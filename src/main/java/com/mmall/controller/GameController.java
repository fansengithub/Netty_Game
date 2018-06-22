package com.mmall.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mmall.dao.*;
import com.mmall.model.*;
import com.mmall.service.*;
import com.mmall.util.MD5Util;
import com.mmall.util.MessageUtils;
import com.mmall.util.MyUtils;
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
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Slf4j
@Controller
@RequestMapping("/get")
public class GameController {
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

    //    琴行规模
    @RequestMapping("/getPianoScope.page")
    public ModelAndView getPianoScope(HttpServletRequest request, HttpServletResponse respons, Model model) throws IOException, ServletException {
        log.info("list----琴行规模");
        return new ModelAndView("pages/pianoScope");

    }

    //    服务商管理
    @RequestMapping("/serviceProviderManage")
    public ModelAndView serviceProviderManage(HttpServletRequest request, HttpServletResponse response, Model
            model) throws IOException, ServletException {
        log.info("服务商管理!");
        return new ModelAndView("/pages/serviceProviderManage");


    }


    //机构管理
    @RequestMapping("/getOrginazList.page")
    public ModelAndView getOrginazList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("机构管理页面!");
        return new ModelAndView("/pages/orginazList");

    }


    @RequestMapping("/modifyOrginaze")
    public ModelAndView modifyOrginaze(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("modifyOrginaze");
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/orginazDetail");

    }

    //    琴行管理
    @RequestMapping("/getPianoList.page")
    public ModelAndView getPianoList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("琴行管理!");


        return new ModelAndView("/pages/pianoList");
    }


//    //    家长管理
    @RequestMapping("/getParent")
    public ModelAndView getParentList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {

        log.info("家长管理!");
        return new ModelAndView("/pages/parentList");
    }


    //    学生管理
    @RequestMapping("/getStudent")
    public ModelAndView getStudentList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("学生管理!");
        return new ModelAndView("/pages/studentList");
    }


