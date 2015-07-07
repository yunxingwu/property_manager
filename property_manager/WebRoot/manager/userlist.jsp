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
	<title>用户列表</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script type="text/javascript">
 function del(id){
 var Id = id;
   if(window.confirm("是否需要删除？")){
   var str = {
	           uId:Id
	           };
    jQuery.ajax({
				url: "deleteU.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){
				window.location.href="userlist.do";										
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
</head>

<body>		
		<article class="module width_full">
		    <footer>
		    <form action="queryuser.do" method="post">
				<div class="submit_link">			
					输入业主姓名查找：<input type="text" name="uname" width="50px">		
					<input type="submit" value="查找" class="alt_btn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																	
				</div>
				</form>	
			</footer>	
		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter"> 
			<thead> 
				<tr> 
   					<th>业主姓名</th> 
    				<th>性别</th> 
    				<th>房间号</th> 
    				<th>证件号</th> 
    				<th>工作单位</th> 
					<th>地址</th>
					<th>联系方式</th>
					<th>邮箱</th>
					<th>操作</th>
				</tr> 
			</thead> 
			<tbody>
			<c:forEach items="${ulist}" var="u">
				<tr> 
    				<td>${u.userName}</td> 
    				<td>${u.sex}</td> 
    				<td>${u.houseId}</td> 
					<td>${u.cardId}</td> 
					<td>${u.unit}</td> 
    				<td>${u.address}</td> 
					<td>${u.phone}</td> 
					<td>${u.email}</td> 
    				<td><a href="#" id="aaa${u.id}" onclick="del(${u.id})"><img src="images/icn_trash.png" title="Trash"></a></td>
				</tr> 
				</c:forEach> 									
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">第${p}页 &nbsp; &nbsp; <a
								href="userlist.do?pageNumber=${page1}">上一页</a> <a
								href="userlist.do?pageNumber=${page2}">下一页</a></td>
						</tr>
					</table> 
			</div>
			</div>
			</article>
		<div class="clear"></div>		
		<div class="spacer"></div>
</body>

</html>