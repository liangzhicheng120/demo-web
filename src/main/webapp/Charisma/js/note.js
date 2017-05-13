var note = {
	url : {
		list : 'note/list',
		del : 'note/delete',
		batchdelete : 'note/batchdelete',
		getlabel : 'note/getlabel',
		get : 'note/get',
		update : 'note/update',
		record : 'recommend/record'
	},
	init : function() {
		note.notemarkuptable(); // 初始化表格
		note.notemarkuptoption(); // 初始化选择框
		note.notemarkupnoteedit(); // 注册笔记编辑事件
		note.notemarkupsearchbtn(); // 注册搜索事件
		note.notemarkupdeletebtn(); // 注册单个删除事件
		note.notemarkupbatchdeletebtn(); // 注册批量删除事件
		note.notemarkupnotesubmitbtn(); // 注册新增事件
		note.notemarkupupdatebtn(); // 注册修改事件
		note.notemarkupdatepicker(); // 注册日期选择事件
		note.notemarkupsearchdatebtn(); // 注册搜索日期事件
		note.buryPointEvent('#noteUpdateDia'); // 注册埋点事件
		responsiveTable(); // 注册响应式表格
	},
	table : {
		head : new Array('标题', '内容', '关键词', '分类', '修改时间'),
		body : new Array('title', 'content', 'keyword', 'label', 'posttime'),
		page : 'javascript:note.changeCurrentPage'
	},
	param : function() {
		return {
			currentPage : $('#currentPage').val(),
			keyword : $('#keyword').val().trim(),
			label : $('#label').val(),
			start : $('#start').val().trim(),
			end : $('#end').val().trim(),
		}
	},
	buryPointEvent : function(modalId) {
		var start;
		var end;
		$(modalId).on('shown.bs.modal', function(e) {
			start = new Date();
		});
		$(modalId).on('hidden.bs.modal', function(e) {
			end = new Date();
			$.ajax({
				url : note.url.record,
				async : false,
				data : {
					nid : $('#noteId').val(),
					views : $('#update-option').val(),
					cost : (end.getTime() - start.getTime()) / 1000,
				},
				success : function(data) {
					if (data.code != 200) {
						$.tooltip("错误：" + data.code + ',' + data.message, 2500, false);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					$.tooltip("错误：" + XMLHttpRequest.status + ',' + XMLHttpRequest.readyState + ',' + textStatus, 2500, false);
				}
			});
		});
	},
	notemarkuptable : function(param) {
		common.markuptable(note.url.list, param, note.notemarkupthead(), note.notemarkuptbody(), note.table.page);
	},
	notemarkupthead : function() {
		return common.markupthead(note.table.head, '<input type="checkbox" onclick="common.checkall()">', '操作');
	},
	notemarkuptbody : function() {
		var before = '<input type="checkbox" name="checkbox_id" value="\${id}">';
		var after = '<a class="btn btn-success btn-sm" href="javascript:note.notemarkupinitupdateformbtn(\${id})">查看</a>&nbsp;&nbsp;';
		after += '<a class="btn btn-danger btn-sm" data-toggle="modal" data-target="#noteDeleteDia" data-backdrop="static" data-id="\${id}">删除</a>';
		return common.markuptbody(note.table.body, before, after);
	},
	changeCurrentPage : function(currentPage) {
		note.notemarkuptable({
			currentPage : currentPage,
			keyword : $('#keyword').val(),
			label : $('#label').val(),
			start : $('#start').val().trim(),
			end : $('#end').val().trim(),
		});
	},
	notemarkuptoption : function() {
		common.markupoption(note.url.getlabel, '#label', '全部');
	},
	notechangelabel : function() {
		note.notemarkuptable(note.param());
	},
	notemarkupnoteedit : function() {
		$('#noteEditBtn').on('click', function() {
			$('#noteEditDia').modal({
				backdrop : 'static',
				keyboard : false,
				show : true
			});
			$('#content').trumbowyg({
				lang : 'zh_cn',
				resetCss : true,
			});
		});
	},
	notemarkupsearchbtn : function() {
		$('#searchBtn').on('click', function() {
			note.notemarkuptable(note.param());
		});
	},
	notemarkupdeletebtn : function() {
		common.markupdata('#noteDeleteDia', new Array('id'));
		$('#deleteBtn').on('click', function() {
			common.doAjaxWithNotAsync(note.url.del, {
				id : $('#id').val()
			}, function() {
				$.tooltip('OK, 操作成功！', 2500, true);
				note.notemarkuptable(note.param());
			});
		});
	},
	notemarkupbatchdeletebtn : function() {
		$('#batchDeleteBtn').on('click', function() {
			var ids = common.getcheckids();
			if (ids.length != 0) {
				common.doAjaxWithNotAsync(note.url.batchdelete, {
					ids : ids
				}, function() {
					$.tooltip('OK, 操作成功！', 2500, true);
					note.notemarkuptable(note.param());
				});
			}
		});
	},
	notemarkupnotesubmitbtn : function() {
		$('#noteSubmitBtn').on('click', function() {
			var validator = new Validator(); // 创建一个构造器对象
			validator.add($('#title'), [ {
				strategy : 'isNotEmpty',
				msg : '标题不能为空'
			} ]);
			validator.add($('#content'), [ {
				strategy : 'isNotEmpty',
				msg : '内容不能为空'
			} ]);
			validator.start();
			common.doAjaxSubmitForm('#noteEditFrom', '#noteEditDia', function(data) {
				$('#content').empty();
				$('#title').empty();
				note.notemarkuptable(note.param());
			});
		});
	},
	notemarkupinitupdateformbtn : function(id) {
		common.modal('#noteUpdateDia');
		$('#remarks').trumbowyg({
			lang : 'zh_cn',
			btns : [ '|' ],
			resetCss : true
		});
		common.doAjaxWithNotAsync(note.url.get, {
			id : id
		}, function(data) {
			$('#update-title').val(data.value.title);
			common.trumbowyg('#update-content');
			$('#update-content').html(data.value.content);
			var keys = data.value.keyword.split(",");
			for (var i = 0; i < keys.length; i++) {
				$('#key' + i).val(keys[i].trim());
			}
			common.markupoption(note.url.getlabel, '#update-option', null);
			$('#update-option').val(data.value.label);
			$('#noteId').val(data.value.id);
			$('#remarks').html(data.value.remarks);
		});
	},
	isNotEmpty : function(id) {
		return ($(id).val()) ? ',' + $(id).val() : '';
	},
	notemarkupupdatebtn : function() {
		$('#noteUpdateBtn').on('click', function() {
			var validator = new Validator(); // 创建一个构造器对象
			validator.add($('#update-title'), [ {
				strategy : 'isNotEmpty',
				msg : '标题不能为空'
			} ]);
			validator.add($('#update-content'), [ {
				strategy : 'isNotEmpty',
				msg : '内容不能为空'
			} ]);
			validator.start();
			common.doAjaxSubmit(note.url.update, {
				id : $('#noteId').val(),
				title : $('#update-title').val(),
				content : document.getElementById('update-content').innerHTML,
				keyword : $('#key0').val() + note.isNotEmpty('#key1') + note.isNotEmpty('#key2'),
				label : $('#update-option').val(),
				remarks : document.getElementById('remarks').innerHTML,
			}, '#noteUpdateDia', function(data) {
				note.notemarkuptable(note.param());
			});
		});
	},
	notemarkupsearchdatebtn : function() {
		$('#searchDateBtn').on('click', function() {
			note.notemarkuptable(note.param());
		});
	},
	notemarkupdatepicker : function() {
		$('.default-date-picker').datepicker({
			format : 'yyyy-mm-dd'
		});
	},
};