//    //    老师管理
    @RequestMapping("/getTeacher")
    public ModelAndView getTeacherList(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {

        log.info("老师管理!");
        return new ModelAndView("/pages/teacherList");
    }

    //    待审核会员管理
    @RequestMapping("/getAuditMember")
    public ModelAndView getAuditMember(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("待审核会员!");
        return new ModelAndView("/pages/auditMember");
    }

    //    待审核会员 --详细信息
    @RequestMapping("/auditMemberDetail")
    public ModelAndView getAuditMemberDetail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        log.info("待审核会员  ---  详细信息!");

        return new ModelAndView("/pages/auditMemberDetail");
    }

    //    添加老师
    @RequestMapping("/addTeacher")
    public ModelAndView addTeacher(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("添加老师!");
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
        log.info("当前用户的身份" + sysUser.getXinxiType() + "信息的ID" + sysUser.getXinxiId());
        int xinxiType = sysUser.getXinxiType();
        //当前用户的可提现余额
        BigDecimal bigDecimal = null;
        if (xinxiType == 1) {
            ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = serviceProvider.getWithdrawBalance();
        } else if (xinxiType == 2) {
            Organization organization = organizationMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawBalance();
        } else if (xinxiType == 3) {
            PianoShop organization = pianoShopMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawalsBalance();
        } else if (xinxiType == 4) {
            Teacher organization = teacherMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getBalance();
        }

        model.addAttribute("bigDecimal", bigDecimal);
        List<PianoShop> pianoShopList = pianoShopMapper.selectAll(null, null, null);
        ParametersSet parametersSet = parametersSetService.selectByPrimaryKey(3);
        List<ZnArea> znAreaList = znAreaMapper.selectAll();
        model.addAttribute("znAreaList", znAreaList);        //区域管理
        model.addAttribute("pianoShopList", pianoShopList);    //琴行
        model.addAttribute("parametersSet", parametersSet);   //琴行创建老师消耗的熊掌
        return new ModelAndView("/pages/addTeacherDetail");

    }

    //发送验证码
    public boolean sendSmsCode(String number) {
        String code = MyUtils.SixMobileVfCode();
        try {
            // 发送短信
//            if (SmsCnUtil.httpRequest(number, template, content)) {
            if (MessageUtils.sendMessage(number, code)) {
                // 将该在线用户用手机号标记
                log.info("验证码发送成功！");
                PhoneCode phoneCode = new PhoneCode();
                phoneCode.setCode(code);
                Date date = new Date();
                phoneCode.setCreatetime(date);
                phoneCode.setPhone(number);
                phoneCode.setExpiredTime(new Date(10 * 60 * 1000 + date.getTime()));
                phoneCodeMapper.insertSelective(phoneCode);
                return true;
            } else {
                log.info("验证码发送失败！");
                return false;
            }

        } catch (Exception e) {
            log.info("验证码发送失败！");
            return false;
        }

    }

    //验证验证码
    @RequestMapping("/sendYanzhengma")
    @ResponseBody
    public String sendYanzhengma(@RequestParam("number") String number, @RequestParam("code") String code) {
        log.info("發送+number" + number + "code" + code);
        PhoneCode phoneCode = phoneCodeMapper.selectByPhone(number);
        if (phoneCode == null) {
            log.info("并没有给该手机号发送过验证码!");
            return "0";
        }
        // 验证码过期
        if (new Date().getTime() > phoneCode.getExpiredTime().getTime()) {
            log.info("验证码已过期!");
            return "1";
        }
        if (!phoneCode.getCode().equals(code)) {
            log.info("验证码错误!");
            return "2";
        }
        log.info("验证成功!");
        return "3";
    }

    //验证服务商是否被注册
    @RequestMapping("/sendSmsCodeByService")
    @ResponseBody
    public String sendSmsCodeByService(@RequestParam("number") String number, Model model) {
        log.info("手机号码=" + number);
        Long n = serviceProviderMapper.selectIsNotPhone(number);
        if (n > 0) {
            return "2";   //手机已经被注册了
        }
        if (sendSmsCode(number)) {
            return "1";     //发送成功
        }
        return "0";         //发送失败
    }

    //验证机构是否被注册
    @RequestMapping("/sendSmsCodeByOrganization")
    @ResponseBody
    public String sendSmsCodeByOrganization(@RequestParam("number") String number, Model model) {
        log.info("手机号码=" + number);
        Long n = organizationMapper.selectIsNotPhone(number);
        if (n > 0) {
            return "2";   //手机已经被注册了
        }
        if (sendSmsCode(number)) {
            return "1";     //发送成功
        }
        return "0";         //发送失败
    }

    //验证老师是否被注册
    @RequestMapping("/sendSmsCodeByTeacher")
    @ResponseBody
    public String sendSmsCodeByTeacher(@RequestParam("number") String number, Model model) {
        log.info("手机号码=" + number);
        Long n = teacherMapper.selectIsNotPhone(number);
        if (n > 0) {
            return "2";   //手机已经被注册了
        }
        if (sendSmsCode(number)) {
            return "1";     //发送成功
        }
        return "0";         //发送失败
    }

    /**
     * 添加老师数据
     *
     * @param request
     * @param teacher
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/addTeacherDetail")
    public String addTeacherDetail(HttpServletRequest request, Teacher teacher) throws IOException, ServletException {
        log.info("添加老师!");
        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        teacher.setArea(area1 + "|" + area2 + "|" + area3);
        String password = request.getParameter("password");
        String headurl = request.getParameter("headurl");
        int num = teacherMapper.insertSelective(teacher);      //创建一个老师信息
        log.info("插入数据的id为：" + teacher.getId());
        if (num > 0) {
//            Teacher teacher1 = teacherMapper.selectByPrimaryKey(teacher.getId());
            ElecPlayer elecPlayer = new ElecPlayer();
            elecPlayer.setPlayerId(teacher.getId());  //获取老师表中最后一个id老师
            elecPlayer.setPassword(MD5Util.encrypt(password));          //密码
            elecPlayer.setRoleType(3);     //'身份：1-学生，2-家长，3-老师，4-机构',
            elecPlayer.setHeadurl(headurl);             //头像
            elecPlayer.setName(teacher.getName());      //姓名
            elecPlayer.setPhone(teacher.getTelephone());    //过去手机号
            int nnn = elecPlayerMapper.insertSelective(elecPlayer);
            if (nnn > 0) {
                ParametersSet parametersSet = parametersSetService.selectByPrimaryKey(3);
                //消耗的熊掌
                BigDecimal xiaohao = parametersSet.getValue();
                SysUser user = (SysUser) request.getSession().getAttribute("user");
                SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
                log.info("当前用户的身份" + sysUser.getXinxiType() + "信息的ID" + sysUser.getXinxiId());
                int xinxiType = sysUser.getXinxiType();
                if (xinxiType == 1) {
                    ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(user.getXinxiId());
                    serviceProvider.setWithdrawBalance(serviceProvider.getWithdrawBalance().subtract(xiaohao));
                    serviceProviderMapper.updateByPrimaryKeySelective(serviceProvider);
                } else if (xinxiType == 2) {
                    Organization organization = organizationMapper.selectByPrimaryKey(user.getXinxiId());
                    organization.setWithdrawBalance(organization.getWithdrawBalance().subtract(xiaohao));
                    organizationMapper.updateByPrimaryKeySelective(organization);
                } else if (xinxiType == 3) {   //只有琴行创建老师
                    PianoShop organization = pianoShopMapper.selectByPrimaryKey(user.getXinxiId());
                    organization.setWithdrawalsBalance(organization.getWithdrawalsBalance().subtract(xiaohao));
                    pianoShopMapper.updateByPrimaryKeySelective(organization);
                    //进行分润统计    琴行创建老师部分   服务商和机构有分润
                    Long shareProfitSet = shareProfitMapper.selectByPrimaryKeyByRole(1).getCreateTeacherProfit();
                    Long shareProfitSet2 = shareProfitMapper.selectByPrimaryKeyByRole(2).getCreateTeacherProfit();
                    //机构收入
                    BigDecimal organizationshouru = xiaohao.divide(new BigDecimal("100")).multiply(new BigDecimal(shareProfitSet2));
                    //服务商收入
                    BigDecimal serviceProvidershouru = (xiaohao.subtract(organizationshouru)).divide(new BigDecimal("100")).multiply(new BigDecimal(shareProfitSet));
                    //总管理收入
                    BigDecimal zongMessageshouru = xiaohao.subtract(organizationshouru).subtract(serviceProvidershouru);
                    //等会做
                } else if (xinxiType == 4) {
                    Teacher teacher1 = teacherMapper.selectByPrimaryKey(user.getXinxiId());
                    teacher1.setBalance(teacher1.getBalance().subtract(xiaohao));
                    teacherMapper.updateByPrimaryKeySelective(teacher1);
                }

                log.info("添加老师数据成功!");
            } else {
                log.info("添加老师数据失败!");
            }


        }
        return "redirect:/get/addTeacher.page";
    }

    //    添加服务商
    @RequestMapping("/addService")
    public ModelAndView addService(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("添加服务商!1");

        List<ZnArea> znAreaList = znAreaMapper.selectAll();
        model.addAttribute("znAreaList", znAreaList);
        return new ModelAndView("/pages/addServiceDetail");

    }

    /**
     * 添加服务商数据
     *
     * @param request
     * @param serviceProvider
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/addServiceDetail")
    public String addTeacherDetail(HttpServletRequest request, ServiceProvider serviceProvider) throws IOException, ServletException {
        log.info("添加服务商!2");
        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        serviceProvider.setArea(area1 + "|" + area2 + "|" + area3);
        log.info(area1 + "|" + area2 + "|" + area3);
        int num = serviceProviderMapper.insertSelective(serviceProvider);      //创建一个服务商信息
        log.info("插入数据的id为：" + serviceProvider.getId());
        if (num > 0) {
//            Teacher teacher1 = teacherMapper.selectByPrimaryKey(serviceProvider.getId());
            SysUser sysUser = new SysUser();
            sysUser.setXinxiId(serviceProvider.getId());  //获取添加的服务商id
            sysUser.setXinxiType(1);  //服务为1
            sysUser.setPassword(MD5Util.encrypt(serviceProvider.getTelephone()));          //密码
            sysUser.setUsername(serviceProvider.getContacts());      //姓名
            sysUser.setTelephone(serviceProvider.getTelephone());    //手机号
            int nnn = sysUserMapper.insertSelective(sysUser);
            if (nnn > 0) {
                log.info("添加服务商数据成功!");
            } else {
                log.info("添加服务商数据失败!");
            }


        }
        return "redirect:/get/addService.page";
    }

    //    添加机构
    @RequestMapping("/addOrganization")
    public ModelAndView addOrganization(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("添加机构!");
        List<ZnArea> znAreaList = znAreaMapper.selectAll();
        model.addAttribute("znAreaList", znAreaList);
        return new ModelAndView("/pages/addOrganizationDetail");

    }

    /**
     * 添加机构数据
     *
     * @param request
     * @param organization
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @RequestMapping("/addOrganizationDetail")
    public String addOrganizationDetail(HttpServletRequest request, Organization organization) throws IOException, ServletException {
        log.info("添加机构!");
        String area1 = request.getParameter("area1");
        String area2 = request.getParameter("area2");
        String area3 = request.getParameter("area3");
        organization.setArea(area1 + "|" + area2 + "|" + area3);
        int num = organizationMapper.insertSelective(organization);      //创建一个服务商信息
        log.info("插入数据的id为：" + organization.getId());
        if (num > 0) {
//            Teacher teacher1 = teacherMapper.selectByPrimaryKey(serviceProvider.getId());
            SysUser sysUser = new SysUser();
            sysUser.setXinxiId(organization.getId());  //获取添加的服务商id
            sysUser.setXinxiType(2);  //机构为1
            sysUser.setPassword(MD5Util.encrypt(organization.getTelephone()));          //密码
            sysUser.setUsername(organization.getContacts());      //姓名
            sysUser.setTelephone(organization.getTelephone());    //手机号
            int nnn = sysUserMapper.insertSelective(sysUser);
            if (nnn > 0) {
                log.info("添加机构数据成功!");
            } else {
                log.info("添加机构数据失败!");
            }


        }
        return "redirect:/get/addOrganization.page";
    }

    //    添加机构绑定老师
    @RequestMapping("/addOrganizationByPianoShop")
    public ModelAndView addOrganizationByPianoShop(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, ServletException {
        log.info("添加机构!");
        List<ZnArea> znAreaList = znAreaMapper.selectAll();
        model.addAttribute("znAreaList", znAreaList);
        return new ModelAndView("/pages/addOrganizationByPianoShop");

    }

    //通过id差琴行的手机号
    @RequestMapping("/sendSelectTelephoneById")
    @ResponseBody
    public LayUIResult sendSelectTelephoneById(@RequestParam("jigouid") Integer jigouid, Model model) {
        log.info("机构id=" + jigouid);
        LayUIResult layUIResult = new LayUIResult();
        PianoShop pianoShop = pianoShopMapper.selectByPrimaryKey(jigouid);
        if (pianoShop != null) {
            layUIResult.setCode(0);
            layUIResult.setMsg(pianoShop.getTelephone());
        } else {
            layUIResult.setCode(1);
        }
        return layUIResult;         //发送失败
    }

    //验证该琴行是否有机构绑定
    @RequestMapping("/sendSmsSelectTelephone")
    @ResponseBody
    public LayUIResult sendSmsSelectTelephone(@RequestParam("jigouid") Integer jigouid, Model model) {
        log.info("机构id=" + jigouid);
        LayUIResult layUIResult = new LayUIResult();
        PianoShop pianoShop = pianoShopMapper.selectByPrimaryKey(jigouid);
        if (pianoShop != null) {
            if (pianoShop.getBelongtoOrginazeid() == null) {
                layUIResult.setCode(0);
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("该琴行已有机构绑定了");
            }
        } else {
            layUIResult.setCode(2);
            layUIResult.setMsg("未找到该琴行");
        }
        return layUIResult;         //发送失败
    }

    //发送验证ma 上
    @RequestMapping("/sendSelectTelephone")
    @ResponseBody
    public String sendSelectTelephone(@RequestParam("number") String number, Model model) {
        if (sendSmsCode(number)) {
            return "0";     //发送成功
        }
        return "1";         //发送失败
    }

    //发送验证ma 上
    @RequestMapping("/updatePianoshipByorganID")
    @ResponseBody
    public String updatePianoshipByorganID(@RequestParam("jigouid") Integer jigouid, HttpServletRequest request) {
        log.info("手机号码=" + jigouid);
        PianoShop pianoShop = pianoShopMapper.selectByPrimaryKey(jigouid);
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        pianoShop.setBelongtoOrginazeid(user.getXinxiId());
        int num = pianoShopMapper.updateByPrimaryKeySelective(pianoShop);
        if (num > 0) {
            return "0";     //发送成功
        }
        return "1";         //发送失败
    }

    //    充值明细
    @RequestMapping("/getRechargeDetail")
    public ModelAndView getRechargeDetail(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {

        log.info("充值明细!");
        return new ModelAndView("/pages/rechargeDetail");
    }

    //    充值中心
    @RequestMapping("/rechargeCenter")
    public ModelAndView rechargeCenter(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("我!");
        List<RechargePackage> rechargePackageList = rechargePackageMapper.selectAll();
        model.addAttribute("rechargePackageList", rechargePackageList);
        return new ModelAndView("/pages/rechargeCenter");
    }

    //充值中心计算
    @RequestMapping("/sendrechargeCenterjisuan")
    @ResponseBody
    public LayUIResult sendrechargeCenterjisuan(@RequestParam("money") String money) {
        log.info("钱" + money);
        LayUIResult layUIResult = new LayUIResult();
        layUIResult.setMsg(money);
        layUIResult.setCode(0);
//        PhoneCode phoneCode = phoneCodeMapper.selectByPhone(number);
        return layUIResult;
    }

    //    充值明细查询
    @RequestMapping("/selAllRechargeDetail")
    @ResponseBody
    public LayUIResult selAllRechargeDetail(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                            Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("提现列表" + param + startTime + endTime);
            PageHelper.startPage(curr, limit);
            List<RechargeDetail> list = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                list = rechargeDetailMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                list = rechargeDetailMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            } else if (xinxiType == 2) {
                list = rechargeDetailMapper.selectAllByOrganization(user.getXinxiId(), param, startTime, endTime);  //机构
            } else if (xinxiType == 3) {
                list = rechargeDetailMapper.selectAllByPianoShop(user.getXinxiId(), param, startTime, endTime);  //琴行
            }
            log.info("details=" + list.size());
            PageInfo pageInfo = new PageInfo(list);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(list);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }

    //    充值管理
    @RequestMapping("/rechargeManagement")
    public ModelAndView rechangeManagement(HttpServletRequest request, HttpServletResponse response, Model
            model) throws IOException, ServletException {
        log.info("充值管理!");

//      获取当前登录的用户信息
//        SysUser sysUser = (SysUser)request.getSession().getAttribute("user");
//        System.out.println("--------sysUser"+sysUser);

        try {
            String curr = request.getParameter("curr");
            String limit = request.getParameter("limit");
            String param = request.getParameter("param");
            int currPage = 1;
            int limitPage = 10;
            if (curr == null || curr == "") {
            } else {
                currPage = Integer.parseInt(curr);

            }
            if (limit == null || limit == "") {
            } else {
                limitPage = Integer.parseInt(limit);

            }

            log.info("curr---" + currPage + "limit  ---" + limitPage);
            PageHelper.startPage(currPage, limitPage);

            List<RechargePackage> list = rechargePackageMapper.selectByParam(param);
//            PianoShopScale list =pianoShopscaleMapper.selectByPrimaryKey(50);

            PageInfo pageInfo = new PageInfo(list);
            model.addAttribute("list", list);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("param", param);

            log.info("list----" + list);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/rechargeManagement");
    }

    //    添加充值套餐
    @RequestMapping("/addRecharge")
    public String addRecharge(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("添加充值套餐!");
        try {
            String object = request.getParameter("object");
            String money = request.getParameter("money");

            RechargePackage rechargePackage = new RechargePackage();
            rechargePackage.setRechargeMonry(Long.parseLong(money));
            rechargePackage.setRechargeObject(Long.parseLong(object));


            rechargePackageMapper.insertSelective(rechargePackage);
            log.info("添加老师数据成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/get/rechargeManagement.page";

    }

    //    充值套餐删除
    @RequestMapping("deleteRecharge")
    public String deleteRecharge(HttpServletRequest request) {

        String id = request.getParameter("id");
        try {
            log.info("充值套餐删除  id--" + id);
            int num = rechargePackageMapper.deleteByPrimaryKey(Integer.parseInt(id));
            if (num == 1) {
                System.out.println("删除充值套餐成功!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/get/rechargeManagement.page";

    }

    //     消费明细
    @RequestMapping("/getConsumDetail.page")
    public ModelAndView getConsumDetail(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {

        log.info("消费明细");
//        try {
//            String curr = request.getParameter("curr");
//            String limit = request.getParameter("limit");
//            String param = request.getParameter("param");
//            int currPage = 1;
//            int limitPage = 10;
//            if (curr == null || curr == "") {
//            } else {
//                currPage = Integer.parseInt(curr);
//
//            }
//            if (limit == null || limit == "") {
//            } else {
//                limitPage = Integer.parseInt(limit);
//
//            }
//
//            log.info("琴行规模展示页面.");
//            log.info("curr---" + currPage + "limit  ---" + limitPage);
//            PageHelper.startPage(currPage, limitPage);
//
//            List<ConsumptionDetail> list = null;
//            SysUser user=(SysUser) request.getSession().getAttribute("user");
//            int xinxiType=user.getXinxiType();
//            log.info("xinxiType"+xinxiType);
//            if (xinxiType==0){
//                list = consumptionDetailMapper.selectAll(param);                       //总管理
//            }else if(xinxiType==1){
//                list = consumptionDetailMapper.selectAllByService(user.getXinxiId(),param);  //服务商
//            }else if(xinxiType==2){
//                list = consumptionDetailMapper.selectAllByOrganization(user.getXinxiId(),param);  //机构
//            }else if(xinxiType==3){
//                list = consumptionDetailMapper.selectAllByPianoShop(user.getXinxiId(),param);  //琴行
//            }
//
//            PageInfo pageInfo = new PageInfo(list);
//            model.addAttribute("list", list);
//            model.addAttribute("pageInfo", pageInfo);
//            model.addAttribute("param", param);
//
//            log.info("list----" + list);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return new ModelAndView("/pages/consumDetail");
    }

    //    消费明细查询
    @RequestMapping("/selAllConsumDetail")
    @ResponseBody
    public LayUIResult selAllConsumDetail(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                          @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                          Model model, HttpServletRequest request) {

        LayUIResult layUIResult = new LayUIResult();
        try {
            String param = request.getParameter("keyword");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            log.info("提现列表" + param + startTime + endTime);
            PageHelper.startPage(curr, limit);
            List<ConsumptionDetail> list = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                list = consumptionDetailMapper.selectAll(param, startTime, endTime);                       //总管理
            } else if (xinxiType == 1) {
                list = consumptionDetailMapper.selectAllByService(user.getXinxiId(), param, startTime, endTime);  //服务商
            } else if (xinxiType == 2) {
                list = consumptionDetailMapper.selectAllByOrganization(user.getXinxiId(), param, startTime, endTime);  //机构
            } else if (xinxiType == 3) {
                list = consumptionDetailMapper.selectAllByPianoShop(user.getXinxiId(), param, startTime, endTime);  //琴行
            }
            log.info("details=" + list.size());
            PageInfo pageInfo = new PageInfo(list);
            layUIResult.setCode(0);
            layUIResult.setMsg("获取成功");
            layUIResult.setData(list);
            layUIResult.setCount(pageInfo.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            layUIResult.setCode(1);
            layUIResult.setMsg("获取失败！");
        }
        log.info("结果" + layUIResult);
        return layUIResult;
    }

    //    作业管理
    @RequestMapping("/taskManagement")
    public ModelAndView taskManagement(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {

        log.info("作业管理");
        try {
            String curr = request.getParameter("curr");
            String limit = request.getParameter("limit");
            String param = request.getParameter("param");
            int currPage = 1;
            int limitPage = 10;
            if (curr == null || curr == "") {
            } else {
                currPage = Integer.parseInt(curr);

            }
            if (limit == null || limit == "") {
            } else {
                limitPage = Integer.parseInt(limit);

            }

            log.info("琴行规模展示页面.");
            log.info("curr---" + currPage + "limit  ---" + limitPage);
            PageHelper.startPage(currPage, limitPage);

            List<HomeworkDatail> list = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                list = homeworkDatailMapper.selectAll(param);                       //总管理
            } else if (xinxiType == 1) {
                list = homeworkDatailMapper.selectAllByService(user.getXinxiId(), param);  //服务商
            } else if (xinxiType == 2) {
                list = homeworkDatailMapper.selectAllByOrganization(user.getXinxiId(), param);  //机构
            } else if (xinxiType == 3) {
                list = homeworkDatailMapper.selectAllByPianoShop(user.getXinxiId(), param);  //琴行
            }

            PageInfo pageInfo = new PageInfo(list);
            model.addAttribute("list", list);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("param", param);

            log.info("list----" + list);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/taskManagement");
    }

    //    评语管理
    @RequestMapping("/commentManagement")
    public ModelAndView commentManagement(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("评语管理");
        return new ModelAndView("/pages/commentManagement");
    }

    @RequestMapping("/commentList")
    @ResponseBody
    public LayUIResult commentList(@RequestParam(value = "page", defaultValue = "1") Integer curr,
                                   @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                   Model model, HttpServletRequest request) {
        LayUIResult result = new LayUIResult();
        try {
            PageHelper.startPage(curr, limit);
            List<Comment> comments = commentMapper.getComments();
            PageInfo pageInfo = new PageInfo(comments);
            result.setCount(pageInfo.getTotal());
            result.setData(comments);
            result.setCode(0);
            result.setMsg("获取成功");
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("获取失败");
        }
        return result;
    }

    //删除评语
    @RequestMapping("/delComment")
    @ResponseBody
    public LayUIResult delComment(HttpServletRequest request) {
        log.info("删除");
        LayUIResult result = new LayUIResult();
        String cid = request.getParameter("cid");
        try {
            int num = commentMapper.deleteByPrimaryKey(Integer.parseInt(cid));
            if (num > 0) {
                result.setCode(0);
                result.setMsg("删除成功");
            } else {
                result.setCode(1);
                result.setMsg("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("删除失败");
        }
        return result;
    }

    @RequestMapping("/selectOneComment")
    @ResponseBody
    public Comment selectOneComment(HttpServletRequest request, Model model) {
        log.info("查询单个");
        LayUIResult result = new LayUIResult();
        String cid = request.getParameter("cid");
        Comment comment = null;
        try {
            comment = commentMapper.selectByPrimaryKey(Integer.parseInt(cid));
        } catch (Exception e) {
            e.printStackTrace();
            result.setMsg("查询单个失败");
        }
        return comment;
    }

    //添加评语
    @RequestMapping("/addComment")
    @ResponseBody
    public LayUIResult addComment(HttpServletRequest request) {
        log.info("添加");
        LayUIResult result = new LayUIResult();
        String content = request.getParameter("content");
        String id = request.getParameter("id");
        Comment comment = new Comment();
        int num = 0;
        try {
            if (id != null && !"".equals(id)) {
                comment.setId(Integer.parseInt(id));
                comment.setContent(content);
                num = commentMapper.updateByPrimaryKey(comment);
                log.info("修改成功");
            } else {
                comment.setContent(content);
                num = commentMapper.insert(comment);
                log.info("添加成功");
            }
            if (num > 0) {
                result.setCode(0);
                result.setMsg("添加或修改成功");
            } else {
                result.setCode(1);
                result.setMsg("添加或修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(1);
            result.setMsg("添加或修改失败");
        }
        return result;
    }

    //    学生点评
    @RequestMapping("/studentComment")
    public ModelAndView studentComment(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("学生点评");
//        后台获取当前用户
//        Principal principal = request.getUserPrincipal();
//        log.info("获取当前用户: -- id"+principal.getName());
        try {
            String curr = request.getParameter("curr");
            String limit = request.getParameter("limit");
            String param = request.getParameter("param");
            int currPage = 1;
            int limitPage = 10;
            if (curr == null || curr == "") {
            } else {
                currPage = Integer.parseInt(curr);

            }
            if (limit == null || limit == "") {
            } else {
                limitPage = Integer.parseInt(limit);

            }

            log.info("curr---" + currPage + "limit  ---" + limitPage);
            PageHelper.startPage(currPage, limitPage);

            List<CommentTeacToStu> list = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                list = commentTeacToStuMapper.selectAll(param);                       //总管理
            } else if (xinxiType == 1) {
                list = commentTeacToStuMapper.selectAllByService(user.getXinxiId(), param);  //服务商
            } else if (xinxiType == 2) {
                list = commentTeacToStuMapper.selectAllByOrganization(user.getXinxiId(), param);  //机构
            } else if (xinxiType == 3) {
                list = commentTeacToStuMapper.selectAllByPianoShop(user.getXinxiId(), param);  //琴行
            }
            PageInfo pageInfo = new PageInfo(list);
            model.addAttribute("list", list);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("param", param);

            log.info("list----" + list);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/studentComment");
    }

    @RequestMapping("/deleteCommentFromStu")
    public String deleteCommentFromStu(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");
            log.info("删除学生对老师的评语---id" + id);

            if (id != null || id != "") {
                commentTeacToStuMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/get/studentComment.page";
    }

    //    家长给老师寄语
    @RequestMapping("/parentCommentTeacher")
    public ModelAndView parentCommentTeacher(HttpServletRequest request, HttpServletResponse response, Model
            model) throws IOException, ServletException {

        log.info("家长给老师寄语!");
        try {
            String curr = request.getParameter("curr");
            String limit = request.getParameter("limit");
            String param = request.getParameter("param");
            int currPage = 1;
            int limitPage = 10;
            if (curr == null || curr == "") {
            } else {
                currPage = Integer.parseInt(curr);

            }
            if (limit == null || limit == "") {
            } else {
                limitPage = Integer.parseInt(limit);

            }

            log.info("琴行规模展示页面.");
            log.info("curr---" + currPage + "limit  ---" + limitPage);
            PageHelper.startPage(currPage, limitPage);

            List<CommentParentTeacher> list = null;
            SysUser user = (SysUser) request.getSession().getAttribute("user");
            int xinxiType = user.getXinxiType();
            log.info("xinxiType" + xinxiType);
            if (xinxiType == 0) {
                list = commentParentTeacherMapper.selectAll(param);                       //总管理
            } else if (xinxiType == 1) {
                list = commentParentTeacherMapper.selectAllByService(user.getXinxiId(), param);  //服务商
            } else if (xinxiType == 2) {
                list = commentParentTeacherMapper.selectAllByOrganization(user.getXinxiId(), param);  //机构
            } else if (xinxiType == 3) {
                list = commentParentTeacherMapper.selectAllByPianoShop(user.getXinxiId(), param);  //琴行
            }
            PageInfo pageInfo = new PageInfo(list);
            model.addAttribute("list", list);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("param", param);

            log.info("list----" + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("/pages/parentCommentTeacher");
    }

    //    删除家长对老师的评语
//                return "redirect:/GameController/getTeacherList"
    @RequestMapping("/deleteCommentTeacher")
    public String deleteCommentTeacher(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");
            log.info("删除家长对老师的评语---id" + id);

            if (id != null || id != "") {
                commentParentTeacherMapper.deleteByPrimaryKey(Integer.parseInt(id));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/get/parentCommentTeacher.page";
    }


    //    CMS管理
    @RequestMapping("/columnManagement")
    public ModelAndView columnManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("CMS管理---滚动广告位!");
        return new ModelAndView("pages/rollingAdverment");
    }

    //    内容管理
    @RequestMapping("/contentManagement")
    public ModelAndView contentManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("内容管理!");
        return new ModelAndView("/pages/contentManagement");
    }

    //    滚动广告位
    @RequestMapping("/rollingAdverment")
    public ModelAndView rollingAdverment(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("滚动广告位 --!");
        return new ModelAndView("pages/rollingAdverment");
    }

    //    热门广告位
    @RequestMapping("/popularAdverment")
    public ModelAndView popularAdverment(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("滚动广告位--热门广告位!");
//        return  new ModelAndView("pages/rollingAdverment");

        return new ModelAndView("/pages/popularAdverment");
    }

    //    添加广告信息
    @RequestMapping("/addAdverment")
    public ModelAndView addAdverment(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("添加广告信息!");
        return new ModelAndView("/pages/addAdverment");
    }


    //    阶段管理
    @RequestMapping("/stageManagement")
    public ModelAndView stageManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("阶段管理!");
        return new ModelAndView("/pages/stageManagement");
    }

    //    风格管理
    @RequestMapping("/styleManagement")
    public ModelAndView styleManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("风格管理!");
        return new ModelAndView("/pages/styleManagement");
    }


    /**
     * 删除教材风格
     * @param styleId
     * @return
     */
