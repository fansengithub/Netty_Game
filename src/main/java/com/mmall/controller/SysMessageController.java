package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.Object.GameWorld;
import com.mmall.model.LayUIResult;
import com.mmall.model.SkinType;
import com.mmall.model.SysMessage;
import com.mmall.netty.message.MessageSend;
import com.mmall.service.LearnBookService;
import com.mmall.service.SkinTypeService;
import com.mmall.service.SysMessageService;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/sysMessage")
public class SysMessageController {
    @Autowired
    private LearnBookService learnBookService;
    @Autowired
    private SkinTypeService  skinTypeService;
    @Autowired
    private SysMessageService sysMessageService;
    /**
     * 获取消息列表
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

            log.info("消息列表"+param+startTime+endTime);
            PageHelper.startPage(curr,limit);
            List<SysMessage> details= sysMessageService.getAllSysMessage(param,null,null);
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

    /**
     * 删除教材
     * @param id
     * @return
     */
    @RequestMapping("/deleteByKey")
    @ResponseBody
    public LayUIResult deleteByKey(@RequestParam("id")Integer id){
        LayUIResult layUIResult= new LayUIResult();
        //删除
        log.info("删除皮肤id="+id);
        int num=sysMessageService.deleteByPrimaryKey(id);
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
        log.info("查询--------selectByKey"+id);
        SysMessage sysMessage = sysMessageService.selectByPrimaryKey(id);
        model.addAttribute("sysMessage",sysMessage);
        return "pages/upSysMessage";
    }


    /**
     * 添加
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public String add(HttpServletRequest request){
        //发送的消息体
        String content = request.getParameter("content");
        SysMessage sysMessage=new SysMessage();
        sysMessage.setContent(content);
        //默认为系统消息
        sysMessage.setMessageType(2);
        //默认为全体成员id
        sysMessage.setObjectId(-1);
        //默认为全体会员
        sysMessage.setMessageObject("全体会员");
        sysMessage.setSendTime(new Date());

        //消息接口
        GameWorld.scheduledExecutorService.execute(()->{
            for (Map.Entry<String, ChannelHandlerContext> ss:
                    GameWorld.sessionList.entrySet()) {
                Map<String,String> re = new HashMap<>();
                re.put("message",content);
                MessageSend.send(ss.getValue(),"xiaoxi",re,false);

            }
        });


        log.info("新增消息信息:"+sysMessage.toString());
        sysMessageService.insertSelective(sysMessage);
        return  "redirect:/get/messageList.page";
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
//        SkinType  newskinType = new SkinType();
//        newskinType.setId(Integer.parseInt(id));
//        newskinType.setName(name);
//        log.info("修改广告="+id);
//
//        sysMessageService.updateByPrimaryKeySelective(newskinType);
//        log.info("修改成功="+id);
        return  "redirect:/get/skinType.page";
    }

}
