package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.MembershipDuesMapper;
import com.mmall.model.LayUIResult;
import com.mmall.model.MembershipDues;
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
@RequestMapping("/membershipDues")
public class MembershipDuesController {

    @Autowired
    private MembershipDuesMapper membershipDuesMapper;

    /**
     * 获取提现列表
     *
     * @param curr
     * @param limit
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/selAll")
    @ResponseBody
    public LayUIResult getAllLearnBook(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                       Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("会费查询" + param + startTime + endTime);
            PageHelper.startPage(curr, limit);
            List<MembershipDues> details = membershipDuesMapper.selectAll(param, consumpType1, startTime, endTime);
            log.info("details=" + details.size());
            PageInfo pageInfo = new PageInfo(details);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(details);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }

    @RequestMapping("/getcountByAmount")
    @ResponseBody
    public String getcountByAmount(HttpServletRequest request, Model model) {
        String param = request.getParameter("keyword");
        String consumpType1 = request.getParameter("consumpType1");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        log.info("会费统计" + param + startTime + endTime);
        Integer countByAmount = membershipDuesMapper.selectAllCountByRole(param, consumpType1, startTime, endTime);
        if (countByAmount==null){
            countByAmount=0;
        }
        return "" + countByAmount;
    }


}
