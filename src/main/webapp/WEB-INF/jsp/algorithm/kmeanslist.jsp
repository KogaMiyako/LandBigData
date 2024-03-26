<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>Type: </strong></td>
                <td>${algorithm.algorithmName}</td>
            </tr>
            <tr>
                <td colspan="2"><hr></td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>Description: </strong></td>
                <td>${algorithm.algorithmDescribe}</td>
            </tr>
        </table>
    </div>

    <%--<table class="table table-hover table-font" id = "ex">--%>
        <%--<tr>--%>
            <%--<td ><div id="pH" style="width: 400px;height:400px;"></div></td>--%>
            <%--<td ><div id="Cr" style="width: 400px;height:400px;"></div></td>--%>
            <%--<td ><div id="Ni" style="width: 400px;height:400px;"></div></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td ><div id="Cu" style="width: 400px;height:400px;"></div></td>--%>
            <%--<td ><div id="Zn" style="width: 400px;height:400px;"></div></td>--%>
            <%--<td ><div id="As" style="width: 400px;height:400px;"></div></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td ><div id="Cd" style="width: 400px;height:400px;"></div></td>--%>
            <%--<td ><div id="Hg" style="width: 400px;height:400px;"></div></td>--%>
            <%--<td ><div id="Pb" style="width: 400px;height:400px;"></div></td>--%>
        <%--</tr>--%>
    <%--</table>--%>

    <table class="table table-hover table-font">
        <tr>
            <div class="text-center" id="addAlg" data-toggle="modal" data-target="#addExcel">
                <img src="${pageContext.request.contextPath}/assets/img/node/add_32.png" style="margin-top: 8px"/>
            </div>
        </tr>
    </table>

    <h3>聚类结果：</h3>
    <p id="expression" style="font-size:22px;"></p>
    <hr size="5px">
</div>

<div class="modal fade" id="addExcel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">设置文件与参数</h4>
            </div>
            <div class="modal-body">



                <div class="form-group">
                    <label for="k">聚类结果簇的个数</label>
                    <textarea class="form-control" id="k" placeholder="k" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="convergenceDelta">迭代误差大小</label>
                    <textarea class="form-control" id="convergenceDelta" placeholder="convergenceDelta" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="maxIterations">最大迭代次数</label>
                    <textarea class="form-control" id="maxIterations" placeholder="maxIterations" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label>待聚类文件（txt格式）</label>
                    <input id="fileId" type="file" name="file" multiple class="file" data-upload-url="algorithm/uploadkmeans"
                           data-file-upload-preview="text" data-min-file-count="1" data-show-preview="false">
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="no_upload_file" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行填充操作.
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="addExcelFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 <%--提交按钮接入到cmd_logisticcheck()中，并且需要更改js逻辑--%>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="cmd_kmeanscheck()">提交</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    /**
     * 添加算法提交
     */


</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>
