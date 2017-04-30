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
<link href='<%=basePath%>Charisma/css//colorbox.css' rel='stylesheet'>
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
	<%@include file="../main/navbar.jsp"%>
	<div class="ch-container" style="margin-top: -15px;">
		<div class="row">
			<%@include file="../main/sidebar.jsp"%>
			<div id="content" class="col-lg-10 col-sm-10" style="margin-top: -11px;"></div>

			<!-- modal start  -->
			<div class="modal fade" id="galleryDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header" style="padding-bottom: 3px;">
							<button type="button" class="close" data-dismiss="modal">×</button>
							<h4>创建分类</h4>
						</div>
						<div class="modal-body" style="text-align: center;">
							<div class="example-wrapper">
								<div class="tags well">
									<label for="tag" class="control-label">类别</label>
									<div id="clzss-tag" data-tags-input-name="taggone" class="form-control"></div>
									<p class="help-block">按回车，逗号或空格键创建一个新的类别，退格键或删除删除最后一个。</p>
									<label for="tag" class="control-label">标签</label>
									<div id="label-tag" data-tags-input-name="taggone" class="form-control"></div>
									<p class="help-block">按回车，逗号或空格键创建一个新的标签，退格键或删除删除最后一个。</p>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<a class="btn btn-sm btn-default" id='sumbitBtn'>提交</a> <a class="btn btn-sm btn-default" id='resetBtn'>重置</a>
						</div>
					</div>
				</div>
			</div>
			<!-- /modal end  -->
		</div>
	</div>
	<input type="text" hidden="hidden" id="currentPage" value="">
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
	<script src="<%=basePath%>Charisma/js/common.js"></script>
	<script src="<%=basePath%>Charisma/js/validate.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.hDialog.min.js"></script>
	<script src="<%=basePath%>Charisma/jquery-tag/tagging.js"></script>
	<script>
		var gallery = {
			url : {
				list : 'gallery/list',
				init : 'note/init',
			},
			init : function() {
				gallery.initView(); //初始化界面
				gallery.createBtn(); //注册创建模态框事件
				gallery.taggingBtn(); // 注册标签按钮事件
			},
			params : function() {
				return '';
			},
			initView : function() {
				var li_body = '';
				common.doAjaxWithNotAsync(gallery.url.list, {}, function(result) {
					var data = result.value.data;
					for ( var i in data) {
						li_body += gallery.html.li(gallery.html.a().format(i % 6, data[i]['clzss'], data[i]['clzss'], data[i]['label'],
								data[i]['label']));
					}
				});
				var li_foot = gallery.html
						.li('<a id="createBtn" style="text-align: center;text-decoration:none"><img src="./Charisma/images/0.png" style="display: block;">【添加】<br>添加新类别</a>');
				var ul = gallery.html.ul(li_body + li_foot);
				var content = gallery.html.content(ul);
				$('#content').html(content);
			},
			html : {
				ul : function(li) {
					return '<ul class="thumbnails">{0}</ul>'.format(li)
				},
				li : function(args) {
					return '<li class="thumbnail" style="float:left;list-style:none">{0}</li>'.format(args);
				},
				a : function() {
					return '<a style="text-align: center;text-decoration:none" data-toggle="tooltip" data-placement="bottom" title="{4}" href="javascript:intoNote({1})"><img src="./Charisma/images/{0}.png" style="display: block;">【{2}】<br>{3}</a>';
				},
				content : function(args) {
					var result = '<div class="box col-md-12">';
					/* 		result+='<div class="box-inner">' */
					result += '<div class="box-header well">'
					result += '<h2>'
					result += '<i class="glyphicon glyphicon-user"></i> 笔记管理系统'
					result += '</h2>'
					result += '<div class="box-icon">'
					result += '<h2>'
					result += '<a href="gallery" style="color: #333; margin-top: 4px;"><i class="glyphicon glyphicon-refresh"></i></a>'
					result += '</h2>'
					result += '</div>'
					result += '</div>'
					result += '<div class="box-content">{0}</div>'
					result += '</div>'
					/* 		result += '</div>' */
					return result.format(args);
				},

			},
			taggingBtn : function() {
				var $label_tag = $("#label-tag").tagging({
					'no-spacebar' : true,
					'tag-char' : '@',
					'tag-on-blur' : false,
					'tag-box-class' : 'tagging',
					'edit-on-delete' : false,
					'no-duplicate-text' : '标签重复',
				})[0];
				var $clzss_tag = $("#clzss-tag").tagging({
					'tags-limit' : 1,
					'edit-on-delete' : false,
					'tag-char' : '@',
					'no-spacebar' : true,
					'tag-on-blur' : false,
					'tag-box-class' : 'tagging',
				})[0];
				$('#sumbitBtn').on('click', function() {
					common.doAjaxWithNotAsync(gallery.url.init, {
						clzss : $clzss_tag.tagging('getTags').join(','),
						label : $label_tag.tagging('getTags').join(',')
					}, function(data) {
						$.tooltip('OK, 操作成功！', 2500, true);
					});
				});
				$('#resetBtn').on('click', function() {
					$label_tag.tagging('reset');
					$clzss_tag.tagging('reset');
				});
			},
			createBtn : function() {
				$('#createBtn').on('click', function() {
					$('#galleryDialog').modal({
						backdrop : 'static',
						keyboard : false,
						show : true,
					});
				});
			}
		}
	</script>
	<script>
		$(function() {
			gallery.init();
		})
	</script>
</body>
</html>
