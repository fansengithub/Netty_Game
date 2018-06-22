package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.LearnbookStyleMapper;
import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *  教材风格控制器
 */
@Slf4j
@RequestMapping("/textStyle")
@Controller
public class TextStyleController {
    @Autowired
    LearnbookStyleMapper learnbookStyleMapper;

    /**
     * 获取教材风格
     * @param curr
     * @param limit
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = "/getTextStyle")
    @ResponseBody
    public LayUIResult getTextStyle(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                 @RequestParam(value = "limit",defaultValue = "10") Integer limit,
                                 Model model, HttpServletRequest request){
        LayUIResult layUIResult =new LayUIResult();
        try {
            String param=request.getParameter("keyword");
            log.info("param"+param);
            PageHelper.startPage(curr,limit);
            List<LearnbookStyle> learnbookStyleList = learnbookStyleMapper.selectStyleByParam(param);
//            List<OperaDetail> operaDetails=operaService.selOperas(param);
            PageInfo pageInfo =new PageInfo(learnbookStyleList);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(learnbookStyleList);
            layUIResult.setCount(pageInfo.getTotal());
        }catch (Exception e){
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        return layUIResult;
    }


    /**
     * 删除教材风格
     * @param styleId
     * @return
     */
    @RequestMapping("/deleteTextStyle")
    @ResponseBody
    public String deleteTextStyle(@RequestParam("styleId")String styleId){
        try {
            log.info("教材风格删除---"+styleId);
            int num = 0 ;
            if (styleId !=null && styleId !=""){
                num =learnbookStyleMapper.deleteByPrimaryKey(Integer.parseInt(styleId));
            }
            if(num>0){
                log.info("删除成功!");
            }else{
                log.info("删除失败!");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/get/styleManagement.page";

    }

    /**
     * 教材风格详情
     * @param styleId
     * @return
     */
    @RequestMapping("/OperaDetail")
    public String textStyleDetail(@RequestParam("styleId") String styleId,Model model){
        try {

            log.info("教材风格详情-----"+styleId);
            LearnbookStyle temp = learnbookStyleMapper.selectByPrimaryKey(Integer.parseInt(styleId));
            model.addAttribute("learnbookStyle",temp);
            log.info("opera"+temp);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "pages/textStyleDetail";
    }

    /**
     * 教材风格更新
     * @param
     * @return
     */
    @RequestMapping(value = "/modifyTextStyle",method = RequestMethod.POST)
    public String modifyTextStyle(@RequestParam("id") String id,@RequestParam("style") String style){
        log.info("--- style"+style);
        log.info("--- id"+id);
        try {
            if (id!=null && id !=""){
                LearnbookStyle temp = learnbookStyleMapper.selectByPrimaryKey(Integer.parseInt(id));
                temp.setStyle(style);
                int  num =learnbookStyleMapper.updateByPrimaryKey(temp);
                if (num > 0){
                    log.info("修改成功!");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("重定向!");
        return "redirect:/get/styleManagement.page";
    }

    /***
     * 新增教材风格
     * @return
     */
    @RequestMapping("/addTextStyle")
    public  String addTextStyle(@RequestParam("style") String style){
        try {
            log.info("新增教材风格:style"+style);
            LearnbookStyle temp = new LearnbookStyle();
            temp.setStyle(style);
            int num = learnbookStyleMapper.insertSelective(temp);
            if (num == 1){
                log.info("教材风格添加成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/get/styleManagement.page";

    }
}
