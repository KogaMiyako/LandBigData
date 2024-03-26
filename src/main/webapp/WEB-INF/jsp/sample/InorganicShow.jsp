<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>
<div class="row" style="margin-top: 30px">
    <div class="col-md-8" style="height: 500px;" id="mainOrganinc"></div>
    <div class="col-md-4" style="height: 500px;" id="nowOrganinc">
        <div style="height: 20px;">
            <h3>平均元素量</h3>
        </div>
        <div style="height: 160px;">
            <div class="col-md-3">
                <h4 style="margin-top: 60px">Ni（mg/kg）</h4>
            </div>
            <div class="col-md-9" id="organinc1" style="height: 100%"></div>
        </div>
        <div style="height: 160px;">
            <div class="col-md-3">
                <h4 style="margin-top: 60px">Cu（mg/kg）</h4>
            </div>
            <div class="col-md-9" id="organinc2" style="height: 100%"></div>
        </div>
        <div style="height: 160px;">
            <div class="col-md-3">
                <h4 style="margin-top: 60px">Zn（mg/kg）</h4>
            </div>
            <div class="col-md-9" id="organinc3" style="height: 100%"></div>
        </div>
    </div>
</div>

<script>
    function getOrganic(){
        $.ajax({
            url:'soilSample/getFiveMetal',
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
</script>

<script>

    var newFiveData = {}

    $.ajax({
        url:'soilSample/getFiveMetal',
        type:'POST',
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        async:false,
        success(data){
            // console.log(data)
            newFiveData = data;
        },
        error(data){
        }

    })

    var app = {};

    var chartDom = document.getElementById('mainOrganinc');
    var myChart = echarts.init(chartDom);
    var option;

    const posList = [
        'left',
        'right',
        'top',
        'bottom',
        'inside',
        'insideTop',
        'insideLeft',
        'insideRight',
        'insideBottom',
        'insideTopLeft',
        'insideTopRight',
        'insideBottomLeft',
        'insideBottomRight'
    ];
    app.configParameters = {
        rotate: {
            min: -90,
            max: 90
        },
        align: {
            options: {
                left: 'left',
                center: 'center',
                right: 'right'
            }
        },
        verticalAlign: {
            options: {
                top: 'top',
                middle: 'middle',
                bottom: 'bottom'
            }
        },
        position: {
            options: posList.reduce(function (map, pos) {
                map[pos] = pos;
                return map;
            }, {})
        },
        distance: {
            min: 0,
            max: 100
        }
    };
    app.config = {
        rotate: 0,
        align: 'center',
        verticalAlign: 'top',
        position: 'top',
        distance: 15,
        onChange: function () {
            const labelOption = {
                rotate: app.config.rotate,
                align: app.config.align,
                verticalAlign: app.config.verticalAlign,
                position: app.config.position,
                distance: app.config.distance
            };
            myChart.setOption({
                series: [
                    {
                        label: labelOption
                    },
                    {
                        label: labelOption
                    },
                    {
                        label: labelOption
                    },

                ],

            });
        }
    };
    const labelOption = {
        show: true,
        position: app.config.position,
        distance: app.config.distance,
        align: app.config.align,
        verticalAlign: app.config.verticalAlign,
        rotate: app.config.rotate,
        formatter: '{c}',
        fontSize: 14,
        rich: {
            name: {}
        }
    };
    option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow'
            }
        },
        legend: {
            data: ['Ni', 'Cu', 'Zn']
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
        xAxis: [
            {
                type: 'category',
                axisTick: { show: false },
                data: ['采样t1', '采样t2', '采样t3', '采样t4', '采样t5']
            }
        ],
        yAxis: [
            {
                type: 'value',
                min:20,
                max:100
            }
        ],
        series: [
            {
                name: 'Ni',
                type: 'bar',
                barGap: 0,
                label: labelOption,
                emphasis: {
                    focus: 'series'
                },
                data: newFiveData.metal1
            },
            {
                name: 'Cu',
                type: 'bar',
                label: labelOption,
                emphasis: {
                    focus: 'series'
                },
                data: newFiveData.metal2
            },
            {
                name: 'Zn',
                type: 'bar',
                label: labelOption,
                emphasis: {
                    focus: 'series'
                },
                data: newFiveData.metal3
            },

        ]
    };

    option && myChart.setOption(option);

</script>

<script>

    var newMetalData = {
        metal1: 70,
        metal2: 70,
        metal3: 70
    };

    $.ajax({
        url:'soilSample/getNewMetal',
        type:'POST',
        dataType:'json',
        contentType:'application/json; charset=utf-8',
        async:false,
        success(data){
            // console.log(data)
            newMetalData = data;
        },
        error(data){
            newMetalData = {
                metal1: 70,
                metal2: 70,
                metal3: 70
            }
        }

    })
    
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
                        value: newMetalData.metal1
                    }
                ],
                min:20,
                max:70
            }
        ],
        tooltip: {
            formatter: 'Ni：{c}（mg/kg）'
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
                        value: newMetalData.metal2
                    }
                ],
                min:10,
                max:50
            }
        ],
        tooltip: {
            formatter: 'Cu：{c}（mg/kg）'
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
                        value: newMetalData.metal3
                    }
                ],
                min:50,
                max:130
            }
        ],
        tooltip: {
            formatter: 'Ni：{c}（mg/kg）'
        },
    };

    option2 && myChart.setOption(option2);

</script>