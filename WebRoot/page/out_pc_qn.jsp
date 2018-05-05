<%@ page language="java" import="java.util.*" pageEncoding="utf8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page import="com.design.entity.User"%>
<%@ page import="com.design.entity.Qn_topic_option_Union"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  	
  <title>导出问卷</title>
    <script src="../js/jslib/jquery-git.js"></script>    
    <script src="../js/jslib/canvas.js"></script>
    <script src="../js/jslib/jspdf.debug.js"></script>
	
	<script type="text/javascript" src="../js/jslib/jslib.js"></script>
	<style>
		#content{magin-left:15%; width:80%} 
		.title {height:100px; width:100%; background:#f0f0f0;margin:-20px 0px;}	
		.h1cc{padding:20px 50px}
	</style>
	
	
	
  <style>
  	body{font-family:"microsoft yahei"; }
  	h1{color:#66CCCC;}
  	h2{color:#66CCCC;}
 
  </style>	
</head>  
  <body>

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
				<h3 name="<%=qnit.getToorderid()%>" class="tocontent oneline"><%=qnit.getToorderid()%>. <%=qnit.getTocontent()%></h3>				
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
 <script type="text/javascript">
        var pdf = new jsPDF('p','pt','a4');
        pdf.internal.scaleFactor = 1;
        var options = {
             pagesplit: true
        };

        //$('.pdf-wrapper')
        pdf.addHTML(document.body,options,function() {
            pdf.save('web.pdf');
        });
    </script>
</div>
  </body>
  </html>
