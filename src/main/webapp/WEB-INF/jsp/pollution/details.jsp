<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
<!-- END GLOBAL MANDATORY STYLES -->

<!-- BEGIN THEME STYLES -->
<link href="${pageContext.request.contextPath}/assets/css/style-metronic.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/style-responsive.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/plugins.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/themes/default.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/custom.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/assets/css/pages/table-list.css" rel="stylesheet" type="text/css" />
<!-- END THEME STYLES -->

<link href="${pageContext.request.contextPath}/app/img/cloud.png" rel="shortcut icon"/>

<script src="${pageContext.request.contextPath}/assets/plugins/datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/assets/plugins/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" ></script>

<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>污染源 : </strong></td>
                <td>${plu.pollutionName}</td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>描述 : </strong></td>
                <td>${plu.pollutionDescribe}</td>
            </tr>
        </table>
    </div>


    <table class="table table-hover table-font">
        <thead>
        <tr>
            <td class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>重金属名称</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span>相关性</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-tree-conifer" aria-hidden="true"></span>样本是否超标</td>
        </tr>
        </thead>
        <tbody id="dataTbody">
        <c:forEach items="${strs}" var="data">
            <tr>
                <td class="col-lg-1 col-md-1 text-center">${data[0]}</td>
                <td class="col-lg-2 col-md-2 text-center">${data[1]}</td>
                <td class="col-lg-2 col-md-2 text-center">${data[2]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br/>
    <hr>
    <br/>
    <h3>防治策略</h3>
    <table class="table table-hover table-font">
        <thead>
        <tr>
            <td class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>策略</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span>实施方案</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-tree-conifer" aria-hidden="true"></span>针对金属</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${recovers}" var="data"  varStatus="p">
            <tr>
                <td class="col-lg-1 col-md-1 text-center">${p.index+1}</td>
                <td class="col-lg-2 col-md-2 text-center">${data.recoverDescribe}</td>
                <td class="col-lg-2 col-md-2 text-center">${data.recoverMetalName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<script src="${pageContext.request.contextPath}/assets/plugins/respond.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/excanvas.min.js"></script>
<![endif]-->
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/select2/select2.min.js" type="text/javascript" ></script>

<script src="${pageContext.request.contextPath}/assets/scripts/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/FastJson-1.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/app/js/index.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"
        type="text/javascript"></script>