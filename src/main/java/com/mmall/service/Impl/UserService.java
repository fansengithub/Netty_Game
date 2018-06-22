package com.mmall.service.Impl;

import com.mmall.model.LayUIResult;

public interface UserService {

    //用户登陆
    public LayUIResult userLogin(String username,String psw);
}
