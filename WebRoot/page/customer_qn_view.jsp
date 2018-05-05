<%@ page language="java" import="java.util.*" pageEncoding="utf8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.design.entity.User"%>
<%@ page import="com.design.entity.Qn_topic_option_Union"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  	
  <title>浏览问卷</title>
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
		function jq(){
			var userid=document.getElementById("userid").innerHTML;
			var qnid=GetQueryString("data");			
			var data ={"userid":userid,"qnid":qnid};		
			fn_ajax("addGetcouponsAction",data);	
			alert("获得奖券,返回个人中心查看！");			
		}
		function submits(){
			jq();
			var userid=document.getElementById("userid").innerHTML;			
			//alert(userid);
			var options=document.getElementsByTagName("input");
			var json=[];
			
			for(var i=0;i<options.length;i++){				
				if(options[i].checked){	
					var row={};
					row.userid=userid;
					row.optionid=options[i].getAttribute("opid");	
					json.push(row);
				}				
			}
			var data = {"rs":JSON.stringify(json)};
			//alert(JSON.stringify(json));			
			fn_ajax_req("addAnswerAction",data);	
			window.location.href="myindex.jsp";
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
  <div onfocus="tsone()"  class="title"><h1 class="h1cc">浏览问卷</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="#" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="history.go(-1)">返回</a>		 	
  		<a id="update" href="#" data-options="iconCls:'icon-ok', plain:true" class="easyui-linkbutton" style="width:120px; " onclick="submits()">完成提交</a> 
  		
  		<label style="color:red; margin-left:70%">欢迎用户：</label><a id="userid" style="color:red; "><%=userid%></a>			
  </div>
  <div id="content">
 
   <%
	List<Qn_topic_option_Union> info = (List<Qn_topic_option_Union>) request.getAttribute("qn") ;

	Iterator<Qn_topic_option_Union> iter=null;	
	if(info != null){	// 有信息返回
	iter = info.iterator() ;
	int n=info.size();
	int qnid=0;
	int topicid=0;
	int optionid=0;
	int tixing=0;
		while(iter.hasNext()){					
			for(int i=0;i<n;i++){
				Qn_topic_option_Union qnit=iter.next();
				
				if(qnid!=qnit.getQnid()){//fang zhi chong fu xian shi
					qnid=qnit.getQnid();					
				%>
				<h2 name="<%=qnit.getQnid()%>" class="qnname"><%=qnit.getQnname()%></h2>			
				<%
				}		
				
				if(topicid!=qnit.getTopicid()){
					topicid=qnit.getTopicid();					
				%>
				<a href="bar.jsp?qnid=<%=qnid %>&topicid=<%=topicid %>" title="点击查看网友结果"><h3 name="<%=qnit.getToorderid()%>" class="tocontent oneline"><%=qnit.getToorderid()%>. <%=qnit.getTocontent()%></h3></a>			
				<%
				}
				
				if(optionid!=qnit.getOptionid()){
					optionid=qnit.getOptionid();
					if(qnit.getTixing()==0){
				%>
				
					<input name="<%=qnit.getTopicid()%>" type="radio" class="opcontent oneline" opid="<%=qnit.getOptionid()%>"><%=qnit.getOpcontent()%></input>				
				<%	
					}else{
						%>
						
						<input name="<%=qnit.getTopicid()%>" type="checkbox" class="opcontent oneline" opid="<%=qnit.getOptionid()%>"><%=qnit.getOpcontent()%></input>				
						<%
					}
				}
				
				
				
				
			}//for ending
		}//while ending		
	}//out if ending		
%>
</div>
  </body>
  </html>
