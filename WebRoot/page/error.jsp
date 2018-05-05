<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>提示页面</title>
  </head>
  
  <body>
  <div id="d1" style="margin:280">
  		<div id="img1">
	    	<img style="height:50px" src="../images/bengkui.jpg" alt=""/>	
	    	<a href="login.jsp">点击直接跳转</a>   	
		</div>
    <h3>用户信息错误或新高级用户未通过审核，请前往修改或注册！</h3>
    <h3 style="color:green ">5s后跳转....</h3>
    <%response.setHeader("Refresh","5;URL=/design/page/login.jsp");%>
  </body>
</html>
