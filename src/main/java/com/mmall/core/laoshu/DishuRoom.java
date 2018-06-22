package com.mmall.core.laoshu;

import com.mmall.Object.GameWorld;
import com.mmall.core.BaseRoom;
import com.mmall.core.BaseUser;
import com.mmall.netty.message.MessageSend;
import com.mmall.util.MyUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.mmall.util.MyUtils.getExceptionAllinformation;


@Slf4j
public class DishuRoom extends BaseRoom{


    /**
     * 打地鼠房间玩家
     */
    public List<DishuPlayer> players = new ArrayList<>();

    /**
     * 房间类型 0-单人挑战  1-在线pk
     */
    private int roomType=0;

    /**
     * 自动准备时间
     */
    public static final long waitchoosegameTime=10000;


    protected int AIThinkTime = 1000;// AI思考时间
    // int HumanThinkTime = 500;// 人类思考时间
    protected int WaitTime = 60;// 等待时间（秒）

    //歌曲时间(秒)
    private int time = 60;


    //准备人数
    public int outReadyCount;



    //游戏房间初始化
    public DishuRoom(List<BaseUser> users) {
        for (int i = 0; i < users.size(); i++) {
            DishuPlayer player = new DishuPlayer();
            player.setCount(0);
            player.setRead(false);
            player.setScore(0);
            player.setUser(users.get(i));
            players.add(player);
        }
    }

    public void run() {
        try {
            StartGame();
        } catch (Exception e) {
            log.info("服务器异常: " + e.getMessage() + "\n" + getExceptionAllinformation(e));
            removeRoom("服务器异常,请联系管理员!");
            log.info("房间已解散: " + roomID);
        }
        log.info("房间线程终止: " + roomID);
    }


    public void StartGame() throws Exception {
        log.info("<==Step1ZB==>  准备步骤");
        //发送游戏开始准备
        Map<String,Object> ddsReady = new HashMap<>();
        try {
            outReadyCount = 0;
            //等待所有人准备
            while (outReadyCount < players.size()) {
                Thread.sleep(dedelayTime);// 缓冲
            }
            ddsReady.put("success",1);
            ddsReady.put("msg","准备成功");
            sendToAllMap(ddsReady,"ddsReady");
            YXStage();
        }catch (Exception e){
            e.printStackTrace();
            ddsReady.put("success",0);
            ddsReady.put("msg","准备失败");
            sendToAllMap(ddsReady,"ddsReady");
        }

    }

    public void YXStage() throws Exception {
        log.info("<==YXStage==>  游戏步骤");
        //歌曲播放等待时间
        Thread.sleep(time);
        //发送游戏结束步骤
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) != null &&players.get(i).getUser()!=null) {
                Map<String,Object> ddsReady = new HashMap<>();
                ddsReady.put("score",players.get(i).getScore());
                sendToAllMap(ddsReady,"ddsOver");
            }
        }
    }

    //消息发送
    public void sendToAllMap(Object msg, String head) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) != null &&players.get(i).getUser()!=null) {
                MessageSend.send(players.get(i).getUser().getCtx(),head,msg,false);
            }
        }

    }

    /**
     * 加入房间
     */
    public static void joinRoom(BaseUser user, String operaId){
        log.info("加入房间======="+operaId+"用户id"+user.getUserID());
            //找这曲谱有没有房间
        if(GameWorld.rooms.size()>0) {
            log.info("总房间数"+GameWorld.rooms.size());
            for (Map.Entry<String, ConcurrentHashMap<String, DishuRoom>> rooms : GameWorld.rooms.entrySet()) {
                log.info("存在的房间曲谱id========"+rooms.getKey());
                if (rooms.getKey().equals(operaId)) { //有对应的曲谱房间
                    log.info("该曲谱目前对应的房间总数" + rooms.getValue().size());
                    ConcurrentHashMap<String, DishuRoom> hashMap = rooms.getValue();
                    for (Map.Entry<String, DishuRoom> stringListEntry : hashMap.entrySet()) {//看房间有没有没满的
                        log.info("房间号"+stringListEntry.getKey());
                        //房间只有0人 ,移除
                        if (stringListEntry.getValue().players.size() < 0) {
                            hashMap.remove(stringListEntry.getKey());
                            return;
                        }
                        List<DishuPlayer> players = stringListEntry.getValue().players;
                        log.info("players=====" + players.size());
                        if (players.size() < GameWorld.Max_MATCH_PLAYER_COUNT) { //房间人数不足，直接加进去
                            log.info("加入房间");
                            DishuPlayer laoshuPlayer = new DishuPlayer();
                            laoshuPlayer.setUser(user);
                            players.add(laoshuPlayer);
                            log.info("加入后人数"+players.size());
                            if(players.size()==2){ //凑齐2人推送匹配成功
                                log.info("匹配成功,推送对手信息");
                                for (int i = 0; i < players.size(); i++) {
                                    if(players.get(i).getUser().getUserID()!=user.getUserID()){
                                        log.info("开始推送");
                                        BaseUser baseUser = players.get(i).getUser();
                                        Map<String, Object> map = new HashMap<String, Object>();
                                        map.put("enemyName", baseUser.getUserName());
                                        map.put("enemyIcon",baseUser.getHeadUrl());
                                        map.put("enemyLv", baseUser.getRank());
                                        log.info("推送信息=="+map);
                                        MessageSend.send(baseUser.getCtx(),"ddsMatch",map,false);
                                    }
                                }
                            }
                            break;
                        }else{
                            log.info("房间已满，创建新房间");
                            addRoom(user,operaId);
                            break;
                        }
                    }
                } else {//没有则创建新的
                    addRoom(user,operaId);
                }
            }
        }else{
            addRoom(user,operaId);
        }
    }
    /**
     * 创建房间
     * @param user
     * @param operaId
     */
    public static void addRoom(BaseUser user,String operaId){
        //没有则创建新的
        log.info("新建=====");
        ConcurrentHashMap<String, DishuRoom> map = new ConcurrentHashMap<>();
        //用户
        List<BaseUser> users = new ArrayList<>();
        users.add(user);
        //房间号
        String roomId = MyUtils.getUUID();
        log.info("roomId==" + roomId);
        //房间
        DishuRoom laohuRoom = new DishuRoom(users);
        laohuRoom.setRoomID(roomId);
        map.put(roomId, laohuRoom);
        GameWorld.rooms.put(operaId, map);
        log.info("房间数" + GameWorld.rooms.size());
    }


    /**
     * 取消匹配
     */
    public static void cancelMatch(Integer userId){
        
    }

}
