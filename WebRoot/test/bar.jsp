<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>barchart</title>
   <script type="text/javascript" src="../js/jslib/jscharts.js"></script>
    
</head>
<body>   
<div id="chartcontainer">one</div><br/>
<div id="chartcontainer1">two</div><br/>
<div id="chartcontainer2">three</div><br/>
<script type="text/javascript">  
    //曲线图
    var myData = new Array([10,20], [15,10], [20,30], [25,10], [30,5]);  
    var myChart = new JSChart('chartcontainer', 'line');  
    myChart.setDataArray(myData);  
    myChart.draw();  
    
    //柱状图
    var myData1 = new Array(['Unit 1',20], ['Unit 2',10], ['Unit 3',30], ['Unit 4',10],['Unit 5',5]);
    var myChart1 = new JSChart('chartcontainer1', 'bar');
    myChart1.setDataArray(myData1);
    myChart1.draw();
    
    //饼状图
    //var myData2 = new Array(['Unit 1',20], ['Unit 2',10], ['Unit 3',30], ['Unit 4',10],['Unit 5',5],['Unit 6',15],['Unit 7',5]);
    var myChart2 = new JSChart('chartcontainer2', 'pie');
    myChart2.setDataArray(myData1);
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