package com.mmall.Object;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

import java.util.concurrent.ConcurrentHashMap;


public class AllRoom {
	Log log = LogFactory.getLog(getClass());
	public AllRoom(){
		RoomInterfaceListAll=new ConcurrentHashMap<>();
	}
	
	public ConcurrentHashMap<String,ConcurrentHashMap<String,RoomInterface>> RoomInterfaceListAll;
	
	public  ConcurrentHashMap<String,RoomInterface> getGameRoomList(String gameType){
		if (RoomInterfaceListAll.containsKey(gameType)) {
			ConcurrentHashMap<String,RoomInterface> RoomInterfaceList=RoomInterfaceListAll.get(gameType);
			return RoomInterfaceList;
		}else {
			return null;
		}
	}
	
	public  RoomInterface getRoom(String gameType,String roomID){
		if (gameType.length()>0&&RoomInterfaceListAll.containsKey(gameType)) {
			ConcurrentHashMap<String,RoomInterface> RoomInterfaceList=RoomInterfaceListAll.get(gameType);
			if (roomID.length() > 0 &&RoomInterfaceList.containsKey(roomID)) {
				return RoomInterfaceList.get(roomID);
			} else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	public  void addGameRoomList(String gameType,ConcurrentHashMap<String,RoomInterface> RoomInterfaceList){
		RoomInterfaceListAll.put(gameType, RoomInterfaceList);
	}
	
	public  void addRoom(RoomInterface RoomInterface){
		if (RoomInterfaceListAll.containsKey(RoomInterface.getGameType())) {
			RoomInterfaceListAll.get(RoomInterface.getGameType()).put(RoomInterface.getRoomID(), RoomInterface);
		}else {
			log.warn("addRoomInterface失败,没有找到gameType:"+RoomInterface.getGameType());
		}
	}
	
	public  void removeRoom(RoomInterface RoomInterface){
		if (RoomInterfaceListAll.containsKey(RoomInterface.getGameType())) {
			if (RoomInterfaceListAll.get(RoomInterface.getGameType()).containsKey(RoomInterface.getGameType())) {
				RoomInterfaceListAll.get(RoomInterface.getGameType()).remove(RoomInterface.getRoomID());
			} else {
				log.warn("removeRoomInterface失败,没有找到RoomInterfaceID:"+RoomInterface.getRoomID());
			}
		}else {
			log.warn("removeRoomInterface失败,没有找到gameType:"+RoomInterface.getGameType());
		}
	}
	
	
	
	
}
