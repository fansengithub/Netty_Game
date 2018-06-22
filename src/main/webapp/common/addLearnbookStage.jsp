<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<jsp:include page="/common/backend_common.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white">
	<form class="layui-form" action="">
		<input type="hidden" value="" id="id" name="id">
		<div class="layui-form-item">
			<label class="layui-form-label">教材阶段管理:</label>
			<div class="layui-input-inline">
				<input type="text" name="content" id="content" required lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
<script>
    layui.use('form', function(){
        var form = layui.form;
        //监听提交
        form.on('submit(formDemo)', function(data){
            console.log(JSON.stringify(data.field));
            $.ajax({
                url:'${pageContext.request.contextPath}/stage/add.page?content='+data.field.content+"&id="+data.field.id,
                success:function (result) {
                    console.log(result)
                    if(result.code==0){
                        layer.msg("操作成功！");
                    }else{
                        layer.msg("操作失败！");
                    }
                }
            })
            return false;
        });
    });
</script>
</html>