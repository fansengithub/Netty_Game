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
                用户详情
            </div>
            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <div class="row">
                        <form action="${pageContext.request.contextPath}/PlayerController/modifyPlayer" method="post">
                        <table id="dynamic-table" class="table table-striped table-bordered table-hover dataTable no-footer" role="grid"
                               aria-describedby="dynamic-table_info" style="font-size:14px">

                            <tr class="border">
                                <td colspan="2" rowspan="2" ><img class="img-responsive" src="${player.headurl }" alt=" picture"></td>
                                <td align="center">琴行名：电鼓</td>
                                <td align="center">联系人：小黑</td>
                                <td align="center">手机号：123456</td>
                                <td align="center">总创建老师数：10</td>
                            </tr>
                            <tr class="border">
                                <td align="center">状态：正常</td>
                                <td align="center">现有老师数：12</td>
                                <td align="center">在校学生数: 22</td>
                                <td align="center">曲谱数：10</td>
                            </tr>
                            <tr class="border">
                                <td colspan="3"  >法人电话:123456789</td>
                                <td align="center">消费金额：12</td>
                                <td align="center">注册时间: 2017-12-12</td>
                                <td align="center">会员时间：2018-12-12</td>
                            </tr>
                            <tr class="border">
                                <td colspan="3"  >区域:上海浦东区</td>
                                <td colspan="3" >区域:上海浦东区</td>
                            </tr>
                            <tr class="border">
                                <td colspan="2">密码重置：</td>
                                <td align="center">充值：12</td>
                                <td align="center">分红总收入: 1022</td>
                                <td align="center">审核人：10</td>
                                <td align="center">审核时间:2017-12-12</td>

                            </tr>

                            <tr class="border">
                                <td  colspan="2 >机构规模:89</td>
                                <td align="center">琴行类别：</td>
                                <td align="center">琴行分成比: 25%</td>
                                <td colspan="2">最后登录时间：2018-12-12</td>
                            </tr>

                            <tr class="border">
                                <td  colspan="2" >可提现余额:89</td>
                                <td colspan="2">推广分成比：</td>
                                <td colspan="2">所属机构:</td>

                            </tr>

                            <tr class="border">
                                <td colspan="3" rowspan="3" ><img class="img-responsive" src="${player.headurl }" alt="User profile picture">身份证图片</td>
                                <td colspan="3" rowspan="3" ><img class="img-responsive" src="${player.headurl }" alt="User profile picture">营业执照图片</td>

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
                        <div class="row" id="logPage">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>