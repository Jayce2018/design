<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%request.setCharacterEncoding("gbk");%>
<html>
<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=GBk">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<style>
		a{text-decoration:none}
		.add{padding-top:15px}
	</style>
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script>
		function add(){			
			var tp=document.getElementsByTagName("input")[5].value;
			var cid=document.getElementById("id").value;
			if(tp!="商家"){
				alert("用户类型错误");
				document.getElementById("addcs").href="#";
			}else{				
				document.getElementById("addcs").href="addcustomerinfo.jsp?cid="+cid;
			}			
		}
	</script>
	<title>用户登录</title>
</head>
<body style="margin: 50px 50px;background:#FFFACD ">


	<div class="easyui-panel" id="myForm1" title="&nbsp;用户登录" style="position:relative;" >
		
			<s:form id="insert" method="POST" action="validateLogin"  class="easyui-panel" namespace="/page" >
			<label id='id_label'>用户编号：</label>
			<div id="id_div"><input class="easyui-textbox" type="text" id="id" name="id"></input></div>
			<label id='type_label'>用户类型：</label>
			<div id="type_div"><input class="easyui-combobox" type="text" id="type" name="type"></input></div>
			<label id='ps_label'>密码：</label>
			<div id="ps_div"><input class="easyui-passwordbox" type="text" id="password" name="password"></input></div>
				<div id="bt">	
				<input type="submit"></input>	
				<input type="reset" value="重置">
				<a href="zhuce.jsp">注册</a><br/>		
				<div class="add"><a id="addcs" href="#" onclick="add()">完善商家信息>></a></div>
				<!--  <a href="#" id="bta" iconCls="icon-redo"  onClick="javascript:document.getElementById('DengLu').submit();return false;">登录</a>  
				-->
		        </div>  
			</s:form>
			<div id="info">
				<%		
					List<String> info = (List<String>) request.getAttribute("req") ;
					if(info != null){	// 有信息返回
						Iterator<String> iter = info.iterator() ;
						while(iter.hasNext()){
				%>
							<h4 style="color:green"><%=iter.next()%></h4>
				<%
						}
					}
				%>
			</div>
	</div> 
			
			
		


<script>
	$(document).ready(function(){
		
		var typesource=[{'type':'超级管理员'},{'type':'管理员'},{'type':'用户'},{'type':'商家'}];
		//控件位置布局
		$("#id_label").css({position: "absolute", top:"23px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#id_div").css({position: "absolute", top:"20px", left:"76px", "z-index":2});

		$("#type_label").css({position: "absolute", top:"53px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#type_div").css({position: "absolute", top:"50px", left:"76px","z-index":2});

		$("#ps_label").css({position: "absolute", top:"83px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#ps_div").css({position: "absolute", top:"80px", left:"76px", "z-index":2});

		
		$("#info").css({position: "absolute", top:"170px", left:"16px", "z-index":2});
	
		
		$("#bt").css({position: "absolute", top:"123px", left:"106px", "z-index":2});
		$('#bta').linkbutton({plain:true});  
		$('#btb').linkbutton({plain:true});  
		$("#information").css({position: "absolute", top:"143px", left:"16px", "z-index":2});
		
		
		$("#type").combobox({width:120, data:typesource, valueField:'type', textField:'type'});
		
		
		//控件声明
		$("#myForm1").panel({width:300, height:320});
		$("#id").textbox({width:120});
		
		$("#id").textbox('setValue','admin');
		$("#type").textbox('setValue','超级管理员');
		$("#password").textbox('setValue','1');
		
		
		$("#name").textbox({width:120});
		$("#password").textbox({width:120});	
	
		
		$("#bta").on('click',function(){			
			//icon四种设置："error"、"info"、"question"、"warning"
			//$.messager.alert("操作提示", "您确定要执行校验操作吗！","question");  
			//fnValidation();
		});
    }); 
    
    
   
</script>
</body>
</html>

