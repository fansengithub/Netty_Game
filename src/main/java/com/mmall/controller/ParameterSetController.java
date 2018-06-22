package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.LayUIResult;
import com.mmall.model.ParameterSet;
import com.mmall.service.ParameterSetService;
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
@RequestMapping("/parameterSet")
public class ParameterSetController {

    @Autowired
    private ParameterSetService parameterSetService;

    /**
     * 获取银行卡列表
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
            log.info("皮肤类型列表" + param);
            PageHelper.startPage(curr, limit);
            List<ParameterSet> details = parameterSetService.getAllParameterSet(param);
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

    /**
     * 查询
     *
     * @param type
     * @param model
     * @return
     */
    @RequestMapping("/selectByKey")
    public String selectByKey(@RequestParam("type") Integer type, Model model) {
        log.info("查询--------selectByKey" + type);
        ParameterSet parameterSet = parameterSetService.selectByPrimaryKey(type);
        model.addAttribute("parameterSet", parameterSet);
        return "pages/updateSkinType";
    }


    /**
     * 修改
     *
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request) {

        String content1 = request.getParameter("content1");
        String content2 = request.getParameter("content2");
        String content3 = request.getParameter("content3");
        String content4 = request.getParameter("content4");
        String content5 = request.getParameter("content5");
        String content6 = request.getParameter("content6");
        log.info("修改会费type=" + content1 + content2 + content3);
        ParameterSet newParameterSet1 = new ParameterSet();
        ParameterSet newParameterSet2 = new ParameterSet();
        ParameterSet newParameterSet3 = new ParameterSet();
        ParameterSet newParameterSet4 = new ParameterSet();
        ParameterSet newParameterSet5 = new ParameterSet();
        ParameterSet newParameterSet6 = new ParameterSet();

        newParameterSet1.setType(1);
        newParameterSet1.setContent(Long.parseLong(content1));
        newParameterSet2.setType(2);
        newParameterSet2.setContent(Long.parseLong(content2));
        newParameterSet3.setType(3);
        newParameterSet3.setContent(Long.parseLong(content3));
        newParameterSet4.setType(4);
        newParameterSet4.setContent(Long.parseLong(content4));
        newParameterSet5.setType(5);
        newParameterSet5.setContent(Long.parseLong(content5));
        newParameterSet6.setType(6);
        newParameterSet6.setContent(Long.parseLong(content6));


        parameterSetService.updateByPrimaryKeySelective(newParameterSet1);
        parameterSetService.updateByPrimaryKeySelective(newParameterSet2);
        parameterSetService.updateByPrimaryKeySelective(newParameterSet3);
        parameterSetService.updateByPrimaryKeySelective(newParameterSet4);
        parameterSetService.updateByPrimaryKeySelective(newParameterSet5);
        parameterSetService.updateByPrimaryKeySelective(newParameterSet6);
        log.info("修改成功=");
        return "redirect:/get/memberFee.page";
    }

}
