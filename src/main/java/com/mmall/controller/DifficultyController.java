package com.mmall.controller;

import com.mmall.model.DifficultySet;
import com.mmall.model.LayUIResult;
import com.mmall.model.SkinType;
import com.mmall.service.DifficultySetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 难度管理
 */
@Slf4j
@RequestMapping("/difficulty")
@Controller
public class DifficultyController {

    @Autowired
    private DifficultySetService difficultyService;

    /**
     * 查询所有
     * @return
     * @throws Exception
     */
    @RequestMapping("/selAll")
    @ResponseBody
    public LayUIResult selAllDifficulty()throws Exception{
       LayUIResult layUIResult=new LayUIResult();
       try {
           List<DifficultySet> difficultySets= difficultyService.getAllDifficulty(null);
           layUIResult.setData(difficultySets);
           layUIResult.setCode(0);
           layUIResult.setMsg("成功！");
       }catch (Exception e){
            e.getMessage();
           layUIResult.setCode(1);
           layUIResult.setMsg("失败！");
       }
        return layUIResult;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public LayUIResult addDifficulty(DifficultySet difficultySet){
        LayUIResult layUIResult=new LayUIResult();
        int num=difficultyService.insertSelective(difficultySet);
        if(num>0){
            layUIResult.setMsg("cg");
            layUIResult.setCode(0);
        }else{
            layUIResult.setMsg("sb");
            layUIResult.setCode(1);
        }
        return layUIResult;
    }

    /**
     * 删除
     * @return
     */
    @RequestMapping("/deleteByKey")
    @ResponseBody
    public LayUIResult delDifficulty(@RequestParam("id")Integer did){
        LayUIResult layUIResult=new LayUIResult();
        int num=difficultyService.deleteByPrimaryKey(did);
        if(num>0){
            layUIResult.setMsg("cg");
            layUIResult.setCode(0);
        }else{
            layUIResult.setMsg("sb");
            layUIResult.setCode(1);
        }
        return layUIResult;
    }
    @RequestMapping("/selectByKey")
    public String selectByKey(@RequestParam("id")Integer id,Model model){
        log.info("查询--------selectByKey"+id);
        DifficultySet difficultySet = difficultyService.selectByPrimaryKey(id);
        model.addAttribute("difficultySet",difficultySet);
        return "pages/updateSkinType";
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){
        String id = request.getParameter("id");
        String diffityLevel = request.getParameter("diffityLevel");
        DifficultySet  difficultySet = new DifficultySet();
        difficultySet.setId(Integer.parseInt(id));
        difficultySet.setDiffityLevel(Integer.parseInt(diffityLevel));
        log.info("修改广告="+id);

        difficultyService.updateByPrimaryKeySelective(difficultySet);
        log.info("修改成功="+id);
        return  "redirect:/get/skinType.page";
    }

}
