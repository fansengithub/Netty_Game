package com.mmall.core;


import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.mmall.Object.PlayerInterface;
import com.mmall.Object.UserInterface;
import io.netty.channel.ChannelHandlerContext;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BaseUser implements UserInterface {
	Log log = LogFactory.getLog(getClass());
	private String headUrl;
	private String userName;
	private String openId;
	private String phone;
	private String userID;
	private String rank; //等级
	private boolean gender;

    private int roleType;//角色
    private int score;//积分
    private int xiongzhang;//熊掌
    private int sex;
	private BigDecimal money;

	private ChannelHandlerContext ctx;
	private Map<String, PlayerInterface> players;

	private String RoomId;


	public String getRoomId() {
		return RoomId;
	}

	public void setRoomId(String roomId) {
		RoomId = roomId;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public BaseUser(){
		players=new HashMap<>();
	}

	public Log getLog() {
		return log;
	}

	public void setLog(Log log) {
		this.log = log;
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

	public ChannelHandlerContext getCtx() {
		return ctx;
	}

	public void setCtx(ChannelHandlerContext ctx) {
		this.ctx = ctx;
	}

	public Map<String, PlayerInterface> getPlayer() {
		return players;
	}

	public void setPlayer(Map<String, PlayerInterface> player) {
		this.players = player;
	}
	
	//掉线操作
	@Override
	public void offline() {
	}


	//回到游戏操作
	@Override
	public void reConnect() {
		log.info("回到游戏操作");
		for (Map.Entry<String, PlayerInterface> entry : players.entrySet()) {
			log.info("entry.getkey:"+entry.getKey());
			log.info("entry.getValue:"+entry.getValue());
			try {
			entry.getValue().playerReConnect(this);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}  
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}


	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getRoleType() {
		return roleType;
	}

	public void setRoleType(int roleType) {
		this.roleType = roleType;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getXiongzhang() {
		return xiongzhang;
	}

	public void setXiongzhang(int xiongzhang) {
		this.xiongzhang = xiongzhang;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}
}
