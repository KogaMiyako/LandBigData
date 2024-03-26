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


<style>

    .reportContent{
        text-indent: 2em;
        line-height: 170%;
    }

</style>

<div>
    <div class="index-box">
        <p class="box-name">防控预案信息</p>

        <p class="box-content">防控预案的详细界面，可以查看发布的预案的详细信息。</p>


    </div>

    <h2 id="reportTitle" style="text-align: center;margin-top: 40px;margin-bottom: 20px"></h2>
<%--    关于污染溯源超标元素的进一步分析和判断--%>
    <h4 id="reportDate" style="text-align: center;margin: 10px"></h4>
<%--    2022年10月22日--%>
    <h4 id="reportUser" style="text-align: center;margin: 10px"></h4>
<%--    防控指挥室--%>

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10 centered" id="reportContent">
            <h3 style="" class="reportContent"></h3>
<%--            10月21日上报的污染数据进行的污染溯源分析结果中，Pb元素明显超标，算法初步分析是由于公路污染造成，经过进一步排查，确定是附近经过的高速公路
                汽车尾气排放污染造成，现已于当地政府相关部门取得联系，展开进一步土壤污染防治工作。--%>
        </div>
        <div class="col-md-1"></div>
    </div>

    <a id="${sessionScope.get("textName")}" class="temp"></a>

</div>


<script>

    function timeFormatter(execTime){
        return execTime.substring(0,4) + '年'
            + execTime.substring(4, 6) + '月'
            + execTime.substring(6, 8) + '日'
    }

    let text = document.getElementsByClassName('temp').item(0)
    let fileName = text.id
    console.log(fileName)

    $.ajax({
        url:'report/sendReports',
        type:'POST',
        data : {'fileName': fileName},
        dataType: 'json',
        success(data){
            console.log(data)

            let tagContent = ''

            let content = data['content']
            let splitContent = content.split('\n')
            for (const sContent of splitContent) {
                tagContent += `
                    <h3 style="" class="reportContent"> `+ sContent +` </h3>
                `
            }

            document.getElementById('reportTitle').innerText = data['title']
            document.getElementById('reportDate').innerText = timeFormatter(data['date'])
            document.getElementById('reportUser').innerText = data['user']
            document.getElementById('reportContent').innerHTML = tagContent

        },
        error(){
            alert('error')
        }
    })

</script>


