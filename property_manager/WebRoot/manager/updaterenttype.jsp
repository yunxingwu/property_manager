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
	<title>费用修改</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script type="text/javascript">
	function getInputValue(name) {
	var id = document.getElementsByName(name);
	var idVal = "";
	for ( var i = 0; i < id.length; i++) {	
	if(isNaN(id[i].value)){alert("输入的不为数字！");return false;}	
			idVal +=id[i].value+","+id[i].id+";";
	}
	var ret = idVal.substring(0,idVal.length-1);

	var str = {
	           ret:ret,
	           };
		 jQuery.ajax({
				url: "updaterent.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){	
				window.location.href="successr.jsp";																			
				},
			    error: function(response){
			    	  alert("error");
			    	  return false;
			    }	  
		   });
}
	</script>
</head>
<body>
		
		<article class="module width_full">
		<header><h3 class="tabs_involved">费用修改</h3>
		</header>
		<div class="tab_container">
			<div id="tab1" class="tab_content">			
			<table class="tablesorter" > 		  
			<thead> 
				<tr> 
				    <th>收费项目</th> 
    				<th>单位价格</th> 				 
				</tr> 
			</thead> 
			<tbody> 
			<c:forEach var="rent" items="${rentlist}">
				<tr> 
   					<td>${rent.rentName}</td> 
    				<td><input type="text" name="rentPrice" value="${rent.price}" id="${rent.id}"></td> 
				</tr> 
				</c:forEach>			
			</tbody> 
			</table>
			</div>	
			<footer>
				<div class="submit_link">
					<button name="fffff" value="发个" onclick="getInputValue('rentPrice')">确认修改</button>
				</div>
			</footer>				
		</div><!-- end of .tab_container -->		
		</article><!-- end of content manager article -->				
		<div class="spacer"></div>
</body>

</html>
