package com.mmall.filter;

import com.mmall.common.ApplicationContextHelper;
import com.mmall.common.RequestHolder;
import com.mmall.dto.AclModuleLevelDto;
import com.mmall.model.SysUser;
import com.mmall.service.SysRoleService;
import com.mmall.service.SysTreeService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");
        if (sysUser == null) {
            String path = "/signin.jsp";
            resp.sendRedirect(req.getContextPath()+path);
            return;
        }
        RequestHolder.add(sysUser);
        RequestHolder.add(req);
        //log.info("过滤器调用");
        if(req.getSession().getAttribute("aclModule")==null){
            //权限缓存
            SysTreeService sysTreeService = ApplicationContextHelper.popBean(SysTreeService.class);
            req.getSession().setAttribute("aclModule", sysTreeService.userAclTree(sysUser.getId()));

            //角色缓存
            SysRoleService sysRoleService = ApplicationContextHelper.popBean(SysRoleService.class);
            req.getSession().setAttribute("aclRules", sysRoleService.getRoleListByUserId(sysUser.getId()));
        }

        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    public void destroy() {

    }
}
