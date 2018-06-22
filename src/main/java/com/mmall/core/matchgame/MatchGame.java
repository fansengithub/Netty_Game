package com.mmall.core.matchgame;

import com.mmall.Object.GameWorld;
import com.mmall.core.BaseUser;
import com.mmall.netty.message.MessageSend;
import com.mmall.util.MyUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * 游戏房间匹配
 */

@Slf4j
public class MatchGame {

    /**
     * 匹配池
     */
    public static ConcurrentHashMap<Integer, MatchPoolPlayerInfo> playerPool = new ConcurrentHashMap<Integer, MatchPoolPlayerInfo>();
    /**
     * 临时房间池
     */
    public static ConcurrentHashMap<Long, List<MatchPoolPlayerInfo>> roomPool = new ConcurrentHashMap<Long, List<MatchPoolPlayerInfo>>();


    public static  ConcurrentHashMap<Integer,ConcurrentHashMap<String,List<String>>> room=new ConcurrentHashMap<Integer,ConcurrentHashMap<String,List<String>>>();
    /**
     * 每个人需要匹配到的玩家最小数量
     */
    private static int NEED_MATCH_PLAYER_COUNT = 1;

    /**
     * 每个人需要匹配到的玩家最大数量
     */
    private static  int Max_MATCH_PLAYER_COUNT = 2;



    /**
     * 把玩家放入匹配池
     *
     * @param playerId userId
     * @param user     BaseUser
     * @return
     */
    public static void putPlayerIntoMatchPool(int playerId, BaseUser user,String operaId,String gamePattern) {
        if (!playerPool.containsKey(playerId)) {
            MatchPoolPlayerInfo playerInfo = new MatchPoolPlayerInfo(playerId, user);
            // 匹配池储存的是 id 和 info
            playerPool.put(playerId, playerInfo);
            // 向前端发送消息：“匹配开始”
            log.info("开始匹配!");

//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("msg", "开始匹配");
//
//
//            MessageSend.send(user.getCtx(), "ddsStartMatch", map, false);
        }
    }



    /**
     * 退出匹配队列
     *
     * @param userId
     */
    public static void cancelMatch(Integer userId) {
        if (MatchGame.playerPool.containsKey(userId)) { //匹配池存在该用户，直接移除
            //log.info("cancelMatch---------------1");
            MatchGame.playerPool.remove(userId);
        } else {
            //log.info("cancelMatch-------------2");
            for (Map.Entry<Long, List<MatchPoolPlayerInfo>> room : MatchGame.roomPool.entrySet()) {
                //掉线玩家退出匹配处理
                for (int i = 0; i < room.getValue().size(); i++) {
                    if (room.getValue().get(i).getPlayerId() == userId) {
                        log.info(room.getValue().get(i).getPlayerId() + "掉线，直接移除");
                        room.getValue().remove(i);
                    }
                }
                //房间只有1人 ，丢回匹配
                if (room.getValue().size() == 1) {
                    MatchGame.putPlayerIntoMatchPool(room.getValue().get(0).getPlayerId(), room.getValue().get(0).getUser(),"107","1");
                }
                //房间只有0人 ，结束
                if (room.getValue().size() == 0) {
                    MatchGame.roomPool.remove(room.getKey());
                    //return;
                }
            }
        }
    }


    /**
     * 多线程
     */
    public static void run() {
        log.info("匹配线程执行");
        GameWorld.scheduledExecutorService.scheduleWithFixedDelay(() -> {
            //匹配操作
            matchProcess(playerPool);
            //房间分配
            matchRoom(roomPool);
        }, 1, 1, TimeUnit.SECONDS);//每隔1秒匹配一次
    }


    /**
     * 匹配方法
     *
     * @param sameRankPlayers
     */
    private static void matchProcess(ConcurrentHashMap<Integer, MatchPoolPlayerInfo> sameRankPlayers) {
        long startTime = System.currentTimeMillis();
//        log.info("执行匹配开始|开始时间|" + startTime);
        try {
            for (Map.Entry<Long, List<MatchPoolPlayerInfo>> roomPoolList : roomPool.entrySet()) {
                log.info("临时房间 " + roomPoolList.getKey() + " 里的人数是: " + roomPoolList.getValue().size());
            }
            log.info("当前匹配池人数" + sameRankPlayers.size());
            if (sameRankPlayers.size() <= 0) {
                return;
            }

            while (true) {
                if (sameRankPlayers.size() <= 0) {
//                    log.info("2:匹配池分配完毕");
                    break;
                }
                //找到时间最长的那个人
                MatchPoolPlayerInfo oldest = getoldPlayer(sameRankPlayers);


                //临时游戏房间建设
                List<MatchPoolPlayerInfo> matchPoolPlayer = new ArrayList<MatchPoolPlayerInfo>();
                if (!sameRankPlayers.isEmpty()) {
                    for (Map.Entry<Integer, MatchPoolPlayerInfo> currsameRankPlayers : sameRankPlayers.entrySet()) {
                        MatchPoolPlayerInfo player = currsameRankPlayers.getValue();
                        if (player.getPlayerId() != oldest.getPlayerId()) {//排除玩家本身
                            if (matchPoolPlayer.size() < NEED_MATCH_PLAYER_COUNT) {
                                matchPoolPlayer.add(player);
                                log.info(oldest.getPlayerId() + "|匹配到玩家|" + player.getPlayerId());
                                //移除
                                sameRankPlayers = removePlayerFromMatchPool(player.getPlayerId());
                            } else {
                                break;
                            }
                        }
                    }
                }

                if (matchPoolPlayer.size() == NEED_MATCH_PLAYER_COUNT) {
//                    log.info(oldest.getPlayerId() + "|临时房间匹配到玩家数量够了|提交匹配成功处理");
                    //自己也匹配池移除
                    sameRankPlayers = removePlayerFromMatchPool(oldest.getPlayerId());
                    //匹配成功处理
                    matchPoolPlayer.add(oldest);
                    //放入临时房间
                    roomPool.put(System.currentTimeMillis(), matchPoolPlayer);
                } else {
//                    log.info("3:匹配池分配完毕");
                    break;
                }
            }
        } catch (Throwable t) {
            log.info("match|error", t);
        }
        long endTime = System.currentTimeMillis();
        log.info("执行匹配结束|结束时间|" + endTime + "|耗时|" + (endTime - startTime) + "ms");
    }

