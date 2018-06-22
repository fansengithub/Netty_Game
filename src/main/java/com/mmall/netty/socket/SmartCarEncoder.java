package com.mmall.netty.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.slf4j.Slf4j;


/**
 * 自定义编码器
 */
@Slf4j
public class SmartCarEncoder extends MessageToByteEncoder<Message> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Message message, ByteBuf byteBuf) throws Exception {
        //log.info("encode ----------------------- start");
        // 将对象转化为字节数组
        byteBuf.writeInt(message.getLenth());
        byteBuf.writeShort(message.getType());
        byteBuf.writeLong(message.getTimestamp());
        byteBuf.writeInt(message.getDataLenth());
        byteBuf.writeBytes(message.getContent());
        byteBuf.writeBytes(message.getData());
        ctx.flush();
    }
}
