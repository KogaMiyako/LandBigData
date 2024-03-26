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
        <p class="box-name">防控预案编辑</p>
        <p class="box-content">可以根据算法执行的分析结果制定防控预案，发布后以便执行相应的防控预案信息。</p>


    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">编辑区域</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal" role="form" action="javascript:reportSub();">

                <div class="form-group">
                    <div class="col-xs-12">
                        <input type="text" class="form-control" id="titlename"
                               placeholder="请输入标题">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <input type="text" class="form-control" id="user"
                               placeholder="请输入部门">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <textarea class="form-control" rows="3" placeholder="请输入内容" id="content"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-10">
                        <button type="submit" class="btn btn-primary" style="margin-top: 20px;margin-left: 1300px">发布预案</button>
                    </div>
                </div>

            </form>
        </div>
    </div>

</div>


<script>
    function reportSub(){

        let title = document.getElementById('titlename').value
        let user = document.getElementById('user').value
        let content = document.getElementById('content').value

        console.log(content)

        $.ajax({
            url:'report/addReports',
            type:'POST',
            data : {'title': title, 'user': user, 'content': content},
            dataType: 'json',
            success(){
                alert('发布成功！')
                returnToReport()
            },
            error(){
                alert('error')
            }
        })




    }

    function returnToReport(){
        var str1 = "个人中心"
        var str2 = "防控预案信息"
        document.getElementById("index-page-title").innerHTML=str1;
        document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
        $.get("user/report", function (data) {
            $('#main-content').html(data);
        });
    }
</script>






