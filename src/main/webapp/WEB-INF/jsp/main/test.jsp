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
<title>测试</title>
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
<link href='<%=basePath%>Charisma/jquery-edit/assets/design/css/trumbowyg.css' rel='stylesheet'>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<style type="text/css">
.modal {
	bottom: auto;
	padding: 0;
	background-color: #ffffff;
	border: 1px solid #999999;
	border: 1px solid rgba(0, 0, 0, 0.2);
	border-radius: 6px;
	-webkit-box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	background-clip: padding-box;
	overflow-y: auto;
}
</style>
</head>
<body>
	<div class="content" style="margin-left: 100px; margin-top: 100px;">
		<button class="btn btn-primary btn-lg" id="m1">打开第一层模态窗口</button>
	</div>
	<div id="firstmodal" class="modal container fade" tabindex="-1" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h4 class="modal-title">第一层模态窗口</h4>
		</div>
		<div class="modal-body">
			<p>
				<button class="btn btn-primary btn-lg" id="m2">打开第二层模态窗口</button>
				第一层主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 第一层主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 第一层主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
			</p>
		</div>
		<div class="modal-footer" style="text-align: center;">
			<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		</div>
	</div>

	<div id="secondmodal" class="modal container fade" tabindex="-1" style="display: none;">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			<h4 class="modal-title">第二层模态窗口</h4>
		</div>
		<div class="modal-body">
			<p>第二层主体内容主体内容主体内容主体内容主体内体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容 主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容
				主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容主体内容</p>
		</div>
		<div class="modal-footer" style="text-align: center;">
			<button type="button" data-dismiss="modal" class="btn btn-default">关闭</button>
		</div>
	</div>
</body>
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
<script src="<%=basePath%>Charisma/js/charisma.min.js"></script>
<script src="<%=basePath%>Charisma/js/jquery-form.js"></script>
<script src="<%=basePath%>Charisma/js/jquery.tmpl.min.js"></script>
<script src="<%=basePath%>Charisma/js/common.js"></script>
<script src="<%=basePath%>Charisma/jquery-edit/assets/trumbowyg.js"></script>
<script src="<%=basePath%>Charisma/jquery-edit/assets/plugins/base64/trumbowyg.base64.min.js"></script>
<script type="text/javascript">
	$(function()
		{
			$('#m1').on("click", function()
				{
					$('#firstmodal').modal();
				});
			$('#m2').on("click", function()
				{
					$('#secondmodal').modal();
				});
		});
</script>
</body>


</html>
