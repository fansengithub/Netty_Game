package com.mmall.service.socket;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.Object.GameWorld;
import com.mmall.dao.*;
import com.mmall.entity.*;
import com.mmall.model.*;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 在线课堂
 */
@Slf4j
@Service("o")
public class OnlineClass {

    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private CmsAdverMapper cmsAdverMapper;
    @Autowired
    private PlayerOperaMapper playerOperaMapper;
    @Autowired
    private OrganizationTextbookMapper organizationTextbookMapper;
    @Autowired
    private OperaOwnerMapper operaOwnerMapper;
    @Autowired
    private OperaCalssifyMapper operaCalssifyMapper;
    @Autowired
    private OperaDetailMapper operaDetailMapper;
    @Autowired
    private OperaPriceMapper operaPriceMapper;
    @Autowired
    private ElecPlayerMapper elecPlayerMapper;
    @Autowired
    private PianoShopMapper pianoShopMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentsMapper studentsMapper;

    /**
     * 打开在线课堂的首界面
     *
     * @return
     */
    public Map<String, Object> onLineClass(final ChannelHandlerContext ctx,String page,String size) {
        log.info("打开在线课堂的首界面");
        Map<String, Object> result = new HashMap<>();
        try {
//            获取全部机构数
            List<Organization> organizationList = new ArrayList<>();
            PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
            organizationList = organizationMapper.selectAll(null, null, null);

            PageInfo pageInfo = new PageInfo(organizationList);
            if(pageInfo.isIsLastPage()){
                result.put("isLastPage",0);
            }else{
                result.put("isLastPage",1);
            }

            List<Company> aimCompany = new ArrayList<>();
            for (Organization temp : organizationList) {

                if (temp != null) {
                    Company company = new Company();
                    if (temp.getHeadUrl() != null) {
                        company.setUrl(temp.getHeadUrl());
                    } else {
//                        返回空字符串
                        company.setUrl("");
                    }
                    company.setId(temp.getId());
                    aimCompany.add(company);
                }
            }

//            获取打开界面的教材  <根据教材下面曲谱的下载量,取前3个>
            List<LearnbookDetail> learnbookDetailList = learnbookDetailMapper.getTop3();
            List<AimLearnBook> aimLearnBookList = new ArrayList<>();
            for (LearnbookDetail temp : learnbookDetailList) {
                if (temp != null) {
                    AimLearnBook aimLearnBook = new AimLearnBook();
                    aimLearnBook.setId(temp.getId());
                    if (temp.getCoverPicture() != null) {
                        aimLearnBook.setUrl(temp.getCoverPicture());
                    } else {
                        aimLearnBook.setUrl("");
                    }

                    aimLearnBookList.add(aimLearnBook);

                }
            }

            result.put("bookList", aimLearnBookList);
            result.put("companyList", aimCompany);
            result.put("success", 1);
            result.put("msg", "获取成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "获取失败！");
        }
        log.info("结果" + result);
        return result;
    }

    /**
     * 获取某机构详情
     *
     * @param ctx id  --- 3
     * @return
     */
    public Map<String, Object> getDetailCompany(final ChannelHandlerContext ctx, String id,String page,String size) {
        log.info("获取某机构详情");
        Map<String, Object> result = new HashMap<>();
        try {
            Organization temp = organizationMapper.selectByPrimaryKey(Integer.parseInt(id));

            //            获取机构对应的教材  --  目前没有关联多表
            PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
            List<LearnbookDetail> learnbookDetailList = learnbookDetailMapper.selAllLearnBook("");

            PageInfo pageInfo = new PageInfo(learnbookDetailList);
            if(pageInfo.isIsLastPage()){
                result.put("isLastPage",0);
            }else{
                result.put("isLastPage",1);
            }

            List<AimLearnBook> aimLearnBookList = new ArrayList<>();
            for (LearnbookDetail temp1 : learnbookDetailList) {
                if (temp1 != null) {
                    AimLearnBook aimLearnBook = new AimLearnBook();
                    aimLearnBook.setUrl(temp1.getCoverPicture());
                    aimLearnBook.setId(temp1.getId());
                    aimLearnBook.setName(temp1.getName());
                    aimLearnBook.setSummary(temp1.getSummary());
                    aimLearnBook.setAuthor(temp1.getAuthor());
                    aimLearnBookList.add(aimLearnBook);

                }
            }

            int bookNum = organizationTextbookMapper.getCountByOrganizationId(Integer.parseInt(id));


            result.put("name", temp.getOrganizeName());
            result.put("desc", temp.getOrganizeScope());
            result.put("opern", temp.getOperabookNum());
            result.put("bookNum", temp.getOperabookNum());
            result.put("bookList", aimLearnBookList);
            result.put("url", temp.getHeadUrl());
//            result.put("organization",temp);
            result.put("success", 1);
            result.put("msg", "获取成功！");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "获取失败！");
        }
        log.info("结果" + result);
        return result;
    }

