<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>
<script src="${pageContext.request.contextPath}/app/js/jquery.js"></script>

<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/app/js/soil/myScript.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/app/js/index.js" type="text/javascript"></script>

<div style="margin-top: 10px">
    <div class="panel panel-danger table-font">
        <!-- Default panel contents -->
        <div class="panel-heading">污染溯源算法</div>
        <div class="panel-body">
            &emsp;&emsp;研究基于层次聚类的多源异构土壤污染溯源技术，在边云协同体系中，研究土壤污染溯源技术，综合运用受体模型、源模型等方法，
            基于层次聚类的土壤重金属溯源方法挖掘土壤污染源
        </div>
    </div>
</div>


<div class="form-group">
    <input type="file" name="file" id="al1_1File" multiple class="file" data-upload-url="soilFile/upload?algMode=1"
           data-preview-file-type="text">
</div>


<div class="input-group" id="cmdDiv">
    <label class="label-default" style="width :744px"> </label>
    <span class="input-group-btn">
            <button type="button" class="btn btn-success"
                    id="runButton" onclick="runPollutionResource()">运行算法</button>
    </span>
</div>



