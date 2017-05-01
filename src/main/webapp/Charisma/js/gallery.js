var gallery = {
	url : {
		list : 'gallery/list',
		init : 'note/init',
	},
	init : function() {
		gallery.initView(); // 初始化界面
		gallery.createBtn(); // 注册创建模态框事件
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
				li_body += gallery.html.li(gallery.html.a().format(i % 6, data[i]['clzss'], data[i]['clzss'], data[i]['label'], data[i]['label']));
			}
		});
		var li_foot = gallery.html
				.li('<a id="createBtn" style="text-align: center;text-decoration:none"><img src="./Charisma/images/0.png" style="display: block;">【添加】<br>添加新类别</a>');
		$('#content').html(gallery.html.content(gallery.html.ul(li_body + li_foot)));
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
			/* result+='<div class="box-inner">' */
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
			/* result += '</div>' */
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
			common.modal('#galleryDialog');
		});
	},
}