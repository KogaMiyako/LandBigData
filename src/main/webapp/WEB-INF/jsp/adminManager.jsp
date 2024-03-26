<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<link href="${pageContext.request.contextPath}/assets/css/style1.css" rel="stylesheet" type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/app/js/jquery.SuperSlide.2.1.1.js"></script>

<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>Type: </strong></td>
                <td>${cls.className}</td>
            </tr>
            <tr>
                <td colspan="2"><hr></td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>Description: </strong></td>
                <td>${cls.classDescribe}</td>
            </tr>
        </table>
    </div>

    <table class="table table-hover table-font">
        <tr>
            <div class="text-center" id="addAlg" data-toggle="modal" data-target="#addExcel">
                <img src="${pageContext.request.contextPath}/assets/img/node/add_32.png" style="margin-top: 8px"/>
            </div>
        </tr>
    </table>

</div>
    <div class="set-content">
        <div style="height: 80px;"></div>
        <div class="set-title hd">
            <ul class="clearfix">
                <li class="on">群组管理</li>
                <li>日志移存</li>
                <li>索引更新</li>
            </ul>
        </div>
        <div class="set-middle bd">
            <ul class="set-middle-item">
                <li>
                    <div class="set-middle-image">
                        <div>
                            <div class="text-center" style="padding: 20px">
                                <span class="mine-title">
                                  <img src="${pageContext.request.contextPath}/assets/img/search/search_48.png" style="margin-right: 20px"/>
                                  <strong>群组检索</strong>
                                </span>
                            </div>

                            <div class="input-group mine-box has-success">
                                <input type="text" class="form-control" id="grouptext">
                                <span class="input-group-btn">
                                   <button class="btn btn-primary" type="button" style="margin-right: 10px" onclick="text_group()"><span class="glyphicon glyphicon-search"></span>&nbsp;检索</button>
                                </span>
                            </div>

                            <div id="groupresult" class="mine-result-box">

                            </div>
                        </div>
                    </div>
                </li>
                <li style="height: 250px">
                    <table class="table" id="group" >
                        <thead>
                        <tr>
                            <th class="col-lg-1 col-md-1 text-center">是否选中</th>
                            <th class="col-lg-1 col-md-2 text-center">群组名称</th>
                            <th class="col-lg-1 col-md-2 text-center">群组描述</th>
                            <th class="col-lg-1 col-md-1 text-center">现任组长</th>

                        </tr>
                        </thead>
                        <tbody id="groupTbody">
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">天津农业环保所风险评估组</td>
                                <td class="col-lg-1 col-md-2 text-center">天津农业环保所风险评估组主要负责土壤的等级评价，为土壤治理提供腐竹决策</td>
                                <td class="col-lg-1 col-md-1 text-center">刘襄阳</td>
                            </tr>
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">南京农业蔬菜研究所</td>
                                <td class="col-lg-1 col-md-2 text-center">改组主要分析土壤地质，作物品行，从而给出蔬菜种植的指导性意见</td>
                                <td class="col-lg-1 col-md-1 text-center">李清亮</td>
                            </tr>
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">辽宁省农业科学院种植研究所</td>
                                <td class="col-lg-1 col-md-2 text-center">研究院主要开展粮油、蔬菜、果树、等新品种选育及种质资源收集、保存、评价和创新工作</td>
                                <td class="col-lg-1 col-md-1 text-center">王立群</td>
                            </tr>
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">四川省农业科学院水稻所</td>
                                <td class="col-lg-1 col-md-2 text-center">针对水稻种植与新品种的开发进行研究工作</td>
                                <td class="col-lg-1 col-md-1 text-center">王盛林</td>
                            </tr>
                        </tbody>
                    </table>
                </li>
                <li>
                    <div class="set-middle-image">
                        <div>
                            <div class="text-center" style="padding: 20px">
                                <span class="mine-title">
                                  <img src="${pageContext.request.contextPath}/assets/img/search/search_48.png" style="margin-right: 20px"/>
                                  <strong>用户检索</strong>
                                </span>
                            </div>

                            <div class="input-group mine-box has-success">
                                <input type="text" class="form-control" id="usertext">
                                <span class="input-group-btn">
                                   <button class="btn btn-primary" type="button" style="margin-right: 10px" onclick="text_user()"><span class="glyphicon glyphicon-search"></span>&nbsp;检索</button>
                                </span>
                            </div>

                            <div id="userresult" class="mine-result-box">

                            </div>
                        </div>
                    </div>
                </li>
                <li  style="height: 200px;">
                    <table class="table" id="user">
                        <thead>
                        <tr>
                            <th class="col-lg-1 col-md-1 text-center">是否选中</th>
                            <th class="col-lg-1 col-md-2 text-center">用户真实姓名</th>
                            <th class="col-lg-1 col-md-2 text-center">所在群组</th>
                            <th class="col-lg-1 col-md-1 text-center">用户级别</th>


                        </tr>
                        </thead>
                        <tbody id="userTbody1">
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">刘劲松</td>
                                <td class="col-lg-1 col-md-2 text-center">南京农业蔬菜研究所</td>
                                <td class="col-lg-1 col-md-1 text-center">成员</td>
                            </tr>
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">刘襄阳</td>
                                <td class="col-lg-1 col-md-2 text-center">天津农业环保所风险评估组</td>
                                <td class="col-lg-1 col-md-1 text-center">组长</td>
                            </tr>
                            <tr style="font-size:15px;">
                                <td class="col-lg-1 col-md-1 text-center">
                                    <label class="radio-inline"><input type="radio" value="pdf" name="contenttype"/></label>
                                </td>
                                <td class="col-lg-1 col-md-2 text-center">刘胜</td>
                                <td class="col-lg-1 col-md-2 text-center">无</td>
                                <td class="col-lg-1 col-md-1 text-center">无</td>
                            </tr>

                        </tbody>
                    </table>
                </li>
                <li>
                    <center>
                        <button class="btn btn-primary" type="button" style="" onclick="submitChange()">确认修改</button>
                    </center>
                </li>
            </ul>
            <ul class="set-middle-item">
                <li>
                    <div  id="middle" class="set-middle-image">

                    </div>
                </li>
            </ul>
            <ul class="set-middle-item">
                <li>
                    <div class="set-middle-image">
                        <h3>最高可能性污染源</h3>
                            <div>
                                <table class="table" id="highP">
                                    <thead>
                                    <tr>
                                        <th class="col-lg-1 col-md-1 text-center">名称</th>
                                        <th class="col-lg-3 col-md-3 text-center">描述</th>
                                        <th class="col-lg-1 col-md-1 text-center">详细</th>
                                    </tr>
                                    </thead>
                                    <tbody id="dataTbody1">

                                    </tbody>
                                </table>
                            </div>
                    </div>

                </li>
            </ul>
        </div>
    </div>

