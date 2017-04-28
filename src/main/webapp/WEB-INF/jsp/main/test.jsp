<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>taggingJS</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=basePath%>Charisma/jquery-tag/bootstrap.min.css" rel="stylesheet">
<link href="<%=basePath%>Charisma/jquery-tag/tag-basic-style.css" rel="stylesheet">
<!--[if lt IE 9]>
		<script src="//oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
		<script src="//oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>
<body>
	<div class="container">
		<h1>Create classification</h1>
		<div class="row">
			<!-- The example Code -->
			<div class="example-wrapper">
				<div class="tags well">
					<label for="tag" class="control-label">class</label>
					<div id="clzss-tag" data-tags-input-name="taggone" class="form-control">生物</div>
					<p class="help-block">Press Enter, Comma or Spacebar to create a new class, Backspace or Delete to remove the last one.</p>
					<label for="tag" class="control-label">label</label>
					<div id="label-tag" data-tags-input-name="taggone" class="form-control">语文, 英语, 化学, 历史, 生物</div>
					<p class="help-block">Press Enter, Comma or Spacebar to create a new label, Backspace or Delete to remove the last one.</p>
				</div>
				<div style="float: right;">
					<a class="btn btn-sm btn-default" id='sumbitBtn'>提交</a> <a class="btn btn-sm btn-default" id='resetBtn'>重置</a>
				</div>

			</div>
		</div>
	</div>
	<script src="<%=basePath%>Charisma/jquery-tag/jquery.min.js"></script>
	<script src="<%=basePath%>Charisma/jquery-tag/tagging.js"></script>
	<script src="<%=basePath%>Charisma/js/jquery.hDialog.min.js"></script>
	<script>
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
			$.ajax({
				url : 'note/initmodel',
				data : {
					clzss : $clzss_tag.tagging('getTags').join(','),
					label : $label_tag.tagging('getTags').join(',')
				},
				success : function(data) {
					console.log(data);
				},
				error : function(er) {
					console.log(er);
				}
			});
		});
		$('#resetBtn').on('click', function() {
			$label_tag.tagging('reset');
			$clzss_tag.tagging('reset');
		});
	</script>
</body>
</html>
