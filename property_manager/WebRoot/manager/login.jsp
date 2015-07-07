<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>管理员登陆</title>
	<!--- CSS --->
	<link rel="stylesheet" href="css/style.css" type="text/css" />
	</head>
	 <body>
		<div id="container">
			<form action="Mlogin.do" method="post">
				<div class="login">后台登陆</div>
				<div class="username-text" >用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username"/>
				</div>			
				<div class="password-field">
					<input type="password" name="password"/>
				</div>
				<div class="aaa">${error}</div>
				<div class="bbb"></div>
				<input type="submit" name="submit" value="GO" />
			</form>
		</div>
		<div id="footer">
			Copyright &copy; 2014 wuyunxing All Rights Reserved.
		</div>
</body>
</html>