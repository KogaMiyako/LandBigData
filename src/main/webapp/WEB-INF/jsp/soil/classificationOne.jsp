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
        <div class="panel-heading">垃圾分类算法一</div>
        <div class="panel-body">
            &emsp;&emsp;基于传感器采集与数据资料收集等方式，实现对重金属、酸、碱、有机物、农药、生活垃圾等污染物的采集与管理。
            基于概念注意力网络方法，针对采集的土壤污染物图像数据进行特征提取，实现全口径土壤污染物的实时感知、识别、预警
        </div>
    </div>
</div>


<div class="form-group">
    <input type="file" name="file" id="al1_1File" multiple class="file" data-upload-url="soilFile/upload?algMode=3"
           data-preview-file-type="text">
</div>


<div class="input-group" id="cmdDiv">
    <label class="label-default" style="width :744px"> </label>
    <span class="input-group-btn">
            <button type="button" class="btn btn-success"
                    id="runButton" onclick="runClassificationOne()">运行算法</button>
    </span>
</div>