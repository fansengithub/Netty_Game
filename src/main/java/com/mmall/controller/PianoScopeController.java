package com.mmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.*;
import com.mmall.model.*;
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
@RequestMapping("/pianoScope")
public class PianoScopeController {

    @Autowired
    private PianoShopScaleMapper pianoShopscaleMapper;
    @Autowired
    private PianoShopMapper pianoShopMapper;
    @Autowired
    private ElecPlayerMapper elecPlayerMapper;
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 分页和模糊查询获取琴行规模
     *
     * @param curr
     * @param limit
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/getPianoScope")
    @ResponseBody
    public LayUIResult getPianoScope(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                     @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                     Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");

            PageHelper.startPage(curr, limit);
            List<PianoShopScale> pianoShopScaleList = pianoShopscaleMapper.selectByParam(param);
            log.info("获取所有琴行规模!");
            PageInfo pageInfo = new PageInfo(pianoShopScaleList);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(pianoShopScaleList);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }

    @RequestMapping("/getPianoScopeState1")
    @ResponseBody
    public LayUIResult getPianoScopeState1(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                           Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");

            PageHelper.startPage(curr, limit);
            List<PianoShop> pianoShopScaleList = pianoShopMapper.selectAllState(param, startTime, endTime);
            log.info("获取所有琴行规模!");
            PageInfo pageInfo = new PageInfo(pianoShopScaleList);

            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(pianoShopScaleList);
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
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    @ResponseBody
    public LayUIResult deleteById(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        //删除
        log.info("删除琴行规模id=" + id);
        int num = pianoShopscaleMapper.deleteByPrimaryKey(id);
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
     * 查询
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/selectById")
    public String selectById(@RequestParam("id") Integer id, Model model) {
        log.info("查询琴行规模byId--------s" + id);
        PianoShopScale pianoShopScale = pianoShopscaleMapper.selectByPrimaryKey(id);
        model.addAttribute("pianoShopScale", pianoShopScale);

        return "pages/pianoScopeChange";
    }


    /**
     * 修改
     *
     * @param request
     * @return
     */
    @RequestMapping("/updatePianScope")
    public String updatePianScope(HttpServletRequest request) {
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        String maxTeacherNum = request.getParameter("maxTeacherNum");

        log.info("更新琴行规模!");
        PianoShopScale pianoShopScale = new PianoShopScale();
        pianoShopScale.setId(Integer.parseInt(id));
        pianoShopScale.setMaxTeacherNum(Integer.parseInt(maxTeacherNum));
        pianoShopScale.setType(type);

        pianoShopscaleMapper.updateByPrimaryKeySelective(pianoShopScale);
        log.info("修改成功=" + id);
        return "redirect:/get/getPianoScope.page";
    }

    /**
     * 修改为通关
     *
     * @param request
     * @return
     */
    @RequestMapping("/updatestate0")
    @ResponseBody
    public LayUIResult updatestate0(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));

        LayUIResult layUIResult = new LayUIResult();
        log.info("更新琴行规模!");
        PianoShop pianoShop = new PianoShop();
        pianoShop.setId(id);
        pianoShop.setState(0);

        log.info("修改成功=" + id);

        //改变老师的状态
        try {
            Teacher teacher = teacherMapper.selectAllByPianoshopTongguo(id);
            teacher.setState(0);
            //查询elecPlayer表中找琴行把信息复制到后台sysUser中
            //ElecPlayer elecPlayer = elecPlayerMapper.selectAllByPlayeridAndRole(id, 4);
            //查询琴行的信息

            PianoShop pianoShop1 = pianoShopMapper.selectByPrimaryKey(id);
            String telephone = pianoShop1.getTelephone();
            if (sysUserMapper.isPhoneCunzai(telephone) == 1) {
                SysUser sysUser = sysUserMapper.selectPhone(telephone);
                sysUser.setStatus(1);
                sysUserMapper.updateByPrimaryKeySelective(sysUser);     //后台琴行账号状态
                pianoShopMapper.updateByPrimaryKeySelective(pianoShop);   //修改琴行状态
                teacherMapper.updateByPrimaryKeySelective(teacher);     //修改老师的状态
                layUIResult.setMsg("操作成功！");
                layUIResult.setCode(0);
            } else {
                layUIResult.setMsg("后台管理没有或者已有多位琴行手机号注册！");
                layUIResult.setCode(1);
            }
        } catch (Exception e) {
            layUIResult.setMsg("操作失败！数据不完整");
            e.printStackTrace();
            layUIResult.setCode(1);
        }

        log.info("结果" + layUIResult);
        return layUIResult;
    }

    //    修改为未通过
    @RequestMapping("/updatestate2")
    @ResponseBody
    public LayUIResult updatestate2(HttpServletRequest request) {
        String id = request.getParameter("id");

        LayUIResult layUIResult = new LayUIResult();
        log.info("更新琴行规模!");
        PianoShop pianoShop = new PianoShop();
        pianoShop.setId(Integer.parseInt(id));
        pianoShop.setState(2);
        int num = pianoShopMapper.updateByPrimaryKeySelective(pianoShop);
        log.info("修改成功=" + id);
        if (num > 0) {
            layUIResult.setMsg("操作成功！");
            layUIResult.setCode(0);
        } else {
            layUIResult.setMsg("操作失败！");
            layUIResult.setCode(1);
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }
}
