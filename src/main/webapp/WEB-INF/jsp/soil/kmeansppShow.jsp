<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px;">
        <div class="col-md-6">
            <h2 style="text-align: center">KMeans++结果</h2>
            <%--<div style="text-align: center">
                <img src="${pageContext.request.contextPath}/assets/img/soil/pic.png" style="text-align: center">
            </div>--%>
            <div id="KmeansRes" style="padding-top: 30px;text-align: center"></div>
        </div>
        <div class="col-md-6">
            <h2 style="text-align: center">KMeans++介绍</h2>
            <h3 style="margin-top: 25px">&emsp;&emsp; K-means算法是最为经典的基于划分的聚类方法，是十大经典 数据挖掘算法之一。K-means算法的基本思想是：
                以空间中k个点为中心进行聚类，对最靠近他们的对象归类。通过迭代的方法，逐次更新各聚类中心的值，直至得到最好的聚类结果。</h3>
                <h3>&emsp;&emsp; Kmeans++，仅从名字也可以看出它就是Kmeans聚类算法的改进版。
                    Kmeans++在初始化簇中心时的方法总结成一句话就是：逐个选取 k个簇中心，且离其它簇中心越远的样本点越有可能被选为下一个簇中心。
                    </h3>


        </div>
</div>

<script>
    $.ajax({
        url:'soilAlg/kMeansRes',
        type:'POST',
        async:true,
        success(data3){
            FastJson.format(data3);

            console.log(data3)

            var centers = data3['centers']
            var dim = data3['dim']
            var cluster = data3['cluster']

            var res = ''
            for (var i=0;i<cluster;i++){
                res += '<h4>center ' + (i+1) + ': '
                for (var j=0;j<dim;j++){
                    res += centers[i][j].toFixed(3) + ' '
                }
                res += '</h4>'
            }

            document.getElementById('KmeansRes').innerHTML = res


        },
        error(data3){
            alert("加载数据失败3")
        }
    })
</script>

