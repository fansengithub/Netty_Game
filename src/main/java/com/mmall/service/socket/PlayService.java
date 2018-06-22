package com.mmall.service.socket;


import com.mmall.Object.GameWorld;
import com.mmall.core.BaseUser;
import com.mmall.core.laoshu.DishuRoom;
import com.mmall.core.matchgame.MatchGame;
import com.mmall.dao.ElecPlayerMapper;
import com.mmall.dao.OperaCalssifyMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.OperaOwnerMapper;
import com.mmall.dto.OperaDiffcultyDto;
import com.mmall.entity.OperaForGame;
import com.mmall.model.ElecPlayer;
import com.mmall.model.OperaCalssify;
import com.mmall.model.OperaDetail;
import com.mmall.model.OperaOwner;
import com.mmall.util.PropertyUtil;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 *   打地鼠游戏接口
 */
@Slf4j
@Service("p")
public class PlayService {
    @Autowired
    private OperaOwnerMapper operaOwnerMapper;
    @Autowired
    private OperaCalssifyMapper operaCalssifyMapper;
    @Autowired
    private OperaDetailMapper operaDetailMapper;
    @Autowired
    private ElecPlayerMapper elecPlayerMapper;

    /**
     * 获取某一难度下的曲谱
     *
     * @return
     */
    public Map<String, Object> getOperaByDifficulty(final ChannelHandlerContext ctx,String difficulty) {

        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("--userId--" + userId);
//            eleplayer表中通过id--->player-Id
            ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(454);
            List<OperaOwner> operaOwnerList = operaOwnerMapper.getAllByUserId(temp1.getPlayerId());
//              获取当前用户的所有曲谱
            List<OperaForGame> operaForGameList = new ArrayList<>();

            for (OperaOwner temp : operaOwnerList) {
                OperaForGame operaForGame = new OperaForGame();
                log.info("Integer.parseInt(difficulty)   ----------"+Integer.parseInt(difficulty));
                OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKeyAndDifficulty(temp.getOperaId(),Integer.parseInt(difficulty));
                if (operaDetail != null) {
                    operaForGame.setAuthor(operaDetail.getAuthor());
                    operaForGame.setOperaId(temp.getOperaId() + "");
                    operaForGame.setTextbookName(operaDetail.getLearnbookName());
                    operaForGame.setExpiryTime(temp.getExpiryTime());
                    operaForGame.setImgUrl(operaDetail.getCoverPicture());
                    operaForGame.setOperaName(operaDetail.getOperaName());
//                    operaForGame.setClassifyName();
                    OperaCalssify operaCalssify = operaCalssifyMapper.selectByPrimaryKey(temp.getClassifyId());
                    if (operaCalssify != null) {
//                        获取分类名称
                        operaForGame.setClassifyName(operaCalssify.getClassifyName());
                    }
                    operaForGameList.add(operaForGame);
                }

            }
            result.put("allOpera", operaForGameList);


//                获取当前用户的所有分类  的id和名称
            List intermList = new ArrayList();
//            将查询出来的operaOwnerList中去除重复classifyId,并放入list中.
            for (OperaOwner temp : operaOwnerList) {
                if (!intermList.contains(temp.getClassifyId())) {
                    intermList.add(temp.getClassifyId());
                }
            }
            log.info("去重复后的  intermList-- " + intermList);
            List<OperaCalssify> operaCalssifyList = new ArrayList<>();
            for (int i = 0; i < intermList.size(); i++) {
                OperaCalssify operaCalssify = operaCalssifyMapper.selectByPrimaryKey((int) intermList.get(i));
                operaCalssifyList.add(operaCalssify);
            }
            result.put("allClassify", operaCalssifyList);

            result.put("success", 1);
            result.put("msg", "操作成功!");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "操作失败!");
        }
        return result;
    }

    /**
     * 获取某一难度下某个分类的曲谱
     * @param ctx getOperaByDiffictAndClassify
     * @param difficulty
     * @param classifyId
     * @return
     */
    public Map<String, Object> getTypeMusic(final ChannelHandlerContext ctx,String difficulty,String classifyId){
        Map<String,Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId" + userId);
            ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(userId);
//            BaseUser user = (BaseUser) GameWorld.userList.get(userId);
            List<OperaForGame> operaForGameList = new ArrayList<>();

            if (userId!=null&&classifyId != null){
//                根据userId和 classifyId 查找曲谱
                List<OperaOwner> operaOwnerList  = operaOwnerMapper.selectByClassifyIdAndUserId(Integer.parseInt(classifyId),userId);
                for(OperaOwner operaOwner : operaOwnerList){
                    OperaForGame operaForGame  = new OperaForGame();
                    OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId());
//                    operaForGame.setClassifyName();
                    operaForGame.setOperaName(operaDetail.getOperaName());
                    operaForGame.setTextbookName(operaDetail.getLearnbookName());
                    operaForGame.setAuthor(operaDetail.getAuthor());
                    operaForGame.setExpiryTime(operaOwner.getExpiryTime());

                    operaForGameList.add(operaForGame);
                }

                result.put("success",1);
                result.put("msg","操作成功!");
                result.put("allOpera",operaForGameList);
            }else {
                result.put("success",0);
                result.put("msg","操作失败!");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("msg","操作失败!");
        }
        return  result;
    }

    /**
     *获取曲谱的详细信息
     * @param ctx
     * @param operaId
     * @return
     */
    public Map<String, Object> getMusicInfo(final ChannelHandlerContext ctx,String operaId){
        Map<String, Object> result = new HashMap<>();
        try {
            OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(Integer.parseInt(operaId));
            result.put("id",operaDetail.getId());
            result.put("name",operaDetail.getOperaName());
            result.put("difficulty",operaDetail.getDifficulty());
            result.put("musicUrl",operaDetail.getMusic());
            result.put("imgUrl",operaDetail.getMusicScore());
            result.put("jsonUrl",operaDetail.getProfile());
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",10);
            result.put("msg","操作失败!");
        }

        return  result;
    }

    /**
     * 打地鼠游戏匹配 直接加入房间
     * @param ctx
     * @param operaId
     * @param gamePattern
     * @return
     */
    public Map<String, Object> gameMatch(final ChannelHandlerContext ctx,String operaId,String gamePattern){
        Map<String,Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId" + userId);
            BaseUser user = (BaseUser) GameWorld.userList.get(userId+"");
//            MatchGame.putPlayerIntoMatchPool(userId,user,operaId,gamePattern);
            DishuRoom.joinRoom(user,operaId);
            result.put("success",1);
            result.put("msg","操作成功!");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("msg","操作失败!");
        }
        return  result;
    }


    /**
     * 取消打地鼠游戏的匹配
     * @param ctx
     * @return
     */
    public Map<String, Object> cancelDdsMatch(final ChannelHandlerContext ctx){
        Map<String,Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId" + userId);
            BaseUser user = (BaseUser) GameWorld.userList.get(userId+"");
            MatchGame.cancelMatch(userId);
            result.put("success",1);
            result.put("msg","操作成功!");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("msg","操作失败!");
        }
        return  result;
    }

    /**
     * 打地鼠游戏准备好了
     * @param ctx
     * @return
     */
    public  Map<String, Object> ddsReady(final ChannelHandlerContext ctx,String uid){
        Map<String,Object>  result = new HashMap<>();
        try {
            log.info("userId" + uid);
            result.put("success",1);
            result.put("msg","操作成功!");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("msg","操作失败");
        }
        return  result;
    }

    /**
     * 获取曲谱的讲解视频
     * @param ctx
     * @param operaId
     * @return
     */
    public  Map<String,Object> getMusicExplainUrl(final ChannelHandlerContext ctx,String operaId){

        Map<String,Object> result = new HashMap<>();
        try {
            OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(Integer.parseInt(operaId));
            if (operaDetail != null){
                if (operaDetail.getExplainVideo() != null){
                        result.put("success",1);
                        result.put("msg","操作成功!");
                        result.put("url",operaDetail.getExplainVideo());
                }else {
                    result.put("success",0);
                    result.put("msg","操作失败,当前曲谱无讲解视屏!");
                }
            }else {
                result.put("success",0);
                result.put("msg","操作失败,无当前曲谱!");
            }

        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("msg","操作失败!");
        }
        return  result;
    }


    /**
     * 请求上传路径
     * @param ctx
     * @param type
     * @return
     */
    public Map<String,Object> RequestUpDataUrl(final ChannelHandlerContext ctx,int type){
        Map<String, Object> mapRes = new HashMap<>();
        String returnUrlHead= PropertyUtil.getProperty("SystemData.returnUrlHead");
        returnUrlHead=returnUrlHead.substring(0, returnUrlHead.length()-3);
        log.info(returnUrlHead);
        if(type == 0){
            mapRes.put("url", returnUrlHead+"/Game/FileController/imgUpload?kinds=");//前台动态拼接，图片上传
        }else if(type == 1){
            mapRes.put("url", returnUrlHead+"/Game/FileController/springUpload?kinds=");//文件上传
        }
        mapRes.put("success", 1);
        return mapRes;
    }

    /**
     *   第三方分享
     */
    public Map<String, Object> shareSdk(final ChannelHandlerContext ctx,String picUrl,int index) {
        Map<String, Object> result = new HashMap<>();
        if(picUrl == null ){
            result.put("success", 0);
            result.put("message", "图片路径/用户名不存在！");
            return result;
        }

        String RetUrl = null;
        if(index ==1){//新浪微博
            RetUrl = "http://service.weibo.com/share/share.php?"
                    + "title=精彩瞬间，值得分享&"
                    + "url="
                    +  picUrl   //图片路径
                    + "&appkey=2992571369"
                    + "&pic="
                    +  picUrl
                    + "&ralateUid=#_loginLayer_1502349458377";
        }
        if(index ==2){//QQ
            RetUrl = "http://connect.qq.com/widget/shareqq/index.html?"
                    + "url="
                    +  picUrl
                    + "&site=jiathis&"
                    + "pics="
                    +  picUrl;		//图片路径
        }

        if(index ==3){//微信
            RetUrl = "http://www.jiathis.com/send/?webid=weixin"
                    + "&url="
                    + picUrl   //图片路径
                    + "&title=精彩瞬间，值得分享，扫一扫，分享朋友圈。";
        }

//        Score score = scoreMapper.selectByPrimaryKey(4);
//        ElecPlayer user=elecPlayerMapper.selectByPrimaryKey((Integer)session.getAttribute("userID"));
//        if(score != null && user != null){
//            Userscore userScore = userscoreMapper.selectByUserIdByinfo((Integer)session.getAttribute("userID"),4);
//            if(userScore==null){//新用户
//                Userscore uS = new Userscore();
//                uS.setInfo(4);
//                uS.setTime(new Date());
//                uS.setNickname(user.getNickname());
//                uS.setNum(Integer.parseInt(score.getScore())+"");
//                uS.setGradenum(Integer.parseInt(score.getScore())+"");
//                uS.setPlayerId((Integer)session.getAttribute("userID")); //分享成功奖励
//
//                log.info("ID:"+user.getId()+","+user.getNickname()+"分享成绩，奖励"+score.getScore()+"分！");
//                userscoreMapper.insertSelective(uS);
//            }else{//老用户
//                userScore.setTime(new Date());
//                userScore.setGradenum((Integer.parseInt(score.getScore())+Integer.parseInt(userScore.getGradenum()))+"");
//                userscoreMapper.updateByPrimaryKeySelective(userScore);
//            }
//        }

        result.put("success", 1);
        result.put("message", "分享成功！");
        result.put("RetUrl", RetUrl);
        return result;
    }


    /**
     * 随机返回一个指定难度的自已已有的乐谱
     * @param ctx
     * @param difficulty
     * @return
     */
    public Map<String,Object> randomMusic(final ChannelHandlerContext ctx,String difficulty){
        Map<String,Object> map=new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            if(userId==null){
                map.put("success",0);
                map.put("msg","获取失败!");
                return map;
            }
            List<OperaDetail> operaDetails=operaDetailMapper.getOperaByUidAndDiffculty(userId,difficulty);
            log.info("数量"+operaDetails.size());
            if(operaDetails.size()>0){
                OperaDetail operaDetail=operaDetails.get((int)(Math.random()*operaDetails.size()));
                map.put("musicID",operaDetail.getId());
                map.put("imgUrl",operaDetail.getCoverPicture());
                map.put("musicName",operaDetail.getOperaName());
                map.put("success",1);
                map.put("msg","获取成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("msg","获取失败!");
        }
        return map;
    }

    /**
     * 19
     * 查找摸个难度下面的曲谱
     * @param ctx
     * @return
     */
    public Map<String,Object> inquireMusic(final ChannelHandlerContext ctx,String difficulty,String param){
        Map<String,Object> map=new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            if(userId==null){
                map.put("success",0);
                map.put("msg","获取失败!");
                return map;
            }
            List<OperaDiffcultyDto> dtos=operaDetailMapper.getOperaByDiffculty(param,difficulty,userId);
            map.put("opera",dtos);
            map.put("success",1);
            map.put("msg","获取成功!");
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("msg","获取失败!");
        }
        return map;
    }
}
