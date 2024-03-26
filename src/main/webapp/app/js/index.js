$(function() {
    App.init();

    var Index = (function() {
        var me = {};

        // 处理一级菜单点击
        me.handleMenuClick = function() {
            $('#page-sidebar-menu > li').click(function(e) {

                var menu = $('#page-sidebar-menu');
                var li = menu.find('li.active').removeClass('active');
                //$(this).setAttribute("class","active");
                // 添加选中 打开的样式
                $(this).addClass('active');
            });
        };


        // 处理子菜单点击
        me.handleSubMenuClick = function() {
            $('#page-sidebar-menu li a').click(function(e) {
                e.preventDefault();
                var url = this.href;
                if (url != null && url != 'javascript:;') {
                    $.get(url, function (data) {
                        $('#main-content').html(data);
                        if(url.indexOf("dashboard") == -1){
                            $("#main-navbar").removeAttr("hidden");
                        }else{
                            $("#main-navbar").attr("hidden","hidden");
                        }
                    });
                }
            });
        };


        me.init = function() {
            me.handleMenuClick();
            me.handleSubMenuClick();
        };

        return me;
    })();

    Index.init();
    //dashboard模块被加载的处罚条件
    $('#btn-dashboard').trigger("click");
    // $('#algorithmlib').trigger("click");
//    algorithmlib

});

$('#cluster_app').click(function (e) {
    window.open ('http://192.168.1.99:8088/cluster','集群应用管理','height=500,width=800,top=0,left=0,toolbar=no,scrollbars=no,resizable=no,location=yes,status=no,menubar=no')
});

$('#dfs_health').click(function (e) {
    window.open ('http://192.168.1.99:50070/dfshealth.html','分布式文件系统','height=500,width=800,top=0,left=0,toolbar=no,scrollbars=no,resizable=no,location=yes,status=no,menubar=no')
});



$('#algorithmlib li a').click(function(e) {
    document.getElementById("index-page-title").innerHTML="算法";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">算法库</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">算法</a></li>';
});
$('#resourcelib li a').click(function(e) {
    document.getElementById("index-page-title").innerHTML="资源";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">已上传数据</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">数据</a></li>';
});
$('#dataCleanlib li a').click(function(e) {
    document.getElementById("index-page-title").innerHTML="污染分析";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">污染分析</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">污染分析</a></li>';
});

$('#btn-dashboard').click(function(e){
    document.getElementById("index-page-title").innerHTML="大数据计算";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">首页</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">大数据计算</a></li>';

});

// *****************

$('#pollutionResource').click(function(e){
    $("#main-navbar").removeAttr("hidden");
    document.getElementById("index-page-title").innerHTML="土壤大数据算法";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">土壤大数据算法</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">污染溯源算法</a></li>';
});

$('#siteSelect').click(function(e){
    $("#main-navbar").removeAttr("hidden");
    document.getElementById("index-page-title").innerHTML="土壤大数据算法";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">土壤大数据算法</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">检测选址算法</a></li>';
});

$('#classificationOne').click(function(e){
    $("#main-navbar").removeAttr("hidden");
    document.getElementById("index-page-title").innerHTML="土壤大数据算法";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">土壤大数据算法</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">垃圾分类算法一</a></li>';
});

$('#classificationTwo').click(function(e){
    $("#main-navbar").removeAttr("hidden");
    document.getElementById("index-page-title").innerHTML="土壤大数据算法";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">土壤大数据算法</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">水面污染物识别算法</a></li>';
});

$('.landmore1').click(function(e){
    document.getElementById("index-page-title").innerHTML="开放式景区视图";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">开放式景区视图</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">场景信息</a></li>';
});

$('.landmore2').click(function(e){
    document.getElementById("index-page-title").innerHTML="开放式景区视图";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="main">开放式景区视图</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">数据展示</a></li>';
});

$('#nodelist').click(function(e) {
    document.getElementById("index-page-title").innerHTML="采摘园场景视图";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">采摘园场景视图</a><i class="fa fa-angle-right"></i></li><li><a href="">数据展示</a></li>';
});

$('#clusterinfo').click(function(e) {
    document.getElementById("index-page-title").innerHTML="采摘园场景视图";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">采摘园场景视图</a><i class="fa fa-angle-right"></i></li><li><a href="">场景信息</a></li>';
});

$('#farmInfo').click(function(e) {
    document.getElementById("index-page-title").innerHTML="散户养殖场视图";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">散户养殖场视图</a><i class="fa fa-angle-right"></i></li><li><a href="">场景信息</a></li>';
});

$('#farmShow').click(function(e) {
    document.getElementById("index-page-title").innerHTML="散户养殖场视图";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">散户养殖场视图</a><i class="fa fa-angle-right"></i></li><li><a href="">数据展示</a></li>';
});

$('#infoUpdate').click(function(e) {
    document.getElementById("index-page-title").innerHTML="个人中心";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">个人中心</a><i class="fa fa-angle-right"></i></li><li><a href="">个人信息修改</a></li>';
});

$('#algoHistory').click(function(e) {
    document.getElementById("index-page-title").innerHTML="个人中心";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">个人中心</a><i class="fa fa-angle-right"></i></li><li><a href="">算法历史记录</a></li>';
});

