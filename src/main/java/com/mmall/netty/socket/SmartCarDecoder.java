package com.mmall.netty.socket;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;


/**
 * 自定义解码器
 */
@Slf4j
public class SmartCarDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        //log.info("decode ----------------------- start");
       // Date time=new Date();
        if (in.readableBytes() < Message.headLenth()) {  //当前字节码小于Message长度return掉
            return;
        }

        in.markReaderIndex();            //我们标记一下当前的readIndex的位置
        int length = in.readInt();       // 读取传送过来的消息的长度。ByteBuf 的readInt()方法会让他的readIndex增加4
        if (length < 0) { // 我们读到的消息体长度为0，这是不应该出现的情况，这里出现这情况，关闭连接。
            ctx.close();
        }
        if (in.readableBytes() < length - 4) { //读到的消息体长度如果小于我们传送过来的消息长度，则resetReaderIndex. 这个配合markReaderIndex使用的。把readIndex重置到mark的地方
            in.resetReaderIndex();
            return;
        }
        //读取nettybean的信息
        Message nettyBean = new Message();
        nettyBean.setType(in.readShort());
        nettyBean.setTimestamp(in.readLong());
        int dataLength = in.readInt();
        //  嗯，这时候，我们读到的长度，满足我们的要求了，把传送过来的数据，取出来吧~~
        byte[] arr = new byte[length - Message.headLenth() - dataLength];
        if(in.readableBytes() < arr.length){
            //读到的消息体长度如果小于消息长度 ，把readIndex重置到mark的地方，继续读取
            in.resetReaderIndex();
            return;
        }
        in.readBytes(arr,0,arr.length);
        nettyBean.setContent(arr);
        byte[] data = new byte[dataLength];
        if (in.readableBytes() < dataLength) {
            //读到的消息体长度如果小于消息长度 ，把readIndex重置到mark的地方，继续读取
            in.resetReaderIndex();
            return ;
        }
        in.readBytes(arr,0,data.length);
        nettyBean.setData(data);
        //Date timelast=new Date();
        //log.info("\n\n\n\n花费时间："+(timelast.getTime()-time.getTime())+"\n\n\n\n");
        out.add(nettyBean);
    }
}
