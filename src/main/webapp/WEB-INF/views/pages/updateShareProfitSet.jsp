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
        商城管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            修改分润
        </small>
    </h1>
</div>
<div class="main-content-inner">
        <form class="layui-form layui-form-pane" id="myFrom">
            <input type="hidden" value="${shareProfit.role}" id="id2" name="roleid"  readonly autocomplete="off" class="layui-input">
            <div class="layui-form-item">
                <label class="layui-form-label">角色</label>
                <div class="layui-input-inline">
                    <input type="text" value="${shareProfit.role}" id="id" name="role"  readonly autocomplete="off" class="layui-input">

                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">游戏分润</label>
                <div class="layui-input-inline">
                    <input type="text" value="${shareProfit.gameProfit}" name="gameProfit" lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">购买教材分润</label>
                <div class="layui-input-inline">
                    <input type="text" value="${shareProfit.learnbookProfit}" name="learnbookProfit" lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">皮肤分润</label>
                <div class="layui-input-inline">
                    <input type="text" value="${shareProfit.skinProfit}" name="skinProfit" lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">琴行创建老师分润</label>
                <div class="layui-input-inline">
                    <input type="text" value="${shareProfit.createTeacherProfit}" name="createTeacherProfit" lay-verify="required"  autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">曲谱讲解</label>
                <div class="layui-input-inline">
                    <input type="text" value="${shareProfit.operaExplain}" name="operaExplain" lay-verify="required"  autocomplete="off" class="layui-input">
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

                console.info("修改")
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/shareProfit/update.page');

        });
    });
</script>

<script>
    var id=document.getElementById("id");
    if(id.value ==1){
        id.value="服务商";
    }
    if(id.value ==2){
        id.value="机构";
    }
    if(id.value ==3){
        id.value="琴行";
    }
    if(id.value ==4){
        id.value="推荐人";
    }
    if(id.value ==5){
        id.value="老师";
    }

</script>
</body>
</html>