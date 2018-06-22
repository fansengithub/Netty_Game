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
		充值
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			充值明细
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="demoTable">
		搜索：
		<div class="layui-inline">
			<input class="layui-input" name="keyword" id="keyword" placeholder="输入ID或店主/姓名" autocomplete="off">
		</div>

		<div class="layui-inline">
			<label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提现开始时间</label>

			<div class="layui-input-inline">
				<input  class="layui-input" name="startTime" id="startTime" placeholder="yyyy-MM-dd HH:mm:ss">
			</div>
		</div>

		<div class="layui-inline">
			<label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提现结束时间</label>

			<div class="layui-input-inline">
				<input  class="layui-input" name="endTime" id="endTime" placeholder="yyyy-MM-dd HH:mm:ss">
			</div>
		</div>


		&nbsp;&nbsp;&nbsp;&nbsp;
		<button class="layui-btn layui-btn-normal"  data-type="reload">搜索</button>
		<%--<button class="layui-btn layui-btn-normal"  data-type="add" onclick="addlearn()">新增皮肤风格</button>--%>
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
            ,url: '${pageContext.request.contextPath}/get/selAllConsumDetail' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: '数据iD', width:150, sort: true}
                ,{field: 'userId', title: '用户ID', width:150, sort: true}
                ,{field: 'name', title: '店名/姓名', width:150, }
                ,{field: 'role', title: '角色', width:150, }
                ,{field: 'consumptionMoney', title: '消费金额', width:150, }
                ,{field: 'consumptionDetail', title: '消费详情', width:250, }
                ,{field: 'rechargeType', title: '支付方式', width:200, }
                ,{field: 'createtime', title: '消费时间', width:200,templet:"<div>{{layui.util.toDateString(d.createtime, 'yyyy-MM-dd HH:mm:ss')}}</div>" }
                ,{field: 'restMoney', title: '剩余金额', width:200, }
                // ,{field:'stage', title: '操作',width:200,toolbar:"#learnbookedt"}
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
                var keyword = $('#keyword'); //搜索条件
                var startTime = $('#startTime'); //搜索条件
                var endTime = $('#endTime'); //搜索条件
                table.reload('learntable', {
                    where: {
                        keyword: keyword.val(),
                        startTime: startTime.val(),
                        endTime: endTime.val()
                    }
                });
            }
        }
        var laydate = layui.laydate;   //加载时间组件
        //日期时间选择器
        laydate.render({
            elem: '#startTime'
            ,type: 'datetime'
        });
        laydate.render({
            elem: '#endTime'
            ,type: 'datetime'
        });
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
                        url:'${pageContext.request.contextPath}/skinDetail/deleteByKey.page?id='+data.id,
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
                window.location.href="${pageContext.request.contextPath}/skinDetail/selectByKey.page?id="+data.id;
            }
        });
    });

</script>
</body>
</html>