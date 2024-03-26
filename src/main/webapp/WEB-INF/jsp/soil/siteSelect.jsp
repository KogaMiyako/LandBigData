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
        <div class="panel-heading">智能选址算法</div>
        <div class="panel-body">
            &emsp;&emsp;针对工厂、农业区等污染区域，使用图数据结构建模土壤污染点位，
            构建基于图神经网络的污染源监测点位选址推荐模型，优化污染源监测点位选址技术，
            为污染源选址提供规范化推荐方案，提高土壤污染识别感知准确率
        </div>
    </div>
</div>


<div class="form-group">
    <input type="file" name="file" id="al1_1File" multiple class="file" data-upload-url="soilFile/upload?algMode=2"
           data-preview-file-type="text">
</div>


<div class="input-group" id="cmdDiv">
    <label class="label-default" style="width :744px"> </label>
    <%--<div class="row">
        <div style="float: left;margin-left: 20px">
            <h4>聚类簇个数：</h4>
        </div>
        <div class="form-group col-md-4" style="width: 50%;">
            <input type="text" class="form-control" id="cluster" placeholder="请输入聚类簇个数">
        </div>
    </div>--%>

    <select id="site-model-select" class="form-control" style="width: 50%; margin-top: -15px">
<%--        filename-num1-num2--%>
        <option value="-1">请选择模型文件</option>
        <option value="1">SiteData-45-28.pth</option>
<%--        <option>Option 2</option>--%>
<%--        <option>Option 3</option>--%>
    </select>


    <span class="input-group-btn">
            <button type="button" class="btn btn-success"
                    id="runButton" onclick="runSiteSelect()">运行算法</button>
    </span>
</div>

<script>

</script>