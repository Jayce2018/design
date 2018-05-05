<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>test</title>  
</head>

    
<body>
   <table onmousemove="getinfo()"> 
<tr>    <td>11</td>    <td>12</td>    <td>13</td></tr> 
<tr>    <td>21</td>    <td>22</td>    <td>23</td></tr> 
<tr>    <td>31</td>    <td>32</td>    <td>33</td></tr> 
</table> 
<span id=info></span> 
<script language="JavaScript"> 
<!-- 
function getinfo(){ 
var e=event.srcElement; 
if(e.tagName=="TD"){ 
var r=e.parentElement.rowIndex +1; 
var c = e.cellIndex +1; 
var a=e.innerText;
info.innerText = "当前行号：" + r + " 当前列号：" + c+" 值:"+a; 
} 
} 
//--> 
</script> 
</body>


</html>