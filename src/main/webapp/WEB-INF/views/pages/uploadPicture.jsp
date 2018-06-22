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
        过渡界面管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            过渡界面上传图片
        </small>
    </h1>
</div>
<div class="layui-container">
    <blockquote class="layui-elem-quote">过渡界面上传图片</blockquote>

    <%--<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">--%>
    <%--<legend>始终等比例水平排列</legend>--%>
    <%--</fieldset>--%>
    <form class="layui-form layui-form-pane" id="myFrom" lay-filter="myFrom">
        <div class="layui-row">
            <%--<input type="text" value="${pianoShop.transitionPicture}">--%>
            <div class="layui-col-xs12">
                <div class="grid-demo">
                    <div class="layui-upload">
                        <button type="button" class="layui-btn" id="test1">选择上传</button>
                        <div class="layui-upload-list">
                            <img class="layui-upload-img" width="300px" height="200px"
                                 style="border: 1px solid greenyellow"
                                 src="${pianoShop.transitionPicture}"
                                 id="demo1">
                            <p id="demoText"></p>
                            <input type="hidden" value="" required
                                   name="transitionPicture" id="pic">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="layui-row">

            <div class="layui-col-xs12">
                <button class="layui-btn" lay-submit="" lay-filter="addLearnbook" id="ti">立即提交</button>
            </div>
        </div>
    </form>
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
            $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/get/uploadPictureDetail.page');
        });

    });
</script>
</body>
</html>