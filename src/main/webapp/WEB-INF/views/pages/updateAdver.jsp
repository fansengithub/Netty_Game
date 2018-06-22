<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        CMS管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            修改广告
        </small>
    </h1>
</div>
<div class="main-content-inner">
        <form class="layui-form layui-form-pane" id="myFrom">
            <div class="layui-form-item">
                <label class="layui-form-label">序号</label>
                <div class="layui-input-inline">
                    <input type="text" value="${cmsAdver.id}" id="id" name="id"  readonly autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">作者</label>
                <div class="layui-input-inline">
                    <input type="text" value="${cmsAdver.founder}" name="author" lay-verify="required" readonly autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-upload">
                <button type="button" class="layui-btn" id="test1">重新上传封面图片</button>
                <div class="layui-upload-list">
                    <img class="layui-upload-img" src="${cmsAdver.coverPicture}" id="demo1" style="width:300px;height:300px;">
                    <p id="demoText"></p>
                    <input type="hidden" value="${cmsAdver.coverPicture}" name="coverPicture" id="pic">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">栏目类型</label>
                <div class="layui-input-inline">

                    <c:if test="${cmsAdver.columnType eq 1}">
                        <input type="text"   name="columnType" class="layui-input" value="教材" >
                    </c:if>
                </div>
            </div>


            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">内容</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入内容" name="textContent" class="layui-textarea">${cmsAdver.textContent}</textarea>
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
    layui.use(['upload','form','layedit'], function() {
        var form=layui.form;
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath}/FileController/imgUpload.json'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }else{
                    console.log(res);
                    $("#pic").val(res.data);
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        form.on('submit(addLearnbook)', function(data){
            var rid=$("#id").val();
            console.info(rid)
            if(rid!=null&&rid!=""){
                console.info("修改")
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/cms/update.page');
            }else{
                console.info("添加")
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/learnbook/add.page');
            }
        });
    });
</script>

<script type="text/html" id="columnType">
    {{#  if(d.columnType ==1){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">教材</a>
    {{#  } }}
    {{#  if(d.columnType ==2){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">曲谱</a>
    {{#  } }}
    {{#  if(d.columnType ==3){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">广告</a>
    {{#  } }}
    {{#  if(d.columnType ==4){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">文本</a>
    {{#  } }}
</script>
</body>
</html>