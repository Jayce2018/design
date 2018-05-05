<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.design.entity.User"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>问卷创建</title>
 <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/questionnaire_create.css">
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>		
  	<script type="text/javascript" src="../js/jslib/jslib.js" charset="gbk"></script>
  	<script>
  	window.onload=function(){					
		selectType();		
	};
	  function selectType(){//类型选择框
			var rt=fn_ajax_req("typesListAction");
			var size=rt.result.length;
			for(var i=0;i<size;i++){
				var tmp=rt.result[i];
				var optionNode= '<option value="'+tmp.typeid+'">'+tmp.typecontent+'</option>';
				$("#typeselect").append(optionNode);
			}	
		}
	  </script>
  </head>
  
  <body>
  <%
	List<User> info = (List<User>) session.getAttribute("user") ;	
	Iterator<User> iter=null;	
	String userid=null;
	
	String userinfo=null;
	String username=null;
	String usertype=null;
	if(info != null){	// 有信息返回
		iter = info.iterator() ;
		userid=iter.next().getId();			
	}	
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
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a href="shangjia.jsp" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="">返回</a>
  		<label class="info"><%=userinfo %></label>
  </div>
  <div class="title"><h1 class="h1cc">问卷创建</h1></div>
  <div class="content">
   		<form action="addQuestionnaireAction">
   			<div class="inputs"><label>问卷名称：</label><input name="qnname" class="ipt"/></div>
   			
   			<label class="left">问卷类型：</label><select id="typeselect" name="typeid">
						 
					 </select>			
   			<label class="left">作者编号：</label><input name="createrid" readonly="true" value="<%=userid%>" class="ipt1"/>
   			
   			<div class="inputs"><input class="cysub" type="submit" value="创建问卷"></div>	
   		</form>
   	</div>
  </body>
  </html>
