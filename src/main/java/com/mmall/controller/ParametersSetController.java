package com.mmall.controller;

import com.mmall.model.ParametersSet;
import com.mmall.service.ParametersSetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Slf4j
@Controller
@RequestMapping("/parametersSet")
public class ParametersSetController {

    @Autowired
    private ParametersSetService parametersSetService;


    /**
     * 查询
     * @param type
     * @param model
     * @return
     */
    @RequestMapping("/selectByKey")
    public String selectByKey(@RequestParam("type")Integer type,Model model){
        log.info("查询--------selectByKey"+type);
        ParametersSet parameterSet = parametersSetService.selectByPrimaryKey(type);
        model.addAttribute("parameterSet",parameterSet);
        return "pages/updateSkinType";
    }


    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){

        String value1 = request.getParameter("value1");
        String value2 = request.getParameter("value2");
        String value3 = request.getParameter("value3");
        String value4 = request.getParameter("value4");
        log.info("修改会费type="+value1+value2+value3+value4);
        ParametersSet  newParameterSet1 = new ParametersSet();
        ParametersSet  newParameterSet2 = new ParametersSet();
        ParametersSet  newParameterSet3 = new ParametersSet();
        ParametersSet  newParameterSet4 = new ParametersSet();

        newParameterSet1.setType(1);
        newParameterSet1.setValue(new BigDecimal(value1));
        newParameterSet2.setType(2);
        newParameterSet2.setValue(new BigDecimal(value2));
        newParameterSet3.setType(3);
        newParameterSet3.setValue(new BigDecimal(value3));
        newParameterSet4.setType(4);
        newParameterSet4.setValue(new BigDecimal(value4));


        parametersSetService.updateByPrimaryKeySelective(newParameterSet1);
        parametersSetService.updateByPrimaryKeySelective(newParameterSet2);
        parametersSetService.updateByPrimaryKeySelective(newParameterSet3);
        parametersSetService.updateByPrimaryKeySelective(newParameterSet4);
        log.info("修改成功=");
        return  "redirect:/get/serviceFee.page";
    }

}
