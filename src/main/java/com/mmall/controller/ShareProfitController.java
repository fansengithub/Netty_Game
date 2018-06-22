package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.*;
import com.mmall.service.LearnBookService;
import com.mmall.service.ShareProfitService;
import com.mmall.service.WitdrawDetailService;
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
@RequestMapping("/shareProfit")
public class ShareProfitController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private ShareProfitService shareProfitService;
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
            log.info("分润设置列表"+param);
            PageHelper.startPage(curr,limit);
            List<ShareProfit> details= shareProfitService.getAllShareProfit(param);
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
    @RequestMapping("/selectByKey")
    public String sel(@RequestParam("role")Integer lid,Model model){
        log.info("查询"+lid);

        ShareProfit shareProfit=shareProfitService.selectByPrimaryKey(lid);
        model.addAttribute("shareProfit",shareProfit);
        return  "pages/updateShareProfitSet";
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){
        String gameProfit = request.getParameter("gameProfit");
        String learnbookProfit = request.getParameter("learnbookProfit");
        String skinProfit = request.getParameter("skinProfit");
        String createTeacherProfit = request.getParameter("createTeacherProfit");
        String operaExplain = request.getParameter("operaExplain");
        String role = request.getParameter("roleid");
        log.info("role+"+role);
        ShareProfit newShareProfit=new ShareProfit();
        newShareProfit.setRole(Integer.parseInt(role));
        newShareProfit.setGameProfit(Long.parseLong(gameProfit));
        newShareProfit.setLearnbookProfit(Long.parseLong(learnbookProfit));
        newShareProfit.setSkinProfit(Long.parseLong(skinProfit));
        newShareProfit.setCreateTeacherProfit(Long.parseLong(createTeacherProfit));
        newShareProfit.setOperaExplain(Long.parseLong(operaExplain));
        log.info("修改广告="+newShareProfit.toString());

        shareProfitService.updateByPrimaryKeySelective(newShareProfit);
        log.info("修改成功");
        return  "redirect:/get/shareProfitSetting.page";
    }
}
