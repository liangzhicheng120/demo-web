var note =
	{
		url :
			{
				notelist : 'note/list',
				notedelete : 'note/delete',
				notebatchdelete : 'note/batchdelete',
				notegetnclass : 'note/getnclass',
			},
		init : function()
			{
				note.notemarkuptable(); // 初始化表格
				note.notemarkupdeleteid(); // 注册删除事件
				note.notemarkuptoption(); // 初始化选择框
				note.notemarkupnoteedit(); // 注册笔记编辑事件
				note.notemarkupsearchbtn(); // 注册搜索事件
				note.notemarkupdeletebtn(); // 注册单个删除事件
				note.notemarkupbatchdeletebtn() // 注册批量删除事件
				$('#noteSubmitBtn').click(function(){
						
				});
				responsiveTable(); // 注册响应式表格
			},
		table :
			{
				head : new Array('内容', '标题', '关键词', '类型', '修改时间'),
				body : new Array('content', 'title', 'keyword', 'nclass', 'posttime'),
				page : 'javascript:note.changeCurrentPage'
			},
		param : function()
			{
				var result =
					{
						currentPage : $('#currentPage').val(),
						keyword : $('#keyword').val().trim(),
						nclass : $('#currentNclass').val()
					}
				return result
			},
		notemarkuptable : function(param)
			{
				common.markuptable(note.url.notelist, param, note.notemarkupthead(), note.notemarkuptbody(), note.table.page);
			},
		notemarkupthead : function()
			{
				var before = '<input type="checkbox" onclick="common.checkall()">';
				var after = '操作';
				return common.markupthead(note.table.head, before, after);
			},
		notemarkuptbody : function()
			{
				var before = '<input type="checkbox" name="checkbox_id" value="\${id}">';
				var after = '<a class="btn btn-success btn-sm" id="update">修改</a>&nbsp;&nbsp;';
				after += '<a class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteDia" data-backdrop="static" data-id="\${id}">删除</a>';
				return common.markuptbody(note.table.body, before, after);
			},
		changeCurrentPage : function(currentPage)
			{
				note.notemarkuptable(
					{
						currentPage : currentPage,
						keyword : $('#keyword').val(),
						nclass : $('#currentNclass').val()
					});
			},
		notemarkupdeleteid : function()
			{
				common.markupdata('#deleteDia', new Array('id'));
			},
		notemarkuptoption : function()
			{
				common.markupoption(note.url.notegetnclass, '#nclass');
			},
		notechangeNcalss : function(osel)
			{
				var nclass = osel.options[osel.selectedIndex].value;
				if (nclass)
				{
					note.notemarkuptable(
						{
							currentPage : $('#currentPage').val(),
							keyword : $('#keyword').val().trim(),
							nclass : nclass
						});
					$('#currentNclass').val(nclass);
				}
			},
		notemarkupnoteedit : function()
			{
				var func = $('#noteEditBtn').click(function()
					{
						$('#noteEdit').modal(
							{
								backdrop : 'static',
								keyboard : false,
								show : true,
							});
						$('#trumbowyg').trumbowyg(
							{
								lang : 'zh_cn',
							});
					});
				return func;
			},
		notemarkupsearchbtn : function()
			{
				var func = $('#searchBtn').click(function()
					{
						note.notemarkuptable(note.param());
					});
				return func
			},
		notemarkupdeletebtn : function()
			{
				var func = $('#deleteBtn').click(function()
					{
						common.doAjaxWithNotAsync(note.url.notedelete,
							{
								id : Number($('#id').val())
							}, function()
							{
								note.notemarkuptable(note.param());
							});
					});
				return func;
			},
		notemarkupbatchdeletebtn : function()
			{
				var func = $('#batchDeleteBtn').click(function()
					{
						var ids = common.getcheckids();
						if (ids.length != 0)
						{
							common.doAjaxWithNotAsync(note.url.notebatchdelete,
								{
									ids : ids
								}, function()
								{
									note.notemarkuptable(note.param());
								});
						}
					});
				return func;
			}
	};