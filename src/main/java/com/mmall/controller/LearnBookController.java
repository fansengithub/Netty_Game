package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.dao.PianoShopMapper;
import com.mmall.model.*;
import com.mmall.service.LearnBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@Slf4j
@Controller
@RequestMapping("/learnbook")
public class LearnBookController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private OperaDetailMapper operaDetailMapper;
    @Autowired
    private PianoShopMapper pianoShopMapper;

    /**
     * 获取教材列表
     *
     * @param curr
     * @param limit
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/selAll")
    @ResponseBody
    public LayUIResult getAllLearnBook(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                       Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            log.info("教材列表" + param);
            PageHelper.startPage(curr, limit);
            List<LearnbookDetail> details = learnBookService.getAllLean(param);
            PageInfo pageInfo = new PageInfo(details);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(details);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }

    /**
     * 删除教材
     *
     * @param lid
     * @return
     */
    @RequestMapping("/dellearnbook")
    @ResponseBody
    public LayUIResult delLearnbook(@RequestParam("lid") Integer lid) {
        LayUIResult layUIResult = learnBookService.delLearn(lid);
        log.info("结果" + layUIResult);
        return layUIResult;
    }

    /**
     * 查询
     *
     * @param lid
     * @param model
     * @return
     */
    @RequestMapping("/sel")
    public String sel(HttpServletRequest request, @RequestParam("lid") Integer lid, Model model) {
        log.info("查询" + lid);
        //获取不是当前登录用户(机构的)的琴行
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        log.info("当前用户:" + user.getId());
        List<PianoShop> pianoShopList = pianoShopMapper.selectAllNotUser(user.getId());
        log.info("pianoShopList" + pianoShopList.size());
        LearnbookDetail learnbookDetail = learnBookService.selLearnbook(lid);
        model.addAttribute("learnbookDetail", learnbookDetail);
        model.addAttribute("pianoShopList", pianoShopList);

        return "pages/addLearnBook";
    }

    //异步查询所有没有绑定教材的曲谱
    @RequestMapping("/getNoLearnOpera")
    @ResponseBody
    public List<OperaDetail> getNoLearnOpera(Model model) {
        log.info("异步查询没有绑定教材的曲谱");
        List<OperaDetail> learnbookDetail = operaDetailMapper.getNoLearnOpera();
        log.info("learnbookDetail" + learnbookDetail.size());
        return learnbookDetail;
    }

    //异步绑定所有没有绑定教材的曲谱
    @RequestMapping("/bangding")
    @ResponseBody
    public int bangding(@RequestParam("learnbook1") Integer learnbook1, @RequestParam("searce1") Integer searce1, Model model) {
        //      learnbook1='+learnbook1+"&searce1"+searce1,
        log.info("异步绑定教材的曲谱教材id" + learnbook1 + "曲谱id" + searce1);
        OperaDetail operaDetail = new OperaDetail();
        operaDetail.setId(searce1);
        operaDetail.setLearnbookId(learnbook1);
        LearnbookDetail learnbookDetail = learnBookService.selectByPrimaryKey(learnbook1); //过得指定教材对象
        operaDetail.setLearnbookName(learnbookDetail.getName());
        //修改教材中曲谱总数  +1
        if (learnbookDetail.getOpernNum() == null) {
            learnbookDetail.setOpernNum(1);
        } else {
            learnbookDetail.setOpernNum(learnbookDetail.getOpernNum() + 1);
        }
        int m = operaDetailMapper.updateByPrimaryKeySelective(operaDetail);
        int n = learnBookService.updateByPrimaryKeySelective(learnbookDetail);
        return m;
    }

    /**
     * 添加
     *
     * @param learnbookDetail
     * @return
     */
    @RequestMapping("/add")
    public String addLearn(LearnbookDetail learnbookDetail) {
        log.info("添加");
        int num = learnBookService.addLearn(learnbookDetail);
        return "redirect:/get/learnBookManagement.page";
    }

    /**
     * 修改
     *
     * @param learnbookDetail
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(LearnbookDetail learnbookDetail, HttpServletRequest request, @RequestParam(value = "lastname", required = false) Set<String> lastnameList) {
        log.info("修改" + learnbookDetail.getLearnbookId());
        String vehicle = request.getParameter("vehicle");
        log.info("vehicle" + vehicle);
        log.info("lastnameList" + lastnameList);
        if (vehicle != null) {
            learnbookDetail.setPianoshopRole("-1");
        } else {
            if (lastnameList != null) {
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
                learnbookDetail.setPianoshopRole(str);
            } else {
                learnbookDetail.setPianoshopRole("0");
            }
        }
        learnBookService.updateLearn(learnbookDetail);
        return "redirect:/get/learnBookManagement.page";
    }

}
