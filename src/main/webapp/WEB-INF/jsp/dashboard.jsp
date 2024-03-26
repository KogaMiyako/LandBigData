<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--<div class="row" style="margin-top: 20px" id="dashboard_1">
    <p class="boardtitle" style="margin-left: 15px">重金属大数据</p>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat blue">

            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                               onmouseout="popover_hide(this)" title="文本挖掘" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               data-content="针对土地文本数据来源广，覆盖面大，涉及内容较多的实际情况，利用文本挖掘的方法实现对不同部门关注的关键信息进行分级、多粒度挖掘，实现多角色的土地文本数据内容推荐服务">文本挖掘</a></strong>
                </h4>
            </div>
            <div class="details">
                <img class="boardcloud" src="${pageContext.request.contextPath}/assets/img/node/cloud.png"/>
            </div>
            <a class="more" href="javascript:;" value="1" onclick="landmore(this)"> View more <i
                    class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat green">

            <div class="visual" style="width: 100px;">
                <h4>
                    <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                               onmouseout="popover_hide(this)" title="数据填充" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               data-content="针对土地资源数据在采集和处理过程中导致的数据缺失，使用基于分布式减法聚类的不完整数据填充算法对缺失数据进行填充，从而使得数据在预处理阶段达到知识挖掘的要求">数据填充</a></strong>
                </h4>
            </div>
            <div class="details">
                <img class="boardcloud" src="${pageContext.request.contextPath}/assets/img/node/cloud.png"/>
            </div>
            <a class="more" href="javascript:;" value="2" onclick="landmore(this)"> View more <i
                    class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat purple">

            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                               onmouseout="popover_hide(this)" title="迁移学习" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               data-content="针对土地资源数据各项指标采集不均衡的情况，通过迁移学习的方法对不均衡数据进行补偿，辅助决策判断，促进符合实际的决策产生">迁移学习</a></strong>
                </h4>
            </div>
            <div class="details number">
                <img class="boardcloud" src="${pageContext.request.contextPath}/assets/img/node/cloud.png"/>
            </div>
            <a class="more" href="javascript:;" value="3" onclick="landmore(this)"> View more <i
                    class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat" id="addResClass" data-toggle="modal" data-target="#addResClassModal">
            <div class="text-center" style="margin-top: 20px"><img
                    src="${pageContext.request.contextPath}/assets/img/node/add_64.png"/></div>
        </div>
    </div>
</div>
<hr/>

<div class="row" style="margin-top: 20px" id="dashboard_2">
    <p class="boardtitle" style="margin-left: 15px">污染分析</p>
    <c:forEach items="${dataCleanClasses}" var="classes">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <c:choose>
        <c:when test="${classes.classId%4==1}">
        <div class="dashboard-stat blue">
            </c:when>
            <c:when test="${classes.classId%4==2}">
            <div class="dashboard-stat green">
                </c:when>
                <c:when test="${classes.classId%4==3}">
                <div class="dashboard-stat purple">
                    </c:when>
                    <c:when test="${classes.classId%4==0}">
                    <div class="dashboard-stat yellow">
                        </c:when>
                        </c:choose>
                        <div class="visual" style="width: 100px">
                            <h4>
                                <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                                           onmouseout="popover_hide(this)" title="${classes.className}"
                                           data-container="body"
                                           data-toggle="popover" data-trigger="focus"
                                           data-content="${classes.classDescribe}">${classes.className}</a></strong>
                            </h4>
                        </div>
                        <a class="more" href="javascript:void(0);" onclick="viewmoreDataClean(this)"
                           value="${classes.classId}"> View more <i class="m-icon-swapright m-icon-white"></i>
                        </a>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<hr/>
