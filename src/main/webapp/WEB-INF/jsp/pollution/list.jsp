<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/datetimepicker/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/assets/plugins/datetimepicker/bootstrap-datetimepicker.min.js" type="text/javascript" ></script>
<script src="${pageContext.request.contextPath}/assets/plugins/datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js" type="text/javascript" ></script>

<div>
    <div class="text-center" style="padding: 20px">
        <span class="mine-title">
            <img src="${pageContext.request.contextPath}/assets/img/search/search_48.png" style="margin-right: 20px"/>
            <strong>Data Search</strong>
        </span>
    </div>

    <div class="input-group mine-box has-success">
        <input type="text" class="form-control" id="mtext">
        <span class="input-group-btn">
                <button class="btn btn-primary" type="button" style="margin-right: 10px" onclick="text_mine()"><span class="glyphicon glyphicon-search"></span>&nbsp;搜索一下</button>
                <button class="btn btn-primary" type="button" onclick="advanced_mine()">高级搜索</button>
            </span>
    </div>

    <div id="queryresult" class="mine-result-box">

    </div>
</div>

<div class="modal fade" id="advQueryModal" tabindex="-1" role="dialog" aria-labelledby="mySearchModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="mySearchModalLabel">高级搜索</h4>
            </div>
            <div class="modal-body">
                <div class="form-group"><label><strong>标题:</strong></label><input class="form-control" type="text" id="querytitle"/></div>
                <div class="form-group"><label><strong>描述:</strong></label><input class="form-control" type="text" id="querycontent"/></div>
                <div class="form-group"><label><strong>城市:</strong></label><input class="form-control" type="text" id="querycity"/></div>
                <%--<div class="form-group">--%>
                    <%--<div><label><strong>文件类型:</strong></label></div>--%>

                    <%--<label class="radio-inline">全部<input type="radio" value="*" name="contenttype" checked/></label>--%>
                    <%--<label class="radio-inline">PDF<input type="radio" value="pdf" name="contenttype"/></label>--%>
                    <%--<label class="radio-inline">WORD<input type="radio" value="msword" name="contenttype"/></label>--%>
                    <%--<label class="radio-inline">TEXT<input type="radio" value="text" name="contenttype"/></label>--%>

                <%--</div>--%>
                <div class="form-group">
                    <label><strong>日期:</strong></label>

                    <div class="form-group">
                        <label class="control-label">最早提交时间:</label>
                        <span class="input-group date form_datetime" data-date="2016-08-12 00:00:00" data-date-format="yyyy-mm-dd hh:ii:ss">
                            <input class="form-control" id="startdate" size="16" type="text" value="2015-01-01 00:00:00" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label">最晚提交时间:</label>
                        <span class="input-group date form_datetime" data-date="2016-08-12 00:00:00" data-date-format="yyyy-mm-dd hh:ii:ss">
                            <input class="form-control" id="enddate" size="16" type="text" value="2015-01-01 00:00:00" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                        </span>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="advTextMine">搜索</button>
            </div>
        </div>
    </div>
</div>




<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>Algorithm</strong></td>
                <td>${cls.className}</td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>Description</strong></td>
                <td>${cls.classDescribe}</td>
            </tr>
        </table>
    </div>


    <table class="table table-hover table-font">
        <thead>
        <tr>
            <td class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>名称</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span>描述</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-tree-conifer" aria-hidden="true"></span>城市</td>
            <td class="col-lg-2 col-md-2 text-center"><span class="glyphicon glyphicon-time" aria-hidden="true"></span>创建时间</td>
            <td class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-user" aria-hidden="true"></span>创建者</td>
            <td class="col-lg-1 col-md-1 text-center"><span class="glyphicon glyphicon-download" aria-hidden="true"></span>下载</td>
        </tr>
        </thead>
        <tbody id="dataTbody">
        <c:forEach items="${datas}" var="data">
            <tr>
                <td class="col-lg-1 col-md-1 text-center">${data.dataName}</td>
                <td class="col-lg-2 col-md-2 text-center">${data.dataDescribe}</td>
                <td class="col-lg-2 col-md-2 text-center">${data.dataCity}</td>
                <td class="col-lg-2 col-md-2 text-center"><fmt:formatDate value="${data.dataCreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
                <td class="col-lg-1 col-md-1 text-center">${data.dataCreateuser}</td>
                <td class="col-lg-1 col-md-1 text-center"><a class="more" href="javascript:void(0);" onclick="datadownload(this)" value="${data.dataFilename}">下载</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="table table-hover table-font">
        <tr>
            <div class="text-center" id="addAlg" data-toggle="modal" data-target="#addDataModal">
                <img src="${pageContext.request.contextPath}/assets/img/node/add_32.png" style="margin-top: 8px"/>
            </div>
        </tr>
    </table>
</div>

<div>
    <div class="alert alert-success alert-font" role="alert">
        <table>
            <tr>
                <td><strong>污染源</strong></td>
                <td>${plu.pollutionName}</td>
            </tr>
            <tr>
                <td style="vertical-align:top;"><strong>描述</strong></td>
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
        <tbody id="dataTbody1">
        <c:forEach items="${strs}" var="data">
            <tr>
                <td class="col-lg-1 col-md-1 text-center">${data[0]}</td>
                <td class="col-lg-2 col-md-2 text-center">${data[1]}</td>
                <td class="col-lg-2 col-md-2 text-center">${data[2]}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>


