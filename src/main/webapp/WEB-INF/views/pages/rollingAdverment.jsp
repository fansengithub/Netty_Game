<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<jsp:include page="/common/backend_common.jsp"/>
	<jsp:include page="/common/page.jsp"/>
	<style>
		.laytable-cell-1-coverPicture{  /*最后的pic为字段的field*/
			height: 100%;
			max-width: 100%;
		}
	</style>
</head>

<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
	<h1>
		CMS管理
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			滚动广告位
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="demoTable">
		搜索：
		<div class="layui-inline">
			<input class="layui-input" name="keyword" id="serachlearnbook" placeholder="输入搜索教材" autocomplete="off">
		</div>
		<button class="layui-btn layui-btn-normal"  data-type="reload">搜索</button>

		<button class="layui-btn layui-btn-normal"  data-type="add" onclick="addlearn()">新增广告位</button>
	</div>

	<table id="learnbooks" lay-filter="learnbooks"></table>
</div>

<script>
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#learnbooks'
            ,id:'CMStable'
            ,cellMinWidth:100
            ,url: '${pageContext.request.contextPath}/cms/selAll.page?type=1' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
				{field: 'id', title: 'ID', width:80, sort: true}
                ,{field: 'columnName', title: '栏目分类名称', width:200,templet:'#columnName'}
                ,{field: 'coverPicture', title: '封面图片', width:150,style:"height:100px;",templet:'<div><img style="width: 100px;height: 100px" src="{{d.coverPicture}}"></div>'}
                ,{field: 'textContent', title: '内容', width: 500}
                ,{field: 'columnType', title: '栏目类型',width: 150,templet:'#columnType'}
                ,{field: 'founder', title: '创建人', width: 100, templet:'#opernNum'}
                ,{field: 'createTime', title: '创建时间', width: 200,sort: true ,templet:"<div>{{layui.util.toDateString(d.createTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
                ,{field:'right', title: '操作',width:200,toolbar:"#CMSedit"}


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
                table.reload('CMStable', {
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
                        url:'${pageContext.request.contextPath}/cms/deleteByKey.page?id='+data.id,
                        success:function (result) {
                            console.log(result)
                            if(result.code==0){
                                // obj.del();
                                table.reload('CMStable'); //重新加载表格数据
                            }else{
                                layer.msg(result.msg);
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                window.location.href="${pageContext.request.contextPath}/cms/selectByKey.page?id="+data.id;
            }
        });
    });

</script>
<%--数据操作按钮--%>
<script type="text/html" id="CMSedit">
	<%--<a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看曲谱</a>--%>
	<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addlearn(){
        <%--window.location.href="${pageContext.request.contextPath}/pages/addAdver.jsp";--%>
        window.location.href="${pageContext.request.contextPath}/get/addAdver.page?type=1";

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
<%--  对后台数字映射为汉字  --%>
<script type="text/html" id="columnName">
	{{#  if(d.columnName ==1){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm">首页轮播图</a>
	{{#  } }}
	{{#  if(d.columnName ==2){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm">教材库轮播图</a>
	{{#  } }}
	{{#  if(d.columnName ==3){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm">没有内容</a>
	{{#  } }}
</script>

<script type="text/html" id="columnType">
	{{#  if(d.columnType ==0){ }}
	<a class="layui-btn layui-btn-xs layui-btn-warm">无设置类别</a>
	{{#  } }}
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