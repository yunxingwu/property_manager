<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>报修处理记录列表</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
</head>

<body>		
	<article class="module width_full">
		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter"> 
			<thead> 
				<tr> 
   					<th>报修编号</th> 
    				<th>维修人姓名</th> 
    				<th>派修时间</th> 
    				<th>联系电话</th> 
    				<th>状态</th> 
					<th>操作</th>
				</tr> 
			</thead> 
			<tbody>
			<c:forEach items="${repairrecord}" var="u">
				<tr> 
    				<td>${u.repairRecord}</td> 
    				<td>${u.repairMan}</td> 
    				<td>${u.repairTime}</td> 
					<td>${u.phone}</td> 
					<td>${u.result}</td> 
    				<td>
    				<c:if test="${u.result=='已派修'}">
    				<a href="achieverepair.do?reid=${u.repairRecord}">完成处理</a>
    				</c:if>
    				</td>
				</tr> 
			</c:forEach> 									
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							第${p}页 &nbsp; &nbsp; <a
								href="repairrecord.do?pageNumber=${page1}">上一页</a> <a
								href="repairrecord.do?pageNumber=${page2}">下一页</a></td>
						</tr>
					</table> 
			</div>
			</div>
			</article>
		<div class="clear"></div>		
		<div class="spacer"></div>
</body>
</html>