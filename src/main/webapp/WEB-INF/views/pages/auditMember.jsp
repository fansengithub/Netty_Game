<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            待审核会员
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="demoTable">
        搜索：
        <div class="layui-inline">
            <input class="layui-input" name="keyword" id="param" placeholder="id,名称" autocomplete="off">
        </div>
        <div class="layui-inline">
            <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提现开始时间</label>

            <div class="layui-input-inline">
                <input class="layui-input" name="startTime" id="startTime" placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>

        <div class="layui-inline">
            <label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;提现结束时间</label>

            <div class="layui-input-inline">
                <input class="layui-input" name="endTime" id="endTime" placeholder="yyyy-MM-dd HH:mm:ss">
            </div>
        </div>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="layui-btn layui-btn-normal" data-type="reload">搜索</button>
        <table id="operas" lay-filter="operas"></table>
    </div>
</div>
<script>
    layui.use('table', function () {
        var table = layui.table;
        var laydate = layui.laydate;
        var $ = layui.$;
        //第一个实例
        table.render({
            elem: '#operas'
            , id: 'opera'
            , cellMinWidth: 100
            , url: '${pageContext.request.contextPath}/pianoScope/getPianoScopeState1' //数据接口
            , page: true //开启分页
            , cols: [[ //表头
                {field: 'id', title: '琴行ID', width: 100, sort: true}
                , {field: 'name', title: '琴行名', width: 100}
                , {field: 'contacts', title: '联系人', width: 100}
                , {field: 'telephone', title: '手机号', width: 100}
                , {field: 'area', title: '区域', width: 100}
                , {field: 'address', title: '详细地址', width: 100}
                , {field: 'bossTelephone', title: '法人电话', width: 100}
                , {field: 'legalName', title: '法人姓名', width: 100}
                , {
                    field: 'idcardPicture',
                    title: '身份证图片',
                    width: 100,
                    style: "height:80px;",
                    templet: '<div><img style="width: 100px;height: 80px" src="{{d.idcardPicture}}"></div>'
                }
                , {
                    field: 'businessLicensePicture',
                    title: '营业执照',
                    width: 100,
                    style: "height:80px;",
                    templet: '<div><img style="width: 100px;height: 80px" src="{{d.businessLicensePicture}}"></div>'
                }
                , {field: 'state', title: '状态', width: 100, templet: "#state"}
                , {field: 'right', title: '操作', width: 200, toolbar: "#operasedt"}
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
                var param = $('#param'); //搜索条件
                var startTime = $('#startTime'); //搜索条件
                var endTime = $('#endTime'); //搜索条件
                table.reload('opera', {
                    where: {
                        keyword: param.val(),
                        startTime: startTime.val(),
                        endTime: endTime.val()
                    }
                });
            }
        }
        //日期时间选择器
        laydate.render({
            elem: '#startTime'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#endTime'
            , type: 'datetime'
        });
        //监听工具条
        table.on('tool(operas)', function (obj) {
            var data = obj.data;
            if (obj.event === 'detail') {
                layer.msg('ID：' + data.id + ' 的查看操作');
            } else if (obj.event === 'del') {
                layer.confirm('执行”不通过“', function (index) {
                    console.log(data.id) //获取id
                    $.ajax({
                        url: '${pageContext.request.contextPath}/pianoScope/updatestate2.page?id=' + data.id,
                        success: function (result) {
                            console.log(result)
                            if (result.code == 0) {
                                table.reload('opera'); //重新加载表格数据
                            }
                            layer.msg(result.msg);
                        }
                    })
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                layer.confirm('执行”通过审核“', function (index) {
                    console.log(data.id) //获取id
                    $.ajax({
                        url: '${pageContext.request.contextPath}/pianoScope/updatestate0?id=' + data.id,
                        success: function (result) {
                            console.log(result)
                            if (result.code == 0) {
                                table.reload('opera'); //重新加载表格数据
                            }
                            layer.msg(result.msg);
                        }
                    })
                    layer.close(index);
                });
            }
        });
    });

</script>

<%--数据操作按钮--%>

<script type="text/html" id="operasedt">
    <a class="layui-btn layui-btn-sm layui-btn-normal" lay-event="edit">通过审核</a>
    <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">不通过</a>
</script>

<script type="text/html" id="state">
    {{#  if(d.state ==1){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-green">审核中</a>
    {{#  } }}
    {{#  if(d.state ==2){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm layui-bg-red">未通过</a>
    {{#  } }}
</script>
</body>
</html>