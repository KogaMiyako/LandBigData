<%--
<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="row">
    <div class="col-md-6" style="margin-top: 45px">

    </div>
    <div class="col-md-6" style="margin-top: 45px">

    </div>
</div>--%>
<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div>
    <div class="index-box">
        <p class="box-name">算法历史报告</p>

        <p class="box-content">查看历史重要数据和分析概要，并以此判断污染严重程度；若达到防控需要的阈值，
            则可以通过污染防控平台的综合数据进行污染溯源分析，并通过污染溯源解析结果进行污染防控草案的制定。</p>


    </div>

    <table class="table table-hover table-responsive table-font">
        <thead>
        <tr>
            <td></td>
            <td>执行算法</td>
            <td>上传文件名</td>
            <td>上传文件格式</td>
            <td>算法执行时间</td>
            <td>运行结果</td>
        </tr>
        </thead>
        <tbody id="histories">
        <%--<tr>
            <td>001</td>
            <td>溯源算法</td>
            <td><a href="javascript:;">data1.xlsx</a></td>
            <td>Excel数据文件</td>
            <td>2022-10-22</td>
            <td><a href="javascript:;">查看结果</a></td>
        </tr>
        <tr>
            <td>002</td>
            <td>选址算法</td>
            <td><a href="javascript:;">data2.xlsx</a></td>
            <td>Excel数据文件</td>
            <td>2022-10-24</td>
            <td><a href="javascript:;">查看结果</a></td>
        </tr>--%>
        <%--<c:forEach items="${nodes}" var="nodes">
            <tr class="nodes" node="${nodes.nodeName}"
                ip="${nodes.nodeIp}"
                contextPath="${pageContext.request.contextPath}">

                <td><input type="checkbox"/></td>
                <td><img src="${pageContext.request.contextPath}/assets/img/node/monitor.png"
                         class="img-responsive list-img"/>&nbsp;${nodes.nodeName}</td>
                <td>
                    <span>
                    <c:choose>
                        <c:when test="${nodes.nodeStatus == '运行中'}">
                        <img src="${pageContext.request.contextPath}/assets/img/node/running.png"
                             class="img-responsive list-img"/>&nbsp;${nodes.nodeStatus}</span>
                    </c:when>
                    <c:otherwise>
                        <img src="${pageContext.request.contextPath}/assets/img/node/stoping.png"
                             class="img-responsive list-img"/>&nbsp;${nodes.nodeStatus}</span>
                    </c:otherwise>
                    </c:choose>
                </td>

                <td>${nodes.nodeIp}</td>
                <td><img src="${pageContext.request.contextPath}/assets/img/node/ubuntu.png"
                         class="img-responsive list-img"> </img>${nodes.nodeSpecification}</td>
                <td>${nodes.nodeRole}</td>
                <td>${nodes.nodeCreater}</td>
                <td><fmt:formatDate value="${nodes.nodeTime}" pattern="yyyy-MM-dd HH:mm"/></td>

            </tr>
        </c:forEach>--%>
        </tbody>
    </table>

    <button type="button" class="btn btn-success"
            id="runButton" onclick="toEdit()" style="position: fixed;bottom: 100px;right: 50px">编辑预案</button>
</div>



<%--<div class="contextMenu" id="menu">
    <ul>
        <li id="start">
            <img src="${pageContext.request.contextPath}/assets/img/node/start_16.png" width="16" height="16"/>
            启动
        </li>
        <li id="stop">
            <img src="${pageContext.request.contextPath}/assets/img/node/stop_16.png" width="16" height="16"/>
            关闭
        </li>
        <li id="monitor">
            <img src="${pageContext.request.contextPath}/assets/img/node/monitor.png" width="16" height="16"/>
            打开终端
        </li>
        <li id="about">
            <img src="${pageContext.request.contextPath}/assets/img/node/about_16.png" width="16" height="16"/>
            关于
        </li>
    </ul>
</div>

