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
            <div class="panel-heading">${algorithm.algorithmName}</div>
            <div class="panel-body">
                ${algorithm.algorithmTip}
            </div>
        </div>
    </div>
    <table class="table table-hover table-font">
        <tr>
            <div class="text-center" id="addAlg" data-toggle="modal" data-target="#addExcel">
                <img src="${pageContext.request.contextPath}/assets/img/node/add_32.png" style="margin-top: 8px"/>
            </div>
        </tr>
    </table>
    <div class="modal fade" id="addExcel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">模型自变量</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group">
                        <label for="temperature">土壤温度x（℃）</label>
                        <textarea class="form-control" id="temperature" placeholder="temperature" style="height: 50px"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="ozone">臭氧浓度y（μg/m2）</label>
                        <textarea class="form-control" id="ozone" placeholder="ozone" style="height: 50px"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="Hg">大气Hg浓度z（ng/m2）</label>
                        <textarea class="form-control" id="Hg" placeholder="Hg" style="height: 50px"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <%--提交按钮接入到cmd_logisticcheck()中，并且需要更改js逻辑--%>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="cmd_al29()">提交</button>
                </div>
            </div>
        </div>
    </div>

    <h3 id="h1" hidden="true">各项金属指标</h3>
    <table class="table table-hover table-font" id = "ex">
        <tr>
            <td ><div id="graph" style="width: 1316px;height:500px;"></div></td>
        </tr>

    </table>

</div>



</body>
<script type="text/javascript">

    function cmd_al29() {
        //判断命令行是否为空，若为空给出提示
        if($('#temperature').attr("value").trim()==""||$('#ozone').attr("value").trim()==""||$('#Hg').attr("value").trim()==""){
            alert("您输入的参数有误，请校验");
        }else{
            //该ajax主要是请求判断文件是否已上传，且对命令进行合法性检查
            $.ajax({
                url:"team/team2/al1",
                type:"POST",
                data:{
                    "temperature": $('#temperature').attr("value"),
                    "ozone": $('#ozone').attr("value"),
                    "Hg": $('#Hg').attr("value"),
                },
                dataType: "text",
                async:true,
                beforeSend: function() {
                },
                success:function(data){
                    //成功请求后对返回数据进行判断
                    var obj=FastJson.format(data);
                    var data = obj['data'];
                    if(!(obj["error"] == null )){
                        alert(obj["error"]);
                    }
                    $('#graph').empty();
                    var myChart1 = echarts.init(document.getElementById("graph"));
                    option = {
                        title:{
                            text:'通量预测模型'
                        },
                        color: ['#3398DB'],
                        tooltip : {
                            trigger: 'axis',
                            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                            }
                        },
                        grid: {
                            left: '20%',
                            // right: '4%',
                            bottom: '3%',
                            width:'1000',
                            // height:'400',
                            containLabel: true
                        },
                        xAxis : [
                            {
                                name:'季节',
                                type : 'category',
                                data : ['春季', '夏季', '秋季', '冬季'],
                                axisTick: {
                                    alignWithLabel: true,

                                }
                            }
                        ],
                        yAxis : [
                            {
                                 name:'估算通量（）'
,                                type : 'value'
                            }
                        ],
                        series : [
                            {
                                name:'数值大小',
                                type:'bar',
                                barWidth: '50%',
                                data:[data[0], data[1], data[2], data[3]]

                            }
                        ]
                    };
                    myChart1.setOption(option);

                },
                error : function(data){
                    var obj=FastJson.format(data);
                    alert(obj['error']);
                    // window.location.href="500";
                }
            });
        }
    }
</script>
<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/assets/plugins/upload/fileinput_locale_zh.js"

        type="text/javascript"></script>