    /**
     * 获取所有机构
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getAllCompany(final ChannelHandlerContext ctx,String page,String size) {
        log.info("打开在线课堂的首界面");
        Map<String, Object> result = new HashMap<>();
        try {
            //            获取全部机构数
            List<Organization> organizationList = new ArrayList<>();

            PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
            organizationList = organizationMapper.selectAll(null, null, null);
            PageInfo pageInfo = new PageInfo(organizationList);
            if(pageInfo.isIsLastPage()){
                result.put("isLastPage",0);
            }else{
                result.put("isLastPage",1);
            }

            List<Company> aimCompany = new ArrayList<>();
            for (Organization temp : organizationList) {

                if (temp != null) {
                    Company company = new Company();
                    company.setId(temp.getId());
                    if (temp.getHeadUrl() != null) {
                        company.setUrl(temp.getHeadUrl());
                    } else {
//                        返回空字符串
                        company.setUrl("");
                    }
                    aimCompany.add(company);
                }
            }

//            获取机构对应的教材  --  目前没有关联多表
            List<LearnbookDetail> learnbookDetailList = learnbookDetailMapper.getTop3();

//            result.put("bookList",learnbookDetailList);
            result.put("companyList", aimCompany);
            result.put("success", 1);
            result.put("msg", "获取成功！");

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "获取失败！");
        }
        log.info("结果" + result);
        return result;
    }

    /**
     * 点击教材库
     *
     * @param ctx
     * @param type 1--推荐  2--作者  3--教材  type --- 3
     * @return
     */
    public Map<String, Object> getBookStroehourse(final ChannelHandlerContext ctx, String type ,String page,String size) {
        log.info("打开在线课堂的首界面");
        Map<String, Object> result = new HashMap<>();
        try {
            List<LearnbookDetail> temp = new ArrayList<>();
            if (Integer.parseInt(type) == 1) {
//                    查找推荐教材
                temp = learnbookDetailMapper.selectByRecommend();
            } else if (Integer.parseInt(type) == 2) {
                //          查找作者教材
                temp = learnbookDetailMapper.selectByAuthor();
            } else if (Integer.parseInt(type) == 3) {
//                    查找所有教材
                temp = learnbookDetailMapper.selAllLearnBook("");
            }

            PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
            List<AimLearnBook> aimLearnBookList = new ArrayList<>();
            PageInfo pageInfo = new PageInfo(aimLearnBookList);
            if(pageInfo.isIsLastPage()){
                result.put("isLastPage",0);
            }else{
                result.put("isLastPage",1);
            }

            for (LearnbookDetail temp1 : temp) {
                if (temp1 != null) {
                    AimLearnBook aimLearnBook = new AimLearnBook();
                    aimLearnBook.setUrl(temp1.getCoverPicture());
                    aimLearnBook.setId(temp1.getId());
                    aimLearnBook.setName(temp1.getName());
                    aimLearnBook.setAuthor(temp1.getAuthor());
                    aimLearnBook.setSummary(temp1.getSummary());
                    aimLearnBookList.add(aimLearnBook);

                }
            }

            result.put("bookList", aimLearnBookList);
//               所有教材库轮播广告图
            List<CmsAdver> cmsAdverList = cmsAdverMapper.selectByColunmName(2);
            List<AimADS> aimADSList = new ArrayList<>();
            if (cmsAdverList.size() > 0) {
                cmsAdverList.forEach((CmsAdver cmsAdver) -> {
                    AimADS aimADS = new AimADS();
                    aimADS.setCoverPicture(cmsAdver.getCoverPicture());
                    aimADS.setTextContent(cmsAdver.getTextContent());
                    if (cmsAdver.getColumnType() == null || "".equals(cmsAdver.getColumnType())) {
                        aimADS.setType(1 + "");
                    } else if (cmsAdver.getColumnType() == 1) {
//                        广告内容为教材时
                        aimADS.setType(5 + "");
                    } else if (cmsAdver.getColumnType() == 2) {
//                         内容为曲谱时
                        aimADS.setType(6 + "");
                    } else if (cmsAdver.getColumnType() == 3) {
//                         内容为广告时
                        aimADS.setType(3 + "");
                    } else if (cmsAdver.getColumnType() == 4) {
//                         内容为文本时
                        aimADS.setType(4 + "");
                    }

                    aimADSList.add(aimADS);
                });
                result.put("adList", aimADSList);

//                result.put("adList", cmsAdverList);
            } else {
                log.info("所有教材库轮播广告图获取失败!");
                result.put("success", 0);
                result.put("msg", "获取失败!");
                return result;
            }


            result.put("success", 1);
            result.put("msg", "获取成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "获取失败!");

        }
        return result;
    }

    /**
     * 获取教材详情
     *
     * @param ctx
     * @param id  教材id   -- 4
     * @return
     */
    public Map<String, Object> getDetailBook(final ChannelHandlerContext ctx, String id,String page,String size) {
        log.info("获取教材详情!");
        Map<String, Object> result = new HashMap<>();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd ");
        try {

//                获取id对应的教材详细信息
            LearnbookDetail learnbookDetail = learnbookDetailMapper.selectByPrimaryKey(Integer.parseInt(id));


            AimLearnBook aimLearnBook = new AimLearnBook();
            aimLearnBook.setId(learnbookDetail.getId());
            aimLearnBook.setUrl(learnbookDetail.getCoverPicture());
            aimLearnBook.setSummary(learnbookDetail.getSummary());
            aimLearnBook.setAuthor(learnbookDetail.getAuthor());
            aimLearnBook.setName(learnbookDetail.getName());

//                result.put("book",aimLearnBook);
            result.put("id", aimLearnBook.getId());
            result.put("url", aimLearnBook.getUrl());
            result.put("name", aimLearnBook.getName());
            result.put("author", aimLearnBook.getAuthor());
            result.put("summary", aimLearnBook.getSummary());

//                新增需求:当前教材下面所有曲谱
            PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
            List<OperaDetail> operaDetailList = operaDetailMapper.selectByLearnbookId(Integer.parseInt(id));
            PageInfo pageInfo = new PageInfo(operaDetailList);
            if(pageInfo.isIsLastPage()){
                result.put("isLastPage",0);
            }else{
                result.put("isLastPage",1);
            }

            List<AimOwnerOpera> aimOwnerOperaList = new ArrayList<>();
            for (OperaDetail temp : operaDetailList) {
                AimOwnerOpera aimOwnerOpera = new AimOwnerOpera();
                aimOwnerOpera.setName(temp.getOperaName());
                aimOwnerOpera.setAuthor(temp.getAuthor());
                aimOwnerOpera.setId(temp.getId() + "");
                OperaOwner operaOwner = operaOwnerMapper.selectByOperaId(temp.getId());
                if (operaOwner != null) {
//                        到期时间
                    aimOwnerOpera.setLimitTime(formatter.format(operaOwner.getExpiryTime()));
                } else {

//                        表示没有购买
                    aimOwnerOpera.setLimitTime("-1");
                }
//                    查询当前曲谱是否为免费的
                OperaPrice operaPriceFree = operaPriceMapper.selectIsFree(temp.getId());
                if (operaPriceFree != null) {
                    aimOwnerOpera.setLimitTime("-2");     //标记为免费曲谱
                }

//                    查询曲谱原价
                List<OperaPrice> operaPriceList = operaPriceMapper.selectByOperaIdAndIsSpecial(temp.getId(), 0);
//                    有待完善
                // 分别获取所有原价
                if (operaPriceList.size() > 0) {
                    BigDecimal aimPrice = operaPriceList.get(0).getPrice();
                    for (OperaPrice operaPrice : operaPriceList) {
//                            比较大小,找出最小的值
                        if (operaPrice.getPrice().compareTo(aimPrice) == -1) {
                            aimPrice = operaPrice.getPrice();
                        }
                    }
                    aimOwnerOpera.setPrice(aimPrice + "");
                    log.info("");
                }

//                    查询所有特价
                operaPriceList = operaPriceMapper.selectByOperaIdAndIsSpecial(temp.getId(), 1);
                if (operaPriceList.size() > 0) {
                    BigDecimal aimPrice = operaPriceList.get(0).getPrice();
                    for (OperaPrice operaPrice : operaPriceList) {
                        if (operaPrice.getPrice().compareTo(aimPrice) == -1) {
                            aimPrice = operaPrice.getPrice();
                        }
                    }
                    aimOwnerOpera.setDiscountPrice(aimPrice + "");
                }


                aimOwnerOperaList.add(aimOwnerOpera);
            }

            result.put("ownOpen", aimOwnerOperaList);
            result.put("success", 1);
            result.put("msg", "获取成功！");
        } catch (Exception e) {
            e.printStackTrace();
            result.clear();   //出现异常时,清理result中信息
            result.put("success", 0);
            result.put("msg", "获取失败!");
        }

        log.info("result:---" + result);
        return result;
    }


    /**
     * * 获取自己的曲谱
     *
     * @param ctx
     * @param type -1  -- 代表获取全部曲谱
     * @return
     */
    public Map<String, Object> getOwnOpera(final ChannelHandlerContext ctx, String type,String page,String size) {
        Map<String, Object> result = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            log.info("获取自己的曲谱:--type" + type);
//                Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
//                log.info("userId"+userId);
//                BaseUser user = (BaseUser) GameWorld.userList.get(userId);
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("--userId--" + userId);
//            eleplayer表中通过id--->player-Id
            ElecPlayer temp1 = elecPlayerMapper.selectByPrimaryKey(userId);
            if (type.equals("-1")) {
//                    显示所有曲谱

                PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                List<OperaOwner> temp = operaOwnerMapper.getAllByUserId(temp1.getPlayerId());
                PageInfo pageInfo = new PageInfo(temp);
                if(pageInfo.isIsLastPage()){
                    result.put("isLastPage",0);
                }else{
                    result.put("isLastPage",1);
                }


                List<AimOwnerOpera> aimOwnerOperaList = new ArrayList<>();
                if (temp.size() > 0) {
                    for (OperaOwner operaOwner : temp) {
                        if (operaOwner != null) {
                            AimOwnerOpera aimOwnerOpera = new AimOwnerOpera();
                            if (operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()) != null) {
                                aimOwnerOpera.setName(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getOperaName());
                                aimOwnerOpera.setAuthor(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getAuthor());
                                aimOwnerOpera.setLimitTime(formatter.format(operaOwner.getExpiryTime()));
//                                分别获取曲谱ID 和 分类 id

//                                获取分类id
                                aimOwnerOpera.setTypeID(operaOwner.getClassifyId() + "");
                                aimOwnerOpera.setId(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getId() + "");
                            }

                            aimOwnerOperaList.add(aimOwnerOpera);
                        }
                    }
                    result.put("ownOpen", aimOwnerOperaList);
                    result.put("success", 1);
                    result.put("msg", "获取成功!");
                } else {
                    result.put("ownOpen", "当前用户曲谱为空!");
                    result.put("success", 0);
                    result.put("msg", "获取失败!");
                }

            } else {
//                    通过分类id查询当前用户所拥有的曲谱数
                PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                List<OperaOwner> operaOwnerList = operaOwnerMapper.selectByClassifyIdAndUserId(Integer.parseInt(type), temp1.getPlayerId());
                PageInfo pageInfo = new PageInfo(operaOwnerList);
                if(pageInfo.isIsLastPage()){
                    result.put("isLastPage",0);
                }else{
                    result.put("isLastPage",1);
                }


                List<AimOwnerOpera> aimOwnerOperaList = new ArrayList<>();
//                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                if (operaOwnerList.size() > 0) {
                    for (OperaOwner operaOwner : operaOwnerList) {
                        AimOwnerOpera aimOwnerOpera = new AimOwnerOpera();

                        if (operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()) != null) {
                            aimOwnerOpera.setAuthor(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getAuthor());
                            aimOwnerOpera.setName(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getOperaName());
                            aimOwnerOpera.setLimitTime(formatter.format(operaOwner.getExpiryTime()));
//                                分别获取曲谱ID 和 分类 id

                            aimOwnerOpera.setTypeID(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getClassfiyId() + "");
                            aimOwnerOpera.setId(operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId()).getId() + "");
                        }

                        aimOwnerOperaList.add(aimOwnerOpera);

                    }

