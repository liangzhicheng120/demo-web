var index = {
	url : {
		notelist : function() {
			return 'note/list';
		}
	},
	init : function() {
		$.ajax({
			url : index.url.notelist(),
			success : function(data) {
				if (data.code == 200) {
					$('#thead').empty().html(index.notemarkupthead());
					$.template("Template", index.notemarkuptbody());
					$.tmpl("Template", common.makecontent(data.value.data)).appendTo("#tbody");
					responsiveTable();
				} else {
					alert(data.message);
				}
			}
		});
	},
	notemarkupthead : function() {
		var before = '<input type="checkbox" id="checkAll" onclick="common.checkall()">';
		var after  = '操作';
		return common.markupthead(new Array('内容', '标题', '关键词', '修改时间'), before, after);
	},
	notemarkuptbody : function() {
		var before = '<input type="checkbox" name="checkbox_id" value="\${id}">';
		var after  = '<a class="btn btn-success btn-sm" id="update">修改</a>&nbsp;&nbsp;';
			after += '<a class="btn btn-danger btn-sm" id="delete">删除</a>';
		return common.markuptbody(new Array('content', 'title', 'keyword', 'posttime'), before, after);
	}
}