var common =
	{
		/**
		 * 构造表头
		 * 
		 * @param array
		 * @returns {String}
		 */
		markupthead : function(array, before, after)
			{
				var result = '<tr>';
				result += '<th>' + before + '</th>';
				for ( var x in array)
				{
					result += '<th>' + array[x] + '</th>'
				}
				result += '<th>' + after + '</th>';
				result += '</tr>';
				return result;
			},
		/**
		 * 构造表身
		 * 
		 * @param array
		 * @returns {String}
		 */
		markuptbody : function(array, before, after)
			{
				var result = '<tr>';
				result += '<td>' + before + '</td>';
				for ( var x in array)
				{
					result += '<td>\$' + '{' + array[x] + '}' + '</td>'
				}
				result += '<td>' + after + '</td>';
				result += '</tr>';
				return result;
			},
		/**
		 * 构造表格
		 * 
		 * @param url
		 * @param param
		 * @param thead
		 * @param tbody
		 * @param tpage
		 */
		markuptable : function(url, param, thead, tbody, tpage)
			{
				common.doAjaxWithNotAsync(url, param, function(data)
					{
						$('#thead').html(thead);
						$('#tbody').empty();
						$.template("Template", tbody);
						$.tmpl("Template", common.makecontent(data.value.data)).appendTo("#tbody");
						common.markuptpage(data, tpage);
						$('.pinned').html(common.markupretable(data.value.data));
					});
			},
		/**
		 * 非异步获取数据
		 * 
		 * @param url
		 * @param param
		 * @param func
		 */
		doAjaxWithNotAsync : function(url, param, func)
			{
				$.ajax(
					{
						url : url,
						async : false,
						data : param,
						success : function(data)
							{
								if (data.code == 200)
								{
									func(data);
								}
								else
								{
									common.showerrordialog(data.code + ',' + data.message);
								}
							},
						error : function(XMLHttpRequest, textStatus, errorThrown)
							{
								common.showerrordialog(XMLHttpRequest.status + ',' + XMLHttpRequest.readyState + ',' + textStatus);
							}
					});

			},
		/**
		 * ajax提交表单
		 * @DOTO 未完成
		 * @param form
		 * @param modal
		 * @param callback
		 */
		doAjaxSubmitForm : function(formId, modalId, callback)
			{
				$(formId).ajaxSubmit(
					{
						secureuri : false,
						clearForm : true,
						resetForm : true,
						beforeSend : function()
							{
								$("#submitFooter a").addClass("disabled"); // 禁用提交按钮
							},
						success : function(data)
							{
								if (data.code == 200)
								{
									callback(data);
									$(modalId).modal('hide');
									$("#submitFooter a").removeClass("disabled"); // 提交按钮
								}
								else
								{
									alert(data.code + ',' + data.message)
								}
							},
						error : function(XMLHttpRequest, textStatus, errorThrown)
							{
								alert(XMLHttpRequest.status + ',' + XMLHttpRequest.readyState + ',' + textStatus);
							},
					});
			},
		/**
		 * 分页插件
		 * 
		 * @param data
		 */
		markuptpage : function(data, tchan)
			{
				var pageParam = data.value.pageParam;
				var tinfo = '';
				var tpage = '';
				if (pageParam.totalNumber != '0')
				{
					tinfo += '共查询到{0}条记录,当前为第{1}/{2}页'.format(pageParam.totalNumber, pageParam.currentPage, pageParam.totalPage);
				}
				else
				{
					tinfo += '共查询到0条记录,当前为第0/0页';
				}
				if (pageParam.currentPage != 1)
				{
					tpage += '<li><a href="{0}(1)">首页</a></li>'.format(tchan);
					tpage += '<li><a href="{0}({1})"><<</a></li>'.format(tchan, pageParam.currentPage - 1);
				}
				else
				{
					tpage += '<li class="disabled"><a href="javascript:void(0)">首页</a></li>';
					tpage += '<li class="disabled"><a href="javascript:void(0)"><<</a></li>';
				}
				tpage += '<li class="disabled"><a>{0}/{1}</a></li>'.format(pageParam.currentPage, pageParam.totalPage);
				if (pageParam.currentPage != pageParam.totalPage)
				{
					tpage += '<li><a href="{0}({1})">>></a></li>'.format(tchan, pageParam.currentPage + 1);
					tpage += '<li><a href="{0}({1})">末页</a></li>'.format(tchan, pageParam.totalPage);
				}
				else
				{
					tpage += '<li class="disabled"><a href="javascript:void(0)">>></a></li>';
					tpage += '<li class="disabled"><a href="javascript:void(0)">末页</a></li>';
				}
				$('#currentPage').val(pageParam.currentPage);
				$('#tinfo').html(tinfo);
				$('#tpage').html(tpage);
			},
		markupoption : function(url, selectId)
			{
				common.doAjaxWithNotAsync(url, null, function(data)
					{
						var nc = data.value;
						var content = '<option value="">--请选择--</option>';
						for (var i = 0; i < nc.length; i++)
						{
							content += '<option value="{0}">{1}</option>'.format(nc[i]['desc'], nc[i]['desc'])
						}
						$(selectId).html(content);
					});
			},
		/**
		 * 全选
		 */
		checkall : function()
			{
				var arrSon = document.getElementsByName('checkbox_id');
				var tempState = $("#checkAll").checked;
				for (i = 0; i < arrSon.length; i++)
				{
					if (arrSon[i].checked != tempState) arrSon[i].click();
				}
			},
		/**
		 * 获取选择后的id
		 * 
		 * @returns
		 */
		getcheckids : function()
			{
				obj = document.getElementsByName("checkbox_id");
				ids = [];
				for (k in obj)
				{
					if (obj[k].checked) ids.push(obj[k].value);
				}
				return ids.join(",")
			},
		/**
		 * 对于内容列大于20的字符改变显示
		 * 
		 * @param data
		 * @returns
		 */
		makecontent : function(data)
			{
				for ( var x in data)
				{
					data[x]['content'] = data[x]['content'].substring(0, 40) + '......';
				}
				return data
			},
		/**
		 * 模态框传值
		 * 
		 * @param id
		 * @param array
		 */
		markupdata : function(id, array)
			{
				$(id).on('show.bs.modal', function(event)
					{
						var a = $(event.relatedTarget);
						var modal = $(id);
						for (x in array)
						{
							modal.find('.modal-body #' + array[x]).val(a.data(array[x]));
						}
					});
			},
		/**
		 * 显示错误信息
		 * 
		 * @param msg
		 */
		showerrordialog : function(msg)
			{
				$('#errorDia').modal({keyboard : false,backdrop : false,show : true});
				$('#msg').html(msg);
			},
		markupretable : function(data)
			{
				var result = '<table class="table table-striped table-bordered">';
				result += '<thead class="thead">';
				result += '<tr style="height: 32px;">';
				result += '<th><input type="checkbox" onclick="common.checkall()"></th>';
				result += '</tr>';
				result += '</thead>';
				result += '<tbody class="tbody">';
				for (var i = 0; i < data.length; i++)
				{
					result += '<tr style="height: 39px;">';
					result += '<td><input type="checkbox" name="checkbox_id" value="{0}"></td>'.format(data[i]['id']);
					result += '</tr>';
				}
				result += '</tbody>';
				result += '</table>';
				return result;
			}
	};
/**
 * String.format方法
 * 
 * @param args
 * @returns {String}
 */
String.prototype.format = function(args)
	{
		var result = this;
		if (arguments.length > 0)
		{
			if (arguments.length == 1 && typeof (args) == "object")
			{
				for ( var key in args)
				{
					if (args[key] != undefined)
					{
						var reg = new RegExp("({" + key + "})", "g");
						result = result.replace(reg, args[key])
					}
				}
			}
			else
			{
				for (var i = 0; i < arguments.length; i++)
				{
					if (arguments[i] != undefined)
					{
						var reg = new RegExp("({)" + i + "(})", "g");
						result = result.replace(reg, arguments[i])
					}
				}
			}
		}
		return result
	};
