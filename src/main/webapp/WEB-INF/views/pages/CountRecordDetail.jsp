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
		积分记录管理
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			积分获取记录
		</small>
	</h1>
</div>
<div class="main-content-inner">
    <div class="demoTable">
        搜索：
        <div class="layui-inline">
            <input class="layui-input" name="keyword" id="serachlearnbook" placeholder="输入用户昵称" autocomplete="off">
        </div>

        <div class="layui-inline">
            <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获得积分开始时间</label>

            <div class="layui-input-inline">
                <input  class="layui-input" name="startTime" id="startTime" placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>

        <div class="layui-inline">
            <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;获得积分结束时间</label>

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
            ,url: '${pageContext.request.contextPath}/userScore/selAllCountRecord.page' //数据接口
            ,page: true //开启分页
            ,cols: [[ //表头
                {field: 'id', title: '记录序号', width:200, sort: true}
                ,{field: 'userId', title: '用户id', width:200, sort: true}
                ,{field: 'userAccount', title: '用户账号', width:200}
                ,{field: 'userRole', title: '角色', width:200}
                ,{field: 'userNick', title: '用户昵称', width:200}
                ,{field: 'pianoShop', title: '所属琴行', width:200}
                ,{field: 'teacher', title: '所属老师', width:200}
                ,{field: 'countTime', title: '练习时间', width:200}
                ,{field: 'counterSpeed', title: '练习速度', width:200}
                ,{field: 'counterCount', title: '打击数', width:200}
                ,{field: 'recordTime', title: '获得积分时间', width: 180,sort: true,templet:"<div>{{layui.util.toDateString(d.recordTime, 'yyyy-MM-dd HH:mm:ss')}}</div>"}
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
                var startTime = $('#startTime'); //搜索条件
                var endTime = $('#endTime'); //搜索条件
                table.reload('learntable', {
                    where: {
                        keyword: serachlearnbook.val(),
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
                window.location.href="${pageContext.request.contextPath}/withdrawDetail/update.page?id="+data.id+"&stage="+data.stage;
            }
        });
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
    });

</script>
<%--数据操作按钮--%>
<script type="text/html" id="learnbookedt">
    <%--{{#  if(d.stage ==0){ }}--%>
    <%--<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">改变状态</a>--%>
    <%--{{#  } }}--%>
    {{#  if(d.stage ==0){ }}
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">改变状态</a>
    {{#  } }}

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

<%--提现状态--%>
<script type="text/html" id="info">

    {{#  if(d.info ==1){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">每日登陆</a>
    {{#  } }}
    {{#  if(d.info ==2){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">游戏通关</a>
    {{#  } }}
    {{#  if(d.info ==3){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">基础练习</a>
    {{#  } }}
    {{#  if(d.info ==4){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">分享</a>
    {{#  } }}
    {{#  if(d.info ==5){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">购买曲谱</a>
    {{#  } }}
</script>

</body>
</html>