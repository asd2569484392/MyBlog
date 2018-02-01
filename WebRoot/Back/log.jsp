<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,user-scalable=no">
		<title></title>
		<script src="//cdn.bootcss.com/jquery/2.1.4/jquery.js"></script>
		<style>
			body{
			
				width: 100%;
  				margin: 0px;
  				font-family: 'Helvetica Neue';
  				background-color: #020202;
			}
			p{
				color:#02FC00;
				margin-left: 10px; 
				font-family: "新宋体";
				font-size: 20px;
			}
		</style>
		
		<script type="text/javascript">
		function getLog(){
				
				var xmlhttp = null;
        		if(window.XMLHttpRequest){
        			xmlhttp = new XMLHttpRequest();
        		}else if(window.ActiveXObject){
        			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        		}
        		xmlhttp.onreadystatechange = function(){
        			if(xmlhttp.readyState == 4){
        				var content = xmlhttp.responseText;
        				document.getElementById("content").innerHTML += content;
        				document.getElementById("content").scrollIntoView();
        				
        			}
        		};
        		xmlhttp.open("GET", "<%=path%>/back/getLog4j.do",true);
        		xmlhttp.send();
		};
	</script>
	<script>
   
</script>
	<script type="text/javascript">
		
		window.setInterval(function (){getLog();   },2000);
	
	</script>
	
	</head>
	<body id = "body">
		<div id = "content" style=""></div>
	</body>
</html>

