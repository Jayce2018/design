<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.design.entity.User"%>
<!DOCTYPE html>
<html>
<head>

 
<title>小集市平台</title>
<link rel="stylesheet" href="../css/styles.css">
<link rel="stylesheet" href="../css/animate-custom.css">
<link rel="stylesheet" href="../css/menu.css">
<link href="../css/list_right.css" rel="stylesheet" type="text/css"  />   
<style>
	.oneline{
		display:inline;
	}
	
	#mq{	
			padding-top:10px;
			float:left;	
	}
</style>
<link rel="stylesheet" type="text/css" href="../css/zzsc-demo.css">
<link rel="stylesheet" type="text/css" href="../css/sparkle.css">
<link rel="stylesheet" type="text/css" href="../css/pubuliu_style.css"/> 
<link href="../css/win8.css" rel="stylesheet" type="text/css"/>
<script>
	window.onload=function(){
	    //alert("提示：请先上传优惠券！");
	}
</script>

</head>
<body>
<%
	List<User> info = (List<User>) session.getAttribute("user") ;	
	Iterator<User> iter=null;
	String userinfo=null;
	String username=null;
	String userid=null;
	String usertype=null;
	if(info != null){	// 有信息返回
		iter = info.iterator() ;
		username=iter.next().getName();			
	}
	if(info != null){	// 有信息返回
		iter = info.iterator() ;
		userid=iter.next().getId();		
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
			 <h3 class="center oneline">商家服务系统</h3>			 	  		 
		</div>		
	</div>
</div> 

<div id="menue">
	<img src="../images/background/gray.png" width="100%" height="100" alt=""/>	
</div>
<div  class="oneline" id="mq"><marquee behavior="scroll">温馨提示：请商家确保有优惠券信息！</marquee></div>
<div class="nav">
	<ul>
		<li><a href="myindex.jsp">首页</a></li>
		<li><a href='addcoupons.jsp?cid=<%=userid %>'>上传优惠券</a></li>
		<li><a href="#">热门推荐
		<div class="xs">
			<div class="xiao"></div>
			<img src="../images/xialatu/2.jpg" />
		</div>
		</a></li>	
		
		
		<li><a href="#">数据查询</a></li>
		<li><a href="#">个人信息</a></li>
		<li><a href="#">平台地图</a></li>
		<li><a href="#">服务</a></li>
		<%
			if(userinfo.equals("欢迎"+"null"+":"+"null")){
				%>
				<li><a style="color:red" href="login.jsp">未登录，请返回登录！</a></li>
				<%
			}else{
		%>		
				
				<li><a style="color:green" href="#"><%=userinfo %></a></li>
				<li><a style="color:red" href="exitAction" onclick="<%%>">注销</a></li>
		<%
		}
		 %>	
			
	</ul>
</div>


<div class="index-con" style="z-index: 0">
  <ul>
    <li class="in-kct in-course"> <a href="#" title="视频">
      <div class="in-block"> <i class="bigger"></i> <span class="ch show" style="display: block;">视频</span> <i class="in-none"></i> <span class="in-text" style="display: none;">
        <p><em>小集市</em>&nbsp;&nbsp;个性化推荐 </p>       
        </span> </div>
      </a> </li>
    <li class="in-kct in-quest"> <a href="createqn.jsp" title="创建问卷">
      <div class="in-block"> <i class=""></i> <span class="ch" style="display: inline;">创建</span> <i class="in-none"></i> <span class="in-text" style="display: none; width: 280px; left: 30px">
        <p><em>个性化</em>活动调查、<em>用户</em>流量吸引</p>
        <p>让你的销售额<em>提升更容易</em>！</p>
        </span> </div>
      </a> </li>
    <li class="in-jbk in-plan"> <a href="#" title="每日推荐">
      <div class="in-block"> <i style="display: block;"></i> <span style="display: inline;">每日推荐</span> <i class="in-none toLeft1" style="display: none;"></i> <span class="in-text" style="display: none;">
        <p>完备的规划是指引</p>
        <p>我们取得成功的前提</p>
        </span> </div>
      </a> </li>
    <li class="in-jbk in-report"> <a href="#" title="活动帮助">
      <div class="in-block"> <i style="display: block;"></i> <span style="display: inline;">活动帮助</span> <i class="in-none toLeft2" style="display: none;"></i> <span class="in-text" style="display: none;">
        <p>分布解析</p>
        <p>小白参与的有力助手</p>
        </span> </div>
      </a> </li>
    <li class="in-zxl in-forma"> <a href="ownqn.jsp" title="我的数据">
      <div class="in-block"> <i style="display: block;"></i> <span style="display: inline;">我的数据</span> <i class="in-none toLeft0 toLeft4" style="display: none;"></i> <span class="in-text" style="display: none;">
        <p>已发布活动、未发布活动、问卷可视化一览</p>
     
        </span> </div>
      </a> </li>
    <li class="in-zxl in-means"> <a href="customersqn.jsp" title="数据下载">
      <div class="in-block"> <i></i> <span>数据下载</span> <i class="in-none"></i> <span class="in-text">
        <p>相关商品数据</p>
        <p>应有尽有</p>
        </span> </div>
      </a> </li>
    <li class="in-jbk in-client"> <a href="#" target="_blank" title="微社区">
      <div class="in-block"> <i></i> <span>微社区</span> <i class="in-none"></i> <span class="in-text">
        <p>在线交流</p>
        <p>让你店铺经营更简单</p>
        </span> </div>
      </a> </li>
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


<script src="../js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="../js/win8/core.js" type="text/javascript"></script>

<script>
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