package com.mmall.core;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.mmall.model.ElecPlayer;
import io.netty.channel.ChannelHandlerContext;

import java.net.Socket;
import java.net.SocketAddress;

public class UserInfo {
	Log log = LogFactory.getLog(getClass());

	private String userName;
	private String userID;
	private int type;
	private int isComplete;
	private String userOpenID;
	private String headUrl;
	private SocketAddress ip;
	private Socket client;
	private ChannelHandlerContext session;
	private int sex;
	private String rank; //等级
	private ElecPlayer player;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIsComplete() {
		return isComplete;
	}

	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}

	public ElecPlayer getPlayer() {
		return player;
	}

	public void setPlayer(ElecPlayer player) {
		this.player = player;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public SocketAddress getIp() {
		return ip;
	}

	public void setIp(SocketAddress socketAddress) {
		this.ip = socketAddress;
	}

	public Socket getClient() {
		return client;
	}

	public void setClient(Socket client) {
		this.client = client;
	}

	public String getUserOpenID() {
		return userOpenID;
	}

	public void setUserOpenID(String userOpenID) {
		this.userOpenID = userOpenID;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public ChannelHandlerContext getSession() {
		return session;
	}

	public void setSession(ChannelHandlerContext session) {
		this.session = session;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
}