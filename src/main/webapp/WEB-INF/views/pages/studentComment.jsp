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
		教务系统
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			学生点评
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="col-sm-12">
		<div class="col-xs-12">
			<div class="table-header">
				学生点评
			</div>
			<div>
				<div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
					<div class="row">
						<form action="${pageContext.request.contextPath}/get/studentComment.page" method="post" id="form_send">

							<div class="col-xs-12">
								<div class="dataTables_length" id="dynamic-table_length">


									<input id="search-operator" type="search" name="param" placeholder="请输入搜索条件"  class="form-control input-sm"  >

									&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="layui-btn layui-btn-normal" style="margin-bottom: 6px;" type="submit" >
										搜索
									</button>
								</div>
							</div>

						</form>
						<table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
							   aria-describedby="dynamic-table_info" style="font-size:14px">
							<thead>
							<tr role="row">
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									序号
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									琴行
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									老师
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									学生
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									家长
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									评语
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									星级
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									点评时间
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									操作
								</th>

							</tr>
							</thead>
							<tbody id="logList">
							<c:forEach var="temp" items="${list}">

								<tr>
									<td>${temp.id}</td>
									<td>${temp.pianoShop}</td>
									<td>${temp.teacher}</td>
									<td>${temp.student}</td>
									<td>${temp.parent}</td>
									<td>${temp.comment}</td>
									<td>${temp.startLevel}</td>
									<td><fmt:formatDate value="${temp.commentTime }" type="both"/></td>
									<td>
										<i class="glyphicon glyphicon-trash" title="删除" onclick="goDelete(${temp.id});"></i>
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
<script type="text/javascript">
    function goDelete(id){
        // var type = $('#type').val();
        <%--alert("${pageContext.request.user.id}");--%>
        layer.confirm('确定要删除该记录吗？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            window.location.href="${pageContext.request.contextPath}/get/deleteCommentFromStu.page?id="+id;
        }, function(){
            layer.msg('取消成功');
        });
        <%--alert("www");--%>
        <%--alert("${user.username}");--%>
        <%--alert("${user.id}");--%>

        <%--window.location.href="${pageContext.request.contextPath}/get/deleteCommentFromStu.page?id="+id;--%>
    }
</script>
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
</script>
</body>
</html>