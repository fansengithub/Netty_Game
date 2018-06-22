<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <style>
        [name=lastname2] {
            margin: 0px 50px 0px 110px;
            width: 300px;
        }
    </style>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        教材管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            添加/修改教材
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <form class="layui-form layui-form-pane" id="myFrom">
        <c:if test="${learnbookDetail.id !=null}">
            <div class="layui-form-item">
                <label class="layui-form-label">教材id</label>
                <div class="layui-input-inline">
                    <input type="text" value="${learnbookDetail.id}" name="id" id="id" lay-verify="required" readonly
                           autocomplete="off" class="layui-input">
                </div>
            </div>


        </c:if>
        <div class="layui-form-item">
            <label class="layui-form-label">教材名</label>
            <div class="layui-input-inline">
                <input type="text" value="${learnbookDetail.name}" name="name" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">作者</label>
            <div class="layui-input-inline">
                <input type="text" value="${learnbookDetail.author}" name="author" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <c:if test="${user.xinxiType ==0}">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 160px">是否设置推荐教材</label>
            <div class="layui-input-inline">
                <select name="isRecommend" lay-verify="required">
                    <option value=""></option>
                    <option value="1"<c:if test="${learnbookDetail.isRecommend ==1}">selected</c:if>>是</option>
                    <option value="0"<c:if test="${learnbookDetail.isRecommend ==0}">selected</c:if>>否</option>
                </select>
            </div>
        </div>
        </c:if>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 160px">是否设置作者教材</label>
            <div class="layui-input-inline">
                <select name="isAnthor" lay-verify="required">
                    <option value=""></option>
                    <option value="1" <c:if test="${learnbookDetail.isAnthor ==1}">selected</c:if>>是</option>
                    <option value="0" <c:if test="${learnbookDetail.isAnthor ==0}">selected</c:if>>否</option>
                </select>
            </div>
        </div>
        <c:if test="${learnbookDetail.id !=null}">
            <div class="layui-form-item">
                <label class="layui-form-label">使用权限</label>
                <div class="layui-input-block">
                    <input type="checkbox" lay-filter="vehicle" name="vehicle" id="vehicle" value="Car" title="全部琴行">
                </div>
            </div>
            <div class="layui-form-item" id="fendian">
                <label class="layui-form-label">选择琴行</label>
                <div class="layui-input-block" >
                    <select name="priceUsed" id="myselect" lay-filter="myselect">
                        <c:forEach var="stu" items="${pianoShopList}">
                            <option value="${stu.id}">曲谱id:${stu.id}&nbsp;&nbsp;&nbsp;&nbsp;曲谱名称:(${stu.name})</option>
                        </c:forEach>
                    </select><br>
                </div>
            </div>
        </c:if>

        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test1">上传图片</button>
            <div class="layui-upload-list">
                <img class="layui-upload-img" width="300px" height="200px" style="border: 1px solid greenyellow"
                     src="${learnbookDetail.coverPicture}" id="demo1">
                <p id="demoText"></p>
                <input type="hidden" value="${learnbookDetail.coverPicture}" name="coverPicture" id="pic">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">简介</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="summary"
                          class="layui-textarea">${learnbookDetail.summary}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addLearnbook">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>

<script>

    layui.use(['upload', 'form', 'jquery'], function () {
        var form = layui.form;
        var $ = layui.$
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
                $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/learnbook/update.page');
            } else {
                console.info("添加")
                $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/learnbook/add.page');
            }
        });

        form.on('checkbox(vehicle)', function () {

            if (this.checked) {
                $("#fendian").hide();
            } else {
                $("#fendian").show();
            }
        });
        form.on('select(myselect)', function () {
            var opt = $("#myselect").val();
            var opt2 = $("#myselect").find("option:selected").text();
            ;
            console.log(opt);
            console.log(opt2);
            $("#fendian").append('<p><input type="hidden" name="lastname" value="' + opt + '"><input type="text" name="lastname2" value="' + opt2 + '"><a class="aaa" onclick="dele(this)">删除</a></p>');
        });
    });

    function dele(val) {
        console.log(val.getAttribute("class"))
        val.parentNode.removeChild(val.parentNode.childNodes[0]);
        val.parentNode.removeChild(val.parentNode.childNodes[0]);
        val.parentNode.removeChild(val.parentNode.childNodes[0]);
    }
</script>
</body>
</html>