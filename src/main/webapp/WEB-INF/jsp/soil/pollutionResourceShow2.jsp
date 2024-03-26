<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px;">
    <div class="col-md-4" style="height: 500px;">
        <div style="text-align: center">
            <h2>样本污染超标占比</h2>
            <div id="overRatePieChart" style="height: 400px;width: 100%;" disabled="true"></div>
        </div>
    </div>
    <div class="col-md-4" style="height: 500px">
        <div style="text-align: center">
            <h2 id="bar-header">主要元素相关系数排名</h2>
            <div id="relevantElem" style="height: 400px;width: 100%;"></div>
        </div>
    </div>
    <div class="col-md-4" style="height: 500px">
        <div style="text-align: center">
            <h2>污染溯源算法总结</h2>
        </div>
        <div id="resourceShow">
            <h3>主要超标元素：</h3>
            <h3>&emsp;元素主要相关元素：</h3>
            <h3 style="text-align: center">&emsp;（%），&emsp;（%）</h3>
            <h3>污染来源：</h3>
            <h3>该污染源特征：</h3>
            <h4>&emsp;&emsp;&emsp;主要污染元素：Cu，Zn，还有Cr污染等等.............</h4>
        </div>
    </div>
</div>


<script type="text/javascript">

    var myChart = echarts.init(document.getElementById('overRatePieChart'));

    let mainElemName = "";

    myChart.showLoading({
        text: "数据计算中...",
        color: "#3174F2",
        textColor: "#000000",
        maskColor: "rgba(255, 255, 255, 0.8)",
        zlevel: 0,
    });

    // ajax 获得污染占比 前+后 -> async:false 画第一个表
    $.ajax({
        url:'soilAlg/resourcePieData2',
        type:'POST',
        async:true,
        success(data){

            console.log('ajax post success')
            FastJson.format(data);

            console.log(data)

            let get_legend = data['legend']
            let get_data = []
            mainElemName = data['mainElemName']

            for (let key in data['result']){
                get_data.push({
                    value: data['result'][key],
                    name: key
                })
            }


            console.log(get_legend)
            console.log(get_data)
            // 准备数据
            /*let pie_legend = ['Cr', 'Ni', 'As', 'Zn', 'Cu']
            let pie_data = [
                {value: 335, name: 'Cr'},
                {value: 310, name: 'Ni'},
                {value: 234, name: 'As'},
                {value: 135, name: 'Zn'},
                {value: 1548, name: 'Cu'}
            ]*/

            myChart.hideLoading();
            myChart.setOption({
                tooltip: {
                    trigger: 'item',
                    formatter: '{a} <br/>{b} : {c} ({d}%)'
                },
                legend:{
                    orient: 'horizontal',
                    top: '20',
                    data: get_legend
                },
                series:[
                    {
                        name: '重金属元素占比',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: get_data,
                        emphasis: {
                            itemStyle: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            });


            // 加载第二个表数据

            var barChart = echarts.init(document.getElementById('relevantElem'));

            barChart.showLoading({
                text: "数据计算中...",
                color: "#3174F2",
                textColor: "#000000",
                maskColor: "rgba(255, 255, 255, 0.8)",
                zlevel: 0,
            });


            $.ajax({
                url:'soilAlg/resourceBarData2',
                type:'POST',
                async:true,
                success(data2){

                    console.log('ajax post success')
                    FastJson.format(data2);

                    console.log(data2)

                    let x_data = data2['x_data']
                    let y_data = data2['y_data']

                    /*// 准备数据
                    let bar_axis = ['Zn', 'Ni', 'Cr', 'As', 'Cd', 'Hg', 'Pb'];
                    let bar_yxis = [60.6, 59.9, 48.2, 43.1, 33.2, 28.6, 20];*/

                    barChart.hideLoading();
                    barChart.setOption({

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
                            data: x_data
                        },
                        yAxis: {
                            type: 'value',
                            min: 0.5,
                            max: 0.8
                        },
                        series: [{
                            name:'主要元素相关系数排名',
                            data: y_data,
                            type: 'bar'
                        }]
                    });

                    $.ajax({
                        url:'soilAlg/resourceDescribeData2',
                        type:'POST',
                        async:true,
                        data:'mainElem='+ mainElemName+'&elem1='+x_data[0]+'&elem2='+x_data[1],
                        success(data3){
                            FastJson.format(data3);

                            console.log(data3)

                            // 第三部分

                            document.getElementById('resourceShow').innerHTML = `
                            <h3>主要超标元素：`+mainElemName+`</h3>
                            <h3>`+mainElemName+`元素主要相关元素：</h3>
                            <h3 style="text-align: center">`+
                                    x_data[0]
                                    +"("+
                                    (y_data[0] * 100).toFixed(2)
                                    +"%)&emsp;"+
                                    x_data[1]
                                    +"("+
                                    (y_data[1] * 100).toFixed(2)
                                    +"%)"+`</h3>
                            <h3>污染来源：`+data3['sourceName']+`</h3>
                            <h3>该污染源特征：</h3>
                            <h4>&emsp;&emsp;&emsp;`+data3['describe']+`</h4>
                        `

                        },
                        error(data3){
                            alert("加载数据失败3")
                        }
                    })

                },
                error(data2){
                    alert('加载数据失败2')
                }
            })



        },
        error(data){
            alert('加载数据失败1')
        }
    })
    // ajax 获得相关系数数组 前+后 -> async:false 画第二个表和后面的总结

</script>
<script>

    /*var testvar = ${sessionScope.get("mainElemName")};

    setTimeout(fillShow, 2000)

    function fillShow(){
        document.getElementById('resourceShow').innerHTML = `
            <h3>主要超标元素：`+testvar+`</h3>
            <h3>xx元素主要相关元素：</h3>
            <h3 style="text-align: center">Zn（60.6%），Ni（59.9%）</h3>
            <h3>污染来源：实验土壤污染</h3>
            <h3>该污染源特征：</h3>
            <h4>&emsp;&emsp;&emsp;主要污染元素：Cu，Zn，还有Cr污染等等.....1........</h4>
    `
    }*/

</script>


