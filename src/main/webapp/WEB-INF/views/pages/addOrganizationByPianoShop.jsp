<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        会员管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            机构绑定琴行
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                机构绑定琴行
            </div>

            <div id="dialog-user-form" class="layui-container">
                <form action="${pageContext.request.contextPath}/get/addServiceDetail.page"
                      class="layui-form layui-form-pane layui-container" id="" lay-filter="myFrom">
                    <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label" style="width: 200px">琴行ID</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="name" id="jigouid" lay-verify="required"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                    <a class="layui-btn" id="selPon">点击查询手机号</a>
                                </div>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label" style="width: 200px">琴行手机账号</label>
                                    <div class="layui-input-inline">
                                        <input type="tel" name="telephone" id="telephone" lay-verify="required|phone"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                    <a class="layui-btn" id="sendyan">点击发送验证码</a>
                                </div>

                                <%--<button type="submit" class="btn btn-primary">获取验证码</button>--%>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label" style="width: 200px">验证码</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="yanzhengma" id="yanzhengma" lay-verify="required"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>

                        <tr>


                        </tr>
                        <tr>
                            <td>
                                <a class="layui-btn" id="tijiao3">立即提交
                                </a>

                            </td>
                        </tr>
                    </table>


                </form>
            </div>

        </div>
    </div>
</div>
<script>
    layui.use(['upload', 'form', 'layer'], function () {
        var form = layui.form, layedit = layui.layedit
            , laydate = layui.laydate;
        var layer = layui.layer;
        var $ = layui.jquery
            , upload = layui.upload;
        form.render();


        $("#tijiao3").click(function (data) {
            console.info("添加");
            var jigouid = $("#jigouid").val();
            var telephone = $("#telephone").val();
            var yanzhengma = $("#yanzhengma").val();
            if (!(/^1[34578]\d{9}$/.test(telephone))) {
                layer.tips('请输入正确手机号', '#telephone', {
                    tips: [1, '#0FA6D8'] //还可配置颜色
                });
                return false;
            }
            if (!(/^\d{6}$/.test(yanzhengma))) {
                layer.tips('请输入正确验证码', '#yanzhengma', {
                    tips: [1, '#0FA6D8'] //还可配置颜色
                });
                return false;
            }
            console.log("telephone" + telephone + "yanzhenma" + yanzhengma);
            $.ajax({
                url: '${pageContext.request.contextPath}/get/sendYanzhengma.page?number=' + telephone + "&code=" + yanzhengma,
                success: function (result) {
                    console.log(result)
                    if (result == 0) {
                        layer.msg("并没有给该手机号发送过验证码!");
                        return false;
                    } else if (result == 1) {
                        layer.msg("验证码已过期");
                        return false;
                    } else if (result == 2) {
                        layer.msg("验证码错误!");
                    } else if (result == 3) {
                        console.log("绑定的方法");
                        $.ajax({
                            url: '${pageContext.request.contextPath}/get/updatePianoshipByorganID.page?jigouid=' + jigouid,
                            success: function (result) {
                                console.log(result)
                                if (result == 0) {
                                    layer.msg("绑定成功");
                                } else {
                                    layer.msg("绑定失败");
                                }
                            }
                        })
                    }
                }
            })

        });
        //点击发送验证码
        $('#sendyan').click(function () {
            var jigouid = $("#jigouid").val();
            var telephone = $("#telephone").val();
            if (!(/^1[34578]\d{9}$/.test(telephone))) {
                layer.tips('请输入正确手机号', '#telephone', {
                    tips: [1, '#0FA6D8'] //还可配置颜色
                });
                return false;
            }
            console.log("telephone" + jigouid);
            console.log("telephone" + telephone);
            //验证该琴行是否有机构绑定
            $.ajax({
                url: '${pageContext.request.contextPath}/get/sendSmsSelectTelephone.page?jigouid=' + jigouid,
                success: function (result) {
                    console.log(result.code)
                    if (result.code == 0) {
                        $.ajax({
                            url: '${pageContext.request.contextPath}/get/sendSelectTelephone.page?number=' + telephone,
                            success: function (result) {
                                console.log(result.code)
                                if (result == 0) {
                                    layer.msg("发送成功");
                                } else {
                                    layer.msg("发送失败");
                                }
                            }
                        })
                    } else {
                        layer.msg(result.msg);
                    }
                }
            })

        });
        //点击查询手机号
        $('#selPon').click(function () {
            var jigouid = $("#jigouid").val();
            // if (!(/^\d{*}$/.test(telephone))) {
            //     layer.tips('请输入正确验证码', '#yanzhengma', {
            //         tips: [1, '#0FA6D8'] //还可配置颜色
            //     });
            //     return false;
            // }
            console.log("jigouid" + jigouid);
            $.ajax({
                url: '${pageContext.request.contextPath}/get/sendSelectTelephoneById.page?jigouid=' + jigouid,
                success: function (result) {
                    console.log(result.code)
                    if (result.code == 0) {
                        $("#telephone").val(result.msg);
                    } else if (result == 1) {
                        layer.msg("未查询到该琴行");
                    } else {
                        layer.msg("发送失败");
                    }
                }
            })
        });
    });
</script>

</body>
</html>