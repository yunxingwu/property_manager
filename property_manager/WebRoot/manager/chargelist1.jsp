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
	<title>费用查询</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
</head>

<body>		
		<article class="module width_full">
		    <footer>
		    <form action="chargequery.do" method="post">
				<div class="submit_link">			
					查找条件：<select name="year">
					    <option>${y}</option>
						<option>2008</option>
						<option>2009</option>
						<option>2010</option>
						<option>2011</option>
						<option>2012</option>
						<option>2013</option>
						<option>2014</option>
					</select>年
					<select name="month">
					    <option>${m}</option>
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
					<input type="submit" value="查找" class="alt_btn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;																	
				</div>
				</form>	
			</footer>
		
		<div class="tab_container">
			<div id="tab1" class="tab_content">
			<table class="tablesorter"> 
			<thead> 
				<tr> 
				   <th>业主</th> 
   					<th>年月</th> 
    				<th>用水量</th> 
    				<th>水费</th> 
    				<th>用电量</th> 
    				<th>电费</th> 
					<th>燃气量</th>
					<th>燃气费</th>
					<th>物业管理费</th>
					<th>费用总计</th>
                    <th>缴纳状态</th>
				</tr> 
			</thead> 
			<tbody> 
			<c:forEach items="${chargelist}" var="c">
				<tr> 
				    <td>${c.userinfo.userName}</td>
   					<td>${c.month}</td> 
    				<td>${c.water}立方</td> 
    				<td>${c.rwater}元</td> 
    				<td>${c.electric}度</td> 
					<td>${c.relectric}元</td> 
					<td>${c.gas}立方</td> 
    				<td>${c.rgas}元</td> 
					<td>${c.propertyfee}元</td> 
					<td>${c.total}元</td> 
    				<td>${c.status}</td>
				</tr> 	
				</c:forEach>								
			</tbody> 
			</table>
			<table align="center" id="page">
						<tr>
							<td align="right">共${max}页&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
							第${p}页 &nbsp; &nbsp; <a
								href="chargequery.do?pageNumber=${page1}&d=${date}">上一页</a> <a
								href="chargequery.do?pageNumber=${page2}&d=${date}">下一页</a></td>
						</tr>
					</table> 
			</div>
			</div>
			</article>
		<div class="clear"></div>		
		<div class="spacer"></div>

</body>

</html>