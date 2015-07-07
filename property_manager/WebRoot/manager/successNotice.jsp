<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>报修成功</title>
	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen"/>
	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
		<script src="js/modernizr.custom.js"></script>
	<![endif]-->
	<script>
   var time=3;
  
   function timedown()
   {
    time=time-1;
    if (time<1)
     window.location.href='historypublish.jsp' ;
   }
  
   setInterval("timedown()",1000);
</script>
</head>
  
  <body>
    <section id="main" class="column">	
		<h4 class="alert_success">公告发布成功！</h4>
		</section>
  </body>
</html>
