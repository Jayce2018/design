<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<style>
	body{
		  font-family:"微软雅黑"; 	
	}
	.names{ 	  
	    font-size:25px; 	
	    line-height:60px;
	    color:#66ccff;
    }
  
	.textinput{ 
		height:25px;
		width:320px;		
	    font-size:15px; 	
	}
	.bt{width:220px; height:50px; background:#66CCCC; font-size:30px; font-family: "microsoft yahei"; color:#ffffff;margin:20px 25%}
	</style>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/questionnaire_create.css">	
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script> 
	<title>商家信息添加</title>
</head>
<body>
<div class="title"><h1 class="h1cc">商家信息添加</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="login.jsp" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:110px; " onclick="">返回登录</a>	
  </div>
  
	<div class="content" style="margin-left:25%">
		<form action="addCustomersAction" method="post">
			<label class="names">商家编码：</label><input readonly="readonly" class="textinput" type="text" name="customerid" value="<%=request.getParameter("cid") %>" /><br/>
			<label class="names">店铺名称：</label><input class="textinput" type="text" name="name" /><br/>
			<label class="names">店主姓名：</label><input class="textinput" type="text" name="managername" /><br/>
			<label class="names">联系方式：</label><input class="textinput" type="text" name="phone" /><br/>
			<label class="names">店铺邮箱：</label><input class="textinput" type="text" name="mail" /><br/>
			<label class="names">店铺网址：</label><input class="textinput" type="text" name="storeurl" /><br/>
			<input type="submit" class="bt" value="提交信息"></input>
		</form>
	</div>
</body>
</html>