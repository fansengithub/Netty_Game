package com.mmall.service.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.Object.GameWorld;
import com.mmall.core.BaseUser;
import com.mmall.dao.*;
import com.mmall.dto.ScoreTopNum;
import com.mmall.entity.*;
import com.mmall.model.*;
import com.mmall.netty.message.MessageSend;
import com.mmall.util.*;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 个人中心
 */
@Slf4j
@Service("c")
public class UserService {
    @Autowired
    private PhoneCodeMapper phoneCodeMapper;
    @Autowired
    private StudentsMapper studentsMapper;

    @Autowired
    private ElecPlayerMapper elecPlayerMapper;

    @Autowired
    private ZnAreaMapper znAreaMapper;

    @Autowired
    private ParentsMapper parentsMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private SysMessageMapper sysMessageMapper;

    @Autowired
    private CountRecordMapper countRecordMapper;

    @Autowired
    private UserScoreMapper userScoreMapper;

    @Autowired
    private ScoreSetMapper scoreSetMapper;

    @Autowired
    private SongRecordMapper songRecordMapper;

    @Autowired
    private OperaDetailMapper operaDetailMapper;

    @Autowired
    private PianoShopMapper pianoShopMapper;

    @Autowired
    private ElecLoginMapper loginMapper;

    @Autowired
    private PianoShopScaleMapper pianoShopScaleMapper;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private  VersionMapper versionMapper;

    @Autowired
    private  OrganizationMapper organizationMapper;




    private static final int TOP_N = 100;//排行榜前100名

    private SimpleDateFormat format=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private SimpleDateFormat day=new  SimpleDateFormat("yyyy-MM-dd");

    private static final String APP_SECRET = "aec672b857cc5ebb9c39cc5131448652";
    public static final String WEIXIN_APP_ID = "wxacedc548af489c67";
    private static final String QQ_Appid = "1106262879";

    //6.第三方登录 			以前台传过来的openID与token,验证用户信息、存入数据库、传出 userid、密码   微信   后台做
    public Map<String, Object> thirdLogin(final ChannelHandlerContext ctx, String openId, String token, int type) {
        return requestPassword(openId, token, type);
    }

