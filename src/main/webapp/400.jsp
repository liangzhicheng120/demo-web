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
<title>400 Page</title>
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
				<div style='width: 572px; height: 650px; margin: 0px auto; margin-top: 40px;'>
					<div style='font-size: 18px; color: #000;'>400 page not found</div>
					<div style='margin-top: 40px; color: #000;' class='body'>
						<div>很抱歉，您要访问的页面无法正常显示，可能是因为如下原因：</div>
						<div>1.系统过于繁忙，请点击浏览器的"刷新"按钮，或稍后再试。</div>
						<div>2.你输入的网址有误，请重新检查您输入的网址。</div>
						<div>
							<a class="back-btn" href="<%=basePath%>index.html"> Back To Home</a>
						</div>
					</div>
				</div>
			</section>
		</div>
	</section>
</body>
</html>