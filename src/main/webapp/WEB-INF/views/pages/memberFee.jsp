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
        参数设置
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            会费设置
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                会费设置
            </div>

                <div id="dialog-user-form" >
                    <form id="userForm" action="${pageContext.request.contextPath}/parameterSet/update.page" method="post">
                        <table class="table table-striped table-bordered table-hover dataTable no-footer" role="grid">
                            <tr>
                                <td><label for="userName">旗舰店</label></td>
                                <input type="hidden" name="id" id="userId"/>
                                <td><input type="text" name="content1" id="userName" value="${parameterSet1.content}" class="text ui-widget-content ui-corner-all" placeholder="旗舰店"></td>
                                <td>熊掌</td>
                            </tr>
                            <tr>
                                <td><label for="userName">机构</label></td>
                                <input type="hidden" name="id" />
                                <td><input type="text" name="content2"  value="${parameterSet2.content}" class="text ui-widget-content ui-corner-all" placeholder="机构"></td>
                                <td>熊掌</td>
                            </tr>

                            <tr>
                                <td><label for="userName">琴行</label></td>
                                <input type="hidden" name="id" />
                                <td><input type="text" name="content3" value="${parameterSet3.content}" class="text ui-widget-content ui-corner-all" placeholder="琴行"></td>
                                <td>熊掌</td>
                            </tr><tr>
                                <td><label for="userName">会员试用时间</label></td>
                                <input type="hidden" name="id" />
                                <td><input type="text" name="content4" value="${parameterSet4.content}" class="text ui-widget-content ui-corner-all" placeholder="会员试用时间"></td>
                            <td>天</td>
                            </tr><tr>
                                <td><label for="userName">会费缴纳周期</label></td>
                                <input type="hidden" name="id" />
                                <td><input type="text" name="content5" value="${parameterSet5.content}" class="text ui-widget-content ui-corner-all" placeholder="会费缴纳周期"></td>
                            <td>月</td>
                            </tr><tr>
                                <td><label for="userName">逾期可提现金额扣除,每个月</label></td>
                                <input type="hidden" name="id" />
                                <td><input type="text" name="content6" value="${parameterSet6.content}" class="text ui-widget-content ui-corner-all" placeholder="逾期可提现金额扣除"></td>
                                <td>%</td>
                            </tr>


                        </table>
                        <div class="col-lg-12" style="margin-bottom: 1%;">
                            <%--<input type="hidden" name="playerid" value="${player.id}" />--%>
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