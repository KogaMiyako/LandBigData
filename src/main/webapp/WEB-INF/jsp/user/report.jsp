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
        <p class="box-name">防控预案信息</p>

        <p class="box-content">可查看或编辑历史发布过的污染防控预案，了解最新的土壤防控政策；或主动发布新的土壤防控预案。</p>


    </div>

    <table class="table table-hover table-responsive table-font">
        <thead>
        <tr>
            <td></td>
            <td>预案标题</td>
            <td>相关部门</td>
            <td>制定执行时间</td>
            <td>编辑</td>
        </tr>
        </thead>
        <tbody id="reports">
        <%--<tr>
            <td>000</td>
            <td><a href="javascript:toReport()">关于污染溯源超标元素的进一步分析和判断</a></td>
            <td>防控指挥室</td>
            <td>2022-10-22</td>
            <td><a href="javascript:;">修改</a>&nbsp;/&nbsp;<a href="javascript:;">删除</a></td>
        </tr>--%>

        </tbody>
    </table>


    <button type="button" class="btn btn-success"
            id="runButton" onclick="toEdit()" style="position: fixed;bottom: 100px;right: 50px">编辑预案</button>
</div>


<script>

    function toEdit(){
        var str1 = "个人中心"
        var str2 = "预案编辑界面"
        document.getElementById("index-page-title").innerHTML=str1;
        document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
        $.get("user/edit", function (data) {
            $('#main-content').html(data);
        });
    }

    function toReport(textName){
        textName = textName.id
        var str1 = "个人中心"
        var str2 = "预案详情界面"
        document.getElementById("index-page-title").innerHTML=str1;
        document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
        $.get("user/reportShow?textName=" + textName, function (data) {
            $('#main-content').html(data);
        });
    }

    function timeFormatter(execTime){
        return execTime.substring(0,4) + '年'
            + execTime.substring(4, 6) + '月'
            + execTime.substring(6, 8) + '日'
    }


    $.ajax({
        url:'report/getReports',
        type:'POST',
        async:true,
        success(data3){
            FastJson.format(data3);
            console.log(data3['reports'])

            console.log(data3['reports'].length)

            var tbody = ''
            var basePath = data3['basePath']

            for (var i = 0; i < data3['reports'].length ; i++){
                var reports_ = data3['reports'][i]
                tbody += `
                    <tr>
                        <td>`+ i +`</td>
                        <td> <a id="`+ reports_['textName'] +`" onclick="toReport(this)">` + reports_['title'] + `</a></td>
                        <td>`+ reports_['depart']+`</td>
                        <td>`+ timeFormatter(reports_['reTime']) +`</td>
                        <td>

                            <a data-id="`+ reports_['id'] +`" onclick="dataDelete(this)">删除</a>
                        </td>
                    </tr>
                `
            }//<a data-id="`+ reports_['id'] +`" onclick="dataEdit(this)">修改</a>&nbsp;/&nbsp;

            document.getElementById('reports').innerHTML = tbody
        },
        error(data3){
            alert("加载数据失败")
        }
    })

    function returnToReport(){
        var str1 = "个人中心"
        var str2 = "防控预案信息"
        document.getElementById("index-page-title").innerHTML=str1;
        document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
        $.get("user/report", function (data) {
            $('#main-content').html(data);
        });
    }

    function dataEdit(tagA){
        alert(tagA.dataset.id)

    }

    function dataDelete(tagA){

        if (confirm('确定要删除吗？')){
            $.ajax({
                url:'report/delReports',
                type:'POST',
                data : {'id': tagA.dataset.id},
                dataType: 'json',
                success(){
                    alert('删除成功！')
                    returnToReport()
                },
                error(){
                    alert('error')
                }
            })
        }


    }

</script>