<div class="row" style="margin-top: 20px" id="dashboard_2">
                <p class="boardtitle" style="margin-left: 15px">源解析算法</p>
                <c:forEach items="${algClasses}" var="classes">
                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                    <c:choose>
                    <c:when test="${classes.classId%4==1}">
                    <div class="dashboard-stat blue">
                        </c:when>
                        <c:when test="${classes.classId%4==2}">
                        <div class="dashboard-stat green">
                            </c:when>
                            <c:when test="${classes.classId%4==3}">
                            <div class="dashboard-stat purple">
                                </c:when>
                                <c:when test="${classes.classId%4==0}">
                                <div class="dashboard-stat yellow">
                                    </c:when>
                                    </c:choose>
                                    <div class="visual" style="width: 100px">
                                        <h4>
                                            <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                                                       onmouseout="popover_hide(this)" title="${classes.className}"
                                                       data-container="body"
                                                       data-toggle="popover" data-trigger="focus"
                                                       data-content="${classes.classDescribe}">${classes.className}</a></strong>
                                        </h4>
                                    </div>
                                        &lt;%&ndash;<div class="details">&ndash;%&gt;
                                        &lt;%&ndash;<div class="number">${fn:length(algClasses)}</div>&ndash;%&gt;
                                        &lt;%&ndash;</div>&ndash;%&gt;
                                    <a class="more" href="javascript:void(0);" onclick="viewmore(this)"
                                       value="${classes.classId}"> View more <i
                                            class="m-icon-swapright m-icon-white"></i>
                                    </a>
                                </div>
                            </div>
                            </c:forEach>
                            <c:if test="${sessionScope.user.userAuthority == 0 ||sessionScope.user.userAuthority == 1}">
                                <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="dashboard-stat" id="addAlgClass" data-toggle="modal"
                                         data-target="#addAlgClassModal">
                                        <div class="text-center" style="margin-top: 20px"><img
                                                src="${pageContext.request.contextPath}/assets/img/node/add_64.png"/>
                                        </div>
                                    </div>
                                </div>
                            </c:if>

                        </div>
                    </div>
                </div>
            </div>

<hr/>
<div class="row" style="margin-top: 20px" id="dashboard_2">
                            <p class="boardtitle" style="margin-left: 15px">资源数据库</p>
                            &lt;%&ndash;    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                    <div class="dashboard-stat yellow">
                                        <div class="visual" style="width: 100px">
                                            <h4>
                                                <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                                                           onmouseout="popover_hide(this)" title="污染源信息" data-container="body"
                                                           data-toggle="popover" data-trigger="focus"
                                                           data-content="造成农田中重金属的污染的污染源分析">污染源信息</a></strong>
                                            </h4>
                                        </div>
                                        <a class="more" href="pollution/list"> View more <i class="m-icon-swapright m-icon-white"></i>
                                        </a>
                                    </div>
                                </div>&ndash;%&gt;
                            <c:forEach items="${resClasses}" var="classes">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <c:choose>
                                <c:when test="${classes.classId%4==1}">
                                <div class="dashboard-stat blue">
                                    </c:when>
                                    <c:when test="${classes.classId%4==2}">
                                    <div class="dashboard-stat green">
                                        </c:when>
                                        <c:when test="${classes.classId%4==3}">
                                        <div class="dashboard-stat purple">
                                            </c:when>
                                            <c:when test="${classes.classId%4==0}">
                                            <div class="dashboard-stat yellow">
                                                </c:when>
                                                </c:choose>
                                                <div class="visual" style="width: 100px">
                                                    <h4>
                                                        <strong><a class="a-popover" tabindex="0"
                                                                   onmouseover="popover_show(this)"
                                                                   onmouseout="popover_hide(this)"
                                                                   title="${classes.className}" data-container="body"
                                                                   data-toggle="popover" data-trigger="focus"
                                                                   data-content="${classes.classDescribe}">${classes.className}</a></strong>
                                                    </h4>
                                                </div>
                                                    &lt;%&ndash;<div class="details">&ndash;%&gt;
                                                    &lt;%&ndash;<div class="number">${fn:length(resClasses)}</div>&ndash;%&gt;
                                                    &lt;%&ndash;</div>&ndash;%&gt;
                                                <a class="more" href="javascript:void(0);" onclick="viewmoreRes(this)"
                                                   value="${classes.classId}"> View more <i
                                                        class="m-icon-swapright m-icon-white"></i>
                                                </a>
                                            </div>
                                        </div>
                                        </c:forEach>
                                        <c:if test="${sessionScope.user.userAuthority == 0 ||sessionScope.user.userAuthority == 1}">
                                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                                <div class="dashboard-stat" id="addResClass" data-toggle="modal"
                                                     data-target="#addResClassModal">
                                                    <div class="text-center" style="margin-top: 20px"><img
                                                            src="${pageContext.request.contextPath}/assets/img/node/add_64.png"/>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </div>

                        &lt;%&ndash;
                        <hr/>
                        <div class="row" style="margin-top: 20px" id="dashboard_2">
                            <p class="boardtitle" style="margin-left: 15px">管理模块</p>
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                <div class="dashboard-stat yellow">
                                    <div class="visual" style="width: 100px">
                                        <h4>
                                            <strong><a class="a-popover" tabindex="0" onmouseover="popover_show(this)"
                                                       onmouseout="popover_hide(this)" title="管理员页面" data-container="body"
                                                       data-toggle="popover" data-trigger="focus"
                                                       data-content="管理员页面">管理员页面</a></strong>
                                        </h4>
                                    </div>
                                    <a class="more" href="javascript:void(0);" onclick="viewmoreAdmin(this)" value="1"> View more <i class="m-icon-swapright m-icon-white"></i>
                                    </a>
                                </div>
                            </div>

                        &ndash;%&gt;
