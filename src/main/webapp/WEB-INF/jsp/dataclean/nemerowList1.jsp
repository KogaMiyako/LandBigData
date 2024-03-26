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



<%--dropdown格式--%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/dropdown.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/reset.css">
<script src="${pageContext.request.contextPath}/app/js/dropdown.js"></script>


<%--leaflet ESRI css js--%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/leaflet/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
      crossorigin="" />
<script src="${pageContext.request.contextPath}/app/js/leaflet/leaflet.js"></script>


<!-- Load Esri Leaflet from local -->
<script src="${pageContext.request.contextPath}/app/js/leaflet/esri-leaflet.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/leaflet/esri-leaflet-geocoder.css"/>
<script src="${pageContext.request.contextPath}/app/js/leaflet/esri-leaflet-geocoder.js"></script>



<style>
    .tableth, .tabletd {
    width:220px;
    text-align: center;
    color:black;
    vertical-align: middle!important;


    }
    .tabletr{
        height: 100px;
    }

    #map {
        position: absolute;
        top: 0;
        bottom: 0;
        right: 0;
        left: 0;
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
    <h4 style="font-size: 18pt;color:dimgrey;">本检测结果严格按照内梅罗综合指数法与<a style="color:darkred;" href="/landbigdata/laws/download?fileName=食用农产品产地环境质量评价标准HJ_T_332-2006.pdf">食用农产品产地环境质量评价标准HJ_T+332-2006</a></h4>
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
                    <div class="col-md-1" style="height: 800px;">
                        <ul class="cd-accordion-menu animated" id = "pluDropDown" hidden = "hidden">
                            <li class="has-children">
                                <input type="checkbox" name ="group-1" id="group-1" checked>
                                <label for="group-1">基本状况</label>
                                <ul>
                                    <li><a href="javascript:doMap(0);">铬元素</a></li>
                                    <li><a href="javascript:doMap(1);">镍元素</a></li>
                                    <li><a href="javascript:doMap(2);">铜元素</a></li>
                                    <li><a href="javascript:doMap(3);">锌元素</a></li>
                                    <li><a href="javascript:doMap(4);">砷元素</a></li>
                                    <li><a href="javascript:doMap(5);">镉元素</a></li>
                                    <li><a href="javascript:doMap(6);">汞元素</a></li>
                                    <li><a href="javascript:doMap(7);">铅元素</a></li>

                                    <%--<li class="has-children">--%>
                                        <%--<input type="checkbox" name ="sub-group-1" id="sub-group-1">--%>
                                        <%--<label for="sub-group-1">鎘元素</label>--%>

                                        <%--<ul>--%>
                                            <%--<li><a href="#0">Image</a></li>--%>
                                            <%--<li><a href="#0">Image</a></li>--%>
                                            <%--<li><a href="#0">Image</a></li>--%>
                                        <%--</ul>--%>
                                    <%--</li>--%>


                                </ul>
                            </li>
                        </ul>
                    </div>
                    <div id="mapcontainer" class="col-md-11" style="height: 800px;">
                        <div id="map"></div>
                        <%--<div class="set-middle-image">--%>

                            <%--<h3 id="h1" hidden="true">各项金属指标</h3>--%>
                            <%--<table class="table table-hover table-font" id = "ex">--%>

                                <%--<tr>--%>
                                    <%--<td ><div id="Cr" style="width: 400px;height:400px;"></div></td>--%>
                                    <%--<td ><div id="Ni" style="width: 400px;height:400px;"></div></td>--%>
                                    <%--<td ><div id="Cu" style="width: 400px;height:400px;"></div></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td ><div id="Zn" style="width: 400px;height:400px;"></div></td>--%>
                                    <%--<td ><div id="As" style="width: 400px;height:400px;"></div></td>--%>
                                    <%--<td ><div id="Cd" style="width: 400px;height:400px;"></div></td>--%>
                                <%--</tr>--%>
                                <%--<tr>--%>
                                    <%--<td ><div id="Hg" style="width: 400px;height:400px;"></div></td>--%>
                                    <%--<td ><div id="Pb" style="width: 400px;height:400px;"></div></td>--%>
                                    <%--<td ><div id="Nemerow" style="width: 400px;height:400px;"></div></td>--%>
                                <%--</tr>--%>
                            <%--</table>--%>
                        <%--</div>--%>

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
                        <h3 id="noPlu" hidden="hidden" align="center">结合金属关联性分析与污染判定结果，暂未发现土地处于污染状态</h3>
                        <div id="HD" hidden="hidden">
                            <h2>最高可能性污染源</h2>
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
                            <h2>高可能性污染源</h2>
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
                            <h2>可能性污染源</h2>
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
    var re = null;
    var neme = null;
    var standard = null;
    //Cr  Ni  Cu  Zn  As  Cd  Hg  Pb
    var arr = ["铬","镍","铜","锌","砷","镉","汞","铅"];
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
                re = data['data'];
                neme = data['nemerowArr'];
                standard = data['standard'];
                alert(data['addStatus']);
                // $('#h1').removeAttr("hidden");
                // $.each(data['result'],function(n,value) {
                //     var myChart1 = echarts.init(document.getElementById(value['name']));
                //     option = {
                //         title: {
                //             text: value['name']
                //         },
                //         tooltip: {
                //             trigger: 'axis'
                //         },
                //         xAxis: {
                //             data: value['data'].map(function (item) {
                //                 return item[0];
                //             })
                //         },
                //         yAxis: {
                //             splitLine: {
                //                 show: false
                //             }
                //         },
                //         toolbox: {
                //             left: 'center',
                //             feature: {
                //                 dataZoom: {
                //                     yAxisIndex: 'none'
                //                 },
                //                 restore: {},
                //                 saveAsImage: {}
                //             }
                //         },
                //         dataZoom: [{
                //             startValue: '1'
                //         }, {
                //             type: 'inside'
                //         }],
                //         visualMap: {
                //             top: 10,
                //             right: 10,
                //             precision: 1,
                //             pieces: [{
                //                 gt: 0,
                //                 lte: 0.7,
                //                 color: '#096'
                //             }, {
                //                 gt: 0.7,
                //                 lte: 1,
                //                 color: '#ffde33'
                //             }, {
                //                 gt: 1,
                //                 color: '#d60f17'
                //             }],
                //             outOfRange: {
                //                 color: '#999'
                //             }
                //         },
                //         series: {
                //             name: value['name'],
                //             type: 'line',
                //             data: value['data'].map(function (item) {
                //                 return item[1];
                //             }),
                //             markLine: {
                //                 silent: true,
                //                 data: [{
                //                     yAxis: 0.7
                //                 }, {
                //                     yAxis: 1
                //                 }]
                //             }
                //         }
                //     }
                //     myChart1.setOption(option);
                // });

                //地图加载



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
                if(lowLevel.length>0){
                    $('#LD').removeAttr('hidden');

                }
                if(highLevel.length == 0 && middleLevel.length == 0 && lowLevel.length == 0)
                    $("#noPlu").removeAttr("hidden");

                $("#dataTbody3").append(getPluTBody(lowLevel));

                setMap("map",2,re,neme);

                $('#pluDropDown').removeAttr("hidden");

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
            result += "<th class=\"tableth\" style=\"font-size: 25px\">" + title[i] + "</th>";
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
                    result += "<th class=\"tableth\" style=\"font-size: 25px\"> </th>";
                    continue;
                }
                if(isNaN(data)){

                    result += "<th class=\"tableth\" style=\"font-size: 25px\">" + data + "</th>";
                }
                else{
                    if(data < 0.7){
                        data = (data * 100).toFixed(2);
                        data = data + "%";
                        result += "<td class=\"tabletd\" style=\"font-size: 25px\">" + data + "</td>";
                    }
                    else if(data >= 0.7 && data < 0.8){
                        data = (data * 100).toFixed(2);
                        data = data + "%";
                        result += "<td class=\"tabletd warning\" style=\"font-size: 25px\">" + data + "</td>";
                    }
                    else{
                        data = (data * 100).toFixed(2);
                        data = data + "%";
                        result += "<td class=\"tabletd danger\" style=\"font-size: 25px\">" + data + "</td>";
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
                "<td class=\"col-lg-1 col-md-1 text-center\" style='font-size:17pt'>"+pluName+"</td>" +
                "<td class=\"col-lg-3 col-md-3 \" style='font-size:17pt'>"+pluDesc+"</td>" +
                "<td class=\"col-lg-1 col-md-1  text-center\" style='font-size:17pt'>"+"<a  target=\"_blank\" href=\"pollution/showDetails?pluId="+pluId+"\">查看更多</a>"+"</td>" +
                "</tr>";
        }

        return s;
    }

    $('#functionCr').click(function () {
        $('#mapcontainer').empty();
        $('#mapcontainer').append("<div id=\"map\"></div>");
        setMap("map",1,re,neme);

    });
    function doMap(index){
        $('#mapcontainer').empty();
        $('#mapcontainer').append("<div id=\"map\"></div>");
        setMap("map",index,re,neme);
    }
    function setMap(element,index,data,neme){
        var map = L.map(element, {
            minZoom: 0,
            maxZoom: 14
        });
        map.setView([39.467098, 117.004395], 12);
        // map.setView([117.014, 39.495], 10);
        map.setZoom(12);
        // var map = L.map('map').setView([117.014,39.495],2);
        // 			var map = L.map('map').setView([37.71, -99.88], 4);
        // 			L.esri.basemapLayer('Gray').addTo(map);

        L.esri.dynamicMapLayer({
            // url: 'https://services.arcgisonline.com/arcgis/rest/services/Specialty/Soil_Survey_Map/MapServer',
            url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
            searchFields : ['NAME_3','NAME_1'],

            opacity: 0.7
        }).addTo(map);
        var mypop = L.popup();

        var searchControl = L.esri.Geocoding.geosearch({
            providers: [
                <!-- arcgisOnline, -->
                L.esri.Geocoding.mapServiceProvider({
                    label: 'States and Counties',
                    url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
                    layers: [1],
                    searchFields: ['NAME_1', 'NAME_3']
                })
            ]
        }).addTo(map);

        var greenIcon = L.icon({
            iconUrl: 'http://localhost:8080/arcgis_js_api/green.png',

            iconSize:     [11, 11], // size of the icon
            popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
        });
        var redIcon = L.icon({
            iconUrl: 'http://localhost:8080/arcgis_js_api/red.png',

            iconSize:     [11, 11], // size of the icon
            popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
        });
        var orangeIcon = L.icon({
            iconUrl: 'http://localhost:8080/arcgis_js_api/orange.png',

            iconSize:     [11, 11], // size of the icon
            popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
        });
        var yellowIcon = L.icon({
            iconUrl: 'http://localhost:8080/arcgis_js_api/yellow.png',

            iconSize:     [11, 11], // size of the icon
            popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
        });
        var options = {
            minWidth : 300
        };


        for(var i=0;i<re.length;i++){
            var ico = null;
            var dataNum = data[i][index+1];
            var pH = data[i][0];
            var nemeNum = neme[i][index];
            var stdNum = null;
            if(pH<6.5)
                stdNum = standard[0][index];
            else if(pH < 7.5)
                stdNum = standard[1][index];
            else
                stdNum = standard[2][index];

            var percent = dataNum/stdNum;
            percent = percent.toFixed(2) * 100;

            if(nemeNum<0.7){
                ico = greenIcon;
            }
            else if(nemeNum<1){
                ico = yellowIcon;
            }
            else{
                ico = redIcon;
            }
            L.marker([data[i][10], data[i][9]], {icon: ico}).addTo(map)
                // .bindPopup('<table style="height: 127px;width: 224px; font-size: 14pt"><tr><td>'+arr[index]+'含量（mg）:</td><td>'+dataNum.toFixed(2)+'</td></tr><tr><td>国家标准（mg）</td><td>'+stdNum+'</td></tr><tr><td>比值</td><td>'+percent+'%</td></tr><tr><td>经度</td><td>'+data[i][9]+'</td></tr><tr><td>纬度:</td><td>'+data[i][10]+'</td></tr></table>',options);
                .bindPopup('<table style="height: 127px;width: 280px; font-size: 14pt"><tr><td>'+arr[index]+'含量（mg）:</td><td>'+dataNum.toFixed(2)+'</td></tr><tr><td>国家标准（mg）</td><td>'+stdNum+'</td></tr><tr><td>比值</td><td>'+percent+'%</td></tr><tr><td>经度</td><td>'+data[i][9]+'</td></tr><tr><td>纬度:</td><td>'+data[i][10]+'</td></tr><tr><td>省市:</td><td>'+data[i][11]+' '+data[i][12]+' '+'</td></tr><tr><td>区县:</td><td>'+data[i][13]+' '+data[i][14]+' '+'</td></tr></table>',options);

        }
        // <!--red-->
        // L.marker([39.445842, 117.184682], {icon: redIcon}).addTo(map)
        //     .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>镉含量（mg）:</td><td>0.08mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>150%</td></tr><tr><td>经度</td><td>117.184682</td></tr><tr><td>纬度:</td><td>39.445842</td></tr></table>',options);
        //
        // <!-- green -->
        // L.marker([39.345528, 117.113235], {icon: greenIcon}).addTo(map)
        //     .bindPopup('<table><tr><td>镉含量（mg）:</td><td>0.03mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>60%</td></tr><tr><td>经度</td><td>117.017492</td></tr><tr><td>纬度:</td><td>39.345528</td></tr></table>',options);
        // L.marker([39.333158, 117.017492], {icon: greenIcon}).addTo(map)
        //     .bindPopup('<table><tr><td>镉含量（mg）:</td><td>0.24mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>48%</td></tr><tr><td>经度</td><td>117.283492</td></tr><tr><td>纬度:</td><td>39.333158</td></tr></table>',options);

    }
</script>
<script>
    jQuery(".set-content").slide({autoPlay:false,trigger:"click",delayTime:700,pnLoop:false});
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>
