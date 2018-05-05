<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>结果可视化</title>
    <link rel="stylesheet" type="text/css" href="../easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="../easyui/themes/icon.css">	
	
	<script type="text/javascript" src="../easyui/jquery.min.js"></script>
	<script type="text/javascript" src="../easyui/jquery.easyui.min.js"></script>
	
   <script type="text/javascript" src="../js/jslib/jslib.js"></script>
   <script type="text/javascript" src="../js/jslib/jscharts.js"></script>  
   
   
    <style>
   		#content{padding-left:15%} 
		.title {height:100px; width:100%; background:#f0f0f0;margin:-20px 0px;}	
		.h1cc{padding:20px 50px}
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
 <div onfocus="tsone()"  class="title"><h1 class="h1cc">数据可视化</h1></div>
  <div id='toolbar' class='easyui-panel' data-options="region:'north'" style="overflow:hidden; background-color: #E0ECFF; width:100%; height:30px; padding: 1px 1px 1px 10px;">
		<a  href="#" data-options="iconCls:'icon-back', plain:true" class="easyui-linkbutton" style="width:60px; " onclick="history.go(-1)">返回</a>		 			
  </div>
<div id="content">   
	<h2>柱状图</h2>
	<div id="chartcontainer1">暂无用户数据</div><br/>
	<h2>饼图</h2>
	<div id="chartcontainer2">暂无用户数据</div><br/>
</div>

<script type="text/javascript"> 
			
		function json_array(data){//数据格式转换
		    var len=eval(data).result.length;
		    //alert(len);
		    var arr=[];
		    for(var i=0;i<len;i++){
			  arr[i] =[]; //js中二维数组必须进行重复的声明，否则会undefind
			  arr[i]=["选项"+data.result[i].content,data.result[i].num];	  
		    }
		    return arr;  
		}

		var rt=null;
		var qnid=GetQueryString("qnid");
		var topicid=GetQueryString("topicid");
		
		var data={"qnid":qnid,"topicid":topicid};//参数
		//alert(data.qnid);
		rt=fn_ajax_req("findChartsdataAction",data);		
		
		var ardata=json_array(rt);
		
		//alert("mubiao:"+ardata[1]);
    //曲线图  
    /*var myData = new Array([10,20], [15,10], [20,30], [25,10], [30,5]);   
    var myChart = new JSChart('chartcontainer', 'line');  
    myChart.setDataArray(myData);  
    myChart.draw();*/  
    
    //柱状图
    var myData1 = new Array(['Unit 1',20], ['Unit 2',10], ['Unit 3',30], ['Unit 4',10],['Unit 5',5]);
    //alert("shili:"+myData1[1])
    var myChart1 = new JSChart('chartcontainer1', 'bar');
    myChart1.setDataArray(ardata);
    myChart1.draw();
    
    //饼状图
    //var myData2 = new Array(['Unit 1',20], ['Unit 2',10], ['Unit 3',30], ['Unit 4',10],['Unit 5',5],['Unit 6',15],['Unit 7',5]);
    var myChart2 = new JSChart('chartcontainer2', 'pie');
    myChart2.setDataArray(ardata);
    myChart2.draw();
    
  //饼状图（xml导入数据）
   /* var myChart3 = new JSChart('chartcontainer3', 'pie');
    myChart3.setDataXML('js/jschart_data.xml');
    myChart3.draw();
    
    //饼状图（json导入数据）
    var myChart4 = new JSChart('chartcontainer4', 'pie');
    myChart4.setDataJSON('js/jschart_data.json');
    myChart4.draw();*/
</script>  
 </body>  

</html>