<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <jsp:include page="/common/backend_common.jsp"/>
    <jsp:include page="/common/page.jsp"/>
</head>
<body class="no-skin" youdao="bind" style="background: white">
<input id="gritter-light" checked="" type="checkbox" class="ace ace-switch ace-switch-5"/>

<div class="page-header">
    <h1>
        商城管理
        <small>
            <i class="ace-icon fa fa-angle-double-right"></i>
            修改皮肤类型
        </small>
    </h1>
</div>
<div class="main-content-inner">
    <div class="col-sm-12">
        <div class="col-xs-12">
            <div class="table-header">
                添加/修改限制
            </div>
            <form class="layui-form layui-form-pane" id="myFrom">
                <input type="hidden" name="id"   value="${skinDetail.id}">
                <div class="layui-form-item">
                    <label class="layui-form-label">名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" lay-verify="required"  autocomplete="off" class="layui-input" value="${skinDetail.name}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">${skinDetail.type}类型</label>
                    <div class="layui-input-inline">
                        <select name="type" lay-verify="required" id="room">
                            <c:forEach var="stu" items="${SkinTypeList}">
                                <c:if test="${skinDetail.type==stu.id}">
                                     <option value="${stu.id}" selected>${stu.name}</option>
                                </c:if>
                                <c:if test="${skinDetail.type!=stu.id}">
                                   <option value="${stu.id}">${stu.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                        <script>
                            <%--room.value = "${roomSet.gameRoom}";--%>
                        </script>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">风格</label>
                    <div class="layui-input-inline">
                        <select name="style" lay-verify="required">
                            <c:forEach var="stu" items="${skinStyleList}">

                                    <c:if test="${skinDetail.style==stu.id}">
                                        <option value="${stu.id}" selected>${stu.styleName}</option>
                                    </c:if>
                                    <c:if test="${skinDetail.style!=stu.id}">
                                        < <option value="${stu.id}">${stu.styleName}</option>
                                    </c:if>


                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">价格(熊掌)</label>
                    <div class="layui-input-inline">
                        <input type="text" name="price1" lay-verify="required"  autocomplete="off" class="layui-input" value="${skinDetail.price1}">
                    </div>
                    <div class="layui-form-mid layui-word-aux">熊掌</div>
                </div>
                <div class="layui-form-item">
                    <%--<label class="layui-form-label">仅限熊掌</label>--%>
                    <div class="layui-input-block">
                        <c:if test="${skinDetail.priceChoice==1}">
                             <input type="checkbox" name="priceChoice" lay-filter="jin1" id="ji1" value="1" title="仅限熊掌" checked>
                        </c:if>
                        <c:if test="${skinDetail.priceChoice==0}">
                            <input type="checkbox" name="priceChoice" lay-filter="jin1" id="ji1" value="0" title="仅限熊掌">
                        </c:if>
                    </div>
                </div>
                <div id="jin1">
                    <div class="layui-form-item">
                        <label class="layui-form-label">价格(积分)</label>
                        <div class="layui-input-inline">
                            <input type="text" name="price2"   autocomplete="off" class="layui-input" value="${skinDetail.price2}">
                        </div>
                        <div class="layui-form-mid layui-word-aux">积分</div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label" style="width: 140px">是否启用优惠</label>
                    <div class="layui-input-block">

                        <c:if test="${skinDetail.discountUse==1}">
                            <input type="radio" name="discountUse" lay-filter="game" value="1" title="开启" checked>
                            <input type="radio" name="discountUse" lay-filter="game" value="0" title="禁用" >
                        </c:if>
                        <c:if test="${skinDetail.discountUse==0}">
                            <input type="radio" name="discountUse" lay-filter="game" value="1" title="开启" >
                            <input type="radio" name="discountUse" lay-filter="game" value="0" title="禁用" checked>
                        </c:if>
                    </div>
                </div>
                <div id="aaa">
                    <div class="layui-form-item">
                        <label class="layui-form-label" style="width: 140px">优惠价格(熊掌)</label>
                        <div class="layui-input-inline">
                            <input type="text" name="discount1"   autocomplete="off" class="layui-input" value="${skinDetail.discount1}">
                        </div>
                        <div class="layui-form-mid layui-word-aux">熊掌</div>
                    </div>
                    <div class="layui-form-item">
                        <%--<label class="layui-form-label">仅限熊掌</label>--%>
                        <div class="layui-input-block">

                            <c:if test="${skinDetail.discountChoice==1}">
                                <input type="checkbox" name="discountChoice" lay-filter="jin2" id="ji2" value="1" title="仅限熊掌" checked>
                            </c:if>
                            <c:if test="${skinDetail.discountChoice==0}">
                                <input type="checkbox" name="discountChoice" lay-filter="jin2" id="ji2" value="0" title="仅限熊掌">
                            </c:if>
                        </div>
                    </div>
                    <div id="jin2">
                        <div class="layui-form-item">
                            <label class="layui-form-label" style="width: 140px">优惠价格(积分)</label>
                            <div class="layui-input-inline">
                                <input type="text" name="discount2"   autocomplete="off" class="layui-input" value="${skinDetail.discount2}">
                            </div>
                            <div class="layui-form-mid layui-word-aux">积分</div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">状态</label>
                    <div class="layui-input-block">
                        <c:if test="${skinDetail.status==1}">
                            <input type="radio" name="status" lay-filter="ga"  value="1" title="上架" checked>
                            <input type="radio" name="status" lay-filter="ga" value="0" title="下架" >
                        </c:if>
                        <c:if test="${skinDetail.status==0}">
                            <input type="radio" name="status" lay-filter="ga"  value="1" title="上架" >
                            <input type="radio" name="status" lay-filter="ga" value="0" title="下架" checked>
                        </c:if>

                    </div>
                </div>
                <p>创建时间: <fmt:formatDate value="${skinDetail.createTime}" type="both"/></p>
                <c:if test="${skinDetail.onShelfTime==null}">
                    <p>上架时间: 未上架</p>
                </c:if>
                <c:if test="${not empty skinDetail.onShelfTime}">
                    <p>上架时间: <fmt:formatDate value="${skinDetail.onShelfTime}" type="both"/></p>
                </c:if>

                <c:if test="${skinDetail.offShelfTime==null}">
                    <p>下架时间: 未下架</p>
                </c:if>
                <c:if test="${not empty skinDetail.offShelfTime}">
                    <p>下架时间: <fmt:formatDate value="${skinDetail.offShelfTime}" type="both"/></p>
                </c:if>
                <div class="layui-form-item">
                    <label class="layui-form-label">创建人</label>
                    <div class="layui-input-inline">
                        <input type="text" name="founder" lay-skinDetail="required"  autocomplete="off" class="layui-input" value="${skinDetail.founder}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="addLearnbook">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
<script>
    layui.use(['upload','form','layedit'], function() {
        var form=layui.form;
        form.render();
        var $ = layui.jquery
            ,upload = layui.upload;

        //普通图片上传
        var uploadInst = upload.render({
            elem: '#test1'
            ,url: '${pageContext.request.contextPath}/FileController/imgUpload.json'
            ,before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#demo1').attr('src', result); //图片链接（base64）
                });
            }
            ,done: function(res){
                //如果上传失败
                if(res.code > 0){
                    return layer.msg('上传失败');
                }else{
                    console.log(res);
                    $("#pic").val(res.data);
                }
            }
            ,error: function(){
                //演示失败状态，并实现重传
                var demoText = $('#demoText');
                demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                demoText.find('.demo-reload').on('click', function(){
                    uploadInst.upload();
                });
            }
        });

        form.on('submit(addLearnbook)', function(data){
            var rid=$("#id").val();
            console.info(rid)
            if(rid!=null&&rid!=""){
                console.info("修改")
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/skinDetail/update.page');
            }else{
                console.info("添加")
                $('form[id=myFrom]').attr('action','${pageContext.request.contextPath}/skinDetail/update.page');
            }
        });

        form.on('radio(game)', function(data){
            console.log(data.value); //得到被选中的值
            if(data.value==1){
                $("#aaa").show();
            }else{
                $("#aaa").hide();
            }
        });
        var aaa=1;
        form.on('checkbox(jin1)', function(data){
            console.log(data.value); //得到被选中的值
            if(data.value ==0){
                $("#jin1").hide();
                $("#ji1").val("1");
                aaa=0;
            }else{
                $("#jin1").show();
                $("#ji1").val("0");
                aaa=1;
            }
        });

        form.on('checkbox(jin2)', function(data){
            console.log(data.value); //得到被选中的值
            if(data.value ==0){
                $("#jin2").hide();
                $("#ji2").val("1");

            }else{
                $("#jin2").show();
                $("#ji2").val("0");

            }
        });
    });
</script>

<script type="text/html" id="columnType">
    {{#  if(d.columnType ==1){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">教材</a>
    {{#  } }}
    {{#  if(d.columnType ==2){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">曲谱</a>
    {{#  } }}
    {{#  if(d.columnType ==3){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">广告</a>
    {{#  } }}
    {{#  if(d.columnType ==4){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm">文本</a>
    {{#  } }}
</script>
</body>
</html>