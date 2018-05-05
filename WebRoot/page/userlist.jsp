<%@ page contentType="text/html" import="java.sql.*" pageEncoding="utf8"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/core" prefix ="c"%>
<%@ page import="java.util.*"%>
<%@ page import="com.design.entity.User_customers"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
  
    <title>userlist</title>	
	<link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">
		
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../easyui/locale/easyui-lang-zh_CN.js"></script>	
	<script type="text/javascript">
		function show_confirm()
		{
		var r=confirm("确定执行操作!");
		if (r==true)
		  {
		  alert("操作已执行!");
		  }
		else
		  {
		  alert("操作已取消!");
		  return false;
		  }
		}
</script>
  </head>  
  <body >

  <s:action name="selectUserAction"/>
<%
	List<User_customers> info = (List<User_customers>) session.getAttribute("ses") ;  	

%>


 <% 	
 	int countPerPage=10;//每页最多显示个数
 	int rowCount=0;//数据总数
 	int pageCount=0;//总页数
 	int curPage=1;//当前页数
  %>
  
  <%

		rowCount=info.size();
		pageCount=(rowCount%countPerPage==0)?(rowCount/countPerPage):(rowCount/countPerPage+1);//总页数
		String curStrPage=request.getParameter("page");
		if(curStrPage==null||curStrPage==""){
			curPage=1;
		}else{
			curPage=Integer.parseInt(curStrPage);
			if(curPage<1){
				curPage=1;
			}else if(curPage>pageCount){
				curPage=pageCount;
			}
		}
		
		if(rowCount==0){
			out.println("数据库中没有任何记录！");
		}else{							
				if(curPage<pageCount)
				info=info.subList((curPage-1)*countPerPage, (curPage-1)*countPerPage+countPerPage);	
				if(curPage>=pageCount&&curPage!=1)
				info=info.subList((curPage-1)*countPerPage, (curPage-1)*countPerPage+rowCount%countPerPage);	
				
				if(info != null){	// 有信息返回		
					pageContext.setAttribute("ref",info);					
			}
  %>
<div id="outer" style="background-color: #E0ECFF;width:1000">
  	<div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
 	 	总共<%=pageCount %>页，当前是第<%=curPage %>页
 	 	|| <a href="zhuce.jsp" data-options="iconCls:'icon-add', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="">增加</a>
 	 	|| <a href="neibu.jsp" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="">返回</a>
   </div>

  		<table border="1", width="1000", bgcolor="#eeff99">
  		
  			<tr>   	
  				<td>id</td>
  				<td>用户编码</td>  				
  				<td>姓名</td>
  				<td>类型</td>
  				<td>性别</td>
  				<td>注册日期</td>
  				<td>店铺名</td>
  				<td>网址</td>
  				<td>批准</td>
  				<td>操作1</td>
  				<td>操作2</td>
  				  				
  			</tr>
  		<%int i=0; %>	
  		<c:forEach items="${ref}" var="user">   		
 	 	<tr> 	 	
	 	 	<td><%=(curPage-1)*countPerPage+i+1%></td>
	 	 	<td>${user.id}</td>	 	 
	 	 	<td>${user.name}</td>	 	 	
	 	 	<td>${user.type}</td>
	 	 	<td>${user.gender}</td>
	 	 	<td>${user.date}</td>
	 	 	<td>${user.storename}</td>
	 	 	<td><a href="http://${user.storeurl}">${user.storeurl}</a></td>
	 	 	<td>${user.flag}</td>
	 	 	<td><a href="deleteUserAction.action?id=${user.id}" onclick="if(show_confirm()==false)return false;">删除</a></td>
  			<td><a href="checkUserAction.action?id=${user.id}" onclick="if(show_confirm()==false)return false;">审批</a></td>
 	 	</tr>   
 	 	<%
 	 		i++; 
 	 		if(i>=countPerPage)break;
 	 		
 	 	%> 
		</c:forEach>    
  		</table>
<div style="text-align:left;padding:5px">
            <a href="<%=request.getRequestURI()%>?page=1" class="easyui-linkbutton" style="width:60px;" onclick="">首页</a>
            <a href="<%=request.getRequestURI()%>?page=<%=curPage==1?1:curPage-1 %>" class="easyui-linkbutton" style="width:60px;" onclick="">上一页</a>
            <a href="<%=request.getRequestURI()%>?page=<%=curPage==pageCount?pageCount:curPage+1 %>" class="easyui-linkbutton" onclick="">下一页</a>
            <a href="<%=request.getRequestURI()%>?page=<%=pageCount %>" class="easyui-linkbutton" style="width:60px;" onclick="">末页</a>
            &nbsp;&nbsp;总共有<%=rowCount %>条记录
</div>
 <%} %>
  </div>
  </body>
</html>
