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
                添加老师
            </div>

                <div id="dialog-user-form" >
                    <form id="userForm">
                        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                            <tr>
                                <td><label for="userName">栏目分类名称</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>

                                <td><label for="userName">选择教材</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>
                            </tr>
                            <tr>
                                <td><label for="userName">选择曲谱</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>

                                <td><label for="userName">栏目类型</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>
                            </tr>
                            <tr>
                                <td><label for="userName">创建人</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>

                                <td><label for="userName">链接</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>
                            </tr>
                            <tr>
                                <td><label for="userName">输入标题</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>

                                <td><label for="userName">封面图片</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="username" id="userName" value="" class="text ui-widget-content ui-corner-all"></td>
                            </tr>

                            <tr>
                                <td><label for="userRemark">输入文本内容</label></td>
                                <td><textarea name="remark" id="userRemark" class="text ui-widget-content ui-corner-all" rows="3" cols="50" placeholder="输入文本内容"></textarea></td>
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