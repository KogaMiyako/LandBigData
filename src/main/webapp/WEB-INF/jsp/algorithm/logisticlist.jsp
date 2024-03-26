<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/leaflet/leaflet.css" integrity="sha512-puBpdR0798OZvTTbP4A8Ix/l+A4dHDD0DGqYW6RQ+9jxkRFclaxxQb/SJAWZfWAkuyeQUytO7+7N4QKrDh+drA=="
      crossorigin="" />
<script src="${pageContext.request.contextPath}/app/js/leaflet/leaflet.js"></script>


<!-- Load Esri Leaflet from local -->
<script src="${pageContext.request.contextPath}/app/js/leaflet/esri-leaflet.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/app/css/leaflet/esri-leaflet-geocoder.css"/>
<script src="${pageContext.request.contextPath}/app/js/leaflet/esri-leaflet-geocoder.js"></script>



<style>

    #map {
        /*position: absolute;*/
        /*top: 0;*/
        /*bottom: 0;*/
        /*right: 0;*/
        /*left: 0;*/
        /*height : 400px;*/
        /*width: 400px;*/
    }

</style>


<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>Type: </strong></td>
                <td>${algorithm.algorithmName}</td>
            </tr>
            <tr>
                <td colspan="2"><hr></td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>Description: </strong></td>
                <td>${algorithm.algorithmDescribe}</td>
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





    <div hidden="hidden" id="expressionh3">
        <h3 >结果表达式：</h3>
    </div>

    <p id="expression" style="font-size:15px;"></p>
    <hr size="5px">

    <div hidden="hidden" id="argsh3">
        <h3>各项指标比重：</h3>
    </div>
    <div>
        <div class = "col-md-4">
            <table class="table table-hover table-font" id = "property" style="height: 400px;">

            </table>
        </div>
        <div id="mapcontainer" class="col-md-8" >
            <div  id="map" style="height: 400pt;width: 80%">
                <%--<div id="map">--%>
                <%--</div>--%>
            </div>
        </div>

    </div>

    <div id="print" style="width: 1500px;height:600px;"></div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <div>
        <hr size="5px">
        <h3>准确率：</h3>
        <p id="auc" style="font-size:20px;"></p>
        <hr size="5px">
        <h3>实际值与预测值（左为实际值）：</h3>
        <table class="table table-hover table-font" id = "result"></table>
    </div>



</div>

<div class="modal fade" id="addExcel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">设置文件与参数</h4>
            </div>
            <div class="modal-body">



                <div class="form-group">
                    <label for="target">待预测目标向量(target)</label>
                    <textarea class="form-control" id="target" placeholder="target" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="prediction">所有特征向量(prediction)</label>
                    <textarea class="form-control" id="prediction" placeholder="prediction" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="features">特征向量数量(features)</label>
                    <textarea class="form-control" id="features" placeholder="features" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="passes">复核次数(passes)</label>
                    <input class="form-control" id="passes" placeholder="passes"/>
                </div>
                <div class="form-group">
                    <label for="rate">初始学习率(rate)</label>
                    <input class="form-control" id="rate" placeholder="rate"/>
                </div>

                <div class="form-group">
                    <label>训练csv</label>
                    <input id="trainfileId" type="file" name="trainfile" multiple class="file" data-upload-url="algorithm/uploadlogisticTrain"
                           data-file-upload-preview="text" data-min-file-count="1" data-show-preview="false">
                </div>

                <div class="form-group">
                    <label>待遇测csv</label>
                    <input id="testfileId" type="file" name="testfile" multiple class="file" data-upload-url="algorithm/uploadlogisticTest"
                           data-file-upload-preview="text" data-min-file-count="1" data-show-preview="false">
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="nofile" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行填充操作.
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="errorTag" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                 <%--提交按钮接入到cmd_logisticcheck()中，并且需要更改js逻辑--%>
                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="cmd_logisticcheck()">提交</button>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    /**
     * 添加算法提交
     */
    // var map = L.map("map", {
    //     minZoom: 0,
    //     maxZoom: 14
    // });
    // map.setView([39.467098, 117.004395], 12);
    // // map.setView([117.014, 39.495], 10);
    // map.setZoom(12);
    // // var map = L.map('map').setView([117.014,39.495],2);
    // // 			var map = L.map('map').setView([37.71, -99.88], 4);
    // // 			L.esri.basemapLayer('Gray').addTo(map);
    //
    // L.esri.dynamicMapLayer({
    //     // url: 'https://services.arcgisonline.com/arcgis/rest/services/Specialty/Soil_Survey_Map/MapServer',
    //     url: 'http://10.6.121.42:6080/arcgis/rest/services/wuqingxzq/MapServer',
    //     searchFields : ['NAME_3','NAME_1'],
    //
    //     opacity: 0.7
    // }).addTo(map);
    // var mypop = L.popup();
    //
    // var searchControl = L.esri.Geocoding.geosearch({
    //     providers: [
    //         <!-- arcgisOnline, -->
    //         L.esri.Geocoding.mapServiceProvider({
    //             label: 'States and Counties',
    //             url: 'http://10.6.121.42:6080/arcgis/rest/services/wuqingxzq/MapServer',
    //             layers: [1],
    //             searchFields: ['NAME_1', 'NAME_3']
    //         })
    //     ]
    // }).addTo(map);
    //
    // var greenIcon = L.icon({
    //     iconUrl: 'http://10.6.121.42:8080/arcgis_js_api/green.png',
    //
    //     iconSize:     [9, 9], // size of the icon
    //     popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
    // });
    // var redIcon = L.icon({
    //     iconUrl: 'http://10.6.121.42:8080/arcgis_js_api/red.png',
    //
    //     iconSize:     [9, 9], // size of the icon
    //     popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
    // });
    // var orangeIcon = L.icon({
    //     iconUrl: 'http://10.6.121.42:8080/arcgis_js_api/orange.png',
    //
    //     iconSize:     [9, 9], // size of the icon
    //     popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
    // });
    // var yellowIcon = L.icon({
    //     iconUrl: 'http://10.6.121.42:8080/arcgis_js_api/yellow.png',
    //
    //     iconSize:     [9, 9], // size of the icon
    //     popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
    // });
    // var options = {
    //     minWidth : 260
    // };
    //
    // L.marker([39.445842, 117.184682], {icon: redIcon}).addTo(map)
    //     .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>镉含量（mg）:</td><td>0.08mg</td></tr><tr><td>国家标准（mg）</td><td>0.05mg</td></tr><tr><td>比值</td><td>150%</td></tr><tr><td>经度</td><td>117.184682</td></tr><tr><td>纬度:</td><td>39.445842</td></tr></table>',options);


</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>
