package com.mmall.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.*;
import com.mmall.model.*;
import com.mmall.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/huiYuanDetail")
public class HuiYuanDetailController {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    PianoShopScaleMapper pianoShopscaleMapper;
    @Autowired
    OrganizationMapper organizationMapper;
    @Autowired
    ServiceProviderMapper serviceProviderMapper;
    @Autowired
    PianoShopMapper pianoShopMapper;
    @Autowired
    ParentsMapper parentsMapper;
    @Autowired
    StudentsMapper studentsMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    WaitingMemberMapper waitingMemberMapper;
    @Autowired
    RechargeDetailMapper rechargeDetailMapper;
    @Autowired
    RechargePackageMapper rechargePackageMapper;
    @Autowired
    ConsumptionDetailMapper consumptionDetailMapper;
    @Autowired
    HomeworkDatailMapper homeworkDatailMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    CommentTeacToStuMapper commentTeacToStuMapper;
    @Autowired
    CommentParentTeacherMapper commentParentTeacherMapper;
    @Autowired
    LearnbookStyleMapper learnbookStyleMapper;
    @Autowired
    LearnboolSetService learnboolSetService;
    @Autowired
    ParameterSetService parameterSetService;


    @Autowired
    private SkinStyleService skinStyleService;
    @Autowired
    private SkinTypeService skinTypeService;
    @Autowired
    private ParametersSetService parametersSetService;
    @Autowired
    private BankcardDetailService bankcardDetailService;
    @Autowired
    private ElecPlayerMapper elecPlayerMapper;
    //phoneCodeMapper
    @Autowired
    private PhoneCodeMapper phoneCodeMapper;
    @Autowired
    private MembershipDuesMapper membershipDuesMapper;
    @Autowired
    private IncomeDetailMapper incomeDetailMapper;
    @Autowired
    private ZnAreaMapper znAreaMapper;
    @Autowired
    private ShareProfitMapper shareProfitMapper;
    @Autowired
    private MyJisuan myJisuan;

