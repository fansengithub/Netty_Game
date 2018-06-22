package com.mmall.service.Impl;

import com.mmall.dao.SysUserMapper;
import com.mmall.model.LayUIResult;
import com.mmall.model.SysUser;
import com.mmall.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements  UserService  {
    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 登陆
     * @param username
     * @param psw
     * @return
     */
    @Override
    public LayUIResult userLogin(String username, String psw) {
        LayUIResult layUIResult=new LayUIResult();
        SysUser  sysUser= sysUserMapper.findByKeyword(username);
        //如果用户存在，
        if(sysUser!=null){
            log.info("密码"+sysUser.getPassword()+"输入的密码"+MD5Util.encrypt(psw));
            //比对密码
            if(MD5Util.encrypt(psw).equals(sysUser.getPassword())){
                log.info("密码正确");
                layUIResult.setCode(0);
                layUIResult.setMsg("登陆成功！");
                sysUser.setPassword("");
                layUIResult.setData(sysUser);
            }else{
                layUIResult.setCode(1);
                layUIResult.setMsg("密码错误！");
            }
       }else{
            layUIResult.setMsg("用户不存在！");
            layUIResult.setCode(1);
        }
       return layUIResult;
    }
}
