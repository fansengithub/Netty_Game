<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <style>
        .laytable-cell-1-coverPicture { /*最后的pic为字段的field*/
            height: 100%;
            max-width: 100%;
        }
    </style>
</head>

<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        教材管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            教材列表
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="demoTable">
        搜索教材：
        <div class="layui-inline">
            <input class="layui-input" name="keyword" id="serachlearnbook" placeholder="输入教材名称或ID" autocomplete="off">
        </div>
        <button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>

        <button class="layui-btn layui-btn-normal" data-type="add" onclick="addlearn()">新增教材</button>
    </div>
    <table id="learnbooks" lay-filter="learnbooks"></table>
</div>


<div class="layui-row" id="info" style="display: none;">
    <div class="layui-col-md10">
        <form class="layui-form" id="addEmployeeForm">
            <div class="layui-form-item">
                <label class="layui-form-label" style="width: 100px;">曲谱信息:</label>
                <div class="layui-input-block">
                    <select class="layui-input" name="deptId" id="info1" lay-filter="aihao">

                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block" style="text-align: center;">
                    <button class="layui-btn" lay-submit="" lay-filter="bangdings">立即提交</button>
                </div>
            </div>
        </form>
    </div>

<script>
    layui.use(['table', 'form',"layer"], function () {
        var table = layui.table;
        var form = layui.form;
        var layer=layui.layer;
        form.render();
        //第一个实例
        table.render({
            elem: '#learnbooks'
            , id: 'learntable'
            , cellMinWidth: 100
            , url: '${pageContext.request.contextPath}/learnbook/selAll.page' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true}
                , {field: 'name', title: '教材名', width: 200, sort: true}
                , {field: 'summary', title: '简介', width: 200}
                , {field: 'author', title: '作者', width: 100}
                , {
                    field: 'coverPicture',
                    title: '封面图片',
                    width: 150,
                    style: "height:80px;",
                    templet: '<div><img style="width: 100px;height: 80px" src="{{d.coverPicture}}"></div>'
                }
                , {field: 'opernNum', title: '曲谱数', width: 100, templet: '#opernNum'}
                , {field: 'right', title: '操作', width: 200, toolbar: "#learnbookedt"}
            ]]
            , request: {
                pageName: 'page' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            , done: function (res, page, count) {
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
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            console.log("type" + type)
            active[type] ? active[type].call(this) : '';
        });
        //监听工具条
        table.on('tool(learnbooks)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                $.ajax({
                    url: '${pageContext.request.contextPath}/learnbook/getNoLearnOpera.page',
                    success: function (datas) {
                        console.log(datas.length)

                        var Str = "";
                        // alert(bb.length);
                        if (datas.length == 0) {
                            layer.msg('无可用的曲谱绑定', {icon: 5});
                            return;
                        }
                        $("#info1").empty();
                       /* //bb是一个js数组，遍历
                        $("#info1").empty();   //清空该元素的子元素

                        for (var i = 0; i < datas.length; i++) {
                            Str = Str + "<option value='" + datas[i].id + "'>曲谱id：" + datas[i].id + "&nbsp;&nbsp;&nbsp;&nbsp;曲谱名称：" + datas[i].operaName + "</option>"
                        }
                        alert(Str);
                        $("#info1").append(Str)*/
                        $.each(datas,function(index,data){
                            var deptOption=$("<option value='"+data.id+"'>曲谱id:"+data.id+"&nbsp;&nbsp;曲谱名称:"+data.operaName+"</option>");
                            $("#info1").append(deptOption);
                        });

                        layer.open({
                            type: 1,
                            area: ['600px', '450px'],
                            title:"添加曲谱",
                            fixed: false, //不固定
                            maxmin: true,
                            content: "<input type='hidden' name='learnbook1' id='learnbook1' value='" + data.id + "'/><P style='font-size: 24px;margin: 40px 140px'>教材名：" + data.name + "</p>" + $("#info").html()
                            <%--content: '${pageContext.request.contextPath}/get/addLearnBook.page'--%>
                        });
                        form.render();
                        // layer.msg('ID：' + data.id + ' 的查看操作');
                    }
                })

            } else if (obj.event === 'del') {
                layer.confirm('确定要删除吗?', function (index) {
                    console.log(data.id) //获取id
                    $.ajax({
                        url: '${pageContext.request.contextPath}/learnbook/dellearnbook.page?lid=' + data.id,
                        success: function (result) {
                            console.log(result)
                            if (result.code == 0) {
                                // obj.del();
                                table.reload('learntable'); //重新加载表格数据
                            } else {
                                layer.msg(result.msg);
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                window.location.href = "${pageContext.request.contextPath}/learnbook/sel.page?lid=" + data.id;
            }
        });
        form.on('submit(bangdings)', function (data) {
            console.log("learnbook1" + data.field.deptId)
            console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
            console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
            console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}
            var learnbook1 = $("#learnbook1").val();
            var info1 = data.field.deptId;
            console.log("learnbook1" + learnbook1 + "ss" + info1)
            $.ajax({
                url: '${pageContext.request.contextPath}/learnbook/bangding.page?learnbook1=' + learnbook1 + '&searce1=' + info1,
                success: function (data) {
                    console.log("绑定成功" + data)
                    // alert("11111");
                    if (data > 0) {
                        layer.msg("绑定成功");
                    } else {
                        alert("2adfdsfsd");
                    }
                }
            })

        });
        form.on('select(aihao)', function(data){
            // console.log(data.elem); //得到select原始DOM对象
            console.log(data.value); //得到被选中的值
            // console.log(data.othis); //得到美化后的DOM对象
        });
    });

    function show() {
        alert("aaaa")
    }
</script>
<%--数据操作按钮--%>
<script type="text/html" id="learnbookedt">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">添加曲谱</a>
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/javascript">
    function addlearn() {
        window.location.href = "${pageContext.request.contextPath}/get/addLearnBook.page";
    }

    function goDetail() {
        // var type = $('#type').val();
        alert("www")
        window.location.href = "${pageContext.request.contextPath}/get/getOrginazDetail.page";
    }

    function add() {
        // var type = $('#type').val();
        alert("add")
        window.location.href = "${pageContext.request.contextPath}/get/addLearnBook.page";
    }
</script>
</body>
</html>