    //机构规模
    @RequestMapping("/selAll1")
    @ResponseBody
    public LayUIResult getAllLearnBook(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                       @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                       Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            List<PianoShopScale> details = pianoShopscaleMapper.selectByParam(param);
            log.info("details=" + details.size());
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

    //服务商
    @RequestMapping("/selAll2")
    @ResponseBody
    public LayUIResult getAllLearnBook2(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            List<ServiceProvider> details = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            details = serviceProviderMapper.selectAll(param, startTime, endTime);                     //总管理
//            for (IncomeDetail incomeDetail:details) {
//                incomeDetail.setRole(bankcardDetailMapper.getRoleNameByuserID(incomeDetail.getUserId()));
//            }
            log.info("details=" + details.size());
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

    //机构
    @RequestMapping("/selAll3")
    @ResponseBody
    public LayUIResult getAllLearnBook3(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            List<Organization> details = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                details = organizationMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                details = organizationMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            }
            log.info("details=" + details.size());
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

    //琴行
    @RequestMapping("/selAll4")
    @ResponseBody
    public LayUIResult getAllLearnBook4(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            List<PianoShop> details = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                details = pianoShopMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                details = pianoShopMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            } else if (xinxiType == 2) {
                details = pianoShopMapper.selectAllByOrganization(user.getXinxiId(), param, startTime, endTime);  //机构
            }
            log.info("details=" + details.size());
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

    //琴行
    @RequestMapping("/selAll7")
    @ResponseBody
    public LayUIResult getAllLearnBook7(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            List<Teacher> details = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                details = teacherMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                details = teacherMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            } else if (xinxiType == 2) {
                details = teacherMapper.selectAllByOrganization(user.getXinxiId(), param, startTime, endTime);  //机构
            } else if (xinxiType == 3) {
                details = teacherMapper.selectAllByPianoShop(user.getXinxiId(), param, startTime, endTime);  //琴行
            }
            log.info("details=" + details.size());
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

    //家长
    @RequestMapping("/selAll5")
    @ResponseBody
    public LayUIResult getAllLearnBook5(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            List<Parents> details = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                details = parentsMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                details = parentsMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            } else if (xinxiType == 2) {
                details = parentsMapper.selectAllByOrganization(user.getXinxiId(), param, startTime, endTime);  //机构
            } else if (xinxiType == 3) {
                details = parentsMapper.selectAllByPianoShop(user.getXinxiId(), param, startTime, endTime);  //琴行
            }
            log.info("details=" + details.size());
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

    //学生
    @RequestMapping("/selAll6")
    @ResponseBody
    public LayUIResult getAllLearnBook6(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                        Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String consumpType1 = request.getParameter("consumpType1");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("参数列表" + param + "," + consumpType1);
            PageHelper.startPage(curr, limit);
            List<Students> details = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                details = studentsMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                details = studentsMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            } else if (xinxiType == 2) {
                details = studentsMapper.selectAllByOrganization(user.getXinxiId(), param, startTime, endTime);  //机构
            } else if (xinxiType == 3) {
                details = studentsMapper.selectAllByPianoShop(user.getXinxiId(), param, startTime, endTime);  //琴行
            }
            log.info("details=" + details.size());
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

    //    服务商详细信息
    @RequestMapping("/serviceProviderDetail")
    public ModelAndView serviceProviderDetail(HttpServletRequest request, HttpServletResponse response, Model
            model) throws IOException, ServletException {

        log.info("服务商管理--详细信息!");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(id);
            List<ZnArea> znAreaList = znAreaMapper.selectAll();
            model.addAttribute("znAreaList", znAreaList);
            model.addAttribute("temp", serviceProvider);
            model.addAttribute("ZnareaListShow", myJisuan.getListZnArea(serviceProvider.getArea()));
            //分润总收入:
            model.addAttribute("getIncomeDetailCount", myJisuan.getIncomeDetailCount("1", id));
            //分润已提现金额
            model.addAttribute("getWitdrawDetaiCount", myJisuan.getWitdrawDetaiCount("1", id));
            //充值总量
            model.addAttribute("getRechargeDetaiCount", myJisuan.getRechargeDetaiCount("1", id));
            //消费金额
            model.addAttribute("getConsumtionDetaiCount", myJisuan.getConsumtionDetaiCount("1", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/serviceProviderDetail");
    }

    //    修改服务商
    @RequestMapping("/serviceProviderDetailUpdate")
    public String serviceProviderDetailUpdate(HttpServletRequest request, ServiceProvider serviceProvider, Model
            model) {
        int id = serviceProvider.getId();
        log.info("修改服务商!");
        try {
            int num = serviceProviderMapper.updateByPrimaryKeySelective(serviceProvider);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/huiYuanDetail/serviceProviderDetail?id=" + id;
    }

    //    删除服务商
    @RequestMapping("/serviceProviderDetailDelete")
    @ResponseBody
    public LayUIResult serviceProviderDetailDelete(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        log.info("删除服务商!");
        try {
            int num = serviceProviderMapper.deleteByPrimaryKey(id);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg("删除成功");
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("异常!");
        }
        return layUIResult;
    }

    //增加服务商的区域
    @RequestMapping("/addZnarea")
    @ResponseBody
    public LayUIResult addZnarea(@RequestParam("id") Integer id, @RequestParam("str") String str) {
        LayUIResult layUIResult = new LayUIResult();
        ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(id);
        serviceProvider.setArea(serviceProvider.getArea() + "?" + str);
        log.info("Area" + serviceProvider.getArea());
        int num = serviceProviderMapper.updateByPrimaryKeySelective(serviceProvider);
        if (num > 0) {
            layUIResult.setCode(0);
            layUIResult.setMsg(myJisuan.getZnArea(str));
        } else {
            layUIResult.setCode(1);
            layUIResult.setMsg("添加区域失败");
        }
        return layUIResult;
    }
    //删除服务商的区域
    @RequestMapping("/serviceProviderDetailDeleteByArea")
    @ResponseBody
    public LayUIResult serviceProviderDetailDeleteByArea(@RequestParam("id") Integer id, @RequestParam("str") String str) {
        LayUIResult layUIResult = new LayUIResult();
        ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(id);
        String[] strs = str.trim().split(" ");
        String str2="";
        for (int i = 0; i < 3; i++) {
            ZnArea znArea = znAreaMapper.selectByName(strs[i]);
            str2 += znArea.getId();
            if (i != 2) {
                str2 += "|";
            }
        }
        log.info("Area" + str2);
        serviceProvider.setArea(serviceProvider.getArea().replace("?"+str2,""));
        int num = serviceProviderMapper.updateByPrimaryKeySelective(serviceProvider);
        if (num > 0) {
            layUIResult.setCode(0);
            layUIResult.setMsg("删除区域成功");
        } else {
            layUIResult.setCode(1);
            layUIResult.setMsg("删除区域失败");
        }
        return layUIResult;
    }

    //    机构细信息
    @RequestMapping("/getOrginazDetail")
    public ModelAndView getOrginazDetail(HttpServletRequest request, Organization organization, Model
            model) throws IOException, ServletException {

        log.info("机构管理--详细信息!");
        try {
            int id = organization.getId();
            Organization organization2 = organizationMapper.selectByPrimaryKey(id);
            List<ZnArea> znAreaList = znAreaMapper.selectAll();
            model.addAttribute("znAreaList", znAreaList);
            model.addAttribute("temp", organization2);

            model.addAttribute("ZnareaShow", myJisuan.getZnArea(organization2.getArea()));
            //服务商信息
            model.addAttribute("serviceProcederShow", myJisuan.getServiceProviderByZnArea(organization2.getArea()));
            //分润总收入:
            model.addAttribute("getIncomeDetailCount", myJisuan.getIncomeDetailCount("2", id));
            //分润已提现金额
            model.addAttribute("getWitdrawDetaiCount", myJisuan.getWitdrawDetaiCount("2", id));
            //充值总量
            model.addAttribute("getRechargeDetaiCount", myJisuan.getRechargeDetaiCount("2", id));
            //消费金额
            model.addAttribute("getConsumtionDetaiCount", myJisuan.getConsumtionDetaiCount("2", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/orginazDetail");
    }

    //    修改机构
    @RequestMapping("/getOrginazDetailUpdate")
    public String getOrginazDetailUpdate(HttpServletRequest request, Organization organization, Model
            model) {
        int id = organization.getId();

        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        if (!"".equals(area1) && !"".equals(area2) && !"".equals(area3)) {
            organization.setArea(area1 + "|" + area2 + "|" + area3);
        }
        log.info(area1 + "|" + area2 + "|" + area3);
        log.info("修改机构!");
        try {
            int num = organizationMapper.updateByPrimaryKeySelective(organization);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/huiYuanDetail/getOrginazDetail?id=" + id;
    }

    //    删除机构
    @RequestMapping("/OrginazDetailDelete")
    @ResponseBody
    public LayUIResult OrginazDetailDelete(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        log.info("删除机构!");
        try {
            int num = organizationMapper.deleteByPrimaryKey(id);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg("删除成功");
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("异常!");
        }
        return layUIResult;
    }

    //琴行详细信息
    @RequestMapping("/pianoListDetail")
    public ModelAndView pianoListDetail(HttpServletRequest request, PianoShop organization, Model
            model) throws IOException, ServletException {

        log.info("琴行管理--详细信息!");
        try {
            int id = organization.getId();
            PianoShop organization2 = pianoShopMapper.selectByPrimaryKey(id);
            List<ZnArea> znAreaList = znAreaMapper.selectAll();
            model.addAttribute("znAreaList", znAreaList);
            model.addAttribute("temp", organization2);

            model.addAttribute("ZnareaShow", myJisuan.getZnArea(organization2.getArea()));
            //服务商信息
            model.addAttribute("serviceProcederShow", myJisuan.getServiceProviderByZnArea(organization2.getArea()));
            //分润总收入:
            model.addAttribute("getIncomeDetailCount", myJisuan.getIncomeDetailCount("3", id));
            //分润已提现金额
            model.addAttribute("getWitdrawDetaiCount", myJisuan.getWitdrawDetaiCount("3", id));
            //充值总量
            model.addAttribute("getRechargeDetaiCount", myJisuan.getRechargeDetaiCount("3", id));
            //消费金额
            model.addAttribute("getConsumtionDetaiCount", myJisuan.getConsumtionDetaiCount("3", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/pianoListDetail");
    }

    //    修改琴行
    @RequestMapping("/pianoListDetailUpdate")
    public String pianoListDetailUpdate(HttpServletRequest request, PianoShop pianoShop, Model
            model) {
        int id = pianoShop.getId();

        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        if (!"".equals(area1) && !"".equals(area2) && !"".equals(area3)) {
            pianoShop.setArea(area1 + "|" + area2 + "|" + area3);
        }
        log.info(area1 + "|" + area2 + "|" + area3);
        log.info("修改琴行!");
        try {
            int num = pianoShopMapper.updateByPrimaryKeySelective(pianoShop);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/huiYuanDetail/pianoListDetail?id=" + id;
    }

    //    删除琴行
    @RequestMapping("/pianoShopDelete")
    @ResponseBody
    public LayUIResult pianoShopDelete(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        log.info("删除琴行!");
        try {
            int num = pianoShopMapper.deleteByPrimaryKey(id);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg("删除成功");
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("异常!");
        }
        return layUIResult;
    }

    //老师详细信息
    @RequestMapping("/TeacherDetail")
    public ModelAndView TeacherDetail(HttpServletRequest request, Teacher teacher, Model
            model) throws IOException, ServletException {

        log.info("老师管理--详细信息!");
        try {
            int id = teacher.getId();
            Teacher organization2 = teacherMapper.selectByPrimaryKey(id);
            ElecPlayer elecPlayer = elecPlayerMapper.selectAllByPlayeridAndRole(id, 3);   //id  role
            List<ZnArea> znAreaList = znAreaMapper.selectAll();
            model.addAttribute("znAreaList", znAreaList);
            model.addAttribute("temp", organization2);
            model.addAttribute("elecPlayer", elecPlayer);

            //服务商信息
            model.addAttribute("serviceProcederShow", myJisuan.getServiceProviderByZnArea2(organization2.getArea()));
            //分润总收入:
            model.addAttribute("getIncomeDetailCount", myJisuan.getIncomeDetailCount("4", id));
            //分润已提现金额
            model.addAttribute("getWitdrawDetaiCount", myJisuan.getWitdrawDetaiCount("4", id));
            //充值总量
            model.addAttribute("getRechargeDetaiCount", myJisuan.getRechargeDetaiCount("4", id));
            //消费金额
            model.addAttribute("getConsumtionDetaiCount", myJisuan.getConsumtionDetaiCount("4", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/teacherListDetail");
    }

    //    修改老师
    @RequestMapping("/TeacherDetailUpdate")
    public String TeacherDetailUpdate(HttpServletRequest request, Teacher teacher, Model
            model) {
        int id = teacher.getId();

        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        if (!"".equals(area1) && !"".equals(area2) && !"".equals(area3)) {
            teacher.setArea(znAreaMapper.selectByPrimaryKey(area1).getAreaName() + " " + znAreaMapper.selectByPrimaryKey(area2).getAreaName() + " " + znAreaMapper.selectByPrimaryKey(area3).getAreaName());
        }
        log.info(area1 + "|" + area2 + "|" + area3);

        log.info("修改老师!");
        try {
            int num = teacherMapper.updateByPrimaryKeySelective(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/huiYuanDetail/TeacherDetail?id=" + id;
    }

    //    删除老师
    @RequestMapping("/TeacherDelete")
    @ResponseBody
    public LayUIResult TeacherDelete(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        log.info("删除老师!");
        try {
            int num = teacherMapper.deleteByPrimaryKey(id);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg("删除成功");
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("异常!");
        }
        return layUIResult;
    }

    //家长详细信息
    @RequestMapping("/ParentsDetail")
    public ModelAndView ParentsDetail(HttpServletRequest request, Parents parents, Model
            model) throws IOException, ServletException {

        log.info("家长管理--详细信息!");
        try {
            int id = parents.getId();
            Parents organization2 = parentsMapper.selectByPrimaryKey(id);
            ElecPlayer elecPlayer = elecPlayerMapper.selectAllByPlayeridAndRole(id, 2);   //id  role
            //查询所有的孩子
            List<Students> studentsList = studentsMapper.getStuNameByPid(id);
            List<ZnArea> znAreaList = znAreaMapper.selectAll();
            model.addAttribute("znAreaList", znAreaList);
            model.addAttribute("temp", organization2);
            model.addAttribute("elecPlayer", elecPlayer);
            model.addAttribute("studentsList", studentsList);
            //服务商信息
            model.addAttribute("serviceProcederShow", myJisuan.getServiceProviderByZnArea2(organization2.getArea()));
            //充值总量
            model.addAttribute("getRechargeDetaiCount", myJisuan.getRechargeDetaiCount("5", id));
            //消费金额
            model.addAttribute("getConsumtionDetaiCount", myJisuan.getConsumtionDetaiCount("5", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/parentListDetail");
    }

    //    修改家长
    @RequestMapping("/ParentsDetailUpdate")
    public String ParentsDetailUpdate(HttpServletRequest request, Parents parents, Model
            model) {
        int id = parents.getId();

        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        if (!"".equals(area1) && !"".equals(area2) && !"".equals(area3)) {
            parents.setArea(znAreaMapper.selectByPrimaryKey(area1).getAreaName() + " " + znAreaMapper.selectByPrimaryKey(area2).getAreaName() + " " + znAreaMapper.selectByPrimaryKey(area3).getAreaName());
        }

        log.info("修改家长!");
        try {
            int num = parentsMapper.updateByPrimaryKeySelective(parents);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/huiYuanDetail/ParentsDetail?id=" + id;
    }

    //    删除家长
    @RequestMapping("/ParentsDelete")
    @ResponseBody
    public LayUIResult ParentsDelete(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        log.info("删除家长!");
        try {
            int num = parentsMapper.deleteByPrimaryKey(id);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg("删除成功");
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("异常!");
        }
        return layUIResult;
    }

    //学生详细信息
    @RequestMapping("/StudentsDetail")
    public ModelAndView StudentsDetail(HttpServletRequest request, Students students, Model
            model) throws IOException, ServletException {

        log.info("学生管理--详细信息!");
        try {
            int id = students.getId();
            Students organization2 = studentsMapper.selectByPrimaryKey(id);
            ElecPlayer elecPlayer = elecPlayerMapper.selectAllByPlayeridAndRole(id, 1);   //id  role
            //查询所属的琴行
            if (organization2.getTeacherId() != null) {
                Teacher teacher = teacherMapper.selectByPrimaryKey(organization2.getTeacherId());
                model.addAttribute("teacher", teacher);
            }
            List<ZnArea> znAreaList = znAreaMapper.selectAll();
            model.addAttribute("znAreaList", znAreaList);
            model.addAttribute("temp", organization2);
            model.addAttribute("elecPlayer", elecPlayer);
            //服务商信息
            model.addAttribute("serviceProcederShow", myJisuan.getServiceProviderByZnArea2(organization2.getArea()));
            //充值总量
            model.addAttribute("getRechargeDetaiCount", myJisuan.getRechargeDetaiCount("6", id));
            //消费金额
            model.addAttribute("getConsumtionDetaiCount", myJisuan.getConsumtionDetaiCount("6", id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/studentListDetail");
    }

    //    修改学生
    @RequestMapping("/StudentsDetailUpdate")
    public String StudentsDetailUpdate(HttpServletRequest request, Students students, Model
            model) {
        int id = students.getId();

        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        if (!"".equals(area1) && !"".equals(area2) && !"".equals(area3)) {
            students.setArea(znAreaMapper.selectByPrimaryKey(area1).getAreaName() + " " + znAreaMapper.selectByPrimaryKey(area2).getAreaName() + " " + znAreaMapper.selectByPrimaryKey(area3).getAreaName());
        }

        log.info("修改学生!");
        try {
            int num = studentsMapper.updateByPrimaryKeySelective(students);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/huiYuanDetail/StudentsDetail?id=" + id;
    }

    //    删除学生
    @RequestMapping("/StudentsDelete")
    @ResponseBody
    public LayUIResult StudentsDelete(@RequestParam("id") Integer id) {
        LayUIResult layUIResult = new LayUIResult();
        log.info("删除学生!");
        try {
            int num = studentsMapper.deleteByPrimaryKey(id);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg("删除成功");
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("异常!");
        }
        return layUIResult;
    }
}
