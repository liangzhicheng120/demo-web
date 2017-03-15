<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="liangzhicheng">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="#" type="image/png">
<title>后台登陆</title>
<link rel="stylesheet" type="text/css" href="./Charisma/css/style.css" />
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
			<input type="text" id="username" placeholder="账号" name="username"  class="login_txtbx" maxlength="12" />
		</dd>
		<dd class="pwd_icon">
			<input type="password" id="password" placeholder="密码" maxlength="20" name="password" class="login_txtbx" />
		</dd>
		<dd class="val_icon">
			<div class="checkcode">
				<input type="text" id="codetext" placeholder="验证码" maxlength="4" name="vcode" autocomplete="off" class="login_txtbx" /><img id="vcode" alt="验证码"
					src="captcha-image.do" onclick="changeCode()" />
			</div>
			<a style="width: 82px; text-align: center;" href="javascript:showpwd()" class="ver_btn">显示密码</a>
		</dd>
		<dd>
			<input type="button" value="立即登陆" class="submit_btn" onclick="login()" />
		</dd>
		<dd>
			<p>© 2015-2016 飞树工作室 版权所有</p>
			<p>粤B2-20080224-1</p>
		</dd>
	</dl>

	<script src="./Charisma/js/jquery.min.js"></script>
	<script src="./Charisma/js/login.js"></script>
	<script>
		$(function(){
			login.init();
		});
	</script>
</body>
</html>