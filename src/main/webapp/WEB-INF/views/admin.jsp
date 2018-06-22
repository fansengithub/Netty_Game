<%@ page import="com.mmall.common.RequestHolder" %>
<%@ page import="com.mmall.model.SysUser" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>

</head>

<body class="no-skin">
<div id="navbar" class="navbar navbar-default">
    <div class="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler">
            <span class="sr-only">Toggle sidebar</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="${pageContext.request.contextPath}/admin/page.do" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    管理员控制台
                </small>
            </a>
        </div>
        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a  href="${pageContext.request.contextPath}/logout.page" >
                        <span class="user-info">
                            <small>欢迎,</small>
                            ${user.username}
                        </span>
                        <i class="ace-icon fa fa-power-off" id="logout"></i>
                    </a>
                </li>
            </ul>
        </div>

    </div>

</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <div id="sidebar" class="sidebar responsive">
        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'fixed')
            } catch (e) {
            }
        </script>


        <ul class="nav nav-list">
            <li class="active">
                <a class="popstyle" href="${pageContext.request.contextPath}/sys/user/page.do" target="_blank">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> 首页 </span>
                </a>
                <b class="arrow"></b>
            </li>

            <c:forEach items="${aclModule}" var="aclModule" >
                <%--${fn:length(aclModule.aclModuleList)}--%>
                <c:if test="${aclModule.aclModuleList!=null && (fn:length(aclModule.aclModuleList) > 0 ) }">
                    <li class="" id="${aclModule.id}" style="display: none">
                        <a href="#" class="dropdown-toggle">
                            <i class="menu-icon fa fa-desktop"></i>
                            <span class="menu-text"> ${aclModule.name} </span>
                            <b class="arrow fa fa-angle-down"></b>
                        </a>
                        <b class="arrow"></b>
                        <ul class="submenu">
                            <c:forEach items="${aclModule.aclModuleList}" var="aclm" >
                                <c:forEach items="${aclm.aclList}" var="acl" >
                                    <c:if test="${aclm.id == acl.aclModuleId && acl.type == 1 && acl.status == 1}" >
                                        <script type="text/javascript">
                                            try{
                                                //alert('1');
                                                $("#${aclModule.id}").removeAttr("style"); //ie,ff均支持
                                                //alert('2');
                                            } catch (e) {
                                            }
                                        </script>
                                        <li class="">
                                            <a class="popstyle" href="${pageContext.request.contextPath}${acl.url}" target="_blank">
                                                <i class="menu-icon fa fa-caret-right"></i>
                                                    ${aclm.name}
                                            </a>
                                            <b class="arrow"></b>
                                        </li>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </ul>
                    </li>
                </c:if>
            </c:forEach>
<%--            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text"> 权限管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a class="popstyle" href="${pageContext.request.contextPath}/sys/dept/dept.page" target="_blank">
                            <i class="menu-icon fa fa-caret-right"></i>
                            用户管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a class="popstyle" href="${pageContext.request.contextPath}/sys/role/role.page" target="_blank">
                            <i class="menu-icon fa fa-caret-right"></i>
                            角色管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a class="popstyle" href="${pageContext.request.contextPath}/sys/aclModule/acl.page" target="_blank">
                            <i class="menu-icon fa fa-caret-right"></i>
                            权限管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a class="popstyle" href="${pageContext.request.contextPath}/sys/log/log.page" target="_blank">
                            <i class="menu-icon fa fa-caret-right"></i>
                            权限更新记录
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>--%>

<%--            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text"> 系统管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a class="popstyle" href="${pageContext.request.contextPath}/config/config.page" target="_blank">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全局配置管理
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li>--%>
        </ul>
        <!-- /.nav-list -->

        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
               data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>

        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'collapsed')
            } catch (e) {
            }
        </script>
    </div>

    <div class="main-content">
        <iframe id="innerFrame" src="" width="99%" style="min-height: 768px;"></iframe>
    </div>
    <!-- /.main-content -->

    <a href="index.html#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse display">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>

</div>
<!-- /.main-container -->


<!-- basic scripts -->

<!--[if !IE]> -->
<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.0.min.js"></script>
<![endif]-->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.min.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery1x.min.js'>" + "<" + "/script>");
</script>
<![endif]-->

<script src="http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->

<!--[if lte IE 8]>
<script src="${pageContext.request.contextPath}/assets/js/excanvas.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.easypiechart.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/flot/jquery.flot.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/flot/jquery.flot.pie.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/flot/jquery.flot.resize.min.js"></script>

<!-- ace scripts -->
<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

<script>

    $(document).ready(function () {
        $(".popstyle").removeAttr("target");
        $(".popstyle").each(function () {
            var $this = $(this)
            tmp = $this.attr("href");
            $this.attr("data", tmp);
            $this.attr("href", "javascript:void(0)");
        })

        $(".popstyle").click(function () {
            var $this = $(this)
            $("iframe").attr(
                    'src',
                    $this.attr("data")
            );
        });

        $(".direct").click(function () {
            var $this = $(this)
            $("iframe").attr(
                    'src',
                    $this.attr("data-value")
            );
        });
    });
</script>
</body>
</html>

