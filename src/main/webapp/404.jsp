<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<meta name="description" content="">
<meta name="author" content="liangzhicheng">
<link rel="shortcut icon" href="#" type="image/png">
<title>404 Page</title>
<link href="<%=basePath%>AdminEx/css/style.css" rel="stylesheet">
<link href="<%=basePath%>AdminEx/css/style-responsive.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body class="error-page">
	<section>
		<div class="container ">
			<section class="error-wrapper text-center">
				<h1>
					<img alt="" src="<%=basePath%>AdminEx/images/404-error.png">
				</h1>
				<h2>page not found</h2>
				<h3>We Couldn’t Find This Page</h3>
				<a class="back-btn" href="<%=basePath%>index.html"> Back To Home</a>
			</section>
		</div>
	</section>
</body>
</html>