package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.DifficultySet;
import com.mmall.model.LayUIResult;
import com.mmall.model.SkinType;
import com.mmall.service.DifficultySetService;
import com.mmall.service.LearnBookService;
import com.mmall.service.SkinTypeService;
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
@RequestMapping("/difficultySet")
public class DifficultySetController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private DifficultySetService difficultySetService;
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
            log.info("皮肤类型列表"+param);
            PageHelper.startPage(curr,limit);
            List<DifficultySet> details= difficultySetService.getAllDifficulty(param);
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
     * @param id
     * @return
     */
    @RequestMapping("/deleteByKey")
    @ResponseBody
    public LayUIResult deleteByKey(@RequestParam("id")Integer id){
        LayUIResult layUIResult= new LayUIResult();
        //删除
        log.info("删除皮肤id="+id);
        int num=difficultySetService.deleteByPrimaryKey(id);
        if(num>0){
            layUIResult.setMsg("删除成功！");
            layUIResult.setCode(0);
        }else{
            layUIResult.setMsg("删除失败！");
            layUIResult.setCode(1);
        }
        log.info("结果"+layUIResult);
        return  layUIResult;
    }
    /**
     * 查询
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectByKey")
    public String selectByKey(@RequestParam("id")Integer id,Model model){
        log.info("查询--------selectByKey"+id);
        DifficultySet difficultySet = difficultySetService.selectByPrimaryKey(id);
        model.addAttribute("difficultySet",difficultySet);
        return "pages/updateDifficultySet";
    }


    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        String diffityLevel = request.getParameter("diffityLevel");
        DifficultySet difficultySet=new DifficultySet();
        difficultySet.setDiffityLevel(Integer.parseInt(diffityLevel));
        System.out.println("新增的广告信息:"+difficultySet.toString());
        difficultySetService.insertSelective(difficultySet);
        return  "redirect:/get/difficultySet.page";
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
        DifficultySet difficultySet=new DifficultySet();
        difficultySet.setId(Integer.parseInt(id));
        difficultySet.setDiffityLevel(Integer.parseInt(diffityLevel));
        log.info("修改广告="+id);

        difficultySetService.updateByPrimaryKeySelective(difficultySet);
        log.info("修改成功="+id);
        return  "redirect:/get/difficultySet.page";
    }

}
