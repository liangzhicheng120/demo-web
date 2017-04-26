<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="liangzhicheng">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="#" type="image/png">
<link href='<%=basePath%>Charisma/css/animate.min.css' rel="stylesheet">
<title>后台注册</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>Charisma/css/style.css" />
<style>
body {
	height: 100%;
	background: #16a085;
	overflow: hidden;
}

canvas {
	z-index: -1;
	position: absolute;
}
</style>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<dl class="admin_login">
		<dt>
			<strong>站点后台管理系统</strong> <em>Management System</em>
		</dt>
		<dd class="user_icon">
			<input type="text" id="username" placeholder="请输入0-20位账号" class="login_txtbx" maxlength="20" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" id="password" placeholder="请输入0-20位密码" maxlength="20" class="login_txtbx" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" style="width: 185px;" id="repassword" placeholder="再输一次密码" maxlength="20" class="login_txtbx" /> 
			<a style="width: 82px; text-align: center;" href="<%=basePath%>login" class="ver_btn">登陆</a>
		</dd>
		<dd>
			<input type="button" value="立即注册" class="submit_btn" id="registerBtn" />
		</dd>
		<dd>
			<p>© 2016-2017 东岸工作室 版权所有</p>
			<p>粤B2-20080224-1</p>
		</dd>
	</dl>

	<script src="<%=basePath%>Charisma/js/jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/view.js"></script>
	<script src="<%=basePath%>Charisma/js/validate.js"></script>
	<script src="<%=basePath%>Charisma/js/register.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.hDialog.min.js"></script>
	<script src="<%=basePath%>Charisma/js/util.js"></script>
	<script>
		$(function()
			{
				register.init();
			});
	</script>
</body>
</html>