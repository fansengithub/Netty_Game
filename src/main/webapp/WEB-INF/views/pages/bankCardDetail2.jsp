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
			银行卡
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="demoTable">


		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button class="layui-btn layui-btn-normal"  data-type="add" onclick="addlearn()">新增银行卡</button>
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
            ,url: '${pageContext.request.contextPath}/BankcardDetail/selAll.page' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'userId', title: '用户ID', width:100, sort: true}
                ,{field: 'userName', title: '用户名', width:100,}
                ,{field: 'roler', title: '角色', width:100, templet:'#roler'}
                ,{field: 'opeanBank', title: '开户行地址', width: 100}
                ,{field: 'holderName', title: '开户姓名', width: 100, templet:'#opernNum'}
                ,{field: 'bankcardNum', title: '账号', width: 100}
                ,{field: 'bankcardType', title: '类型', width: 150}
                ,{field: 'isDefault', title: '是否为默认银行卡', width: 150,templet:'#isDefault'}
                ,{field:'stage', title: '设置默认银行卡',width:150,toolbar:"#learnbookedt"}
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
                window.location.href="${pageContext.request.contextPath}/BankcardDetail/update.page?id="+data.id;
            }
        });
    });

</script>
<%--数据操作按钮--%>
<script type="text/html" id="learnbookedt">
	<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">改变</a>
</script>
<script type="text/javascript">
    function addlearn(){
        window.location.href="${pageContext.request.contextPath}/get/addBankCard.page";
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

<%--提现状态--%>
<script type="text/html" id="isDefault">
	{{#  if(d.isDefault ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm">是</a>
	{{#  } }}
	{{#  if(d.isDefault ==0){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-red">不是</a>
	{{#  } }}
</script>
<script type="text/html" id="roler">
	{{#  if(d.roler ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">服务商</a>
	{{#  } }}
	{{#  if(d.roler ==2){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">机构</a>
	{{#  } }}
	{{#  if(d.roler ==3){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">琴行</a>
	{{#  } }}
	{{#  if(d.roler ==4){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">老师</a>
	{{#  } }}
</script>
</body>
</html>