<hr/>
<div class="row" style="margin-top: 20px" id="dashboard_2">
    <p class="boardtitle" style="margin-left: 15px">课题组间研究成果 </p>
    <c:forEach items="${teamClasses}" var="classes">
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <c:choose>
        <c:when test="${classes.classId%4==1}">
        <div class="dashboard-stat blue">
            </c:when>
            <c:when test="${classes.classId%4==2}">
            <div class="dashboard-stat green">
                </c:when>
                <c:when test="${classes.classId%4==3}">
                <div class="dashboard-stat purple">
                    </c:when>
                    <c:when test="${classes.classId%4==0}">
                    <div class="dashboard-stat yellow">
                        </c:when>

                        </c:choose>
                        <div class="visual" style="width: 250px">
                            <h4>
                                <strong><a class="a-popover" tabindex="0"
                                           onmouseover="popover_show(this)"
                                           onmouseout="popover_hide(this)"
                                           title="${classes.className}" data-container="body"
                                           data-toggle="popover" data-trigger="focus"
                                           data-content="${classes.classDescribe}">${classes.className}</a></strong>
                            </h4>
                        </div>
                            &lt;%&ndash;<div class="details">&ndash;%&gt;
                            &lt;%&ndash;<div class="number">${fn:length(algClasses)}</div>&ndash;%&gt;
                            &lt;%&ndash;</div>&ndash;%&gt;
                        <a class="more" href="javascript:void(0);" onclick="viewmore(this)"
                           value="${classes.classId}"> View more <i
                                class="m-icon-swapright m-icon-white"></i>
                        </a>
                    </div>
                </div>
                </c:forEach>
                &lt;%&ndash;                <c:if test="${sessionScope.user.userAuthority == 0 ||sessionScope.user.userAuthority == 1}">
                                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                                        <div class="dashboard-stat" id="addAlgClass" data-toggle="modal" data-target="#addAlgClassModal">
                                            <div class="text-center" style="margin-top: 20px"><img src="${pageContext.request.contextPath}/assets/img/node/add_64.png"/></div>
                                        </div>
                                    </div>
                                </c:if>&ndash;%&gt;

            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="addResClassModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabelRes">添加資源类别</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="algClassName">类别名称</label>
                    <input class="form-control" type="text" id="resClassName"
                           placeholder="类别名称"/>
                </div>
                <div class="form-group">
                    <label for="algClassDescribe">类别描述</label>
                    <textarea class="form-control" id="resClassDescribe" placeholder="类别描述"
                              style="height: 200px"></textarea>
                </div>
                <div class="alert alert-danger alert-dismissible" role="alert"
                     id="addResClassFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addResClassSubmit">提交</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="addAlgClassModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span
                        aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">添加算法库类别</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="algClassName">类别名称</label>
                    <input class="form-control" type="text" id="algClassName"
                           placeholder="类别名称"/>
                </div>
                <div class="form-group">
                    <label for="algClassDescribe">类别描述</label>
                    <textarea class="form-control" id="algClassDescribe" placeholder="类别描述"
                              style="height: 200px"></textarea>
                </div>
                <div class="alert alert-danger alert-dismissible" role="alert"
                     id="addClassFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addAlgClassSubmit">提交</button>
            </div>
        </div>
    </div>
</div>--%>


<div class="row" style="margin-top: 10px;margin-left: 10px;margin-right: 10px;">
<%--    <p class="boardtitle" style="margin-left: 15px;">土壤污染平台</p>--%>
    <div class="index-box">
        <p class="box-name" style="text-align: center">土壤污染治理平台</p>

        <p class="box-content">
            &emsp;&emsp;该土壤污染平台旨在通过建立各层次模型处理算法库，实现多源异构数据的表示、数据模式的深度计算、以及面向时效特征和安全的
            数据挖掘等，验证本课题提出的模型、算法。并在通用算法库的基础上，建立多种模型对土地污染物数据深度挖掘潜力进行评价，并以可视化的方式
            将结果呈现给决策者，辅助决策者制定改造计划。利用大数据的计算模型，结合知识推理技术完成多维度、多场景下的污染源溯源的数据分析工作，
            在结果分析、潜在数据价值挖掘、污染源辅助决策上提供帮助。
        </p>
    </div>
