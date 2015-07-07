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
	<title>新增报修</title>
	<link rel="shortcut icon" type="image/x-icon" href="css/images/favicon.ico" />
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen"/>
	
	<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
		<script src="js/modernizr.custom.js"></script>
	<![endif]-->
	<script src="js/jquery.flexslider-min.js" type="text/javascript"></script>
	<script src="js/functions.js" type="text/javascript"></script>

	
</head>
<body>
	<!-- wrapper -->
	<!--<div id="wrapper">
		<!-- shell -->
		
			<!-- container -->
		
							
				<div class="main">
					<!-- slider -->
					<div class="flexslider">
						<ul class="slides">
							<li>
								<img src="css/images/1.jpg" alt="" />																
							</li>
							<li>
								<img src="css/images/2.jpg" alt="" />										
							</li>
							<li>
								<img src="css/images/3.jpg" alt="" />										
							</li>
							<li>
								<img src="css/images/6.jpg" alt="" />										
							</li>
							<li>
								<img src="css/images/5.jpg" alt="" />										
							</li>
		
						</ul>
					</div>
					<!-- end of slider -->
                    <div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >Website Template</a></div>
					<!-- cols -->
					<section class="cols">
						<div class="col">
							<h3><a href="#">最新动态</a></h3>
							<c:forEach items="${noticeList}" var="noti">
							<a href="content.jsp?title=${noti.title}&content=${noti.content}&time=${noti.noticeTime}">${noti.title}</a><br>
							</c:forEach>
						</div>

						<div class="col">
							<h3><a href="#">时事热点</a></h3>
							<c:forEach items="${noticeList1}" var="noti1">
							<a href="content.jsp?title=${noti1.title}&content=${noti1.content}&time=${noti1.noticeTime}">${noti1.title}</a><br>
							</c:forEach>
						</div>

						<div class="col">
							<h3><a href="#">便民信息</a></h3>
							<c:forEach items="${noticeList2}" var="noti2">
							<a href="content.jsp?title=${noti2.title}&content=${noti2.content}&time=${noti2.noticeTime}" >${noti2.title}</a><br>
							</c:forEach>
						</div>

						<div class="col">
							<h3><a href="#">生活健康</a></h3>
							<c:forEach items="${noticeList3}" var="noti3">
							<a href="content.jsp?title=${noti3.title}&content=${noti3.content}&time=${noti3.noticeTime}" >${noti3.title}</a><br>
							</c:forEach>
						</div>
						<div class="cl">&nbsp;</div>
					
					</section>
					<!-- end of cols  -->

					<!-- box -->
					<section class="box">
						<span class="shadow-t"></span>
						<h3>Recent Works</h3>
						
						<div class="cl">&nbsp;</div>
						<!-- entries -->
						<div class="entries">
							<div class="entry">
								<a href="#"><img src="css/images/entry1.png" alt="" /></a>
								<span class="shadow"></span>
							</div>
							<div class="entry">
								<a href="#"><img src="css/images/entry2.png" alt="" /></a>
								<span class="shadow"></span>
							</div>
							<div class="entry">
								<a href="#"><img src="css/images/entry3.png" alt="" /></a>
								<span class="shadow"></span>
							</div>
							<div class="entry">
								<a href="#"><img src="css/images/entry4.png" alt="" /></a>
								<span class="shadow"></span>
							</div>
							<div class="cl">&nbsp;</div>
							<span class="shadow-b"></span>
						</div>	
					<!-- end of entries -->
					</section>
					<!-- end of box -->
					
					<!-- services -->
					<section class="services">
						<div class="widget">
							<h3>Crisp, Clean &amp; Creative Design</h3>
							<p>Sed vel lacus lorem, non auctor ante. Aliquam posuere libero non felis euismod ac volutpat augue ullamcorper. Suspendisse convallis mi eget leo Sed pellentesque aliquam urna, vel euismod libero venenatis vitae.</p>
						</div>
						<div class="widget contact-widget">
							<h3>Contact Us</h3>
							<ul>
								<li>East Pixel Bld. 99, Creative City 9000</li>
								<li><strong>Phone: </strong>655-606-605</li>
								<li><strong>Email:</strong>template@proper.com</li>
							</ul>
						</div>
						<div class="widget socials-widget">
							<h3>Get Social</h3>
							<p>Lorem ipsum dolor sit amet eu.</p>
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
				<!-- end of main -->
			
			<!-- end of container -->	
			
		
		<!-- end of shell -->
	<!--</div>
	<!-- end of wrappert -->
</body>
</html>