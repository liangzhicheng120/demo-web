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

							<div class="box-header well" data-original-title="">
								<h2>
									<i class="glyphicon glyphicon-user"></i> 笔记管理系统
								</h2>
							</div>
							<div class="box-content">

								<input type="text" value="" hidden="hidden" id="currentPage"> 
								<input type="text" value="" hidden="hidden" id="city"> 
								<input type="text" value="" hidden="hidden" id="district">

								<div class="row" style="margin-bottom: 10px;">

									<div class="col-md-2">
										<div class="input-group input-group-sm">
											<span class="input-group-addon">城市</span> <select size="1" class="form-control">
												<option value="">--请选择--</option>
											</select>
										</div>
									</div>

									<div class="col-md-2">
										<div class="input-group input-group-sm">
											<span class="input-group-addon">地区</span> <select size="1" class="form-control">
												<option value="">--请选择--</option>
											</select>
										</div>
									</div>

									<div class="col-md-3">
										<div class="input-group input-group-sm">
											<input type="text" class="form-control" placeholder="搜索关键词" aria-describedby="basic-addon1" id="hospital" value=""> <span class="input-group-addon" id="search_btn"><i
												class="glyphicon glyphicon-search"></i></span>
										</div>
									</div>

									<div class="col-md-3">
										<a class="btn btn-success btn-sm" data-toggle="modal" data-target="#batchagree_dialog" data-backdrop="static" style="font-weight: bold;">&nbsp;&nbsp;新增&nbsp;&nbsp;</a>
										<a class="btn btn-danger btn-sm" style="font-weight: bold;" data-toggle="modal" data-target="#batchdelete_dialog" data-backdrop="static">删除</a>
									</div>
								</div>


								<div class="table-wrapper">
									<table class="table table-striped table-bordered responsive">
										<thead id="thead">
										</thead>
										<tbody id="tbody">
										</tbody>
									</table>
								</div>


							</div>

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
	<script src="<%=basePath%>Charisma/js/jquery.tmpl.min.js"></script>
	<script src="<%=basePath%>Charisma/js/common.js"></script>
	<script src="<%=basePath%>Charisma/js/index.js"></script>
	<script>
		$(function() {
			index.init();
		});
	</script>
</body>
</html>