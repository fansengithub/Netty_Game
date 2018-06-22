package com.mmall.controller;

import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookStage;
import com.mmall.service.StageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 阶段管理
 */
@Slf4j
@RequestMapping("/stage")
@Controller
public class StageController {

    @Autowired
    private StageService stageService;

    @RequestMapping("/add")
    @ResponseBody
    public LayUIResult addStage( HttpServletRequest request){
        log.info("添加");
        LayUIResult result = new LayUIResult();
        String content = request.getParameter("content");
        String id = request.getParameter("id");
        log.info("content"+content+"id"+id);
        LearnbookStage learnbookStage1 = new LearnbookStage();
        int num = 0;
        try {
            if (id != null && !"".equals(id)) {
                learnbookStage1.setId(Integer.parseInt(id));
                learnbookStage1.setStage(content);
                num = stageService.updateStage(learnbookStage1);
                log.info("修改成功");
            } else {
                learnbookStage1.setStage(content);
                num=stageService.addStage(learnbookStage1);
                log.info("添加成功");
            }
            if (num > 0) {
                result.setCode(0);
                result.setMsg("添加或修改成功");
            } else {
                result.setCode(1);
                result.setMsg("添加或修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("添加或修改失败");
        }
        return result;
    }

    @RequestMapping("/selAll")
    @ResponseBody
    public LayUIResult selAllStage(){
        LayUIResult layUIResult=new LayUIResult();
        try {
            List<LearnbookStage> learnbookStages=stageService.selAllStage();
            layUIResult.setData(learnbookStages);
            layUIResult.setCode(0);
            layUIResult.setMsg("cg");
        }catch (Exception e){
            e.getMessage();
            layUIResult.setCode(1);
            layUIResult.setMsg("sb");
        }
        return layUIResult;
    }

    @RequestMapping("/del")
    @ResponseBody
    public LayUIResult delStage(@RequestParam("sid")Integer sid){
        LayUIResult layUIResult=new LayUIResult();
        int num=stageService.delStage(sid);
        if(num>0){
            layUIResult.setCode(0);
            layUIResult.setMsg("cg");
        }else{
            layUIResult.setCode(1);
            layUIResult.setMsg("sb");
        }
        return layUIResult;
    }
}
