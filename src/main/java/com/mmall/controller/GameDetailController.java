package com.mmall.controller;

import com.alibaba.druid.stat.TableStat;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.*;
import com.mmall.service.GameDetailService;
import com.mmall.service.SkinDetailService;
import com.mmall.service.SkinStyleService;
import com.mmall.service.SkinTypeService;
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
@RequestMapping("/gameDetail")
public class GameDetailController {

    @Autowired
    private SkinDetailService skinDetailService;

    @Autowired
    private SkinStyleService skinStyleService;
    @Autowired
    private GameDetailService gameDetailService;
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
            String startTime=request.getParameter("startTime");
            String endTime=request.getParameter("endTime");
            log.info("皮肤详情列表"+param+startTime+endTime);
            PageHelper.startPage(curr,limit);
            List<GameDetail> details= gameDetailService.getAllGameDetail(param,startTime,endTime);
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

    @RequestMapping("/deleteByKey")
    @ResponseBody
    public LayUIResult deleteByKey(@RequestParam("id")Integer id){
        LayUIResult layUIResult= new LayUIResult();
        //删除
        log.info("删除皮肤id="+id);
        int num=gameDetailService.deleteByPrimaryKey(id);
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
        log.info("查询皮肤id--------selectByKey"+id);
        GameDetail gameDetail = gameDetailService.selectByPrimaryKey(id);
        model.addAttribute("gameDetail",gameDetail);

        return "pages/gameManageDetail";
    }


    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        String name = request.getParameter("name");
        String pirce = request.getParameter("pirce");
        String discount = request.getParameter("discount");
        String dicountUse = request.getParameter("dicountUse");
        String freeCount = request.getParameter("freeCount");
        String status = request.getParameter("status");
        String lastPlayTime = request.getParameter("lastPlayTime");
        String createTime = request.getParameter("createTime");
        String onShelfTime = request.getParameter("onShelfTime");
        String offShelfTime = request.getParameter("offShelfTime");
        String founder = request.getParameter("founder");
        GameDetail gameDetail=new GameDetail();
        gameDetail.setName(name);
        gameDetail.setPirce(Long.parseLong(pirce));
        if(discount!=null && !"".equals(discount)) {
            gameDetail.setDiscount(Long.parseLong(discount));
        }
        if(dicountUse==null || "".equals(dicountUse)){
            dicountUse="0";
        }
        gameDetail.setDicountUse(Integer.parseInt(dicountUse));
        gameDetail.setFreeCount(Integer.parseInt(freeCount));
        gameDetail.setStatus(Integer.parseInt(status));
//        gameDetail.setLastPlayTime(lastPlayTime);
        gameDetail.setCreateTime(new Date());
        if (status.equals("1")){
            gameDetail.setOnShelfTime(new Date());
        }else if (status.equals("0")){
            gameDetail.setOffShelfTime(new Date());
        }
        gameDetail.setFounder(founder);
        //设置默认值
        gameDetail.setPlayCount(0);
        System.out.println("新增的皮肤信息:"+gameDetail.toString());
        gameDetailService.insertSelective(gameDetail);
        return  "redirect:/get/gameManage.page";
    }

    /**
     * 修改
     * @param request
     * @return
     */
    @RequestMapping("/update")
    public String updateLearn(HttpServletRequest request){
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String pirce = request.getParameter("pirce");
        String discount = request.getParameter("discount");
        String dicountUse = request.getParameter("dicountUse");
        String freeCount = request.getParameter("freeCount");
        String status = request.getParameter("status");
        String founder = request.getParameter("founder");

        GameDetail gameDetail=new GameDetail();
        gameDetail.setId(Integer.parseInt(id));
        gameDetail.setName(name);
        gameDetail.setPirce(Long.parseLong(pirce));
        if(discount!=null && !"".equals(discount)) {
            gameDetail.setDiscount(Long.parseLong(discount));
        }
        if(dicountUse==null || "".equals(dicountUse)){
            dicountUse="0";
        }
        gameDetail.setDicountUse(Integer.parseInt(dicountUse));
        gameDetail.setFreeCount(Integer.parseInt(freeCount));
        gameDetail.setStatus(Integer.parseInt(status));
//        gameDetail.setLastPlayTime(lastPlayTime);
        gameDetail.setCreateTime(new Date());
        if (status.equals("1")){
            gameDetail.setOnShelfTime(new Date());
        }else if (status.equals("0")){
            gameDetail.setOffShelfTime(new Date());
        }
        gameDetail.setFounder(founder);
        log.info("修改皮肤信息id="+id);

        int result=gameDetailService.updateByPrimaryKeySelective(gameDetail);

        log.info("修改成功="+result);
        return  "redirect:/get/gameManage.page";
    }
}
