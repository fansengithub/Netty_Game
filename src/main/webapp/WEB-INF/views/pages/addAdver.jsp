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

        .aa1, .aa2, .aa3, .aa41, .aa42 {
            display: none
        }
    </style>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        CMS管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            添加/修改广告
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <form class="layui-form layui-form-pane" id="myFrom" lay-filter="myFrom">
        <input type="hidden" value="${cmsAdver.id}" name="id" id="id">
                <div class="layui-form-item">
                    <label class="layui-form-label label1">栏目分类:</label>

                    <div class="layui-input-block">
                        <select class="layui-input" name="columnName" required id="columnName" lay-filter="columnName">
                    <c:if test="${cmsAdver.type==1}">
                        <option value="1" <c:if test="${cmsAdver.columnName == 1}">selected</c:if>>首页轮播图</option>
                        <option value="2" <c:if test="${cmsAdver.columnName == 2}">selected</c:if>>教材库轮播图</option>
                    </c:if>
                    <c:if test="${cmsAdver.type==2}">
                        <option value="4" <c:if test="${cmsAdver.columnName == 4}">selected</c:if>>首页热门广告</option>
                    </c:if>
                    <option value="3" <c:if test="${cmsAdver.columnName == 3}">selected</c:if>>没有内容</option>
                </select>
            </div>

        </div>
        <div class="layui-upload">
            <button type="button" class="layui-btn" id="test1">封面图片</button>
            <div class="layui-upload-list">
                <img class="layui-upload-img" width="300px" height="200px" style="border: 1px solid greenyellow"
                     src="${cmsAdver.coverPicture}"
                     id="demo1">
                <p id="demoText"></p>
                <input type="hidden" value="${cmsAdver.coverPicture}" required name="coverPicture" id="pic">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">栏目类型:</label>
            <div class="layui-input-block">
                <select class="layui-input" name="columnType" required id="columnType" lay-filter="columnType">
                    <option value="">请选择</option>
                    <option value="1" <c:if test="${cmsAdver.columnType == 1}">selected</c:if>>教材</option>
                    <option value="2" <c:if test="${cmsAdver.columnType == 2}">selected</c:if>>曲谱</option>
                    <option value="3" <c:if test="${cmsAdver.columnType == 3}">selected</c:if>>广告</option>
                    <option value="4" <c:if test="${cmsAdver.columnType == 4}">selected</c:if>>文本</option>
                </select>
            </div>
        </div>
        <%--栏目类型1--%>
        <div class="layui-form-item aa1">
            <label class="layui-form-label">教材选择:</label>
            <div class="layui-input-block">
                <select class="layui-input" name="textContent1" id="textContent1" lay-filter="textContent1">
                    <c:forEach var="stu" items="${learnbookDetailList}">
                        <c:if test="${'sddfsf'.matches('[0-9]+')}">
                            <fmt:parseNumber value="sss" type="number" var="credit2"></fmt:parseNumber>
                        </c:if>
                        <option value="${stu.id}">
                            教材id: ${stu.id}&nbsp;&nbsp;&nbsp;&nbsp;教材名称:(${stu.name}+${credit2})
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <%--栏目类型2--%>
        <div class="layui-form-item aa2">
            <label class="layui-form-label">曲谱选择:</label>
            <div class="layui-input-block">
                <select class="layui-input" name="textContent2" id="textContent2" lay-filter="textContent2">
                    <c:forEach var="stu" items="${operaDetailList}">
                        <option value="${stu.id}">曲谱id:${stu.id}&nbsp;&nbsp;&nbsp;&nbsp;曲谱名称:(${stu.operaName})</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <%--栏目类型3--%>
        <div class="layui-form-item aa3">
            <label class="layui-form-label">广告链接:</label>
            <div class="layui-input-block">
                <input type="text" value="${cmsAdver.textContent}" id="textContent3" name="textContent3"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <%--栏目类型4--%>
        <div class="layui-form-item aa41">
            <label class="layui-form-label">广告标题:</label>
            <div class="layui-input-block">
                <input type="text" value="${cmsAdver.textContent}" id="textContent4" name="textContent4"
                       autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item  aa42">
            <label class="layui-form-label">广告简介</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入内容" name="contant"
                          class="layui-textarea">${cmsAdver.contant}</textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">创建人</label>
            <div class="layui-input-block">
                <input type="text" value="${cmsAdver.founder}" required name="founder" lay-verify="founder"
                       autocomplete="off"
                       class="layui-input">
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
    layui.use(['upload', 'form', 'layedit'], function () {
        var form = layui.form;

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