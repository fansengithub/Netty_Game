package com.mmall.controller;

import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookStyle;
import com.mmall.service.StyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 风格管理
 */
@Slf4j
@Controller
@RequestMapping("/style")
public class StyleController {

    @Autowired
    private StyleService styleService;

    @RequestMapping("/add")
    @ResponseBody
    public LayUIResult addStyle(HttpServletRequest request){
        log.info("添加");
        LayUIResult result = new LayUIResult();
        String content = request.getParameter("content");
        String id = request.getParameter("id");
        log.info("content"+content+"id"+id);
        LearnbookStyle learnbookStage1 = new LearnbookStyle();
        int num = 0;
        try {
            if (id != null && !"".equals(id)) {
                learnbookStage1.setId(Integer.parseInt(id));
                learnbookStage1.setStyle(content);
                num = styleService.updateStype(learnbookStage1);
                log.info("修改成功");
            } else {
                learnbookStage1.setStyle(content);
                num=styleService.addStyle(learnbookStage1);
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
    public LayUIResult selAllStyle(){
        LayUIResult layUIResult=new LayUIResult();
        List<LearnbookStyle> learnbookStyles=styleService.selAllStyle();
        layUIResult.setMsg("cg");
        layUIResult.setData(learnbookStyles);
        layUIResult.setCode(0);
        return layUIResult;
    }


    @RequestMapping("/del")
    @ResponseBody
    public LayUIResult delStyle(@RequestParam("sid")Integer sid){
        LayUIResult layUIResult=new LayUIResult();
        int num=styleService.delStyle(sid);
        if(num>0){
            layUIResult.setCode(0);
            layUIResult.setMsg("cg");
        }else {
            layUIResult.setMsg("sb");
            layUIResult.setCode(1);
        }
        return layUIResult;
    }


    @RequestMapping("/update")
    @ResponseBody
    public LayUIResult updateStyle(LearnbookStyle learnbookStyle){
        LayUIResult layUIResult=new LayUIResult();
        int num=styleService.updateStype(learnbookStyle);
        if(num>0){
            layUIResult.setCode(0);
            layUIResult.setMsg("cg");
        }else {
            layUIResult.setMsg("sb");
            layUIResult.setCode(1);
        }
        return layUIResult;
    }

}
