<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%--<%@taglib prefix="sec"--%>
<%--uri="http://www.springframework.org/security/tags"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<section class="content">
    <div class="row" style="width: 100%;height: 100%;">
        <div class="col-xs-12" style="width: 100%;height: 100%;">
            <div class="box-body no-padding">
                <div class="box-header" align="center">
                    <h3 class="box-title">微信扫码支付 收银台</h3>
                </div>
                <table style="width: 100%;height: 100%;border: none;">
                    <tr>
                        <td colspan="3" align="center">
                            <label>订单编号：${orderNo}</label><br/>
                            <label>订单类型：${ordertype}</label>
                        </td>
                        <td class="pull-right">应付金额：${money}</td>
                    </tr>
                    <tr style="width: 100%;">
                        <td></td>
                        <td align="center"><img src="${pageContext.request.contextPath}/img/WePayLogo.png"
                                                style="height: 20%;">
                            <img src="${pageContext.request.contextPath}/img/按钮标签.png" style="height: 20%;"></td>
                        <td><label>亿万用户的选择，更快更安全</label></td>
                        <td class="pull-right"><label><font size="5%" color="red">支付${money}元</font></label></td>
                    </tr>
                    <tr>
                        <td colspan="4" align="center"><img alt="" src="${urlpath}"></td>
                    </tr>
                    <tr>
                        <td colspan="4" align="center"><img alt=""
                                                            src="${pageContext.request.contextPath}/img/说明文字.png"></td>
                </table>
            </div>
            <!-- /.box-body -->
        </div>
    </div>
</section>
