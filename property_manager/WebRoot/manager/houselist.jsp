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
	<title>房间列表</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script type="text/javascript">
 function del(id){
 var Id = id;
 
   if(window.confirm("是否需要删除？")){
   var str = {
	           hId:Id
	           };
    jQuery.ajax({
				url: "deleteH.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){
				window.location.href="houselist.do";							
						alert("删除成功！");
				},
			    error: function(response){
			    	  alert("删除失败,该房间存在业主！");
			    	  return false;
			    }	  
		   });
   }else{
   top.location;
   return false;
   }
   function abc(){
   alert("aaa");
   }
 }
</script>
</head>

<body>
     <div class="shell">				
	  <div class="main">	
		<article class="module width_full">
		<header><h3 class="tabs_involved">房间列表</h3>
		</header>

		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter" > 
			<thead> 
				<tr> 
    				<th>房间号</th> 
    				<th>楼号</th> 
    				<th>建筑年代</th> 
    				<th>房屋类型</th> 
					<th>建筑面积</th>
					<th>备注</th>
					<th>描述</th>
					<th>操作</th>
				</tr> 
			</thead> 
			<tbody> 
				<c:forEach var="hou" items="${houlist}">
				<tr> 
   					<td>${hou.houseId}</td> 
    				<td>${hou.build.buildId}</td> 
    				<td>${hou.build.date}</td>
    				<td>${hou.houseType}</td> 
    				<td>${hou.areas}</td> 
					<td>${hou.remark}</td>
					<td>${hou.status}</td>
					<td>
					
					<a href="#"id="aaa${hou.id}" onclick="del(${hou.id})"><img src="images/icn_trash.png" title="删除"></a></td>
				</tr> 
				</c:forEach>	
				
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							第${p}页 &nbsp; &nbsp; <a
								href="houselist.do?pageNumber=${page1}">上一页</a> <a
								href="houselist.do?pageNumber=${page2}">下一页</a></td>
						</tr>
					</table> 
			</div><!-- end of #tab1 -->				
		</div><!-- end of .tab_container -->		
		</article><!-- end of content manager article -->
					
		<div class="spacer"></div>
	</div>
	</div>
	
</body>

</html>