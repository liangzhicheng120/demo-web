var gallery = {
	url : {
		list : 'gallery/list',
		init : 'gallery/init',
		del : 'gallery/delete',
		get : 'gallery/get',
		update : 'gallery/update',
	},
	init : function() {
		gallery.initView(); // 初始化界面
		gallery.createBtn(); // 注册创建模态框事件
		gallery.taggingBtn(); // 注册标签按钮事件
		gallery.hoverBtn(); // 注册标签鼠标经过事件
		gallery.thumbnailsBtn(); // 注册标签编辑事件
	},
	initView : function() {
		var li_body = '';
		var ul_body = '';
		common.doAjaxWithNotAsync(gallery.url.list, {}, function(result) {
			var data = result.value.data;
			for ( var i in data) {
				li_body += gallery.html.li(i % 6, data[i]['clzss'], data[i]['label'], data[i]['num']);
				ul_body += '<li><a class="btn" href="note?clzss={0}&label={1}"><i class="glyphicon glyphicon-pushpin"></i>【{2}】 {3}篇</a></li>'.format(
						data[i]['clzss'], data[i]['label'], data[i]['clzss'], data[i]['num']);
			}
		});
		$('#ch-content').html(gallery.html.content(li_body));
		$('#ch-gallery').html(gallery.html.ul(ul_body));
	},
	html : {
		li : function(img, clzss, label, num) {
			var tmpl = '<li class="thumbnail clzss" style="float: left; list-style: none" data-clzss="{0}" data-label="{1}">'.format(clzss, label);
			tmpl += '<a style="text-align: center;text-decoration:none" href="note?clzss={0}&label={1}">'.format(clzss, label);
			tmpl += '<img src="./Charisma/images/{0}.png" data-toggle="tooltip" data-placement="bottom" title="{1}" style="display: block;">'.format(
					img, label);
			tmpl += '【{0} {1}篇】<br>{2}'.format(clzss, num, label);
			tmpl += '</a>';
			tmpl += '</li>';
			return tmpl;
		},
		content : function(args) {
			var tmpl = '<div class="row">';
			tmpl += '<div class="box col-md-12">';
			tmpl += '<div class="box-inner">';
			tmpl += '<div class="box-header well">';
			tmpl += '<h2>';
			tmpl += '<i class="glyphicon glyphicon-user"></i> 笔记管理系统';
			tmpl += '</h2>';
			tmpl += '<div class="box-icon">';
			tmpl += '<h2>';
			tmpl += '<a href="gallery" style="color: #333; margin-top: 4px;"><i class="glyphicon glyphicon-refresh"></i></a>';
			tmpl += '</h2>';
			tmpl += '</div>';
			tmpl += '</div>';
			tmpl += '<div class="box-content" style="height: 565px;">';
			tmpl += '<ul class="thumbnails gallery">';
			tmpl += '{0}';
			tmpl += '<li class="thumbnail" style="float: left; list-style: none">';
			tmpl += '<a id="createBtn" style="text-align: center; text-decoration: none">';
			tmpl += '<img src="./Charisma/images/0.png" style="display: block;">【添加】<br>添加新类别';
			tmpl += '</a>';
			tmpl += '</li>';
			tmpl += '</ul>';
			tmpl += '</div>';
			tmpl += '</div>';
			tmpl += '</div>';
			tmpl += '</div>';
			return tmpl.format(args);
		},
		controls : function() {
			var tmpl = '<div class="well gallery-controls">';
			tmpl += '<p>';
			tmpl += '<a href="#" class="gallery-edit btn">';
			tmpl += '<i class="glyphicon glyphicon-edit"></i>';
			tmpl += '</a>';
			tmpl += '<a href="#" class="gallery-delete btn">';
			tmpl += '<i class="glyphicon glyphicon-remove"></i>';
			tmpl += '</a>';
			tmpl += '</p>';
			tmpl += '</div>';
			return tmpl;
		},
		ul : function(data) {
			var tmpl = '<a class="btn btn-default" href="#"><i class="glyphicon glyphicon-check"></i><span> 笔记管理 </span></a>';
			tmpl += '<ul class="nav nav-pills nav-stacked text-center" style="display: block; margin-left: 0px;">{0}</ul>'.format(data);
			return tmpl;
		}
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
		$("#clzss-tag").on("add:after", function(el, text, tagging) {
			common.doAjax(gallery.url.get, {
				clzss : $clzss_tag.tagging('getTags').join(',')
			}, function(data) {
				$("#label-tag").tagging('focusInput');
			}, function(data) {
				$("#clzss-tag").tagging('reset');
			});
		});
		$('#sumbitBtn').on('click', function() {
			try {
				common.doAsyncAjaxWithBefore(gallery.url.init, {
					clzss : $clzss_tag.tagging('getTags').join(','),
					label : $label_tag.tagging('getTags').join(',')
				}, function(data) {
					gallery.init();
					$label_tag.tagging('reset');
					$clzss_tag.tagging('reset');
					$('#galleryDialog').modal('hide');
				});
			} catch (e) {
			}
		});
		$('#resetBtn').on('click', function() {
			$label_tag.tagging('reset');
			$clzss_tag.tagging('reset');
		});
	},
	createBtn : function() {
		$('#createBtn').on('click', function() {
			common.modal('#galleryDialog');
		});
	},
	hoverBtn : function() {
		$('ul.gallery li.clzss').hover(function() {
//			$('img', this).fadeToggle(500);
			$(this).find('.gallery-controls').remove();
			$(this).append(gallery.html.controls());
			$(this).find('.gallery-controls').stop().animate({
				'margin-top' : '50'
			}, 100);
		}, function() {
//			$('img', this).fadeToggle(500);
			$(this).find('.gallery-controls').stop().animate({
				'margin-top' : '50'
			}, 200, function() {
				$(this).remove();
			});
		});
	},
	thumbnailsBtn : function() {
		$('.thumbnails').on('click', '.gallery-delete', function(e) {
			var clzss = $(this).parents('.thumbnail').attr('data-clzss');
			common.doAjaxWithNotAsync(gallery.url.del, {
				clzss : clzss
			}, function(data) {
				$.tooltip('OK, 操作成功！', 2500, true);
				gallery.init();
			});
		});
		var $new_label_tag = $("#new-label-tag").tagging({
			'no-spacebar' : true,
			'tag-char' : '@',
			'tag-on-blur' : false,
			'tag-box-class' : 'tagging',
			'edit-on-delete' : false,
			'no-duplicate-text' : '标签重复',
		})[0];
		$('.thumbnails').on('click', '.gallery-edit', function(e) {
			var clzss = $(this).parents('.thumbnail').attr('data-clzss');
			var label = $(this).parents('.thumbnail').attr('data-label');
			common.modal('#galleryUpdateDialog');
			$('#update-clzss-tag').text(clzss);
			$('#update-label-tag').text(label);
		});
		$('#new-label-tag').on("add:after", function(el, text, tagging) {
			common.doAjax(gallery.url.get, {
				label : $new_label_tag.tagging('getTags').join(',')
			}, function(data) {
			}, function(data) {
				$('#new-label-tag').tagging('remove', text);
			});
		});
		$('#updateResetBtn').on('click', function() {
			$new_label_tag.tagging('reset');
		});
		$('#updateBtn').on('click', function() {
			try {
				common.doAsyncAjaxWithBefore(gallery.url.update, {
					clzss : $('#update-clzss-tag').text(),
					label : $('#update-label-tag').text(),
					newlabel : $new_label_tag.tagging('getTags').join(','),
				}, function(data) {
					$('#galleryUpdateDialog').modal('hide');
					$new_label_tag.tagging('reset');
					gallery.init();
				});
			} catch (e) {
			}
		});
	},
}