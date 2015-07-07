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
	<title>新增房间</title>
	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen"/>
	
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
		<script src="js/modernizr.custom.js"></script>
	<![endif]-->
	<script src="js/functions.js" type="text/javascript"></script>
	<script type="text/javascript">
	function check(){
	var a = document.getElementById("in").value;
	var b = document.getElementById("ht").value;
	var c = document.getElementById("ha").value;
			if(a==""){
			alert("房间号不能为空！");
			return false;
			}else if(isNaN(a)){
			alert("房间号不合法！");
			return false;
			}else if(b==""){
			alert("房间类型不能为空！");
			return false;
			}else if(c==""){
			alert("房间面积不能为空！");
			return false;
			}else{
			document.forms[0].submit();
			return true;
			}
	}
	</script>
</head>
<body>
		<!-- shell -->
		<div class="shell">				
			<div class="main">				
			  <article class="module width_full">
			<header><h3>新增房间</h3></header>
			    <form action="house.do" method="post"> 
				<div class="module_content">
				<fieldset style="width:48%; float:left;margin-right: 3%;"> 
							<label>楼栋号</label>
							<select id="bid" name="builid">                      
                            <c:forEach items="${buildlist}" var="build">
                             <option>${build.buildId}</option>
                        </c:forEach>                                                                
					</select>	
						</fieldset>					
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>房间号</label>
							<input id="in" type="text" style="width:50%;" name="hid">
							<div style="width:40%; float:right;">填写房间号，如101；102</div>
						</fieldset>
						<div class="clear"></div>
						
						<fieldset style="width:48%; float:left; margin-right: 3%;"> 
						<label>房间类型</label>
							<input type="text" id="ht" style="width:92%;" name="houseType">
						</fieldset>
						<fieldset style="width:48%; float:left;"> 
							<label>面积</label>
							<input type="text" id="ha" style="width:92%;" name="area">
						</fieldset><div class="clear"></div>
						<fieldset>
							<label>备注</label>
							<textarea rows="12" name="remark"></textarea>
						</fieldset>
				</div>	
				<footer>
				<div class="submit_link1">
					<input type="button" value="提交" onclick="check()">
				</div>
			</footer>
				</form>
		</article><!-- end of post new article -->                
				</div>
				<!-- end of main -->					
		</div>
		<!-- end of shell -->
</body>
</html>