$('#KKKMeans').click(function(e) {
    $("#main-navbar").removeAttr("hidden");
    document.getElementById("index-page-title").innerHTML="大数据基础算法库";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">大数据基础算法库</a><i class="fa fa-angle-right"></i></li><li><a href="">KMeans</a></li>';
});

$('#KKKMeanspp').click(function(e) {
    $("#main-navbar").removeAttr("hidden");
    document.getElementById("index-page-title").innerHTML="大数据基础算法库";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">大数据基础算法库</a><i class="fa fa-angle-right"></i></li><li><a href="">KMeans++</a></li>';
});

$('#report').click(function(e) {
    document.getElementById("index-page-title").innerHTML="个人中心";
    document.getElementById("page-index").innerHTML='<li><i class="fa fa-home"></i><a href="javascript:;">个人中心</a><i class="fa fa-angle-right"></i></li><li><a href="">防控预案信息</a></li>';
});

/**
 * 命令执行关键方法
 */

// zlx: 算法执行函数 param: algMode url
function algRun(algMode, url) {
    // zlx: 先检查该算法下是否上传了文件
    $.ajax({
        url:"soilFile/check?algMode=" + algMode,
        type:"POST",
        success(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);
            //如果判断没有文件，警告框提示
            if(obj["result"]==="noFile"){
                alert("未上传文件或文件格式有误，请重新上传。")
            }else if(obj["result"]==="bothYes"){
                // zlx: 算法及文件一致 运行算法
                // alert("运行算法"+url)
                $.ajax({
                    url: url,
                    type:"POST",
                    success(data){
                        var algRes=FastJson.format(data);
                        // zlx : 测试一下
                        alert(algRes['filePath'] + algMode);

                    }
                })
            }
        }
    })
}

function runKMeans() {

    let cluster = $('#cluster').val()
    let objExp = /^[0-9]*[1-9][0-9]*$/
    if (!objExp.test(cluster)){
        alert('聚类簇数非正整数，请重新输入！')
    }

    // zlx: 先检查该算法下是否上传了文件
    $.ajax({
        url:"soilFile/check2?algMode=11" + '&cluster=' + cluster,
        type:"POST",
        success(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);
            //如果判断没有文件，警告框提示
            if(obj["result"]==="noFile"){
                alert("未上传文件或文件格式有误，请重新上传。")
            }else if(obj["result"]==="bothYes"){
                // zlx: 算法及文件一致 运行算法
                // alert("运行算法"+url)
                $.ajax({
                    url: "soilAlg/kMeans",
                    type:"POST",
                    success(data){
                        var algRes=FastJson.format(data);
                        // zlx : 测试一下
                        // alert(algRes['fileType']);
                        if (algRes['fileType'] === 'txt'){
                            var str1 = "大数据基础算法库"
                            var str2 = "KMeans算法运行结果"
                            document.getElementById("index-page-title").innerHTML=str1;
                            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
                            $.get("soilAlgorithm/kmeansShow", function (data) {
                                $('#main-content').html(data);
                            });
                        }else {
                            alert("文件格式上传错误！仅支持txt格式！")
                        }
                    }
                })
            }
        }
    })
}

function runKMeanspp() {

    let cluster = $('#cluster').val()
    let objExp = /^[0-9]*[1-9][0-9]*$/
    if (!objExp.test(cluster)){
        alert('聚类簇数非正整数，请重新输入！')
    }

    // zlx: 先检查该算法下是否上传了文件
    $.ajax({
        url:"soilFile/check2?algMode=12" + '&cluster=' + cluster,
        type:"POST",
        success(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);
            //如果判断没有文件，警告框提示
            if(obj["result"]==="noFile"){
                alert("未上传文件或文件格式有误，请重新上传。")
            }else if(obj["result"]==="bothYes"){
                // zlx: 算法及文件一致 运行算法
                // alert("运行算法"+url)
                $.ajax({
                    url: "soilAlg/kMeanspp",
                    type:"POST",
                    success(data){
                        var algRes=FastJson.format(data);
                        // zlx : 测试一下
                        // alert(algRes['fileType']);
                        if (algRes['fileType'] === 'txt'){
                            var str1 = "大数据基础算法库"
                            var str2 = "KMeans++算法运行结果"
                            document.getElementById("index-page-title").innerHTML=str1;
                            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
                            $.get("soilAlgorithm/kmeansppShow", function (data) {
                                $('#main-content').html(data);
                            });
                        }else {
                            alert("文件格式上传错误！仅支持txt格式！")
                        }
                    }
                })
            }
        }
    })
}

function runSiteSelect() {

    if (document.getElementById('site-model-select').value === '-1'){
        alert("未选择模型文件，请选择正确的模型文件。")
    }else {
        /*if(false){
            alert("选择模型文件有误，请重新选择。")
        }*/
        // zlx: 先检查该算法下是否上传了文件
        $.ajax({
            url:"soilFile/check?algMode=2",
            type:"POST",
            success(data){
                //成功请求后对返回数据进行判断
                var obj=FastJson.format(data);
                //如果判断没有文件，警告框提示
                if(obj["result"]==="noFile"){
                    alert("未上传文件或文件格式有误，请重新上传。")
                }else if(obj["result"]==="bothYes"){
                    // zlx: 算法及文件一致 运行算法
                    // alert("运行算法"+url)
                    $.ajax({
                        url: "soilAlg/siteSelectAlg",
                        type:"POST",
                        success(data){
                            var algRes=FastJson.format(data);
                            // zlx : 测试一下
                            // alert(algRes['fileType']);
                            if (algRes['fileType'] === 'xlsx' || algRes['fileType'] === 'xls'){
                                var str1 = "土壤大数据算法"
                                var str2 = "检测选址算法运行结果"
                                document.getElementById("index-page-title").innerHTML=str1;
                                document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
                                $.get("soilAlgorithm/siteSelectShow", function (data) {
                                    $('#main-content').html(data);
                                });
                            }else {
                                alert("文件格式上传错误！仅支持xlsx或xls格式！")
                            }
                        }
                    })
                }
            }
        })
    }


}

