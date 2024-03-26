<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="${pageContext.request.contextPath}/app/js/echarts.js"></script>

<div class="row" style="margin-top: 15px;">
    <%--<div class="col-md-3">
        <h2 style="text-align: center">输入图片</h2>
        &lt;%&ndash;        src="${pageContext.request.contextPath}/app/img/temp.jpg"&ndash;%&gt;
        <img src="${pageContext.request.contextPath}/app/temp/${sessionScope.get('fileName')}" style="margin-top: 25px;height: 400px;width: 300px;" id="bin_id"/>
    </div>--%>
    <div class="col-md-6">
        <h2 style="text-align: center">识别结果</h2>
        <div id="res_show" style="height: 500px;">
            <h3 style="margin-top: 200px;text-align: center">计算中...</h3>
        </div>
    </div>
    <div class="col-md-6" >
        <h2 style="text-align: center" >具体分析结果</h2>
        <div style="margin-top: 100px;text-align: center" id="res_txt">
            <h3 style="margin-top: 200px;text-align: center">计算中...</h3>
        </div>
    </div>
</div>



<script>

    function getPollutionStr(num){
        switch (num){
            case 0:
                return '可回收/废纸'
            case 1:
                return '可回收/塑料'
            case 2:
                return '可回收/玻璃'
            case 3:
                return '可回收/金属'
            case 4:
                return '其他垃圾/口罩'
            case 5:
                return '其他垃圾/砖瓦陶瓷'
            case 6:
                return '其他垃圾/一次性餐具'
            case 7:
                return '其他垃圾/纸巾'
            case 8:
                return '厨余垃圾/水果果肉'
            case 9:
                return '厨余垃圾/骨头'
            case 10:
                return '厨余垃圾/菜根菜叶'
            case 11:
                return '厨余垃圾/水果果皮'
            case 12:
                return '有害垃圾/电池'
            case 13:
                return '有害垃圾/灯泡'
            case 14:
                return '有害垃圾/温度计'
            case 15:
                return '有害垃圾/药瓶'
            default:
                return '其他'
        }
    }

    $.ajax({
        url:'soilAlg/clsOneAlgRun2',
        type:'POST',
        async:true,
        success(data1){
            console.log('ajax post success')
            FastJson.format(data1);

            let resTxt = data1['resTxt']
            console.log(resTxt)

            let resHTML = ''
            // process resTxt
            for (let idx=0; idx<resTxt.length; idx++) {
                let item = resTxt[idx]

                console.log(item)
                console.log(idx)
                let pulStr = getPollutionStr(item[0])
                console.log(pulStr)

                resHTML += `
                    <h3> 污染物`+ (idx+1) +`：`+ pulStr +`，准确率：`+ item[1].toFixed(3) +` </h3>
                `
            }

            resHTML += `
                <h3 style="margin-top: 50px;">（点击图像以放大）</h3>
            `

            document.getElementById('res_show').innerHTML = `
               <img src="${pageContext.request.contextPath}/app/temp/${sessionScope.get('fileName')}" style="margin-top: 25px;height:100%;width:100%;" id="image" "/>
            `

            document.getElementById('res_txt').innerHTML = resHTML

            // 获取图片元素和容器元素
            const image = document.getElementById('image');
            const container = image.parentNode;

            // 监听图片的点击事件
            image.addEventListener('click', function() {
                // 创建一个新的 Image 元素，用于显示放大后的图片
                const zoomed = new Image();
                zoomed.src = this.src;
                zoomed.style.maxWidth = '90%';
                zoomed.style.maxHeight = '90%';

                // 创建一个新的容器元素，用于显示放大后的图片
                const zoomedContainer = document.createElement('div');
                zoomedContainer.style.position = 'fixed';
                zoomedContainer.style.top = '0';
                zoomedContainer.style.left = '0';
                zoomedContainer.style.width = '100%';
                zoomedContainer.style.height = '100%';
                zoomedContainer.style.backgroundColor = 'rgba(0, 0, 0, 0.8)';
                zoomedContainer.style.display = 'flex';
                zoomedContainer.style.justifyContent = 'center';
                zoomedContainer.style.alignItems = 'center';
                zoomedContainer.appendChild(zoomed);

                // 将放大后的图片添加到容器中
                document.body.appendChild(zoomedContainer);

                // 监听容器的点击事件，点击容器时关闭放大图片的显示
                zoomedContainer.addEventListener('click', function() {
                    document.body.removeChild(this);
                });
            });

            /*document.getElementById('res_txt').innerHTML = `
                <h3 style="margin-top: 25px">污染物1：塑料瓶，准确率：88.98%</h3>

                <h3 style="margin-top: 25px">污染物2：塑料瓶，准确率：31.98%</h3>
            `*/

        },
        error(){
            alert('加载数据失败！')
        }
    })


</script>

<script>


</script>
