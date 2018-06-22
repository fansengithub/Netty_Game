package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.model.*;
import com.mmall.service.*;
import com.mmall.service.Impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 编辑器用到的接口
 */
@Controller
@Slf4j
@RequestMapping("/editor")
public class EditorController {
    @Autowired
    private StyleService styleService;
    @Autowired
    private StageService stageService;
    @Autowired
    private DifficultySetService difficultySetService;

    @Autowired
    private OperaService operaService;

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerOperaService playerOperaService;


    /**
     * 获取曲谱编辑信息(风格，阶段，难度)
     * @return
     */
    @RequestMapping("/getMusicEditInfo")
    @ResponseBody
    public Map<String,Object> getMusicEditInfo(){
        log.info("获取曲谱编辑信息");
        Map<String,Object> map=new HashMap<>();
        try {
            List<LearnbookStage> stages= stageService.selAllStage();
            List<LearnbookStyle> styles=styleService.selAllStyle();
            List<DifficultySet> sets=difficultySetService.selAllDifficulty();
            map.put("style",styles);
            map.put("difficulty",sets);
            map.put("stage",stages);
            map.put("success",0);
        }catch (Exception e){
            e.getMessage();
            map.put("success",1);
            map.put("msg","获取失败！");
        }
        log.info("结果"+map);
       return map;
    }

    /**
     * 曲谱列表
     * @param request
     * @param page
     * @param num
     * @return
     */
    @RequestMapping("/getMusicList")
    @ResponseBody
    public Map<String,Object> getMusicList(HttpServletRequest request,
                                           @RequestParam(value = "page",defaultValue = "1")Integer page,
                                           @RequestParam(value="num",defaultValue ="7")Integer num){
        Map<String,Object> map=new HashMap<>();
        try {
            String param=request.getParameter("param");
            log.info("参数"+param);
            PageHelper.startPage(page,num);
            List<OperaDetail> operaDetails=operaService.selOperas(param);
            PageInfo pageInfo=new PageInfo(operaDetails);
            map.put("musics",operaDetails);
            map.put("pageNum",pageInfo.getPages()); //总页数
            map.put("msg","获取成功！");
        }catch (Exception e){
            e.getMessage();
            map.put("msg","获取失败！");
        }
        log.info("结果"+map);
        return map;
    }

    /**
     * 曲谱详情
     * @param request
     * @return
     */
    @RequestMapping("/getMusicInfo")
    @ResponseBody
    public Map<String,Object> getMusicInfo(HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        String operaId=request.getParameter("id");
        log.info("曲谱详情"+operaId);
        OperaDetail operaDetail=operaService.selOperaDetail(Integer.parseInt(operaId));
        if(operaDetail!=null){
            map.put("msg","获取成功！");
            map.put("data",operaDetail);
        }else{
            map.put("msg","获取失败！");
        }
        return map;
    }

    /**
     * 添加曲谱
     * @return
     */
    @RequestMapping("/setMusicNew")
    @ResponseBody
    public Map<String,Object> setMusicNew(){
        Map<String,Object> map =new HashMap<>();
        return map;
    }

    /**
     * 删除曲谱
     * @param oid
     * @return
     */
    @RequestMapping("/deleteMusic")
    @ResponseBody
    public Map<String,Object> delMusic(@RequestParam("id")Integer oid){
        log.info("删除曲谱"+oid);
        Map<String,Object> map=new HashMap<>();
        List<PlayerOpera> playerOperas=playerOperaService.getOperaByOid(oid);
        if(playerOperas!=null&&playerOperas.size()!=0){
            map.put("success",1);
            map.put("message","该曲谱已被用户购买或使用，无法删除！");
        }else{
            int num=operaService.delOpera(oid);
            log.info(""+num);
            if(num>0){
                map.put("success",0);
                map.put("message","删除成功！");
            }else{
                map.put("success",1);
                map.put("message","删除失败！");
            }
        }
        return  map;
    }

    /**
     * 用户登陆
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public LayUIResult Login(HttpServletRequest request, HttpServletResponse response){
        String username= request.getParameter("id");
        String psw=request.getParameter("pass");
        log.info("登陆"+username+""+psw);
        LayUIResult layUIResult=userService.userLogin(username,psw);
        log.info("结果"+layUIResult);
        return layUIResult;
    }

}


