<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="https://code.jquery.com/jquery-git.js"></script>    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
    
</head>

    
<body>
    <div class="pdf-wrapper" ="to-pdf">HTML content...<h1>中文</h1>
   ccccccccccccccccccccccccccccccccccccccccccc
        中国,汉字,测试:合同 模版 中国中国中国中国中国中国中国中国中
国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中
国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国
</br>
中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中
国中国中国中国中国中国中国中国中国中国中国中国中国中国中国中国....................<br/>
        中国,汉字,测试:合同 模版 ...................<br/>
         计费 接口 ....................<br/>
        
    </div>
   
    	sahjdasjdopjaspd
		<img src='../images/avatar.png'/>

    <script type="text/javascript">
        var pdf = new jsPDF('p','pt','a4');
        pdf.internal.scaleFactor = 1;
        var options = {
             pagesplit: true
        };

        //$('.pdf-wrapper')
        pdf.addHTML(document.body,options,function() {
            pdf.save('web1111.pdf');
        });
    </script>
</body>


</html>