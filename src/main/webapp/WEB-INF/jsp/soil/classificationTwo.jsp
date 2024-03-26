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
        <div class="panel-heading">水面污染物识别算法</div>
        <div class="panel-body">
            &emsp;&emsp;水污染问题与土壤污染息息相关，水质的恶化将会直接对土壤造成影响，因而把水污染的检测纳入到土壤污染检测的范围内是十分有必要的。在yolov7的模型的基础上，增加了对小目标有优势的检测结构，以提高小目标检测的精度。
        </div>
    </div>
</div>


<div class="form-group">
    <input type="file" name="file" id="al1_1File" multiple class="file" data-upload-url="soilFile/upload?algMode=4"
           data-preview-file-type="text">
</div>


<div class="input-group" id="cmdDiv">
    <label class="label-default" style="width :744px"> </label>
    <span class="input-group-btn">
            <button type="button" class="btn btn-success"
                    id="runButton" onclick="runClassificationTwo()">运行算法</button>
    </span>
</div>