function newalert(){
	alert("�Ѽ����ⲿjslib���");
}

function fn_ajax_req(url,data,successfn){
		var tag=null;
		$.ajax({
			url: url,
			data: data,
			async: false, 
			method: 'post',    
			success: function(rt) {	
				//alert("("+rt+")");
				tag=JSON.parse(rt);
				successfn;				
			},
			error: function(err){
				//$.messager.alert('��ʾ',"�������ݣ�");
			}
		});
		return tag;
	}

function fn_ajax(url,data,successfn){
	$.ajax({
		url: url,
		data: data,
		async: false, 
		method: 'post',    
		success: function(rs) {				
			successfn;	
		},
		error: function(err){
			//$.messager.alert('��ʾ',"�������ݣ�");
		}
	});
}

function GetQueryString(name){//get url's other data 
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
}

function json_array(data){
    var len=eval(data).result.length;
    //alert(len);
    var arr=[];
    for(var i=0;i<len;i++){
	  arr[i] =[]; //js�ж�ά�����������ظ��������������undefind
	  arr[i]=["ѡ��"+data.result[i].content,data.result[i].num];	  
    }
    return arr;  
}