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
        充值
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            充值管理
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                配置充值熊掌和人民币套餐
            </div>
            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <div class="row">
                        <div class="row">
                            <div class="col-lg-10">
                                <form action="${pageContext.request.contextPath}/get/getRechargeDetail.page" method="post" id="form_send">

                                    <div class="col-xs-12">
                                        <div class="dataTables_length" id="dynamic-table_length">


                                            <input id="search-operator" type="search" name="param" placeholder="请输入搜索条件"  class="form-control input-sm"  >

                                            &nbsp;&nbsp;&nbsp;&nbsp;
                                            &nbsp;&nbsp;&nbsp;&nbsp;

                                            <button class="layui-btn layui-btn-normal" style="margin-bottom: 6px;" type="submit" >
                                                搜索
                                            </button>
                                        </div>
                                    </div>

                                </form>

                            </div>

                            <div class="col-lg-2">
                                <button id="addOne" class="layui-btn layui-btn-normal" style="margin-bottom: 6px;" type="submit" >
                                    新增
                                </button>
                            </div>


                        </div>


                        <table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                               aria-describedby="dynamic-table_info" style="font-size:14px">
                            <thead>
                            <tr role="row">
                                <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                    ID
                                </th>
                                <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                    充值熊掌
                                </th>
                                <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                    充值人民币
                                </th>

                                <th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
                                    操作
                                </th>

                            </tr>
                            </thead>
                            <tbody id="logList">
                            <c:forEach var="temp" items="${list}">
                                <tr>
                                    <td >${temp.id}</td>
                                    <td width="30%">${temp.rechargeObject}</td>
                                    <td width="30%">${temp.rechargeMonry}</td>
                                    <td>
                                        <button class="layui-btn layui-btn-normal" onclick="goDelete(${temp.id});">删除</button>
                                        <%--<button class="layui-btn layui-btn-normal">修改</button>--%>
                                    </td>


                                </tr>
                            </c:forEach>


                            </tbody>
                        </table>
                        <div class="row"  >
                            <div class="col-xs-6"></div>
                            <div class="col-xs-6"  id="logPage"></div>

                        </div>
                    </div>
                </div>
            </div>



        </div>
    </div>
</div>
<script>
    //分页
    layui.use('laypage', function() {
        var laypage = layui.laypage;  //加载分页组件
        // 分页
        laypage.render({
            elem: 'logPage'  //绑定的id
            ,count: ${pageInfo.total}   //数据总数，从服务端得到
            ,theme: '#1E9FFF'  //样式
            ,curr: ${pageInfo.pageNum}
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']  //开放所有功能
            ,jump: function(obj,first){  //跳转  //obj包含了当前分页的所有参数
                console.log(obj)
                if(!first){
                    window.location.href="${pageContext.request.contextPath}/get/getPianoScope.page?curr="+obj.curr+"&limit="+obj.limit;
                }
            }
        });
    });

    //弹出一个页面层
    $('#addOne').on('click', function(){
        layer.open({
            type: 1,
            area: ['600px', '360px'],
            shadeClose: true, //点击遮罩关闭
            content: '        <form action="${pageContext.request.contextPath}/get/addRecharge.page" method="post">\n' +
            '                        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">\n' +
            '                            <tr>\n' +
            '                                <td><label for="object">熊掌数:</label></td>\n' +
            '                                <td><input type="text" name="object" id="object" value="" class="text ui-widget-content ui-corner-all"></td>\n' +
            '\n' +
            '                                <td><label for="money">人民币数:</label></td>\n' +
            '                                <td><input type="text" name="money" id="money" value="" class="text ui-widget-content ui-corner-all"></td>\n' +
            '                            </tr>\n' +
            '\n' +
            '                        </table>\n' +
            '                        <div class="col-lg-12" style="margin-bottom: 1%;">\n' +

            '                            <div class="input-group pull-right">\n' +
            '                                <div class="col-lg-6" style="margin-bottom: 1%;">\n' +
            '                                    <button type="submit" class="btn btn-block btn-info" >提交</button>\n' +
            '                                </div>\n' +
            '                                <div class="col-lg-6" style="margin-bottom: 1%;">\n' +
            '                                    <button type="button" class="btn btn-block btn-info" onclick="javascript:window.history.back();">返回</button>\n' +
            '                                </div>\n' +
            '                            </div>\n' +
            '                        </div>\n' +
            '\n' +
            '                    </form>'
        });
    });
</script>
<script type="text/javascript">
    function goDelete(id){
        // var type = $('#type').val();
        alert("www")
        window.location.href="${pageContext.request.contextPath}/get/deleteRecharge.page?id="+id;
    }
</script>
</body>
</html>