<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>新增用户</title>
	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />

	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen"/>
	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
	<script type="text/javascript">
	function check(){
	var a = document.getElementById("n").value;
	var c = document.getElementById("cid").value;
	var d = document.getElementById("ph").value;
	var email = document.getElementById("e").value;
	var match = /^[0-9a-zA-Z]+@(([0-9a-zA-Z]+)[.])+[a-z]{2,4}$/i;
			if(a==""){
			alert("姓名不能为空！");
			return false;
			}else if(c==""){
			alert("证件号不能为空！");
			return false;
			}else if(isNaN(c)){
			alert("非法证件号！");
			return false;
			}else if(d==""){
			alert("联系方式不能为空！");
			return false;
			}else if(isNaN(c)){
			alert("联系方式不合法！");
			return false;
			}else if(!match.test(email)){
			alert("邮箱不合法！");
			return false;
			}else{
			document.forms[0].submit();
			return true;
			}

	}
	</script>
</head>
<body>
		<!-- shell -->
		<div class="shell">				
			<div class="main">			
			  <article class="module width_full">
			<header><h3>新增用户</h3></header>
			<form action="adduser.do" method="post">
				<div class="module_content">
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>房号</label>
							<select id="bid" name="houseId" style="width:50%;"> 
							  <c:forEach items="${hlist}" var="h">                                            
                                <option>${h.houseId}</option>
                                </c:forEach>                                                                                 
					</select>	
							<div style="width:40%; float:right;"></div>
						</fieldset>					
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>用户姓名</label>
							<input type="text" id="n" style="width:92%;" name="uname">
						</fieldset><div class="clear"></div>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>性别</label>
							<input type="radio" id="s" style="width:10%;" name="sex" value="男" checked>男
							<input type="radio" id="s" style="width:10%;" name="sex" value="女">女
						</fieldset>
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>证件号码</label>
							<input type="text" id="cid" style="width:92%;" name="cardId">
						</fieldset><div class="clear"></div>					
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>联系方式</label>
							<input type="text" id="ph" style="width:92%;" name="phone">
						</fieldset>
						<fieldset style="width:48%; float:left;">
							<label>Email</label>
							<input type="text" id="e" style="width:92%;" name="email">
						</fieldset><div class="clear"></div>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>住址</label>
							<input type="text" id="ad" style="width:92%;" name="address">
						</fieldset>
						<fieldset style="width:48%; float:left;">
							<label>工作单位</label>
							<input type="text" style="width:92%;" name="unit">
						</fieldset><div class="clear"></div>
				</div>
				<footer>
				<div class="submit_link1">
					<input type="button" value="提交" onclick="check()">
				</div>
			</footer>	
			</form>
		</article><!-- end of post new article -->
	                 
				</div>
				<!-- end of main -->					
		</div>
		<!-- end of shell -->
</body>
</html>