<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">关于</h4>
            </div>
            <div class="modal-body table-font">
                <p class="p-text">
                    Hadoop作为分布式和并行化的数据处理支撑点，为算法库的运行提供基础环境。其中，Hadoop可分为Master和Slave节点，通过云服务层的虚拟化技术，我们将硬件设备进行统一管理，并进行了计算资源的分配。
                </p>
                <p class="p-text">
                    Master节点是一个中心服务节点，负责管理文件系统的名字空间以及客户端对文件的访问，也负责对用户提交任务进行统一调度。Slave节点是一般子节点，负责管理它所在节点上的存储与处理文件系统客户端的读写请求，在Master的统一调度下进行数据块的创建、删除和复制，并执行Master分配的任务。
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>--%>

<script>

    let res_url = ''

    function getAlgName(algId){
        if (algId === 1){
            res_url = 'soilAlgorithm/pollutionResourceShow2'
            return '污染溯源算法'
        }else if (algId === 2){
            res_url = 'soilAlgorithm/siteSelectShow2'
            return '检测选址算法'
        }else if (algId === 3 ){
            res_url = 'soilAlgorithm/classificationOneShow2'
            return '垃圾分类算法一'
        }else if (algId === 4){
            res_url = 'soilAlgorithm/classificationTwoShow2'
            return '水面污染物识别算法'
        }else{
            return '大数据基础算法'
        }
    }

    function timeFormatter(execTime){
        return execTime.substring(0,4) + '年'
            + execTime.substring(4, 6) + '月'
            + execTime.substring(6, 8) + '日'
    }

    $.ajax({
        url:'history/getHistories',
        type:'POST',
        async:true,
        success(data3){
            FastJson.format(data3);
            console.log(data3['histories'])

            console.log(data3['histories'].length)

            var tbody = ''
            var basePath = data3['basePath']

            for (var i = 0; i < data3['histories'].length ; i++){
                var history_ = data3['histories'][i]
                tbody += `
                    <tr>
                        <td>`+ i +`</td>
                        <td>`+ getAlgName(history_['algId']) +`</td>
                        <td><a href="`+ basePath + '/file/download2?fileName='+ history_['dataFileName']
                    +`">`+ history_['dataFileName'] +`</a></td>
                        <td>`+ history_['dataFlleType']+'格式文件' +`</td>
                        <td>`+ timeFormatter(history_['execTime']) +`</td>
                        <td><a id="`+ history_['reslutDirName'] +`" onclick="run_his_show(this)" >`+ '查看结果' +`</a></td>
                    </tr>
                `
            }//history_['reslutDirName']

            document.getElementById('histories').innerHTML = tbody
        },
        error(data3){
            alert("加载数据失败")
        }
    })

    function run_his_show(reslutDirName){
        console.log(reslutDirName)
        reslutDirName = reslutDirName.id
        console.log(reslutDirName)

        let algID = reslutDirName.split('_')[0]

        if (algID === '1'){
            var str1 = "土壤大数据算法"
            var str2 = "污染溯源算法运行结果"
            document.getElementById("index-page-title").innerHTML=str1;
            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
            $.get("soilAlgorithm/pollutionResourceShow2?filename=" + reslutDirName, function (data) {
                $('#main-content').html(data);
            });
        }else if (algID === '2'){
            var str1 = "土壤大数据算法"
            var str2 = "检测选址算法运行结果"
            document.getElementById("index-page-title").innerHTML=str1;
            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
            $.get("soilAlgorithm/siteSelectShow2?filename=" + reslutDirName, function (data) {
                $('#main-content').html(data);
            });
        }else if(algID === '3'){
            var str1 = "土壤大数据算法"
            var str2 = "垃圾分类算法一运行结果"
            document.getElementById("index-page-title").innerHTML=str1;
            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
            $.get("soilAlgorithm/classificationOneShow2?filename=" + reslutDirName, function (data) {
                $('#main-content').html(data);
            });
        }else if (algID === '4'){
            var str1 = "土壤大数据算法"
            var str2 = "水面污染物识别算法运行结果"
            document.getElementById("index-page-title").innerHTML=str1;
            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
            $.get("soilAlgorithm/classificationTwoShow2?filename=" + reslutDirName, function (data) {
                $('#main-content').html(data);
            });
        }else {

        }


    }

    function toEdit(){
        var str1 = "个人中心"
        var str2 = "预案编辑界面"
        document.getElementById("index-page-title").innerHTML=str1;
        document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
        $.get("user/edit", function (data) {
            $('#main-content').html(data);
        });



    }
</script>


