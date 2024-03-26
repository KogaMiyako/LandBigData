<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px;">
        <div class="col-md-6">
            <h2 style="text-align: center; margin-bottom: 20px">点位坐标优化前后对比</h2>
            <div id="site-select-res" style="text-align: center;height: 400px;width: 100%;">
<%--                <img src="${pageContext.request.contextPath}/assets/img/soil/pic.png" style="text-align: center">--%>
            </div>
        </div>
        <div class="col-md-6">
            <h2 style="text-align: center">选址算法评价指标（内梅罗污染指数）</h2>
            <h3>&emsp;&emsp;内梅罗指数反映了各污染物对土壤的作用，同时突出了高浓度污染物对土壤环境质量的影响，可按内梅罗污染指数，划定污染等级。计算指标如下公式：</h3>
            <math xmlns="http://www.w3.org/1998/Math/MathML" display="block" style="font-size: 25px;margin-bottom: 20px;margin-top: 20px;">
                <mrow data-mjx-texclass="INNER"><mo data-mjx-texclass="OPEN">(</mo><msub><mrow><mi mathvariant="normal">P</mi></mrow><mrow><mi>N</mi></mrow></msub><mo data-mjx-texclass="CLOSE">)</mo></mrow><mo>=</mo><mrow data-mjx-texclass="INNER"><mo data-mjx-texclass="OPEN">{</mo><msup><mrow data-mjx-texclass="INNER"><mo data-mjx-texclass="OPEN">[</mo><mrow data-mjx-texclass="INNER"><mo data-mjx-texclass="OPEN">(</mo><msub><mrow><mi mathvariant="normal">P</mi><mi mathvariant="normal">I</mi></mrow><mrow><mtext>均&nbsp;</mtext></mrow></msub><msup><mrow></mrow><mrow><mn>2</mn></mrow></msup><mo data-mjx-texclass="CLOSE">)</mo></mrow><mo>+</mo><mrow data-mjx-texclass="INNER"><mo data-mjx-texclass="OPEN">(</mo><msub><mrow><mi mathvariant="normal">P</mi><mi mathvariant="normal">I</mi></mrow><mrow><mtext>最大&nbsp;</mtext></mrow></msub><msup><mrow></mrow><mrow><mn>2</mn></mrow></msup><mo data-mjx-texclass="CLOSE">]</mo></mrow><mrow><mo>/</mo></mrow><mn>2</mn><mo data-mjx-texclass="CLOSE">}</mo></mrow><mrow><mn>1</mn><mrow><mo>/</mo></mrow><mn>2</mn></mrow></msup><mo data-mjx-texclass="CLOSE" fence="true" stretchy="true" symmetric="true"></mo></mrow>
            </math>
            <div id="site-ana-res">
                <h3>点位优化前指数：</h3>
                <h3>点位优化后指数：</h3>
                <h3>点位优化率：</h3>
                <h3>指数代表率：</h3>
            </div>

        </div>
</div>

<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('site-select-res'));
    myChart.showLoading({
        text: "数据计算中...",
        color: "#3174F2",
        textColor: "#000000",
        maskColor: "rgba(255, 255, 255, 0.8)",
        zlevel: 0,
    });

    $.ajax({
        url:'soilAlg/siteSelectData2',
        type:'POST',
        async:true,
        success(data){

            console.log('ajax post success')
            FastJson.format(data);
            console.log(data)

            let data_x = data['data_x']
            let data_y = data['data_y']

            const data_merge = data_x.map((x, index) => [x, data_y[index]]);

            let data_old_x = data['data_old_x']
            let data_old_y = data['data_old_y']

            const data_old_merge = data_old_x.map((x, index) => [x, data_old_y[index]]);

            console.log(data_merge);

            option = {
                /*title: {
                    text: '点位坐标优化前后对比',
                    x: 'center',
                    y: 'top',
                    top: '10%'
                },*/
                tooltip: {
                    trigger: 'axis',

                },
                legend: {
                    data: ['优化前', '优化后'],
                    selected: {
                        '优化前': false,
                        '优化后': true
                    }
                },
                xAxis: {
                    type: 'value',
                    min: Math.min.apply(null, data_old_x), // 设置最小值为横坐标数组中的最小值
                    max: Math.max.apply(null, data_old_x), // 设置最大值为横坐标数组中的最大值
                    splitLine: {
                        lineStyle: {
                            type: 'dashed'
                        }
                    },
                    axisLabel: {
                        formatter: function (value, index) {
                            return value.toFixed(2); // 将坐标轴标签格式化为1位小数
                        }
                    },
                    name: '经度'
                },
                yAxis: {
                    type: 'value',
                    min: Math.min.apply(null, data_old_y), // 设置最小值为纵坐标数组中的最小值
                    max: Math.max.apply(null, data_old_y), // 设置最大值为纵坐标数组中的最大值
                    splitLine: {
                        lineStyle: {
                            type: 'dashed'
                        }
                    },
                    axisLabel: {
                        formatter: function (value, index) {
                            return value.toFixed(2); // 将坐标轴标签格式化为1位小数
                        }
                    },
                    name: '纬度'
                },

                series: [{
                    name: '优化前',
                    data: data_old_merge,
                    type: 'scatter',
                    symbolSize: 10,
                    itemStyle: {
                        color: '#FF0000' // 设置散点的颜色
                    }
                }, {
                    name: '优化后',
                    data: data_merge,
                    type: 'scatter',
                    symbolSize: 10,
                    itemStyle: {
                        color: '#00FF00' // 设置散点的颜色
                    }
                }]
            };
            myChart.hideLoading();
            myChart.setOption(option);



            ana_res = document.getElementById('site-ana-res')
            let eval_res_old = data['eval_res_old']
            let eval_res = data['eval_res']
            let position_opt_per = ((48-25) / 48).toFixed(3)
            let res_opt_per = Math.abs((eval_res_old - eval_res) / eval_res_old).toFixed(3)

            ana_res.innerHTML = `
                <div id="site-ana-res">
                    <h3>点位优化前指数：`+ eval_res_old.toFixed(3) +`%</h3>
                    <h3>点位优化后指数：`+ eval_res.toFixed(3) +`%</h3>
                    <h3>点位优化率：`+ position_opt_per +`%</h3>
                    <h3>内梅罗污染指数误差率：`+ res_opt_per +`%</h3>
                </div>
            `
        },
        error(data){
            alert('加载数据失败')
        }
    })


</script>