<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>
<script src="${pageContext.request.contextPath}/app/js/jquery.js"></script>
<%--<script src="${pageContext.request.contextPath}/app/js/jquery.SuperSlide.2.1.1.js"></script>--%>


<body>
<div>
    <div style="margin-top: 10px">
        <div class="panel panel-danger table-font">
            <!-- Default panel contents -->
            <div class="panel-heading">${algorithm.algorithmName} - al26</div>
            <div class="panel-body">
                ${algorithm.algorithmTip}
            </div>
        </div>
    </div>


    <div class="form-group">
        <input type="file" name="al1_1File" id="al1_1File" multiple class="file" data-upload-url="team/uploadAl1_1"
               data-preview-file-type="text">
    </div>


    <div class="input-group" id="cmdDiv">
        <%--<input type="text" class="form-control" placeholder="Command" id="command">--%>
        <label class="label-default" style="width :744px"> </label>
          <span class="input-group-btn">
            <button type="button" class="btn btn-success" data-dismiss="modal" id="runButton">执行命令</button>
          </span>
    </div>

    <h3 id="h1" hidden="true">各项金属指标</h3>
    <table class="table table-hover table-font" id = "ex">

        <tr>
            <td ><div id="Cd" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Hg" style="width: 400px;height:400px;"></div></td>
            <td ><div id="As" style="width: 400px;height:400px;"></div></td>
        </tr>
        <tr>
            <td ><div id="Pb" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Cr" style="width: 400px;height:400px;"></div></td>
        </tr>

    </table>
    <div class="alert alert-danger alert-dismissible" role="alert" id="nofile" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 未检测到上传文件.请您先上传文件，后执行命令.如果文件已存在，请以#开始命令
    </div>
    <div class="alert alert-danger alert-dismissible" role="alert" id="nomatch" hidden>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                aria-hidden="true">&times;</span></button>
        <strong>Error!</strong> 您输入的命令存在问题,请按照输入规则检查后重试.
    </div>

</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" data-backdrop="static">
    <div class="modal-dialog" role="document">
        <div class="modal-content" id="modal">
            <div class="modal-header input-group">
                <h4 class="modal-title" id="myModalLabel">输出日志</h4>
                <span class="input-group-btn">
                    <button type="button" class="btn btn-primary" id="saveLog">Save</button>
                    <button type="button" class="btn btn-primary" id="next" disabled>Next</button>
                    <button type="button" class="btn btn-primary" id="close">Close</button>
                </span>
            </div>
            <script type="text/javascript">
                $('#saveLog').click(function () {
                    var cmd = $('#command').val();
                    var arr = cmd.split(/[ ]+/);
                    var lastStr = arr[arr.length - 1];
                    alert(lastStr);
                    window.open(url="http://localhost:8080/landbigdata/file/download?fileName="+lastStr);
                });
                $('#close').click(function () {
                    console.log('hidden');
                $('.modal-backdrop').css('display','none');
                    $('#modal').hide();
                    $('#myModal').css('display','none');
                });
            </script>
            <div class="modal-body" style="height:auto;width: auto;background-color: #2e2e2e;">
                <div id="modelLog" style="color: #FFFFFF">

                </div>
            </div>
            <%--<div class="modal-footer">--%>

            <%--</div>--%>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">

    $('#runButton').click(function(){
        var alg={
            classId:"2",
            className:"1"
        };
        $.ajax({
            type:'POST',
            url:'team/team1/al1',
            data:JSON.stringify(alg),
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            async:true,
            success:function(data){
                alert(data['addStatus']);
                var obj1=FastJson.format(data);
                $.each(obj1['result'],function(n,value) {
                    var myChart1 = echarts.init(document.getElementById(value['name']));
                    option = {
                        title: {
                            text: value['name']
                        },
                        tooltip: {
                            trigger: 'axis'
                        },
                        xAxis: {
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
                            precision: 2,
                            pieces: [{
                                lte: value['score'][2],
                                color:'#d60f17'
                            },{
                                gt: value['score'][2],
                                lte: value['score'][1],
                                color:'#d66e2b'
                            }, {
                                gt: value['score'][1],
                                lte: value['score'][0],
                                color: '#ffde33'
                            }, {
                                gt: value['score'][0],
                                color: '#096'
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
                    };
                    myChart1.setOption(option);
                });
            },
            error:function (data) {
                $('#addExcelFailed').removeAttr('hidden');
            }
        });
    });
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"

        type="text/javascript"></script>


