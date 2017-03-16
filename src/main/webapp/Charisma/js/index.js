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
	notemarkuptbody : function() {
		return common.markuptbody(new Array('id', 'content', 'title', 'keyword', 'posttime'));
	},
	notemarkupthead : function() {
		return common.markupthead(new Array('id', '内容', '标题', '关键词', '修改时间'));
	}
}