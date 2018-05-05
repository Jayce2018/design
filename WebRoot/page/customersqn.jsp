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
		color:#FFF; width:70%; 
		margin-left:15%; 
		margin-top:20px;
		height:450px;
		overflow :auto;
	}
	.borderline{list-style-type:none; border-bottom:1px dashed #ccc; width:95%}
	a{text-decoration:none; color:#333333}
	a:hover{color:#99CCFF }
	#sx{
		width:50px;
		magin-left:20px;
	}
	#caozuo{color:#66CCCC;}
</style>
<link rel="stylesheet" type="text/css" href="../css/zzsc-demo.css">
<link rel="stylesheet" type="text/css" href="../css/sparkle.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	
<script type="text/javascript" src="../easyui/jquery.min.js"></script>
<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/jslib/jslib.js" charset="gbk"></script>


<script>	

	window.onload=function(){	
		onclick_event();		
		selectType();
		selectCustomers();
		init();
	};
	function init(){//初始化事件
		document.getElementById("uls").innerHTML=" ";///初始化容器				
		var keys=document.getElementById("keys").value;
		//alert(keys);
		var data={"keys":keys};//参数	
		var ht='<h2 class="borderline"><a>所有结果</a></h2><br/>'
			+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);
		rt=fn_ajax_req("fuzzyAllFindSerfinfoAction",data);			
		content(rt);
	}
	
	function onclick_event(){
			document.getElementById("fuzzy").onclick=function(){//模糊查询事件
				document.getElementById("uls").innerHTML=" ";///初始化容器				
				var keys=document.getElementById("keys").value;
				//alert(keys);
				var data={"keys":keys};//参数	
				var ht='<h2 class="borderline"><a>查询结果</a></h2><br/>'
					+'<div id="mydiv"><a>暂无该项数据</a></div>';
				$("#uls").prepend(ht);
				rt=fn_ajax_req("fuzzyAllFindSerfinfoAction",data);			
				content(rt);
		};
		
		document.getElementById("screen").onclick=function(){//点击绑定筛选查询事件
			screenSerfinfo();
		};
		/*document.getElementById("typeselect").onchange=function(){//类型改变事件
			alert(document.getElementById("typeselect").value);
		};	*/	
	}
	
	function content(rt){//加载内容函数
		if(rt.result.length>0)
		document.getElementById("mydiv").innerHTML=" ";	
		//alert(rt.result.length);	
		var size=rt.result.length;
		for (var i=0;i<size;i++) {
			var tmp=rt.result[i];
			var lis='<li class="borderline"><a  id="'+tmp.qnid+'" name="'+tmp.qnid+'" onclick="checked(this.name)" href="selectUnionQnAction?data='+tmp.qnid+'">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;活动编号：'+tmp.qnid+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;活动名称：'+tmp.qnname+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;店铺名：'+tmp.storename+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;所属类型：'+tmp.typecontent+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="caozuo" href="outPdfAction?data='+tmp.qnid+'">导出PDF</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="answerlist.jsp?qnid='+tmp.qnid+'" id="caozuo" href="myindex.jsp">导出数据</a></a></li><br/>';
			$("#mydiv").append(lis);			
		}
	}
	
	function selectType(){//类型选择框
		var rt=fn_ajax_req("typesListAction");
		var size=rt.result.length;
		for(var i=0;i<size;i++){
			var tmp=rt.result[i];
			var optionNode= '<option value="'+tmp.typecontent+'">'+tmp.typecontent+'</option>';
			$("#typeselect").append(optionNode);
		}	
	}
	
	function selectCustomers(){//店铺选择框
		var rt=fn_ajax_req("listCustomersAction");
		var size=rt.result.length;
		for(var i=0;i<size;i++){
			var tmp=rt.result[i];
			var optionNode= '<option value="'+tmp.name+'">'+tmp.name+'</option>';
			$("#storeselect").append(optionNode);
		}	
	}
	
	function screenSerfinfo(){//筛选查询事件
		document.getElementById("uls").innerHTML=" ";///初始化容器
		
		var ht='<h2 class="borderline"><a>筛选结果</a></h2><br/>'
			+'<div id="mydiv"><a>暂无该项数据</a></div>';
		$("#uls").prepend(ht);
		
		var type=document.getElementById("typeselect").value;
		var store=document.getElementById("storeselect").value;
		//alert(type+"-"+store);
		var data={"type":type,"store":store};
		var rt=fn_ajax_req("screenAllSerfinfoAction",data);
		content(rt);
		//alert(rt.result.length);
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
	userinfo=usertype+":"+username;
%>
<div class="zzsc-container">
	<div class="content">
		<div id="main" class="logo">
			 <h1 class="center">YouGou小集市</h1>
			 <h3 class="center">商家数据库</h3>			  		 
		</div>
	</div>
</div> 

<div id="menue">
	<img src="../images/background/gray.png" width="120%" height="100" alt=""/>
</div>

<div class="nav">
	<ul>
		<li><a href="shangjia.jsp">商家首页</a></li>
		<li><a href="customersqn.jsp" onclick="">所有活动</a></li>
		
		<li>类型：<select id="typeselect" >
			  <option value="">暂无参数</option> 			  
			</select>&nbsp;&nbsp;&nbsp;&nbsp;
		</li>			
		<li>店铺：<select id="storeselect">
			  <option value="">暂无参数</option> 			 
			</select>
			<input id="screen" type="button" value="筛选"/>&nbsp;&nbsp;&nbsp;&nbsp;
		</li>
		<li id="puts"><input name="keys" id="keys"/><input id="fuzzy" type="button" value="模糊查询"/></li>
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