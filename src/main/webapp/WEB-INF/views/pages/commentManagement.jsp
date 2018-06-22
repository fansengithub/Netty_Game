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
        教务系统
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            评语管理
        </small>
    </h1>
</div>
<button id="addOne" class="layui-btn layui-btn-normal" style="margin-bottom: 6px;" type="submit">
    新增
</button>
</div>
<table id="comments" lay-filter="comments"></table>
<script>
    layui.use('table', function () {
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#comments'
            , id: 'comment'
            , cellMinWidth: 100
            , url: '${pageContext.request.contextPath}/get/commentList.page' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: 'ID', width: 80, sort: true, fixed: 'left'}
                , {field: 'content', title: '评语', width: 300}
                , {field: 'right', title: '操作', width: 200, toolbar: "#commentedt"}
            ]]
            , request: {
                pageName: 'page' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            }
            , done: function (res, page, count) {
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
        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            console.log("type" + type)
            active[type] ? active[type].call(this) : '';
        });

        //监听工具条
        table.on('tool(comments)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');

            } else if (obj.event === 'del') {
                layer.confirm('真的删除行么', function (index) {
                    console.log(data.id) //获取id
                    $.ajax({
                        url: '${pageContext.request.contextPath}/get/delComment.page?cid=' + data.id,
                        success: function (result) {
                            console.log(result)
                            if (result.code == 0) {
                                table.reload('comment'); //重新加载表格数据
                            } else {
                                layer.msg("删除失败！");
                            }
                        }
                    })
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.open({
                    type: 2,
                    area: ['400px', '400px'],
                    fixed: false, //不固定
                    maxmin: true,
                    content: '${pageContext.request.contextPath}/common/edtComment.jsp',
                    success: function (layero, index) {
                        $.ajax({
                            url: '${pageContext.request.contextPath}/get/selectOneComment.page?cid=' + data.id,
                            success: function (datas) {
                                console.log(datas)
                                var jquerySendHelloButton1 = $("#id", layero.find("iframe")[0].contentWindow.document);
                                jquerySendHelloButton1.attr("value", datas.id);
                                var jquerySendHelloButton = $("#content", layero.find("iframe")[0].contentWindow.document);
                                jquerySendHelloButton.attr("value", datas.content);
                            }
                        });

                    },
                    end: function () {
                        table.reload('comment'); //重新加载表格数据
                    }
                });
                <%--window.location.href="${pageContext.request.contextPath}/get/selectByKey.page?id="+data.id;--%>
                <%--layer.msg('ID：'+ data.id + ' 的编辑操作');--%>
            }
        });

        //弹出一个页面层
        $('#addOne').on('click', function () {
            //iframe层-父子操作
            layer.open({
                type: 2,
                area: ['400px', '400px'],
                fixed: false, //不固定
                maxmin: true,
                content: '${pageContext.request.contextPath}/common/edtComment.jsp',
                success: function (layero, index) {
                    console.log(layero)
                },
                end: function () {
                    table.reload('comment'); //重新加载表格数据
                }
            });
        });
    });
</script>

<%--数据操作按钮--%>
<script type="text/html" id="commentedt">
    <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
</script>

<script>
</script>
</body>
</html>