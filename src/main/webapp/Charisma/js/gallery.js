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
	initView : function() {
		var li_body = '';
		common.doAjaxWithNotAsync(gallery.url.list, {}, function(result) {
			var data = result.value.data;
			for (var i in data) {
				li_body += gallery.html.li(i % 6, data[i]['clzss'], data[i]['label']);
			}
		});
		$('#ch-content').html(gallery.html.content(li_body));
	},
	html : {
		li : function(img,clzss,label) {
			var tmpl = 
				`<li class="thumbnail" style="float: left; list-style: none">
				    <a style="text-align: center;text-decoration:none" data-toggle="tooltip" data-placement="bottom" title="${label}" href="note?clzss=${clzss}&label=${label}">
				        <img src="./Charisma/images/${img}.png" style="display: block;">【${clzss}】<br>${label}
				    </a>
				</li>`;
			return tmpl;
		},
		content : function(args) {
			var tmpl = 
				`<div class="row">
					<div class="box col-md-12">
						<div class="box-inner">
							<div class="box-header well">
								<h2>
									<i class="glyphicon glyphicon-user"></i> 笔记管理系统
								</h2>
								<div class="box-icon">
									<h2>
										<a href="gallery" style="color: #333; margin-top: 4px;"><i class="glyphicon glyphicon-refresh"></i></a>
									</h2>
								</div>
							</div>
							<div class="box-content" style="height: 565px;">
								<ul class="thumbnails">
									${args}
								    <li class="thumbnail" style="float: left; list-style: none">
								        <a id="createBtn" style="text-align: center; text-decoration: none">
								            <img src="./Charisma/images/0.png" style="display: block;">【添加】<br>添加新类别
								        </a>
								    </li>
								</ul>
							</div>
						</div>
					</div>
				</div>`
			return tmpl;
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