function runPollutionResource() {

    // zlx:文件上传检查
    $.ajax({
        url:"soilFile/check?algMode=1",
        type:"POST",
        success(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);
            //如果判断没有文件，警告框提示
            if(obj["result"]==="noFile"){
                alert("未上传文件或文件格式有误，请重新上传。")
            }else if(obj["result"]==="bothYes"){
                // zlx: 算法及文件一致 运行算法
                // alert("运行算法"+url)
                $.ajax({
                    url: "soilAlg/resourceAlg",
                    type:"POST",
                    success(data){
                        var algRes=FastJson.format(data);
                        // zlx : 测试一下
                        // alert(algRes['fileType']);
                        if (algRes['fileType'] === 'xlsx' || algRes['fileType'] === 'xls'){
                            var str1 = "土壤大数据算法"
                            var str2 = "污染溯源算法运行结果"
                            document.getElementById("index-page-title").innerHTML=str1;
                            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
                            $.get("soilAlgorithm/pollutionResourceShow", function (data) {
                                $('#main-content').html(data);
                            });
                        }else {
                            alert("文件格式上传错误！仅支持xlsx或xls格式！")
                        }
                    }
                })


            }
        }
    })

    // alert("123")


}

function runClassificationOne(){

    $.ajax({
        url:"soilFile/check?algMode=3",
        type:"POST",
        success(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);
            //如果判断没有文件，警告框提示
            if(obj["result"]==="noFile"){
                alert("未上传文件或文件格式有误，请重新上传。")
            }else if(obj["result"]==="bothYes"){
                // zlx: 算法及文件一致 运行算法
                // alert("运行算法"+url)
                $.ajax({
                    url: "soilAlg/classificationOne",
                    type:"POST",
                    success(data){
                        var algRes=FastJson.format(data);
                        // zlx : 测试一下
                        // alert(algRes['fileType']);
                        if (algRes['fileType'] === 'png' || algRes['fileType'] === 'jpg'|| algRes['fileType'] === 'JPG'|| algRes['fileType'] === 'PNG'){
                            var str1 = "土壤大数据算法"
                            var str2 = "垃圾分类算法一运行结果"
                            document.getElementById("index-page-title").innerHTML=str1;
                            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
                            $.get("soilAlgorithm/classificationOneShow", function (data) {
                                $('#main-content').html(data);
                            });
                        }else {
                            alert("文件格式上传错误！仅支持png或jpg格式！")
                        }
                    }
                })


            }
        }
    })




}

function runClassificationTwo(){

    $.ajax({
        url:"soilFile/check?algMode=4",
        type:"POST",
        success(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);
            //如果判断没有文件，警告框提示
            if(obj["result"]==="noFile"){
                alert("未上传文件或文件格式有误，请重新上传。")
            }else if(obj["result"]==="bothYes"){
                // zlx: 算法及文件一致 运行算法
                // alert("运行算法"+url)
                $.ajax({
                    url: "soilAlg/classificationTwo",
                    type:"POST",
                    success(data){
                        var algRes=FastJson.format(data);
                        // zlx : 测试一下
                        // alert(algRes['fileType']);
                        if (algRes['fileType'] === 'png' || algRes['fileType'] === 'jpg'|| algRes['fileType'] === 'JPG'|| algRes['fileType'] === 'PNG'){
                            var str1 = "土壤大数据算法"
                            var str2 = "水面污染物识别算法运行结果"
                            document.getElementById("index-page-title").innerHTML=str1;
                            document.getElementById("page-index").innerHTML=`<li><i class="fa fa-home"></i><a href="main">`+str1+`</a></li><li><i class="fa fa-angle-right"></i><a href="javascript:void(0);">`+str2+`</a></li>`;
                            $.get("soilAlgorithm/classificationTwoShow", function (data) {
                                $('#main-content').html(data);
                            });
                        }else {
                            alert("文件格式上传错误！仅支持png或jpg格式！")
                        }
                    }
                })


            }
        }
    })



}

