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
		权限操作记录
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			管理权限相关模块更新历史
		</small>
	</h1>
</div>
	<!-- Content Header (Page header) -->


	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-6">
				<div class="dataTables_wrapper form-inline no-footer">

					<table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
						   aria-describedby="dynamic-table_info" style="font-size:14px">
						<div class="box-body">
							<div class="form-group">
								<label for="typeName"  class="col-sm-2 control-label">消息标题</label>
								<input  class="col-sm-10" id="titel" name="title" value="${an.title }" required="required">
							</div>
							<div class="form-group">
								<label for="typeName">消息内容</label>
								<textarea class="form-control" id="message" name="content"  style="height: 200px" required="required" >${an.content }</textarea>
							</div>
							<div class="form-group">
								<label for="typeName">消息状态</label>
								<select class="form-control" name="state" id="type">
									<option value="10">普通</option>
									<option value="11">置顶</option>
								</select>
								<script>type.value=${an.state}</script>
							</div>
						</div>
						<div class="box-footer">
							<input type="hidden" name="id" value="${an.id}" />
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<button type="submit" class="btn btn-primary" >提交</button>
							<button type="button" class="btn" style="margin-left: 5%;" onclick="javascript:window.history.back();">返回</button>
						</div>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!-- /.content -->

<script type="text/javascript">
    function goDetail(){
        // var type = $('#type').val();
		alert("www")
        window.location.href="${pageContext.request.contextPath}/get/auditMemberDetail.page";
    }
</script>
</body>
</html>