    /**
     * 房间分配(正式)
     *
     * @param roomPool
     */
    private static void matchRoom(ConcurrentHashMap<Long, List<MatchPoolPlayerInfo>> roomPool) {
        for (Map.Entry<Long, List<MatchPoolPlayerInfo>> room : roomPool.entrySet()) {

            //房间只有1人 ，丢回匹配
            if(room.getValue().size() == 1){
                putPlayerIntoMatchPool(room.getValue().get(0).getPlayerId(),room.getValue().get(0).getUser(),"107","1");
            }

            //房间只有0人 ，结束
            if (room.getValue().size() == 0) {
                roomPool.remove(room.getKey());
                return;
            }

            //大於當前時間 或者 房間人物已滿  則創建房間
            if (room.getValue().size() >= Max_MATCH_PLAYER_COUNT) {
                // 匹配成功的逻辑
                List<MatchPoolPlayerInfo> value = room.getValue();


                //房间号
                List<String> userLsit = new ArrayList<String>();
                String roomId = MyUtils.getUUID();


                for (int i = 0; i < value.size(); i++) {
                    BaseUser user = value.get(i).getUser();

                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("enemyName", user.getUserName());
                    map.put("enemyIcon",user.getHeadUrl());
                    map.put("enemyLv", user.getRank());

                    user.setRoomId(roomId);
                    userLsit.add(user.getUserID());

                    MessageSend.send(user.getCtx(),"ddsMatch",map,false);
                }

                GameWorld.RoomList.put(roomId,userLsit);


                //清除本临时房间
                removeRoomMatchPool(room.getKey());
            }
        }
    }

    /**
     * 把房间从临时房间池移除
     *
     * @param time
     */
    public static ConcurrentHashMap<Long, List<MatchPoolPlayerInfo>> removeRoomMatchPool(Long time) {
        roomPool.remove(time);
        return roomPool;
    }


    /**
     * 把玩家从匹配池移除
     * @param playerId
     */
    public static ConcurrentHashMap<Integer, MatchPoolPlayerInfo> removePlayerFromMatchPool(int playerId) {
        playerPool.remove(playerId);
        return playerPool;
    }

    /**
     * 时间最久的用户
     *
     * @param sameRankPlayers
     * @return
     */
    private static MatchPoolPlayerInfo getoldPlayer(ConcurrentHashMap<Integer, MatchPoolPlayerInfo> sameRankPlayers) {
        //找出等待时间最长的玩家，用他来匹配，因为他的区间最大
        //如果他都不能匹配到，等待时间比他短的玩家更匹配不到
        MatchPoolPlayerInfo oldest = null;
        for (Map.Entry<Integer, MatchPoolPlayerInfo> playerMatchPoolInfo : sameRankPlayers.entrySet()) {
            if (oldest == null) {
                oldest = playerMatchPoolInfo.getValue();
            } else if (playerMatchPoolInfo.getValue().getStartMatchTime() < oldest.getStartMatchTime()) {
                oldest = playerMatchPoolInfo.getValue();
            }
        }
//        log.info(oldest.getPlayerId() + "|为该分数上等待最久时间的玩家开始匹配");
        long now = System.currentTimeMillis();
        int waitSecond = (int) ((now - oldest.getStartMatchTime()) / 1000);

//        log.info(oldest.getPlayerId() + "|当前时间已经等待的时间|waitSecond|" + waitSecond + "|当前系统时间|" + now + "|开始匹配时间|" + oldest.getStartMatchTime());
        return oldest;
    }


    public static class MatchPoolPlayerInfo {
        private int playerId;//玩家ID

        private long startMatchTime;//开始匹配时间

        private BaseUser user;

        private MatchPoolPlayerInfo(int playerId, BaseUser user) {
            super();
            this.playerId = playerId;
            this.user = user;
            this.startMatchTime = System.currentTimeMillis();
        }

        public int getPlayerId() {
            return playerId;
        }

        public void setPlayerId(int playerId) {
            this.playerId = playerId;
        }

        public long getStartMatchTime() {
            return startMatchTime;
        }

        public void setStartMatchTime(long startMatchTime) {
            this.startMatchTime = startMatchTime;
        }

        public BaseUser getUser() {
            return user;
        }

        public void setUser(BaseUser user) {
            this.user = user;
        }
    }


}
