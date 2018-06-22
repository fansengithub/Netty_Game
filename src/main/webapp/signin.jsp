<%@ page import="java.net.URLEncoder" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="zh-CN">
<%
    String ret = request.getParameter("ret");
    if(StringUtils.isNotBlank(ret)) {
        ret = URLEncoder.encode(ret);
    } else {
        ret = "";
    }
%>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/component.css" />
    <!--[if IE]>
    <script src="${pageContext.request.contextPath}/js/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h1 style="text-align:center">欢迎登录后台管理系统</h1>
                <form action="${pageContext.request.contextPath}/login.page?ret=<%=ret%>" id="subform" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="username" class="text" style="color: #FFFFFF !important" autocomplete=”on” type="text" placeholder="Email/Telephone">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"autocomplete="on"  type="password"  placeholder="password">
                    </div>
                    <div class="checkbox" style="color: red;">${error}</div>
                    <div class="mb2"><a class="act-but submit" href="javascript:;" style="color: #FFFFFF"
                                        onclick="document.getElementById('subform').submit();">登录</a></div>
                </form>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="${pageContext.request.contextPath}/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/js/demo-1.js"></script>
</body>
</html>
