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
            添加老师
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                添加老师
            </div>

            <div id="dialog-user-form">
                <form class="layui-form layui-form-pane" id="myFrom" lay-filter="myFrom">

                    <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                        <tr>
                            <td width="610px">
                                <div class="layui-form-item">
                                    <label class="layui-form-label">老师姓名</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="name" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>


                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label label1">所属琴行:</label>
                                    <div class="layui-input-inline">
                                        <select class="layui-input" name="belongtoPianoShopid" required
                                                id="belongtoPianoShopid"
                                                lay-filter="columnName">
                                            <option value=""></option>
                                            <c:forEach var="stu" items="${pianoShopList}">
                                                <option value="${stu.id}">
                                                    琴行id:${stu.id}&nbsp;&nbsp;&nbsp;&nbsp;琴行名称:(${stu.name})
                                                </option>
                                            </c:forEach>
                                        </select>
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
                                    <label class="layui-form-label">就职类型</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="workType" lay-verify="required" autocomplete="off"
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
                                    <label class="layui-form-label">在职单位</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="workPlace" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">密码</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="password" id="password" lay-verify="required"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label label1">区域管理:</label>
                                    <div class="layui-input-inline">
                                        <select name="area1" required
                                                id="area1"
                                                lay-filter="area1">
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
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">再次确认</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="password2" id="password2" lay-verify="required"
                                               autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
                            <td>
                                <div class="layui-form-item">
                                    <label class="layui-form-label">详细地址</label>
                                    <div class="layui-input-inline">
                                        <input type="text" name="address" lay-verify="required" autocomplete="off"
                                               class="layui-input">
                                    </div>
                                </div>
                            </td>
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
                                               name="headurl" id="pic">
                                    </div>
                                </div>

                            </td>
                            <td>
                                <a class="layui-btn" id="chuangjian1">创建</a>

                                <button style="display: none;" class="layui-btn" lay-submit="" lay-filter="addLearnbook"
                                        id="ti">立即提交
                                </button>
                                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                                <div id="tijiao1" class="layui-container" style="display: none;">

                                    <div class="layui-row">
                                        <div class="layui-col-md7" style="margin: 40px 180px;font-size: 26px">
                                            创建老师需要消耗<span style="color: #2ecee7" id="aa1">${parametersSet.value}</span>熊掌
                                        </div>
                                    </div>
                                    <div class="layui-row">
                                        <div class="layui-col-md7" style="margin: 10px 220px 50px;font-size: 26px">
                                            当前可用<span style="color: #2ecee7" id="aa2">${bigDecimal}</span>熊掌
                                        </div>
                                    </div>
                                    <div class="layui-form-item">
                                        <div class="layui-input-block" style="margin: 10px 240px ;">
                                            <a class="layui-btn layui-btn-lg layui-btn-radius" id="chuangjian2"
                                               style="width: 200px">创建</a>
                                        </div>
                                    </div>
                                </div>
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

        form.on('submit(addLearnbook)', function (data) {
            console.info("添加1")
            $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/get/addTeacherDetail.page');
        });
        $("#chuangjian1").click(function () { //#btn为按钮id
            console.info("添加")
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
                        if ($("#password").val() != $("#password2").val()) {
                            layer.msg("两次密码输入不一致!")
                            return
                        }
                        // $("#aa1").text("100");
                        // $("#aa2").text("10000");
                        layer.open({
                            type: 1,
                            area: ['700px', '400px'],
                            fixed: false, //不固定
                            maxmin: true,
                            content: $("#tijiao1").html(),
                        });
                    }
                }
            })

        })
        $(document).on('click', '#chuangjian2', function () {
            // console.log('响应点击事件'+$("#aa2").text());
            if (parseFloat($("#aa2").text()) < parseFloat($("#aa1").text())) {
                layer.msg("熊掌不足,无法创建!")
                return
            }
            $("#ti").click()
        });
        //点击发送验证码
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
                url: '${pageContext.request.contextPath}/get/sendSmsCodeByTeacher.page?number='+ telephone,
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