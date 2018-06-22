package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookSet;
import com.mmall.model.SkinType;
import com.mmall.service.LearnBookService;
import com.mmall.service.LearnboolSetService;
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
@RequestMapping("/learnboolSet")
public class LearnboolSetController {

    @Autowired
    private LearnboolSetService learnboolSetService;

    /**
     * 修改教材设置
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){
        String id ="1";
//        id=request.getParameter("id");
        String learnbookNum = request.getParameter("learnbookNum");
        String teacerBuyBook = request.getParameter("teacerBuyBook");
        LearnbookSet newLearnbookSet = new LearnbookSet();
        newLearnbookSet.setId(Integer.parseInt(id));
        newLearnbookSet.setLearnbookNum(Long.parseLong((learnbookNum)));
        newLearnbookSet.setTeacerBuyBook(Long.parseLong(teacerBuyBook));
        log.info("修改教材设置="+id);

        learnboolSetService.updateByPrimaryKeySelective(newLearnbookSet);
        log.info("修改成功="+id);
        return  "redirect:/get/textbookSet.page";
    }

}
