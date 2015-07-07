<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


	<title>物业管理系统</title>
	
	<link rel="stylesheet" href="css/layout.css" type="text/css" media="screen" />
	<!--[if lt IE 9]>
	<link rel="stylesheet" href="css/ie.css" type="text/css" media="screen" />
	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	<script src="js/jquery-1.5.2.min.js" type="text/javascript"></script>
	<script src="js/hideshow.js" type="text/javascript"></script>
	<script type="text/javascript" src="js/jquery.equalHeight.js"></script>
	
<script type="text/javascript">
        	function changeIframe(src){
			document.getElementById("iframe").src=src;
			}
        </script>

</head>


<body>

	<header id="header">
		<hgroup>
			<h1 class="site_title">桂花园小区物业后台管理系统</h1>
		</hgroup>
		<br>
		<div style="position:absolute;top:5%;left:90%;"><a href="mexit.do">注销登陆</a></div>
	</header> <!-- end of header bar -->
	
	<section id="secondary_bar">
		<div class="user">
			<p>${manager.managerName}</p>
			<!-- <a class="logout_user" href="#" title="Logout">Logout</a> -->
		</div>
	</section><!-- end of secondary bar -->
	
	<aside id="sidebar" class="column">
		<br>
		<h3>用户管理</h3>
		<ul class="toggle">
		    <li class="icn_add_user"><a href="javascript:void(0)" onclick="changeIframe('toAddUser.do')">新增用户</a></li>
			<li class="icn_new_article"><a href="#"  onclick="changeIframe('userlist.do')">查询用户</a></li>
		</ul>
		<h3>房产信息管理</h3>
		<ul class="toggle">
			<li class="icn_add_user"><a href="javascript:void(0)" onclick="changeIframe('addhouse.do')">新增房间</a></li>
			<li class="icn_view_users"><a href="javascript:void(0)" onclick="changeIframe('houselist.do')">住房列表</a></li>
		</ul>
		<h3>报修管理</h3>
		<ul class="toggle">
			<li class="icn_folder"><a href="#" onclick="changeIframe('mrepair.do')">报修列表</a></li>
			<li class="icn_photo"><a href="#" onclick="changeIframe('dealrepair.do')">安排维修</a></li>
			<li class="icn_audio"><a href="#" onclick="changeIframe('repairrecord.do')">处理记录</a></li>
		</ul>
		<h3>收费管理</h3>
		<ul class="toggle">
			<li class="icn_settings"><a href="#" onclick="changeIframe('waterInit.do')">水费录入</a></li>
			<li class="icn_settings"><a href="#" onclick="changeIframe('elecInit.do')">电费录入</a></li>
			<li class="icn_settings"><a href="#" onclick="changeIframe('gasInit.do')">燃气费录入</a></li>
			<li class="icn_security"><a href="#" onclick="changeIframe('mcharge.do')">费用查询</a></li>
			<li class="icn_security"><a href="#" onclick="changeIframe('renttype.do')">费用调整</a></li>
			<li class="icn_jump_back"><a href="#" onclick="changeIframe('payment.jsp')">用户缴费</a></li>
		</ul>
		<h3>投诉管理</h3>
		<ul class="toggle">
			<li class="icn_settings"><a href="#" onclick="changeIframe('mcomplain.do')">投诉列表</a></li>
		</ul>
		<h3>公告管理</h3>
		<ul class="toggle">
			<li class="icn_settings"><a href="javascript:void(0)" onclick="changeIframe('publish.jsp')">发布公告</a></li>
			<li class="icn_security"><a href="javascript:void(0)" onclick="changeIframe('noticehistory.do')">查看历史公告</a></li>
		</ul>	
		<footer>
			<hr />
			<p><strong>Copyright &copy; 2014 wuyunxing All Rights Reserved.</strong></p>
		</footer>
	</aside><!-- end of sidebar -->
	<section id="main" class="column">		
	<div id="content">
          <!-- iframe框架-->
          <iframe src="welcome.jsp" style="width:100%;min-height:900px" id="iframe" name="iframe" >
          </iframe>
		</div>
		</section>
</body>

</html>