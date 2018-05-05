<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.design.entity.User"%>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0">
 
<title>小集市平台</title>

<link rel="stylesheet" href="../css/edslider.css">
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/animate-custom.css">
<link rel="stylesheet" href="../css/menu.css">
<link href="../css/list_right.css" rel="stylesheet" type="text/css"  />   

<link rel="stylesheet" type="text/css" href="../css/zzsc-demo.css">
<link rel="stylesheet" type="text/css" href="../css/sparkle.css">

<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="../css/pubuliu_style.css"/> 
<script>
	
	
	function sjyz(){		
		var str=document.getElementById("userinfo").innerHTML;
		var type=str.substring(2,4);//取出用户类型
		//alert(type);
		if("商家"==type.trim()){
			window.location.href="shangjia.jsp";
		}else{
			alert("请使用商家账号进入！")
		}
	}
	
	function glyyz(){	
		var str=document.getElementById("userinfo").innerHTML;
		var type=str.substring(2,4);//取出用户类型
		//alert(type);
		if("管理"==type.trim()||"超级"==type.trim()){
			window.location.href="neibu.jsp";
		}else{
			alert("请使用管理员账号进入！")
		}
	}
</script>
</head>
<body>
<%
	List<User> info = (List<User>) session.getAttribute("user") ;
	
	Iterator<User> iter=null;
	String userinfo=null;
	String username=null;
	String usertype=null;
	if(info != null){	// 有信息返回
		iter = info.iterator() ;
		username=iter.next().getName();			
	}
	if(info != null){	// 有信息返回
		iter = info.iterator() ;
		usertype=iter.next().getType();			
	}
	userinfo="欢迎"+usertype+":"+username;
%>
<div class="zzsc-container">
	<div class="content">
		<div id="main" class="logo">
			 <h1 class="center">YouGou小集市</h1>			  		 
		</div>
	</div>
</div> 

<div id="menue">
	<img src="../images/background/gray.png" width="100%" height="100" alt=""/>
</div>

<div class="nav">
	<ul>
		<li><a href="myindex.jsp">首页</a></li>
		<li><a href="userqn.jsp?m=0&n=10">活动检索</a></li>
		<li><a href="#">热门推荐
		<div class="xs">
			<div class="xiao"></div>
			<img src="../images/xialatu/2.jpg" />
		</div>
		</a></li>
		<li><a href="#">商家一览</a></li>
		<li><a href="#">活动一览</a></li>
		<li><a href="#">数据查询</a></li>
		<li><a href="findgetcoupons.jsp">个人中心</a></li>
		<li><a href="#">平台地图</a></li>
		<li><a href="#">服务</a></li>
		<%
			if(userinfo.equals("欢迎"+"null"+":"+"null")){
				%>
				<li><a style="color:red" href="login.jsp">未登录，请返回登录！</a></li>
				<%
			}else{
		%>		
				
				<li><a id="userinfo" style="color:green" href="#"><%=userinfo %></a></li>
				<li><a style="color:red" href="exitAction" onclick="<%%>">注销</a></li>
		<%
		}
		 %>
		
	</ul>
</div>

<div class="container">
	<ul class="mySlideshow">
		
		<li class="first">
			<a href="https://haojue.tmall.com" target="_blank" class="animated fadeInLeft">
				<img src="../images/hd-logo.png" width="330" height="255" alt="Harley-Davidson">
			</a>
			<div class="animated fadeInRight">It's time to ride!</div>
		</li>
		<li class="second">
			<a href="https://haojue.tmall.com">
				<img src="../images/second-title.png" class="animated fadeInRight">
			</a>
		</li>
		<li class="third">
			<a href="https://haojue.tmall.com">
				<img src="../images/third-title.png" class="animated fadeInLeft">
			</a>
		</li>
		<li class="fourth">
			<a href="https://haojue.tmall.com">
				<img src="../images/fourth-title.png" class="animated fadeInRight">
			</a>
		</li>
		<li class="fifth">
			<a href="https://haojue.tmall.com">
				<img src="../images/fifth-title.png" class="animated fadeInLeft">
			</a>
		</li>
	</ul>
</div>

  <div id="right" class="list_r">
   <div id="rt">
   	<lable>便捷选项</lable>
   	<a href="#">more>></a>
   </div>
	<ul>
        	<li><a href="#" onclick="glyyz()">内部资源管理</a></li>
            <li><a href="#" onclick="sjyz()">商家服务</a></li>
            <li><a href="#">今日特价</a></li>
            <li><a href="#">超市规范条例</a></li>
            <li><a href="#">人力资源管理</a></li>
            <li><a href="#">友情网站</a></li>           
    </ul>
	</div>
	
	<div class="wrapper">
	<ul class="wall">
		<li class="article">
			<a href="#">
				<img src="../images/pubuliu/7.jpg" />
			<p>用户名用户名用户名用户名用户名</p>
				<small>热度：10000000票</small>
				<input type="button" value="参与" />
			</a>
		</li>
		<li class="article">
			<a href="#">
				<img src="../images/pubuliu/12.jpg" />
				<p>用户名用户名用户名用户名</p>
				<small>热度：10000000票</small>
				<input type="button" value="参与" />
			</a>
		</li>
		<li class="article">
			<a href="#">
				<img src="../images/pubuliu/4.jpg" />
				<p>用户名用户名用户名用户名用户名</p>
				<small>热度：10000000票</small>
				<input type="button" value="参与" />
			</a>
		</li>
		<li class="article">
			<a href="#">
				<img src="../images/pubuliu/6.jpg" />
				<p>用户名用户名用户名用户名用户名</p>
				<small>热度：10000000票</small>
				<input type="button" value="参与" />
			</a>
		</li>
	</ul>
</div>
<img src="../images/down_title.jpg" width="100%" height="120" alt=""/>

<script src="../js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="../js/jquery.edslider.js"></script>
<script>
	$(document).ready(function(){
		//Call plugin
		$('.mySlideshow').edslider({
			width : '100%',
			height: 500
		});
	});
</script>

<script type="text/javascript" src="../js/logo/sparkle.jquery.js"></script>
<script type="text/javascript">
	$("#main").sparkle({
		fill:"#f7c916"	,
		stroke:"#fde3a7",
		size: 30,
	  }).sparkle({
		delay: 1000,
		pause: 750,
		size: 10
	  });
</script>

<script src="../js/pubuliu/jaliswall.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function(){
		$('.wall').jaliswall({ item: '.article' });
	});
</script>

<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
</div>
</body>
</html>