                    result.put("ownOpen", aimOwnerOperaList);
                    result.put("ownOpen", aimOwnerOperaList);
                    result.put("success", 1);
                    result.put("msg", "获取成功!");
                } else {
                    result.put("ownOpen", "当前分类下曲谱为空!");
                    result.put("success", 0);
                    result.put("msg", "获取失败!");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "获取失败!");
        }
        return result;
    }

    /**
     * 修改分类
     *
     * @param ctx
     * @param delete 删除的分类  分类Id|分类Id  多个|分割
     * @param add    增加的分类  分类名|分类名       多个|分割
     * @param update 修改的分类名  分类ID:分类名  多个|分割
     *               [--分类名称不能重复
     *               --分类下面有曲谱时不能删除]
     * @return
     */
    public Map<String, Object> updateKind(final ChannelHandlerContext ctx, String delete, String add, String update) {
        Map<String, Object> result = new HashMap<>();
        try {
            int is_success = 1;    //  判断最终是否成功!    0--操作失败
            if (!delete.equals("")) {
//                删除分类不为空时
                String[] aimKind = delete.split("\\|");
                for (String aimID : aimKind) {
                    log.info("删除分类:---id:" + aimID);
                    OperaCalssify temp = operaCalssifyMapper.selectByPrimaryKey(Integer.parseInt(aimID));
                    if (operaOwnerMapper.getAllByClassifyId(temp.getId()).size() > 0) {
                        //            判断该分类下是否有曲谱
                        log.info("当前分类下级存在曲谱!删除失败!");
                        result.put("success", 0);
                        result.put("msg", "当前分类下级存在曲谱!");
                        is_success = 0;
                    } else if (operaCalssifyMapper.selectByPrimaryKey(Integer.parseInt(aimID)) != null) {
//                        判断数据库中是否存在该记录
                        OperaCalssify temp1 = operaCalssifyMapper.selectByPrimaryKey(Integer.parseInt(aimID));
                        temp1.setIsDelete(1);
                        int num = operaCalssifyMapper.updateByPrimaryKeySelective(temp1);

                        if (num != 0) {
                            result.put("success", 1);
                            result.put("msg", "操作成功!");
                        } else {
                            result.put("success", 0);
                            result.put("msg", "操作失败!");
                            is_success = 0;

                        }

                    } else {
                        result.put("success", 0);
                        result.put("msg", "当前分类不存在!");
                        is_success = 0;
                    }
                }
            }
            if (!add.equals("")) {
//         增加分类不为空时
                String[] aimkind = add.split("\\|");
                for (String aimName : aimkind) {
                    log.info("新增分类:---name" + aimName);
                    if (operaCalssifyMapper.getCountByClassifyName(aimName) != 0) {
                        log.info("当前分类名称已经存在!");
//                数据库中存在时--该分类时
                        result.put("success", 0);
                        result.put("msg", "当前分类名称已经存在!");
                        is_success = 0;
                    } else {
                        OperaCalssify operaCalssify = new OperaCalssify();
                        operaCalssify.setClassifyName(aimName);
                        operaCalssifyMapper.insertSelective(operaCalssify);
                        result.put("success", 1);
                        result.put("msg", "添加分类成功!");
                    }
                }
            }
            if (!update.equals("")) {
//                  修改分类不为空时    ----   分类ID:分类名
                String[] aimObject = update.split("\\|");
                for (String aim : aimObject) {
//                    分别获取 id 和 name
                    String[] updateObject = aim.split("\\:");
                    String aimId = updateObject[0];
                    String aimName = updateObject[1];

                    OperaCalssify calssify = operaCalssifyMapper.selectByPrimaryKey(Integer.parseInt(aimId));
                    if (calssify.getIsDelete() == 1) {
                        log.info("该条记录已经被删除!");
                        is_success = 0;
                    } else {
                        calssify.setClassifyName(aimName);
                        operaCalssifyMapper.updateByPrimaryKeySelective(calssify);
                        result.put("success", 1);
                        result.put("msg", "操作成功!");
                    }

                }
            }
            if (is_success == 0) {
//                当有错误发生时
                result.put("success", 0);
                result.put("msg", "操作失败!");

            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "操作失败!");
        }
        return result;
    }

    /**
     * 获取所有分类
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getAllKind(final ChannelHandlerContext ctx) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<OperaCalssify> operaCalssifyList = operaCalssifyMapper.getAllRecordAvailable();
            result.put("allKind", operaCalssifyList);
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
     * * 把谱曲添加到某个分类下面
     *
     * @param ctx
     * @param operaid 曲谱id
     * @param kindID  分类id  -1 表示将曲谱从分类中移除
     * @return
     */
    public Map<String, Object> addOperaKind(final ChannelHandlerContext ctx, String operaid, String kindID) {
        Map<String, Object> result = new HashMap<>();
        try {
            if (kindID.equals("-1")) {
//              将曲谱从分类中删除
//                operaOwnerMapper.selectByClassifyIdAndUserId("",);
//                OperaCalssify temp = operaCalssifyMapper.selectByClassifyName(kindname);
                OperaOwner operaOwner = operaOwnerMapper.selectByOperaId(Integer.parseInt(operaid));

//                进行判断

                if (operaOwner.getClassifyId() != -1) {
                    //              将曲谱从分类中移除
                    operaOwner.setClassifyId(-1);
                    operaOwnerMapper.updateByPrimaryKeySelective(operaOwner);

                    result.put("success", 1);
                    result.put("msg", "操作成功!");
                }
            } else {
//                将曲谱添加到某个分类下面
                OperaCalssify temp = operaCalssifyMapper.selectByPrimaryKey(Integer.parseInt(kindID));
                OperaOwner operaOwner = operaOwnerMapper.selectByOperaId(Integer.parseInt(operaid));
                if (temp != null) {
                    operaOwner.setClassifyId(temp.getId());
                    operaOwnerMapper.updateByPrimaryKeySelective(operaOwner);

                    result.put("success", 1);
                    result.put("msg", "操作成功!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "操作失败!");
        }
        return result;
    }

    /**
     * 大厅获取所有广告
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getAllAdv(final ChannelHandlerContext ctx) {
        Map<String, Object> result = new HashMap<>();
        try {

//            获取首页轮播广告图
            List<CmsAdver> cmsAdverList = cmsAdverMapper.selectByColunmName(1);
            if (cmsAdverList.size() > 0) {
                List<AimADS> aimADSList = new ArrayList<>();

                cmsAdverList.forEach((CmsAdver cmsAdver) -> {
                    AimADS aimADS = new AimADS();
                    aimADS.setCoverPicture(cmsAdver.getCoverPicture());
                    aimADS.setTextContent(cmsAdver.getTextContent());
                    if (cmsAdver.getColumnType() == null || "".equals(cmsAdver.getColumnType())) {
                        aimADS.setType(1 + "");
                    } else if (cmsAdver.getColumnType() == 1) {
//                        广告内容为教材时
                        aimADS.setType(5 + "");
                    } else if (cmsAdver.getColumnType() == 2) {
//                         内容为曲谱时
                        aimADS.setType(6 + "");
                    } else if (cmsAdver.getColumnType() == 3) {
//                         内容为广告时
                        aimADS.setType(3 + "");
                    } else if (cmsAdver.getColumnType() == 4) {
//                         内容为文本时
                        aimADS.setType(4 + "");
                    }

                    aimADSList.add(aimADS);
                });


                result.put("adListTop", aimADSList);
            } else {
                log.info("所有教材库轮播广告图获取失败!");
                result.put("success", 0);
                result.put("msg", "获取失败!");
                return result;
            }


            //            获取首页轮播广告图
            List<CmsAdver> cmsAdverList1 = cmsAdverMapper.selAllCMSbyType("", 2);
            if (cmsAdverList1.size() > 0) {
                List<AimADS> aimADSList = new ArrayList<>();

                cmsAdverList1.forEach((CmsAdver cmsAdver) -> {
                    AimADS aimADS = new AimADS();
                    aimADS.setCoverPicture(cmsAdver.getCoverPicture());
                    aimADS.setTextContent(cmsAdver.getTextContent());
                    if (cmsAdver.getColumnType() == null || "".equals(cmsAdver.getColumnType())) {
                        aimADS.setType(1 + "");
                    } else if (cmsAdver.getColumnType() == 1) {
//                        广告内容为教材时
                        aimADS.setType(5 + "");
                    } else if (cmsAdver.getColumnType() == 2) {
//                         内容为曲谱时
                        aimADS.setType(6 + "");
                    } else if (cmsAdver.getColumnType() == 3) {
//                         内容为广告时
                        aimADS.setType(3 + "");
                    } else if (cmsAdver.getColumnType() == 4) {
//                         内容为文本时
                        aimADS.setType(4 + "");
                    }

                    aimADSList.add(aimADS);
                });


                result.put("adListButtom", aimADSList);
            } else {
                log.info("所有教材库轮播广告图获取失败!");
                result.put("success", 0);
                result.put("msg", "获取失败!");
                return result;
            }

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
     * 获取我的教材(老师和学生身份使用)
     *
     * @param ctx
     * @return
     */
    public Map<String, Object> getMyOwnBooks(final ChannelHandlerContext ctx,String page,String size) {
        Map<String, Object> result = new HashMap<>();
        try {
            Integer userId = ctx.channel().attr(GameWorld.userId_key).get();
            log.info("--userId--" + userId);
//            eleplayer表中通过id--->player-Id
            ElecPlayer elecPlayer = elecPlayerMapper.selectByPrimaryKey(userId);
            List<AimBook> aimBookList = new ArrayList<>();
            List<AimBook> aimBookList1 = new ArrayList<>();

            if (elecPlayer.getRoleType() == 3) {
//                登录用户的身份是老师的时候  ---  查找琴行所拥有教材
                Teacher teacher = teacherMapper.selectByPrimaryKey(elecPlayer.getPlayerId());
                if (teacher != null && teacher.getBelongtoPianoShopid() != null) {
                    PianoShop pianoShop = pianoShopMapper.selectByPrimaryKey(teacher.getBelongtoPianoShopid());

                    PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
//                    寻找learbook和pianshop的对应关系
                    List<LearnbookDetail> learnbookDetailList = learnbookDetailMapper.selAllLearnBook("");
                    PageInfo pageInfo = new PageInfo(learnbookDetailList);
                    if(pageInfo.isIsLastPage()){
                        result.put("isOtherLastPage",0);
                    }else{
                        result.put("isOtherLastPage",1);
                    }

                    learnbookDetailList.forEach((LearnbookDetail learnbookDetail) -> {
                        if (learnbookDetail.getPianoshopRole() != null) {
                            String[] aim = learnbookDetail.getPianoshopRole().split("\\|");
                            for (String aimId : aim) {
                                if (Integer.parseInt(aimId) == pianoShop.getId()) {
//                                      确定learnbook 对应某一pianoshop时

                                    AimBook aimBook = new AimBook();
                                    aimBook.setAuthor(learnbookDetail.getAuthor());
                                    aimBook.setId(learnbookDetail.getId() + "");
                                    aimBook.setName(learnbookDetail.getName());
                                    aimBook.setUrl(learnbookDetail.getCoverPicture());
                                    aimBook.setSummary(learnbookDetail.getSummary());

                                    aimBookList.add(aimBook);
                                }
                            }
                        }
                    });

                    result.put("bookListOther", aimBookList);

//                    确定我的曲谱和教材关系
//                    找到当前老师的曲谱
                    PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                    List<OperaOwner> operaOwnerList = operaOwnerMapper.getAllByUserId(elecPlayer.getId());
                     pageInfo = new PageInfo(operaOwnerList);

                    if(pageInfo.isIsLastPage()){
                        result.put("isMineLastPage",0);
                    }else{
                        result.put("isMineLastPage",1);
                    }


                    if (operaOwnerList.size() > 0) {
                        operaOwnerList.forEach((OperaOwner operaOwner) -> {
                            if (operaOwner.getOperaId() != null) {
//                                由曲谱找到教材
                                OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId());

                                if (operaDetail.getLearnbookId() != null) {
                                    LearnbookDetail learnbookDetail = learnbookDetailMapper.selectByPrimaryKey(operaDetail.getLearnbookId());
                                    if (learnbookDetail != null) {

                                        AimBook aimBook = new AimBook();
                                        aimBook.setAuthor(learnbookDetail.getAuthor());
                                        aimBook.setId(learnbookDetail.getId() + "");
                                        aimBook.setName(learnbookDetail.getName());
                                        if (learnbookDetail.getCoverPicture() != null) {
                                            aimBook.setUrl(learnbookDetail.getCoverPicture());
                                        }
                                        aimBook.setSummary(learnbookDetail.getSummary());

                                        aimBookList1.add(aimBook);
                                    }
                                }
                            }
                        });
                    }
                    result.put("bookListMine", aimBookList1);

                }


            } else if (elecPlayer.getRoleType() == 1) {
//                  登录用户是学生   ---  查找所属老师的所有教材
                Students students = studentsMapper.selectByPrimaryKey(userId);


                if (students.getTeacherId() != null) {
                    PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));

                    List<OperaOwner> operaOwnerList = operaOwnerMapper.getAllByUserId(students.getTeacherId());
                    PageInfo pageInfo = new PageInfo(operaOwnerList);
                    if(pageInfo.isIsLastPage()){
                        result.put("isOtherLastPage",0);
                    }else{
                        result.put("isOtherLastPage",1);
                    }

                    if (operaOwnerList.size() > 0) {
                        operaOwnerList.forEach((OperaOwner operaOwner) -> {
                            if (operaOwner.getOperaId() != null) {
//                                由曲谱找到教材
                                OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId());

                                if (operaDetail.getLearnbookId() != null) {
                                    LearnbookDetail learnbookDetail = learnbookDetailMapper.selectByPrimaryKey(operaDetail.getLearnbookId());
                                    if (learnbookDetail != null) {

                                        AimBook aimBook = new AimBook();
                                        aimBook.setAuthor(learnbookDetail.getAuthor());
                                        aimBook.setId(learnbookDetail.getId() + "");
                                        aimBook.setName(learnbookDetail.getName());
                                        if (learnbookDetail.getCoverPicture() != null) {
                                            aimBook.setUrl(learnbookDetail.getCoverPicture());
                                        }
                                        aimBook.setSummary(learnbookDetail.getSummary());
                                        aimBookList.add(aimBook);
                                    }
                                }
                            }
                        });
                    }
                }
                result.put("bookListOther", aimBookList);

                PageHelper.startPage(Integer.parseInt(page),Integer.parseInt(size));
                List<OperaOwner> operaOwnerList = operaOwnerMapper.getAllByUserId(elecPlayer.getId());
                PageInfo pageInfo = new PageInfo(operaOwnerList);

                if(pageInfo.isIsLastPage()){
                    result.put("isMineLastPage",0);
                }else{
                    result.put("isMineLastPage",1);
                }


                if (operaOwnerList.size() > 0) {
                    operaOwnerList.forEach((OperaOwner operaOwner) -> {
                        if (operaOwner.getOperaId() != null) {
//                                由曲谱找到教材
                            OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(operaOwner.getOperaId());

                            if (operaDetail.getLearnbookId() != null) {
                                LearnbookDetail learnbookDetail = learnbookDetailMapper.selectByPrimaryKey(operaDetail.getLearnbookId());
                                if (learnbookDetail != null) {

                                    AimBook aimBook = new AimBook();
                                    aimBook.setAuthor(learnbookDetail.getAuthor());
                                    aimBook.setId(learnbookDetail.getId() + "");
                                    aimBook.setName(learnbookDetail.getName());
                                    if (learnbookDetail.getCoverPicture() != null) {
                                        aimBook.setUrl(learnbookDetail.getCoverPicture());
                                    }
                                    aimBook.setSummary(learnbookDetail.getSummary());

                                    aimBookList1.add(aimBook);
                                }
                            }
                        }
                    });
                }
                result.put("bookListMine", aimBookList1);

            }

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
     * 获取某一个曲谱以及曲谱所属的教材信息
     *
     * @param ctx
     * @param id
     * @return
     */
    public Map<String, Object> getOneOpern(final ChannelHandlerContext ctx, String id) {
        Map<String, Object> result = new HashMap<>();
        try {
            OperaDetail operaDetail = operaDetailMapper.selectByPrimaryKey(Integer.parseInt(id));
            List<AimOpera> aimOperaList = new ArrayList<>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            if (operaDetail != null) {
                AimOpera aimOpera = new AimOpera();
                aimOpera.setName(operaDetail.getOperaName());
                aimOpera.setAuthor(operaDetail.getAuthor());
                aimOpera.setId(operaDetail.getId()+"");

                OperaOwner operaOwner = operaOwnerMapper.selectByOperaId(operaDetail.getId());
                if (operaOwner != null) {
//                        到期时间
                    aimOpera.setLimitTime(formatter.format(operaOwner.getExpiryTime()));
                } else {

//                        表示没有购买
                    aimOpera.setLimitTime("-1");
                }
//                    查询当前曲谱是否为免费的
                OperaPrice operaPriceFree = operaPriceMapper.selectIsFree(operaDetail.getId());
                if (operaPriceFree != null) {
                    //标记为免费曲谱
                    aimOpera.setLimitTime("-2");
                }
//                    查询曲谱原价
                List<OperaPrice> operaPriceList = operaPriceMapper.selectByOperaIdAndIsSpecial(operaDetail.getId(), 0);
//                    有待完善
                // 分别获取所有原价
                if (operaPriceList.size() > 0) {
                    BigDecimal aimPrice = operaPriceList.get(0).getPrice();
                    for (OperaPrice operaPrice : operaPriceList) {
//                            比较大小,找出最小的值
                        if (operaPrice.getPrice().compareTo(aimPrice) == -1) {
                            aimPrice = operaPrice.getPrice();
                        }
                    }
                    aimOpera.setPrice(aimPrice + "");
                    log.info("");
                }

//                    查询所有特价
                operaPriceList = operaPriceMapper.selectByOperaIdAndIsSpecial(operaDetail.getId(), 1);
                if (operaPriceList.size() > 0) {
                    BigDecimal aimPrice = operaPriceList.get(0).getPrice();
                    for (OperaPrice operaPrice : operaPriceList) {
                        if (operaPrice.getPrice().compareTo(aimPrice) == -1) {
                            aimPrice = operaPrice.getPrice();
                        }
                    }
                    aimOpera.setDiscountPrice(aimPrice + "");
                }

                aimOperaList.add(aimOpera);


                //                获取id对应的教材详细信息
                LearnbookDetail learnbookDetail = learnbookDetailMapper.selectByPrimaryKey(operaDetail.getLearnbookId());

                AimLearnBook aimLearnBook = new AimLearnBook();
                aimLearnBook.setId(learnbookDetail.getId());
                aimLearnBook.setUrl(learnbookDetail.getCoverPicture());
                aimLearnBook.setSummary(learnbookDetail.getSummary());
                aimLearnBook.setAuthor(learnbookDetail.getAuthor());
                aimLearnBook.setName(learnbookDetail.getName());

                result.put("id", aimLearnBook.getId());
                result.put("url", aimLearnBook.getUrl());
                result.put("name", aimLearnBook.getName());
                result.put("author", aimLearnBook.getAuthor());
                result.put("summary", aimLearnBook.getSummary());
            }else {
                result.put("success", 0);
                result.put("msg", "传入曲谱id错误!");
                return  result;
            }


            result.put("ownOpen",aimOperaList);
            result.put("success", 1);
            result.put("msg", "操作成功!");
        } catch (Exception e) {
            e.printStackTrace();
            result.put("success", 0);
            result.put("msg", "操作失败!");
        }
        return result;
    }


}
