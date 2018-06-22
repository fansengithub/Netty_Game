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
                添加银行卡
            </div>

                <div id="dialog-user-form" >
                    <form id="userForm">
                        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                            <tr>
                                <td><label for="userName">序号</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all" placeholder="序号"></td>


                            </tr>
                            <tr>
                                <td><label for="userName">输入类型名称</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all" placeholder="请输入类型名称"></td>


                            </tr>


                        </table>
                        <div class="col-lg-12" style="margin-bottom: 1%;">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            <input type="hidden" name="id" value="${player.id}" />
                            <input type="hidden" name="type" value="${type}" />
                            <input type="hidden" name="playerid" value="${player.id}" />
                            <div class="input-group pull-right">
                                <div class="col-lg-6" style="margin-bottom: 1%;">
                                    <button type="submit" class="btn btn-block btn-info" >提交</button>
                                </div>
                                <div class="col-lg-6" style="margin-bottom: 1%;">
                                    <button type="button" class="btn btn-block btn-info" onclick="javascript:window.history.back();">返回</button>
                                </div>
                            </div>
                        </div>

                    </form>
                </div>

        </div>
    </div>
</div>
</body>
</html>