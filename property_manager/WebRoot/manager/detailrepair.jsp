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
	<title>派修详细</title>
	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />

	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen"/>
	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
</head>
<body>
		<!-- shell -->
		<div class="shell">				
			<div class="main">			
			  <article class="module width_full">
			<header><h3>派修单</h3></header>
			<form action="drepair.do" method="post">
				<div class="module_content">
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>选择维修人</label>
							<select id="bid" name="man" style="width:50%;"> 
							  <c:forEach items="${repairman}" var="man">                                            
                                <option>${man.repairMan}</option>
                                </c:forEach>                                                                                 
					</select>					
							<div style="width:40%; float:right;"></div>
						</fieldset>					
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>报修编号</label>
							<input type="text" style="width:92%;" name="rid" readonly="readonly" value="${r.repairId}">
						</fieldset><div class="clear"></div>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>报修人</label>
							<input type="text" style="width:80%;" name="sex" readonly="readonly" value="${r.userinfo.userName}">
						</fieldset>
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>户主电话</label>
							<input type="text" style="width:92%;" name="cardId" readonly="readonly" value="${r.userinfo.phone}">
						</fieldset><div class="clear"></div>					
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>报修类型</label>
							<input type="text" style="width:92%;" name="phone" readonly="readonly" value="${r.repairType}">
						</fieldset>
						<fieldset style="width:48%; float:left;">
							<label>报修时间</label>
							<input type="text" style="width:92%;" name="email" readonly="readonly" value="${r.repairTime}">
						</fieldset><div class="clear"></div>
						<fieldset>
							<label>描述</label>
							<textarea rows="12" name="repairContent" readonly="readonly">${r.repairContent}</textarea>
						</fieldset><div class="clear"></div>
				</div>
				<footer>
				<div class="submit_link1">
					<input type="submit" value="确认报修单">
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