// zlx: �㷨ִ�к��� param: algMode url
/*
function algRun(algMode, url) {
    // zlx: �ȼ����㷨���Ƿ��ϴ����ļ�
    debugger;
    $.ajax({
        url:"soilFile/check?algMode=" + algMode,
        type:"POST",
        success(data){
            //�ɹ������Է������ݽ����ж�
            var obj=FastJson.format(data);
            //����ж�û���ļ����������ʾ
            if(obj["result"]==="noFile"){
                alert("δ�ϴ��ļ����ļ���ʽ�����������ϴ���")
            }else if(obj["result"]==="bothYes"){
                // zlx: �㷨���ļ�һ�� �����㷨
                alert("�����㷨"+url)
            }
        }
    })
}*/
