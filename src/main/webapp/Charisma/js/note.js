var note = {
	url : {
		notelist : 'note/list',
		notedelete : 'note/delete',
		notebatchdelete : 'note/batchdelete',
		notegetnclass : 'note/getnclass',
		noteget : 'note/get',
		noteupdate : 'note/update'
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
		note.notemarkuprefreshbtn(); // 注册刷新按钮
		responsiveTable(); // 注册响应式表格
	},
	table : {
		head : new Array('标题', '内容', '关键词', '类型', '修改时间'),
		body : new Array('title', 'content', 'keyword', 'nclass', 'posttime'),
		page : 'javascript:note.changeCurrentPage'
	},
	param : function() {
		return {
			currentPage : $('#currentPage').val(),
			keyword : $('#keyword').val().trim(),
			nclass : $('#nclass').val(),
			start : $('#start').val().trim(),
			end : $('#end').val().trim(),
		}
	},
	notemarkuptable : function(param) {
		common.markuptable(note.url.notelist, param, note.notemarkupthead(), note.notemarkuptbody(), note.table.page);
	},
	notemarkupthead : function() {
		var before = '<input type="checkbox" onclick="common.checkall()">';
		var after = '操作';
		return common.markupthead(note.table.head, before, after);
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
			nclass : $('#nclass').val(),
			start : $('#start').val().trim(),
			end : $('#end').val().trim(),
		});
	},
	notemarkuptoption : function() {
		common.markupoption(note.url.notegetnclass, '#nclass', '全部');
	},
	notechangeNcalss : function() {
		note.notemarkuptable(note.param());
	},
	notemarkupnoteedit : function() {
		$('#noteEditBtn').click(function() {
			$('#noteEditDia').modal({
				backdrop : 'static',
				keyboard : false,
				show : true,
			});
			$('#content').trumbowyg({
				lang : 'zh_cn',
			});
		});
	},
	notemarkupsearchbtn : function() {
		$('#searchBtn').click(function() {
			note.notemarkuptable(note.param());
		});
	},
	notemarkupdeletebtn : function() {
		common.markupdata('#noteDeleteDia', new Array('id'));
		$('#deleteBtn').click(function() {
			common.doAjaxWithNotAsync(note.url.notedelete, {
				id : Number($('#id').val())
			}, function() {
				$.tooltip('OK, 操作成功！', 2500, true);
				note.notemarkuptable(note.param());
			});
		});
	},
	notemarkupbatchdeletebtn : function() {
		$('#batchDeleteBtn').click(function() {
			var ids = common.getcheckids();
			if (ids.length != 0) {
				common.doAjaxWithNotAsync(note.url.notebatchdelete, {
					ids : ids
				}, function() {
					$.tooltip('OK, 操作成功！', 2500, true);
					note.notemarkuptable(note.param());
				});
			}
		});
	},
	notemarkupnotesubmitbtn : function() {
		$('#noteSubmitBtn').click(function() {
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
				note.notemarkuptable(note.param());
			});
		});
	},
	notemarkupinitupdateformbtn : function(id) {
		$('#noteUpdateDia').modal({
			backdrop : 'static',
			keyboard : false,
			show : true,
		});
		common.doAjaxWithNotAsync(note.url.noteget, {
			id : id
		}, function(data) {
			$('#update-title').val(data.value.title);
			$('#update-content').trumbowyg({
				lang : 'zh_cn',
			});
			$('#update-content').html(data.value.content);
			var keys = data.value.keyword.split(",");
			for (var i = 0; i < keys.length; i++) {
				$('#key' + i).val(keys[i].trim());
			}
			common.markupoption(note.url.notegetnclass, '#update-option', '其他');
			$('#update-option').val(data.value.nclass);
			$('#noteId').val(data.value.id)
		});
	},
	isNotEmpty : function(id) {
		return ($(id).val()) ? ',' + $(id).val() : '';
	},
	notemarkupupdatebtn : function() {
		$('#noteUpdateBtn').click(function() {
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
			common.doAjaxSubmit(note.url.noteupdate, {
				id : $('#noteId').val(),
				title : $('#update-title').val(),
				content : document.getElementById('update-content').innerHTML,
				keyword : $('#key0').val() + note.isNotEmpty('#key1') + note.isNotEmpty('#key2'),
				nclass : $('#update-option').val()
			}, '#noteUpdateDia', function(data) {
				note.notemarkuptable(note.param());
			});
		});
	},
	notemarkupsearchdatebtn : function() {
		$('#searchDateBtn').click(function() {
			note.notemarkuptable(note.param());
		});
	},
	notemarkupdatepicker : function() {
		$('.default-date-picker').datepicker({
			format : 'yyyy-mm-dd'
		});
	},
	notemarkuprefreshbtn : function() {
		$('#refreshBtn').click(function() {
			console.log('refreshBtn');
		});
	}
};