<%@ page contentType="text/html" import="java.sql.*" pageEncoding="utf8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.design.entity.User_customers"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
  
    <title>answerlist</title>	
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<style>
	body{	
		font-family: "Microsoft YaHei" ! important;
	}
	#tableExcel
        {          
            border: 1px solid #ccc;
            padding: 0;
            margin: 0;
            border-collapse: collapse;
        }
     </style>
	<script type="text/javascript" src="../js/jslib/jslib.js"></script>
	<script src="../js/jquery-1.11.0.min.js"></script>
    <script src="../js/jslib/jquery.table2excel.js"></script>
    <script language="JavaScript" type="text/javascript">
		
    $(document).ready(function () {
    	var data={"qnid":GetQueryString("qnid")};	
    	var rt = fn_ajax_req("../findAnswertableAction",data);	
    	
    	var size=rt.result.length;
    	
    	var topicid=null;
    	var optionid=null;
    	
    	if(size){//设置表头及属性
    		document.getElementById("tbtitle").innerHTML="活动名："+rt.result[0].qnname;
    	}
    	for (var i=0;i<size;i++) {
			var tmp=rt.result[i];
			if(tmp.topicid!=topicid){
				topicid=tmp.topicid;
				var tds="<td>"+tmp.toorderid+"_"+tmp.tocontent+"</td>";	
				$("#tbtitles").append(tds);
			}
			if(tmp.optionid!=optionid){
				var tds="<td id="+tmp.optionid+">"+tmp.toorderid+"."+tmp.oporderid+"_"+tmp.opcontent+"</td>";	
				$("#tbtitles").append(tds);
			}		
		}	
    	//alert(document.getElementById("49").parentElement.rowIndex+1);
    	//alert(document.getElementById("49").cellIndex+1);    	
    	
    	var tablert = fn_ajax_req("../findAnswerAction",data);    	
    	var tablesize=tablert.result.length;//结果对象个数
    	//alert(tablesize);
    	
    	var userid=null;
    	var usersize=0;
    	 
    	
    	for(var j=0;j<tablesize;j++){//创建用户记录行
    		var rs=tablert.result[j];
    		if(rs.userid!=userid){
    			userid=rs.userid;
    			//alert(userid);
    			var node="<tr id='"+rs.userid+"'></tr>"; 
    			$("#tableExcel").append(node);
    		}      		
    	} 
    	
    	var auserid=null;
    	var rowsize=document.getElementById("tableExcel").rows[1].cells.length;//单元格赋空值
    	//属性个数
		//alert(rowsize);
    	//alert(tablert.result[0].userid);
    	for(var i=0;i<tablesize;i++){
			if(auserid!=tablert.result[i].userid){
				auserid=tablert.result[i].userid;
				//alert(auserid);
				for(var k=0;k<rowsize;k++){
		    		var tdnode=" ";	 
		    		var cid=document.getElementById("tableExcel").rows[1].cells[k].id;	
		    		//alert(cid);
		    		if(k==0){
		    			tdnode="<td id="+tablert.result[i].userid+cid+">"+auserid+"</td>";
		    		}else{		    			    		  	
		    			tdnode="<td id="+tablert.result[i].userid+cid+">0</td>";
		    		}
		    			//alert("1:"+tablert.result[i].userid+cid);
		    		$("#"+tablert.result[i].userid).append(tdnode);
		    	}
			}
		}
		
		for(var j=0;j<tablesize;j++){//赋值用户记录
    		var rs=tablert.result[j];
    		var opid=rs.userid+rs.optionid;
    		//alert("2:"+opid);
    		//alert(document.getElementById(opid).innerHTML)
    		document.getElementById(opid).innerHTML=1;	
    			
    	}  	
    	
		
        $("#btnExport").click(function () {//打印事件
            $("#tableExcel").table2excel({
                exclude  : ".noExl", //过滤位置的 css 类名
                filename : "新增调查记录" + new Date().getTime(), //文件名称               
                exclude_img: true,
                exclude_links: true,
                exclude_inputs: true

            });
        });
    });
    </script>

	
  </head>  
  <body >


<div >
    <button type="button" id="btnExport" onclick="method5('tableExcel')">导出Excel</button>
     <button id="btn2" onclick="history.go(-1)">返回</button>
</div>
<div id="outer" style="">	

  		<table id="tableExcel" border="1">
  			<tr>
            	<td id="tbtitle" colspan="100" align="left">活动名：测试测试</td>
        	</tr>
  			<tr id="tbtitles">   	
  				<td id="qnid">用户编码</td>  						  				
  			</tr> 		
 	 		
 	  
 	 	 
  		</table>

  </div>
  </body>
</html>
