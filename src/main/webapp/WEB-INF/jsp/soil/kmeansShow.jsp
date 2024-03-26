<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px;">
        <div class="col-md-6">
            <h2 style="text-align: center">KMeans结果</h2>
            <%--<div style="text-align: center">
                <img src="${pageContext.request.contextPath}/assets/img/soil/pic.png" style="text-align: center">
            </div>--%>
            <div id="KmeansRes" style="padding-top: 30px;text-align: center"></div>
        </div>
        <div class="col-md-6">
            <h2 style="text-align: center">KMeans介绍</h2>
            <h3 style="margin-top: 25px">&emsp;&emsp; K-means算法是最为经典的基于划分的聚类方法，是十大经典 数据挖掘算法之一。K-means算法的基本思想是：
                以空间中k个点为中心进行聚类，对最靠近他们的对象归类。通过迭代的方法，逐次更新各聚类中心的值，直至得到最好的聚类结果。</h3>
                <h3>假设要把样本集分为c个类别，算法描述如下：</h3>
            <h3>（1）适当选择c个类的初始中心；</h3>
            <h3>（2）在第k次迭代中，对任意一个样本，求其到c个中心的距离，将该样本归到距离最短的中心所在的类；</h3>
            <h3>（3）利用均值等方法更新该类的中心值；</h3>
            <h3>（4）对于所有的c个 聚类中心，如果利用（2）（3）的 迭代法更新后，值保持不变，则迭代结束，否则继续迭代。</h3>
            <h3>该算法的最大优势在于简洁和快速。算法的关键在于初始中心的选择和距离公式。 </h3>

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

