package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.BankcardDetailMapper;
import com.mmall.entity.IncomeDetailCount;
import com.mmall.model.IncomeDetail;
import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookDetail;
import com.mmall.model.SysUser;
import com.mmall.service.IncomeDetailService;
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
@RequestMapping("/IncomeDetail")
public class IncomeDetailController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private IncomeDetailService incomeDetailService;
    @Autowired
    private BankcardDetailMapper bankcardDetailMapper;
    /**
     * 获取收入明细
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
            String consumpType1=request.getParameter("consumpType1");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("收入信息列表"+param+","+consumpType1);
            PageHelper.startPage(curr,limit);
            List<IncomeDetail> details=null;
            SysUser user=(SysUser) request.getSession().getAttribute("user");
            int xinxiType=user.getXinxiType();
            log.info("xinxiType"+xinxiType);
            if (xinxiType==0){
                details = incomeDetailService.getAllIncomeDetail(param,consumpType1,startTime,endTime);                     //总管理
            }else if(xinxiType==1) {
                details = incomeDetailService.selectAllByService(user.getXinxiId(),param, consumpType1, startTime, endTime);    //服务商
            }else if(xinxiType==2) {
                details = incomeDetailService.selectAllByOrganization(user.getXinxiId(),param, consumpType1, startTime, endTime);    //服务商
            }else if(xinxiType==3) {
                details = incomeDetailService.selectAllByPianoShop(user.getXinxiId(),param, consumpType1, startTime, endTime);    //服务商
            }
//            for (IncomeDetail incomeDetail:details) {
//                incomeDetail.setRole(bankcardDetailMapper.getRoleNameByuserID(incomeDetail.getUserId()));
//            }
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
//获取分润统计
    @RequestMapping("/selAll2")
    @ResponseBody
    public LayUIResult getAllLearnBook2(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                       @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                       Model model, HttpServletRequest request){

        LayUIResult layUIResult=new LayUIResult();
        try {
            String param=request.getParameter("keyword");
            String consumpType1=request.getParameter("consumpType1");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("收入信息列表"+param+","+consumpType1+","+startTime+","+endTime);
            PageHelper.startPage(curr,limit);
            List<IncomeDetailCount> details= null;
            SysUser user=(SysUser) request.getSession().getAttribute("user");
            int xinxiType=user.getXinxiType();
            log.info("xinxiType"+xinxiType);
            if (xinxiType==0){
                details = incomeDetailService.getGroupIncomeDetail(param,consumpType1,startTime,endTime);                     //总管理
            }else if(xinxiType==1) {
                details = incomeDetailService.getGroupIncomeDetailByService(user.getXinxiId(),param, consumpType1, startTime, endTime);    //服务商
            }else if(xinxiType==2) {
                details = incomeDetailService.getGroupIncomeDetailByOrganization(user.getXinxiId(),param, consumpType1, startTime, endTime);    //服务商
            }else if(xinxiType==3) {
                details = incomeDetailService.getGroupIncomeDetailByPianoShop(user.getXinxiId(),param, consumpType1, startTime, endTime);    //服务商
            }
//            for (IncomeDetailCount incomeDetail:details) {
//                incomeDetail.setRole(bankcardDetailMapper.getRoleNameByuserID(incomeDetail.getUserId()));
//            }


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
     * @param learnbookDetail
     * @return
     */
    @RequestMapping("/add")
    public String addLearn(LearnbookDetail learnbookDetail){
        log.info("添加");
        int num=learnBookService.addLearn(learnbookDetail);
        return  "redirect:get/learnBookManagement";
    }

    /**
     * 修改
     * @param learnbookDetail
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(LearnbookDetail learnbookDetail){
        log.info("修改"+learnbookDetail.getLearnbookId());
        learnBookService.updateLearn(learnbookDetail);
        return  "redirect:get/learnBookManagement";
    }

}