<div class="modal fade" id="addDataModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">添加${cls.className}数据</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label for="dataName">数据集名称</label>
                    <input class="form-control" type="text" id="dataName" placeholder="数据集名称"/>
                </div>
                <div class="form-group">
                    <label for="dataDescribe">数据集描述</label>
                    <textarea class="form-control" id="dataDescribe" placeholder="数据集描述" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="dataCity">数据集采集地点</label>
                    <textarea class="form-control" id="dataCity" placeholder="数据集采集地点" style="height: 100px"></textarea>
                </div>
                <div class="form-group">
                    <label for="dataFilename">数据集文件名（请包含后缀,并且保持上传的数据文件与数据文件名保持一致）</label>
                    <textarea class="form-control" id="dataFilename" placeholder="数据集文件名" style="height: 100px"></textarea>
                </div>



                <div class="form-group">
                    <label>数据文件</label>
                    <input id="" type="file" name="file" multiple class="file" data-upload-url="data/upload"
                           data-file-upload-preview="text" data-min-file-count="1" data-show-preview="false">
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="no_upload_file" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行填充操作.
                </div>

                <div class="alert alert-danger alert-dismissible" role="alert" id="addAlgFailed" hidden>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <strong>Error!</strong> 您填写的内容可能为空,请填写后重新提交.
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="addDataSubmit">提交</button>
            </div>
        </div>
    </div>
</div>




<script type="text/javascript">
    function datatooltip(e){
        $.get("data/tooltip?id="+ e.getAttribute("value"), function(rs) {
            document.getElementById("index-page-title").innerHTML="使用说明";
            document.getElementById("page-index").innerHTML+='<li><i class="fa fa-angle-right"></i><a href="">使用说明</a></li>';
            $('#main-content').html(rs);
        });
    }
    function datadownload(e){
        var fileName = e.getAttribute("value");
        alert(fileName);
        window.open(url="http://localhost:8080/landbigdata/data/download?fileName="+fileName);
    }
    /**
     * 添加算法提交
     */
    $('#addDataSubmit').click(function(){
        if($('#dataName').attr("value").trim() == "" || $('#dataDescribe').attr("value").trim() == "" ||
                $('#dataCity').attr("value").trim() == "" || $('#dataFilename').attr("value").trim() == ""){
            $('#addAlgFailed').removeAttr('hidden');
        }else{
            var alg={
                dataName:$('#dataName').attr("value"),
                dataFilename:$('#dataFilename').attr("value"),
                dataCity:$('#dataCity').attr("value"),
                dataDescribe:$('#dataDescribe').attr("value"),
                classId:${cls.classId},
                className:"${cls.className}"
            };
            $.ajax({
                type:'POST',
                url:'data/add',
                data:JSON.stringify(alg),
                dataType:'json',
                contentType:'application/json; charset=utf-8',
                async:true,
                success:function(data){
                    alert(data['addStatus']);
                },
                error:function (data) {
                    $('#addAlgFailed').removeAttr('hidden');
                }
            });
        }

    });
</script>
<script type="text/javascript">


    function text_mine(){
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

    //datetimepicker初始化
    $('.form_datetime').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });

    Date.prototype.format = function (format)
    {
        /*
         * eg:format="YYYY-MM-dd hh:mm:ss";
         */
        var o =
            {
                "M+" : this.getMonth() + 1, // month
                "d+" : this.getDate(), // day
                "h+" : this.getHours(), // hour
                "m+" : this.getMinutes(), // minute
                "s+" : this.getSeconds(), // second
                "q+" : Math.floor((this.getMonth() + 3)  / 3), // quarter
                "S" : this.getMilliseconds() // millisecond
            }
        if (/(y+)/.test(format))
        {
            format = format.replace(RegExp.$1, (this.getFullYear() + "") .substr(4 - RegExp.$1.length));
        }
        for ( var k in o)
        {
            if (new RegExp("(" + k + ")").test(format))
            {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    }

    /**
     *高级查询，多种条件查询
     */
    $('#advTextMine').click(function(e){
        $.post('data/multiSearch',{
            title:$('#querytitle').val(),
            content:$('#querycontent').val(),
            city:$('#querycity').val(),
            // contentType:$('input[name="contenttype"]:checked').val(),
            startDate:$('#startdate').val(),
            endDate:$('#enddate').val(),
            classId:${cls.classId}
        },function(data){
            $('#advQueryModal').modal('toggle');
            if($.trim(data)==""){
                alert("无符合条件内容");
            }else{
                // alert(data);
                $("#dataTbody").empty();
                // var jsonData = JSON.parse(data);
                for(i in data){
                    var jsDate = new Date(data[i].dataCreatetime);
                    var dateStr=jsDate.format("yyyy-MM-dd hh:mm:ss");
                    $("#dataTbody").append("<tr>" +
                        "<td class=\"col-lg-1 col-md-1 text-center\"><a class=\"more\" href=\"javascript:void(0);\" onclick=\"datatooltip(this)\" value=\""+data[i].dataId+"\">"+data[i].dataName+"</a></td>" +
                        "<td class=\"col-lg-2 col-md-2 text-center\">"+data[i].dataDescribe+"</td>" +
                        "<td class=\"col-lg-2 col-md-2 text-center\">"+data[i].dataCity+"</td>" +
                        "<td class=\"col-lg-2 col-md-2 text-center\">"+dateStr+"</td>" +
                        "<td class=\"col-lg-1 col-md-1 text-center\">"+data[i].dataCreateuser+"</td>" +
                        "<td class=\"col-lg-1 col-md-1 text-center\"><a class=\"more\" href=\"javascript:void(0);\" onclick=\"datadownload(this)\" value=\""+data[i].dataFilename+"\">下载</a></td>" +
                        "</tr>");
                }
            }
            $('#mtext').attr("value","");
        });
    });
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"
        type="text/javascript"></script>