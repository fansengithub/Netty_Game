<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        教材管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            风格详情
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                风格详情
            </div>
            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <div class="row">

                        <form action="${pageContext.request.contextPath}/textStyle/modifyTextStyle" method="post">
                            <div class="box-body">
                                <div class="form-group">
                                    <label>风格名称：</label>
                                    <input class="form-control" name="style" value='${learnbookStyle.style }' required="required">
                                </div>


                                <div id="progress"></div>
                                <div class="box-footer">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <input type="hidden" name="id" value="${learnbookStyle.id }" />
                                    <button type="submit" class="btn btn-primary" >提交</button>
                                    <button type="button" class="btn" style="margin-left: 5%;" onclick="javascript:window.history.back();">返回</button>
                                </div>
                            </div>
                        </form>


                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>