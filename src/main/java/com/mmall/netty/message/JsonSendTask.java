package com.mmall.netty.message;

import com.mmall.netty.socket.Message;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import com.alibaba.fastjson.JSON;

@Slf4j
public class JsonSendTask implements Runnable , Callable {
	private FutureTask<Integer> future;
	private  ChannelHandlerContext ctx;
	private  Object args;
	private  String method;
	private  boolean isBack;
	private  byte[] data;

	public JsonSendTask(final ChannelHandlerContext ctx, final String method, final Object args, final boolean isBack) {
		this.ctx = ctx;
		this.method = method;
		this.args = args;
		this.isBack=isBack;
		this.data=new byte[0];
	}

	
	public JsonSendTask(final ChannelHandlerContext ctx, final String method, final Object args, final boolean isBack, byte[] data) {
		this.ctx = ctx;
		this.method = method;
		this.args = args;
		this.isBack=isBack;
		this.data=data;
	}

	public JsonSendTask(final ChannelHandlerContext ctx, final String method, final Object args, final boolean isBack,FutureTask<Integer> future) {
		this.ctx = ctx;
		this.method = method;
		this.args = args;
		this.isBack=isBack;
		this.data=new byte[0];
		this.future=future;
	}


	@Override
	public void run() {
		try {
			//回掉信息等待
			if(this.future!=null)
				future.get();
			Message msg=new Message();
			msg.setTimestamp(new Date().getTime());
			msg.setType((short) 0);
			msg.setData(data);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			if (isBack) {
				map.put("m", this.method);
			}else {
				map.put("m", "<"+this.method+">");
			}
			map.put("a", this.args);
			String data =JSON.toJSONString(map,false);
			msg.setContent(data.getBytes(Charset.forName("utf-8")));
			log.info(msg.toString());
			if(this.ctx!=null){
				ctx.channel().writeAndFlush(msg);
			}
		} catch (Exception e) {
			log.error(this.method, e.getMessage());
		}
	}

	@Override
	public Object call() throws Exception {
		return null;
	}
}
