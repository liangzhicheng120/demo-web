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
<title>首页</title>
<link id="bs-css" href='<%=basePath%>Charisma/css/theme/bootstrap-cerulean.min.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/charisma-app.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/mystyle.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/fullcalendar.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='<%=basePath%>Charisma/css/chosen.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css//colorbox.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/responsive-tables.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/uploadify.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/animate.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/main.css' rel='stylesheet'>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@include file="../main/navbar.jsp"%>

	<div class="ch-container" style="margin-top: -15px;">
		<div class="row">
			<%@include file="../main/sidebar.jsp"%>
			<div id="content" class="col-lg-10 col-sm-10">
				<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<!-- 							<div id="showLoad"></div>
							<div id="loadingbody" style="height: 600px;"></div> -->
							<input type="button" value="确定" id="OkBtn">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=basePath%>Charisma/js/jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.cookie.js"></script>
	<script src="<%=basePath%>Charisma/js/moment.min.js"></script>
	<script src="<%=basePath%>Charisma/js/fullcalendar.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Charisma/js/chosen.jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.colorbox-min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.noty.js"></script>
	<script src="<%=basePath%>Charisma/js/responsive-tables.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Charisma/js/bootstrap-tour.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.raty.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.iphone.toggle.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.autogrow-textarea.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.uploadify-3.1.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.history.js"></script>
	<script src="<%=basePath%>Charisma/js/charisma.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery-form.js"></script>
	<script>
		$(function() {
			$('#OkBtn').click(function() {
				var NAV_XML = _TEXT(function() {
					/*
					<a href="http://orzhtml.github.io/">{{home}}</a>
					<a href="http://orzhtml.github.io/">{{aboutUs}}</a>
					 */
				});
				function changeModelToHtml(template, oSource) {
					for ( var i in oSource) {
						var reg = new RegExp("{{" + i + "}}", "gim");
						template = template.replace(reg, oSource[i]);
						reg = null;
					}
					return template;
				}
				function _TEXT(wrap) {
					return wrap.toString().match(/\/\*\s([\s\S]*)\s\*\//)[1]; 
				}
				// 测试
				var list = {
					home : '首页',
					aboutUs : '关于我们'
				};
				console.log(changeModelToHtml(NAV_XML, list));
			});
		})
		http://blog.csdn.net/alex2917/article/details/51078543
	</script>
</body>
</html>