<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
	<jsp:include page="/common/backend_common.jsp"/>
	<jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
	<h1>
		分润系统
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			收入明细
		</small>
	</h1>
</div>

<div class="main-content-inner">
	<div class="demoTable">
		<button class="layui-btn layui-btn-warm">我的总收入：<span id="Count">${Count}</span>熊掌</button>

		<div class="layui-inline">
			<input class="layui-input" name="keyword" id="serachlearnbook" placeholder="用户ID或用户名" autocomplete="off">
		</div>
		<select name="type" lay-verify="required" id="consumpType1">
				<option value="">所有</option>
				<option value="1">琴行创建</option>
				<option value="2">曲谱讲解</option>
				<option value="3">皮肤收入</option>
				<option value="4">教材收入</option>
				<option value="5">游戏收入</option>

		</select>
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
            ,url: '${pageContext.request.contextPath}/IncomeDetail/selAll.page' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'userId', title: '用户ID', width:80, sort: true}
                ,{field: 'userName', title: '用户名', width:100,}
                ,{field: 'role', title: '角色', width:100, templet:'#role'}
                ,{field: 'consumpType', title: '消费类型', width:100, templet:'#consumpType'}
                ,{field: 'incomeMoney', title: '收入金额', width: 100, templet:'#opernNum'}
                ,{field: 'accountBalance', title: '账户金额', width: 100}
                ,{field: 'createTime', title: '时间', width: 200,templet:"<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
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
				var consumpType1=$("#consumpType1");
                var startTime = $('#startTime'); //搜索条件
                var endTime = $('#endTime'); //搜索条件
                table.reload('learntable', {
                    where: {
                        keyword: serachlearnbook.val(),
                        consumpType1: consumpType1.val(),
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
                        url:'${pageContext.request.contextPath}/learnbook/dellearnbook.page?lid='+data.id,
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
                window.location.href="${pageContext.request.contextPath}/learnbook/sel.page?lid="+data.id;
            }
        });
    });

</script>
<%--数据操作按钮--%>
<script type="text/html" id="learnbookedt">
	<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看曲谱</a>
	<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addlearn(){
        window.location.href="${pageContext.request.contextPath}/get/addLearnBook.page";
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
<script type="text/html" id="consumpType">
	{{#  if(d.consumpType ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">琴行创建</a>
	{{#  } }}
	{{#  if(d.consumpType ==2){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">曲谱讲解</a>
	{{#  } }}
	{{#  if(d.consumpType ==3){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">皮肤收入</a>
	{{#  } }}
	{{#  if(d.consumpType ==4){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">教材收入</a>
	{{#  } }}
	{{#  if(d.consumpType ==5){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">游戏收入</a>
	{{#  } }}
</script>
<script type="text/html" id="role">
	{{#  if(d.role ==0){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">总管理</a>
	{{#  } }}
	{{#  if(d.role ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">服务商</a>
	{{#  } }}
	{{#  if(d.role ==2){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">机构</a>
	{{#  } }}
	{{#  if(d.role ==3){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">琴行</a>
	{{#  } }}
	{{#  if(d.role ==4){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">老师</a>
	{{#  } }}
</script>
</body>
</html>