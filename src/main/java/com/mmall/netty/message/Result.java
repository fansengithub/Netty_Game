package com.mmall.netty.message;

import java.util.HashMap;
import java.util.Map;

public class Result {
	private Map<String, Object> map;
	private byte[] data;
	
	public Result(){
		map=new HashMap<>();
		data=new byte[0];
	}
	
	
	public void put(String key,Object Value){
		map.put(key, Value);
	}
	
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
}
