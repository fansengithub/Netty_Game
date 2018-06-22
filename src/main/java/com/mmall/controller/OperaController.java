package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.PianoShopMapper;
import com.mmall.model.*;
import com.mmall.service.LearnBookService;
import com.mmall.service.OperaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 曲谱管理
 */
@Slf4j
@RequestMapping("/opera")
@Controller
public class OperaController {
    @Autowired
    private OperaService operaService;
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private PianoShopMapper pianoShopMapper;

    //曲谱列表
    @RequestMapping(value = "/selOperas")
    @ResponseBody
    public LayUIResult getOperas(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 Model model, HttpServletRequest request) {
        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            log.info("param" + param);
            PageHelper.startPage(curr, limit);
            List<OperaDetail> operaDetails = operaService.selOperas(param);
            PageInfo pageInfo = new PageInfo(operaDetails);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(operaDetails);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        return layUIResult;
    }

    /**
     * 删除曲谱
     *
     * @param operaid
     * @return
     */
    @RequestMapping("/delOpera")
    @ResponseBody
    public LayUIResult delOpera(@RequestParam("operaid") String operaid) {
        LayUIResult result = new LayUIResult();
        log.info("删除" + operaid);
        int num = operaService.delOpera(Integer.parseInt(operaid));
        if (num > 0) {
            result.setCode(0);
            result.setMsg("成功");
        } else {
            result.setCode(1);
            result.setMsg("失败");
        }
        return result;
    }

    /**
     * 曲谱详情
     *
     * @param request
     * @param operaid
     * @return
     */
    @RequestMapping("/OperaDetail")
    public String OperaDetail(HttpServletRequest request, @RequestParam("operaid") Integer operaid, Model model) {
        log.info("曲谱详情" + operaid);
        OperaDetail operaDetail = operaService.selOperaDetail(operaid);
        //获取不是当前登录用户(机构的)的琴行
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        log.info("当前用户:" + user.getId());
        List<PianoShop> pianoShopList = pianoShopMapper.selectAllNotUser(user.getId());
        model.addAttribute("opera", operaDetail);
        model.addAttribute("pianoShopList", pianoShopList);
        log.info("opera" + operaDetail);
        log.info("pianoShopList" + pianoShopList.size());
        return "pages/OperaDetail";
    }

    /**
     * 修改曲谱
     *
     * @param operaDetail
     * @return
     */
    @RequestMapping(value = "/updateOpera", method = RequestMethod.POST)
    public String updateOpera(HttpServletRequest request, OperaDetail operaDetail, @RequestParam(value="lastname",required=false) Set<String> lastnameList) {
        String vehicle = request.getParameter("vehicle");
//        String[] lastname=request.getParameterValues("lastname");
        log.info("vehicle" + vehicle);
        log.info("lastnameList" + lastnameList);
//        log.info("lastname"+ Arrays.toString(lastname));
        log.info("opera" + operaDetail.getLearnbookName());
        if (vehicle != null) {
            operaDetail.setPianoshopRole("-1");
        } else {
            if(lastnameList!=null) {
                String str = "";
                int num = 0;
                for (String ss : lastnameList) {
                    if (num != 0) {
                        str += "|" + ss;
                    } else {
                        str += ss;
                    }
                    num++;
                }
                operaDetail.setPianoshopRole(str);
            }else {
                operaDetail.setPianoshopRole("0");
            }
        }

        int num = operaService.updateOpera(operaDetail);
        log.info("修改曲谱" + num);
        return "redirect:/get/seeOpera.page";
    }

    /**
     * 获取所有教材
     *
     * @return
     */
    @RequestMapping("/getLearn")
    @ResponseBody
    public Map<String, Object> getLearn() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<LearnbookDetail> learnbookDetails = learnBookService.getAllLean(null);
            map.put("data", learnbookDetails);
        } catch (Exception e) {
            map.put("err", 0);
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 获取未指定教材的曲谱
     *
     * @return
     */
    @RequestMapping("/getNoLeanOperas")
    public LayUIResult getNoLeanOperas(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                       Model model, HttpServletRequest request) {
        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            log.info("param" + param);
            PageHelper.startPage(curr, limit);
            List<OperaDetail> operaDetails = operaService.selOperas(param);
            PageInfo pageInfo = new PageInfo(operaDetails);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(operaDetails);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        return layUIResult;
    }
}
