package com.mmall.Object;

public interface RoomInterface {
	public boolean removeRoom(String reason);
	public String getRoomID() ;
	public String getGameType() ;
	public String getGameName() ;
	public boolean entryRoom() ;
	public boolean quitRoom() ;
	public boolean creatRoom() ;
}
 