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
			皮肤类型
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="demoTable">
		搜索皮肤：
		<div class="layui-inline">
			<input class="layui-input" name="keyword" id="serachlearnbook" placeholder="输入皮肤类型ID" autocomplete="off">
		</div>
		<button class="layui-btn layui-btn-normal"  data-type="reload">搜索</button>

		<button class="layui-btn layui-btn-normal"  data-type="add" onclick="addlearn()">新增皮肤类型</button>
	</div>

	<table id="learnbooks" lay-filter="learnbooks"></table>
</div>

<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#learnbooks'
            ,id:'learntable'
            ,cellMinWidth:100
            ,url: '${pageContext.request.contextPath}/skinType/selAll.page' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: '皮肤类型ID', width:150, sort: true}
                ,{field: 'name', title: '皮肤类型名称', width:250, sort: true}
                ,{field:'stage', title: '操作',width:200,toolbar:"#learnbookedt"}
            ]]
            ,request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            ,done: function(res, page, count){
                console.log(res);
                //得到当前页码
                console.log(page);
                //得到数据总量
                console.log(count);
            },
        });
        //搜索
        var $ = layui.$, active = {
            reload: function () {
                var serachlearnbook = $('#serachlearnbook'); //搜索条件
                table.reload('learntable', {
                    where: {
                        keyword: serachlearnbook.val()
                    }
                });
            }
        }
        // 绑定click点击事件
        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            console.log("type"+type)
            active[type] ? active[type].call(this) : '';
        });
        //监听工具条
        table.on('tool(learnbooks)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('确定要删除吗?', function(index){
                    console.log(data.id) //获取id
                    $.ajax({
                        url:'${pageContext.request.contextPath}/skinType/deleteByKey.page?id='+data.id,
                        success:function (result) {
                            console.log(result)
                            if(result.code==0){
                                // obj.del();
                                table.reload('learntable'); //重新加载表格数据
                            }else{
                                layer.msg(result.msg);
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                window.location.href="${pageContext.request.contextPath}/skinType/selectByKey.page?id="+data.id;
            }
        });
    });

</script>
<%--数据操作按钮--%>
<script type="text/html" id="learnbookedt">
	<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addlearn(){
        window.location.href="${pageContext.request.contextPath}/get/addSkinType.page";
    }
    function goDetail(){
        // var type = $('#type').val();
        alert("www")
        window.location.href="${pageContext.request.contextPath}/get/getOrginazDetail.page";
    }
    function add(){
        // var type = $('#type').val();
        alert("add")
        window.location.href="${pageContext.request.contextPath}/get/addLearnBook.page";
    }
</script>
</body>
</html>