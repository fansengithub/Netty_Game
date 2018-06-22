package com.mmall.Object;

import com.mmall.core.laoshu.DishuRoom;
import com.mmall.netty.message.MessageSend;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.AttributeKey;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Slf4j
public class GameWorld {

	/**
	 * 加密密钥
	 */
	public static Map<Long, String> encrypt_key_map = new HashMap<Long, String>();

	/**
	 * 用户id
	 */
	public final static AttributeKey<Integer> userId_key  = AttributeKey.valueOf("userId_key");

	/**
	 * 房间号id
	 */
	public final static AttributeKey<String> roomId_key  = AttributeKey.valueOf("roomId_key");

	/**
	 * 在线用户
	 */
	public static ConcurrentHashMap<String, ChannelHandlerContext> sessionList = new ConcurrentHashMap<String, ChannelHandlerContext>();
	/**
	 * 登录用户
	 */
	public static ConcurrentHashMap<String,UserInterface> userList = new ConcurrentHashMap<String,UserInterface>();

	/**
	 * 打地鼠
	 */
	public static ConcurrentHashMap<String,List<String>> RoomList = new ConcurrentHashMap<String,List<String>>();

	/**
	 * 曲谱模式 pk房间 key为曲谱id ，value为房间
	 */
	public static  ConcurrentHashMap<String,ConcurrentHashMap<String,DishuRoom>> rooms=new ConcurrentHashMap<String,ConcurrentHashMap<String,DishuRoom>>();

	/**
	 * 每个房间玩家最大数量
	 */
	public static  int Max_MATCH_PLAYER_COUNT = 2;


	public static void main(String[] args) {
//		if(userList.containsKey("12312")){
//			ChannelHandlerContext ctx = userList.get("sad").getCtx();
//			Map<String,String> re = new HashMap<>();
//			re.put("message","asdasdasda");
//			MessageSend.send(ctx,"<xiaoxi>",re,false);
//		}


		GameWorld.scheduledExecutorService.execute(()->{
			for (Map.Entry<String, ChannelHandlerContext> ss:
					GameWorld.sessionList.entrySet()) {
				Map<String,String> re = new HashMap<>();
				re.put("message","huanyin a");
				MessageSend.send(ss.getValue(),"xiaoxi",re,false);

			}
		});

	}
	/**
	 * 所有房间
	 */
	public static AllRoom allRoom = new AllRoom();
	
	
	/**
	 * 不需要登陆就可以调用的方法
	 */
	private static HashSet<String> URLNameWithoutLogin = new HashSet<>();
	static {
		URLNameWithoutLogin.add("loginService/login");
	}
	
	public static boolean containsURL(final String URL) {
		return URLNameWithoutLogin.contains(URL);
	}
	
	/**
	 * 线程池
	 */
	public static ScheduledExecutorService scheduledExecutorService = Executors
			.newScheduledThreadPool(Runtime.getRuntime().availableProcessors() * 2);
}