</div>

<div class="row" style="margin-top: 20px">
    <p class="boardtitle" style="margin-left: 15px;">土壤大数据算法</p>

    <hr/>

    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat blue">
            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               onclick="viewmore(this)"
                               value="1">污染溯源算法</a></strong>
                </h4>
            </div>
            <a class="more"
               href="javascript:void(0);"
               onclick="viewmore(this)"
               value="1"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>

    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat green">
                <div class="visual" style="width: 100px">
                    <h4>
                        <strong><a class="a-popover" tabindex="0" data-container="body"
                                   data-toggle="popover" data-trigger="focus"
                                   onclick="viewmore(this)"
                                   value="2">检测选址算法</a></strong>
                    </h4>
                </div>
                <a class="more" href="javascript:void(0);"
                   onclick="viewmore(this)"
                   value="2"> View more <i class="m-icon-swapright m-icon-white"></i>
                </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat purple">
                <div class="visual" style="width: 100px">
                    <h4>
                        <strong><a class="a-popover" tabindex="0" data-container="body"
                                   data-toggle="popover" data-trigger="focus"
                                   onclick="viewmore(this)"
                                   value="3">垃圾分类算法一</a></strong>
                    </h4>
                </div>
                <a class="more" href="javascript:void(0);"
                   onclick="viewmore(this)"
                   value="3"> View more <i class="m-icon-swapright m-icon-white"></i>
                </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat yellow">
                <div class="visual" style="width: 100px">
                    <h4>
                        <strong><a class="a-popover" tabindex="0" data-container="body"
                                   data-toggle="popover" data-trigger="focus"
                                   onclick="viewmore(this)"
                                   value="4">水面污染物识别</a></strong>
                    </h4>
                </div>
                <a class="more" href="javascript:void(0);"
                   onclick="viewmore(this)"
                   value="4"> View more <i class="m-icon-swapright m-icon-white"></i>
                </a>
        </div>
    </div>
</div>

<div class="row" style="margin-top: 20px">
    <p class="boardtitle" style="margin-left: 15px;">防控场景视图</p>
    <hr/>

    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat blue">
            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               onclick="viewmore(this)"
                               value="5">开放式景区视图</a></strong>
                </h4>
            </div>
            <a class="more" href="javascript:void(0);"
               onclick="viewmore(this)"
               value="5"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>

    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat green">
            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               onclick="viewmore(this)"
                               value="6">采摘园视图场景</a></strong>
                </h4>
            </div>
            <a class="more" href="javascript:void(0);"
               onclick="viewmore(this)"
               value="6"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
        <div class="dashboard-stat purple">
            <div class="visual" style="width: 100px">
                <h4>
                    <strong><a class="a-popover" tabindex="0" data-container="body"
                               data-toggle="popover" data-trigger="focus"
                               onclick="viewmore(this)"
                               value="7"
                    >散户养殖场场景</a></strong>
                </h4>
            </div>
            <a class="more" href="javascript:void(0);"
               onclick="viewmore(this)"
               value="7"> View more <i class="m-icon-swapright m-icon-white"></i>
            </a>
        </div>
    </div>

</div>


