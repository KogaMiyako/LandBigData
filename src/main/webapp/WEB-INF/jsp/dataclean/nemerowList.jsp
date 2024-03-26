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
<style>
    .tableth, .tabletd {
    width:220px;
    text-align: center;
    vertical-align: middle!important;

    }
    .tabletr{
        height: 100px;
    }
</style>
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
    <h4>本检测结果严格按照内梅罗综合指数法与<a href="/landbigdata/laws/download?fileName=食用农产品产地环境质量评价标准HJ_T_332-2006.pdf">食用农产品产地环境质量评价标准HJ_T+332-2006</a></h4>
    <div class="set-content">
        <div style="height: 80px;"></div>
        <div class="set-title hd">
            <ul class="clearfix">
                <li class="on">样本污染状况</li>
                <li>相关系数分析</li>
                <li>溯源辅助决策</li>
            </ul>
        </div>
        <div class="set-middle bd">
            <ul class="set-middle-item">
                <li>
                    <div class="set-middle-image">

                        <h3 id="h1" hidden="true">各项金属指标</h3>
                        <table class="table table-hover table-font" id = "ex">

                            <tr>
                                <td ><div id="Cr" style="width: 400px;height:400px;"></div></td>
                                <td ><div id="Ni" style="width: 400px;height:400px;"></div></td>
                                <td ><div id="Cu" style="width: 400px;height:400px;"></div></td>
                            </tr>
                            <tr>
                                <td ><div id="Zn" style="width: 400px;height:400px;"></div></td>
                                <td ><div id="As" style="width: 400px;height:400px;"></div></td>
                                <td ><div id="Cd" style="width: 400px;height:400px;"></div></td>
                            </tr>
                            <tr>
                                <td ><div id="Hg" style="width: 400px;height:400px;"></div></td>
                                <td ><div id="Pb" style="width: 400px;height:400px;"></div></td>
                                <td ><div id="Nemerow" style="width: 400px;height:400px;"></div></td>
                            </tr>
                        </table>
                    </div>
                </li>
            </ul>
            <ul class="set-middle-item">
                <li>
                    <div  id="middle" class="set-middle-image">
                        <br>
                        <br>
                        <h2 align="center" id="middleTitle" hidden="hidden">相关系数分析结果表</h2>
                        <br>
                        <br>
                        <br>
                        <br>

                        <div class="table-responsive" id="relationDiv">
                            <table class="table table-bordered" id="relationTable">

                            </table>
                        </div>
                    </div>
                </li>
            </ul>
            <ul class="set-middle-item">
                <li>
                    <div class="set-middle-image" >
                        <div id="HD" hidden="hidden">
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
                        <div id="MD" hidden="hidden">
                            <h3>高可能性污染源</h3>
                            <div>
                                <table class="table" id="middleP">
                                    <thead>
                                    <tr>
                                        <th class="col-lg-1 col-md-1 text-center">名称</th>
                                        <th class="col-lg-3 col-md-3 text-center">描述</th>
                                        <th class="col-lg-1 col-md-1 text-center">详细</th>
                                    </tr>
                                    </thead>
                                    <tbody id="dataTbody2">
                                    <tr style="font-size:20px;">

                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div id="LD" hidden="hidden">
                            <h3>可能性污染源</h3>
                            <div>
                                <table class="table" id="lowP">
                                    <thead>
                                    <tr>
                                        <th class="col-lg-1 col-md-1 text-center">名称</th>
                                        <th class="col-lg-3 col-md-3 text-center">描述</th>
                                        <th class="col-lg-1 col-md-1 text-center">详细</th>
                                    </tr>
                                    </thead>
                                    <tbody id="dataTbody3">
                                    <tr style="font-size:20px;">

                                    </tr>
                                    </tbody>
                                </table>
                            </div>
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
            classId:2,
            className:"1"
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
                $.each(data['result'],function(n,value) {
                    var myChart1 = echarts.init(document.getElementById(value['name']));
                    option = {
                        title: {
                            text: value['name']
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        xAxis: {
                            name: "序号",
                            nameTextStyle:{
                                fontSize:15
                            },
                            data: value['data'].map(function (item) {
                                return item[0];
                            })
                        },
                        yAxis: {
                            splitLine: {
                                show: false
                            }
                        },
                        toolbox: {
                            left: 'center',
                            feature: {
                                dataZoom: {
                                    yAxisIndex: 'none'
                                },
                                restore: {},
                                saveAsImage: {}
                            }
                        },
                        dataZoom: [{
                            startValue: '1'
                        }, {
                            type: 'inside'
                        }],
                        visualMap: {
                            top: 10,
                            right: 10,
                            precision: 1,
                            pieces: [{
                                gt: 0,
                                lte: 0.7,
                                color: '#096'
                            }, {
                                gt: 0.7,
                                lte: 1,
                                color: '#ffde33'
                            }, {
                                gt: 1,
                                color: '#d60f17'
                            }],
                            outOfRange: {
                                color: '#999'
                            }
                        },
                        series: {
                            name: value['name'],
                            type: 'line',
                            data: value['data'].map(function (item) {
                                return item[1];
                            }),
                            markLine: {
                                silent: true,
                                data: [{
                                    yAxis: 0.7
                                }, {
                                    yAxis: 1
                                }]
                            }
                        }
                    }
                    myChart1.setOption(option);
                });

                //相关系数分析表数据加载
                $("#relationDiv").empty();
                var relationTbody = getRelationTable(data['relationMatrix']);
                $("#middleTitle").removeAttr("hidden");
                $("#relationDiv").append(relationTbody);


                $("#dataTbody1").empty();
                $("#dataTbody2").empty();
                $("#dataTbody3").empty();

                var highLevel = data['highLevel'];
                var middleLevel = data['middleLevel'];
                var lowLevel = data['lowLevel'];

                //最高可能性污染源
                if(highLevel.length>0){
                    $('#HD').removeAttr('hidden');

                }
                $("#dataTbody1").append(getPluTBody(highLevel));

                //高可能性污染源
                if(middleLevel.length>0){
                    $('#MD').removeAttr('hidden');

                }
                $("#dataTbody2").append(getPluTBody(middleLevel));

                //可能性污染源
                if(middleLevel.length>0){
                    $('#LD').removeAttr('hidden');

                }
                $("#dataTbody3").append(getPluTBody(lowLevel));

            },
            error:function (data) {
                $('#addExcelFailed').removeAttr('hidden');
            }
        });


    });
    function getRelationTable(relationMatrix) {
        var result = "";

        result += "<table class=\"table table-bordered\" id=\"relationTable\">";
        //  <thead> </thead>
        result += "<thead>" + "<tr class=\"tabletr\">";
        var title = relationMatrix[0];
        for(i in title){
            result += "<th class=\"tableth\" style=\"font-size: 17px\">" + title[i] + "</th>";
        }
        result += "</tr>" + "</thead>";

        //<tbody> </tbody>
        result += "<tbody>";
        for(i in relationMatrix){
            if(i == 0)
                continue;
            result += "<tr class=\"tabletr\">";
            var row = relationMatrix[i];
            for(j in row){

                var data = row[j];
                if(data == null){
                    result += "<th class=\"tableth\" style=\"font-size: 17px\"> </th>";
                    continue;
                }
                if(isNaN(data)){

                    result += "<th class=\"tableth\" style=\"font-size: 17px\">" + data + "</th>";
                }
                else{
                    if(data < 0.7){
                        data = (data * 100).toFixed(2);
                        data = data + "%";
                        result += "<td class=\"tabletd\" style=\"font-size: 17px\">" + data + "</td>";
                    }
                    else if(data >= 0.7 && data < 0.8){
                        data = (data * 100).toFixed(2);
                        data = data + "%";
                        result += "<td class=\"tabletd warning\" style=\"font-size: 17px\">" + data + "</td>";
                    }
                    else{
                        data = (data * 100).toFixed(2);
                        data = data + "%";
                        result += "<td class=\"tabletd danger\" style=\"font-size: 17px\">" + data + "</td>";
                    }
                }
            }
            result += "</tr>";
        }
        result += "</tbody>";
        result += "</table>";
        return result;
    }

    function getPluTBody(XLevel) {
        var s = "";
        for(i in XLevel){
            var pluName = XLevel[i].plu.pollutionName;
            var pluId = XLevel[i].plu.pollutionId;
            var pluDesc = XLevel[i].plu.pollutionDescribe;
            s += "<tr>" +
                "<td class=\"col-lg-1 col-md-1 text-center\">"+pluName+"</td>" +
                "<td class=\"col-lg-3 col-md-3 \">"+pluDesc+"</td>" +
                "<td class=\"col-lg-1 col-md-1 text-center\">"+"<a  target=\"_blank\" href=\"pollution/showDetails?pluId="+pluId+"\">查看更多</a>"+"</td>" +
                "</tr>";
        }

        return s;
    }
</script>
<script>
    jQuery(".set-content").slide({autoPlay:false,trigger:"click",delayTime:700,pnLoop:false});
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>
