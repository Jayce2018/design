<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>html 表格导出道</title>
    <script src="../js/jquery-1.11.0.min.js"></script>
    <script src="../js/jslib/jquery.table2excel.js"></script>
    <script language="JavaScript" type="text/javascript">

        $(document).ready(function () {
            $("#btnExport").click(function () {
                $("#tableExcel").table2excel({
                    exclude  : ".noExl", //过滤位置的 css 类名
                    filename : "你想说啥" + new Date().getTime(), //文件名称
                   
                    exclude_img: true,
                    exclude_links: true,
                    exclude_inputs: true

                });
            });
        });

    </script>
</head>
<body>

<div >

    <button type="button" id="btnExport" onclick="method5('tableExcel')">导出Excel</button>
</div>
<div id="myDiv">
    <table id="tableExcel" width="100%" border="1" cellspacing="0" cellpadding="0">
        <tr>
            <td colspan="5" align="center">html 表格导出道Excel</td>
        </tr>
        <tr>
            <td>列标题1</td>
            <td>列标题2</td>
            <td>类标题3</td>
            <td>列标题4</td>
            <td>列标题5</td>
        </tr>
        <tr>
            <td>aaa</td>
            <td>bbb</td>
            <td>ccc</td>
            <td>ddd</td>
            <td>eee</td>
        </tr>
        <tr>
            <td>AAA</td>
            <td>BBB</td>
            <td>CCC</td>
            <td>DDD</td>
            <td>EEE</td>
        </tr>
        <tr>
            <td>FFF</td>
            <td>GGG</td>
            <td>HHH</td>
            <td>III</td>
            <td>JJJ</td>
        </tr>
    </table>
</div>
</body>
</html>