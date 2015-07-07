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
	<title>历史公告</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
 function del(id){
 var Id = id;
   if(window.confirm("是否需要删除？")){
   var str = {
	           NoticeId:Id
	           };
    jQuery.ajax({
				url: "deleteN.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){
				window.location.href="noticehistory.do";										
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
<section id="main">
		
		
		<article class="module width_3_quarter">
		<header><h3 class="tabs_involved">公告列表</h3>
		</header>
		<div class="tab_container">
			<div id="tab1" class="tab_content">		
			<table class="tablesorter" > 
			  
			<thead> 
				<tr> 
				    <th>编号</th> 
    				<th>标题</th> 
    				<th>发布类型</th> 
    				<th>发布时间</th> 
    				<th>操作</th> 
				</tr> 
			</thead> 
			<tbody> 
			<c:forEach  var="notice" items="${notiList}" varStatus="n">
				<tr> 
				    <td>${notice.id}</td>
    				<td>${notice.title}</td> 
    				<td>${notice.type}</td> 
    				<td>${notice.noticeTime}</td> 
    				<td><a href="#" id="aaa${notice.id}" onclick="del(${notice.id})"><img src="images/icn_trash.png" title="Trash"></a></td> 
				</tr> 
				</c:forEach>		
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							第${p}页 &nbsp; &nbsp; 
							<a href="noticehistory.do?pageNumber=${page1}">上一页</a> 
							<a href="noticehistory.do?pageNumber=${page2}">下一页</a></td>
						</tr>
					</table> 
			</div>				
		</div><!-- end of .tab_container -->		
		</article><!-- end of content manager article -->
					
		<div class="spacer"></div>
	</section>
</body>

</html>