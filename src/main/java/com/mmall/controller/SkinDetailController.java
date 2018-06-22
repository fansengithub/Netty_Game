package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.*;
import com.mmall.service.*;
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
@RequestMapping("/skinDetail")
public class SkinDetailController {

    @Autowired
    private SkinDetailService skinDetailService;

    @Autowired
    private SkinStyleService skinStyleService;
    @Autowired
    private SkinTypeService skinTypeService;
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
            List<SkinDetail> details= skinDetailService.getAllSkinDetail(param,startTime,endTime);
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
        int num=skinDetailService.deleteByPrimaryKey(id);
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
        SkinDetail skinDetail = skinDetailService.selectByPrimaryKey(id);
        model.addAttribute("skinDetail",skinDetail);
        List<SkinStyle> skinStyleList= skinStyleService.getAllSkinStyle(null);
        List<SkinType>  SkinTypeList=skinTypeService.getAllSkinType(null);
        model.addAttribute("skinStyleList",skinStyleList);
        model.addAttribute("SkinTypeList",SkinTypeList);
        return "pages/updateSkinDetail";
    }


    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String style = request.getParameter("style");
        String price1 = request.getParameter("price1");
        String price2 = request.getParameter("price2");
        String priceChoice = request.getParameter("priceChoice");
        String discount1 = request.getParameter("discount1");
        String discount2 = request.getParameter("discount2");
        String discountChoice = request.getParameter("discountChoice");
        String discountUse = request.getParameter("discountUse");
        String status = request.getParameter("status");
        String founder = request.getParameter("founder");
        SkinDetail skinDetail=new SkinDetail();
        skinDetail.setName(name);
        skinDetail.setType(type);
        skinDetail.setStyle(style);
        skinDetail.setPrice1(Long.parseLong(price1));
        if(price2!=null && !"".equals(price2)) {
            skinDetail.setPrice2(Long.parseLong(price2));
        }
        if(priceChoice==null || "".equals(priceChoice)){
            priceChoice="0";
        }
        skinDetail.setPriceChoice(Integer.parseInt(priceChoice));
        if(discount1!=null && !"".equals(discount1)) {
            skinDetail.setDiscount1(Long.parseLong(discount1));
        }
        if(discount2!=null && !"".equals(discount2)) {
            skinDetail.setDiscount2(Long.parseLong(discount2));
        }
        if(discountChoice==null || "".equals(discountChoice)){
            discountChoice="0";
        }
        skinDetail.setDiscountChoice(Integer.parseInt(discountChoice));
        skinDetail.setDiscountUse(Integer.parseInt(discountUse));
        skinDetail.setStatus(Integer.parseInt(status));
        skinDetail.setFounder(founder);
        //默认设置
        skinDetail.setPurchaseTime(0);
        skinDetail.setCreateTime(new Date());
        if (status.equals("1")){
            skinDetail.setOnShelfTime(new Date());
        }else if (status.equals("0")){
            skinDetail.setOffShelfTime(new Date());
        }
        System.out.println("新增的皮肤信息:"+skinDetail.toString());
        skinDetailService.insertSelective(skinDetail);
        return  "redirect:/get/skinManage.page";
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

        String type = request.getParameter("type");
        String style = request.getParameter("style");
        String price1 = request.getParameter("price1");
        String price2 = request.getParameter("price2");
        String priceChoice = request.getParameter("priceChoice");
        String discount1 = request.getParameter("discount1");
        String discount2 = request.getParameter("discount2");
        String discountChoice = request.getParameter("discountChoice");
        String discountUse = request.getParameter("discountUse");
        String status = request.getParameter("status");
        String founder = request.getParameter("founder");

        log.info("name"+name);
        log.info("type"+type);
        log.info("style"+style);
        log.info("price1"+price1);
        log.info("price2"+price2);
        log.info("priceChoice"+priceChoice);
        log.info("discount1"+discount1);
        log.info("discount2"+discount2);
        log.info("discountChoice"+discountChoice);
        log.info("discountUse"+discountUse);
        log.info("status"+status);
        SkinDetail skinDetail=new SkinDetail();
        skinDetail.setId(Integer.parseInt(id));
        skinDetail.setName(name);
        skinDetail.setType(type);
        skinDetail.setStyle(style);
        skinDetail.setPrice1(Long.parseLong(price1));
        if(price2!=null && !"".equals(price2)) {
            skinDetail.setPrice2(Long.parseLong(price2));
        }
        if(priceChoice==null || "".equals(priceChoice)){
            priceChoice="0";
        }
        skinDetail.setPriceChoice(Integer.parseInt(priceChoice));
        if(discount1!=null && !"".equals(discount1)) {
            skinDetail.setDiscount1(Long.parseLong(discount1));
        }
        if(discount2!=null && !"".equals(discount2)) {
            skinDetail.setDiscount2(Long.parseLong(discount2));
        }
        if(discountChoice==null || "".equals(discountChoice)){
            discountChoice="0";
        }
        skinDetail.setDiscountChoice(Integer.parseInt(discountChoice));
        skinDetail.setDiscountUse(Integer.parseInt(discountUse));
        skinDetail.setStatus(Integer.parseInt(status));
        skinDetail.setFounder(founder);
        //默认设置
        skinDetail.setPurchaseTime(0);
//        skinDetail.setCreateTime(new Date());
        if (status.equals("1")){
            skinDetail.setOnShelfTime(new Date());
        }else if (status.equals("0")){
            skinDetail.setOffShelfTime(new Date());
        }

        log.info("修改皮肤信息id="+id);

        int result=skinDetailService.updateByPrimaryKeySelective(skinDetail);

        log.info("修改成功="+result);
        return  "redirect:/get/skinManage.page";
    }
}
