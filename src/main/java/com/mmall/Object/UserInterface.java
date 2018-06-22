package com.mmall.Object;

import io.netty.channel.ChannelHandlerContext;

import java.util.Map;

public interface UserInterface {
	public String getUserID();
	public String getUserName();
	public Map<String, PlayerInterface> getPlayer();
	public ChannelHandlerContext getCtx();
	public void offline();
	public void reConnect();
}
