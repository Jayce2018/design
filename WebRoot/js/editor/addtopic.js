
	document.onkeydown = function()//禁止F5和右键刷新界面，防止重复操作数据库
	{
	         if(event.keyCode==116) {
	         event.keyCode=0;
	         event.returnValue = false;
	         }
	}
	document.oncontextmenu = function() {event.returnValue = false;}
	
	function orders(){//序号实例化
	var num=document.getElementsByTagName("ul").length;		
		for(var i=0;i<num;i++){
			document.getElementsByTagName("ul")[i].getElementsByTagName("div")[0].innerHTML=i+1+". ";			
			var n=document.getElementsByTagName("ul")[i].getElementsByTagName("input").length;
			for(var j=0;j<n;j++){				
				document.getElementsByTagName("ul")[i].getElementsByTagName("input")[j].name="n"+i;				
			}
		}
	}

	function updatecontext(){//修改新增题目内容
		var num=document.getElementsByTagName("ul").length;		
		var tixing=null;
		document.getElementsByTagName("ul")[num-1].getElementsByTagName("div")[1].innerHTML="输入你的题目。";
		tixing=document.getElementsByTagName("ul")[num-1].getElementsByTagName("input")[1].type;		
		var n=document.getElementsByTagName("ul")[num-1].getElementsByTagName("input").length;
				for(var j=0;j<n;j++){
					document.getElementsByTagName("ul")[num-1].getElementsByClassName("option")[j].innerHTML="选项";					
				}
				
	}
	
	function optiondefault(){//测试使用		
		
		alert("optiondefault: "+document.getElementsByTagName("ul")[0].getElementsByClassName("option").length);
		document.getElementsByTagName("ul")[0].getElementsByClassName("option")[4].innerText="测试";
	}
	
	function addoption(data){//增加单选选项
		 var input=document.createElement("input");
         input.type="radio";
         input.name="n";
         
		 var labelout=document.createElement("label");
		 var label=document.createElement("label");
		 label.setAttribute("class", "option"); //设置属性值
		 
         var labeltext=document.createTextNode("选项");
         label.appendChild(labeltext);
         
         labelout.appendChild(input);        
         labelout.appendChild(label);
         
         data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("li").item(0).appendChild(labelout); 
        
         orders();//序列化   
	}
	
	function addfxoption(data){//增加复选选项
		 var input=document.createElement("input");
        input.type="checkbox";
        input.name="n";
        
		 var labelout=document.createElement("label");
		 var label=document.createElement("label");
		 label.setAttribute("class", "option"); //设置属性值
		 
        var labeltext=document.createTextNode("选项");
        label.appendChild(labeltext);
        
        labelout.appendChild(input);        
        labelout.appendChild(label);
        
        data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("li").item(0).appendChild(labelout); 
      
        orders();//序列化   
	}
	
	function desoption(data){//删除选项
           
        var length= data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("label").length;
        //alert(length);
        data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("label").item(length-2).remove(); //删除外层label
       
        orders();//序列化   
	}
	
	function deletetopic(data){//删除题目        
        data.parentNode.remove();
        orders();//序列化   
	}
	
	function editor(data){//编辑操作
		var topic=data.parentNode.getElementsByTagName("div")[1].innerText; //取到题目值
		var orderid=data.parentNode.getElementsByTagName("div")[0].innerText; //取到题号
		var optionlength=data.parentNode.getElementsByClassName("option").length; //取到选项个数
		//data.parentNode.getElementsByTagName("div")[1].innerText="测试"; 
		//alert("题目: "+topic);		
		var sonwindow=window.open("","inputwindow","height=300, width=300");
		var text="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";
			text+="<html>";
			text+="<head>";    
			text+="<title>编辑窗口</title>";
			text+="<script type='text/javascript' src='../js/editor/editor.js'><\/script>";
			text+="</head>";  
			text+="<body>";		
			text+="<div>题目"+orderid+"<input value='"+topic+"'/></div></br>";					
			var options=null;
			for(var i=0;i<optionlength;i++){
				options=data.parentNode.getElementsByClassName("option")[i].innerHTML; //取到选项
				text+="选项"+(i+1)+"：<input value='"+options+"'/></br></br>";
			}	
			text+="<input type='button' id='editor' value='完成编辑' onclick='sonwin()'/>";
			text+="</body>";
			text+="</html>";
		//alert(text);
		sonwindow.document.write(text);
		window.orderid=orderid[0];
		var x=0.5*window.screen.availWidth;
		var y=0.2*window.screen.availHeight;
		sonwindow.moveTo(x,y);
		sonwindow.focus();	
	}
	
	
	
	function topicover(){//完成题目提交操作		
		var lisize=document.getElementsByTagName("ul").length;		
		var json=[];		
		
		for(var i=0;i<lisize;i++){			
			var row={};
			row.id=i+1;
			row.name=document.getElementsByTagName("ul")[i].getElementsByTagName("div")[1].innerHTML;
			row.qnid=document.getElementsByTagName("h3")[1].innerHTML;
			var flag=document.getElementsByTagName("ul")[i].getElementsByTagName("div")[2].innerHTML;
			if(flag=="(单选)"){
				flag=0;
			}else{
				flag=1;
			}			
			row.tixing=flag;
			json.push(row);				
		}		
		var data = {"a":JSON.stringify(json)};
		//alert(JSON.stringify(json));
		fn_ajax_req("addTopicAction",data);		
	}
	
	function submits(){
		topicover();//提交题目操作		
		optionover();//提交选项操作
		alert("问卷创建完成，确定返回商家界面。");
	}
	

	
	function optionover(){//完成选项提交操作	
		var lisizes=document.getElementsByTagName("ul").length;		
		var qnid=document.getElementsByTagName("h3")[1].innerHTML;	
		var optionsize="";
		var json=[];
		var ops={};
		for(var i=0;i<lisizes;i++){	
			id=i+1;
			optionsize=document.getElementsByTagName("ul")[i].getElementsByClassName("option").length;
			//alert(optionsize);				
			for(var j=0;j<optionsize;j++){
				ops={};
				ops.id=j+1;
				ops.content=document.getElementsByTagName("ul")[i].getElementsByClassName("option")[j].innerHTML;
				ops.qnid=qnid;
				ops.topicorderid=id;
				//alert("选项序号:"+ops.id+"  选项内容："+ops.content+"  问卷编号："+ops.qnid+"  题目序号："+ops.topicorderid);		
				json.push(ops);				
			}				
		}
		//var str=window.location.href="shangjia.jsp";
		var data = {"options":JSON.stringify(json)};
		//alert(JSON.stringify(json));
		fn_ajax_req("addOptionAction",data,tz());			
	}
	function tz(){
		window.location.href="shangjia.jsp";
	}

	function fn_ajax_req(url,data,successfn){
		var tag;
		$.ajax({
			url: url,
			data: data,
			async: false, 
			method: 'post',    
			success: function(data) {					
				successfn;				
			},
			error: function(err){
				$.messager.alert('警告',"服务器出现错误！");
			}
		});
		return tag;
	}
	
	function clonerd(){//克隆单选题型
		var clonenode=document.getElementById("f1").cloneNode(true);
		document.getElementById("f1").parentNode.appendChild(clonenode);
		updatecontext()
		orders();
	}

	function clonefx(){//克隆复选题型
		var clonenode=document.getElementById("f2").cloneNode(true);
		document.getElementById("f2").parentNode.appendChild(clonenode);
		updatecontext();
		orders();
	}