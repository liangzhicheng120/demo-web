var index =
	{
		url :
			{
				notelist : function()
					{
						return 'note/list';
					},
				notedelete : function()
					{
						return 'note/delete';
					},
				notebatchdelete : function()
					{
						return 'note/batchdelete';
					},
				notegetnclass : function()
					{
						return 'note/getnclass';
					}
			},
		table :
			{
				head : function()
					{
						return new Array('内容', '标题', '关键词', '类型', '修改时间');
					},
				body : function()
					{
						return new Array('content', 'title', 'keyword', 'nclass', 'posttime');
					},
				page : function()
					{
						return 'javascript:index.changeCurrentPage';
					},
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
		init : function()
			{
				index.notemarkuptable(); // 初始化表格
				index.notemarkupdeleteid(); // 注册删除事件
				index.notemarkuptoption(); // 初始化选择框
				$('#searchBtn').click(function()
					{ // 搜索
						index.notemarkuptable(index.param());
					});
				$('#deleteBtn').click(function()
					{ // 单个删除
						common.doAjaxWithNotAsync(index.url.notedelete(),
							{
								id : Number($('#id').val())
							}, function()
							{
								index.notemarkuptable(index.param());
							});
					});
				$('#batchDeleteBtn').click(function()
					{ // 批量删除
						var ids = common.getcheckids();
						if (ids.length != 0)
						{
							common.doAjaxWithNotAsync(index.url.notebatchdelete(),
								{
									ids : ids
								}, function()
								{
									index.notemarkuptable(index.param());
								});
						}
					});
				responsiveTable(); // 响应式表格
			},
		notemarkuptable : function(param)
			{
				common.markuptable(index.url.notelist(), param, index.notemarkupthead(), index.notemarkuptbody(), index.table.page());
			},
		notemarkupthead : function()
			{
				var before = '<input type="checkbox" onclick="common.checkall()">';
				var after = '操作';
				return common.markupthead(index.table.head(), before, after);
			},
		notemarkuptbody : function()
			{
				var before = '<input type="checkbox" name="checkbox_id" value="\${id}">';
				var after = '<a class="btn btn-success btn-sm" id="update">修改</a>&nbsp;&nbsp;';
				after += '<a class="btn btn-danger btn-sm" data-toggle="modal" data-target="#deleteDia" data-backdrop="static" data-id="\${id}">删除</a>';
				return common.markuptbody(index.table.body(), before, after);
			},
		changeCurrentPage : function(currentPage)
			{
				index.notemarkuptable(
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
				common.markupoption(index.url.notegetnclass(), '#nclass');
			},
		notechangeNcalss : function(osel)
			{
				var nclass = osel.options[osel.selectedIndex].value;
				if (nclass)
				{
					index.notemarkuptable(
						{
							currentPage : $('#currentPage').val(),
							keyword : $('#keyword').val().trim(),
							nclass : nclass
						});
					$('#currentNclass').val(nclass);
				}
			}
	};