package com.mmall.service;


import com.mmall.dao.*;
import com.mmall.entity.AimMusicList;
import com.mmall.model.*;
import com.mmall.service.Impl.UserService;
import com.mmall.util.MD5Util;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service("editor")
public class EditorService {

    @Autowired
    private StyleService styleService;
    @Autowired
    private StageService stageService;

    @Autowired
    private OperaService operaService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerOperaService playerOperaService;
    @Autowired
    private OperaDetailMapper operaDetailMapper;
    @Autowired
    private OperaPriceMapper operaPriceMapper;
    @Autowired
    private OperaExplainPictureMapper operaExplainPictureMapper;

    @Autowired
    private PlayerOperaMapper playerOperaMapper;

    @Autowired
    private LearnbookStageMapper learnbookStageMapper;

    @Autowired
    private LearnbookStyleMapper learnbookStyleMapper;

    @Autowired
    private DifficultySetMapper difficultySetMapper;

    @Autowired
    private SysUserMapper sysUserMapper;



    /**
     * 获取曲谱编辑信息(风格，阶段，难度)
     * @return
     */
    public Map<String,Object> getMusicEditInfo(final ChannelHandlerContext ctx){
        log.info("获取曲谱编辑信息");
        Map<String,Object> result=new HashMap<>();
        try {
            List<LearnbookStage> stages= learnbookStageMapper.selAllStage();
            List<LearnbookStyle> styles=learnbookStyleMapper.selAllStyle();
            List<DifficultySet> sets=difficultySetMapper.selAllDifficulty();

//            String[] explainPicture = new String[operaExplainPictureList.size()];
            String[] aimStyles = new String[styles.size()];
            for (int i = 0; i <styles.size() ; i++) {
                String temp = styles.get(i).getStyle();
                aimStyles[i]=temp;
            }

            String[] aimStage = new String[stages.size()];
            for (int i = 0; i <stages.size() ; i++) {
                String temp = stages.get(i).getStage();
                aimStage[i]=temp;
            }

            String[] aimSets = new String[sets.size()];
            for (int i = 0; i <sets.size() ; i++) {
                String temp = sets.get(i).getDiffityLevel()+"";
                aimSets[i]= temp;
            }

            result.put("style",aimStyles);
            result.put("difficulty",aimSets);
            result.put("stage",aimStage);
            result.put("success",1);
        }catch (Exception e){
            e.getMessage();
            result.put("success",0);
            result.put("msg","获取失败！");
        }
        log.info("结果"+result);
        return result;
    }


    /**
     * 曲谱列表
     * @param
     * @param page   第3页
     * @param num    每页7个
     * @return
     */
    public Map<String,Object> getMusicList(final ChannelHandlerContext ctx,String page,String  num){
        Map<String,Object> result=new HashMap<>();
        try {
            log.info("参数---page:"+page+"---num"+num);
            int start = (Integer.parseInt(page)-1)*Integer.parseInt(num);
            int size = Integer.parseInt(num);
            List<OperaDetail> operaDetails=operaDetailMapper.selectByStartAndSize(start,size);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<AimMusicList> aimMusicLists = new ArrayList<>();
            for (int i = 0; i <operaDetails.size() ; i++) {
                AimMusicList temp0 = new AimMusicList();

                temp0.setId(operaDetails.get(i).getId()+"");
                temp0.setName(operaDetails.get(i).getOperaName());
                if (operaDetails.get(i).getEditTime() != null)
                {
                    temp0.setTime(formatter.format(operaDetails.get(i).getEditTime()));
                }
                else{
                    temp0.setTime("");
                }
                aimMusicLists.add(temp0);
            }


            int count = operaDetailMapper.getCount();
            int pageNum = 0;
//            计算总页数
            if (count%Integer.parseInt(num) == 0){
                pageNum = count/Integer.parseInt(num);
            }else {
                pageNum = count/Integer.parseInt(num)+1;
            }
            log.info("-----pageNum----"+pageNum);
//            PageInfo pageInfo=new PageInfo(operaDetails);
            result.put("musics",aimMusicLists);
            result.put("pageNum",pageNum); //总页数
            result.put("success",1);
            result.put("msg","获取成功！");
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("msg","获取失败！");
        }
        log.info("结果"+result);
        return result;
    }

    /**
     * 曲谱详情
     * @param
     * @return
     */
    public Map<String,Object> getMusicInfo(final ChannelHandlerContext ctx,String id){
        Map<String,Object> result=new HashMap<>();
        try {
            log.info("曲谱详情"+id);
            OperaDetail operaDetail=operaService.selOperaDetail(Integer.parseInt(id));
            if(operaDetail!=null){
                result.put("musicScore",operaDetail.getMusicScore());
                result.put("music",operaDetail.getMusic());
                result.put("config",operaDetail.getProfile());
                result.put("midi",operaDetail.getMusicScoreMidi());

                result.put("msg","获取成功！");
                result.put("success",1);
            }else{
                result.put("success",0);
                result.put("msg","获取失败！");
            }
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("message","操作失败!");
        }
        return result;
    }

