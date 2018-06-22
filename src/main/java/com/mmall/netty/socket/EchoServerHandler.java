package com.mmall.netty.socket;

import com.mmall.Object.GameWorld;
import com.mmall.core.BaseUser;
import com.mmall.netty.message.MessageSend;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Sharable
public class EchoServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 连接事件，服务器的协议(自定义协议管理器)连接到对应的通道中然后触发channelActive事件
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端与服务端连接开启：" + ctx.channel().remoteAddress().toString());
       // log.info("netty id：" + ctx.channel().id().asLongText());
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("客户端与服务端连接关闭：" + ctx.channel().remoteAddress().toString());
        try{
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            BaseUser user = (BaseUser) GameWorld.userList.get(userId);
            user.offline();
        }catch (Exception e){

        }
        // 关闭，等待重连
        ctx.channel().close();
    }

    /**
     * 读取客户端发送过来的数据
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
         //log.info("channelRead");
         MessageSend.sendMessage(ctx,msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //log.info("channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.info("客户端与服务端出现异常连接关闭：" +cause.getMessage());
        cause.printStackTrace();
       // ctx.channel().close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.info("客户端与服务端空闲状态" +ctx.channel().remoteAddress().toString());
        if(evt instanceof IdleStateEvent){
            try{
                Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
                BaseUser user = (BaseUser) GameWorld.userList.get(userId);
                user.offline();
            }catch (Exception e){

            }
            MessageSend.TimeIdleStateEvent(ctx,evt);
        }else{
            super.userEventTriggered(ctx, evt);
        }
    }







}
