package com.mmall.controller;

import com.mmall.dao.ServiceProviderMapper;
import com.mmall.dao.ZnAreaMapper;
import com.mmall.model.ServiceProvider;
import com.mmall.model.ZnArea;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/znArea")
public class ZnAreaController {


    @Autowired
    private ZnAreaMapper znAreaMapper;
    @Autowired
    private ServiceProviderMapper serviceProviderMapper;

    // 区域管理
    @RequestMapping("/getListZnArea")
    @ResponseBody
    public List<ZnArea> getListZnArea(@RequestParam("parentId") String parentId) {
        List<ZnArea> znArea = znAreaMapper.selectAllAreaListByParentId(parentId);
        return znArea;
    }

    // 服务商的区域管理
    @RequestMapping("/getListZnAreaByserviceProvider")
    @ResponseBody
    public List<ZnArea> getListZnAreaByserviceProvider(@RequestParam("parentId") String parentId) {
        //得到当前市级区域的所有服务商
        List<ServiceProvider> serviceProviderList = serviceProviderMapper.getServiceProviderByZnAreaLike(parentId);
        List<String> shengjiList = new ArrayList<>();
        //得到该市所有的已有省id
        for (ServiceProvider serviceProvider : serviceProviderList
                ) {
            String[] arrStr = serviceProvider.getArea().split("\\?");
            for (String ss : arrStr) {
                if (ss.indexOf(parentId) != -1) {   //如果该段存在
                    log.info(ss.substring(ss.lastIndexOf("|") + 1));
                    shengjiList.add(ss.substring(ss.lastIndexOf("|") + 1));
                }
            }
        }

        List<ZnArea> znArea = znAreaMapper.selectAllAreaListByParentId(parentId);
        for (Iterator<ZnArea> it = znArea.iterator(); it.hasNext(); ) {
            ZnArea a = it.next();
            if (shengjiList.contains(a.getId())) {   //如果存在就删除
                it.remove();
            }
            ;
        }
        return znArea;
    }
}
