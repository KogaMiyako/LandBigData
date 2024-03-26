<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href="${pageContext.request.contextPath}/assets/css/pages/fileinput.css" media="all" rel="stylesheet"
      type="text/css"/>
<link href="${pageContext.request.contextPath}/assets/css/loading.css" media="all" rel="stylesheet"
      type="text/css"/>
<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

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
        <tr id="box" hidden="true">
            <td>
                <div class="text-center" id="fixBox">
                    <img src="${pageContext.request.contextPath}/assets/img/node/1.png" style="margin-top: 8px"/>修复
                </div>
            </td>
            <td id="download" hidden="true">
                <div class="text-center" id="downloadBox">
                    <img src="${pageContext.request.contextPath}/assets/img/node/2.png" style="margin-top: 8px"/>下载
                </div>
            </td>
        </tr>
    </table>

    <table class="table table-hover table-font" id = "ex">
        <tr>
            <td ><div id="pH" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Cr" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Ni" style="width: 400px;height:400px;"></div></td>
        </tr>
        <tr>
            <td ><div id="Cu" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Zn" style="width: 400px;height:400px;"></div></td>
            <td ><div id="As" style="width: 400px;height:400px;"></div></td>
        </tr>
        <tr>
            <td ><div id="Cd" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Hg" style="width: 400px;height:400px;"></div></td>
            <td ><div id="Pb" style="width: 400px;height:400px;"></div></td>
        </tr>
    </table>

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
            <%--var alg={--%>
                <%--classId:${cls.classId},--%>
                <%--className:"${cls.className}"--%>
            <%--};--%>
            $.ajax({
                type:'POST',
                url:'dataClean/addBox',
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
                                top: 1,
                                right: 1,
                                precision: 1,
                                pieces: [{
                                    gt: 0,
                                    lte: value['level1'],
                                    color: '#d60f17'
                                }, {
                                    gt: value['level1'],
                                    lte: value['level2'],
                                    color: '#ffde33'
                                }, {
                                    gt: value['level2'],
                                    lte: value['level3'],
                                    color: '#096'
                                }, {
                                    gt: value['level3'],
                                    lte: value['level4'],
                                    color: '#ffde33'
                                }, {
                                    gt: value['level4'],
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
                                        yAxis: value['level1']
                                    }, {
                                        yAxis: value['level2']
                                    }, {
                                        yAxis: value['level3']
                                    }, {
                                        yAxis: value['level4']
                                    }]
                                }
                            }
                        };
                        myChart1.setOption(option);
                    });
                    $('#box').removeAttr('hidden');
                },
                error:function (data) {
                    $('#addExcelFailed').removeAttr('hidden');
                }
            });


    });
    $('#fixBox').click(function(){

            <%--var alg={--%>
            <%--classId:${cls.classId},--%>
            <%--className:"${cls.className}"--%>
            <%--};--%>
        $.ajax({
            type:'POST',
            url:'dataClean/fixBox',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            async:true,
            success:function(data){
                alert(data['errormsg']);
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
                            top: 1,
                            right: 1,
                            precision: 1,
                            pieces: [{
                                gt: 0,
                                lte: value['level1'],
                                color: '#d60f17'
                            }, {
                                gt: value['level1'],
                                lte: value['level2'],
                                color: '#ffde33'
                            }, {
                                gt: value['level2'],
                                lte: value['level3'],
                                color: '#096'
                            }, {
                                gt: value['level3'],
                                lte: value['level4'],
                                color: '#ffde33'
                            }, {
                                gt: value['level4'],
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
                                    yAxis: value['level1']
                                }, {
                                    yAxis: value['level2']
                                }, {
                                    yAxis: value['level3']
                                }, {
                                    yAxis: value['level4']
                                }]
                            }
                        }
                    }
                    myChart1.setOption(option);
                });
                $('#download').removeAttr('hidden');
            },
            error:function (data) {
            }
        });
    });

    $('#addAlg').click(function(){
        $('#box').attr("hidden","true");
        $('#download').attr("hidden","true");
    });
    $('#downloadBox').click(function(){
        window.open(url="http://localhost:8088/landbigdata/dataClean/downloadFixedExcel");
    });
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js" type="text/javascript"></script>
