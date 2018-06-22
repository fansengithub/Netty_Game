package com.mmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.LearnbookStageMapper;
import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookStage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/stage")
@Controller
public class LearnbookStageController {

    @Autowired
    LearnbookStageMapper  learnbookStageMapper;

    /**
     *
     * @param curr
     * @param limit
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/selectByParam")
    @ResponseBody
    public LayUIResult getOperas(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                 @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 Model model, HttpServletRequest request){
        LayUIResult layUIResult =new LayUIResult();
        try {
            Map<String,Object> map=new HashMap<>();
            String param=request.getParameter("keyword");
            log.info("param"+param);
            PageHelper.startPage(curr,limit);
            List<LearnbookStage> operaDetails=learnbookStageMapper.selectByParam(param);
            PageInfo pageInfo =new PageInfo(operaDetails);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(operaDetails);
            layUIResult.setCount(pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
        }

        return layUIResult;
    }

    /**
     *   根据id删除
     * @param stageId
     * @return
     */
    @RequestMapping(value = "/deletStageeById")
    @ResponseBody
    public LayUIResult deletStageeById(@RequestParam("stageId")String stageId){
        LayUIResult result=new LayUIResult();

        try {
            log.info("删除"+stageId);
            int num=learnbookStageMapper.deleteByPrimaryKey(Integer.parseInt(stageId));
            if(num>0){
                result.setCode(0);
                result.setMsg("成功");
            }else{
                result.setCode(1);
                result.setMsg("失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 查看阶段详情
     * @param stageId
     * @return
     */
    @RequestMapping("/stageDetail")
    public String OperaDetail(@RequestParam("stageId")Integer stageId,Model model){
        try {

            log.info("阶段详情---id"+stageId);
            LearnbookStage stageDetail=learnbookStageMapper.selectByPrimaryKey(stageId);
            model.addAttribute("stageDetail",stageDetail);
            log.info("阶段详情"+stageDetail);
        }catch (Exception e){
            e.printStackTrace();
        }

        return "pages/StageDetail";
    }

    /**
     *    修改阶段信息
     * @param stage
     * @return
     */
    @RequestMapping("/modifyStage")
    public  String  modifyStage(@RequestParam("stage")String stage,@RequestParam("id")String id){
        LayUIResult result=new LayUIResult();

        try {
            log.info("修改阶段信息 id:"+id+"  stage"+stage);
            if (id!=null &&id!=""){
                LearnbookStage temp = learnbookStageMapper.selectByPrimaryKey(Integer.parseInt(id));
                temp.setStage(stage);

                int num = learnbookStageMapper.updateByPrimaryKey(temp);
                if(num>0){
                    result.setCode(0);
                    result.setMsg("成功");
                }else{
                    result.setCode(1);
                    result.setMsg("失败");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/get/stageManagement.page";

    }
}
