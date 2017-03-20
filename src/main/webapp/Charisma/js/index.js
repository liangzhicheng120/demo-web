var index = {
	url : {
		notelist : function() {
			return 'note/list';
		},
		notedelete : function() {
			return 'note/delete';
		},
		notebatchdelete : function() {
			return 'note/batchdelete';
		}
	},
	table : {
		head : function() {
			return new Array('内容', '标题', '关键词', '修改时间');
		},
		body : function() {
			return new Array('content', 'title', 'keyword', 'posttime');
		},
		func : function() {
			return 'javascript:index.changeCurrentPage';
		}
	},
	init : function() {
		index.notemarkuptable(); // 初始化表格
		index.notemarkupdeleteid(); // 注册删除事件
		$('#searchBtn').click(function() { // 搜索功能
			index.notemarkuptable({
				currentPage : $('#currentPage').val(),
				keyword : $('#keyword').val().trim()
			});
		});
		$('#deleteBtn').click(function() { // 单个删除
			common.doAjaxWithNotAsync(index.url.notedelete(), {
				id : Number($('#id').val())
			}, function() {
				index.notemarkuptable({
					currentPage : $('#currentPage').val(),
					keyword : $('#keyword').val().trim()
				});
			});
		});
		$('#batchDeleteBtn').click(function() { // 批量删除功能
			var ids = common.getcheckids();
			if (ids.length != 0) {
				common.doAjaxWithNotAsync(index.url.notebatchdelete(), {
					ids : ids
				}, function() {
					index.notemarkuptable({
						currentPage : $('#currentPage').val(),
						keyword : $('#keyword').val().trim()
					});
				});
			}
		});
		responsiveTable(); // 响应式表格
	},
	notemarkuptable : function(param) {
		common.markuptable(index.url.notelist(), param, index.notemarkupthead(), index.notemarkuptbody(), index.table.func());
	},
	notemarkupthead : function() {
		var before = '<input type="checkbox" onclick="common.checkall()">';
		var after = '操作';
		return common.markupthead(index.table.head(), before, after);
	},
	notemarkuptbody : function() {
		var before = '<input type="checkbox" name="checkbox_id" value="\${id}">';
		var after = '<a class="btn btn-success btn-sm" id="update">修改</a>&nbsp;&nbsp;';
		after += '<a class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteDia" data-backdrop="static" data-id="\${id}">删除</a>';
		return common.markuptbody(index.table.body(), before, after);
	},
	changeCurrentPage : function(currentPage) {
		index.notemarkuptable({
			currentPage : currentPage,
			keyword : $('#keyword').val()
		});
	},
	notemarkupdeleteid : function() {
		common.markupdata('#deleteDia', new Array('id'));
	},
};