<script type="text/javascript">

    function viewFill(url, str1, str2) {
        document.getElementById("index-page-title").innerHTML=str1;
        document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
        $.get(url, function (data) {
            $('#main-content').html(data);
            console.log(data)
        });
    }

    // zlx: view more 的跳转
    function viewmore(e) {

        $("#main-navbar").removeAttr("hidden");
        switch (e.getAttribute('value')) {
            case '1':
                // $('#pollutionResource').trigger('click');
                // debugger;
                viewFill('soilAlgorithm/pollutionResource','土壤大数据算法','污染溯源算法')
                break;
            case '2':
                // $('#siteSelect').trigger('click');
                viewFill('soilAlgorithm/siteSelect','土壤大数据算法','检测选址算法')
                break;
            case '3':
                // $('#classificationOne').trigger('click');
                viewFill('soilAlgorithm/classificationOne','土壤大数据算法','垃圾分类算法一')
                break;
            case '4':
                // $('#classificationTwo').trigger('click');
                viewFill('soilAlgorithm/classificationTwo','土壤大数据算法','垃圾分类算法一')
                break;
            case '5':
                $('.landmore1').trigger('click');
                break;
            case '6':
                $('#clusterinfo').trigger('click');
                break;
            case '7':
                $('#farmInfo').trigger('click');
                break;
            default:
                break;
        }

    }

    function viewmoreRes(e) {
        //var url="algorithm/list?id="+ e.getAttribute("value");
        $.ajax({
            type: "GET",
            url: "class/details?id=" + e.getAttribute("value"),
            async: true,
            success: function (data) {
                $('#main-navbar').removeAttr("hidden");
                document.getElementById("index-page-title").innerHTML = "已上传数据";
                document.getElementById("page-index").innerHTML = '<li><i class="fa fa-home"></i><a href="main">已上传数据集</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">数据</a></li>';
                $.get("data/list?id=" + data, function (rs) {
                    $('#main-content').html(rs);
                });
            },
            error: function () {
                window.location.href = "404";
            }
        });
    }

    function viewmoreAdmin(e) {
        //var url="algorithm/list?id="+ e.getAttribute("value");
        $.ajax({
            type: "GET",
            url: "class/details?id=1",
            async: true,
            success: function (data) {
                $('#main-navbar').removeAttr("hidden");
                document.getElementById("index-page-title").innerHTML = "管理界面";
                document.getElementById("page-index").innerHTML = '<li><i class="fa fa-home"></i><a href="main">主页面</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">管理员界面</a></li>';
                $.get("dataClean/list?id=9", function (rs) {
                    $('#main-content').html(rs);
                });
            },
            error: function () {
                window.location.href = "404";
            }
        });
    }

    function viewmoreDataClean(e) {
        //var url="algorithm/list?id="+ e.getAttribute("value");
        $.ajax({
            type: "GET",
            url: "class/details?id=" + e.getAttribute("value"),
            async: true,
            success: function (data) {
                $('#main-navbar').removeAttr("hidden");
                document.getElementById("index-page-title").innerHTML = "污染分析";
                document.getElementById("page-index").innerHTML = '<li><i class="fa fa-home"></i><a href="main">污染分析</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">异常点观察</a></li>';
                $.get("dataClean/list?id=" + data, function (rs) {
                    $('#main-content').html(rs);
                });
            },
            error: function () {
                window.location.href = "404";
            }
        });
    }

    function landmore(e) {
        $('#main-navbar').removeAttr("hidden");
        document.getElementById("index-page-title").innerHTML = "土地大数据";
        document.getElementById("page-index").innerHTML = '<li><i class="fa fa-home"></i><a href="main">土地大数据</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">核心技术</a></li>';
        if ($(e).attr("value") == 1) {
            $.get("land/text/mine", function (rs) {
                $('#main-content').html(rs);
            });
        } else if ($(e).attr("value") == 2) {
            $.get("land/data/imputation", function (rs) {
                $('#main-content').html(rs);
            });
        } else if ($(e).attr("value") == 3) {
            $.get("land/data/transfer", function (rs) {
                $('#main-content').html(rs);
            });
        }
    }

    function popover_show(e) {
        $(e).popover('toggle');
    }

    function popover_hide(e) {
        $(e).popover('toggle');
    }

    $('#addAlgClassSubmit').click(function () {
        if ($('#algClassName').attr("value").trim() == "" || $('#algClassDescribe').attr("value").trim() == "") {
            $('#addClassFailed').removeAttr('hidden');
        } else {
            $.post("class/add", {
                className: $('#algClassName').attr("value"),
                classDescribe: $('#algClassDescribe').attr("value"),
                classType: 1
            }, function (data) {
                if (data.trim() == 'success') {
                    window.location.reload();
                } else {
                    $('#addClassFailed').removeAttr('hidden');
                }

            });
        }
    })
    $('#addResClassSubmit').click(function () {
        if ($('#resClassName').attr("value").trim() == "" || $('#resClassDescribe').attr("value").trim() == "") {
            $('#addResClassFailed').removeAttr('hidden');
        } else {
            $.post("class/add", {
                className: $('#resClassName').attr("value"),
                classDescribe: $('#resClassDescribe').attr("value"),
                classType: 2
            }, function (data) {
                if (data.trim() == 'success') {
                    window.location.reload();
                } else {
                    $('#addResClassFailed').removeAttr('hidden');
                }

            });
        }
    })
</script>

