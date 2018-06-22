package com.mmall.netty.websocket;

import com.mmall.netty.message.MessageSend;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoWebSocketServerHandler extends SimpleChannelInboundHandler<Object>  {


    private WebSocketServerHandshaker handshaker;


    /**
     * channel 通道 action 活跃的 当客户端主动链接服务端的链接后，这个通道就是活跃的了。也就是客户端与服务端建立了通信通道并且可以传输数据
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端与服务端连接开启：" + ctx.channel().remoteAddress().toString());
    }


    /**
     * channel 通道 Inactive 不活跃的 当客户端主动断开服务端的链接后，这个通道就是不活跃的。也就是说客户端与服务端关闭了通信通道并且不可以传输数据
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端与服务端连接关闭：" + ctx.channel().remoteAddress().toString());
        ctx.channel().close();
    }


    /**
     * exception 异常 Caught 抓住 抓住异常，当发生异常的时候，可以做一些相应的处理，比如打印日志、关闭链接
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("客户端与服务端异常连接关闭：" +cause.getMessage());
        cause.printStackTrace();
        ctx.channel().close();
    }

    /**
     * 接收客户端发送的消息 channel 通道 Read 读 简而言之就是从通道中读取数据，也就是服务端接收客户端发来的数据。但是这个数据在不进行解码时它是ByteBuf类型的
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        // 传统的HTTP接入 握手操作
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(ctx, ((FullHttpRequest) msg));
            // WebSocket接入
        } else if (msg instanceof WebSocketFrame) {
            //log.info(handshaker.uri());
            handlerWebSocketFrame(ctx, (WebSocketFrame) msg);
        }
    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("客户端与服务端空闲状态" +ctx.channel().remoteAddress().toString());
        if(evt instanceof IdleStateEvent){
            MessageSend.TimeIdleStateEvent(ctx,evt);
        }else{
            super.userEventTriggered(ctx, evt);
        }
    }


    /**
     * channel 通道 Read 读取 Complete 完成 在通道读取完成后会在这个方法里通知，对应可以做刷新操作 ctx.flush()
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }


    private void handlerWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
         // 判断是否关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            System.out.println(1);
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        // 判断是否ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 本例程仅支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            log.info("本例程仅支持文本消息，不支持二进制消息");
            throw new UnsupportedOperationException(
                    String.format("%s frame types not supported", frame.getClass().getName()));
        }

        //
        // 返回应答消息
        String request = ((TextWebSocketFrame) frame).text();
        //log.info("服务端收到：" + request);

        MessageSend.sendMessage(ctx,request);
        //sendMessage(ctx,request);
    }




    //websocket 握手操作 第一次请求是http请求，请求头包括ws的信息
    public void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest req){
        if(!req.decoderResult().isSuccess()){
            sendHttpResponse(ctx,req, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }

        WebSocketServerHandshakerFactory wsFactory ;

        if(WebSocketServer.iswss){
            wsFactory = new WebSocketServerHandshakerFactory("wss:/"+ctx.channel()+ "/websocket",null,false);
        }else{
            wsFactory = new WebSocketServerHandshakerFactory("ws:/"+ctx.channel()+ "/websocket",null,false);
        }


        handshaker = wsFactory.newHandshaker(req);
        if(handshaker == null){
            //不支持
            //WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        }else{
            handshaker.handshake(ctx.channel(), req);
        }
    }

    public static void sendHttpResponse(ChannelHandlerContext ctx,FullHttpRequest req,DefaultFullHttpResponse res){
        // 返回应答给客户端
       // res.getStatus()
        if (res.status().code() != 200)
        {
            //log.info("握手");
            ByteBuf buf = Unpooled.copiedBuffer(res.status().toString(), CharsetUtil.UTF_8);
            res.content().writeBytes(buf);
            buf.release();
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(res);
        if (!isKeepAlive(req) || res.status().code() != 200)
        {
            //log.info("握手2");
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    private static boolean isKeepAlive(FullHttpRequest req)
    {
        return false;
    }

}
