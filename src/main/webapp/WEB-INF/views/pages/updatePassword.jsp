<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <style type="text/css">
        .layui-input-block {
            width: 600px;
        }
    </style>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        个人中心
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            修改密码
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <form class="layui-form layui-form-pane" id="myFrom" lay-filter="myFrom">


        <div class="layui-form-item">
            <label class="layui-form-label">新的密码:</label>
            <div class="layui-input-block">
                <input type="text" value="" id="password" name="password"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn" id="btn1">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script>
    layui.use(['upload', 'form', 'layedit'], function () {
        var form = layui.form;

        var $ = layui.jquery
        form.render();

        $("#btn1").click(function (data) {
            console.info("添加")
            var password = $("#password").val();
            $.ajax({
                url: '${pageContext.request.contextPath}/get/updatePass?password=' + password,
                success: function (result) {
                    console.log(result)
                    if (result.code == 0) {
                        layer.alert('修改成功!密码为:' + result.msg, {icon: 6});
                    } else {
                        layer.msg(result.msg);
                    }
                }
            })
        });
    });
</script>
</body>
</html>