<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
    <style>
        [name=priceUsed]{
            width: 300px;
        }
        [name=lastname2]{
            width: 218px;
        }
    </style>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        曲谱管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            曲谱详情
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                曲谱详情
            </div>
            <div>
                <div id="dynamic-table_wrapper" class="dataTables_wrapper form-inline no-footer">
                    <div class="row">
                        <form action="${pageContext.request.contextPath}/opera/updateOpera.page" method="post">
                            <table id="dynamic-table"
                                   class="table table-striped table-bordered table-hover dataTable no-footer"
                                   role="grid"
                                   aria-describedby="dynamic-table_info" style="font-size:14px">

                                <tr class="border">
                                    <td align="center">
                                        <label>教材名称</label>
                                        <input type="hidden" value="${opera.learnbookId}" name="learnbookId"
                                               id="learnbookId">
                                        <input type="hidden" name="learnbookName" id="name">
                                        <select name="" id="learnbookName" onchange="getlearn()">
                                            <option value="0"></option>
                                            <script type="text/javascript">
                                                learnbookName.value = "${opera.learnbookName}";
                                            </script>
                                        </select>
                                    </td>
                                    <td align="center">风格：${opera.style}</td>
                                    <td align="center">适用阶段：${opera.applyStage}</td>
                                </tr>
                                <tr class="border">
                                    <td align="center">曲谱名称：${opera.operaName}</td>
                                    <td align="center">作者：${opera.author}</td>
                                    <td align="center">是否获得积分:
                                        <c:if test="${opera.isGetScore==0}">是</c:if>
                                        <c:if test="${opera.isGetScore==1}">否</c:if>
                                    </td>

                                </tr>
                                <tr class="border">
                                    <td align="center">
                                        <label>是否公开</label>
                                        <select name="isOpen" id="isOpen">
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                            <script type="text/javascript">
                                                isOpen.value = "${opera.isOpen}";
                                            </script>
                                        </select>
                                    </td>
                                    <td align="center">下载次数：${opera.downlaodAmount}</td>
                                    <td align="center">创建时间: <fmt:formatDate value="${opera.createTime }"
                                                                             type="both"/></td>
                                </tr>
                                <tr class="border">
                                    <td align="center">出售次数:${opera.saledAmount}</td>
                                    <td align="center">收入:${opera.income}</td>
                                    <td align="center">
                                        <label>是否启用</label>
                                        <select name="isUsed" id="isUsed">
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                            <script type="text/javascript">
                                                isUsed.value = "${opera.isUsed}";
                                            </script>
                                        </select>
                                    </td>
                                </tr>
                                <tr class="border">
                                    <td align="center">讲解价格：${opera.explainPrice}
                                        <label>是否启用</label>
                                        <select name="priceUsed" id="priceUsed">
                                            <option value="0">是</option>
                                            <option value="1">否</option>
                                            <script type="text/javascript">
                                                priceUsed.value = "${opera.priceUsed}";
                                            </script>
                                        </select>
                                    </td>
                                    <td align="center">难度：${opera.difficulty}</td>
                                    <td align="center">
                                        封面图片：
                                        <img class="img-responsive" style="width: 100px;height: 100px"
                                             src="${opera.coverPicture}" alt="User profile picture">
                                    </td>
                                </tr>
                                <tr class="border">
                                    <td align="center" width="550px">曲谱使用权限：&nbsp;&nbsp;&nbsp;&nbsp;
                                        <input type="checkbox" name="vehicle" value="Car" id="vehicle">全部琴行 <br>
                                        <div id="fendian">
                                            <label>选择琴行</label>
                                            <select name="priceUsed" id="myselect">
                                                <c:forEach var="stu" items="${pianoShopList}">
                                                    <option value="${stu.id}">曲谱id:${stu.id}&nbsp;&nbsp;&nbsp;&nbsp;曲谱名称:(${stu.name})</option>
                                                </c:forEach>
                                            </select><br>
                                        </div>
                                    </td>

                                </tr>
                            </table>

                            <div class="col-lg-12" style="margin-bottom: 1%;">
                                <input type="hidden" name="id" value="${opera.id}"/>
                                <div class="input-group pull-right">
                                    <div class="col-lg-6" style="margin-bottom: 1%;">
                                        <button type="submit" class="btn btn-block btn-info">提交</button>
                                    </div>
                                    <div class="col-lg-6" style="margin-bottom: 1%;">
                                        <button type="button" class="btn btn-block btn-info"
                                                onclick="javascript:window.history.back();">返回
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    function dele(val){
        console.log(val.getAttribute("class"))
        val.parentNode.removeChild(val.parentNode.childNodes[0]);
        val.parentNode.removeChild(val.parentNode.childNodes[0]);
        val.parentNode.removeChild(val.parentNode.childNodes[0]);
    }
    $("#vehicle").click(function () {
        if (this.checked) {
            $("#fendian").hide();
        } else {
            $("#fendian").show();
        }
    });
    // $(".aaa").click(function (i) {
    //         alert("sss");
    // });
    // $.each($(".aaa"),function (i,val) {
    //
    //     $(this).click(function () {
    //         console.log(val.getAttribute("class"))
    //         val.parentNode.removeChild(val.parentNode.childNodes[0]);
    //         val.parentNode.removeChild(val.parentNode.childNodes[0]);
    //     });
    // });
    $("#myselect").change(function(){
        var opt=$("#myselect").val();
        var opt2=$("#myselect").find("option:selected").text();;
        console.log(opt);
        console.log(opt2);
        $("#fendian").append('<p><input type="hidden" name="lastname" value="'+opt+'"><input type="text" name="lastname2" value="'+opt2+'"><a class="aaa" onclick="dele(this)">删除</a></p>');
    });
    function getlearn() {
        var name = $('#learnbookName option:selected').text();
        console.log(name)
        var value = $("#learnbookName").val();
        $("#learnbookId").val(value);
        $("#name").val(name);
    }

    $(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/opera/getLearn.page",
            success: function (result) {
                var fieldList = result.data;
                if (fieldList != null && fieldList.length > 0) {
                    for (var i = 0; i < fieldList.length; i++) {
                        $("<option value='" + fieldList[i].id + "'>" + fieldList[i].name + "</option>").appendTo("#learnbookName");
                    }
                }
            },
        })
    })
</script>
</body>
</html>