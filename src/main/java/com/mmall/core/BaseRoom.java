package com.mmall.core;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.mmall.Object.GameWorld;
import com.mmall.Object.RoomInterface;
import com.mmall.util.MyUtils;

public class BaseRoom extends Thread implements RoomInterface {
	
	Log log = LogFactory.getLog(getClass());
	
	protected String roomID;
	protected String roomNum;
	protected String gameType;
	public boolean isRunning = false;
	protected int dedelayTime=50;
	public void run() {
		try {
			StartGame();
		} catch (Exception e) {
			log.error("服务器异常: " + e.getMessage() + "\n" + MyUtils.getExceptionAllinformation(e));
			removeRoom("服务器异常,请联系管理员!");
		}
		log.info("房间线程终止: " + roomID);
	}
	
	public void StartGame() throws Exception {
		while (isRunning) {
			log.info("StartGame!");
			// TODO
		}
	}
	
	
	@Override
	public boolean removeRoom(String reason) {
		// TODO 日志操作
		GameWorld.allRoom.removeRoom(this);
		return true;
	}
	@Override
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomId) {
		this.roomID=roomId;
	}
	@Override
	public String getGameType() {
		return gameType;
	}
	@Override
	public String getGameName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean entryRoom() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean quitRoom() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean creatRoom() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}
}
