package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.BankcardDetailMapper;
import com.mmall.dao.SysUserMapper;
import com.mmall.model.*;
import com.mmall.service.BankcardDetailService;
import com.mmall.service.LearnBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/BankcardDetail")
public class BankcardDetailController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private BankcardDetailService bankcardDetailService;
    /**
     * 获取银行卡列表
     * @param curr
     * @param limit
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/selAll")
    @ResponseBody
    public LayUIResult getAllLearnBook(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                       @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                       Model model, HttpServletRequest request){

        LayUIResult layUIResult=new LayUIResult();
        try {
            String param=request.getParameter("keyword");
            log.info("银行卡信息列表"+param);
            PageHelper.startPage(curr,limit);
            SysUser user=(SysUser) request.getSession().getAttribute("user");
            log.info("当前用户="+user.getId());
            List<BankcardDetail> details= bankcardDetailService.getAllBankcardDetail(user.getId().toString());
            log.info("details="+details.size());
            PageInfo pageInfo=new PageInfo(details);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(details);
            layUIResult.setCount(pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
            log.info("结果"+layUIResult);
            return layUIResult;
    }

    /**
     * 删除教材
     * @param lid
     * @return
     */
    @RequestMapping("/dellearnbook")
    @ResponseBody
    public LayUIResult delLearnbook(@RequestParam("lid")Integer lid){
        LayUIResult layUIResult=learnBookService.delLearn(lid);
        log.info("结果"+layUIResult);
        return  layUIResult;
    }

    /**
     * 查询
     * @param lid
     * @param model
     * @return
     */
    @RequestMapping("/sel")
    public String sel(@RequestParam("lid")Integer lid,Model model){
        log.info("查询"+lid);
        LearnbookDetail learnbookDetail=learnBookService.selLearnbook(lid);
        model.addAttribute("learnbookDetail",learnbookDetail);
        return  "pages/addLearnBook";
    }


    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        String holderName=request.getParameter("holderName");
        String bankcardNum=request.getParameter("bankcardNum");
        String bankcardType=request.getParameter("bankcardType");
        String opeanBank=request.getParameter("opeanBank");
        String telephone=request.getParameter("telephone");
        String xxx=request.getParameter("xxx");
        SysUser user=(SysUser) request.getSession().getAttribute("user");
//       String role=bankcardDetailMapper.getRoleNameByuserID(user.getId());

        log.info("当前用户"+user);
        log.info("当前用户"+user.getId());
        log.info("当前角色"+user.getXinxiType());
        log.info("银行卡持有者"+holderName);
        BankcardDetail bankcardDetail=new BankcardDetail();
        bankcardDetail.setUserId(user.getId());
        bankcardDetail.setUserName(user.getUsername());
        bankcardDetail.setRoleType(2);    //默认后台
        bankcardDetail.setRoler(user.getXinxiType().toString());   //当前用户的身份
        bankcardDetail.setHolderName(holderName);
        bankcardDetail.setBankcardNum(bankcardNum);
        bankcardDetail.setBankcardType(bankcardType);
        bankcardDetail.setOpeanBank(opeanBank);
        bankcardDetail.setTelephone(telephone);
        bankcardDetail.setIsDefault(0);
        System.out.println("新增的广告信息:"+bankcardDetail.toString());
        bankcardDetailService.insertSelective(bankcardDetail);
        return  "redirect:/get/bankCardDetail.page";
    }
    /**
     * 添加银行卡
     * @param
     * @return
     */
//    @RequestMapping("/add")
//    public String add(HttpServletRequest request){
//        String columnType = request.getParameter("columnType");
////        String id = request.getParameter("id");
//        String author = request.getParameter("author");
//        String coverPicture = request.getParameter("coverPicture");
//        String textContent = request.getParameter("textContent");
//
//        CmsAdver newCmsAdver = new CmsAdver();
////        newCmsAdver.setId(Integer.parseInt(id));
//        newCmsAdver.setFounder(author);
//        newCmsAdver.setCoverPicture(coverPicture);
//        newCmsAdver.setTextContent(textContent);
//        newCmsAdver.setCreateTime(new Date());
//        newCmsAdver.setType(1);
//
//        log.info("修改  cms广告更新!---columnType"+columnType);
//
//        int newColumnType = 0;
//        if(columnType != null){
//            System.out.println("columnType  ---"+columnType);
//            if (columnType.equals("教材")){
//                newColumnType = 1;
//            }else if (columnType.equals("文本")){
//                newColumnType = 4;
//            }else if (columnType.equals("曲谱")){
//                newColumnType = 2;
//            }else if (columnType.equals("广告")){
//                newColumnType = 3;
//            }
//            newCmsAdver.setColumnType(newColumnType);
//        }
//        System.out.println("新增的广告信息:"+newCmsAdver);
//        cmsAdverMapper.insertSelective(newCmsAdver);
//
//        return  "redirect:/get/columnManagement.page";
//    }
    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){
        String id = request.getParameter("id");
        SysUser user=(SysUser) request.getSession().getAttribute("user");

        BankcardDetail  newskinType = new BankcardDetail();
        newskinType.setIsDefault(0);
        newskinType.setUserId(user.getId());
        bankcardDetailService.updateAllisDefault(newskinType);
        newskinType.setIsDefault(1);
        newskinType.setUserId(null);
        newskinType.setId(Integer.parseInt(id));
        log.info("修改默认银行卡="+id);
        bankcardDetailService.updateByPrimaryKeySelective(newskinType);
        log.info("修改成功="+id);
        return  "redirect:/get/bankCardDetail.page";
    }

}
