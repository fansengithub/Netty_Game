package com.mmall.netty.message;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mmall.Object.GameWorld;
import com.mmall.netty.socket.Message;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.*;

@Slf4j
@Component
public class MessageSend {


    /** 心跳包内容 */
    private static final String ServerRecv = "@";
    private static final String ServerPost = "#";

    /**
     * 消息发送处理
     * @param ctx
     * @param msg
     */
    public static void sendMessage(ChannelHandlerContext ctx, Object msg) throws Exception {
        //socket 请求
        String receiveMessage = "";
        byte[] receiveData = null;
        if(msg instanceof Message){
            //log.info("socket 消息处理");
            Message message = (Message)msg;
            if (message.getType()==99) {
                //消息如果是心跳，则心跳处理
                String temp = new String(message.getContent(),"UTF-8");
                if (temp.equals(ServerRecv))
                {
                    handleHeartbreat(ctx);
                }
                return ;
            }else if(message.getType() == 0) {
                //数据处理
                receiveMessage = new String(message.getContent(),"UTF-8");
                receiveData=((Message) message).getData();
                standardMessage(ctx,receiveMessage,receiveData);
            }else{
                return;
            }
        }else if(msg instanceof String){
            //log.info("websocket 消息处理");
            String message = (String)msg;
            if(message.equals(ServerRecv))
            {
                handleHeartbreat(ctx);
            }else{
                //数据处理
                standardMessage(ctx,message,receiveData);
            }
        }

    }




    /**
     * 处理心跳包
     *
     * @param ctx
     */
    private static void handleHeartbreat(ChannelHandlerContext ctx) throws  Exception{
        /** 返回心跳预设语句 */
        Message obj=new Message();
        obj.setContent(ServerPost.getBytes(Charset.forName("utf-8")));
        obj.setTimestamp(new Date().getTime());
        obj.setType((short)99);
        obj.setData(new byte[0]);
        ctx.channel().writeAndFlush(obj);
    }

    /**
     * 心跳超时处理
     * @param ctx
     * @param evt
     */
    public static void TimeIdleStateEvent(ChannelHandlerContext ctx, Object evt) throws Exception {
        IdleStateEvent event = (IdleStateEvent) evt;
        String type = "";
        if (event.state() == IdleState.READER_IDLE) {
            type = "读操作超时";
        } else if (event.state() == IdleState.WRITER_IDLE) {
            type = "写操作超市";
        } else if (event.state() == IdleState.ALL_IDLE) {
            type = "全部操作超时";
        }
        ctx.channel().close().sync();
        log.info( ctx.channel().remoteAddress()+"超时类型：" + type);
    }


    private static void standardMessage(ChannelHandlerContext ctx,String receiveMessage, byte[] receiveData) throws Exception{
        // 解析调用
        String URL = "";
        Object[] args = null;
        String beanId = "";
        String method = "";
        Date time=new Date();
        try {
            while(receiveMessage.toCharArray()[0]!='{') {
                receiveMessage=receiveMessage.substring(1);
                //log.info(receiveMessage);
            }
            log.error("receiveMessage:"+receiveMessage);
            JSONObject jo = JSON.parseObject(receiveMessage);
            URL = jo.getString("m");
            String[] urls = URL.split("/");
            if (urls.length == 2) {
                beanId = urls[0];
                method = urls[1];
            }
            if (jo.getJSONArray("a") != null) {
                args = jo.getJSONArray("a").toArray();
            } else {
                args = new Object[] {};
            }
        } catch (Exception e) {
            //log.info("请求参数无效!:" + receiveMessage);
            send(ctx, "无", "请求参数无效!:" + receiveMessage, false);
            return;
        }

        // 验证是否登录
/*        if (!GameWorld.sessionList.containsKey(ctx.channel().id().asLongText()) && !GameWorld.containsURL(URL)) {
            log.info("未登录操作:" + URL+" mgs:"+receiveMessage);
            return;
        }*/

        log.info("收到数据,    ID:"+ctx.channel().id()+" service:[ " + beanId + " ]    method:[ " + method + " ]   args:[ "	+ Arrays.toString(args) + " ]");
        // 在最后增加IoSession参数
        if (receiveData!=null&&receiveData.length>0) {//若无数据则不显示数据参数
            Object[] argsTemp = new Object[args.length + 2];
            argsTemp[0] = ctx;
            argsTemp[1] = receiveData;
            for (int i = 0; i < args.length; i++) {
                argsTemp[i + 2] = args[i];
            }
            args = argsTemp;
        }else {
            Object[] argsTemp= new Object[args.length + 1];
            argsTemp[0] = ctx;
            for (int i = 0; i < args.length; i++) {
                argsTemp[i + 1] = args[i];
            }
            args = argsTemp;
        }

        //Object service = ApplicationContextHelper.getBean(beanId);
        //log.info("beanId"+beanId);
        Object service = ContextLoader.getCurrentWebApplicationContext().getBean(beanId);
        Method m = service.getClass().getDeclaredMethod(method, getAndSetClasses(args));
        Object result = m.invoke(service, args);
        Date timelast=new Date();
        //log.info("\n\n\n\n花费时间："+(timelast.getTime()-time.getTime())+"\n\n\n\n");
        if (result != null) {
            if (result instanceof Map<?, ?>||result instanceof String) {
                if(result instanceof String) {
                    send(ctx, URL, JSONObject.parse((String) result), true);
                }else {
                    send(ctx, URL, result, true);
                }
            }else if (result instanceof Result){
                send(ctx, URL, ((Result) result).getMap(), true,((Result) result).getData());
            }
        }
    }


