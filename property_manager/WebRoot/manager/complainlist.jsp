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
	<title>意见列表</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
 function del(id){
 var Id = id;
 var currenTr = $("#aaa"+Id).parent().parent();
   if(window.confirm("是否需要删除？")){
   var str = {
	           complainId:Id
	           };
    jQuery.ajax({
				url: "deleteC.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){
				currenTr.remove();										
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
		<header><h3 class="tabs_involved">意见列表</h3>
		</header>
		<div class="tab_container">
			<div id="tab1" class="tab_content">		
			<table class="tablesorter" > 
			  
			<thead> 
				<tr> 
				    <th>编号</th> 
    				<th>意见人</th> 
    				<th>内容</th>  
    				<th>提议时间</th> 
    				<th>状态</th> 
				</tr> 
			</thead> 
			<tbody> 
			<c:forEach var="com" items="${complainlist}">
				<tr> 
   					<td>${com.complainId}</td>
    				<td>${com.userinfo.userName}</td> 			 
    				<td>${com.complainContent}</td> 
					<td>${com.complainTime}</td>
					<td><a href="#" id="aaa${com.id}" onclick="del(${com.id})"><img src="images/icn_trash.png" title="Trash"></a></td>
				</tr> 
				</c:forEach>			
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							第${p}页 &nbsp; &nbsp; 
							<a href="mcomplain.do?pageNumber=${page1}">上一页</a> 
							<a href="mcomplain.do?pageNumber=${page2}">下一页</a></td>
						</tr>
					</table> 
			</div>				
		</div><!-- end of .tab_container -->		
		</article><!-- end of content manager article -->				
		<div class="spacer"></div>

</body>

</html>
