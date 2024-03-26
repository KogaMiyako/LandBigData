// zlx: 算法执行函数 param: algMode url
/*
function algRun(algMode, url) {
    // zlx: 先检查该算法下是否上传了文件
    debugger;
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
                alert("运行算法"+url)
            }
        }
    })
}*/
