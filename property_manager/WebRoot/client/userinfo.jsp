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
	<title>用户信息修改</title>
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	<script type="text/javascript">
        	function changeIframe(src,user){
        	var u = user;
        	if(!u){
        	alert("请先登录系统");
        	return;
        	}
			window.location =src;
			}
        </script>
</head>
<body>
		<!-- wrapper -->
 <div id="wrapper">	
		<!-- shell -->
	<div class="shell">
		<!-- container -->
	<div class="container">
       <div class="heard">
        <div class="logo"></div>
         <div class="land">
         <c:choose>
           <c:when test="${userinfo==null}">
           <form action="Ulogin.do" method="post">
               <ul>          
                <li>用户名:&nbsp;<input name="username" type="text" />
                                                             密码:&nbsp;<input name="password" type="password" />
                     <button type="submit">登     陆</button></li>
                <li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${error}</li>             
             </ul>
             </form>
           </c:when>
           <c:otherwise>       
                <div class="aaa">当前用户:&nbsp;${userinfo.userName}
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <a href="exit.do">注销</a></div>          
           </c:otherwise>
         </c:choose>         
       </div>
     </div>							
			<!-- header -->
				<header class="header">	
					<nav id="navigation">				
						<ul>
							<li class="active"><a href="index.do">首页</a></li>
							<li><a href="#">关于我们</a></li>
							<li>
								<a href="#">在线报修<span></span></a>
								<ul>
									<li ><a href="javascript:void(0)" onclick="changeIframe('addrepair.jsp','${userinfo}')">新增报修</a></li>
									<li><a href="javascript:void(0)" onclick="changeIframe('history.do','${userinfo}')">报修记录</a></li>
								</ul>
							</li>
							<li>
								<a href="#" onclick="changeIframe('charge.do','${userinfo}')">费用查询</a>				
							</li>
							<li>
								<a href="#">意见箱<span></span></a>
								<ul>
									<li><a href="#" onclick="changeIframe('complain.jsp','${userinfo}')">提出意见</a></li>
									<li><a href="#" onclick="changeIframe('historycomplain.do','${userinfo}')">消息记录</a></li>								
								</ul>
							</li>
							<li><a href="#" onclick="changeIframe('userinfo.jsp','${userinfo}')">用户信息</a></li>
							<li><a href="#" onclick="changeIframe('updatepassword.jsp','${userinfo}')">修改密码</a></li>
							
						</ul>
					</nav>
					<div class="cl">&nbsp;</div>
				</header>
				<!-- end of header -->
				<div id="main">
		  <article class="module width_full">
			<header><h3>用户基本信息</h3></header>
			<form action="updateuser.do" method="post">
				<div class="module_content">
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>姓名</label>
							<input type="text" style="width:80%;" name="uname" readonly="readonly" value="${userinfo.userName}" >
						</fieldset>
						<fieldset style="width:48%; float:left;"> <!-- to make two field float next to one another, adjust values accordingly -->
							<label>证件号码</label>
							<input type="text" style="width:92%;" name="cardId" value="${userinfo.cardId}">
						</fieldset><div class="clear"></div>					
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>联系方式</label>
							<input type="text" style="width:92%;" name="phone" value="${userinfo.phone}">
						</fieldset>
						<fieldset style="width:48%; float:left;">
							<label>Email</label>
							<input type="text" style="width:92%;" name="email" value="${userinfo.email}">
						</fieldset><div class="clear"></div>
						<fieldset style="width:48%; float:left; margin-right: 3%;"> <!-- to make two field float next to one another, adjust values accordingly -->
						<label>住址</label>
							<input type="text" style="width:92%;" name="address" value="${userinfo.address}">
						</fieldset>
						<fieldset style="width:48%; float:left;">
							<label>工作单位</label>
							<input type="text" style="width:92%;" name="unit" value="${userinfo.unit}">
						</fieldset><div class="clear"></div>
				</div>
				
				<div class="submit_link">
					<input type="submit" value="保存">
				</div>
		
			</form>
		</article><!-- end of post new article -->
					<section class="services">
						<div class="widget">
							<h3>关于项目开发</h3>
							<p>客服电话：4000 960 960（个人） 4000 980 980（企业）</p>
							<p>广西科技大学  计算机学院          计Y104   伍运星 </p>
						</div>
						<div class="widget contact-widget">
							<h3>联系我们</h3>
							<ul>
								<li><strong>电话: </strong>655-606-605</li>
								<li><strong>Email:</strong>8888888888@xf.com</li>
							</ul>
						</div>
						<div class="widget socials-widget">
							<h3>社区</h3>
							<a href="#" class="facebook-ico">facebook</a>
							<a href="#" class="twitter-ico">twitter</a>
							<a href="#" class="rss-ico">rss</a>
							<a href="#" class="in-ico">in</a>
							<a href="#" class="skype-ico">skype</a>
							<a href="#" class="google-ico">google</a>
						</div>
						<div class="cl">&nbsp;</div>
					</section>
					<!-- end of services -->
		</div>
				</div>
			<!-- end of container -->	
			<div class="footer">
				<nav class="footer-nav">
					<ul>
						<li><a href="#">首页</a></li>
						<li><a href="#">关于我们</a></li>
						<li><a href="#">用户报修</a></li>
						<li><a href="#">费用查询</a></li>
						<li><a href="#">意见箱</a></li>
						<li><a href="#">公告信息栏</a></li>
					</ul>
				</nav>
				<p class="copy">Copyright &copy; 2014 wuyunxing All Rights Reserved.</p>
			</div>	
		</div>
		<!-- end of shell -->
	</div>
	<!-- end of wrappert -->
</body>
</body>
</html>