<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white" onload="lod()">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        权限操作记录
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            管理权限相关模块更新历史
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                会费设置
            </div>

            <div id="dialog-user-form">
                <form class="layui-form layui-form-pane" id="userForm"
                      action="${pageContext.request.contextPath}/withdrawDetail/add" method="post">
                    <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                        <tr>
                            <td><label for="withdraw">我的可提现金额:</label></td>
                            <td>
                                <div class="layui-form-item">
                                    <div class="layui-input-inline">
                                        <input type="text" name="withdraw" id="withdraw" value="${bigDecimal}" readonly
                                               class="text ui-widget-content ui-corner-all" placeholder="可提现金额">
                                    </div>
                                </div>
                            </td>


                        </tr>
                        <tr>
                            <td><label for="bbb">请输入提现金额:</label></td>
                            <td>
                                <div class="layui-form-item">
                                    <div class="layui-input-inline">
                                        <input type="text" name="withdrawObject" id="bbb" value="" required
                                               class="text ui-widget-content ui-corner-all" placeholder="请输入提现金额"
                                               onchange="show()">
                                    </div>
                                </div>
                            </td>

                        </tr>

                        <tr>
                            <td><label for="ccc">实际到账金额:</label></td>
                            <td>
                                <div class="layui-form-item">
                                    <div class="layui-input-inline">
                                        <input type="text" readonly name="accountMoney" id="ccc" value="" required
                                               class="text ui-widget-content ui-corner-all" placeholder="实际到账金额">
                                    </div>
                                </div>
                            </td>


                        </tr>

                        <tr>
                            <td><label for="ddd">银行卡选择:</label></td>
                            <td>
                                <div class="layui-form-item">
                                    <div class="layui-input-inline">
                                        <select required name="bankAccount" id="ddd" style="width: 165px;">
                                            <c:forEach var="stu" items="${details}">
                                                <option value="${stu.bankcardNum}">${stu.bankcardType}(${stu.bankcardNum})</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                            </td>
                        </tr>


                    </table>
                    <div class="col-lg-12" style="margin-bottom: 1%;">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="hidden" name="id" value="${player.id}"/>
                        <input type="hidden" name="type" value="${type}"/>
                        <input type="hidden" name="playerid" value="${player.id}"/>
                        <div class="input-group pull-right">
                            <div class="col-lg-6" style="margin-bottom: 1%;">
                                <button type="submit" class="btn btn-block btn-info">提交</button>
                            </div>
                            <div class="col-lg-6" style="margin-bottom: 1%;">
                                <button type="button" class="btn btn-block btn-info"
                                        onclick="javascript:window.history.back();">
                                    返回
                                </button>
                            </div>
                        </div>
                    </div>

                </form>
            </div>

        </div>
    </div>
</div>
<script>
    layui.use(['upload', 'form', 'layedit'], function () {
        var form = layui.form;
        form.render();
    });

    function show() {
        // console.log("dfsdf")
        var withdraw = document.getElementById("withdraw").value;
        var num = document.getElementById("bbb").value;
        if (parseFloat(withdraw) < parseFloat(num)) {
            layer.msg("提现余额不能大于可提现余额" + withdraw + "--" + num);
            $("#bbb").val("");
            $("#ccc").val("");
            return false;
        }
        console.log(num);

        //alert(id);
        <%--$.ajax({--%>
        <%--type: "GET",--%>
        <%--url:"${pageContext.request.contextPath}/withdrawDetail/jisuan.page?num="+num,--%>

        <%--dataType: "text",--%>
        <%--success:function(test){--%>
        <%--alert("错dfs误！！");--%>
        <%--},--%>
        <%--error:function(e){--%>
        <%--alert("错误！！");--%>
        <%--},--%>
        <%--});--%>


        // var userinput = document.getElementById("userinput");
        $.post("${pageContext.request.contextPath}/withdrawDetail/jisuan.page", {num: num},
            function (data, textStatus) {
                document.getElementById("ccc").value = data;
                // alert("sss"+data)
            });

    }


</script>
</body>
</html>