function cmd_check() {
    //判断命令行是否为空，若为空给出提示
    if($('#command').attr("value").trim()==""){
        $('#cmdDiv').addClass("has-error");
    }else{
        //该ajax主要是请求判断文件是否已上传，且对命令进行合法性检查
        $.ajax({
            url:"algorithm/check",
            type:"POST",
            data:{
                "command": $('#command').attr("value")
            },
            async:true,
            beforeSend: function() {
            },
            success:function(data){
                //成功请求后对返回数据进行判断
                var obj=FastJson.format(data);
                //如果判断没有文件，警告框提示
                if(obj["result"]=="nomatch"){
                    $('#nomatch').removeAttr('hidden');
                }else if(obj["result"]=="nofile"){
                    $('#nofile').removeAttr('hidden');
                }else if(obj["result"]=="bothno"){
                    $('#nofile').removeAttr('hidden');
                    $('#nomatch').removeAttr('hidden');
                } else if(obj["result"]=="bothyes"){
                    //如果判断存在文件，则打开模态框等待命令执行
                    $('#myModal').modal('toggle');
                    //该ajax请求主要是提交command进行ssh连接，并不返回log
                    $.ajax({
                        type: 'POST',
                        url: 'algorithm/execute',
                        data:{
                            "command": $('#command').attr("value")
                        },
                        dataType: "text",
                        async: true,
                        success: function(obj){
                            //设置轮询ajax.get请求,请求的方法为重载的'algorithm/execute'
                            //3000ms请求一次
                            var _send = setInterval(function(){
                                $.get('algorithm/execute', function(data) {
                                    //如果返回数据为null,则停止轮询，并将保存和下一步的按钮置为可用状态
                                    if(data=="null"){
                                        window.clearInterval(_send);
                                        $('#saveLog').removeAttr('disabled');
                                        $('#next').removeAttr('disabled');
                                    }else{
                                        //请求结果log返回到模态框中
                                        document.getElementById("modelLog").innerText+=data;
                                    }
                                });
                            },3000);
                        },
                        error: function(data){
                            //发生错误跳转500页面
                            window.location.href="500";
                        }
                    });

                }
            }
        });
    }
}
function cmd_logisticcheck() {
    //判断命令行是否为空，若为空给出提示
    if($('#features').attr("value").trim()==""||$('#passes').attr("value").trim()==""||$('#rate').attr("value").trim()==""||$('#target').attr("value").trim()==""||$('#prediction').attr("value").trim()==""){
        alert("您输入的参数有误，请校验");
    }else{
        //该ajax主要是请求判断文件是否已上传，且对命令进行合法性检查
        $.ajax({
            url:"algorithm/checklogistic",
            type:"POST",
            data:{
                "features": $('#features').attr("value"),
                "passes": $('#passes').attr("value"),
                "rate": $('#rate').attr("value"),
                "target": $('#target').attr("value"),
                "prediction": $('#prediction').attr("value")
            },
            async:true,
            beforeSend: function() {
            },
            success:function(data){
                //成功请求后对返回数据进行判断
                var obj=FastJson.format(data);

                //如果判断没有文件，警告框提示
                if(obj["result"]=="nofile"){
                    alert('aaa');
                    $('#nofile').removeAttr('hidden');
                }else if(obj["result"]=="bothyes"){
                    //如果判断存在文件，则打开模态框等待命令执行
                    $('#myModal').modal('toggle');
                    //该ajax请求主要是提交command进行ssh连接，并不返回log
                    $.ajax({
                        type: 'POST',
                        url: 'algorithm/executelogistic',
                        data:{
                            "features": $('#features').attr("value"),
                            "passes": $('#passes').attr("value"),
                            "rate": $('#rate').attr("value"),
                            "target": $('#target').attr("value"),
                            "prediction": $('#prediction').attr("value")
                        },
                        //TODO 将execute返回后的Map进行可视化
                        dataType: "text",
                        async: true,
                        success: function(data){
                            var obj=FastJson.format(data);
                            if(!(obj["error"] == null || obj["error"]=="")){
                                alert(obj["error"]);
                            }
                            $('#expressionh3').removeAttr("hidden");
                            $('#argsh3').removeAttr("hidden");
                            $('#expression').empty();
                            $('#auc').empty();
                            $('#property').empty();
                            $('#result').empty();
                            $('#print').empty();
                            $('#expression').append($('#target').attr("value")+"&nbsp;&nbsp;=&nbsp;&nbsp;"+obj["expression"]);
                            // $('#auc').empty();
                            $('#auc').append(obj["auc"]);
                            var tbody = "";
                            $.each(obj["propertions"],function(n,value) {
                                // $('#property').append(value[0]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\t\\t"+value[1]+"</br>");
                                tbody += "<tr>"+"<td style='font-size: 15pt'>"+value[0]+"</td>"+"<td style='font-size: 15pt'>"+value[1]+"</td>"+"</tr>";
                            });
                            var scores = obj["scores"]
                            var resultTbody = "";
                            $.each(obj["targets"],function(n,value) {
                                // $('#property').append(value[0]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\t\\t"+value[1]+"</br>");
                                resultTbody += "<tr>"+"<td style='font-size: 13pt'>"+value+"</td>"+"<td style='font-size: 13pt'>"+scores[n]+"</td>"+"</tr>";
                            });

                            // $('#property').empty();
                            $('#property').append(tbody);
                            // $('#result').empty();
                            $('#result').append(resultTbody);

                            var map = L.map("map", {
                                minZoom: 0,
                                maxZoom: 14
                            });
                            map.setView([39.467098, 117.004395], 10);
                            // map.setView([117.014, 39.495], 10);
                            map.setZoom(10);
                            // var map = L.map('map').setView([117.014,39.495],2);
                            // 			var map = L.map('map').setView([37.71, -99.88], 4);
                            // 			L.esri.basemapLayer('Gray').addTo(map);

                            L.esri.dynamicMapLayer({
                                // url: 'https://services.arcgisonline.com/arcgis/rest/services/Specialty/Soil_Survey_Map/MapServer',
                                url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
                                searchFields : ['NAME_3','NAME_1'],

                                opacity: 0.7
                            }).addTo(map);
                            var mypop = L.popup();

                            var searchControl = L.esri.Geocoding.geosearch({
                                providers: [
                                    <!-- arcgisOnline, -->
                                    L.esri.Geocoding.mapServiceProvider({
                                        label: 'States and Counties',
                                        // url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
                                        url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
                                        layers: [1],
                                        searchFields: ['NAME_1', 'NAME_3']
                                    })
                                ]
                            }).addTo(map);

                            var greenIcon = L.icon({
                                // iconUrl: 'http://localhost:8080/arcgis_js_api/green.png',
                                iconUrl: 'http://localhost:8080/arcgis_js_api/green.png',

                                iconSize:     [9, 9], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var redIcon = L.icon({
                                // iconUrl: 'http://localhost:8080/arcgis_js_api/red.png',
                                iconUrl: 'http://localhost:8080/arcgis_js_api/red.png',

                                iconSize:     [9, 9], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var orangeIcon = L.icon({
                                // iconUrl: 'http://localhost:8080/arcgis_js_api/orange.png',
                                iconUrl: 'http://localhost:8080/arcgis_js_api/orange.png',

                                iconSize:     [9, 9], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var yellowIcon = L.icon({
                                // iconUrl: 'http://localhost:8080/arcgis_js_api/yellow.png',
                                iconUrl: 'http://localhost:8080/arcgis_js_api/yellow.png',

                                iconSize:     [9, 9], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var options = {
                                minWidth : 260
                            };

                            L.marker([39.445842, 117.184682], {icon: yellowIcon}).addTo(map)
                                .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.85214</td></tr><tr><td>是否达标</td><td>基本达标</td></tr><tr><td>经度</td><td>117.184682</td></tr><tr><td>纬度:</td><td>39.445842</td></tr></table>',options);
                            L.marker([39.421842, 117.165682], {icon: greenIcon}).addTo(map)
                                .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.99978</td></tr><tr><td>是否达标</td><td>达标</td></tr><tr><td>经度</td><td>117.165682</td></tr><tr><td>纬度:</td><td>39.421842</td></tr></table>',options);
                            L.marker([39.480842, 117.264682], {icon: redIcon}).addTo(map)
                                .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.02291</td></tr><tr><td>是否达标</td><td>不达标</td></tr><tr><td>经度</td><td>117.264682</td></tr><tr><td>纬度:</td><td>39.480842</td></tr></table>',options);
                            L.marker([39.503212, 117.164114], {icon: redIcon}).addTo(map)
                                .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.07344</td></tr><tr><td>是否达标</td><td>不达标</td></tr><tr><td>经度</td><td>117.164114</td></tr><tr><td>纬度:</td><td>39.503212</td></tr></table>',options);






                            var myChart1 = echarts.init(document.getElementById("print"));
                            option = {
                                title: {
                                    text: '各项占比柱状图',

                                },
                                color: ['#3398DB'],
                                tooltip : {
                                    trigger: 'axis',
                                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                                    }
                                },
                                grid: {
                                    left: '3%',
                                    right: '4%',
                                    bottom: '3%',
                                    containLabel: true
                                },
                                xAxis : [
                                    {
                                        type : 'category',
                                        data : obj["propertions"].map(function (item) {
                                            return item[0];
                                        }),
                                        axisTick: {
                                            alignWithLabel: true
                                        },
                                        axisLabel:{
                                            textStyle:{
                                                fontSize:22
                                            }
                                        }

                                    }
                                ],
                                yAxis : [
                                    {
                                        type : 'value',
                                        axisLabel:{
                                            textStyle:{
                                                fontSize:22
                                            }
                                        }
                                    }
                                ],
                                series : [
                                    {
                                        name:'比重',
                                        type:'bar',
                                        barWidth: '60%',
                                        data:obj["propertions"].map(function (item) {
                                            return item[1];
                                        })
                                    }
                                ]
                            };
                            myChart1.setOption(option);


                        },
                        error: function(data){
                            var obj=FastJson.format(data);
                            alert(obj['error']);
                            //发生错误跳转500页面
                            // window.location.href="500";
                        }
                    });

                }
            },
            error : function(data){
                var obj=FastJson.format(data);
                alert(obj['error']);
                // window.location.href="500";
            }
        });
    }
}
function cmd_rfcheck() {
    //判断命令行是否为空，若为空给出提示
    if($('#target').attr("value").trim()==""){
        alert("您输入的参数有误，请校验");
    }else{
        //该ajax主要是请求判断文件是否已上传，且对命令进行合法性检查
        $.ajax({
            url:"algorithm/checkrf",
            type:"POST",
            data:{
                "target": $('#target').attr("value"),
                "hasPoint" : $('input[name="hasPoint"]:checked').val()
            },
            async:true,
            beforeSend: function() {
            },
            success:function(data){
                //成功请求后对返回数据进行判断
                var obj=FastJson.format(data);

                //如果判断没有文件，警告框提示
                if(obj["result"]=="nofile"){
                    $('#nofile').removeAttr('hidden');
                }else if(obj["result"]=="bothyes"){
                    //如果判断存在文件，则打开模态框等待命令执行
                    $('#myModal').modal('toggle');
                    //该ajax请求主要是提交command进行ssh连接，并不返回log
                    $.ajax({
                        type: 'POST',
                        url: 'algorithm/executeRF',
                        data:{
                            "target": $('#target').attr("value"),
                            "hasPoint" : $('input[name="hasPoint"]:checked').val()
                        },
                        //TODO 将execute返回后的Map进行可视化
                        dataType: "text",
                        async: true,
                        success: function(data){
                            var obj=FastJson.format(data);
                            var predictions = obj["prediction"];
                            var points = obj["points"];
                            if(!(obj["error"] == null || obj["error"]=="")){
                                alert(obj["error"]);
                            }
                            $('#rfTableBody').empty();
                            var rfTableBodyStr = "";
                            // for(var i=0;i<predictions.length;i++){
                            //     var index = i+1;
                            //     var str = "";
                            //     if(predictions[i] == 1)
                            //         str = "超标";
                            //     else
                            //         str = "合格";
                            //     rfTableBodyStr += "<tr>";
                            //     rfTableBodyStr +="<td>"+index+"</td><td></td>"
                            //     rfTableBodyStr += "</tr>";
                            //
                            // }


                            $('#map').empty();
                            var map = L.map("map", {
                                minZoom: 0,
                                maxZoom: 14
                            });
                            map.setView([39.467098, 117.004395], 10);
                            // map.setView([117.014, 39.495], 10);
                            map.setZoom(10);
                            // var map = L.map('map').setView([117.014,39.495],2);
                            // 			var map = L.map('map').setView([37.71, -99.88], 4);
                            // 			L.esri.basemapLayer('Gray').addTo(map);

                            L.esri.dynamicMapLayer({
                                // url: 'https://services.arcgisonline.com/arcgis/rest/services/Specialty/Soil_Survey_Map/MapServer',
                                url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
                                searchFields : ['NAME_3','NAME_1'],

                                opacity: 0.7
                            }).addTo(map);
                            var mypop = L.popup();

                            var searchControl = L.esri.Geocoding.geosearch({
                                providers: [
                                    <!-- arcgisOnline, -->
                                    L.esri.Geocoding.mapServiceProvider({
                                        label: 'States and Counties',
                                        url: 'http://localhost:6080/arcgis/rest/services/wuqingxzq/MapServer',
                                        layers: [1],
                                        searchFields: ['NAME_1', 'NAME_3']
                                    })
                                ]
                            }).addTo(map);

                            var greenIcon = L.icon({
                                iconUrl: 'http://localhost:8080/arcgis_js_api/green.png',

                                iconSize:     [12, 12], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var redIcon = L.icon({
                                iconUrl: 'http://localhost:8080/arcgis_js_api/red.png',

                                iconSize:     [12, 12], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var orangeIcon = L.icon({
                                iconUrl: 'http://localhost:8080/arcgis_js_api/orange.png',

                                iconSize:     [9, 9], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var yellowIcon = L.icon({
                                iconUrl: 'http://localhost:8080/arcgis_js_api/yellow.png',

                                iconSize:     [9, 9], // size of the icon
                                popupAnchor:  [0, -5] // point from which the popup should open relative to the iconAnchor
                            });
                            var options = {
                                minWidth : 260
                            };
                            for(var i=0;i<predictions.length;i++){
                                var longitude = points[i][0];
                                var latitude = points[i][1];
                                var predict = predictions[i];
                                var index = i+1;
                                var icon = null;
                                var preStr = null;
                                if(predict == 1){
                                    icon = redIcon;
                                    preStr = "超标"
                                }
                                else {
                                    icon = greenIcon;
                                    preStr = "合格"
                                }
                                rfTableBodyStr += "<tr><td class=\"tableth\">"+index+"</td><td class=\"tableth\">"+longitude+"</td><td class=\"tableth\">"+latitude+"</td><td class=\"tableth\">"+preStr+"</td></tr>";
                                L.marker([latitude, longitude], {icon: icon}).addTo(map)
                                    .bindPopup('<table style="height: 127px;width: 214px; font-size: 13pt"><tr><td>是否达标</td><td>'+preStr+'</td></tr><tr><td>经度</td><td>'+longitude+'</td></tr><tr><td>纬度:</td><td>'+latitude+'</td></tr></table>',options);
                            }
                            $('#rfTableBody').append(rfTableBodyStr);
                            // L.marker([39.445842, 117.184682], {icon: yellowIcon}).addTo(map)
                            //     .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.85214</td></tr><tr><td>是否达标</td><td>基本达标</td></tr><tr><td>经度</td><td>117.184682</td></tr><tr><td>纬度:</td><td>39.445842</td></tr></table>',options);
                            // L.marker([39.421842, 117.165682], {icon: greenIcon}).addTo(map)
                            //     .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.99978</td></tr><tr><td>是否达标</td><td>达标</td></tr><tr><td>经度</td><td>117.165682</td></tr><tr><td>纬度:</td><td>39.421842</td></tr></table>',options);
                            // L.marker([39.480842, 117.264682], {icon: redIcon}).addTo(map)
                            //     .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.02291</td></tr><tr><td>是否达标</td><td>不达标</td></tr><tr><td>经度</td><td>117.264682</td></tr><tr><td>纬度:</td><td>39.480842</td></tr></table>',options);
                            // L.marker([39.503212, 117.164114], {icon: redIcon}).addTo(map)
                            //     .bindPopup('<table style="height: 127px;width: 214px; font-size: 12pt"><tr><td>预测值:</td><td>0.07344</td></tr><tr><td>是否达标</td><td>不达标</td></tr><tr><td>经度</td><td>117.164114</td></tr><tr><td>纬度:</td><td>39.503212</td></tr></table>',options);
                            $('#hl').removeAttr("hidden");
                            $('#rftable').removeAttr("hidden");

                        },
                        error: function(data){
                            var obj=FastJson.format(data);
                            alert(obj['error']);
                            //发生错误跳转500页面
                            // window.location.href="500";
                        }
                    });

                }
            },
            error : function(data){
                var obj=FastJson.format(data);
                alert(obj['error']);
                // window.location.href="500";
            }
        });
    }
}
function cmd_pcacheck() {
    $.ajax({
        url:"algorithm/checkpca",
        type:"POST",
        data:{
        },
        async:true,
        beforeSend: function() {
        },
        success:function(data){
            //成功请求后对返回数据进行判断
            var obj=FastJson.format(data);

            //如果判断没有文件，警告框提示
            if(obj["result"]=="nofile"){
                alert('aaa');
                $('#nofile').removeAttr('hidden');
            }else if(obj["result"]=="bothyes"){
                //如果判断存在文件，则打开模态框等待命令执行
                $('#myModal').modal('toggle');
                //该ajax请求主要是提交command进行ssh连接，并不返回log
                $.ajax({
                    type: 'POST',
                    url: 'algorithm/executepca',
                    data:{

                    },
                    //TODO 将execute返回后的Map进行可视化
                    dataType: "text",
                    async: true,
                    success: function(data){
                        var obj=FastJson.format(data);
                        if(!(obj["error"] == null || obj["error"]=="")){
                            alert(obj["error"]);
                        }

                        var formatResult = obj["formatResult"];
                        var tbodyStr = "";
                        for(i=0;i<formatResult.length;i++){
                            if(i == 1)
                                continue;
                            tbodyStr += "<tr>";
                            tbodyStr += "<th class=\"col-lg-1 col-md-1 text-center\">"+formatResult[i][0]+"</th>";
                            var num = formatResult[0].length>4?4:formatResult[0].length;
                            for(var j=1;j<num;j++){
                                tbodyStr += "<td class=\"col-lg-2 col-md-2 text-center\">"+formatResult[i][j].toFixed(2)+"</td>";
                            }
                            tbodyStr += "</tr>";
                        }
                        $('#pcaTable').removeAttr("hidden");
                        $('#pcaTbody').empty();
                        $('#pcaTbody').append(tbodyStr);


                        var myChart1 = echarts.init(document.getElementById("print"));
                        var name = ['第一主成分','第二主成分','第三主成分','其他主成分'];
                        var eigenvalues = obj["eigenvalues"];
                        var pair = [];
                        for(var i=0;i<name.length;i++){
                            var p = {"value" : eigenvalues[i],"name" : name[i]};
                            // p.put(name[i],eigenvalues[i]);
                            pair.push(p);
                        }
                        option = {
                            title : {
                                text: '各主成分占百分比',
                                subtext: obj["fileName"],
                                x:'center'
                            },
                            tooltip : {
                                trigger: 'item',
                                formatter: "{a} <br/>{b} : {c} ({d}%)",
                                textStyle:{
                                    fontSize:18
                                }
                            },
                            legend: {
                                orient: 'vertical',
                                left: 'left',
                                data: name,
                                textStyle:{
                                    fontSize:18
                                }
                            },
                            series : [
                                {
                                    name: '基本情况',
                                    type: 'pie',
                                    radius : '55%',
                                    center: ['50%', '60%'],
                                    // data:[
                                    //     {value:335, name:'第一主成分'},
                                    //     {value:310, name:'第二主成分'},
                                    //     {value:234, name:'第三主成分'},
                                    //     {value:1548, name:'第四主成分'}
                                    // ],
                                    data: pair,
                                    itemStyle: {
                                        emphasis: {
                                            shadowBlur: 10,
                                            shadowOffsetX: 0,
                                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                                        }
                                    },
                                    label:{
                                        normal:{
                                            show:true,
                                            textStyle:{
                                                fontSize:18
                                            }
                                        }
                                    }
                                }
                            ]
                        };
                        myChart1.setOption(option);


                    },
                    error: function(data){
                        var obj=FastJson.format(data);
                        alert(obj['error']);
                        //发生错误跳转500页面
                        // window.location.href="500";
                    }
                });

            }
        },
        error : function(data){
            var obj=FastJson.format(data);
            alert(obj['error']);
            // window.location.href="500";
        }
    });
}
function cmd_kmeanscheck() {
    //判断命令行是否为空，若为空给出提示
    if($('#k').attr("value").trim()==""||$('#maxIterations').attr("value").trim()==""||$('#convergenceDelta').attr("value").trim()==""){
        $('#cmdDiv').addClass("has-error");
    }else{
        //该ajax主要是请求判断文件是否已上传，且对命令进行合法性检查
        $.ajax({
            url:"algorithm/checkkmeans",
            type:"POST",
            data:{
            },
            async:true,
            beforeSend: function() {
            },
            success:function(data){
                //成功请求后对返回数据进行判断
                var obj=FastJson.format(data);
                //如果判断没有文件，警告框提示
                if(obj["result"]=="nofile"){
                    $('#nofile').removeAttr('hidden');
                }else if(obj["result"]=="bothyes"){
                    //如果判断存在文件，则打开模态框等待命令执行
                    $('#myModal').modal('toggle');
                    //该ajax请求主要是提交command进行ssh连接，并不返回log
                    $.ajax({
                        type: 'POST',
                        url: 'algorithm/executekmeans',
                        data:{
                            "k": $('#k').attr("value"),
                            "maxIterations": $('#maxIterations').attr("value"),
                            "convergenceDelta": $('#convergenceDelta').attr("value")

                        },
                        //TODO 将execute返回后的Map进行可视化
                        dataType: "text",
                        async: true,
                        success: function(data){
                            var obj=FastJson.format(data);
                            alert
                            $('#expression').empty();
                            $('#expression').append(obj["expression"]);
                            // var tbody = "";
                            // $.each(obj["propertions"],function(n,value) {
                            //     // $('#property').append(value[0]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\t\\t"+value[1]+"</br>");
                            //     tbody += "<tr>"+"<td>"+value[0]+"</td>"+"<td>"+value[1]+"</td>"+"</tr>";
                            // });
                            // var scores = obj["scores"]
                            // var resultTbody = "";
                            // $.each(obj["targets"],function(n,value) {
                            //     // $('#property').append(value[0]+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\\t\\t"+value[1]+"</br>");
                            //     resultTbody += "<tr>"+"<td>"+value+"</td>"+"<td>"+scores[n]+"</td>"+"</tr>";
                            // });
                            //
                            // $('#property').empty();
                            // $('#property').append(tbody);
                            // $('#result').empty();
                            // $('#result').append(resultTbody);



                            // var myChart1 = echarts.init(document.getElementById("print"));
                            // option = {
                            //     title: {
                            //         text: '各项占比柱状图',
                            //
                            //     },
                            //     color: ['#3398DB'],
                            //     tooltip : {
                            //         trigger: 'axis',
                            //         axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                            //             type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                            //         }
                            //     },
                            //     grid: {
                            //         left: '3%',
                            //         right: '4%',
                            //         bottom: '3%',
                            //         containLabel: true
                            //     },
                            //     xAxis : [
                            //         {
                            //             type : 'category',
                            //             data : obj["propertions"].map(function (item) {
                            //                 return item[0];
                            //             }),
                            //             axisTick: {
                            //                 alignWithLabel: true
                            //             }
                            //         }
                            //     ],
                            //     yAxis : [
                            //         {
                            //             type : 'value'
                            //         }
                            //     ],
                            //     series : [
                            //         {
                            //             name:'比重',
                            //             type:'bar',
                            //             barWidth: '60%',
                            //             data:obj["propertions"].map(function (item) {
                            //                 return item[1];
                            //             })
                            //         }
                            //     ]
                            // };
                            // myChart1.setOption(option);
                        },
                        error: function(data){
                            //发生错误跳转500页面
                            // window.location.href="500";
                        }
                    });

                }
            },
            error : function(data){
                // window.location.href="500";
            }
        });
    }
}


/**
 * 日志下载
 * @param e
 */




function saveLog(e){
    alert($('#saveLog').html());
    //downloadFile("log.html",document.getElementById("modelLog").innerHTML);

}

/**
 *输出日志的捕获
 * @param fileName
 * @param content
 */
function downloadFile(fileName, content){
    var aLink = document.createElement('a');
    var blob = new Blob([content]);
    var evt = document.createEvent("HTMLEvents");
    evt.initEvent("click", false, false);//initEvent 不加后两个参数在FF下会报错
    aLink.download = fileName;
    aLink.href = window.URL.createObjectURL(blob);
    aLink.dispatchEvent(evt);
}

$('#next').click(function(){

});

/**
 * 简单条件查询
 */
function text_mine(){
    $.post('land/text/mine',{
        qt:$('#mtext').attr('value')
    },function(data) {
        if(data.trim()==""){
            $('#queryresult').html("无符合条件内容");
        }else{
            $('#queryresult').html(data);
        }
    });
}

function advanced_mine(){
    $('#advQueryModal').modal('toggle');
}

/**
 * 缺失数据填充方法调用
 */
function imputation_execute() {
    $.post("file/check",function(data){
        if(data['result']=="existfile"){
            $('#my_modal_loading').modal('toggle');
            $.ajax({
                type:'POST',
                url:'land/data/imputation',
                async:true,
                success: function(data){
                    $('#my_modal_loading').modal('toggle');
                    if(data['exception']=='yes'){
                        $('#bad_result').removeAttr('hidden');
                        return;
                    }
                    //alert(data);
                    $('#mice_result').html(data);
                    $('#mice_result').removeAttr('hidden');
                },error: function(data){
                    $('#my_modal_loading').modal('toggle');
                    $('#bad_result').removeAttr('hidden');
                }
            });
        }else if(data['result']=="nofile"){
            $('#no_upload_file').removeAttr('hidden');
        }else if(data['result']=="badfile"){
            $('#bad_file').removeAttr('hidden');
        }
    });
}

$('#sample_download').click(function(e){
    $.get("file/download",{
        fileName:'sample.csv'
    },function(data){
    })
});

$('#rankbar').click(function (e) {
    e.preventDefault();
    var url = this.href;
    $('#main-navbar').attr("hidden","hidden");
    if (url != null && url != 'javascript:;') {
        $.get(url, function (data) {
            $('#main-content').html(data);
        });
    }
});
