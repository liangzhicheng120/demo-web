<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
	
	<div class="modal fade bs-example-modal-lg" tabindex="-1" id="notecontent" role="dialog" aria-labelledby="myLargeModalLabel">
  		<div class="modal-dialog modal-lg" role="document">
    		<div class="modal-content">
	    			<div class="modal-header text-center">
						<button type="button" class="close" data-dismiss="modal" onclick="closeInfo()">×</button>
						<h3>
							<i class="glyphicon glyphicon-edit"></i>新增笔记
						</h3>
					</div>
					<div class="modal-body" id="">
						<div id="odiv" style="display: none; position: absolute; z-index: 100;">
							<img src="<%=basePath%>Charisma/images/sx.png" title="缩小" border="0" alt="缩小" onclick="sub(-1);" /> 
							<img src="<%=basePath%>Charisma/images/fd.png" title="放大" border="0" alt="放大" onclick="sub(1)" /> 
							<img src="<%=basePath%>Charisma/images/cz.png" title="重置" border="0" alt="重置" onclick="sub(0)" /> 
							<img src="<%=basePath%>Charisma/images/sc.png" title="删除" border="0"alt="删除" onclick="del();odiv.style.display='none';" />
						</div>
						<div onmousedown="show_element(event)" style="clear:both" id="customized-buttonpane" class="editor"></div>
					</div>
					<div class="modal-footer">
						<a class="btn btn-danger btn-sm" onclick="closeInfo()">取消</a> <a class="btn btn-success btn-sm" onclick="saveInformation()">发布</a>
					</div>
    		</div>
  		</div>
	</div>
	<a class="btn btn-success btn-sm" data-toggle="modal" data-target="#notecontent" data-backdrop="static">&nbsp;&nbsp;新增&nbsp;&nbsp;</a>

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
</body>

</html>
