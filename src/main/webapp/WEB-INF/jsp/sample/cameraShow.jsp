<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
    .carousel-inner{
        overflow: clip;
    }
</style>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px;">
    <div class="col-md-4" style="height: 500px;">
        <div style="text-align: center">
            <h2>污染物检测数量</h2>
            <div id="pollBarChart" style="height: 400px;width: 100%;" disabled="true"></div>
        </div>
    </div>
    <div class="col-md-4" style="height: 500px">
        <div style="text-align: center">
            <h2 id="bar-header">污染物种类占比</h2>
            <div id="pollPieChart" style="height: 400px;width: 100%;"></div>
        </div>
    </div>
    <div class="col-md-4" style="height: 500px">
        <div style="text-align: center">
            <h2>污染物实时识别结果</h2>
        </div>
        <div style="height: 100%;width: 100%;margin-top: 30px;">
            <div class="dumpShow">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="${pageContext.request.contextPath}/assets/img/soil/0121.jpg">
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/assets/img/soil/0180.jpg">
                            <div class="carousel-caption">
                            </div>
                        </div>
                        <div class="item">
                            <img src="${pageContext.request.contextPath}/assets/img/soil/0188.jpg">
                            <div class="carousel-caption">
                            </div>
                        </div>

                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="false"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="false" ></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

    let barChart = echarts.init(document.getElementById('pollBarChart'));

    const data = [8, 7, 8, 8, 7, 9, 9, 15, 36, 53, 15, 27, 53, 111, 75, 104, 103, 81, 52, 17, 8, 9, 7, 8];

    // 指定图表的配置项和数据
    const option = {
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: Array.from({ length: 24 }, (_, i) => i + '时'), // 横轴表示小时数
        },
        yAxis: {
            type: 'value',
            min: 0, // 纵轴最小值为0
            max: 120, // 纵轴最大值为200
        },
        tooltip: {
            trigger: 'axis',

            formatter: function(params) {
                return params[0].name + ': ' + params[0].data;
            }
        },
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                magicType: { show: true, type: ['line', 'bar', 'stack'] },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        series: [{
            data, // 数据
            type: 'line',
            smooth: true, // 平滑曲线
            itemStyle: {
                color: '#009688', // 线条颜色
            },
        }],
    };

    // 使用刚指定的配置项和数据显示图表。
    barChart.setOption(option);
</script>

<%--<script>

    let barChart = echarts.init(document.getElementById('pollBarChart'));

    let barOption = {

        color:['#BA3B2C'],

        tooltip: {
            trigger: 'axis',
            axisPointer: {            // 坐标轴指示器，坐标轴触发有效
                type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            },
            formatter: '{a} <br/>{b} : {c}'
        },
        xAxis: {
            type: 'category',
            data: ['1', '2', '3']
        },
        yAxis: {
            type: 'value',
            min: 0.5,
            max: 0.8
        },
        series: [{
            name:'主要元素相关系数排名',
            data: [0.5, 0.6, 0.7],
            type: 'bar'
        }]
    }

    barChart.setOption(barOption);
</script>--%>

<script>

    let pieChart = echarts.init(document.getElementById('pollPieChart'));

    let pieOption = {
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend:{
            orient: 'horizontal',
            top: '20',
            data: ['塑料（瓶）', '金属（瓶）', '废纸', '口罩', '一次性餐具', '纸巾']
        },
        series:[
            {
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {name: "塑料（瓶）", value: 347},
                    {name: "金属（瓶）", value: 256},
                    {name: "废纸", value: 57},
                    {name: "口罩", value: 96},
                    {name: "一次性餐具", value: 34},
                    {name: "纸巾", value: 46}
                ]
                ,
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    pieChart.setOption(pieOption);
</script>
