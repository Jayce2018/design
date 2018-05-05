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
	  	.inline{
	  		display:inline;
	  	}
		.textinput{ 
			height:25px;
			width:320px;		
		    font-size:15px; 	
		}
		.bt{width:220px; height:50px; background:#66CCCC; font-size:30px; font-family: "microsoft yahei"; color:#ffffff;margin:20px 25%}
		
		#showinfo{
			float:right;
			z-index:3;
			border:1px solid #ccc;			
			width:20%;
			margin-top:-20%;
			margin-right:5%;
		}
		#content{
			height:350px;
		}
		.overflow{
			overflow:auto;
		}
		#info{
			height:70px;
			width:95%;
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
		#ft{				
			pading-top:20px;
			margin-top:20px
		}
		#tp{
			color:#FFFF66;
		}
	</style>
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/questionnaire_create.css">	
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="../js/jslib/jslib.js" charset="gbk"></script>
	<script>
		function tx(){
			var str="固定面值:n表示n元；折扣面值：n表示n折优惠。";
			var n=document.getElementById("amount").value;
			if(n==str)
			document.getElementById("amount").value=" ";
			
		}	
		
		$(document).ready(function(){
			var cid=GetQueryString("cid");			
			var data = {"cid":cid};			
			var datasource=fn_ajax_req("findCouponsByCustomerIdAction",data);
			var size=datasource.result.length;
			var type=null;
			//alert(size);
			for(var i=0;i<size;i++){
				var tmp=datasource.result[i];
				type=tmp.type;
				if(type=="0"){
					type="元优惠券";
				}else{
					type="折折扣券";
				}
				var option='<div id="info">'+tmp.amount+'<div class="inline" id="tp">'+type+'</div></div>';				
				$("#content").append(option);
			}
			//alert(datasource.result[0].couponsid);
		})
	</script>
	<title>优惠券添加</title>
</head>
<body>
<div class="title"><h1 class="h1cc">优惠券添加</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="shangjia.jsp" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:110px; " onclick="">返回</a>	
  </div>
  
	<div class="content" style="margin-left:25%">
		<form action="addCouponsAction" method="post">			
			<label class="names">奖券类型：</label>
												<select name="type">
													  <option value="0">固定面值</option>
													  <option value="1">折扣面值</option>
												</select><br/> 
			<label class="names">奖券面值：</label><input  id="amount" class="textinput" type="text" name="amount" onclick="tx()" value="固定面值:n表示n元；折扣面值：n表示n折优惠。"/><br/>	
			<label class="names">商家编码：</label><input readonly="readonly" class="textinput" type="text" name="customerid" value="<%=request.getParameter("cid") %>" /><br/>		
			<input type="submit" class="bt" value="提交信息"></input>
		</form>
	</div>
	
	
	<div id="showinfo">	
		<div id="tt">已设置奖券</div>
			<div id="content" class="overflow">				
		</div>
	</div>
</body>
</html>