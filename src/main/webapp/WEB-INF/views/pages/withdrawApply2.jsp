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
		分润系统
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			余额提现申请
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="demoTable">
		搜索教材：
		<div class="layui-inline">
			<input class="layui-input" name="keyword" id="serachlearnbook" placeholder="输入单号,用户名" autocomplete="off">
		</div>
		状态:
		<select name="type" lay-verify="required" id="consumpType1">
			<option value="">所有</option>
			<option value="0">审核中</option>
			<option value="1">已完成</option>
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


		<button class="layui-btn layui-btn-normal"  data-type="add" onclick="addlearn()">新增提现申请</button>
		<button class="layui-btn layui-btn-warm"> 我的可提现余额为：${bigDecimal}熊掌</button>
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
            ,url: '${pageContext.request.contextPath}/withdrawDetail/selAll.page' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'number', title: '单号', width:200, sort: true}
                ,{field: 'roleType', title: '平台', width:100, templet:'#roleType'}
                ,{field: 'role', title: '身份', width:100, templet:'#role'}
                ,{field: 'username', title: '用户名', width:140,}
                ,{field: 'withdrawObject', title: '提现熊掌', width:120, sort: true}
                ,{field: 'accountMoney', title: '到账金额', width:120 ,sort: true}
                ,{field: 'withdrawTime', title: '提现时间', width: 200,templet:"<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>",sort: true}
                ,{field: 'bankAccount', title: '银行卡帐号', width: 200, templet:'#opernNum',sort: true}
                ,{field: 'stage', title: '状态', width:100, templet:'#stage'}
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
                        stage: consumpType1.val(),
                        startTime: startTime.val(),
                        endTime: endTime.val()
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
        window.location.href="${pageContext.request.contextPath}/get/addWithdrawApply.page";
    }
</script>

<%--提现状态--%>
<script type="text/html" id="stage">
	{{#  if(d.stage ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green" >已完成</a>
	{{#  } }}
	{{#  if(d.stage ==0){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-red">审核中</a>
	{{#  } }}
</script>
<script type="text/html" id="roleType">
	{{#  if(d.roleType ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green" >前台</a>
	{{#  } }}
	{{#  if(d.roleType ==2){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">后台</a>
	{{#  } }}
</script>
<script type="text/html" id="role">
	{{#  if(d.role ==0){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green" >总管理</a>
	{{#  } }}
	{{#  if(d.role ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green" >服务商</a>
	{{#  } }}
	{{#  if(d.role ==2){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green" >机构</a>
	{{#  } }}
	{{#  if(d.role ==31){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green" >琴行</a>
	{{#  } }}
	{{#  if(d.role ==4){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">老师</a>
	{{#  } }}
</script>
</body>
</html>