package com.mmall.netty.websocket;

import com.mmall.netty.socket.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class WebSocketEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message msg, ByteBuf out) throws Exception {
        TextWebSocketFrame tws = new TextWebSocketFrame(new String(msg.getContent(),"utf-8"));
        ctx.writeAndFlush(tws);
    }
}
