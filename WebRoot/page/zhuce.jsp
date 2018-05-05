<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=GBk">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<title>用户注册</title>
</head>
<body style="margin: 50px 50px;background:#FFFACD ">


	<div class="easyui-panel" id="myForm1" title="&nbsp;用户注册表单" style="position:relative;" >
		
			<s:form id="insert" method="POST" action="addUser" class="easyui-panel">
			<label id='id_label'>用户编号：</label>
			<div id="id_div"><input class="easyui-textbox" type="text" id="id" name="id" value="1100000"></input></div>
			<label id='name_label'>用户姓名：</label>
			<div id="name_div"><input class="easyui-textbox" type="text" id="name" name="name" value="李小明"></input></div>
			<label id='ps_label'>密码：</label>
			<div id="ps_div"><input class="easyui-passwordbox" type="text" id="ps" name="ps" value="1"></input></div>
			<label id='rps_label'>再次输入：</label>
			<div id="rps_div"><input class="easyui-passwordbox" type="text" id="rps" name="password" value="1"></input></div>			
			<label id='date_label'>注册时间：</label>
			<div id="date_div"><input class="easyui-datebox" type="text" id="date" name="zhucedate" value="getdate" readonly="ture"></input></div>
			<label id='gender_label'>性别：</label>
			<div id="gender_div"><input class="easyui-combobox" type="text" id="gender" name="gender" ></input></div>
			<label id='type_label'>用户类型：</label>
			<div id="type_div"><input class="easyui-combobox" type="text" id="type" name="type" ></input></div>
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
			
		<div id="bt">		
		<a href="#" id="bta" iconCls="icon-redo"  onClick="javascript:document.getElementById('insert').submit();return false;">提交</a>  
		
		<!-- <input class="easyui-linkbutton" id="btb" type="submit" value="提交"> -->
		
     	<a id="btc" href="login.jsp" >返回登录</a>  
     	<a id="btc2" href="update.jsp" >修改密码</a>    
        </div>   
        </s:form>
</div>
<script>
	$(document).ready(function(){
	
		var typesource=[{'type':'管理员'},{'type':'用户'},{'type':'商家'}];
		var gendersource=[{'gender':'女'},{'gender':'男'}];
		//控件位置布局
		$("#id_label").css({position: "absolute", top:"23px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#id_div").css({position: "absolute", top:"20px", left:"76px", "z-index":2});

		$("#name_label").css({position: "absolute", top:"53px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#name_div").css({position: "absolute", top:"50px", left:"76px","z-index":2});

		$("#ps_label").css({position: "absolute", top:"83px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#ps_div").css({position: "absolute", top:"80px", left:"76px", "z-index":2});

		$("#rps_label").css({position: "absolute", top:"113px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#rps_div").css({position: "absolute", top:"110px", left:"76px", "z-index":2});
	
		$("#gender_label").css({position: "absolute", top:"143px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#gender_div").css({position: "absolute", top:"140px", left:"76px", "z-index":2});
		
		$("#date_label").css({position: "absolute", top:"173px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#date_div").css({position: "absolute", top:"170px", left:"76px", "z-index":2});
		$("#type_label").css({position: "absolute", top:"203px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#type_div").css({position: "absolute", top:"200px", left:"76px", "z-index":2});
		
		
		$("#info").css({position: "absolute", top:"10px", left:"306px", "z-index":2});
		
		$("#bt").css({position: "absolute", top:"233px", left:"76px", "z-index":2});
		$('#bta').linkbutton({plain:true});  
		$('#btb').linkbutton({plain:true});  
		
		
		//控件声明
		$("#myForm1").panel({width:500, height:320});
		$("#id").textbox({width:120});
		
		$("#gender").combobox({width:120, data:gendersource, valueField:'gender', textField:'gender'});
		$("#type").combobox({width:120, data:typesource, valueField:'type', textField:'type'});
		
		$("#name").textbox({width:120});
		$("#ps").textbox({width:120});	
		$("#rps").textbox({width:120});
		
		$("#bta").on('click',function(){			
			//icon四种设置："error"、"info"、"question"、"warning"
			//$.messager.alert("操作提示", "您确定要执行校验操作吗！","question");  
			//fnValidation();
		});
    }); 
    
    
   
</script>
</body>
</html>