    /**
     * 添加曲谱
     * @return
     */
    @ResponseBody
    public Map<String,Object> setMusicNew(final ChannelHandlerContext ctx,String id,String name,String style,String  stage,
                                          String author,String isHaveIntegral, String difficulty,
                                          String price,String special,String explainPrice,String   musicIconUrl ,
                                          String explainUrl, String  vidoUrl,String musicImgUrl, String musicUrl,String  jsonFileUrl

    ){
        Map<String,Object> result =new HashMap<>();
        log.info("setMusicNew -----");
        try {
//            当是新增曲谱时
            if (Integer.parseInt(id)==-1){
                OperaDetail operaDetail = new OperaDetail();
                operaDetail.setOperaName(name);
                operaDetail.setStyle(style);
                operaDetail.setApplyStage(stage);
                operaDetail.setAuthor(author);

                operaDetail.setExplainVideo(vidoUrl);
                operaDetail.setMusicScore(musicImgUrl);
                operaDetail.setProfile(jsonFileUrl);
                operaDetail.setMusic(musicUrl);

                if (Integer.parseInt(isHaveIntegral)==1){
                    operaDetail.setIsGetScore(1);
                }else {
                    operaDetail.setIsGetScore(0);
                }
                operaDetail.setDifficulty(Integer.parseInt(difficulty));
                operaDetail.setCoverPicture(musicIconUrl);
//                operaDetail.setExplainVideo(vidoName);
//
                if (explainPrice.length()!=0){
                    operaDetail.setExplainPrice(new BigDecimal(explainPrice));
                }else {
                    operaDetail.setExplainPrice(new BigDecimal(0));
                }
                operaDetail.setCreateTime(new Date());
                operaDetail.setEditTime(new Date());
//                新增曲谱记录
                  operaDetailMapper.insertSelective(operaDetail);
                System.out.println("***************************************返回自增的id:"+operaDetail.getId());


                OperaPrice operaPrice = new OperaPrice();
                //                当传入数据不为 ""
                if (price.length()!=0) {
                    String[] aimPrice = price.split("\\-");
                    String[] temp = {"", "", ""};
                    if (aimPrice != null) {
                        for (int i = 0; i < aimPrice.length; i++) {
                            temp = aimPrice[i].split("\\|");
                            if (temp.length != 0) {

                                int year = Integer.parseInt(temp[0]);
                                int month = Integer.parseInt(temp[1]);
                                BigDecimal priceTemp = new BigDecimal(temp[2]);

                                operaPrice.setCreatetime(new Date());
                                operaPrice.setPrice(priceTemp);
                                operaPrice.setDeadline(year * 12 + month);
                                operaPrice.setOperaId(operaDetail.getId());
                                operaPrice.setIsSpecial(0);
//                  插入曲谱价格记录
                                operaPriceMapper.insertSelective(operaPrice);
                            }
                        }

                    }
                }

//                当传入数据不为 ""
                if (special.length()!=0){
                    String[] aimSpecial = special.split("\\-");
                    String[] temp = {"", "", ""};
                    if (aimSpecial!=null ){
                        for (int i = 0; i <aimSpecial.length ; i++) {
                            temp = aimSpecial[i].split("\\|");
                            if (temp.length!=0){

                                int year = Integer.parseInt(temp[0]);
                                int month = Integer.parseInt(temp[1]);
                                BigDecimal priceTemp = new BigDecimal(temp[2]);

                                operaPrice.setCreatetime(new Date());
                                operaPrice.setPrice(priceTemp);
                                operaPrice.setDeadline(year*12+month);
                                operaPrice.setOperaId(operaDetail.getId());
                                operaPrice.setIsSpecial(1);
//                  插入曲谱价格记录--特价记录
                                operaPriceMapper.insertSelective(operaPrice);
                            }

                        }
                    }
                }


                OperaExplainPicture operaExplainPicture  = new OperaExplainPicture();
                String[] aimExplainName = explainUrl.split("\\-");
                if (aimExplainName!=null){
                    for (int i = 0; i <aimExplainName.length ; i++) {
                        operaExplainPicture.setExplainPicture(aimExplainName[i]);
                        operaExplainPicture.setOperaId(operaDetail.getId());
//                    插入曲谱讲解图片
                        operaExplainPictureMapper.insertSelective(operaExplainPicture);
                    }
                }

//              返回id
                result.put("musicID",operaDetail.getId());

            }else {
//                当是更新
                OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(Integer.parseInt(id));
                operaDetail.setOperaName(name);
                operaDetail.setStyle(style);
                operaDetail.setApplyStage(stage);
                operaDetail.setAuthor(author);

                operaDetail.setExplainVideo(vidoUrl);
                operaDetail.setMusicScore(musicImgUrl);
                operaDetail.setProfile(jsonFileUrl);
                operaDetail.setMusic(musicUrl);



                if (Integer.parseInt(isHaveIntegral)==1){
                    operaDetail.setIsGetScore(1);
                }else {
                    operaDetail.setIsGetScore(0);
                }
                operaDetail.setDifficulty(Integer.parseInt(difficulty));
                operaDetail.setCoverPicture(musicIconUrl);
//                operaDetail.setCoverPicture(coverName);
//                operaDetail.setExplainVideo(vidoName);
                if (explainPrice.length()!=0){
                    operaDetail.setExplainPrice(new BigDecimal(explainPrice));

                }
//                更新曲谱记录
                operaDetail.setCreateTime(new Date());
                operaDetail.setEditTime(new Date());

                 operaDetailMapper.updateByPrimaryKey(operaDetail);

                OperaPrice operaPrice = new OperaPrice();
                if (special.length()!=0) {

                    String[] temp = {"", "", ""};
                    String[] aimPrice = price.split("\\-");

                    if (aimPrice != null) {
//                    删除该id关联的曲谱价格记录
                        operaPriceMapper.deleteByOperaId(Integer.parseInt(id));

                        for (int i = 0; i < aimPrice.length; i++) {
                            temp = aimPrice[i].split("\\|");
                            if (temp.length != 0) {
                                int year = Integer.parseInt(temp[0]);
                                int month = Integer.parseInt(temp[1]);
                                BigDecimal priceTemp = new BigDecimal(temp[2]);

                                operaPrice.setCreatetime(new Date());
                                operaPrice.setPrice(priceTemp);
                                operaPrice.setDeadline(year * 12 + month);
                                operaPrice.setIsSpecial(0);
                                operaPrice.setOperaId(operaDetail.getId());
//                  插入曲谱价格记录
                                operaPriceMapper.insertSelective(operaPrice);
                            }

                        }
                    }
                }


                if (special.length()!=0) {

                    String[] aimSpecial = special.split("\\-");
                    String[] temp = {"", "", ""};


                    if (aimSpecial != null) {
                        for (int i = 0; i < aimSpecial.length; i++) {
                            temp = aimSpecial[i].split("\\|");
                            if (temp.length != 0) {
                                int year = Integer.parseInt(temp[0]);
                                int month = Integer.parseInt(temp[1]);
                                BigDecimal priceTemp = new BigDecimal(temp[2]);

                                operaPrice.setCreatetime(new Date());
                                operaPrice.setPrice(priceTemp);
                                operaPrice.setDeadline(year * 12 + month);
                                operaPrice.setIsSpecial(1);
                                operaPrice.setOperaId(operaDetail.getId());
//                  插入曲谱价格记录--特价记录
                                operaPriceMapper.insertSelective(operaPrice);
                            }

                        }
                    }
                }


                OperaExplainPicture operaExplainPicture  = new OperaExplainPicture();
                String[] aimExplainName = explainUrl.split("\\-");

                if (aimExplainName!=null){
                    for (int i = 0; i <aimExplainName.length ; i++) {
                        operaExplainPicture.setExplainPicture(aimExplainName[i]);
                        operaExplainPicture.setOperaId(operaDetail.getId());
//                    插入曲谱讲解图片
                        operaExplainPictureMapper.insertSelective(operaExplainPicture);
                    }
                }
//                临时测试数据
                result.put("musicID",operaDetail.getId());

            }


        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("message","操作失败!");
        }
        return result;
    }

