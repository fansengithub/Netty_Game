package com.mmall.Object;


import com.mmall.core.BaseUser;

public interface PlayerInterface {
	public String getGameType();
	public String getRoomID();
	public int getDeskID();
	public boolean isSited();
	public void playerReConnect(UserInterface user);

    void offline(BaseUser baseUser);
}
