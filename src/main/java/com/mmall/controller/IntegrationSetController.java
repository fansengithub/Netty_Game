package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.GameintegrationSetMapper;
import com.mmall.dao.IntegrationSetMapper;
import com.mmall.model.*;
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
@RequestMapping("/integration")
public class IntegrationSetController {
    @Autowired
    IntegrationSetMapper integrationSetMapper;
    @Autowired
    GameintegrationSetMapper gameintegrationSetMapper;
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
            String consumpType1=request.getParameter("consumpType1");
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("收入信息列表"+param+","+consumpType1);
            PageHelper.startPage(curr,limit);
            List<IntegrationSet> details= integrationSetMapper.getAllIntegrationSet(null);

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
            List<GameintegrationSet> details= gameintegrationSetMapper.getAllGameintegrationSet(null);
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
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/sel")
    public String sel(@RequestParam("id")Integer id,Model model){
        log.info("查询"+id);
        List<IntegrationSet> integrationSet=integrationSetMapper.getAllIntegrationSet(id);
        if (integrationSet!=null) {
            model.addAttribute("integrationSet", integrationSet.get(0));
        }
        return  "pages/updateIntegrationSet";
    }

    /**
     * 查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/sel2")
    public String sel2(@RequestParam("id")Integer id,Model model){
        log.info("查询"+id);
        List<GameintegrationSet> integrationSet=gameintegrationSetMapper.getAllGameintegrationSet(id);
        if (integrationSet!=null) {
            model.addAttribute("gameintegrationSet", integrationSet.get(0));
        }
        return  "pages/updateGameIntegrationSet";
    }




    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){
        log.info("修改2");
        String id=request.getParameter("id");
        String values=request.getParameter("value");
        String topValues=request.getParameter("topValues");
        log.info(id+values+topValues);
        IntegrationSet integrationSet=new IntegrationSet();
        integrationSet.setTypeId(Integer.parseInt(id));
        if(values!=null && !"".equals(values)){
            log.info("---");
            integrationSet.setValue(Long.parseLong(values));
        }else{
            log.info("-+-");
            integrationSet.setValue(null);
        }
        if(topValues!=null && !"".equals(topValues)){
            log.info("---");
            integrationSet.setTopValues(Long.parseLong(topValues));
        }else{
            log.info("-+-");
            integrationSet.setTopValues(null);
        }
        integrationSetMapper.updateByPrimaryKeySelective(integrationSet);
        return  "redirect:/get/integrationSet.page";

    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update2")
    public String updateLearn2(HttpServletRequest request){
        log.info("修改2");
        String id=request.getParameter("id");
        String values=request.getParameter("value");

        log.info(id+values);
        GameintegrationSet integrationSet=new GameintegrationSet();
        integrationSet.setTypeId(Integer.parseInt(id));
        if(values!=null && !"".equals(values)){
            integrationSet.setValue(Long.parseLong(values));
        }else{
            integrationSet.setValue(null);
        }


        gameintegrationSetMapper.updateByPrimaryKeySelective(integrationSet);
        return  "redirect:/get/gameintegrationSet.page";
    }

}