    /**
     * 删除曲谱
     * @param id
     * @return
     */
    @ResponseBody
    public Map<String,Object> deleteMusic(final ChannelHandlerContext ctx,String id){
        log.info("删除曲谱对应的id:----"+id);
        Map<String,Object> result=new HashMap<>();
        try {
            int count = playerOperaMapper.getCountByOperaId(Integer.parseInt(id));
            if(count>0){
                result.put("success",0);
                result.put("message","该曲谱已被用户购买或使用，无法删除！");
            }else{
                int  num = operaDetailMapper.deleteByPrimaryKey(Integer.parseInt(id));
                log.info(""+num);
                if(num>0){
                    result.put("success",1);
                    result.put("message","删除成功！");
                }else{
                    result.put("success",0);
                    result.put("message","删除失败！");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("message","操作失败!");
        }

        return  result;
    }


    /**
     *   通过telephone 或者  email 登录
     * @param ctx
     * @param username
     * @param password
     * @return
     */
    public Map<String,Object> login(final ChannelHandlerContext ctx,String username, String password){
        log.info("用户登录操作!");
        Map<String,Object> result = new HashMap<>();
        try {
            log.info("用户登录:   name"+username+"password;"+password);

//           通过 tele 或者email 登录   可用数据:  12345678  123456password
            SysUser sysUser = sysUserMapper.findByKeyword(username);
            String errorMsg = "";

            if (StringUtils.isBlank(username)) {
                errorMsg = "用户名不可以为空";
                result.put("success",0);
                result.put("message",errorMsg);
            } else if (StringUtils.isBlank(password)) {
                errorMsg = "密码不可以为空";
                result.put("success",0);
                result.put("message",errorMsg);
            } else if (sysUser == null) {
                errorMsg = "查询不到指定的用户";
                result.put("success",0);
                result.put("message",errorMsg);
            } else if (!sysUser.getPassword().equals(MD5Util.encrypt(password))) {
                errorMsg = "用户名或密码错误";
                result.put("success",0);
                result.put("message",errorMsg);
            } else if (sysUser.getStatus() != 1) {
                errorMsg = "用户已被冻结，请联系管理员";
                result.put("success",0);
                result.put("message",errorMsg);
            } else {

                // log.info(sysUser.getUsername() + "登陆成功");
                log.info("登录成功!");
                result.put("success",1);
                result.put("message","操作成功!");
            }



        }catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("message","操作失败!");
        }
//        String username= request.getParameter("id");
//        String psw=request.getParameter("pass");
//        log.info("登陆"+username+""+psw);
//        LayUIResult layUIResult=userService.userLogin(username,psw);
//        log.info("结果"+layUIResult);
        return result;
    }

    /**
     *   获取谱曲上传时文件信息
     * @param ctx
     * @param id
     * @return
     */
    public Map<String,Object> getMusicUploadInfo(final  ChannelHandlerContext ctx,String id){
        log.info("获取曲谱文件信息!");
        Map<String ,Object> result = new HashMap<>();
        try {

            log.info("获取谱曲上传时文件信息  id--"+id);
            OperaDetail operaDetail=operaService.selOperaDetail(Integer.parseInt(id));
            if(operaDetail!=null){


                result.put("id",id);
                result.put("name",operaDetail.getOperaName());
                result.put("style",operaDetail.getStyle());
                result.put("stage",operaDetail.getApplyStage());
                result.put("author",operaDetail.getAuthor());
                result.put("isHaveIntegral",operaDetail.getIsGetScore());
                result.put("difficulty",operaDetail.getDifficulty());

                //                获取曲谱价格
                List<OperaPrice> operaPriceList = operaPriceMapper.selectByOperaId(Integer.parseInt(id));
                String[] operaPirce = new String[operaPriceList.size()];
                for (int i = 0; i <operaPriceList.size() ; i++) {
                    String temp = "0|"+operaPriceList.get(i).getDeadline()+"|"+operaPriceList.get(i).getPrice();
                    operaPirce[i]= temp;
                }
                log.info("-----曲谱价格:----"+operaPirce);
                result.put("price",operaPirce);
                result.put("coverUrl",operaDetail.getCoverPicture());

                //                获取曲谱特价
                List<OperaPrice> operaSpecialPriceList = operaPriceMapper.selectByOperaIdAndIsSpecial(Integer.parseInt(id),1);
                String[] operaSpecialPirce = new String[operaPriceList.size()];
                for (int i = 0; i <operaSpecialPriceList.size() ; i++) {
                    String temp = "0|"+operaSpecialPriceList.get(i).getDeadline()+"|"+operaSpecialPriceList.get(i).getPrice();
                    operaSpecialPirce[i]= temp;
                }

                result.put("special",operaSpecialPirce);
                //                获取曲谱讲解图片
                List<OperaExplainPicture> operaExplainPictureList = operaExplainPictureMapper.selectByOperaId(Integer.parseInt(id));
                String[] explainPicture = new String[operaExplainPictureList.size()];
                for (int i = 0; i <operaExplainPictureList.size() ; i++) {
                    String temp = operaExplainPictureList.get(i).getExplainPicture();
                    explainPicture[i] = temp;
                }
                result.put("explainUrl",explainPicture);
                result.put("vidoName",operaDetail.getExplainVideo());
                log.info("explainPrice---------"+operaDetail.getExplainPrice());
                result.put("explainPrice",operaDetail.getExplainPrice());



                result.put("msg","获取成功！");
                result.put("success",1);
//                result.put("data",operaDetail);
            }else{
                result.put("success",0);
                result.put("msg","获取失败！");
            }
        } catch (Exception e){
            e.printStackTrace();
            result.put("success",0);
            result.put("message","操作失败!");
        }
        return  result;
    }

}
