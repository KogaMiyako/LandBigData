<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px">
    <div class="col-md-6" style="height: 500px;" id="nowOrganinc">
        <div style="height: 20px;text-align: center;padding-bottom: 60px">
            <h3>种植环境实时监测&emsp;&emsp;</h3>
        </div>
        <div style="height: 160px;">
            <div class="col-md-4" style="text-align: center">
                <h4 style="margin-top: 60px">温度（°C）</h4>
            </div>
            <div class="col-md-8" id="organinc1" style="height: 100%"></div>
        </div>
        <div style="height: 160px;">
            <div class="col-md-4" style="text-align: center">
                <h4 style="margin-top: 60px">湿度（体积含水量）</h4>
            </div>
            <div class="col-md-8" id="organinc2" style="height: 100%"></div>
        </div>
        <div style="height: 160px;">
            <div class="col-md-4" style="text-align: center">
                <h4 style="margin-top: 60px">酸碱度（pH）</h4>
            </div>
            <div class="col-md-8" id="organinc3" style="height: 100%"></div>
        </div>
    </div>
    <div class="col-md-6" style="height: 500px;">
        <div style="height: 20px; text-align: center;padding-bottom: 60px">
            <h3>土壤土质监测</h3>
        </div>
        <div id="lineChart" style="height: 400px;width: 100%;">

        </div>
    </div>
</div>

<%--<script>
    function getOrganic(){
        $.ajax({
            url:'soilSample/getOrganic',
            type:'POST',
            dataType:'json',
            contentType:'application/json; charset=utf-8',
            success(data){
                console.log(data)
            },
            error(data){

            }

        })

    }
</script>--%>

<script>

    var organdata = {
        organ1: 24,
        organ2: 51.6,
        organ3: 6.8
    };

    /*$.ajax({
        url:'soilSample/getOrganic',
        type:'POST',
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        async:false,
        success(data){
            // console.log(data)
            organdata = data;
        },
        error(data){
            organdata = {
                organ1: 70,
                organ2: 70,
                organ3: 70
            }
        }

    })*/


    var chartDom = document.getElementById('organinc1');
    var myChart = echarts.init(chartDom);
    var option2;

    option2 = {
        series: [
            {
                type: 'gauge',
                progress: {
                    show: true,
                    width: 8
                },
                axisLine: {
                    lineStyle: {
                        width: 8,
                        color:[[1,'#a83834']]
                    }
                },
                axisTick: {
                    show: false
                },
                splitLine: {
                    length: 5,
                    lineStyle: {
                        width: 2,
                        color: '#999'
                    }
                },
                axisLabel: {
                    distance: 5,
                    color: '#999',
                    fontSize: 7
                },
                anchor: {
                    show: true,
                    showAbove: true,
                    size: 10,
                    itemStyle: {
                        borderWidth: 10
                    }
                },
                pointer:{
                    width:3
                },
                // itemStyle:  {
                //     color:'black'
                // },
                title: {
                    show: false
                },
                detail: {
                    valueAnimation: true,
                    fontSize: 15,
                    offsetCenter: [0, '70%']
                },
                data: [
                    {
                        //zlx
                        value: organdata.organ1
                    }
                ],
                max:40
            }
        ],
        tooltip: {
            formatter: '温度：{c}（°C）'
        },
    };

    option2 && myChart.setOption(option2);

</script>

<script>
    var chartDom = document.getElementById('organinc2');
    var myChart = echarts.init(chartDom);
    var option2;

    option2 = {
        series: [
            {
                type: 'gauge',
                progress: {
                    show: true,
                    width: 8
                },
                axisLine: {
                    lineStyle: {
                        width: 8,
                        color:[[1,'#394754']]
                    }
                },
                axisTick: {
                    show: false
                },
                splitLine: {
                    length: 5,
                    lineStyle: {
                        width: 2,
                        color: '#999'
                    }
                },
                axisLabel: {
                    distance: 5,
                    color: '#999',
                    fontSize: 7
                },
                anchor: {
                    show: true,
                    showAbove: true,
                    size: 10,
                    itemStyle: {
                        borderWidth: 10
                    }
                },
                pointer:{
                    width:3
                },
                // itemStyle:  {
                //     color:'black'
                // },
                title: {
                    show: false
                },
                detail: {
                    valueAnimation: true,
                    fontSize: 15,
                    offsetCenter: [0, '70%']
                },
                data: [
                    {
                        // zlx
                        value: organdata.organ2
                    }
                ],
                min:30,
                max:80
            }
        ],
        tooltip: {
            formatter: '湿度：{c}%'
        },
    };

    option2 && myChart.setOption(option2);

</script>

<script>
    var chartDom = document.getElementById('organinc3');
    var myChart = echarts.init(chartDom);
    var option2;

    option2 = {
        series: [
            {
                type: 'gauge',
                progress: {
                    show: true,
                    width: 8
                },
                axisLine: {
                    lineStyle: {
                        width: 8,
                        color:[[1,'#779fa7']]
                    }
                },
                axisTick: {
                    show: false
                },
                splitLine: {
                    length: 5,
                    lineStyle: {
                        width: 2,
                        color: '#999'
                    }
                },
                axisLabel: {
                    distance: 5,
                    color: '#999',
                    fontSize: 7
                },
                anchor: {
                    show: true,
                    showAbove: true,
                    size: 10,
                    itemStyle: {
                        borderWidth: 10
                    }
                },
                pointer:{
                    width:3
                },
                // itemStyle:  {
                //     color:'black'
                // },
                title: {
                    show: false
                },
                detail: {
                    valueAnimation: true,
                    fontSize: 15,
                    offsetCenter: [0, '70%']
                },
                data: [
                    {
                        // zlx
                        value: organdata.organ3
                    }
                ],
                min:0,
                max:14
            }
        ],
        tooltip: {
            formatter: '酸碱度：{c}'
        },
    };

    option2 && myChart.setOption(option2);

</script>

<script>

    const lineChart = echarts.init(document.getElementById('lineChart'))

    // 数据1
    const data1 = [93, 91, 92, 94, 97, 95, 90];
    // 数据2
    const data2 = [43, 42, 45, 41, 39, 40, 44];
    // 数据3
    const data3 = [32, 30, 33, 34, 31, 35, 30];

    // ECharts 选项
    const option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['Zn', 'Ni', 'Cu']
        },
        xAxis: {
            type: 'category',
            data: ['0时', '4时', '8时', '12时', '16时', '20时', '24时']
        },
        yAxis: {
            type: 'value'
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
            name: 'Zn元素含量',
            type: 'line',
            data: data1,
            itemStyle: {
                color: '#5470c6'
            },
            lineStyle: {
                width: 2
            },
            symbolSize: 8
        }, {
            name: 'Ni元素含量',
            type: 'line',
            data: data2,
            itemStyle: {
                color: '#91cc75'
            },
            lineStyle: {
                width: 2
            },
            symbolSize: 8
        }, {
            name: 'Cu元素含量',
            type: 'line',
            data: data3,
            itemStyle: {
                color: '#fac858'
            },
            lineStyle: {
                width: 2
            },
            symbolSize: 8
        }]
    };

    lineChart.setOption(option);

</script>
