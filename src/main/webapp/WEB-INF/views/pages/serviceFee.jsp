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
        参数设置
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
           手续费设置
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <form class="layui-form layui-form-pane" id="myFrom">
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">免手续费提现金额最少</label>
            <div class="layui-input-inline">
                <input type="text" value="${parametersSet1.value}" id="id" name="value1"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">元</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">不满金额手续费</label>
            <div class="layui-input-inline">
                <input type="text" value="${parametersSet2.value}" name="value2" lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                &permil;</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">琴行创建老师时候的费用</label>
            <div class="layui-input-inline">
                <input type="text" value="${parametersSet3.value}" name="value3" lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">熊掌</div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">熊掌充换现金比例</label>
            <div class="layui-input-inline">
                <input type="text" value="${parametersSet4.value}" name="value4" lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="addLearnbook">立即修改</button>
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
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/parametersSet/update.page');
            }else{
                console.info("添加")
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/parametersSet/update.page');
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