    /**
     * 第三方登录，该方法会生成用户表中自增id 与 密码，前端需拿到这两个参数，在调用登录接口即可(也可以自己主动调用登录方法)
     * 微信-1 QQ-0 新浪微博-2
     * 微博是需要申请者的微博号才能登录(可以增加其他账户)
     * 数据入库，不同的项目，不同的操作(例子可查看电鼓项目中LoginService.java文件)
     * */
    public Map<String, Object> requestPassword(String openid, String access_token, int type) {
        log.info("获取随机密码:开始");
        Map<String, Object> mapRes = new HashMap<>();
        //微信登录
        if(type == 1){
            String path = "https://api.weixin.qq.com/sns/auth?access_token=" + access_token + "&openid=" + openid + "";
            log.info("获取随机密码-微信:openid:" + openid + "   access_token:" + access_token);
            try {
                String result = HttpUtil.sendPost(path, "");
                Map<String, String> map = JSON.parseObject(result, new TypeReference<Map<String, String>>() {
                });
                String errcode = map.get("errcode");
                String errmsg = map.get("errmsg");
                if (errcode.equals("0")) {
                    log.info("获取随机密码:凭证有效!"+errcode);
                    // 利用openid和token生成一个加密密码
                    String password = CodeUtil.enCodeWithBCrypt(openid + access_token);
                    // 获取用户微信信息     只会把openid给存进去？
                    ElecPlayer player = getPlayerInfoWX(openid, access_token);

                    if (player.getWxOpenid() == null || player.getWxOpenid().length() == 0) {
                        mapRes.put("success", 0);
                        log.info("获取随机密码:玩家openID为空!");
                        return mapRes;
                    }
                    log.info("player" + player);
                    log.info("password-------------------------------" + password);
                    log.info("获取随机密码:开始查找是否已经存在用户!");
                    ElecPlayer elecPlayer = elecPlayerMapper.selectByWX(player.getWxOpenid());// 从本地库查询用户

                    if (elecPlayer == null || elecPlayer.getWxOpenid() == null || elecPlayer.getWxOpenid().length() == 0) {
                        // 设置新加用户信息 --微信
                        player.setNickname(removeNonBmpUnicode(player.getNickname()));
                        player.setPassword(password);
                        player.setCreateTime(new Date());
                        //player.setRoleType(0);
                        log.info("获取随机密码:新加用户信息!");
                        elecPlayerMapper.insertSelective(player);
                    } else {
                        // 更新用户信息
                        log.info("获取随机密码:更新用户信息!");
                        elecPlayer.setPassword(password);
                        elecPlayerMapper.updateByPrimaryKeySelective(elecPlayer);
                    }
                    ElecPlayer newPlayer = elecPlayerMapper.selectByWX(player.getWxOpenid());//最新
                    mapRes.put("success", 1);
                    mapRes.put("msg", "获取微信用户成功!");
                    mapRes.put("userID", newPlayer.getId());// 玩家存入表中的id
                    mapRes.put("password", password);		// 生成的加密密码
                } else {
                    log.info("获取随机密码:凭证无效!errcode:" + errcode + " errmsg:" + errmsg);
                    mapRes.put("msg", "获取出错," + errcode + ":" + errmsg);
                    mapRes.put("success", 0);
                }
            } catch (Exception e) {
                log.info("获取随机密码出现异常:" + e.toString());
                mapRes.put("success", 0);
            }
        }
        //qq登录
        if(type == 0){
            String openId = getPlayerInfoQQ(access_token);
            String path = "https://graph.qq.com/user/get_user_info?access_token=" + access_token + "&oauth_consumer_key="+ QQ_Appid +"&openid=" + openId + "";
            log.info("获取随机密码-openId:" + openId + " oauth_consumer_key:"+QQ_Appid+"  access_token:" + access_token);
            try {
                String result = HttpUtil.sendGet(path, "");
                log.info("QQ用户信息、result:："+result);

                Map<String, String> map = JSON.parseObject(result, new TypeReference<Map<String, String>>() {
                });
                String errcode = map.get("ret");
                String errmsg =  map.get("msg");
                if (errcode.equals("0")) {
                    log.info("获取随机密码:QQ凭证有效!");
                    mapRes.put("errcode", errcode);

                    // 利用openid和token生成一个加密密码
                    String password = CodeUtil.enCodeWithBCrypt(openId + access_token);

                    ElecPlayer playertemp = elecPlayerMapper.selectByQQ(openId);// 从本地库查询用户

                    if (playertemp == null || playertemp.getQqOpenid() == null || playertemp.getQqOpenid().length() == 0) {
                        //if (playertemp == null ) {
                        // 设置新加用户信息 --QQ
                        ElecPlayer player = new ElecPlayer();
                        player.setNickname(removeNonBmpUnicode((String) map.get("nickname")));
                        player.setPassword(password);
                        player.setCreateTime(new Date());
                        //player.setRoleType(0);
                        player.setQqOpenid(openId);
//                        player.setQqHead((String)map.get("figureurl_qq_1 "));
                        player.setHeadurl((String)map.get("figureurl_qq_1 "));
                        player.setQqUnionid(QQ_Appid);

                        if("男".equals(map.get("gender"))){
                            player.setSex(0);
                        }else{
                            player.setSex(1);
                        }

                        log.info("获取随机密码:新加用户信息!");
                        elecPlayerMapper.insertSelective(player);
                    } else {
                        // 更新用户信息
                        log.info("获取随机密码:更新用户信息!");
                        playertemp.setPassword(password);
                        elecPlayerMapper.updateByPrimaryKeySelective(playertemp);
                    }
                    ElecPlayer newPlayer = elecPlayerMapper.selectByQQ(openId);//最新
                    mapRes.put("success", 1);
                    mapRes.put("msg", "获取QQ用户成功!");
                    mapRes.put("userID", newPlayer.getId());// 玩家存入表中的id
                    mapRes.put("password", password);		// 生成的加密密码
                } else {
                    log.info("获取随机密码:QQ凭证无效!errcode:" + errcode + " errmsg:" + errmsg);
                    mapRes.put("msg", "获取出错," + errcode + ":" + errmsg);
                    mapRes.put("success", 0);
                }
            } catch (Exception e) {
                log.info("获取QQ随机密码出现异常:" + e.toString());
                mapRes.put("success", 0);
            }
        }
        //微博登录
        if(type == 2){
            String path = "https://api.weibo.com/2/users/show.json?access_token="+access_token+"&uid="+openid;
            log.info("获取随机密码-新浪微博:access_token:" + access_token);
            try {
                String result = HttpUtil.sendGet(path,"");
                System.out.println("微博返回值："+result);

                Map<String, String> map = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});
                String errmsg = map.get("id");
                if (errmsg != null) {
                    log.info("获取随机密码:微博凭证有效!");
                    // 利用openid和token生成一个加密密码
                    String password = CodeUtil.enCodeWithBCrypt(openid + access_token);
                    ElecPlayer player = new ElecPlayer();

                    ElecPlayer playertemp = elecPlayerMapper.selectByWB(player.getSinaOpenid());// 从本地库查询用户
                    if (playertemp == null || playertemp.getSinaOpenid() == null || playertemp.getSinaOpenid().length() == 0) {
                        // 设置新加用户信息 --新浪微博
                        player.setNickname(removeNonBmpUnicode(map.get("name")));
                        player.setPassword(password);
                        player.setCreateTime(new Date());
                        player.setCity(map.get("city"));
                        //player.setRoleType(0);
                        player.setSinaOpenid(openid);
//                        player.setQqHead(map.get("url"));
                        player.setHeadurl(map.get("url"));
                        player.setQqUnionid("");

                        if("m".equals(map.get("gender"))){//男
                            player.setSex(0);
                        }else{
                            player.setSex(1);
                        }

                        log.info("获取随机密码:新加用户信息!");
                        elecPlayerMapper.insertSelective(player);
                    } else {
                        // 更新用户信息
                        log.info("获取随机密码:更新用户信息!");
                        playertemp.setPassword(password);
                        elecPlayerMapper.updateByPrimaryKeySelective(playertemp);
                    }
                    ElecPlayer newPlayer = elecPlayerMapper.selectByWB(openid);//最新
                    mapRes.put("success", 1);
                    mapRes.put("msg", "获取新浪用户成功!");
                    mapRes.put("userID", newPlayer.getId());// 玩家存入表中的id
                    mapRes.put("password", password);		// 生成的加密密码
                } else {
                    mapRes.put("success", 0);
                    mapRes.put("msg", "获取新浪用户失败!");
                }
            } catch (Exception e) {
                log.info("获取新浪随机密码出现异常:" + e.toString());
                mapRes.put("success", 0);
                mapRes.put("msg", "获取新浪用户失败!");
            }
        }
        return mapRes;
    }

    //1.1 获取微信用户信息
    public ElecPlayer getPlayerInfoWX(String openid, String access_token) {
        String path = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openid+"";
        log.info("微信用户:openid:"+openid+"access_token"+access_token);
        try {
            String result=HttpUtil.sendPost(path, "");//通过openid与访问令牌获取用户基本信息
            //ElecPlayer player = JSON.parseObject(result,new TypeReference<ElecPlayer>(){} ); //单人，多人需要分开
            ElecPlayer player = new ElecPlayer();
            Map<String, String> map = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});

            player.setWxOpenid(map.get("openid"));
            player.setWxHead(map.get("headimgurl"));
            player.setNickname(map.get("nickname"));
            player.setWxUnionid(map.get("unionid"));
            player.setSex(Integer.parseInt(map.get("sex")));
            player.setCity(map.get("city"));
            player.setProvince(map.get("province"));

            elecPlayerMapper.updateByPrimaryKeySelective(player);
            log.info("获取用户资料成功:"+result);
            return player;
        }catch (Exception e) {
            log.info("获取用户资料失败:"+e.toString());
        }
        return null;
    }

    //1.2.获取QQ用户openId信息
    public String getPlayerInfoQQ(String access_token) {
        String openId=null;
        String path = "https://graph.qq.com/oauth2.0/me?access_token="+access_token+"";
        try {
            String result=HttpUtil.sendGet(path, "");//通过openid与访问令牌获取用户基本信息
            log.info("获取用户资料成功:"+result);
            result = result.replace("callback(", "");
            result = result.replace(");", "");
            log.info("获取用户资料成功:"+result);
            Map<String, String> map = JSON.parseObject(result, new TypeReference<Map<String, String>>() {

            });
            ElecPlayer player = new ElecPlayer();
			/*player.setQqOpenid((String)map.get("openid"));
			playerMapper.updateByPrimaryKeySelective(player);*/
            log.info("获取用户资料成功:"+result);
            log.info("QQ的openid为:"+map.get("openid"));
            openId = map.get("openid");
            return openId;
        }catch (Exception e) {
            log.info("获取用户资料失败:"+e.toString());
        }
        return null;
    }
    //1.3.获取新浪用户信息
    public ElecPlayer getPlayerInfoXL(String openid, String access_token) {
        String path = "https://graph.qq.com/user/get_user_info?access_token=" + access_token + "&oauth_consumer_key="+ QQ_Appid +"&openid=" + openid + "";
        log.info("新浪微博用户:openid:"+openid+"access_token"+access_token);
        try {
            String result=HttpUtil.sendPost(path, "");//通过openid与访问令牌获取用户基本信息
            //ElecPlayer player = JSON.parseObject(result,new TypeReference<ElecPlayer>(){} ); //单人，多人需要分开
            ElecPlayer player = new ElecPlayer();
            Map<String, String> map = JSON.parseObject(result, new TypeReference<Map<String, String>>() {});
            player.setWxOpenid(map.get("openid"));
            player.setWxHead(map.get("headimgurl"));
            player.setWxUnionid(map.get("unionid"));
            player.setSex(Integer.parseInt(map.get("sex")));
            player.setCity(map.get("city"));
            player.setProvince(map.get("province"));

            elecPlayerMapper.updateByPrimaryKeySelective(player);

            log.info("获取用户资料成功:"+result);
            return player;
        }catch (Exception e) {
            log.info("获取用户资料失败:"+e.toString());
        }
        return null;
    }


    // 去除表情
    public static String removeNonBmpUnicode(String str) {
        if (str == null) {
            return null;
        }
        str = str.replaceAll("[^\\u0000-\\uFFFF]", "");
        return str;
    }



    /**
     * 手机号、密码登录  或 第三方登陆
     * @param ctx
     * @param phoneORuserID
     * @param password
     * @return
     */
    public Map<String, Object> getLogin(final ChannelHandlerContext ctx, String phoneORuserID, String password) {
        return login(ctx, phoneORuserID, password);
    }

    /**
     * 登陆 手机登陆或第三方登陆
     * @param ctx
     * @param userID
     * @param password
     * @return
     */
    public Map<String, Object> login(final ChannelHandlerContext ctx, String userID, String password) {
        log.info("用户登录");
        log.info("新登录请求:  userID:[" + userID + "]  password:[" + password + "]");
        Map<String, Object> result = new HashMap<>();
        try {
            Boolean flag=false;
            ElecPlayer elecPlayer=null;
            if (userID.length() > 0 && password.length() > 0) {
                if(userID.length()>=11){	//手机号、密码登录
                    System.out.println("开始查找手机号");
                    elecPlayer = elecPlayerMapper.selPlayerByPhone(userID);
                    if(elecPlayer==null){
                        result.put("success", 0);
                        result.put("msg", "该账号不存在，请先注册！");
                        return result;
                    }
                    if(elecPlayer.getIsQiyong()==0){ //如果账号被锁定
                        result.put("success", 0);
                        result.put("msg", "该账号已被锁定！");
                        return result;
                    }
                    if(MD5Util.encrypt(password).equals(elecPlayer.getPassword())){
                        log.info("手机登陆密码比对成功！");
                        flag = true;
                    }
                }else{ //第三方登陆
                    elecPlayer=elecPlayerMapper.selectByPrimaryKey(Integer.parseInt(userID));
                    if (null == elecPlayer) {
                        result.put("success", 0);
                        result.put("msg", "账号或密码错误");
                        return result;
                    }
                    if(elecPlayer.getIsQiyong()==0){
                        result.put("success", 0);
                        result.put("msg", "该账号被锁定！");
                        return result;
                    }
                    if (password.equals(elecPlayer.getPassword())) {
                        log.info("第三方登陆密码比对成功！");
                        flag=true;
                    }
                }
                log.info("flag======="+flag);
                if(flag){
                    if (GameWorld.userList.containsKey(elecPlayer.getId())) {
                        log.info("已存在用户,开始重新连接:" + userID);
                        BaseUser oldUser = (BaseUser) GameWorld.userList.get(elecPlayer.getId());
                        Map<String, Object> map = new HashMap<String,Object>();
//                        map.put("type", 0);
                        //向前台发送异地登录信息
                        if (!ctx.equals(oldUser.getCtx())) {
                            MessageSend.send(oldUser.getCtx(), "quitToLogin", map, false);
                        }
                        ctx.channel().attr(GameWorld.userId_key).set(elecPlayer.getId());
                        oldUser.setCtx(ctx);
                        GameWorld.userList.put(elecPlayer.getId()+"", oldUser);
                        GameWorld.sessionList.put(ctx.channel().id().asLongText(), ctx);
                        oldUser.reConnect();
//						PlayService.reconnect(session);
                        log.info("用户:" + userID + "断线重连" + ";在线玩家数:" + GameWorld.sessionList.size() + ";总玩家数:" + GameWorld.userList.size());
                    } else {
                        log.info("用户第一次登录:" + userID+"id"+elecPlayer.getId());
                        BaseUser user = new BaseUser();
                        user.setUserID(elecPlayer.getId()+"");
                        user.setUserName(elecPlayer.getName());
                        user.setHeadUrl(elecPlayer.getHeadurl());
                        user.setRank(elecPlayer.getRank());//等级
                        user.setGender(false);
                        ctx.channel().attr(GameWorld.userId_key).set(elecPlayer.getId());
                        user.setCtx(ctx);
                        GameWorld.userList.put(elecPlayer.getId()+"", user);
                        GameWorld.sessionList.put(ctx.channel().id().asLongText(), ctx);
                        log.info("用户:" + userID + "首次登录" + ";在线玩家数:" + GameWorld.sessionList.size() + ";总玩家数:" + GameWorld.userList.size());

                    }

                    //获取当前零点时间
                    long current=System.currentTimeMillis();//当前时间毫秒数
                    long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
                    Date currentDate = new Timestamp(current);//当前 登陆 时间
                    Date FirstDate = new Timestamp(zero);//今天零点零分零秒
                    log.info("当前登陆时间："+currentDate);
                    log.info("今天零点零分零秒："+FirstDate);
                    ElecPlayer user=null;
                    ElecLogin loginTime  = loginMapper.selectUserEntTime(elecPlayer.getId());//当天，用户最近一次登陆时间对象
                    if(loginTime==null){//当天，第一次登陆
                        //每日第一次登陆奖励积分
                        ScoreSet score = scoreSetMapper.selectByPrimaryKey(1);
                        Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
                        user=elecPlayerMapper.selectByPrimaryKey(userId);
                        log.info("ID:"+user.getId()+","+user.getNickname()+"每日第一次登陆，奖励"+score.getScore()+"分！");

                        ElecLogin login = new ElecLogin();
                        login.setLoginTime(currentDate);
                        login.setPlayerId(elecPlayer.getId());
                        loginMapper.insertSelective(login);//存入 当前 登陆 时间

                        if(score != null && user != null){
                            ElecPlayer ePlayer = elecPlayerMapper.selectByPrimaryKey(elecPlayer.getId());//第一次登陆奖励
                            ePlayer.setScore(Integer.parseInt(score.getScore()));
                            elecPlayerMapper.updateByPrimaryKeySelective(ePlayer);
                            UserScore userScore = userScoreMapper.getScoreByInfo(userId,1);//第一次登陆记录
                            if(userScore==null){//新用户
                                UserScore uS = new UserScore();
                                //存入积分记录表
                                uS.setInfo(1);
                                uS.setTime(new Date());
                                uS.setNickname(user.getNickname());
                                uS.setNum(Integer.parseInt(score.getScore())+"");

                                uS.setPlayerId(userId); //每日第一次登录奖励
                                userScoreMapper.insertSelective(uS);

                            }else{//老用户
                                userScore.setTime(new Date());
                                userScoreMapper.updateByPrimaryKeySelective(userScore);
                            }
                        }
                    }else{
                        log.info("该用户今天不是第一次登陆！");
                    }
                    if(elecPlayer.getPlayerId()==null||elecPlayer.equals("")){
                        result.put("success", 2);
                    }else{
                        result.put("success", 1);
                    }
                    result.put("type",elecPlayer.getRoleType());//角色
                    result.put("id", elecPlayer.getId());
                    result.put("name",elecPlayer.getName());
                    result.put("lv",elecPlayer.getRank());
                    if(elecPlayer.getHeadurl()!=null&&!elecPlayer.getHeadurl().equals("")){
                        result.put("url",elecPlayer.getHeadurl());
                    }else{
                        result.put("url","");
                    }
                    result.put("msg", "登录成功!");
                }else {
                    log.info("登录ID不合法:");
                    result.put("success", 0);
                    result.put("msg", "账号或密码错误");
                }
            } else {
                log.info("参数无效:" + userID);
                result.put("success", 0);
                result.put("msg", "指令无效:参数无效");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("login异常:" + MyUtils.getExceptionAllinformation(e));
            result.put("success", 0);
            result.put("msg", "账号或密码错误!");
        }
        return result;
    }


    /**
     * 注册时点击下一步验证
     * @return
     */
    public Map<String,Object> nextRegister(final ChannelHandlerContext ctx,String phone,String num){
        Map<String,Object> map=new HashMap<>();
        PhoneCode phoneCode=phoneCodeMapper.selectByPhone(phone);
        Boolean flag=true;
        if(phoneCode!=null){
            // 验证码过期
            if (new Date().getTime() > phoneCode.getExpiredTime().getTime()) {
                map.put("success", 0);
                map.put("msg", "验证码已过期！");
                flag=false;
            }
            log.info("pNum"+phone);
            ElecPlayerExample example=new ElecPlayerExample();
            ElecPlayerExample.Criteria criteria=example.createCriteria();
            criteria.andPhoneEqualTo(phone);
            List<ElecPlayer> elecPlayers=elecPlayerMapper.selectByExample(example);
            if(elecPlayers.size()>0){
                map.put("success", 0);
                map.put("msg", "该手机号已被注册!");
                flag=false;
            }
            if(!phoneCode.getCode().equals(num)) { //比对验证码
                map.put("success", 0);
                map.put("msg", "验证码错误！");
                flag=false;
            }
        }else{
            map.put("success",0);
            map.put("msg","没有向该手机发送验证码!");
            flag=false;
        }
        if(!flag){
            return map;
        }else{
            map.put("success",1);
            map.put("msg","成功!");
            return map;
        }

    }


    /**
     * 学生+家长注册
     * @param ctx
     * @param type    1-- 学生注册  2-- 家长注册
     * @param nickName
     * @param name
     * @param leibie
     * @param diqu
     * @param locationDetail
     * @param teacherNum
     * @param referee
     * @return
     */
    public Map<String,Object> regeditS_P(final ChannelHandlerContext ctx,String pNum,String pwd,
                                         String type,String nickName,String name, String leibie,String diqu,
                                         String locationDetail,String teacherNum,String referee){
        log.info("学生+家长注册");
        //ly 6-5
        Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
        log.info("userId============"+userId);
        //
        Map<String,Object> map=new HashMap<>();
        try {
            int num=0;
            Students students=null;
            Parents parents=null;
//        if(phoneCode.getCode().equals(VNum)){ //比对验证码
            if(type.equals("1")){//学生注册
                students=new Students();
                if(referee!=null&&!referee.equals("")){
                    students.setRefereeId(Integer.parseInt(referee));//推荐人
                }
                if(teacherNum!=null&&!teacherNum.equals("")){
                    students.setTeacherId(Integer.parseInt(teacherNum));//老师编号
                }
                students.setTelephone(pNum); //手机号
                students.setRegisterTime(new Date());
                students.setArea(diqu);//地区
                students.setAddress(locationDetail);
                students.setStundentName(name);
                num=studentsMapper.insertSelective(students);
            }
            //家长注册
            if(type.equals("2")){
                parents=new Parents();
                if(referee!=null&&!referee.equals("")){
                    parents.setRefereeId(Integer.parseInt(referee));//推荐人
                }
                if(teacherNum!=null&&!teacherNum.equals("")){
                    parents.setTeacherId(Integer.parseInt(teacherNum));//老师编号
                }
                parents.setTelephone(pNum); //手机号
                parents.setRegisterTime(new Date());
                parents.setArea(diqu);//地区
                parents.setAddress(locationDetail);
                parents.setName(name);
                num=parentsMapper.insertSelective(parents);
            }
//        }else{
//            map.put("success", 0);
//            map.put("msg", "验证码错误！");
//            return map;
//        }
            if(num>0){
                if(userId!=null){
                    log.info("第三方登陆，完善信息");
                    ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
                    if(parents!=null){
                        log.info("id===="+parents.getId());
                        elecPlayer.setPlayerId(parents.getId());
                    }
                    if(students!=null){
                        log.info("id===="+students.getId());
                        elecPlayer.setPlayerId(students.getId());
                    }
                    elecPlayer.setPhone(pNum);
                    elecPlayer.setRoleType(Integer.parseInt(type)); //身份
                    elecPlayer.setName(name);
                    elecPlayer.setType(leibie); //类别
                    elecPlayer.setCreateTime(new Date());
                    elecPlayer.setAddress(locationDetail); //详情地址
                    elecPlayer.setCity(diqu);
                    elecPlayer.setIscomplete(1);//已完善
                    if(elecPlayerMapper.updateByPrimaryKey(elecPlayer)>0){
                        map.put("success", 1);
                        map.put("msg", "注册成功!");
                    }else{
                        map.put("success", 0);
                        map.put("msg", "注册失败!");
                    }
                }else {
                    log.info("手机注册==========================");
                    ElecPlayer elecPlayer = new ElecPlayer();
                    if (parents != null) {
                        log.info("id====" + parents.getId());
                        elecPlayer.setPlayerId(parents.getId());
                    }
                    if (students != null) {
                        log.info("id====" + students.getId());
                        elecPlayer.setPlayerId(students.getId());
                    }
                    elecPlayer.setPhone(pNum);
                    elecPlayer.setRoleType(Integer.parseInt(type)); //身份
                    elecPlayer.setPassword(MD5Util.encrypt(pwd)); //密码
                    elecPlayer.setNickname(nickName);
                    elecPlayer.setName(name);
                    elecPlayer.setType(leibie); //类别
                    elecPlayer.setCreateTime(new Date());
                    elecPlayer.setAddress(locationDetail); //详情地址
                    elecPlayer.setCity(diqu);
                    elecPlayer.setIscomplete(1);//已完善
                    int num2 = elecPlayerMapper.insertSelective(elecPlayer);
                    if (num2 > 0) {
                        map.put("success", 1);
                        map.put("msg", "注册成功!");
                    } else {
                        map.put("success", 0);
                        map.put("msg", "注册失败!");
                    }
                }
            }else{
                map.put("success", 0);
                map.put("msg", "注册失败!");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", 0);
            map.put("msg", "注册失败!");
        }
        return map;
    }

    /**
     *  琴行注册
     * @param ctx
     * @param pNum
     * @param pwd
     * @param name
     * @param linkman
     * @param kind
     * @param phoneNum
     * @param Legal
     * @param LegalNum
     * @param location
     * @param scale
     * @param locationDetail
     * @param url1
     * @param url2
     * @param teaName
     * @param teaNum
     * @param teaCode
     * @param teaPsw
     * @param teaaddress
     * @param tealocationDetail
     * @return
     */
    public Map<String,Object> regedit_shop(final ChannelHandlerContext ctx,String pNum,String pwd,String name,String linkman,String kind,
                                           String phoneNum,String Legal,String LegalNum,String location,String scale,String locationDetail,
                                           String url1,String url2,String teaName,String teaNum,String teaCode,String teaPsw,String teaaddress,String tealocationDetail)throws  Exception{
        log.info("琴行注册");
        Map<String,Object> map=new HashMap<>();
        try {
            PhoneCode phoneCode=phoneCodeMapper.selectByPhone(pNum);
            if(phoneCode==null){
                map.put("success", 0);
                map.put("msg", "并没有给该手机号发送过验证码!");
                return map;
            }
            // 验证码过期
            if (new Date().getTime() > phoneCode.getExpiredTime().getTime()) {
                map.put("success", 0);
                map.put("msg", "验证码已过期!");
                return map;
            }
            PhoneCode phoneCode2=phoneCodeMapper.selectByPhone(teaNum);
            if(phoneCode2==null){
                map.put("success", 0);
                map.put("msg", "并没有给该手机号发送过验证码!");
                return map;
            }
            // 验证码过期
            if (new Date().getTime() > phoneCode2.getExpiredTime().getTime()) {
                map.put("success", 0);
                map.put("msg", "验证码已过期!");
                return map;
            }
            if(!teaCode.equals(phoneCode2.getCode())){
                map.put("success", 0);
                map.put("msg", "验证码有误!");
                return map;
            }
            ElecPlayer elecPlayer=elecPlayerMapper.selPlayerByPhone(teaNum);
            if(elecPlayer!=null){
                map.put("success", 0);
                map.put("msg", "老师手机号已被注册!");
                return map;
            }
            PianoShop pianoShop=new PianoShop();
            pianoShop.setTelephone(pNum);//手机号
            pianoShop.setName(name);//琴行名
            pianoShop.setContacts(linkman);//联系人
            pianoShop.setPianoShopType(kind);//类别
            pianoShop.setTelephone(phoneNum);//手机号
            pianoShop.setLegalName(Legal);//法人
            pianoShop.setBossTelephone(LegalNum);//法人电话
            pianoShop.setArea(location);//地区
            pianoShop.setAddress(locationDetail);//详细地址
            pianoShop.setPianoShopScale(scale);//规模
            pianoShop.setBusinessLicensePicture(url2);//营业执照
            pianoShop.setIdcardPicture(url1);//身份证
            pianoShop.setState(1);//状态
            pianoShop.setRegisterTime(new Date());//注册时间
            if(pianoShopMapper.insert(pianoShop)>0){
                //给琴行创建后台账号
                SysUser sysUser=new SysUser();
                sysUser.setUsername(name);
                sysUser.setTelephone(pNum);//账号
                sysUser.setPassword(MyUtils.getMD5(pwd));//密码
                sysUser.setDeptId(1);
                sysUser.setStatus(0);//状态
                sysUser.setOperator("admin");
                sysUser.setOperateIp("127.0.0.1");
                sysUser.setOperateTime(new Date());
                sysUser.setXinxiType(3);
                sysUser.setXinxiId(pianoShop.getId());//琴行id
                sysUser.setMail("");
                sysUser.setRemark("");
                int num=sysUserMapper.insert(sysUser);
                log.info("琴行信息插入结果"+num);
                if(num>0){
                    Teacher teacher=new Teacher();
                    teacher.setName(teaName);//老师名
                    teacher.setBelongtoPianoShopid(pianoShop.getId());//所属琴行id
                    teacher.setBelongtoPianoShop(name);//琴行名
                    teacher.setTelephone(teaNum);
                    teacher.setState(0);//状态
                    teacher.setIsDefaultTeacher(0);//是否为琴行默认老师
                    teacher.setArea(teaaddress);//区域
                    teacher.setAddress(tealocationDetail);//详情地址
                    teacher.setRegisterTime(new Date());//注册时间
                    teacher.setRemind(1);
                    int num2=teacherMapper.insert(teacher);
                    log.info("老师信息插入结果"+num2);
                    if(num2>0){
                        ElecPlayer player=new ElecPlayer();
                        player.setPlayerId(teacher.getId());
                        player.setName(teaName);
                        player.setPhone(teaNum);//手机号
                        player.setRoleType(3);
                        player.setCreateTime(new Date());
                        player.setPassword(MyUtils.getMD5(teaPsw));
                        player.setCity(teaaddress);
                        player.setAddress(tealocationDetail);
                        int num3=elecPlayerMapper.insert(player);
                        log.info(num3+"");
                    }
                }
                map.put("success",1);
                map.put("msg","成功。");
            }else{
                map.put("success",0);
                map.put("msg","注册失败!");
            }
        }catch (Exception e){
            throw new Exception();
        }
        return  map;
    }

    /**
     * 获取琴行规模
     * @param ctx
     * @return
     */
    public Map<String,Object> getMusicCompanySize(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        try {
            List<PianoShopScale> pianoShopScales=pianoShopScaleMapper.selectAll();
            List<ScalesInfo> scalesInfos=new ArrayList<>();
            for (PianoShopScale pianoShopScale : pianoShopScales) {
                ScalesInfo scalesInfo=new ScalesInfo();
                scalesInfo.setId(pianoShopScale.getId()+"");//id
                scalesInfo.setName(pianoShopScale.getType());//规模类型
                scalesInfos.add(scalesInfo);
            }
            map.put("success",1);
            map.put("msg","获取成功");
            map.put("list",scalesInfos);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("msg","获取失败");
        }
        return map;
    }

    public Map<String,Object> getSmsCode(final ChannelHandlerContext ctx,String number){
        //在发验证码之前判断该手机是否已经注册
        Map<String, Object> result = new HashMap<>();
        ElecPlayer elecPlayer= elecPlayerMapper.selPlayerByPhone(number);
        if(elecPlayer!=null){
            result.put("success", 0);
            result.put("msg", "该手机号已被注册!");
            return result;
        }else{
            return sendSmsCode(number);
        }
    }

    /**
     * 短信验证码
     * @param number
     * @param
     * @return
     */
    public  Map<String,Object> sendSmsCode(String number){
        log.info("注册获取验证码getPhoneCode--------------------------------------------");
        Map<String, Object> result = new HashMap<>();
        String code = MyUtils.SixMobileVfCode();
        try {
//            String template = "414509";//注册时验证码         可能需要注册、修改、绑定时判断了
//            String content = "{\"code\":\""
//                    +code+",欢迎注册“音悦熊”会员！\"}";
            // 发送短信验证码成功
//            if (SmsCnUtil.httpRequest(number,template,content)) {
            if (MessageUtils.sendMessage(number, code)) {
                // 将该在线用户用手机号标记
                result.put("success", 1);
                result.put("msg", "验证码发送成功！");
                PhoneCode phoneCode = new PhoneCode();
                phoneCode.setCode(code);
                Date date = new Date();
                phoneCode.setCreatetime(date);
                phoneCode.setPhone(number);
                phoneCode.setExpiredTime(new Date(10 * 60 * 1000 + date.getTime()));
                phoneCodeMapper.insertSelective(phoneCode);
                return result;
            } else {
                result.put("success", 0);
                result.put("msg", "验证码发送失败！");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "验证码发送失败！");
            return result;
        }
    }

    /**
     * 用户信息
     * @param ctx
     * @param
     * @return
     */
    public Map<String,Object> getUserInfo(final ChannelHandlerContext ctx){
        Map<String,Object> map =new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId"+userId);
            BaseUser user = (BaseUser) GameWorld.userList.get(String.valueOf(userId));
            log.info(""+user.getUserID());
            ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
            if(elecPlayer!=null){
                log.info("角色"+elecPlayer.getRoleType());
                switch (elecPlayer.getRoleType()){
                    case 1: { //学生
                        Students students = studentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                        log.info("学生" + students.getId());
                        if (students != null) {
                            map.put("success", 1);
                            map.put("message", "获取用户信息成功！");
                            map.put("type", elecPlayer.getRoleType());//角色
                            map.put("name", elecPlayer.getName());
                            map.put("city", elecPlayer.getCity());
                            map.put("sex", elecPlayer.getSex() == 0 ? "男" : "女");
                            if (students.getTeacherId() != null && !students.getTeacherId().equals("")&&students.getTeacherName()!=null&&!students.getTeacherName().equals("")) {
                                map.put("teacher", students.getTeacherName());
                            } else {
                                map.put("teacher", "");
                            }
                            if (elecPlayer.getAge() != null) {
                                map.put("age", elecPlayer.getAge()); //年龄
                            } else {
                                map.put("age", ""); //年龄
                            }
                            map.put("score", elecPlayer.getScore());//积分
                            map.put("coinCount", elecPlayer.getXiongzhang()); //熊掌数
                        } else {
                            map.put("success", 0);
                            map.put("message", "获取失败！");
                        }
                        break;
                    }
                    case 2: { //家长
                        Parents parents = parentsMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                        log.info("parentId===" + parents.getId());
//                   List<ElecPlayer> players = parentsMapper.selParentsAndstus(parents.getParentId());
//                        List<ElecPlayer> elecPlayers=elecPlayerMapper.getStuByPid(parents.getId());
                        List<Students> students=studentsMapper.getStuNameByPid(parents.getId());
                        List<String> list = new ArrayList<>();
                        if (students.size() > 0) {
                            for (Students stu : students) {
                                list.add(stu.getStundentName());
                            }
                        }
                        log.info("家长" + parents.getId());
                        if (parents != null) {
                            map.put("success", 1);
                            map.put("message", "获取用户信息成功！");
                            map.put("type", elecPlayer.getRoleType());//角色
                            map.put("name", elecPlayer.getName());
                            if (elecPlayer.getAge() != null) {
                                map.put("age", elecPlayer.getAge()); //年龄
                            } else {
                                map.put("age", ""); //年龄
                            }
                            map.put("city", elecPlayer.getCity());
                            map.put("sex", elecPlayer.getSex() == 0 ? "男" : "女");
                            map.put("score", "");
                            map.put("coinCount", elecPlayer.getXiongzhang()); //熊掌数
                            map.put("children", list);
                        } else {
                            map.put("success", 0);
                            map.put("message", "获取失败！");

                        }
                        break;
                    }
                    case 3: { //老师
                        Teacher teacher = teacherMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
//                        int num = teacherMapper.SelstudentCount(teacher.getTeacherId());
                        int num=studentsMapper.getStuCountByTid(teacher.getId());
                        log.info("老师名"+teacher.getName());
                        if (teacher != null) {
                            map.put("success", 1);
                            map.put("message", "获取用户信息成功！");
                            map.put("type", elecPlayer.getRoleType());//角色
                            map.put("name", elecPlayer.getName());
                            if (elecPlayer.getAge() != null) {
                                map.put("age", elecPlayer.getAge()); //年龄
                            } else {
                                map.put("age", ""); //年龄
                            }
                            map.put("city", elecPlayer.getCity());
                            map.put("sex", elecPlayer.getSex() == 0 ? "男" : "女");
                            map.put("score", elecPlayer.getScore());//积分
                            map.put("coinCount", elecPlayer.getXiongzhang()); //熊掌数
                            map.put("studentCount", num); //学生个数
                            map.put("shop",teacher.getBelongtoPianoShop());//所属琴行
                        } else {
                            map.put("success", 0);
                            map.put("message", "获取失败！");

                        }
                        break;
                    }
                }
            }else{
                map.put("success", 0);
                map.put("message", "没有该用户！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success", 0);
            map.put("message", "获取失败！");
        }
        return map;
    }


    /**
     * 获取用户剩余信息
     * @return
     */
    public Map<String,Object> getMoreUserInfo(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId===="+userId);
            BaseUser user = (BaseUser) GameWorld.userList.get(String.valueOf(userId));
            log.info(""+user.getUserID());
            ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
            if(elecPlayer!=null){
                if(elecPlayer.getRefereeId()!=null&&!elecPlayer.getRefereeId().equals("")){
                    map.put("invitationCode",elecPlayer.getRefereeId());//推荐人
                }else{
                    map.put("invitationCode","");//推荐人
                }
                map.put("level",elecPlayer.getRank());//等级
                if(elecPlayer.getBrithday()==null||elecPlayer.getBrithday().equals("")){
                    map.put("birthday","");//生日
                }else{
                    map.put("birthday",elecPlayer.getBrithday());//生日
                }
                if(elecPlayer.getCity()!=null&&!elecPlayer.getCity().equals("")){
                    map.put("cityList",elecPlayer.getCity());
                }else{
                    map.put("cityList","");
                }
                map.put("success",1);
                map.put("message","获取成功！");
            }else{
                map.put("success",0);
                map.put("message","获取失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("message","获取失败！");
        }
        return map;
    }

    /**
     * 修改个人信息
     * @return
     */
    public Map<String,Object> changeUserInfo(final ChannelHandlerContext ctx,String name,String city,String sex,String brithday,String num){
        Map<String,Object> map=new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId===="+userId);
            BaseUser user = (BaseUser) GameWorld.userList.get(String.valueOf(userId));
            log.info(""+user.getUserID());
            //
            if(num!=null&&!num.equals("")){
                PianoShop pianoShop=pianoShopMapper.selectByPrimaryKey(Integer.parseInt(num));
                if(pianoShop==null){
                    map.put("success",0);
                    map.put("message","琴行ID无效！");
                    return map;
                }
            }
            ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
            if(elecPlayer!=null){
                if(!name.equals("")&&name!=null){
                    elecPlayer.setName(name);//姓名
                }
                if(!city.equals("")&&city!=null){
                    elecPlayer.setCity(city);//城市
                }
                if(!brithday.equals("")&&brithday!=null){
                    elecPlayer.setBrithday(brithday);//生日
                    //根据生日计算年龄
                    int age=AgeUtil.getAgeFromBirthTime(brithday);
                    elecPlayer.setAge(age);//年龄
                }
                if(num!=null&&!num.equals("")){
                    elecPlayer.setRefereeId(num);//推荐码
                }
                if(sex!=null&&!sex.equals("")){
                    elecPlayer.setSex(Integer.parseInt(sex));//性别
                }
                if(elecPlayerMapper.updateByPrimaryKey(elecPlayer)>0){
                    log.info("cg");
                    map.put("success",1);
                    map.put("message","修改成功！");
                }else{
                    map.put("success",0);
                    map.put("message","修改失败！");
                }
            }else{
                map.put("success",0);
                map.put("message","修改失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("message","修改失败！");
        }
        return map;
    }

    /**
     * 获取积分记录
     * @return
     */
    public Map<String,Object> getScoreRecord(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            log.info("userId"+userId);
            ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
            if(elecPlayer!=null){
                List<UserScore> userScores=userScoreMapper.getUserScoreByUid(userId);
                //返回值的数组
                Grade[] gradeInfo = new Grade[userScores.size()];
                for(int i=0;i<userScores.size();i++){
                    gradeInfo[i] = new Grade();
                }
                //填充记录
                for(int i=0;i<userScores.size();i++){
                    ScoreSet scoreSet=scoreSetMapper.selectByPrimaryKey(userScores.get(i).getInfo());
                    String time = sdf.format(userScores.get(i).getTime());
                    gradeInfo[i].setTime(time);
                    gradeInfo[i].setName(scoreSet.getTitle());

                    if(userScores.get(i).getInfo()==2){  //获取多少积分
                        String[] arr = scoreSet.getScore().split("\\|");
                        gradeInfo[i].setAdd(userScores.get(i).getNum());
                    }else{
                        gradeInfo[i].setAdd(scoreSet.getScore());
                    }
                }
                map.put("nowScore",elecPlayer.getScore());
                map.put("success",1);
                map.put("message","获取成功！");
                map.put("record",gradeInfo);
            }else{
                map.put("success",0);
                map.put("message","获取失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("message","获取失败！");
        }
        return map;
    }

    /**
     * 获取系统消息
     * @return
     */
    public Map<String,Object> getSysMsg(final ChannelHandlerContext ctx,String page,String size){
        Map<String,Object> map=new HashMap<>();
        log.info("获取系统消息");
        try {
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            BaseUser baseUser= (BaseUser) GameWorld.userList.get(String.valueOf(userId));
//        List<SysMessage> sysMessages= sysMessageMapper.getMessageList(userId);
            PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
            List<SysMessage> sysMessages= sysMessageMapper.getMessageList(userId);
            PageInfo pageInfo = new PageInfo(sysMessages);
            if(pageInfo.isIsLastPage()){
                map.put("isLastPage",0);
            }else{
                map.put("isLastPage",1);
            }

            List<MessageInfo> infos=new ArrayList<>();
            for (SysMessage sysMessage : sysMessages) {
                MessageInfo messageInfo=new MessageInfo();
                messageInfo.setContent(sysMessage.getContent());//内容
                messageInfo.setName(sysMessage.getObjectId()==-1?"系统消息":"个人消息");
                messageInfo.setTime(format.format(sysMessage.getSendTime()));
                infos.add(messageInfo);
            }
            map.put("success",1);
            map.put("message","获取成功。");
            map.put("msg",infos);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("message","获取失败。");
        }
        return map;
    }

    /**
     * 获取用户基础练习记录
     * @param ctx
     * @return
     */
    public Map<String,Object> getTrainingRecord_base(final ChannelHandlerContext ctx,int page,int size){
        Map<String,Object> map=new HashMap<>();
        try {
            log.info("第几页"+page+"每页"+size);
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
            if(elecPlayer==null){
                map.put("success",0);
                map.put("message","用户不存在！");
            }
            List<SongRecord> songRecords=songRecordMapper.getSongRecord(userId,(page-1)*size,size);
            List<ExerciseBase> bases=new ArrayList<>();
            if(songRecords.size()>0){
                for (SongRecord songRecord : songRecords) {
                    ExerciseBase base=new ExerciseBase();
                    base.setFail(songRecord.getSuccess()+""); //是否成功
                    base.setMiss(songRecord.getFirstParam()+"");//miss数
                    base.setCorrect(songRecord.getSecondParam()+"");//正确数
                    base.setTotalscore(songRecord.getThirdParam()+"");//分数
                    //获取曲谱名
                    OperaDetail operaDetail=operaDetailMapper.selectByPrimaryKey(songRecord.getSongId());
                    base.setName(operaDetail==null?"":operaDetail.getOperaName());
                    base.setTime(format.format(songRecord.getRecordTime()));//生成时间
                    base.setType(songRecord.getPlayspeed()+"");
                    bases.add(base);
                }
                map.put("success",1);
                map.put("message","获取成功");
                map.put("record",bases);
                map.put("isLastPage",1);
            }else{
                map.put("success",1);
                map.put("message","");
                map.put("record",bases);
                map.put("isLastPage",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success","0");
            map.put("message","获取失败");
        }
        return map;
    }

    /**
     * 计数器记录
     * @param ctx
     * @return
     */
    public Map<String,Object> getTrainingRecord_counter(final ChannelHandlerContext ctx,int page,int size){
        Map<String,Object> map=new HashMap<>();
        try {
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer elecPlayer=elecPlayerMapper.selectByPrimaryKey(userId);
            if(elecPlayer==null){
                map.put("success",0);
                map.put("message","用户不存在！");
            }
            List<CountRecord> countRecords=countRecordMapper.getCountRecordByUid(userId,"","",(page-1)*size,size);
            List<CounterInfo> counterInfos=new ArrayList<>();
            if(countRecords.size()>0){
                for (CountRecord countRecord : countRecords) {
                    CounterInfo info=new CounterInfo();
                    info.setHit(countRecord.getCounterCount()+"");//打击数
                    info.setRecordTime(format.format(countRecord.getRecordTime())); //生成时间
                    info.setSpeed(countRecord.getCounterSpeed());//速度
                    info.setTime(countRecord.getCountTime());//持续时间
                    counterInfos.add(info);
                }
                map.put("success","1");
                map.put("message","获取成功");
                map.put("record",counterInfos);
                map.put("isLastPage",1);
            }else{
                map.put("success",1);
                map.put("message","");
                map.put("record",counterInfos);
                map.put("isLastPage",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            map.put("success","0");
            map.put("message","获取失败");
        }
        return map;
    }

    /**
     * 获取练习报表
     * @param ctx
     * @param time
     * @return
     */
    public Map<String, Object> getTrainingTable(final ChannelHandlerContext ctx,String time) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer user=elecPlayerMapper.selectByPrimaryKey(userId);
            if(user==null) {
                result.put("success",0);
                result.put("message","用户获取失败!");
                return result;
            }
            List<String> monthInfo=new ArrayList<>();
            String info="";
            Date date=null;
            if(time.equals("0"))
                date=new Date();
            else
                date=day.parse(time+"-01");

            log.info(day.format(date));

            Calendar rightNow = Calendar.getInstance();
            rightNow.setTime(date);
            rightNow.add(Calendar.MONTH, 1);
            Date nextMonthDate=rightNow.getTime();
            log.info(1-songRecordMapper.selectWeek(day.format(date),user.getId())+"");
            rightNow.add(Calendar.MONTH, 1-songRecordMapper.selectWeek(day.format(date),user.getId()));
            Date lastDay=rightNow.getTime();

            for(int i=1;i<songRecordMapper.selectWeek(day.format(date),user.getId());i++) {
                info+=songRecordMapper.selectSumByDay(day.format(lastDay),user.getId())+"|";
                log.info("day:"+day.format(date)+";"+info);
                rightNow.setTime(lastDay);
                rightNow.add(Calendar.DAY_OF_MONTH, 1);
                lastDay=rightNow.getTime();
            }

            while(date.getTime()<nextMonthDate.getTime()){
                int sum=songRecordMapper.selectSumByDay(day.format(date),user.getId());
                info+=sum+"|";
                log.info("day:"+day.format(date)+";"+info);
                if(songRecordMapper.selectWeek(day.format(date),user.getId())==0) {
                    info=info.substring(0, info.length()-1);
                    monthInfo.add(info);
                    info="";
                }
                rightNow.setTime(date);
                rightNow.add(Calendar.DAY_OF_MONTH, 1);
                date=rightNow.getTime();
            }
            for(int i=songRecordMapper.selectWeek(day.format(nextMonthDate),user.getId());i<8;i++) {
                info+=songRecordMapper.selectSumByDay(day.format(nextMonthDate),user.getId())+"|";
                log.info("day:"+day.format(date)+";"+info);
                rightNow.setTime(nextMonthDate);
                rightNow.add(Calendar.DAY_OF_MONTH, 1);
                nextMonthDate=rightNow.getTime();
            }
            info=info.substring(0, info.length()-1);
            monthInfo.add(info);
            info="";
            log.info(monthInfo.size()+"");
            int thisMonth=songRecordMapper.selectMonthTime(user.getId());
            int thisWeek=songRecordMapper.selectWeekTime(user.getId());
            int lastWeek=songRecordMapper.selectLastWeekTime(user.getId());
            result.put("success", 1);
            result.put("message", "获取成功");
            result.put("thisWeek", thisWeek+"");
            result.put("lastWeek", lastWeek+"");
            result.put("thisMoon", thisMonth+"");
            result.put("valueMoon", monthInfo);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("message", "获取失败");
            return result;
        }
    }


    /**
     * 获取全国省市区
     * @param
     * @param id
     * @return
     */
    public Map<String, Object> getAllCity(final ChannelHandlerContext ctx,String id/*地区编号*/) {
        Map<String, Object> result = new HashMap<>();
        List<Area> areaList = znAreaMapper.selectAreaListByParentId(id);//连续调用、每次都传入id
        if(areaList.size()>0){
            result.put("success", 1);
            result.put("areaList", areaList);
            result.put("msg", "成功！");
        }else{
            result.put("success", 0);
            result.put("areaList", areaList);
            result.put("msg", "失败！");
        }
        return result;
    }

    /**
     * 请求上传路径
     * @param ctx
     * @param
     * @return
     */
    public Map<String,Object> requestUpDataUrl(final ChannelHandlerContext ctx){
        log.info("图片上传");
        Map<String, Object> mapRes = new HashMap<>();
        String returnUrlHead= PropertyUtil.getProperty("SystemData.returnUrlHead");
        log.info("returnUrlHead-----------"+returnUrlHead);
        returnUrlHead=returnUrlHead.substring(0, returnUrlHead.length()-2);  //修改之前字符串截取存在错误<http://47.100.11.1>
        mapRes.put("url", returnUrlHead+"/Game/FileController/imgUpload?kinds=");//前台动态拼接，图片上传
        mapRes.put("success", 1);
        return mapRes;
    }

//    public static void main(String[] args) {
//        String returnUrlHead="http://47.100.11.15/F";
//        returnUrlHead=returnUrlHead.substring(0, returnUrlHead.length()-2);
//        System.out.println("5555555-----:"+returnUrlHead);
//    }
    /**
     * 更换头像
     * @param ctx
     * @param url
     * @return
     */
    public Map<String,Object> userHeadImagePut(final ChannelHandlerContext ctx,String url){
        Map<String, Object> mapRes = new HashMap<>();
        try{
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer player = elecPlayerMapper.selectByPrimaryKey(userId);
            player.setHeadurl(url);
            if(elecPlayerMapper.updateByPrimaryKey(player)>0){
                mapRes.put("success", 1);
                mapRes.put("message", "操作成功！");
            }else{
                mapRes.put("success", 0);
                mapRes.put("message", "操作失败！");
            }
        }catch (Exception e) {
            e.printStackTrace();
            mapRes.put("success", 0);
            mapRes.put("message", "操作失败！");
        }
        return mapRes;
    }
    /**
     * 排行榜
     * @return
     */
    public Map<String,Object> getTopNum(final ChannelHandlerContext ctx){
        Map<String,Object> map=new HashMap<>();
        try {
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            List<ScoreTopNum> scoreTopNums=elecPlayerMapper.getScoreTopNum(TOP_N);
//            scoreTopNums.stream().filter(rank)
            List<ScoreTopNum> scoreTopNums1=new ArrayList<>();
            boolean flag=false;
            String myrank=null;
            for (ScoreTopNum scoreTopNum : scoreTopNums) {
                ScoreTopNum top=new ScoreTopNum();
                if(scoreTopNum.getHead()!=null&&!scoreTopNum.getHead().equals("")){
                    top.setHead(scoreTopNum.getHead());
                }else{
                    top.setHead("");
                }
                if(scoreTopNum.getScore()!=null){
                    top.setScore(scoreTopNum.getScore());
                }else{
                    top.setScore(0+"");
                }
                if(scoreTopNum.getName()!=null){
                    top.setName(scoreTopNum.getName());
                }else{
                    top.setName("");
                }
                top.setUid(scoreTopNum.getUid());
                top.setRank(scoreTopNum.getRank());
                if(scoreTopNum.getUid().equals(userId+"")){
                    flag=true;
                    myrank=scoreTopNum.getRank();
                }
                scoreTopNums1.add(top);
            }
            map.put("myRank",flag?myrank:"未上榜。");
            map.put("success",1);
            map.put("message","");
            map.put("scoreTopNums",scoreTopNums1);
        }catch (Exception e){
            e.printStackTrace();
            map.put("success",0);
            map.put("message","获取失败");
        }
        return map;
    }


    /**
     * 获取在登陆时展示的琴行上传图
     * 老师身份登录,---  多数琴行
     * 家长登录  ---   名下学生,对应老师,所属琴行 id 最小一个
     *  学生  -- 对应老师所属琴行
     * @param ctx
     * @return
     */
    public Map<String,Object> showOrgAdv(final ChannelHandlerContext ctx){
        Map<String,Object> result = new HashMap<>();
        try {
            Integer userId=ctx.channel().attr(GameWorld.userId_key).get();
            ElecPlayer player = elecPlayerMapper.selectByPrimaryKey(userId);

            if (player.getRoleType() == 1){
//                登录身份是学生
                Students students = studentsMapper.selectByPrimaryKey(player.getPlayerId());
                if (students != null || students.getTeacherId() != null){

                    Teacher teacher = teacherMapper.selectByPrimaryKey(students.getTeacherId());

                    if (teacher != null  || teacher.getBelongtoPianoShopid() != null){

                        int isFinsh = 0;     //判断所传数据是否完整
                        PianoShop pianoShop =  pianoShopMapper.selectByPrimaryKey(teacher.getBelongtoPianoShopid());
                        if (pianoShop != null && pianoShop.getHeadUrl() != null){
                            result.put("shopIconUrl",pianoShop.getHeadUrl());
                            isFinsh++;
                        }
                        if (pianoShop != null && pianoShop.getTransitionPicture() != null){
                            result.put("advUrl",pianoShop.getTransitionPicture());
                            isFinsh++;

                        }
                        if (pianoShop != null && pianoShop.getName() != null){
                            result.put("shopName",pianoShop.getName());
                            isFinsh++;

                        }
                        if (pianoShop.getBelongtoOrginazeid() != null){
                            Organization organization = organizationMapper.selectByPrimaryKey(pianoShop.getBelongtoOrginazeid());
                            if (organization != null && organization.getHeadUrl() != null){
                                result.put("orgIconUrl",organization.getHeadUrl());
                                isFinsh++;

                            }
                        }
                        if(isFinsh !=4 ){
                            result.put("suucess",0);
                            result.put("message","已老师身份获取图片失败!");
                        }else {
                            result.put("success",1);
                            result.put("message","已老师身份获取图片成功!");
                        }
                    }

                }else {
                    result.put("suucess",0);
                    result.put("message","当前用户登录身份未绑定老师!");
                    return  result;
                }

            }else if (player.getRoleType() == 2){
//                登录身份是家长      -->  学生   --->老师   --->琴行
                List<Students> studentsList = studentsMapper.selectAll(null,null,null);
                Integer stuId = -1;
                for (Students students : studentsList){
                    if (students.getParentId() == player.getPlayerId()){
                        stuId = students.getParentId() ;
                        break;
                    }
                }

                if(stuId != -1) {
                    Students students = studentsMapper.selectByPrimaryKey(player.getPlayerId());
                    if (students != null || students.getTeacherId() != null) {

                        Teacher teacher = teacherMapper.selectByPrimaryKey(students.getTeacherId());

                        if (teacher != null || teacher.getBelongtoPianoShopid() != null) {

                            int isFinsh = 0;     //判断所传数据是否完整
                            PianoShop pianoShop = pianoShopMapper.selectByPrimaryKey(teacher.getBelongtoPianoShopid());
                            if (pianoShop != null && pianoShop.getHeadUrl() != null) {
                                result.put("shopIconUrl", pianoShop.getHeadUrl());
                                isFinsh++;
                            }
                            if (pianoShop != null && pianoShop.getTransitionPicture() != null) {
                                result.put("advUrl", pianoShop.getTransitionPicture());
                                isFinsh++;

                            }
                            if (pianoShop != null && pianoShop.getName() != null) {
                                result.put("shopName", pianoShop.getName());
                                isFinsh++;

                            }
                            if (pianoShop.getBelongtoOrginazeid() != null) {
                                Organization organization = organizationMapper.selectByPrimaryKey(pianoShop.getBelongtoOrginazeid());
                                if (organization != null && organization.getHeadUrl() != null) {
                                    result.put("orgIconUrl", organization.getHeadUrl());
                                    isFinsh++;

                                }
                            }
                            if (isFinsh != 4) {
                                result.put("suucess", 0);
                                result.put("message", "已老师身份获取图片失败!");
                            } else {
                                result.put("success", 1);
                                result.put("message", "已老师身份获取图片成功!");
                            }
                        }
                    }
                }





            }else if (player.getRoleType() == 3){
//                 登录身份是老师   ---  找到对应琴行
                Teacher teacher = teacherMapper.selectByPrimaryKey(player.getPlayerId());
                if (teacher.getBelongtoPianoShopid() != null){
                    int isFinsh = 0;     //判断所传数据是否完整
                   PianoShop pianoShop =  pianoShopMapper.selectByPrimaryKey(teacher.getBelongtoPianoShopid());
                   if (pianoShop != null && pianoShop.getHeadUrl() != null){
                       result.put("shopIconUrl",pianoShop.getHeadUrl());
                       isFinsh++;
                   }
                   if (pianoShop != null && pianoShop.getTransitionPicture() != null){
                       result.put("advUrl",pianoShop.getTransitionPicture());
                       isFinsh++;

                   }
                   if (pianoShop != null && pianoShop.getName() != null){
                       result.put("shopName",pianoShop.getName());
                       isFinsh++;

                   }
                   if (pianoShop.getBelongtoOrginazeid() != null){
                       Organization organization = organizationMapper.selectByPrimaryKey(pianoShop.getBelongtoOrginazeid());
                       if (organization != null && organization.getHeadUrl() != null){
                           result.put("orgIconUrl",organization.getHeadUrl());
                           isFinsh++;

                       }
                   }
                   if(isFinsh !=4 ){
                       result.put("suucess",0);
                       result.put("message","已老师身份获取图片失败!");
                   }else {
                       result.put("success",1);
                       result.put("message","已老师身份获取图片成功!");
                    }
                }


            }else {
                result.put("suucess",0);
                result.put("message","当前用户登录身份错误!");
                return  result;
            }

        }catch (Exception e){
            e.printStackTrace();
            result.put("suucess",0);
            result.put("message","操作失败!");
        }
        return  result;

    }

    /**
     * 版本更新检查
     * @param ctx
     * @param version    前端传递版本号,根据type和db中version检查.不一样时更新版本.
     * @param type   0 android 1--ios 2--pc
     * @return
     */
    public Map<String,Object> checkVersion(final ChannelHandlerContext ctx,String version,String type){
        Map<String,Object> result = new HashMap<>();
        try {

            if (type != null){
              Version version1 =  versionMapper.selectByType(Integer.parseInt(type));
              if (version1.getVersionName().equals(version)){
                  result.put("success", 0);
                  result.put("msg", "当前版本号已经是最新的！");
              }else {
                  result.put("success", 1);
                  result.put("msg", "版本验证成功！");
                  result.put("url", version1.getVersionUrl());
              }

            }

        }catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "操作失败！");
        }
        return result;
    }
}
