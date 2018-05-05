<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.design.entity.User"%>
<!DOCTYPE html>
<html lang="zh">
<head>
	<style>
		body{
			  font-family:"微软雅黑"; 	
		}	
		a{
			text-decoration:none;
		}	
	  	.inline{
	  		display:inline;
	  	}
		
		
		#showinfo{		
			border:1px solid #ccc;			
			width:80%;
			margin-top:5%;
			margin-left:5%;
		}
		#content{
			height:350px;
		}
		.overflow{
			overflow:auto;
		}
		#info{
			height:70px;
			width:45%;
			margin-top:5px;
			margin-left:2.5%;
			background:#CC3333;
			color:#FFFFFF;
			font-size:30px;	
			text-align:center;
			line-height:70px;					
		}
		#tt{				
			color:#FFFFFF;
			background:#66CCCC;
			padding-left:10%;
			height:30px;
			line-height:30px;		
		}		
		#tp{
			color:#FFFF66;
		}
		.baisexiaozi{
			color:#ffffff;
			font-size:5px;	
		}
		#storename{				
			margin-top:25px;
			margin-right:5px;
		}
		#date{
			
			margin-right:-65px;
			margin-top:-25px;
					
		}
		#userid{
			text-decoration:none;
			color:red;
			float:right;
			padding:5px 20px;
		}
	</style>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/questionnaire_create.css">	
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="../js/jslib/jslib.js" charset="gbk"></script>
	<script>			
		$(document).ready(function(){
			
			var myuserid=document.getElementById("userid").innerHTML;
			//alert(myuserid);
			var data={"userid":myuserid};	
			//alert(data);
			var datasource=fn_ajax_req("findGetcouponsByUseridAction",data);
			var size=datasource.result.length;
			var type=null;
			var name=null;
			var date=null;
			var url=null;
			//alert(size);
			for(var i=0;i<size;i++){
				var tmp=datasource.result[i];
				type=tmp.type;
				name=tmp.name;
				date=tmp.finaldata;
				url="http://"+tmp.storeurl;
				if(type=="0"){
					type="元优惠券";
				}else{
					type="折折扣券";
				}
				var option='<a href="'+url+'"><div id="info">'+tmp.amount+'<div class="inline" id="tp">'+type+'<div class="inline baisexiaozi" id="storename">'+name+'</div><div class="inline baisexiaozi" id="date">有效期至：'+date+'</div></div></div></a>';				
				$("#content").append(option);
			}
		})
	</script>
	<title>我的优惠券</title>
</head>
<body>
<%
	List<User> info = (List<User>) session.getAttribute("user") ;	
	Iterator<User> iter=null;
	String userid=null;	
	if(info != null){	// 有信息返回
		iter = info.iterator();
		userid=iter.next().getId();			
	}	
%>
<div class="title"><h1 class="h1cc">我的优惠券</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="#" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:110px; " onclick="window.history.back()">返回</a>	
		<a  id="userid" href="#" class="" style="width:110px; " onclick=""><%=userid %></a>	
  
  </div>
	
	<div id="showinfo">	
		<div id="tt">我的优惠券</div>
			<div id="content" class="overflow">				
		</div>
	</div>
</body>
</html>