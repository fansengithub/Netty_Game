package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.CountRecordMapper;
import com.mmall.dao.SongRecordMapper;
import com.mmall.dao.UserScoreMapper;
import com.mmall.model.*;
import com.mmall.service.LearnBookService;
import com.mmall.service.ParametersSetService;
import com.mmall.service.WitdrawDetailService;
import com.mmall.util.IDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/userScore")
public class UserScoreController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private WitdrawDetailService witdrawDetailService;
    @Autowired
    private ParametersSetService parametersSetService;
    @Autowired
    private UserScoreMapper userScoreMapper;

    @Autowired
    private CountRecordMapper countRecordMapper;
    @Autowired
    private SongRecordMapper songRecordMapper;
    /**
     * 查询
     * @param num
     * @param model
     * @return
     */
    @RequestMapping("/jisuan")
    @ResponseBody
    public String jisuan(@RequestParam("num")Integer num,Model model){
        log.info("yibu="+num);
        String nums=num+"";
        ParametersSet parametersSet1=parametersSetService.selectByPrimaryKey(1);  //免手续费提现最少
//        ParametersSet parametersSet2=parametersSetService.selectByPrimaryKey(2);  //不满金额手续费
        ParametersSet parametersSet4=parametersSetService.selectByPrimaryKey(4);  //提现比例
        if (parametersSet4!=null && parametersSet4!=null){
            if ((parametersSet1.getValue().compareTo(new BigDecimal(num)))==1){
                //1减去手续费
//                BigDecimal shouxu=new BigDecimal("100").subtract(parametersSet2.getValue());
                //计算减去手续费后的金额
                log.info("提现比例为："+parametersSet4);
                BigDecimal big=parametersSet4.getValue().multiply(new BigDecimal(num+""));
                //除去得到的数据小数点后面
                nums=big.toString();
//                nums=nums.substring(0,nums.length()-2);
                log.info("有手续费"+nums);
            }

        }
        return  nums;
    }
    /**
     * 获取提现列表
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
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("提现列表"+param+startTime+endTime);
            PageHelper.startPage(curr,limit);
            List<UserScore> details= userScoreMapper.selectAll(param,startTime,endTime);
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



    @RequestMapping("/selAllCountRecord")
    @ResponseBody
    public LayUIResult getAllCountRecord(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                         @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                         Model model, HttpServletRequest request){

        LayUIResult layUIResult=new LayUIResult();
        try {
            String param=request.getParameter("keyword");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("提现列表"+param+startTime+endTime);
            PageHelper.startPage(curr,limit);
            List<CountRecord> details= countRecordMapper.selectAll(param,startTime,endTime);
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
    public String addLearn(HttpServletRequest request){

        log.info("添加");
        String withdrawObject=request.getParameter("withdrawObject");
        String bankAccount=request.getParameter("bankAccount");

        SysUser user=(SysUser) request.getSession().getAttribute("user");
        ParametersSet parametersSet=parametersSetService.selectByPrimaryKey(4); //提现比例
        WitdrawDetail witdrawDetail=new WitdrawDetail();
        witdrawDetail.setStage(0);     //默认是审核中
        witdrawDetail.setRoleType(2);  //默认是后台
        witdrawDetail.setNumber(IDUtils.genItemId()+"");//单号
        witdrawDetail.setWithdrawTime(new Date());//提现时间
        witdrawDetail.setBankAccount(bankAccount);//银行卡号
        witdrawDetail.setUserId(user.getId());
        witdrawDetail.setUsername(user.getUsername());//用户名
        witdrawDetail.setWithdrawObject(Long.parseLong(withdrawObject));//熊掌
        //兑换现金
        BigDecimal b2 = parametersSet.getValue();
        BigDecimal b1 = new BigDecimal(withdrawObject);
        log.info("兑换现金======"+b2.multiply(b1));
        witdrawDetail.setAccountMoney(new BigDecimal(b2.multiply(b1).longValue()));
        int num=witdrawDetailService.insert(witdrawDetail);
        return  "redirect:/get/withdrawApply.page";
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")

    public String updateLearn(HttpServletRequest request){
        String id = request.getParameter("id");
        String stage = request.getParameter("stage");
        WitdrawDetail newsWitdrawDetail = new WitdrawDetail();
        newsWitdrawDetail.setId(Integer.parseInt(id));
        log.info("修改广告="+id+"状态"+stage);
        if(stage!=null && !"".equals(stage)){
                if(stage.equals("1")){
                    stage="0";
                }else if (stage.equals("0")){
                    stage="1";
                }
        }
        newsWitdrawDetail.setStage(Integer.parseInt(stage));
        log.info("修改后广告="+id+"状态"+stage);

        witdrawDetailService.updateByPrimaryKeySelective(newsWitdrawDetail);
        log.info("修改成功");
        return  "redirect:/get/withdrawExamine.page";
    }


    @RequestMapping("/selAllSongRecord")
    @ResponseBody
    public LayUIResult getAllSongRecord(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request){

        LayUIResult layUIResult=new LayUIResult();
        try {
            String param=request.getParameter("keyword");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("提现列表"+param+startTime+endTime);
            PageHelper.startPage(curr,limit);
            List<SongRecord> details= songRecordMapper.selectAll(param,startTime,endTime);
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

}
