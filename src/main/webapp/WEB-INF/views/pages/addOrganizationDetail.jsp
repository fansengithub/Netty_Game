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
            添加机构
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                添加机构
            </div>

            <div id="dialog-user-form">
                <form action="${pageContext.request.contextPath}/get/addOrganizationDetail.page" class="layui-form layui-form-pane" id="myFrom" lay-filter="myFrom">
                    <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">机构名称</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="organizeName" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>


                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">联系人</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="contacts" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">手机账号</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="telephone" id="telephone" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                    <a class="layui-btn" id="sendyan">点击发送验证码</a>
                                </div>
                                <%--<button type="submit" class="btn btn-primary">获取验证码</button>--%>
                            </td>

                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">法人账号</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="bossTelephone" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">验证码</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="diffityLevel" id="yanzhengma" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label label1">区域管理:</label>
                                    <div class="layui-input-inline">
                                        <select  name="area1" required
                                                 id="area1"
                                                 lay-filter="area1" >
                                            <option value="">请选择省</option>
                                            <c:forEach var="stu" items="${znAreaList}">
                                                <option value="${stu.areaCede}">省:${stu.areaName}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="layui-input-inline">
                                        <select class="layui-input" name="area2" required
                                                id="area2"
                                                lay-filter="area2">
                                            <option value="">请选择市</option>
                                        </select>
                                    </div>
                                    <div class="layui-input-inline">
                                        <select class="layui-input" name="area3" required
                                                id="area3"
                                                lay-filter="area3">
                                            <option value="">请选择县</option>
                                        </select>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>


                        </tr>
                        <tr>
                            <td>

                                <div class="layui-upload">
                                    <button type="button" class="layui-btn" id="test1">身份证图片</button>
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img" width="300px" height="200px"
                                             style="border: 1px solid greenyellow"
                                             src=""
                                             id="demo1">
                                        <p id="demoText"></p>
                                        <input type="hidden" value="" required
                                               name="idcardPicture" id="pic">
                                    </div>
                                </div>

                            </td>
                            <td>

                                <div class="layui-upload">
                                    <button type="button" class="layui-btn" id="test2">营业执照</button>
                                    <div class="layui-upload-list">
                                        <img class="layui-upload-img" width="300px" height="200px"
                                             style="border: 1px solid greenyellow"
                                             src=""
                                             id="demo2">
                                        <p id="demoText2"></p>
                                        <input type="hidden" value="" required
                                               name="businessLicensePicture" id="pic2">
                                    </div>
                                </div>

                            </td>

                        </tr>

                        <tr>

                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">详细地址</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="detailAddress" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>

                            <td>
                                <a class="layui-btn" id="tijiao3">立即提交
                                </a>
                                <button style="display: none;" class="layui-btn" id="tijiao2" type="submit" lay-filter="reg" lay-submit="">立即提交
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
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
        var form = layui.form;
        var layer = layui.layer;
        var $ = layui.jquery
            , upload = layui.upload;
        form.render();

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            , url: '${pageContext.request.contextPath}/FileController/imgUpload.json'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                } else {
                    console.log(res);
                    $("#pic").val(res.data);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        var uploadInst2 = upload.render({
            elem: '#test2'
            , url: '${pageContext.request.contextPath}/FileController/imgUpload.json'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo2').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                } else {
                    console.log(res);
                    $("#pic2").val(res.data);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText2');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        <%--form.on('submit(addLearnbook)', function(data){--%>
            <%--console.info("添加")--%>
            <%--$('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/get/addOrganizationDetail.page');--%>
        <%--});--%>
        $("#tijiao3").click(function(data) {
            console.info("添加");
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
                        console.log("执行增加服务的方法");
                        // layer.msg("添加成功");
                        $("#tijiao2").click();

                    }
                }
            })

        });
        $('#sendyan').click(function () {
            var telephone = $("#telephone").val();
            if (!(/^1[34578]\d{9}$/.test(telephone))) {
                layer.tips('请输入正确手机号', '#telephone', {
                    tips: [1, '#0FA6D8'] //还可配置颜色
                });
                return false;
            }

            console.log("telephone" + telephone);
            $.ajax({
                url: '${pageContext.request.contextPath}/get/sendSmsCodeByOrganization.page?number=' + telephone,
                success: function (result) {
                    console.log(result)
                    if (result == 1) {
                        layer.msg("发送成功");
                    } else if (result == 2) {
                        layer.msg("该号码已被注册");
                    } else {
                        layer.msg("发送失败");
                    }
                }
            })
        });
        // 区域管理
        form.on('select(area1)', function (data) {
            // console.log(data.elem); //得到select原始DOM对象
            // console.log(data.elem.selectedIndex); //得到select原始DOM对象
            // console.log(data.elem[data.elem.selectedIndex].text); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            // $("#area1").text("aaa");
            if (data.value == "") {
                layer.msg('请选择');
                return;
            }
            $.ajax({
                url: '${pageContext.request.contextPath}/znArea/getListZnArea.page?parentId=' + data.value,
                success: function (datas) {
                    console.log(datas.length)
                    if (datas.length == 0) {
                        layer.msg('无数据', {icon: 5});
                        return;
                    }
                    $("#area2").empty();
                    $("#area3").empty();
                    $.each(datas, function (index, znArea) {
                        var deptOption = $("<option value='" + znArea.areaCede + "'>市:" + znArea.areaName + "</option>");
                        $("#area2").append(deptOption);
                    });

                    form.render();
                }
            })
        });
        form.on('select(area2)', function (data) {
            console.log(data.value); //得到被选中的值
            $.ajax({
                url: '${pageContext.request.contextPath}/znArea/getListZnArea.page?parentId=' + data.value,
                success: function (datas) {
                    console.log(datas.length)
                    if (datas.length == 0) {
                        layer.msg('无数据', {icon: 5});
                        return;
                    }
                    $("#area3").empty();
                    $.each(datas, function (index, znArea) {
                        var deptOption = $("<option value='" + znArea.areaCede + "'>县:" + znArea.areaName + "</option>");
                        $("#area3").append(deptOption);
                    });
                    form.render();
                }
            })
        });
    });
</script>
</body>
</html>