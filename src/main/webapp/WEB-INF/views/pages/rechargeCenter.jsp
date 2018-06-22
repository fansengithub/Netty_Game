<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body style="background: white">
<div class="layui-container">
    <blockquote class="layui-elem-quote">充值中心</blockquote>

    <form class="layui-form" action="" id="myFrom">

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">充值熊掌：</label>
            <div class="layui-input-block">
                <c:forEach var="stu" items="${rechargePackageList}">
                <input type="radio" lay-filter="aaa" name="sex" value="${stu.rechargeMonry}" title="${stu.rechargeObject}">
                </c:forEach>
            </div>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">充值方式：</label>
            <div class="layui-input-block">
                <input type="radio" name="type" value="1" title="微信" checked>
                <input type="radio" name="type" value="2" title="支付宝">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label" style="width: 200px">应付金额：</label>
            <div class="layui-input-inline">
                <input type="text" name="money" id="money" required lay-verify="required" placeholder="" readonly
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['upload', 'form', 'layer'], function () {
        var form = layui.form, layedit = layui.layedit;
        var layer = layui.layer;
        var $ = layui.jquery;
        form.render();
        form.on('submit(formDemo)', function (data) {
            var type=data.field.type;
            console.log(type);
            if (type==1){
                $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/pay/WxpayPCNetPage.page');
            } else {
                $('form[id=myFrom]').attr('action', '${pageContext.request.contextPath}/pay/AlipayPCNetPage.page');
            }
        });
        form.on('radio(aaa)', function (data) {
            console.log(data.value); //被点击的radio的value值
            var money = data.value;
            $("#money").val(money);
            <%--$.ajax({--%>
                <%--url: '${pageContext.request.contextPath}/get/sendrechargeCenterjisuan.page?money=' + money,--%>
                <%--success: function (result) {--%>
                    <%--console.log(result.code)--%>
                    <%--if (result.code == 0) {--%>
                        <%--$("#money").val(result.msg);--%>
                    <%--} else if (result == 2) {--%>
                        <%--layer.msg("该号码已被注册");--%>
                    <%--} else {--%>
                        <%--layer.msg("发送失败");--%>
                    <%--}--%>
                <%--}--%>
            <%--})--%>
        });
    });
</script>

</body>
</html>