package com.mmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.CmsAdverMapper;
import com.mmall.dao.LearnbookDetailMapper;
import com.mmall.dao.OperaDetailMapper;
import com.mmall.model.CmsAdver;
import com.mmall.model.LayUIResult;
import com.mmall.model.LearnbookDetail;
import com.mmall.model.OperaDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/cms")
public class CMSController {
    @Autowired
    CmsAdverMapper cmsAdverMapper;
    @Autowired
    private LearnbookDetailMapper learnbookDetailMapper;
    @Autowired
    private OperaDetailMapper operaDetailMapper;

    /**
     * @param curr
     * @param limit
     * @param type    type--1 滚动广告位    type--2热门广告位
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/selAll")
    @ResponseBody
    public LayUIResult getAllCMS(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                 @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                 @RequestParam(value = "type", defaultValue = "0") Integer type,
                                 Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            log.info("获取所有  cms --查询条件:" + param);
            PageHelper.startPage(curr, limit);
            log.info("type取值:" + type);

            List<CmsAdver> details = cmsAdverMapper.selAllCMSbyType(param, type);
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
     * 查询
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectByKey")
    public String selectByKey(@RequestParam("id") Integer id, Model model) {
        //    添加广告
        log.info("添加广告!");
        CmsAdver cmsAdver = cmsAdverMapper.selectByPrimaryKey(id);
        List<LearnbookDetail> learnbookDetailList = learnbookDetailMapper.selAllLearnBook(null);
        List<OperaDetail> operaDetailList = operaDetailMapper.selOperasByauthorOroperaName(null);
        model.addAttribute("learnbookDetailList", learnbookDetailList);
        model.addAttribute("operaDetailList", operaDetailList);
        model.addAttribute("cmsAdver", cmsAdver);
        log.info(learnbookDetailList.size() + "==" + operaDetailList.size());
        return "/pages/addAdver";
    }

    /**
     * 删除教材
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteByKey")
    @ResponseBody
    public LayUIResult deleteByKey(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        //删除
        int num = cmsAdverMapper.deleteByPrimaryKey(id);
        if (num > 0) {
            layUIResult.setMsg("删除成功！");
            layUIResult.setCode(0);
        } else {
            layUIResult.setMsg("删除失败！");
            layUIResult.setCode(1);
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }


    /**
     * 更新广告
     *
     * @param
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request,CmsAdver cmsAdver) {
        String textContent1 = request.getParameter("textContent1");
        String textContent2 = request.getParameter("textContent2");
        String textContent3 = request.getParameter("textContent3");
        String textContent4 = request.getParameter("textContent4");
        String contant = request.getParameter("contant");
        log.info("cmsAdver" + cmsAdver.getColumnType());
        Integer columnType = cmsAdver.getColumnType();
        log.info("修改的广告信息columnType" + columnType);

        if (columnType != null) {
            System.out.println("columnType  ---" + columnType);
            if (columnType == 1) {
                cmsAdver.setTextContent(textContent1);
            } else if (columnType == 2) {
                cmsAdver.setTextContent(textContent2);
            } else if (columnType == 3) {
                cmsAdver.setTextContent(textContent3);
            } else if (columnType == 4) {
                cmsAdver.setTextContent(textContent4);
                cmsAdver.setContant(contant);
            }
        }
        cmsAdverMapper.updateByPrimaryKeySelective(cmsAdver);

        return "redirect:/get/columnManagement.page";
    }

    /**
     * 添加广告
     *
     * @param
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request, CmsAdver cmsAdver) {
        String textContent1 = request.getParameter("textContent1");
        String textContent2 = request.getParameter("textContent2");
        String textContent3 = request.getParameter("textContent3");
        String textContent4 = request.getParameter("textContent4");
        String contant = request.getParameter("contant");
        log.info("cmsAdver" + cmsAdver.getColumnType());
        Integer columnType = cmsAdver.getColumnType();
        log.info("新增的广告信息columnType" + columnType);

        if (columnType != null) {
            System.out.println("columnType  ---" + columnType);
            if (columnType == 1) {
                cmsAdver.setTextContent(textContent1);
            } else if (columnType == 2) {
                cmsAdver.setTextContent(textContent2);
            } else if (columnType == 3) {
                cmsAdver.setTextContent(textContent3);
            } else if (columnType == 4) {
                cmsAdver.setTextContent(textContent4);
                cmsAdver.setContant(contant);
            }
        }
        cmsAdver.setCreateTime(new Date());
        cmsAdver.setType(1);
        cmsAdverMapper.insertSelective(cmsAdver);
        return "redirect:/get/columnManagement.page";
    }
}