//    @RequestMapping("/deleteTextStyle")
//    @ResponseBody
//    public LayUIResult deleteTextStyle(@RequestParam("styleId")String styleId){
//        LayUIResult result=new LayUIResult();
//        try {
//            log.info("教材风格删除---"+styleId);
//            int num = 0 ;
//            if (styleId !=null && styleId !=""){
//                num =learnbookStyleMapper.deleteByPrimaryKey(Integer.parseInt(styleId));
//            }
//            if(num>0){
//                result.setCode(0);
//                result.setMsg("成功");
//            }else{
//                result.setCode(1);
//                result.setMsg("失败");
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return result;
//    }

    /**
     * 教材风格详情
     *
     * @param
     * @return
     */
//    @RequestMapping("/textStyleDetail")
//    public String textStyleDetail(@RequestParam("styleId") String styleId,Model model){
//        try {
//
//            log.info("教材风格详情-----"+styleId);
//            LearnbookStyle temp = learnbookStyleMapper.selectByPrimaryKey(Integer.parseInt(styleId));
//            model.addAttribute("learnbookStyle",temp);
//            log.info("opera"+temp);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return "pages/OperaDetail";
//    }


    //    教材管理
    @RequestMapping("/learnBookManagement")
    public ModelAndView learnBookManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("教材管理!");
        return new ModelAndView("/pages/learnBookManagement");
    }

    //    添加教材
    @RequestMapping("/addLearnBook")
    public ModelAndView addLearnBook(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("添加教材!");
        return new ModelAndView("/pages/addLearnBook");
    }

    //    添加广告
    @RequestMapping("/addAdver")
    public ModelAndView addAdver(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("添加广告!");

        CmsAdver cmsAdver = new CmsAdver();
        cmsAdver.setType(Integer.parseInt(request.getParameter("type")));
        model.addAttribute("cmsAdver", cmsAdver);
        return new ModelAndView("/pages/addAdver");
    }

    //    查看教材曲谱数
    @RequestMapping("/seeOpera")
    public ModelAndView seeOpera(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("查看教材曲谱数!");
        return new ModelAndView("/pages/seeOpera");
    }

    //    曲谱管理
    @RequestMapping("/operaManagement")
    public ModelAndView operaManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("曲谱管理!");
        return new ModelAndView("/pages/operaManagement");
    }

    //    提现审批
    @RequestMapping("/withdrawExamine")
    public ModelAndView testManagement(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("提现审批22");
        return new ModelAndView("/pages/withdrawExamine2");
    }

    //    分润系统
    @RequestMapping("/shareProfitSetting")
    public ModelAndView shareProfitSetting(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("分润系统");
        return new ModelAndView("/pages/shareProfitSetting2");
    }

    //      银行卡展示
    @RequestMapping("/bankCardDetail")
    public ModelAndView bankCardDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("银行卡展示");
        return new ModelAndView("/pages/bankCardDetail2");
    }

    //    添加银行卡
    @RequestMapping("/addBankCard")
    public ModelAndView addBankCard(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("添加银行卡");
        return new ModelAndView("/pages/addBankCard");
    }

    //    收入明细
    @RequestMapping("/incomeDetail")
    public ModelAndView incomeDetail(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {

        log.info("收入明细");
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        Integer Count = incomeDetailMapper.getIncomeDetailById(user.getXinxiType().toString(), user.getXinxiId());
        log.info("收入明细" + Count);
        if (Count == null) {
            Count = 0;
        }
        model.addAttribute("Count", Count);
        return new ModelAndView("/pages/incomeDetail2");
    }


    //    皮肤类型
    @RequestMapping("/skinType")
    public ModelAndView skinType(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("皮肤类型!");
        return new ModelAndView("/pages/skinTypeShow2");
    }

    //添加皮肤类型
    @RequestMapping("/addSkinType")
    public ModelAndView addSkinType(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("添加皮肤类型!");
        return new ModelAndView("/pages/addSkinType");
    }

    //    皮肤类型管理
    @RequestMapping("/skinTypeDetail")
    public ModelAndView skinTypeDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("皮肤类型管理!");
        return new ModelAndView("/pages/skinTypeDetail");
    }

    //  皮肤风格
    @RequestMapping("/skinStyle")
    public ModelAndView skinStyle(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("皮肤风格!");
        return new ModelAndView("/pages/skinStyle2");
    }

    //添加皮肤类型
    @RequestMapping("/addSkinStyle")
    public ModelAndView addSkinStyle(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("添加皮肤风格!");
        return new ModelAndView("/pages/addSkinStyle");
    }

    //    皮肤风格管理细节
    @RequestMapping("/skinStyleDetail")
    public ModelAndView skinStyleDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("皮肤风格细节!");
        return new ModelAndView("/pages/skinStyleDetail");
    }

    //    皮肤管理
    @RequestMapping("/skinManage")
    public ModelAndView skinManage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("皮肤管理!");
        return new ModelAndView("/pages/skinDetail");
    }

    //    增加皮肤
    @RequestMapping("/addSkinManage")
    public ModelAndView addSkinManage(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("增加皮肤!");
        List<SkinStyle> skinStyleList = skinStyleService.getAllSkinStyle(null);
        List<SkinType> SkinTypeList = skinTypeService.getAllSkinType(null);
        model.addAttribute("skinStyleList", skinStyleList);
        model.addAttribute("SkinTypeList", SkinTypeList);
        return new ModelAndView("/pages/addSkinDetail");
    }

    //    皮肤管理细节
    @RequestMapping("/skinManageDetail")
    public ModelAndView skinManageDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("皮肤风格管理!");
        return new ModelAndView("/pages/skinManageDetail");
    }

    //    游戏管理
    @RequestMapping("/gameManage")
    public ModelAndView gameManage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("游戏管理!");
        return new ModelAndView("/pages/gameManage");
    }

    //    增加游戏
    @RequestMapping("/addGameDetail")
    public ModelAndView addGameDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("游戏管理!");
        return new ModelAndView("/pages/addGameDetail");
    }

    //    游戏管理细节
    @RequestMapping("/gameManageDetail")
    public ModelAndView gameManageDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("游戏管理细节!");
        return new ModelAndView("/pages/gameManageDetail");
    }

    //    发送系统消息
    @RequestMapping("sendSysMessage")
    public ModelAndView sendSysMessage(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("发送系统消息!");
        return new ModelAndView("/pages/sendSysMessage");
    }

    //    已发送消息列表
    @RequestMapping("/messageList")
    public ModelAndView messageList(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("系统消息列表!");
        return new ModelAndView("/pages/messageList");
    }

