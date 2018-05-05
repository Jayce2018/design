<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.design.entity.User"%>
<%@ page import="com.design.entity.Questionnaire"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>

 
<title>小集市平台</title>


<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/animate-custom.css">
<link rel="stylesheet" href="../css/menu.css">

<link rel="stylesheet" type="text/css" href="../css/zzsc-demo.css">
<link rel="stylesheet" type="text/css" href="../css/sparkle.css">


<style>
	#content{
		background:#ffffff; 
		color:#FFF; 
		height:350px;
		width:70%; 
		margin-left:15%; 
		margin-top:40px;		
		overflow:auto;
	}
	.borderline{list-style-type:none; border-bottom:1px dashed #ccc; width:95%}
	#caozuo{color:#99CCFF}
	a{text-decoration:none; color:#333333}
	a:hover{color:#99CCFF }
	
</style>
<link rel="stylesheet" type="text/css" href="../css/zzsc-demo.css">
<link rel="stylesheet" type="text/css" href="../css/sparkle.css">

<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../js/jslib/jslib.js"></script>


<script>	
	function reload(){
		 location.reload(); 
	}
	window.onload=function(){
		myall();
	};
	
	function clean(rt){//清理暂无标记
		if(rt.result.length>0)
		document.getElementById("mydiv").innerHTML=" ";			
	}
	
	function myall() {//我的所有问卷 				
		document.getElementsByTagName("ul")[1].innerHTML=" ";
		var d=document.getElementById("flaguserid").innerHTML;
		var data={"createrid":document.getElementById("flaguserid").innerHTML};	
		var ht='<h2 class="borderline"><a>我的所有问卷</a></h2><br/>'
			+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);		
		
		var rt = fn_ajax_req("../selectQuestionnaireAction",data);	
		clean(rt);
		
		var size=rt.result.length;
		for (var i=0;i<size;i++) {
			var tmp=rt.result[i];
			var lis='<li class="borderline"><a href="#">'+tmp.qnid+':'+tmp.qnname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建人：'+tmp.createrid+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：'+tmp.createdate+'</a></li><br/>';
			$("#mydiv").append(lis);		
		}	
	}
	
	function dfb() {//待发布问卷 				
		document.getElementsByTagName("ul")[1].innerHTML=" ";			
		//alert(d);
		var data={"createrid":document.getElementById("flaguserid").innerHTML};	
		var ht='<h2 class="borderline"><a>待发布问卷</a></h2><br/>'
			+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);	
		
		var rt = fn_ajax_req("../finddfbQnAction",data);
		clean(rt);

		var size=rt.result.length;
		for (var i=0;i<size;i++) {
			var tmp=rt.result[i];
			var lis='<li class="borderline"><a href="#">'+tmp.qnid+'</a><a title="点击发布该条问卷" href="fabu.jsp?qnid='+tmp.qnid+'&cid='+tmp.createrid+'" onclick="fb(this)">: '+tmp.qnname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建人：'+tmp.createrid+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：'+tmp.createdate+'</a></li><br/>';
			$("#mydiv").append(lis);		
		}	
	}
	function yfb() {//已发布问卷 				
		document.getElementsByTagName("ul")[1].innerHTML=" ";			
		//alert(d);
		var data={"createrid":document.getElementById("flaguserid").innerHTML};	
		var ht='<h2 class="borderline"><a>已发布问卷</a></h2><br/>'
			+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);
			
		var rt = fn_ajax_req("../findyfbQnAction",data);
		clean(rt);	
		output(rt);
	}
	
	function output(rt){//输出类条目子节点
		var size=rt.result.length;
		for (var i=0;i<size;i++) {
			var tmp=rt.result[i];
			var lis='<li class="borderline"><a href="#">'+tmp.qnid+'</a><a title="点击浏览问卷" href="selectUnionQnAction?data='+tmp.qnid+'" onclick=" ">: '+tmp.qnname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建人：'+tmp.createrid+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：'+tmp.createdate+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;结束时间：'+tmp.endingdate+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="caozuo" href="outPdfAction?data='+tmp.qnid+'">导出PDF</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="answerlist.jsp?qnid='+tmp.qnid+'" id="caozuo" href="myindex.jsp">导出数据</a></a></li><br/>';
			$("#mydiv").append(lis);		
		}
	}
	
	function ysj() {//已设计问卷 				
		document.getElementsByTagName("ul")[1].innerHTML=" ";			
		//alert(d);
		var data={"createrid":document.getElementById("flaguserid").innerHTML};	
		var ht='<h2 class="borderline"><a >已完成设计问卷</a></h2><br/>'
			+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);	
			
		var rt = fn_ajax_req("../findysjQnAction",data);
		clean(rt);
		
		var size=rt.result.length;
		for (var i=0;i<size;i++) {
			var tmp=rt.result[i];
			var lis='<li class="borderline"><a href="#">'+tmp.qnid+'</a><a title="点击浏览问卷" href="selectUnionQnAction?data='+tmp.qnid+'" onclick=" ">: '+tmp.qnname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建人：'+tmp.createrid+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：'+tmp.createdate+'</a></li><br/>';
			$("#mydiv").append(lis);		
		}	
	}
	
	function wwc() {//未完成问卷 				
		document.getElementsByTagName("ul")[1].innerHTML=" ";			
		//alert(d);
		var data={"createrid":document.getElementById("flaguserid").innerHTML};		
		var ht='<h2 class="borderline"><a >未完成设计问卷</a></h2><br/>'
		+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);		
		var rt = fn_ajax_req("../findwwcQnAction",data);
		clean(rt);
		
		var size=rt.result.length;		
			for (var i=0;i<size;i++) {
				var tmp=rt.result[i];
				var lis='<li class="borderline"><a href="#">'+tmp.qnid+'</a><a title="点击完成问卷" href="completeqn.jsp?qnid='+tmp.qnid+'&qnname='+tmp.qnname+'"  onclick=" ">: '+tmp.qnname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建人：'+tmp.createrid+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间：'+tmp.createdate+'</a></li><br/>';
				$("#mydiv").append(lis);	
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
	String userid=null;
	if(info != null){	// 有信息返回
		iter = info.iterator() ;
		username=iter.next().getName();			
	}
	if(info != null){	// 有信息返回
		iter = info.iterator();
		usertype=iter.next().getType();			
	}
	if(info != null){	// 有信息返回
		iter = info.iterator();
		userid=iter.next().getId();			
	}
	userinfo="欢迎"+usertype+":"+username;
%>
<div class="zzsc-container">
	<div class="content">
		<div id="main" class="logo">
			 <h1 class="center">YouGou小集市</h1>
			 <h3 class="center">商家服务系统</h3>			  		 
		</div>
	</div>
</div> 

<div id="menue">
	<img src="../images/background/gray.png" width="100%" height="100" alt=""/>
</div>

<div class="nav">
	<ul>
		<li><a href="shangjia.jsp">商家首页</a></li>
		<li><a href="#" onclick="ysj();">已设计问卷</a></li>
		<li><a href="#" onclick="dfb();">发布问卷</a></li>
		<li><a href="#" onclick="yfb();">已发布问卷</a></li>
		<li><a href="#" onclick="wwc();">未完成问卷</a></li>
		<li><a href="#">数据查询</a></li>			
		<li><a href="#">平台地图</a></li>
		<li><a href="#">服务</a></li>
		<li><a id="flaguserid" style="color:green" href="#"><%=userid %></a></li>	
		<%
			if(userinfo.equals("欢迎"+"null"+":"+"null")){
				%>
				<li><a style="color:red" href="login.jsp">未登录，请返回登录！</a></li>
				<%
			}else{
		%>		
				
				<li><a style="color:green" href="#"><%=userinfo %></a></li>
		<%
		}
		 %>
		
	</ul>
</div>
<div id="content"><!--原始内容容器 -->
	<ul id="uls"></ul>
</div>



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



<script>//星光js结合css使用
    seajs.use('jquery',function($) {
        $(function () {
             //
            $(".index-con .in-kct").hover(function() {
                $(this).find('i:first').addClass('smaller').removeClass('bigger')
                $(this).find('span:first').fadeOut('')
                $(this).find('.in-text').show('fast').addClass('show')
                $(this).find('.ch').removeClass('')
            }, function() {
                $(this).find('i:first').removeClass('smaller').addClass('bigger')
                $(this).find('span:first').fadeIn('')
                $(this).find('.in-text').hide('').removeClass('fast')
                $(this).find('.ch').addClass('show')
            })
            $(".index-con .in-jbk").hover(function() {
                $(this).find('i:first').addClass('hide')
                $(this).find('span:first').hide('')
                $(this).find('.in-text').show('').addClass('show')
                var num = $(this).index('.in-jbk') + 1;
                $(this).find('.in-none').show('').addClass('toLeft' + num).removeClass('toRight' + num)
                $(this).find('.ch1').removeClass('show')
            }, function() {
                $(this).find('i:first').addClass('hide')
                $(this).find('span:first').fadeIn('')
                $(this).find('.in-text').hide('').removeClass('show')
                var num = $(this).index('.in-jbk') + 1;
                $(this).find('.in-none').show().addClass('toRight' + num).removeClass('toLeft' + num)
                $(this).find('.ch1').addClass('show')
            })
            $(".index-con .in-zxl").hover(function() {
                $(this).find('i:first').addClass('hide')
                $(this).find('span:first').hide('')
                $(this).find('.in-text').show().addClass('show')
                var nums = $(this).index('.in-zxl') + 1;
                $(this).find('.in-none').show().addClass('toLeft4').removeClass('toRight4')
                $(this).find('.ch2').removeClass('show')
            }, function() {
                $(this).find('i:first').addClass('hide')
                $(this).find('span:first').fadeIn('fast')
                $(this).find('.in-text').hide().removeClass('show')
                $(this).find('.in-none').show().addClass('toRight4').removeClass('toLeft4')
                $(this).find('.ch2').addClass('show')
            });
        });
    })
</script>
</body>
</html>