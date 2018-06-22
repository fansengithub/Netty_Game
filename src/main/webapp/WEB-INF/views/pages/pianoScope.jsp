<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<jsp:include page="/common/backend_common.jsp"/>
	<jsp:include page="/common/page.jsp"/>
	<link rel="stylesheet" href="/static/build/layui.css" media="all">
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
	<h1>
		会员管理
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			琴行规模
		</small>
	</h1>
</div>
<div class="demoTable">
	搜索：
	<div class="layui-inline">
		<input class="layui-input" name="keyword" id="serachopera" placeholder="请输入搜索条件" autocomplete="off">
	</div>
	<button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>
</div>


<table id="operas" lay-filter="operas"></table>


<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#operas'
            ,id:'opera'
            ,cellMinWidth:100
            ,url: '${pageContext.request.contextPath}/huiYuanDetail/selAll1' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: '琴行规模ID', width:300, sort: true, fixed: 'left'}
                ,{field: 'type', title: '琴行规模类型', width:300}
                ,{field: 'maxTeacherNum', title: '最大老师数量', width:300}

                ,{field:'right', title: '操作',width:200,toolbar:"#operasedt"}
            ]]
            ,request: {
                pageName: 'page' //页码的参数名称，默认：page
                ,limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            ,done: function(res, page, count){
                console.log(res);
                //得到当前页码
                console.log(page);
                //console.log(limit);
                //得到数据总量
                console.log(count);
            },
        });
        //搜索
        var $ = layui.$, active = {
            reload: function () {
                var serachopera = $('#serachopera'); //搜索条件
                table.reload('opera', {
                    where: {
                        keyword: serachopera.val()
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
        table.on('tool(operas)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    console.log(data.id) //获取id
                    $.ajax({
                        url:'${pageContext.request.contextPath}/pianoScope/deleteById.page?id='+data.id,
                        success:function (result) {
                            console.log(result)
                            if(result.code==0){
                                // obj.del();
                                table.reload('opera'); //重新加载表格数据
                            }else{
                                layer.msg("删除失败！");
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                window.location.href="${pageContext.request.contextPath}/pianoScope/selectById.page?id="+data.id;
            }
        });
    });

</script>

<%--数据操作按钮--%>
<script type="text/html" id="operasedt">
	<a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
</script>
</body>
</html>