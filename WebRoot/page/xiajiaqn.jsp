<%@ page language="java" import="java.util.*" pageEncoding="utf8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.design.entity.User"%>
<%@ page import="com.design.entity.Qn_topic_option_Union"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  	
  <title>下架问卷</title>
   	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<style>
		#content{magin-left:15%; width:80%} 
		.title {height:100px; width:100%; background:#f0f0f0;margin:-20px 0px;}	
		.h1cc{padding:20px 50px}
	</style>
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/jslib/jslib.js" charset="gbk"></script>
	<script>		
		function del(){
			var qnid=document.getElementById("qnid").value;
			var data = {"id":qnid};			
			var datasource=fn_ajax_req("deleteQuotaAction",data);			
			var flag=datasource.result;
			if(flag){
				alert("操作完成，问卷已下架！");
			}else{
				alert("问卷号输入有误！");
			}
		
		}	
	</script>
  <style>
  	body{font-family:"microsoft yahei"; }
  	h1{color:#66CCCC;}
  	h2{color:#66CCCC;}
  	a{
  		text-decoration:none;  
  		color:#333333;		
  	}  
  	a:hover{
  		color:green;
  	}	
  </style>	
</head>  
  <body>
  <%
	List<User> userinfo = (List<User>) session.getAttribute("user") ;	
	Iterator<User> useriter=null;	
	String userid=null;	
	if(userinfo != null){	// 有信息返回
		useriter = userinfo.iterator();
		userid=useriter.next().getId();			
	}
%>
  <div onfocus="tsone()"  class="title"><h1 class="h1cc">下架问卷</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="#" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="history.go(-1)">返回</a>	 	
  		<label style="color:red; margin-left:70%">欢迎管理员：</label><a id="userid" style="color:red; "><%=userid%></a>			
  </div>
  <div id="content" style="margin:5%">
 	问卷编号：<input id="qnid" na="qnid"/><input id="del" type="button" value="下架问卷" onclick="del()"/>
  </div>
  </body>
  </html>
