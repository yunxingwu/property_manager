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
	<title>报修列表</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
</head>
<body>
		
		<article class="module width_full">
		<header><h3 class="tabs_involved">安排维修</h3>
		</header>
		<div class="tab_container">
			<div id="tab1" class="tab_content">		
			<table class="tablesorter" > 
			  
			<thead> 
				<tr> 
				    <th>报修编号</th> 
    				<th>报修人</th> 
    				<th>报修类型</th> 
    				<th>报修描述</th> 
    				<th>报修时间</th> 
    				<th>状态</th> 
    				<th>操作</th> 
				</tr> 
			</thead> 
			<tbody> 
			<c:forEach var="repair" items="${drepairList}">
				<tr> 
   					<td>${repair.repairId}</td> 
    				<td>${repair.userinfo.userName}</td> 
    				<td>${repair.repairType}</td> 
    				<td>${repair.repairContent}</td> 
					<td>${repair.repairTime}</td>
					<td>${repair.repairStatus}</td>
					<td><a href="detailrepair.do?reid=${repair.repairId}">派修</a></td>
				</tr> 
				</c:forEach>			
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							第${p}页 &nbsp; &nbsp; <a
								href="dealrepair.do?pageNumber=${page1}&d=${date}">上一页</a> <a
								href="dealrepair.do?pageNumber=${page2}&d=${date}">下一页</a></td>
						</tr>
					</table> 
			</div>				
		</div><!-- end of .tab_container -->		
		</article><!-- end of content manager article -->				
		<div class="spacer"></div>
</body>
</html>
