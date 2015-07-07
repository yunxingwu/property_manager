<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发布公告</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<script type="text/javascript">
			function check(){
			var a = document.getElementById("ti").value;
			var b = document.getElementById("con").value;
			if(a==""){
			alert("标题不能为空！");
			return false;
			}else if(b==""){
			alert("内容不能为空！");
			return false;
			}else{
			document.forms[0].submit();
			}
			}
        </script>	
</head>
  
  <body>
    <section id="main">		
	<article class="module width_full">
			<header><h3>公告发布</h3></header>
			<form action="notice.do" method="post">
				<div class="module_content">
						<fieldset style="width:48%; float:left; margin-right: 3%;"> 
						<label>标题</label>
							<input id="ti" type="text" style="width:92%;" name="title">
						</fieldset>
						<fieldset style="width:48%; float:left;"> 
							<label>类型</label>
							<select name="type">                      
                             <option>最新动态</option>
                             <option>时事热点</option>
                             <option>便民信息</option>
                             <option>生活健康</option>
                             </select>
						</fieldset><div class="clear"></div>
						<fieldset>
							<label>内容</label>
							<textarea id="con" rows="12" name="content"></textarea>
						</fieldset>
				</div>
			<footer>
				<div class="submit_link">
					<input type="button" value="发布公告" class="alt_btn" onclick="check()">
					<input type="reset" value="取消">
				</div>
			</footer>
			</form>
		</article><!-- end of post new article -->
		<div class="spacer"></div>
	</section>
  </body>
</html>
