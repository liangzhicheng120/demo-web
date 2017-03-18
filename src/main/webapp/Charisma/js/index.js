var index = {
	url : {
		notelist : function() {
			return 'note/list';
		}
	},
	init : function() {
		index.notemarkuptable(); // 初始化表格
		$('#searchBtn').click(function() { // 搜索功能
			index.notemarkuptable({
				currentPage : $('#currentPage').val(),
				keyword : $('#keyword').val().trim()
			});
		});
		responsiveTable(); // 响应式表格 
	},
	notemarkuptable : function(param) {
		common.markuptable(index.url.notelist(), param, index.notemarkupthead(), index.notemarkuptbody(), index.notemarkuptchan());
	},
	notemarkupthead : function() {
		var before = '<input type="checkbox" onclick="common.checkall()">';
		var after = '操作';
		return common.markupthead(new Array('内容', '标题', '关键词', '修改时间'), before, after);
	},
	notemarkuptbody : function() {
		var before = '<input type="checkbox" name="checkbox_id" value="\${id}">';
		var after = '<a class="btn btn-success btn-sm" id="update">修改</a>&nbsp;&nbsp;';
		   after += '<a class="btn btn-danger btn-sm" id="delete">删除</a>';
		return common.markuptbody(new Array('content', 'title', 'keyword', 'posttime'), before, after);
	},
	notemarkuptchan : function(){
		return 'javascript:index.changeCurrentPage';
	},
	changeCurrentPage : function(currentPage) {
		index.notemarkuptable({
			currentPage : currentPage,
			keyword : $('#keyword').val()
		});
	}
}