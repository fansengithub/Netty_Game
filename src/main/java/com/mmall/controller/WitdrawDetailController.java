package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.OrganizationMapper;
import com.mmall.dao.PianoShopMapper;
import com.mmall.dao.ServiceProviderMapper;
import com.mmall.dao.TeacherMapper;
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
@RequestMapping("/withdrawDetail")
public class WitdrawDetailController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private WitdrawDetailService witdrawDetailService;
    @Autowired
    private ParametersSetService parametersSetService;
    @Autowired
    private ServiceProviderMapper serviceProviderMapper;
    @Autowired
    private OrganizationMapper organizationMapper;
    @Autowired
    private PianoShopMapper pianoShopMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    /**
     * 查询
     * @param num
     * @return
     */
    @RequestMapping("/jisuan")
    @ResponseBody
    public String jisuan(@RequestParam("num")Integer num){
        log.info("yibu="+num);
        String nums=num+"";
        ParametersSet parametersSet1=parametersSetService.selectByPrimaryKey(1);  //免手续费提现最少
        ParametersSet parametersSet2=parametersSetService.selectByPrimaryKey(2);  //不满金额手续费
        ParametersSet parametersSet4=parametersSetService.selectByPrimaryKey(4);  //提现比例
        if (parametersSet1!=null && parametersSet4!=null){
            if ((parametersSet1.getValue().compareTo(new BigDecimal(num)))==1){
                //1减去手续费
                BigDecimal shouxu=(new BigDecimal("100").subtract(parametersSet2.getValue())).divide(new BigDecimal("100"));
                //计算减去手续费后的金额
                BigDecimal yuByxiong=shouxu.multiply(new BigDecimal(num+""));
                log.info("提现比例为："+parametersSet4);
                BigDecimal yuByjin=yuByxiong.divide(parametersSet4.getValue());
                //除去得到的数据小数点后面
                nums=yuByjin.toString();
//                nums=nums.substring(0,nums.length()-2);
                log.info("有手续费"+num+"*"+shouxu+"/"+parametersSet4.getValue()+"="+nums);
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
            String stage=request.getParameter("stage");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("提现列表"+param+startTime+endTime);
            PageHelper.startPage(curr,limit);
            List<WitdrawDetail> details= null;
            SysUser user=(SysUser) request.getSession().getAttribute("user");
            int xinxiType=user.getXinxiType();
            log.info("xinxiType"+xinxiType);
            if (xinxiType==0){
                details = witdrawDetailService.getAllWitdrawDetail(param,stage,startTime,endTime);                  //总管理
            }else if(xinxiType==1) {
                details = witdrawDetailService.getAllWitdrawDetailByService(user.getXinxiId(),param,stage,startTime, endTime);    //服务商
            }else if(xinxiType==2) {
                details = witdrawDetailService.getAllWitdrawDetailByOrganization(user.getXinxiId(),param,stage,startTime, endTime);    //服务商
            }else if(xinxiType==3) {
                details = witdrawDetailService.getAllWitdrawDetailByPianoShop(user.getXinxiId(),param,stage, startTime, endTime);    //服务商
            }
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
    public String addLearn(HttpServletRequest request){

        log.info("添加");
        String withdrawObject=request.getParameter("withdrawObject");  //提现金额
        log.info("withdrawObject"+withdrawObject);
        String accountMoney=this.jisuan(Integer.parseInt(withdrawObject));  //计算提现的金额
        String bankAccount=request.getParameter("bankAccount");        //

        SysUser user=(SysUser) request.getSession().getAttribute("user");
        int xinxiType = user.getXinxiType();
        WitdrawDetail witdrawDetail=new WitdrawDetail();
        witdrawDetail.setStage(0);     //默认是审核中
        witdrawDetail.setRoleType(2);  //默认是后台
        witdrawDetail.setNumber(IDUtils.genItemId()+"");//单号
        witdrawDetail.setWithdrawTime(new Date());//提现时间
        witdrawDetail.setBankAccount(bankAccount);//银行卡号
        witdrawDetail.setUserId(user.getXinxiId());
        witdrawDetail.setRole(user.getXinxiType()+"");
        witdrawDetail.setUsername(user.getUsername());//用户名
        witdrawDetail.setRoleType(user.getXinxiType());
        witdrawDetail.setWithdrawObject(Long.parseLong(withdrawObject));//熊掌
        //兑换现金
        witdrawDetail.setAccountMoney(new BigDecimal(accountMoney));
        int num=witdrawDetailService.insert(witdrawDetail);
        if(num>0){
            if (xinxiType == 1) {
                ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(user.getXinxiId());
                serviceProvider.setWithdrawBalance(serviceProvider.getWithdrawBalance().subtract(new BigDecimal(withdrawObject)));
                serviceProviderMapper.updateByPrimaryKeySelective(serviceProvider);
            } else if (xinxiType == 2) {
                Organization organization = organizationMapper.selectByPrimaryKey(user.getXinxiId());
                organization.setWithdrawBalance(organization.getWithdrawBalance().subtract(new BigDecimal(withdrawObject)));
                organizationMapper.updateByPrimaryKeySelective(organization);
            } else if (xinxiType == 3) {
                PianoShop organization = pianoShopMapper.selectByPrimaryKey(user.getXinxiId());
                organization.setWithdrawalsBalance(organization.getWithdrawalsBalance().subtract(new BigDecimal(withdrawObject)));
                pianoShopMapper.updateByPrimaryKeySelective(organization);
            } else if (xinxiType == 4) {
                Teacher teacher = teacherMapper.selectByPrimaryKey(user.getXinxiId());
                teacher.setBalance(teacher.getBalance().subtract(new BigDecimal(withdrawObject)));
                teacherMapper.updateByPrimaryKeySelective(teacher);
            }
        }
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

}
