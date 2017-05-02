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
<title>笔记管理平台</title>
<link id="bs-css" href='<%=basePath%>Charisma/css/theme/bootstrap-cerulean.min.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/charisma-app.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/fullcalendar.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/fullcalendar.print.css' rel='stylesheet' media='print'>
<link href='<%=basePath%>Charisma/css/chosen.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/colorbox.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/responsive-tables.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/bootstrap-tour.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/jquery.noty.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/noty_theme_default.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/elfinder.min.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/elfinder.theme.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/jquery.iphone.toggle.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/uploadify.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/main.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/jquery-edit/assets/design/css/trumbowyg.css' rel='stylesheet'>
<link href='<%=basePath%>Charisma/css/mystyle.css' rel="stylesheet">
<link href='<%=basePath%>Charisma/css/animate.min.css' rel="stylesheet">
<link href='<%=basePath%>AdminEx/css/datepicker-custom.css' rel="stylesheet">
<link href="<%=basePath%>Charisma/jquery-tag/tag-basic-style.css" rel="stylesheet">
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@include file="../main/dialog.jsp"%>
	<%@include file="../main/navbar.jsp"%>
	<input type="text" hidden="hidden" id="currentPage" value="">
	<div class="ch-container" style="margin-top: -15px;">
		<div class="row">
			<%@include file="../main/sidebar.jsp"%>
			<div id="ch-content" class="col-lg-10 col-sm-10"></div>
		</div>
	</div>
	<script src="<%=basePath%>Charisma/js/jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/bootstrap.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.cookie.js"></script>
	<script src="<%=basePath%>Charisma/js/moment.min.js"></script>
	<script src="<%=basePath%>Charisma/js/fullcalendar.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Charisma/js/chosen.jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.noty.js"></script>
	<script src="<%=basePath%>Charisma/js/responsive-tables.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Charisma/js/bootstrap-tour.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.raty.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.iphone.toggle.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.autogrow-textarea.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.uploadify-3.1.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.history.js"></script>
	<script src="<%=basePath%>Charisma/js/charisma.min.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery-form.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.tmpl.min.js"></script>
	<script src="<%=basePath%>Charisma/jquery-edit/assets/trumbowyg.js"></script>
	<script src="<%=basePath%>Charisma/jquery-edit/assets/plugins/base64/trumbowyg.base64.min.js"></script>
	<script src="<%=basePath%>Charisma/js/common.js"></script>
	<script src="<%=basePath%>Charisma/js/validate.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.hDialog.min.js"></script>
	<script src="<%=basePath%>AdminEx/js/bootstrap-datepicker.js"></script>
	<script src="<%=basePath%>Charisma/jquery-tag/tagging.js"></script>
	<script src="<%=basePath%>Charisma/js/gallery.js"></script>
	<script src="<%=basePath%>Charisma/js/note.js"></script>
	<script>
		$(function() {
			gallery.init();
		});
	</script>
</body>
</html>
