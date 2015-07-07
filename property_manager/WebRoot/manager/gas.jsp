<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>燃气费录入</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
</head>
<script>
	function getInputValue(name,y,m) {
	var id = document.getElementsByName(name);
	
	var year = y;
	var month = m;
	var idVal = "";
	for ( var i = 0; i < id.length; i++) {
	if(id[i].value==""){alert("数据录入不完整！");return false;}	
	if(isNaN(id[i].value)){alert("输入的不为数字！");return false;}
			idVal +=id[i].value+","+id[i].id+";";
	}
	var ret = idVal.substring(0,idVal.length-1);
	//alert(ret);
	var str = {
	           ret:ret,
	           year:year,
	           month:month
	           };
		 jQuery.ajax({
				url: "gasInput.do",
				type: 'post',
				data: str,
				timeout: 60000,
				success: function(response){	
				window.location.href="success.jsp";									
						alert("数据录入成功");
						
				},
			    error: function(response){
			    	  alert("改录入条件下的数据已录入，请勿重复录入数据");
			    	  return false;
			    }	  
		   });
}
</script>

<body>		
		<article class="module width_full">	
		    <footer>
		    <form action="gas.do" method="post">
				<div class="submit_link">			
					选择年月份：<select name="year">
					<c:if test="${y!=null}">
					   <c:out value="<option>${y}</option>" escapeXml="boolean"/>
					</c:if>
						<option>2008</option>
						<option>2009</option>
						<option>2010</option>
						<option>2011</option>
						<option>2012</option>
						<option>2013</option>
						<option>2014</option>
					</select>年
					<select name="month">
					<c:if test="${m!=null}">
					   <c:out value="<option>${m}</option>" escapeXml="boolean"/>
					</c:if>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
						<option>5</option>
						<option>6</option>
						<option>7</option>
						<option>8</option>
						<option>9</option>
						<option>10</option>
						<option>11</option>
						<option>12</option>
					</select>月
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                   选择楼号：<select name="buildId">
                        <c:forEach items="${buildlist}" var="build">
                         <option>${build.buildId}</option>
                        </c:forEach>                                             
					</select>栋			
					<input type="submit" value="确定" class="alt_btn">																	
				</div>
				</form>	
			</footer>
		
		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter"> 
			<thead> 
				<tr> 
   					<th>房间号</th> 
    				<th>燃气用量（立方）</th> 
    				<th>房间号</th> 
    				<th>燃气用量（立方）</th>  
    				<th>房间号</th> 
    				<th>燃气用量（立方）</th> 
				</tr> 
			</thead> 
			<tbody> 
				<tr> 
				    <c:forEach var="house" items="${houselist}" varStatus="n">
   					<td>${house.houseId}</td> 
    				<td><input type="text" name="nwater" id="${house.houseId}"></td> 
    				<c:if test="${n.count%3 == 0}">
    				  <c:out value="</tr><tr>" escapeXml="boolean"/>
    				</c:if>
    				</c:forEach>
				</tr> 				
			</tbody> 
			</table>
			</div>
			</div>
			<footer>
				<div class="submit_link1">
					<button name="" value="" onclick="getInputValue('nwater',${y},${m})">录入</button>
				</div>
			</footer>
			</article>
			
		<div class="clear"></div>		
		<div class="spacer"></div>

</body>

</html>