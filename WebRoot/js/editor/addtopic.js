
	document.onkeydown = function()//��ֹF5���Ҽ�ˢ�½��棬��ֹ�ظ��������ݿ�
	{
	         if(event.keyCode==116) {
	         event.keyCode=0;
	         event.returnValue = false;
	         }
	}
	document.oncontextmenu = function() {event.returnValue = false;}
	
	function orders(){//���ʵ����
	var num=document.getElementsByTagName("ul").length;		
		for(var i=0;i<num;i++){
			document.getElementsByTagName("ul")[i].getElementsByTagName("div")[0].innerHTML=i+1+". ";			
			var n=document.getElementsByTagName("ul")[i].getElementsByTagName("input").length;
			for(var j=0;j<n;j++){				
				document.getElementsByTagName("ul")[i].getElementsByTagName("input")[j].name="n"+i;				
			}
		}
	}

	function updatecontext(){//�޸�������Ŀ����
		var num=document.getElementsByTagName("ul").length;		
		var tixing=null;
		document.getElementsByTagName("ul")[num-1].getElementsByTagName("div")[1].innerHTML="���������Ŀ��";
		tixing=document.getElementsByTagName("ul")[num-1].getElementsByTagName("input")[1].type;		
		var n=document.getElementsByTagName("ul")[num-1].getElementsByTagName("input").length;
				for(var j=0;j<n;j++){
					document.getElementsByTagName("ul")[num-1].getElementsByClassName("option")[j].innerHTML="ѡ��";					
				}
				
	}
	
	function optiondefault(){//����ʹ��		
		
		alert("optiondefault: "+document.getElementsByTagName("ul")[0].getElementsByClassName("option").length);
		document.getElementsByTagName("ul")[0].getElementsByClassName("option")[4].innerText="����";
	}
	
	function addoption(data){//���ӵ�ѡѡ��
		 var input=document.createElement("input");
         input.type="radio";
         input.name="n";
         
		 var labelout=document.createElement("label");
		 var label=document.createElement("label");
		 label.setAttribute("class", "option"); //��������ֵ
		 
         var labeltext=document.createTextNode("ѡ��");
         label.appendChild(labeltext);
         
         labelout.appendChild(input);        
         labelout.appendChild(label);
         
         data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("li").item(0).appendChild(labelout); 
        
         orders();//���л�   
	}
	
	function addfxoption(data){//���Ӹ�ѡѡ��
		 var input=document.createElement("input");
        input.type="checkbox";
        input.name="n";
        
		 var labelout=document.createElement("label");
		 var label=document.createElement("label");
		 label.setAttribute("class", "option"); //��������ֵ
		 
        var labeltext=document.createTextNode("ѡ��");
        label.appendChild(labeltext);
        
        labelout.appendChild(input);        
        labelout.appendChild(label);
        
        data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("li").item(0).appendChild(labelout); 
      
        orders();//���л�   
	}
	
	function desoption(data){//ɾ��ѡ��
           
        var length= data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("label").length;
        //alert(length);
        data.parentNode.getElementsByTagName("ul").item(0).getElementsByTagName("label").item(length-2).remove(); //ɾ�����label
       
        orders();//���л�   
	}
	
	function deletetopic(data){//ɾ����Ŀ        
        data.parentNode.remove();
        orders();//���л�   
	}
	
	function editor(data){//�༭����
		var topic=data.parentNode.getElementsByTagName("div")[1].innerText; //ȡ����Ŀֵ
		var orderid=data.parentNode.getElementsByTagName("div")[0].innerText; //ȡ�����
		var optionlength=data.parentNode.getElementsByClassName("option").length; //ȡ��ѡ�����
		//data.parentNode.getElementsByTagName("div")[1].innerText="����"; 
		//alert("��Ŀ: "+topic);		
		var sonwindow=window.open("","inputwindow","height=300, width=300");
		var text="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">";
			text+="<html>";
			text+="<head>";    
			text+="<title>�༭����</title>";
			text+="<script type='text/javascript' src='../js/editor/editor.js'><\/script>";
			text+="</head>";  
			text+="<body>";		
			text+="<div>��Ŀ"+orderid+"<input value='"+topic+"'/></div></br>";					
			var options=null;
			for(var i=0;i<optionlength;i++){
				options=data.parentNode.getElementsByClassName("option")[i].innerHTML; //ȡ��ѡ��
				text+="ѡ��"+(i+1)+"��<input value='"+options+"'/></br></br>";
			}	
			text+="<input type='button' id='editor' value='��ɱ༭' onclick='sonwin()'/>";
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
	
	
	
	function topicover(){//�����Ŀ�ύ����		
		var lisize=document.getElementsByTagName("ul").length;		
		var json=[];		
		
		for(var i=0;i<lisize;i++){			
			var row={};
			row.id=i+1;
			row.name=document.getElementsByTagName("ul")[i].getElementsByTagName("div")[1].innerHTML;
			row.qnid=document.getElementsByTagName("h3")[1].innerHTML;
			var flag=document.getElementsByTagName("ul")[i].getElementsByTagName("div")[2].innerHTML;
			if(flag=="(��ѡ)"){
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
		topicover();//�ύ��Ŀ����		
		optionover();//�ύѡ�����
		alert("�ʾ�����ɣ�ȷ�������̼ҽ��档");
	}
	

	
	function optionover(){//���ѡ���ύ����	
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
				//alert("ѡ�����:"+ops.id+"  ѡ�����ݣ�"+ops.content+"  �ʾ��ţ�"+ops.qnid+"  ��Ŀ��ţ�"+ops.topicorderid);		
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
				$.messager.alert('����',"���������ִ���");
			}
		});
		return tag;
	}
	
	function clonerd(){//��¡��ѡ����
		var clonenode=document.getElementById("f1").cloneNode(true);
		document.getElementById("f1").parentNode.appendChild(clonenode);
		updatecontext()
		orders();
	}

	function clonefx(){//��¡��ѡ����
		var clonenode=document.getElementById("f2").cloneNode(true);
		document.getElementById("f2").parentNode.appendChild(clonenode);
		updatecontext();
		orders();
	}