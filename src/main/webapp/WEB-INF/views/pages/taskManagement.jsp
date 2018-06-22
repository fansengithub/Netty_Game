s<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
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
			作业管理
		</small>
	</h1>
</div>
<div class="main-content-inner">
	<div class="col-sm-12">
		<div class="col-xs-12">
			<div class="table-header">
				作业管理
			</div>
			<div>
				<div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
					<div class="row">
						<form action="${pageContext.request.contextPath}/get/taskManagement.page" method="post" id="form_send">

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
									状态
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									布置时间
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									要求完成时间
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									完成时间
								</th>

							</tr>
							</thead>
							<tbody id="logList">
							<c:forEach var="temp" items="${list}">

								<tr>
									<td>${temp.belontoPiano}</td>
									<td>${temp.teacherName}</td>
									<td>${temp.teacherName}</td>
									<td>${temp.parent}</td>
									<td>${temp.state}</td>
									<td><fmt:formatDate value="${temp.sendTime }" type="both"/></td>
									<td><fmt:formatDate value="${temp.wantFinishTime }" type="both"/></td>
									<td><fmt:formatDate value="${temp.finishTime }" type="both"/></td>


										<%--<td>--%>
										<%--<i class="fa fa-fw fa-edit" title="详细信息" onclick="goDetail();"></i>--%>
										<%--</td>--%>
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
    function goDetail(){
        // var type = $('#type').val();
		alert("www")
        window.location.href="${pageContext.request.contextPath}/get/getStudentListDetail.page";
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