    private static Class<?>[] getAndSetClasses(final Object[] args) {
        try {
            Class<?>[] classArray = new Class<?>[args.length];

            for (int i = 0; i < args.length; i++) {
                classArray[i] = args[i].getClass();

                if (args[i] instanceof Integer) {
                    classArray[i] = Integer.TYPE;
                    args[i] = (int) args[i];
                    continue;
                } else if (args[i] instanceof Boolean) {
                    classArray[i] = Boolean.TYPE;
                    args[i] = (boolean) args[i];
                    continue;
                } else if (args[i] instanceof Map) {
                    classArray[i] = Map.class;
                    continue;
                } else if (args[i] instanceof Long) {
                    classArray[i] = Long.TYPE;
                    args[i] = (long) args[i];
                    continue;
                } else if (args[i] instanceof Double) {
                    classArray[i] = Double.TYPE;
                    args[i] = (double) args[i];
                    continue;
                } else if (args[i] instanceof ChannelHandlerContext) {
                    classArray[i] = ChannelHandlerContext.class;
                    continue;
                } else if (args[i] instanceof Float) {
                    classArray[i] = Float.TYPE;
                    args[i] = (float) args[i];
                } else if (args[i] instanceof int[]) {
                    classArray[i] = int[].class;
                    args[i] = args[i];
                }else if (args[i] instanceof String[]) {
                    classArray[i] = String[].class;
                    args[i] = args[i];
                }
            }
            return classArray;
        } catch (Exception e) {
            log.error("getAndSetClasses异常", e);
        }
        return null;
    }



    // 正常发送消息
    public static void send(final ChannelHandlerContext ctx, final String method, final Object args, boolean isBack) {
        GameWorld.scheduledExecutorService.execute(new JsonSendTask(ctx, method, args, isBack));
    }

    // 延迟发送消息
    public static void sendWithDelay(final ChannelHandlerContext ctx, final String method, final Object args, boolean isBack,long delay,TimeUnit time) {
        if(GameWorld.sessionList.containsKey(ctx.channel().id().asLongText())){
            Runnable runnable=new JsonSendTask(ctx, method, args, isBack);
            GameWorld.scheduledExecutorService.schedule(runnable,delay,time);

        }
    }

    // 发送含有回掉信息的消息
    public static FutureTask<Integer> sendWithReturn(final ChannelHandlerContext ctx, final String method, final Object args, boolean isBack) {
        if(GameWorld.sessionList.containsKey(ctx.channel().id().asLongText())) {
            Callable callable = new JsonSendTask(ctx, method, args, isBack);
            FutureTask<Integer> future = new FutureTask<>(callable);
            new Thread(future).start();
            return future;
        }
        else return null;
    }

    // 发送回掉信息条件满足的消息
    public static void sendAfterFuture(final ChannelHandlerContext ctx, final String method, final Object args, boolean isBack,FutureTask<Integer> future) {
        if(GameWorld.sessionList.containsKey(ctx.channel().id().asLongText()))
            GameWorld.scheduledExecutorService.execute(new JsonSendTask(ctx, method, args, isBack,future));

    }

    // 发送带有二进制文件消息
    public static void send(final ChannelHandlerContext ctx, final String method, final Object args, boolean isBack,byte[] data) {
        GameWorld.scheduledExecutorService.execute(new JsonSendTask(ctx, method, args, isBack,data));
    }


}
