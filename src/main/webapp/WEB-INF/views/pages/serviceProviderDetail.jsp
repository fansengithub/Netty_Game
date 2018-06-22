<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <link rel="stylesheet" href="/static/build/layui.css" media="all">
</head>
<body class="no-skin" youdao="bind" style="background: white">
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
                服务商用户详情
            </div>
            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <div class="row">
                        <form class="layui-form layui-form-pane" id="myFrom">
                            <table id="dynamic-table"
                                   class="table table-striped table-bordered table-hover dataTable no-footer"
                                   role="grid"
                                   aria-describedby="dynamic-table_info" style="font-size:14px">

                                <tr class="border">
                                    <td align="center" rowspan="2">
                                        <div class="layui-upload">
                                            <button type="button" class="layui-btn" id="test1">点击上传封面</button>
                                            <div class="layui-upload-list">
                                                <img class="layui-upload-img" width="150px" height="100px"
                                                     style="border: 1px solid greenyellow"
                                                     src="${temp.fengmianPicture}"
                                                     id="demo1">
                                                <p id="demoText1"></p>
                                                <input type="hidden" value="${temp.fengmianPicture}"
                                                       name="fengmianPicture" id="pic1">
                                            </div>
                                        </div>
                                    </td>
                                    <td align="center">服务商ID：${temp.id}<input type="hidden"
                                                                              value="${temp.id}"
                                                                              name="id" id="fuwuId">
                                    </td>
                                    <td align="center">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">服务商名：</label>
                                            <div class="layui-input-inline" style="width: 100px">
                                                <input value="${temp.name}" style="width:150px;" type="text" name="name"
                                                       lay-verify="required" autocomplete="off"
                                                       class="layui-input">
                                            </div>
                                        </div>
                                    </td>
                                    <td align="center">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">联系人：</label>
                                            <div class="layui-input-inline" style="width: 100px">
                                                <input value="${temp.contacts}" style="width:150px;" type="text"
                                                       name="contacts" lay-verify="required" autocomplete="off"
                                                       class="layui-input">
                                            </div>
                                            <%--<div class="layui-form-mid layui-word-aux">熊掌</div>--%>
                                        </div>
                                    </td>
                                </tr>
                                <tr class="border">
                                    <td align="center">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">手机号：</label>
                                            <div class="layui-input-inline" style="width: 100px">
                                                <input value="${temp.telephone}" style="width:150px;" type="text"
                                                       name="telephone" lay-verify="required" autocomplete="off"
                                                       class="layui-input">
                                            </div>
                                        </div>
                                    </td>
                                    <td align="center">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">法人姓名：</label>
                                            <div class="layui-input-inline" style="width: 100px">
                                                <input value="${temp.bossName}" style="width:150px;" type="text"
                                                       name="bossName" lay-verify="required" autocomplete="off"
                                                       class="layui-input">
                                            </div>
                                        </div>
                                    </td>

                                    <td align="center">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">法人电话：</label>
                                            <div class="layui-input-inline" style="width: 100px">
                                                <input value="${temp.bossTelephone}" style="width:150px;" type="text"
                                                       name="bossTelephone" lay-verify="required" autocomplete="off"
                                                       class="layui-input">
                                            </div>
                                        </div>
                                    </td>


                                </tr>
                                <tr class="border">
                                    <td align="center">区域机构总数： ${temp.organiztionNum}<input type="hidden"
                                                                                            value="${temp.organiztionNum}"
                                                                                            name="organiztionNum"></td>
                                    <td align="center">区域琴行总数： ${temp.pianoShopNum}<input type="hidden"
                                                                                          value="${temp.pianoShopNum}"
                                                                                          name="pianoShopNum"></td>
                                    <td align="center">分润总收入: ${getIncomeDetailCount}</td>
                                    <td align="center">分润已提现金额: ${getWitdrawDetaiCount}</td>


                                </tr>
                                <tr class="border">
                                    <td align="center">分润可提现金额: ${temp.withdrawBalance}</td>
                                    <td align="center">滞纳金： 0</td>
                                    <td align="center">充值账户余额： ${temp.balance}</td>
                                    <td align="center">充值总量: ${getRechargeDetaiCount}</td>

                                </tr>
                                <tr class="border">
                                    <td align="center">消费金额: ${getConsumtionDetaiCount}</td>
                                    <td align="center">会员到期时间： <fmt:formatDate value="${temp.memeberTime }"
                                                                               type="both"/></td>
                                    <td align="center">审核通过时间： <fmt:formatDate value="${temp.examineTime }"
                                                                               type="both"/></td>
                                    <td align="center">审核人: 小明</td>

                                </tr>
                                </tr>
                                <tr class="border">
                                    <td align="center">最后登录时间: <fmt:formatDate value="${temp.lastLoginTime }"
                                                                               type="both"/></td>
                                    <td align="center">一键提醒：</td>
                                    <td align="center">
                                        <div class="layui-form-item" id="fendian">
                                            <label class="layui-form-label">账号状态</label>
                                            <div class="layui-input-inline">
                                                <select name="state" id="state" lay-filter="myselect"
                                                        style="width: 100px">

                                                    <option value="0" <c:if test="${temp.state==0}">selected</c:if>>正常
                                                    </option>


                                                    <option value="1" <c:if test="${temp.state==1}">selected</c:if>>封
                                                    </option>

                                                </select><br>
                                            </div>
                                        </div>
                                    </td>
                                    <td align="center">密码修改: <a>重置为888888</a></td>

                                </tr>
                                <tr class="border">
                                    <td align="center">分润比例: ${temp.state}</td>
                                    <td align="center" colspan="2">
                                        服务区域:
                                        <div id="ZnareaListShow1">
                                            <c:forEach var="stu" items="${ZnareaListShow}">
                                                <p><span>${stu}</span><span>---------------</span><a
                                                        onclick="dele(this)">删除</a></p>
                                            </c:forEach>
                                        </div>
                                        <br>
                                        <div class="layui-form-item">
                                            <label class="layui-form-label label1">选择区域:</label>
                                            <div class="layui-input-inline">
                                                <select name="area1"
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
                                                <select class="layui-input" name="area2"
                                                        id="area2"
                                                        lay-filter="area2">
                                                    <option value="">请选择市</option>
                                                </select>
                                            </div>
                                            <div class="layui-input-inline">
                                                <select class="layui-input" name="area3"
                                                        id="area3"
                                                        lay-filter="area3">
                                                    <option value="">请选择县</option>
                                                </select>
                                            </div>
                                            <a class="layui-btn" id="addznArea">增加区域 </a>
                                        </div>

                                    </td>
                                    <td align="center">
                                        <div class="layui-form-item">
                                            <label class="layui-form-label">地址：</label>
                                            <div class="layui-input-inline" style="width: 100px">
                                                <input value="${temp.address}" style="width:150px;" type="text"
                                                       name="address" lay-verify="required" autocomplete="off"
                                                       class="layui-input">
                                            </div>
                                        </div>
                                    </td>

                                </tr>
                                <tr class="border">
                                    <td align="center">
                                        <div class="layui-upload">
                                            <button type="button" class="layui-btn" id="test2">点击身份证照片</button>
                                            <div class="layui-upload-list">
                                                <img class="layui-upload-img" width="150px" height="100px"
                                                     style="border: 1px solid greenyellow"
                                                     src="${temp.idcardPicture}"
                                                     id="demo2">
                                                <p id="demoText2"></p>
                                                <input type="hidden" value="${temp.idcardPicture}"
                                                       name="idcardPicture" id="pic2">
                                            </div>
                                        </div>
                                    </td>
                                    <td align="center">
                                        <div class="layui-upload">
                                            <button type="button" class="layui-btn" id="test3">点击营业执照</button>
                                            <div class="layui-upload-list">
                                                <img class="layui-upload-img" width="150px" height="100px"
                                                     style="border: 1px solid greenyellow"
                                                     src="${temp.businessLicensePicture}"
                                                     id="demo3">
                                                <p id="demoText3"></p>
                                                <input type="hidden" value="${temp.businessLicensePicture}"
                                                       name="businessLicensePicture" id="pic3">
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <a class="layui-btn layui-bg-blue" id="tijiao3">立即提交 </a>
                                    </td>
                                    <button style="display: none;" class="layui-btn" id="tijiao2" type="submit"
                                            lay-filter="reg" lay-submit="">立即提交
                                    </button>
                                    <td>
                                        <a class="layui-btn layui-bg-red" id="datade1">删除 </a>
                                    </td>
                                </tr>
                            </table>
                            <%--${pageContext.request.contextPath}/PlayerController/modifyPlayer--%>
                        </form>
                        <div class="row" id="logPage">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function dele(val) {
        var fuwuId = $("#fuwuId").val();
        var area = val.parentNode.childNodes[0].innerText;
        $.ajax({
            url: '${pageContext.request.contextPath}/huiYuanDetail/serviceProviderDetailDeleteByArea.page?id=' + fuwuId + "&str=" + area,
            success: function (result) {
                console.log(result)
                if (result.code == 0) {
                    layer.msg("删除成功！");
                    val.parentNode.removeChild(val.parentNode.childNodes[0]);
                    val.parentNode.removeChild(val.parentNode.childNodes[0]);
                    val.parentNode.removeChild(val.parentNode.childNodes[0]);
                } else {
                    layer.msg(result.msg);
                }
            }
        })

    }

    layui.use(['upload', 'form', 'layer'], function () {
        var form = layui.form
            , laydate = layui.laydate;
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
                    $("#pic1").val(res.data);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText1');
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
        var uploadInst3 = upload.render({
            elem: '#test3'
            , url: '${pageContext.request.contextPath}/FileController/imgUpload.json'
            , before: function (obj) {
                //预读本地文件示例，不支持ie8
                obj.preview(function (index, file, result) {
                    $('#demo3').attr('src', result); //图片链接（base64）
                });
            }
            , done: function (res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                } else {
                    console.log(res);
                    $("#pic3").val(res.data);
                }
            }
            , error: function () {
                //演示失败状态，并实现重传
                var demoText = $('#demoText3');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function () {
                    uploadInst.upload();
                });
            }
        });
        form.on('submit(reg)', function (data) {
            console.log("执行修改服务商的方法");
            $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/huiYuanDetail/serviceProviderDetailUpdate.page');
        });
        $("#tijiao3").click(function (data) {
            console.info("添加");
            $("#tijiao2").click();
        });
        $("#datade1").click(function (data) {
            var fuwuId = $("#fuwuId").val();
            layer.confirm('当前会员已经产生真实数据，确定删除？', function (index) {
                console.log(data.id) //获取id
                $.ajax({
                    url: '${pageContext.request.contextPath}/huiYuanDetail/serviceProviderDetailDelete.page?id=' + fuwuId,
                    success: function (result) {
                        console.log(result)
                        if (result.code == 0) {
                            // obj.del();
                            layer.msg("删除成功！");
                            window.location.href = "${pageContext.request.contextPath}/get/serviceProviderManage.page";
                        } else {
                            layer.msg(result.msg);
                        }
                    }
                })
                layer.close(index);
            });
        });
        //ZnareaListShow1
        $("#addznArea").click(function (data) {
            if ($("#area3").val() == null) {
                layer.msg("请重新点击市!");
                return;
            }
            var fuwuId = $("#fuwuId").val();
            var str = $("#area1").val() + "|" + $("#area2").val() + "|" + $("#area3").val();
            console.log(str);
            $.ajax({
                url: '${pageContext.request.contextPath}/huiYuanDetail/addZnarea?id=' + fuwuId + "&str=" + str,
                success: function (data) {
                    console.log(data.code)
                    if (data.code == 0) {
                        layer.msg('添加成功');
                        $("#area3").empty();

                        $("#ZnareaListShow1").append("<p><span>" + data.msg + "</span><span>---------------</span><a onclick=\"dele(this)\">删除</a></p>")

                    } else {
                        layer.msg(data.msg);
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
                url: '${pageContext.request.contextPath}/znArea/getListZnAreaByserviceProvider.page?parentId=' + data.value,
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
        // 区域管理
    });
</script>

</body>
</html>