<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=GBk">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
</head>
<body style="margin: 50px 50px;background:#FFFACD ">


	<div class="easyui-panel" id="myForm1" title="&nbsp;密码修改表单" style="position:relative;" >
		
			<s:form id="update" method="POST" action="updateUserAction"  class="easyui-panel">
			<label id='id_label'>用户编号：</label>
			<div id="id_div"><input class="easyui-textbox" type="text" id="id" name="id" value="0000"></input></div>
			<label id='name_label'>用户姓名：</label>
			<div id="name_div"><input class="easyui-textbox" type="text" id="name" name="name" value="张小明"></input></div>
			<label id='ps_label'>原密码：</label>
			<div id="ps_div"><input class="easyui-textbox" type="text" id="ps" name="ps" value="1"></input></div>
			<label id='rps_label'>新密码：</label>
			<div id="rps_div"><input class="easyui-textbox" type="text" id="rps" name="password" value="123"></input></div>
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
		<a href="#" id="btb" iconCls="icon-reload"  onClick="javascript:document.getElementById('update').submit();return false;">修改</a>
		<!-- <input class="easyui-linkbutton" id="btb" type="submit" value="提交"> -->
		
     	<a id="btc" href="login.jsp" >返回登录</a>    
        </div>   
        </s:form>
		
		
		

</div>
<script>
	$(document).ready(function(){
		var typesource=[{'type':'商家'},{'type':'用户'}];
		//控件位置布局
		$("#id_label").css({position: "absolute", top:"23px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#id_div").css({position: "absolute", top:"20px", left:"76px", "z-index":2});

		$("#name_label").css({position: "absolute", top:"53px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#name_div").css({position: "absolute", top:"50px", left:"76px","z-index":2});

		$("#ps_label").css({position: "absolute", top:"83px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#ps_div").css({position: "absolute", top:"80px", left:"76px", "z-index":2});

		$("#rps_label").css({position: "absolute", top:"113px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#rps_div").css({position: "absolute", top:"110px", left:"76px", "z-index":2});
		
		$("#type_label").css({position: "absolute", top:"143px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#type_div").css({position: "absolute", top:"140px", left:"76px", "z-index":2});
		$("#info").css({position: "absolute", top:"20px", left:"276px", "z-index":2});
	
		
		$("#bt").css({position: "absolute", top:"233px", left:"76px", "z-index":2});		
		$('#btb').linkbutton({plain:true});  
		
		
		//控件声明
		$("#myForm1").panel({width:450, height:320});
		$("#id").textbox({width:120});
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

