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
<script type="text/javascript">
 function del(id){
 var Id = id;
   if(window.confirm("是否需要删除？")){
   var str = {
	           reId:Id
	           };
    jQuery.ajax({
				url: "deleteR.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){
				window.location.href="mrepair.do";										
						alert("删除成功！");
				},
			    error: function(response){
			    	  alert("删除失败！");
			    	  return false;
			    }	  
		   });
   }else{
   top.location;
   return false;
   }
 }
</script>
<body>
		
		<article class="module width_full">
		<header><h3 class="tabs_involved">报修列表</h3>
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
			<c:forEach var="repair" items="${repairList}">
				<tr> 
   					<td>${repair.repairId}</td> 
    				<td>${repair.userinfo.userName}</td> 
    				<td>${repair.repairType}</td> 
    				<td>${repair.repairContent}</td> 
					<td>${repair.repairTime}</td>
					<td>${repair.repairStatus}</td>
					<c:if test="${repair.repairStatus=='已处理'}">
					<td><a href="#" id="aaa${repair.id}" onclick="del(${repair.id})"><img src="images/icn_trash.png" title="Trash"></a>
					</c:if>
					</td>
				</tr> 
				</c:forEach>			
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
							第${p}页 &nbsp; &nbsp; 
							<a href="mrepair.do?pageNumber=${page1}">上一页</a> 
							<a href="mrepair.do?pageNumber=${page2}">下一页</a></td>
						</tr>
					</table> 
			</div>				
		</div><!-- end of .tab_container -->		
		</article><!-- end of content manager article -->				
		<div class="spacer"></div>

</body>

</html>
