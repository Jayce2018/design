<%@ page language="java" import="java.util.*" pageEncoding="utf8"%> 
<%@ page import="com.design.entity.User"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML >
<html>
  <head>
  	<style type="text/css">  		
		ul li{
			list-style-type:none;
			}
		.oneline{
			display:inline; 
		}
		.h3cc {color: #66CCCC; margin-left:55px; font-family: "microsoft yahei";}
	</style>
  <title>题目创建</title>
 <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="../css/questionnaire_create.css">	
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../js/editor/addtopic.js" charset="gb2312"></script>  
	
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

  <div class="title"><h1 class="h1cc">问卷题目设计</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="shangjia.jsp" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="">返回</a>
		<a id="add" href="#" data-options="iconCls:'icon-add', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="clonerd()">单选</a>
		<a id="add" href="#" data-options="iconCls:'icon-add', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="clonefx()">多选</a>
		
		||<a id="add" href="#" data-options="iconCls:'icon-sum', plain:true" class="easyui-linkbutton" style="width:70px; " onclick="orders()">实例化</a>
		<a id="add" href="#" data-options="iconCls:'icon-tip', plain:true" class="easyui-linkbutton" style="width:70px; " onclick="optiondefault()">预览</a>
  		<a id="add" href="#" data-options="iconCls:'icon-ok', plain:true" class="easyui-linkbutton" style="width:90px; " onclick="submits()">完成题目</a>  	
  		<a id="add" href="#" data-options="iconCls:'icon-print', plain:true" class="easyui-linkbutton" style="width:90px; " onclick="exportHtml();">导出</a>  
  		<a id="add" href="#" data-options="iconCls:'', plain:true" class="easyui-linkbutton" style="width:250px;margin-left:580px " onclick=""><%=userinfo %></a>  	
  </div>
  <% 
       	String str = new String(request.getParameter("qnname").getBytes("ISO-8859-1"),"utf8");  
		String qnid = new String(request.getParameter("qnid"));  	
	%> 
  <div id="qn">
  	<h3 class="h3cc oneline">问卷编号：</h3><h3 class="oneline"><%=qnid %></h3><h3 class="h3cc oneline"> 问卷名：<%=str %></h3>
  </div>
<div id="father">
<s:form action="addTopicAction" id="myform">
<fieldset id="f1">
<legend>题目</legend>
<ul>	
	<li><div id="orders" class="oneline">1. </div> <div id="topic" class="oneline">输入你的题目。</div><div id="tixing" class="tixing oneline">(单选)</div></br>
		<label><input name="n" type="radio" value="" /><label class="option">选项</label></label> 
		<label><input name="n" type="radio" value="" /><label class="option">选项</label></label> 
		<label><input name="n" type="radio" value="" /><label class="option">选项</label></label>		
	</li>	
</ul>
<input type='button' class='bn' value='删除' onclick = "deletetopic(this)"/>
<input type='button' class='bn' value='增加选项' onclick = "addoption(this);"/>
<input type='button' class='bn' value='减少选项' onclick = "desoption(this);"/>
<input type='button' class='bn' value='编辑' onclick = "editor(this)"/>
</fieldset>



<fieldset id="f2">
<legend>题目</legend>
<ul>
	<li><div id="orders2" class="oneline">2. </div> <div id="topic2" class="oneline">输入你的题目。</div><div id="tixing2" class="tixing oneline">(多选)</div></br>
		<label><input name="n" type="checkbox" value="" /><label class="option">选项</label></label> 
		<label><input name="n" type="checkbox" value="" /><label class="option">选项</label></label> 
		<label><input name="n" type="checkbox" value="" /><label class="option">选项</label></label>		
	</li>
</ul>
<input type='button' class='btnDel' value='删除' onclick = "deletetopic(this)"/>
<input type='button' class='bn' value='增加选项' onclick = "addfxoption(this);"/>
<input type='button' class='bn' value='减少选项' onclick = "desoption(this);"/>
<input type='button' class='bn' value='编辑' onclick = "editor(this)"/>
</fieldset>
</s:form>
</div>

  </body>
  </html>
