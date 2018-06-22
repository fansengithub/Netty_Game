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
		参数管理
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			难度设置
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="demoTable">


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
            ,url: '${pageContext.request.contextPath}/integration/selAll.page' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'typeId', title: '类别序号', width:100, sort: true}
                ,{field: 'content', title: '积分内容', width:200,}
                ,{field: 'value', title: '奖励积分数值', width:200, templet:'#value'}
                ,{field: 'topValues', title: '基础练习评分在多少以上获得奖励', width:300,templet:'#topValues' }
                ,{field:'stage', title: '操作',width:100,toolbar:"#learnbookedt"}
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
                        url:'${pageContext.request.contextPath}/integration/deleteByKey.page?id='+data.typeId,
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
                window.location.href="${pageContext.request.contextPath}/integration/sel.page?id="+data.typeId;
            }
        });
    });

</script>
<%--数据操作按钮--%>
<script type="text/html" id="learnbookedt">
	<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>

</script>
<script type="text/javascript">
    function addlearn(){
        window.location.href="${pageContext.request.contextPath}/get/addDifficultySet.page";
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
<script type="text/html" id="value">
	{{#  if(d.value ==null ){ }}
		不需要
	{{#  } }}
	{{#  if(d.value !=null ){ }}
		{{d.value}}
	{{#  } }}
	</script>
<script type="text/html" id="topValues">
	<%--{{d.topValues}}--%>

	{{#  if(d.topValues ==null ){ }}
		不需要
	{{#  } }}
	{{#  if(d.topValues !=null ){ }}
		{{d.topValues}}
	{{#  } }}

	<%--{{#  if(d.topValues ！=null){ }}--%>
	<%--<a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">d.topValues</a>--%>
	<%--{{#  } }}--%>

</script>
</body>
</html>
</html>