</div>

<div class="modal fade" id="addExcel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加待分析文件</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label>Excel文件</label>
                    <input id="" type="file" name="file" multiple class="file" data-upload-url="dataClean/upload"
                           data-file-upload-preview="text" data-min-file-count="1" data-show-preview="false">
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="no_upload_file" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行填充操作.
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="addExcelFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="addExcelSubmit">提交</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    /**
     * 添加算法提交
     */

    $('#addExcelSubmit').click(function(){
            var alg={
                classId:${cls.classId},
                className:"${cls.className}"
            };
            $.ajax({
                type:'POST',
                url:'dataClean/addNemerow',
                data:JSON.stringify(alg),
                dataType:'json',
                contentType:'application/json; charset=utf-8',
                async:true,
                success:function(data){
                    alert(data['addStatus']);

                    $('#middle').empty();
                    $('#middle').append("<h3>超标重金属："+data['pluStr']+"</h3><br><br>");
                    $('#middle').append("<h3>重要金属关联指数</h3><br>");
                    $.each(data['relationMap'],function(key,values){
                        $('#middle').append("<h4>&emsp;&emsp;重要关系元素："+key+" , 相关系数为"+values+"</h4><br>");
                    });
                    $('#middle').append("<h3>全部金属关联指数</h3><br>");
                    $.each(data['allRelationMap'],function(key,values){
                        $('#middle').append("<h3>&emsp;&emsp;"+key+" ～ "+values+"</h3><br>");
                    });
                    $('#h1').removeAttr('hidden');

                    $("#dataTbody1").empty();
                    $("#dataTbody2").empty();
                    $("#dataTbody3").empty();

                    var highLevel = data['highLevel'];
                    var middleLevel = data['middleLevel'];
                    var lowLevel = data['lowLevel'];
                    for(i in highLevel){
                        var pluName = highLevel[i].plu.pollutionName;
                        var pluDesc = highLevel[i].plu.pollutionDescribe;
                        $("#dataTbody1").append("<tr>" +
                            "<td class=\"col-lg-1 col-md-1 text-center\">"+pluName+"</td>" +
                            "<td class=\"col-lg-3 col-md-3 text-center\">"+pluDesc+"</td>" +
                            "<td class=\"col-lg-1 col-md-1 text-center\">"+"查看更多"+"</td>" +
                            // "<td class=\"col-lg-1 col-md-1 text-center\"><a class=\"more\" href=\"javascript:void(0);\" onclick=\"datadownload(this)\" value=\""+data[i].dataFilename+"\">下载</a></td>" +
                            "</tr>");
                    }
                },
                error:function (data) {
                    $('#addExcelFailed').removeAttr('hidden');
                }
            });


    });
    function text_group(){
        $.ajax({
            type:"GET",
            url:"data/simpleSearch?kw="+ $('#mtext').val()+"&classId="+${cls.classId},
            async:true,
            success:function(data){
                $("#dataTbody").empty();
                // var jsonData = JSON.parse(data);
                for(i in data){
                    var jsDate = new Date(data[i].dataCreatetime);
                    var dateStr=jsDate.format("yyyy-MM-dd hh:mm:ss");
                    $("#dataTbody").append("<tr>" +
                        "<td class=\"col-lg-1 col-md-1 text-center\">"+data[i].dataName+"</td>" +
                        "<td class=\"col-lg-2 col-md-2 text-center\">"+data[i].dataDescribe+"</td>" +
                        "<td class=\"col-lg-2 col-md-2 text-center\">"+data[i].dataCity+"</td>" +
                        "<td class=\"col-lg-2 col-md-2 text-center\">"+dateStr+"</td>" +
                        "<td class=\"col-lg-1 col-md-1 text-center\">"+data[i].dataCreateuser+"</td>" +
                        "<td class=\"col-lg-1 col-md-1 text-center\"><a class=\"more\" href=\"javascript:void(0);\" onclick=\"datadownload(this)\" value=\""+data[i].dataFilename+"\">下载</a></td>" +
                        "</tr>");
                }
                <%--<fmt:formatDate value=\"data[i].dataCreatetime\" pattern=\"yyyy-MM-dd HH:mm:ss\"]/> --%>

            },
            error:function(){
                window.location.href= "404";
            }
        });
    }
</script>
<script>
    jQuery(".set-content").slide({autoPlay:false,trigger:"click",delayTime:700,pnLoop:false});
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>
