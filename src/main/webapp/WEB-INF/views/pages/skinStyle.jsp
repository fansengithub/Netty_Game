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
<div class="main-content-inner">
	<div class="col-sm-12">
		<div class="col-xs-12">
			<div class="table-header">
				操作列表
			</div>
			<div>
				<div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
					<div class="row">
						<div class="col-xs-12">
							<div class="dataTables_length" id="dynamic-table_length"><label>
								展示
								<select id="pageSize" name="dynamic-table_length" aria-controls="dynamic-table" class="form-control input-sm">
									<option value="10">10</option>
									<option value="25">25</option>
									<option value="50">50</option>
									<option value="100">100</option>
								</select> 条记录 </label>
								<label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;类型
									<select id="search-type" name="dynamic-table_length" aria-controls="dynamic-table" class="form-control input-sm">
										<option value="">全部</option>
										<option value="1">部门</option>
										<option value="2">用户</option>
										<option value="3">权限模块</option>
										<option value="4">权限</option>
										<option value="5">角色</option>
										<option value="6">角色权限关系</option>
										<option value="7">角色用户关系</option>
									</select></label>

								<input id="search-operator" type="search" name="operator" class="form-control input-sm" placeholder="操作者" aria-controls="dynamic-table">
								<input id="search-before" type="search" name="beforeSeg" class="form-control input-sm" placeholder="操作前的值" aria-controls="dynamic-table">
								<input id="search-after" type="search" name="afterSeg" class="form-control input-sm" placeholder="操作后的值" aria-controls="dynamic-table">
								<input id="search-from"type="search" name="fromTime" class="form-control input-sm" placeholder="开始时间" aria-controls="dynamic-table"> ~
								<input id="search-to" type="search" name="toTime" class="form-control input-sm" placeholder="结束时间" aria-controls="dynamic-table">
								&nbsp;&nbsp;&nbsp;&nbsp;
								<button class="btn btn-info fa fa-check research" style="margin-bottom: 6px;" type="button">
									刷新
								</button>
							</div>
						</div>
						<table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
							   aria-describedby="dynamic-table_info" style="font-size:14px">
							<thead>
							<tr role="row">
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									序号
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									风格名称
								</th>
								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									描述
								</th>

								<th tabindex="0" aria-controls="dynamic-table" rowspan="1" colspan="1">
									操作
								</th>

							</tr>
							</thead>
							<tbody id="logList">
							<tr>
								<td>1</td>
								<td>风格1</td>
								<td>风格描述1</td>


								<td>
								<i class="glyphicon glyphicon-trash" title="删除" onclick="goDetail();"></i>
									<i class="glyphicon glyphicon-pencil" title="编辑" onclick="goDetail();"></i>

								</td>
							</tr>

							</tbody>
						</table>
						<div class="col-lg-12" style="margin-bottom: 1%;">
							<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
							<input type="hidden" name="id" value="${player.id}" />
							<input type="hidden" name="type" value="${type}" />
							<input type="hidden" name="playerid" value="${player.id}" />
							<div class="input-group pull-right">
								<div class="col-lg-4" style="margin-bottom: 1%;">
									<button type="submit" class="btn btn-block btn-info"  onclick="add();">新增</button>
								</div>
								<div class="col-lg-4" style="margin-bottom: 1%;">
									<button type="submit" class="btn btn-block btn-info" >提交</button>
								</div>
								<div class="col-lg-4" style="margin-bottom: 1%;">
									<button type="button" class="btn btn-block btn-info" onclick="javascript:window.history.back();">返回</button>
								</div>
							</div>
						</div>

						<div class="row" id="logPage">
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
        window.location.href="${pageContext.request.contextPath}/get/skinStyleDetail.page";
    }
    function add(){
        // var type = $('#type').val();
        alert("add")
        window.location.href="${pageContext.request.contextPath}/get/skinStyleDetail.page";
    }
</script>
</body>
</html>