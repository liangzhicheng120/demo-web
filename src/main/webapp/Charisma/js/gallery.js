var gallery = {
	url : {
		list : 'gallery/list',
		init : 'gallery/init',
		del  : 'gallery/delete',
		get  : 'gallery/get',
	    update : 'gallery/update',
	},
	init : function() {
		gallery.initView(); // 初始化界面
		gallery.createBtn(); // 注册创建模态框事件
		gallery.taggingBtn(); // 注册标签按钮事件
		gallery.hoverBtn();  // 注册标签鼠标经过事件
		gallery.thumbnailsBtn(); // 注册标签编辑事件
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
				`<li class="thumbnail clzss" style="float: left; list-style: none" data-clzss="${clzss}" data-label="${label}">
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
								<ul class="thumbnails gallery">
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
		$("#clzss-tag").on( "add:after", function ( el, text, tagging ) {
			common.doAjax(gallery.url.get,{clzss:$clzss_tag.tagging('getTags').join(',')},function(data){
				$("#label-tag").tagging('focusInput');
			},function(data){
				$("#clzss-tag").tagging('reset');
			});
		});
		$('#sumbitBtn').on('click', function() {
			try{
				common.doAsyncAjaxWithBefore(gallery.url.init, {
					clzss : $clzss_tag.tagging('getTags').join(','),
					label : $label_tag.tagging('getTags').join(',')
				}, function(data) {
					gallery.init();
					$label_tag.tagging('reset');
					$clzss_tag.tagging('reset');  
					$('#galleryDialog').modal('hide');
				});
			}catch(e){}
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
	hoverBtn : function(){
	    $('ul.gallery li.clzss').hover(function () {
	        $('img', this).fadeToggle(500);
	        $(this).find('.gallery-controls').remove();
	        $(this).append('<div class="well gallery-controls">' +
	            '<p><a href="#" class="gallery-edit btn"><i class="glyphicon glyphicon-edit"></i></a> <a href="#" class="gallery-delete btn"><i class="glyphicon glyphicon-remove"></i></a></p>' +
	            '</div>');
	        $(this).find('.gallery-controls').stop().animate({'margin-top': '-1'}, 400);
	    }, function () {
	        $('img', this).fadeToggle(500);
	        $(this).find('.gallery-controls').stop().animate({'margin-top': '-30'}, 200, function () {
	            $(this).remove();
	        });
	    });
	},
	thumbnailsBtn:function(){
	    $('.thumbnails').on('click', '.gallery-delete', function (e) {
	        var clzss = $(this).parents('.thumbnail').attr('data-clzss');
	        common.doAjaxWithNotAsync(gallery.url.del,{
	        	clzss:clzss
	        },function(data){
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
	    $('.thumbnails').on('click', '.gallery-edit', function (e) {
	    	var clzss = $(this).parents('.thumbnail').attr('data-clzss');
	    	var label = $(this).parents('.thumbnail').attr('data-label');
	    	common.modal('#galleryUpdateDialog');
	    	$('#update-clzss-tag').text(clzss);  
	    	$('#update-label-tag').text(label);
	    });
		$('#new-label-tag').on( "add:after", function ( el, text, tagging ) {
			common.doAjax(gallery.url.get,{label:$new_label_tag.tagging('getTags').join(',')},function(data){},function(data){
				$('#new-label-tag').tagging('remove',text);
			});
		});
	    $('#updateResetBtn').on('click',function(){
	    	$new_label_tag.tagging('reset');
	    });
	    $('#updateBtn').on('click',function(){
	    	try{
		    	common.doAsyncAjaxWithBefore(gallery.url.update,{
		    		clzss : $('#update-clzss-tag').text(),
		    		label : $('#update-label-tag').text(),
		    		newlabel : $new_label_tag.tagging('getTags').join(','),
		    	},function(data){
		    		$('#galleryUpdateDialog').modal('hide');
		    		$new_label_tag.tagging('reset');
		    		gallery.init();
		    	});
	    	}catch(e){}
	    });
	},
}