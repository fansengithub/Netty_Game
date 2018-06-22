<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <style type="text/css">
        .layui-row {
            margin-top: 80px;
            font-size: 20px;
        }
    </style>
</head>
<body style="background: white">
<div class="layui-container">
    <blockquote class="layui-elem-quote">我的账户</blockquote>

    <%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">--%>
    <%--<legend>始终等比例水平排列</legend>--%>
    <%--</fieldset>--%>

    <div class="layui-row">
        <div class="layui-col-xs4">
            <div class="grid-demo grid-demo-bg1">分润总熊掌:${shareCount}</div>
        </div>
        <div class="layui-col-xs4">
            <div class="grid-demo">可提现熊掌:${bigDecimal}</div>
        </div>
        <div class="layui-col-xs4">
            <div class="grid-demo">滞纳金:${zhidaijin}</div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-xs4">
            <div class="grid-demo grid-demo-bg1">充值熊掌:${rechargeMoney}</div>
        </div>
        <div class="layui-col-xs4">
            <div class="grid-demo">充值到账熊掌:${rechargeObject}</div>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-xs12">
            <div class="grid-demo">
                <c:if test="${not empty yuqiDate}">
                    逾期时间为:<fmt:formatDate value="${yuqiDate}" type="both"/>
                </c:if>
                ,请在规定时间内纳税,否则将会对账户金额冻结
            </div>
        </div>
    </div>

</div>


<script>
    layui.use(['upload', 'form', 'element'], function () {
        var form = layui.form, element = layui.element;
        element.render();
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
            var rid = $("#id").val();
            console.info(rid)
            if (rid != null && rid != "") {
                console.info("修改")
                $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/cms/update.page?id=' + rid);
            } else {
                console.info("添加")
                $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/cms/add.page');
            }
        });

        form.on('select(columnType)', function (data) {
            console.log(data.value); //得到被选中的值
            if (data.value == 1) {
                $(".aa1").show();
                $(".aa2").hide();
                $(".aa3").hide();
                $(".aa41").hide();
                $(".aa42").hide();
            } else if (data.value == 2) {
                $(".aa1").hide();
                $(".aa2").show();
                $(".aa3").hide();
                $(".aa41").hide();
                $(".aa42").hide();
            } else if (data.value == 3) {
                $(".aa1").hide();
                $(".aa2").hide();
                $(".aa3").show();
                $(".aa41").hide();
                $(".aa42").hide();
            } else if (data.value == 4) {
                $(".aa1").hide();
                $(".aa2").hide();
                $(".aa3").hide();
                $(".aa41").show();
                $(".aa42").show();
            }
        });
        if (${cmsAdver.columnType == 1}) {
            $(".aa1").show();
            $("textContent1").val(18);
        } else if (${cmsAdver.columnType == 2}) {
            $(".aa2").show();
        } else if (${cmsAdver.columnType == 3}) {
            $(".aa3").show();
        } else if (${cmsAdver.columnType == 4}) {
            $(".aa41").show();
            $(".aa42").show();
        }
    });
</script>
</body>
</html>