//    //    已发送消息列表
//    @RequestMapping("/messageList")
//    public  ModelAndView   setParameter  (HttpServletRequest request,HttpServletResponse response) throws  IOException,ServletException{
//        log.info("系统消息列表!");
//        return  new ModelAndView("/pages/messageList");
//    }

    //    会费设置
    @RequestMapping("/memberFee")
    public ModelAndView memberFee(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("会费设置!");
        ParameterSet parameterSet1 = parameterSetService.selectByPrimaryKey(1);
        ParameterSet parameterSet2 = parameterSetService.selectByPrimaryKey(2);
        ParameterSet parameterSet3 = parameterSetService.selectByPrimaryKey(3);
        ParameterSet parameterSet4 = parameterSetService.selectByPrimaryKey(4);
        ParameterSet parameterSet5 = parameterSetService.selectByPrimaryKey(5);
        ParameterSet parameterSet6 = parameterSetService.selectByPrimaryKey(6);
        if (parameterSet1 != null) {
            model.addAttribute("parameterSet1", parameterSet1);
        } else {
            model.addAttribute("parameterSet1", "");
        }
        if (parameterSet2 != null) {
            model.addAttribute("parameterSet2", parameterSet2);
        } else {
            model.addAttribute("parameterSet2", "");
        }
        if (parameterSet3 != null) {
            model.addAttribute("parameterSet3", parameterSet3);
        } else {
            model.addAttribute("parameterSet3", "");
        }
        if (parameterSet4 != null) {
            model.addAttribute("parameterSet4", parameterSet4);
        } else {
            model.addAttribute("parameterSet4", "");
        }
        if (parameterSet5 != null) {
            model.addAttribute("parameterSet5", parameterSet5);
        } else {
            model.addAttribute("parameterSet5", "");
        }
        if (parameterSet6 != null) {
            model.addAttribute("parameterSet6", parameterSet6);
        } else {
            model.addAttribute("parameterSet6", "");
        }
        log.info("获取对象" + parameterSet1 + parameterSet2 + parameterSet3);
        return new ModelAndView("/pages/memberFee");
    }

    //    手续费设置
    @RequestMapping("/serviceFee")
    public ModelAndView serviceFee(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("会费设置!");
        ParametersSet parametersSet1 = parametersSetService.selectByPrimaryKey(1);
        ParametersSet parametersSet2 = parametersSetService.selectByPrimaryKey(2);
        ParametersSet parametersSet3 = parametersSetService.selectByPrimaryKey(3);
        ParametersSet parametersSet4 = parametersSetService.selectByPrimaryKey(4);
        model.addAttribute("parametersSet1", parametersSet1);
        model.addAttribute("parametersSet2", parametersSet2);
        model.addAttribute("parametersSet3", parametersSet3);
        model.addAttribute("parametersSet4", parametersSet4);
        return new ModelAndView("/pages/serviceFee");
    }

    //    难度设置
    @RequestMapping("/difficultySet")
    public ModelAndView difficultySet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("难度设置!");
        return new ModelAndView("/pages/difficultySet");
    }

    //    增加难度设置
    @RequestMapping("/addDifficultySet")
    public ModelAndView addDifficultySet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("难度设置!");
        return new ModelAndView("/pages/addDifficulty");
    }

    //    教材设置
    @RequestMapping("/textbookSet")
    public ModelAndView textbookSet(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("教材设置!");
        LearnbookSet learnbookSet = learnboolSetService.getMaxLearnbookSet();
        log.info("查询最小Id" + learnbookSet);
        model.addAttribute("learnbookSet", learnbookSet);
        return new ModelAndView("/pages/textbookSet");
    }

    //    余额提现申请
    @RequestMapping("/withdrawApply")
    public ModelAndView withdrawApply(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("余额提现申请!");
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        log.info("当前用户=" + user.getId());
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
        log.info("当前用户的身份" + sysUser.getXinxiType() + "信息的ID" + sysUser.getXinxiId());
        int xinxiType = sysUser.getXinxiType();
        //当前用户的可提现余额
        BigDecimal bigDecimal = null;
        if (xinxiType == 1) {
            ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = serviceProvider.getWithdrawBalance();
        } else if (xinxiType == 2) {
            Organization organization = organizationMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawBalance();
        } else if (xinxiType == 3) {
            PianoShop organization = pianoShopMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawalsBalance();
        } else if (xinxiType == 4) {
            Teacher organization = teacherMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getBalance();
        }
        model.addAttribute("bigDecimal", bigDecimal);
        return new ModelAndView("/pages/withdrawApply2");
    }

    //    余额提现申请
    @RequestMapping("/shareProfitCount")
    public ModelAndView shareProfitCount(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        log.info("分润统计报表!");
        return new ModelAndView("/pages/shareProfitCount");
    }

    //    添加余额提现申请
    @RequestMapping("/addWithdrawApply")
    public ModelAndView addWithdrawApply(HttpServletRequest request, HttpServletResponse response, Model model) throws
            IOException, ServletException {
        log.info("添加余额提现申请!");
        SysUser user = (SysUser) request.getSession().getAttribute("user");
        log.info("当前用户=" + user.getId());
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(user.getId());
        log.info("当前用户的身份" + sysUser.getXinxiType() + "信息的ID" + sysUser.getXinxiId());
        int xinxiType = sysUser.getXinxiType();
        //当前用户的可提现余额
        BigDecimal bigDecimal = null;
        if (xinxiType == 1) {
            ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = serviceProvider.getWithdrawBalance();
        } else if (xinxiType == 2) {
            Organization organization = organizationMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawBalance();
        } else if (xinxiType == 3) {
            PianoShop organization = pianoShopMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawalsBalance();
        } else if (xinxiType == 4) {
            Teacher organization = teacherMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getBalance();
        }
//        @Autowired
//        private ServiceProviderMapper serviceProviderMapper;
//        @Autowired
//        private  OrganizationMapper organizationMapper;
//        @Autowired
//        private     PianoShopMapper pianoShopMapper;
//        @Autowired
//        private TeacherMapper teacherMapper;
        model.addAttribute("bigDecimal", bigDecimal);
        //获得当前用户的银行卡
        List<BankcardDetail> details = bankcardDetailService.getAllBankcardDetail(user.getId().toString());
        model.addAttribute("details", details);
        return new ModelAndView("/pages/addWithdrawApply");
    }

    //    学生等级
    @RequestMapping("/getUser")
    public ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("学生等级!");
        return new ModelAndView("/pages/getUser");
    }

    //积分管理
    @RequestMapping("/getUserScoreDetail")
    public ModelAndView getUserScoreDetail(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("积分获取记录!");
        return new ModelAndView("/pages/userScoreDetail");
    }

    //积分管理
    @RequestMapping("/getCountRecord")
    public ModelAndView getCountRecord(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("计数器记录!");
        return new ModelAndView("/pages/CountRecordDetail");
    }

    //积分管理
    @RequestMapping("/getSongRecord")
    public ModelAndView getSongRecord(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("计数器记录!");
        return new ModelAndView("/pages/SongRecordDetail");
    }

    //积分管理
    @RequestMapping("/integrationSet")
    public ModelAndView getintegrationSet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("积分管理!");
        return new ModelAndView("/pages/integrationSet");
    }

    //游戏积分管理
    @RequestMapping("/gameintegrationSet")
    public ModelAndView getgameintegrationSet(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("游戏积分管理!");
        return new ModelAndView("/pages/gameintegrationSet");
    }

    //修改密码
    @RequestMapping("/updatePassword")
    public ModelAndView updatePassword(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {

        log.info("修改密码!");
        return new ModelAndView("/pages/updatePassword");
    }

    //具体修改密码
    @RequestMapping("/updatePass")
    @ResponseBody
    public LayUIResult updatePass(HttpServletRequest request, HttpServletResponse response) throws
            IOException, ServletException {
        String password = request.getParameter("password");
        log.info("具体修改密码!" + password);
        LayUIResult layUIResult = new LayUIResult();
        if (password != null && !"".equals(password)) {
            SysUser user = (SysUser) request.getSession().getAttribute("user");

            user.setPassword(MD5Util.encrypt(password));
            int num = sysUserMapper.updateByPrimaryKeySelective(user);
            if (num > 0) {
                layUIResult.setCode(0);
                layUIResult.setMsg(password);
            } else {
                layUIResult.setCode(1);
                layUIResult.setMsg("修改失败");
            }
        } else {
            layUIResult.setCode(2);
            layUIResult.setMsg("数据获取失败!");
        }
        return layUIResult;
    }

    //会费缴纳详情
    @RequestMapping("/getMembershipDues")
    public ModelAndView getMembershipDues(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("会费缴纳详情!");
        int countByAmount = membershipDuesMapper.selectAllCountByRole(null, null, null, null);
        model.addAttribute("countByAmount", countByAmount);
        return new ModelAndView("/pages/MembershipDuesDetail");
    }

    //我的账户   (服务商,机构,琴行)
    @RequestMapping("/getMyUserXinxi")
    public ModelAndView getUserxinxi(HttpServletRequest request, HttpServletResponse response, Model model) {
        log.info("我的账户!");
        SysUser sysUser = (SysUser) request.getSession().getAttribute("user");
        log.info("当前用户的身份" + sysUser.getXinxiType() + "信息的ID" + sysUser.getXinxiId());
        int xinxiType = sysUser.getXinxiType();

        BigDecimal bigDecimal = null;     //当前用户的可提现余额
        Date registerTime = null;           //当前用户的注册时间
        BigDecimal zhidaijin = null;       //滞纳金
        int yuqiType = 0;       //逾期的状态  0 没有逾期   1,为逾期一个月   2,逾期超过1个月
        Date yuqiDate = null;     //该交会费的时间
        if (xinxiType == 1) {
            ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = serviceProvider.getWithdrawBalance();
            registerTime = serviceProvider.getRegisterTime();
        } else if (xinxiType == 2) {
            Organization organization = organizationMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawBalance();
            registerTime = organization.getRegisterTime();
        } else if (xinxiType == 3) {
            PianoShop organization = pianoShopMapper.selectByPrimaryKey(sysUser.getXinxiId());
            bigDecimal = organization.getWithdrawalsBalance();
            registerTime = organization.getRegisterTime();
        }
        Integer shareCount = incomeDetailMapper.getIncomeDetailById(sysUser.getXinxiType().toString(), sysUser.getXinxiId());
        log.info("收入明细" + shareCount);
        if (shareCount == null) {
            shareCount = 0;
        }
        model.addAttribute("shareCount", shareCount);    //我的分润总熊掌
        model.addAttribute("bigDecimal", bigDecimal);       //我的可提现熊掌
        Map<String, BigDecimal> map = rechargeDetailMapper.getRechargeCountByUid(sysUser.getXinxiId(), sysUser.getXinxiType().toString());
        if (map != null) {
            model.addAttribute("rechargeMoney", map.get("aa").toString());  //充值金额
            model.addAttribute("rechargeObject", map.get("bb").toString()); //到账金额
            log.info("map:" + map.get("aa").toString());
        } else {
            model.addAttribute("rechargeMoney", 0);  //充值金额
            model.addAttribute("rechargeObject", 0); //到账金额
        }
        log.info("map:211");
        //计算滞纳金
        //查询一起是否缴纳过会费,如果有则直接得到下次缴纳会费的时间,没有记录则从注册时间和会员试用时间(天)计算
        MembershipDues membershipDues = membershipDuesMapper.selectByLastTwoTime(sysUser.getXinxiId(), sysUser.getXinxiType().toString());
        if (membershipDues != null) {    //有记录的话看是否逾期
            yuqiDate = membershipDues.getTwoTime();    //该交会费的时间
            if (membershipDues.getTwoTime().getTime() <= (new Date()).getTime()) {    //说明没有逾期
                zhidaijin = new BigDecimal("0");
            } else {                   //逾期的情况

                Calendar bef = Calendar.getInstance();
                Calendar aft = Calendar.getInstance();
                bef.setTime(new Date());
                aft.setTime(membershipDues.getTwoTime());
                //相差几个月
                int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH) + (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
                if (result == 1) {
                    yuqiType = 1;   //逾期为一个月
                } else {
                    yuqiType = 2;    //逾期超过一个月
                    ParameterSet parameterSet6 = parameterSetService.selectByPrimaryKey(6);   //得到逾期扣除的百分比
                    //滞纳金=(逾期的月份*设置的%参数)*现在原本的可提现金额
                    zhidaijin = (new BigDecimal(result).multiply(new BigDecimal(parameterSet6.getContent()))).multiply(bigDecimal);
                    //金额未扣除
                }
            }
        } else {     //从注册时间和会员试用时间(天)计算
            ParameterSet parameterSet4 = parameterSetService.selectByPrimaryKey(4);   //会员试用时间
            yuqiDate = new Date(registerTime.getTime() + (parameterSet4.getContent() * 24 * 60 * 60 * 1000));     //该交会费的时间
            if (yuqiDate.getTime() <= (new Date()).getTime()) { //说明没有逾期
                zhidaijin = new BigDecimal("0");
            } else {                   //逾期的情况

                Calendar bef = Calendar.getInstance();
                Calendar aft = Calendar.getInstance();
                bef.setTime(new Date());
                aft.setTime(yuqiDate);  //该交会费的时候
                //相差几个月
                int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH) + (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
                if (result == 1) {
                    yuqiType = 1;   //逾期为一个月
                } else {
                    yuqiType = 2;    //逾期超过一个月
                    ParameterSet parameterSet6 = parameterSetService.selectByPrimaryKey(6);   //得到逾期扣除的百分比
                    //滞纳金=(逾期的月份*设置的%参数)*现在原本的可提现金额
                    zhidaijin = (new BigDecimal(result).multiply(new BigDecimal(parameterSet6.getContent()))).multiply(bigDecimal);
                    //金额未扣除
                }
            }
        }
        model.addAttribute("yuqiType", yuqiType);    //逾期的状态
        model.addAttribute("zhidaijin", zhidaijin);   //滞纳金
        model.addAttribute("yuqiDate", yuqiDate);   //该交会费的时间
        return new ModelAndView("/pages/MyUserXinxi");
    }

    //过渡界面上传图片
    @RequestMapping("/uploadPicture")
    public ModelAndView uploadPicture(HttpServletRequest request, Model model) {
        log.info("修改密码!");
        SysUser sysUser = (SysUser) request.getSession().getAttribute("user");
        PianoShop pianoShop = pianoShopMapper.selectByPrimaryKey(sysUser.getXinxiId());
        model.addAttribute("pianoShop", pianoShop);
        return new ModelAndView("/pages/uploadPicture");
    }

    //修改过渡界面图片
    @RequestMapping("/uploadPictureDetail")
    public ModelAndView uploadPictureDetail(HttpServletRequest request, Model model) {
        log.info("修改密码!");
        SysUser sysUser = (SysUser) request.getSession().getAttribute("user");
        String transitionPicture = request.getParameter("transitionPicture");
        PianoShop pianoShop = new PianoShop();
        pianoShop.setId(sysUser.getXinxiId());
        pianoShop.setTransitionPicture(transitionPicture);
        int result = pianoShopMapper.updateByPrimaryKeySelective(pianoShop);

        return new ModelAndView("/pages/uploadPicture");
    }


//    /**
//     *    管理后台 -- 琴行规模
//     * @param request
//     * @param respons
//     * @param model
//     * @return
//     * @throws IOException
//     * @throws ServletException
//     */
//    @RequestMapping("/getPianoScope.page")
//    public ModelAndView getPianoScopeNew(HttpServletRequest request, HttpServletResponse respons, Model model) throws IOException, ServletException {
////        @RequestParam(value = "curr", defaultValue = "1") Integer curr,@RequestParam(value = "limit",defaultValue = "10") Integer limit,
//
//        log.info("管理后台 -- 点击 -- 琴行规模");
//        return  new ModelAndView("/pages/pianoScope");
//
//    }
}

