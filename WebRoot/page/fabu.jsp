<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%request.setCharacterEncoding("gbk");%>
<html>
<head>
	  <meta http-equiv="Content-Type" content="text/html; charset=GBk">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/jslib/jslib.js" charset="gbk"></script>
	<script>
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
				var option='<option value="'+tmp.couponsid+'">'+tmp.amount+type+'</option>';				
				$("#coupons").append(option);
			}
			//alert(datasource.result[0].couponsid);
		})		
	</script>
	<title>问卷发布</title>
</head>
<body style="margin: 50px 50px;background:#FFFACD ">
<%String qnid=request.getParameter("qnid"); %>
	<div class="easyui-panel" id="myForm1" title="&nbsp;问卷发布" style="position:relative;" >
		
			<s:form id="insert" method="POST" action="addQuotaAction"  class="easyui-panel" namespace="/page" >
			<label id='qnid_label'>问卷编号：</label>
			<div id="qnid_div"><input class="easyui-textbox" type="text" id="qnid" name="qnid"></input></div>
			<label id='endingdate_label'>截止日期：</label>
			<div id="endingdate_div"><input class="easyui-datebox" type="text" id="endingdate" name="endingdate"></input></div>
			<label id='coupons_label'>奖券设置：</label>
			<div id="coupons_div">
				<input  class="easyui-combbox" type="text" value="" list="coupons" name="couponsid" onclick="datasource()"/>  
				    <datalist id="coupons">  
				      <!--option value="1">5元优惠券</option>   
				      <option value="2">8折折扣券</option>   
				      <option value="3">20元优惠券</option-->   
				    </datalist> 
			</div>
			
				<div id="bt">	
				<input type="submit"></input>	
				<input type="reset" value="重置">
				
				<!--  <a href="#" id="bta" iconCls="icon-redo"  onClick="javascript:document.getElementById('DengLu').submit();return false;">登录</a>  
				-->
		        </div>  
			</s:form>
	</div> 
			
			
		


<script>
	$(document).ready(function(){	
		//控件位置布局
		$("#qnid_label").css({position: "absolute", top:"23px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#qnid_div").css({position: "absolute", top:"20px", left:"76px", "z-index":2});

		$("#endingdate_label").css({position: "absolute", top:"53px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#endingdate_div").css({position: "absolute", top:"50px", left:"76px","z-index":2});
		
		$("#coupons_label").css({position: "absolute", top:"88px", left:"10px", width:"65px", "text-align":"right", "z-index":2});
		$("#coupons_div").css({position: "absolute", top:"85px", left:"76px","z-index":2});
		
	
		
		$("#bt").css({position: "absolute", top:"123px", left:"106px", "z-index":2});
		$('#bta').linkbutton({plain:true});  
		$('#btb').linkbutton({plain:true});  		
		
		//控件声明
		$("#myForm1").panel({width:300, height:320});
		$("#qnid").textbox({width:120});
		
		$("#qnid").textbox('setValue','<%=qnid%>');
		$("#endingdate").datebox();
		
		
		
	
		
		$("#bta").on('click',function(){			
			//icon四种设置："error"、"info"、"question"、"warning"
			//$.messager.alert("操作提示", "您确定要执行校验操作吗！","question");  
			//fnValidation();
		});
    }); 
    
    
   
</script>
</body>
</html>

