var common = {
	/**
	 * 构造表头
	 * 
	 * @param array
	 * @returns {String}
	 */
	markupthead : function(array, before, after) {
		var result = '<tr>';
		result += '<th>' + before + '</th>';
		for ( var x in array) {
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
	markuptbody : function(array, before, after) {
		var result = '<tr>';
		result += '<td>' + before + '</td>';
		for ( var x in array) {
			result += '<td>\$' + '{' + array[x] + '}' + '</td>'
		}
		result += '<td>' + after + '</td>';
		result += '</tr>';
		return result;
	},
	markuptable : function(url, param, thead, tbody, tpage) {
		$.ajax({
			url : index.url.notelist(),
			async : false,
			data : param,
			success : function(data) {
				if (data.code == 200) {
					$('#thead').html(thead);
					$('#tbody').empty();
					$.template("Template", tbody);
					$.tmpl("Template", common.makecontent(data.value.data)).appendTo("#tbody");
					common.markuptpage(data, tpage);
				} else {
					alert('{0}:{1}'.format(data.code, data.message));
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert('异常错误信息' + XMLHttpRequest.status + ':' + XMLHttpRequest.readyState + ':' + textStatus);
			}
		});
	},
	/**
	 * 分页插件
	 * 
	 * @param data
	 */
	markuptpage : function(data, tchan) {
		var pageParam = data.value.pageParam;
		var tinfo = '';
		var tpage = '';
		if (pageParam.totalNumber != '0') {
			tinfo += '共查询到{0}条记录,当前为第{1}/{2}页'.format(pageParam.totalNumber, pageParam.currentPage, pageParam.totalPage);
		} else {
			tinfo += '共查询到0条记录,当前为第0/0页';
		}
		if (pageParam.currentPage != 1) {
			tpage += '<li><a href="{0}(1)">首页</a></li>'.format(tchan);
			tpage += '<li><a href="{0}({1})"><<</a></li>'.format(tchan, pageParam.currentPage - 1);
		} else {
			tpage += '<li class="disabled"><a href="javascript:void(0)">首页</a></li>';
			tpage += '<li class="disabled"><a href="javascript:void(0)"><<</a></li>';
		}
		tpage += '<li class="disabled"><a>{0}/{1}</a></li>'.format(pageParam.currentPage, pageParam.totalPage);
		if (pageParam.currentPage != pageParam.totalPage) {
			tpage += '<li><a href="{0}({1})">>></a></li>'.format(tchan, pageParam.currentPage + 1);
			tpage += '<li><a href="{0}({1})">末页</a></li>'.format(tchan, pageParam.totalPage);
		} else {
			tpage += '<li class="disabled"><a href="javascript:void(0)">>></a></li>';
			tpage += '<li class="disabled"><a href="javascript:void(0)">末页</a></li>';
		}
		$('#currentPage').val(pageParam.currentPage);
		$('#tinfo').html(tinfo);
		$('#tpage').html(tpage);
	},
	/**
	 * 全选
	 */
	checkall : function() {
		var arrSon = document.getElementsByName('checkbox_id');
		var tempState = $("#checkAll").checked;
		for (i = 0; i < arrSon.length; i++) {
			if (arrSon[i].checked != tempState)
				arrSon[i].click();
		}
	},
	/**
	 * 获取选择后的id
	 * 
	 * @returns
	 */
	getcheckids : function() {
		obj = document.getElementsByName("checkbox_id");
		ids = [];
		for (k in obj) {
			if (obj[k].checked)
				ids.push(obj[k].value);
		}
		return ids.join(",")
	},
	/**
	 * 对于内容列大于20的字符改变显示
	 * 
	 * @param data
	 * @returns
	 */
	makecontent : function(data) {
		for ( var x in data) {
			data[x]['content'] = data[x]['content'].substring(0, 40) + '......';
		}
		return data
	},
};
/**
 * String.format方法
 * 
 * @param args
 * @returns {String}
 */
String.prototype.format = function(args) {
	var result = this;
	if (arguments.length > 0) {
		if (arguments.length == 1 && typeof (args) == "object") {
			for ( var key in args) {
				if (args[key] != undefined) {
					var reg = new RegExp("({" + key + "})", "g");
					result = result.replace(reg, args[key])
				}
			}
		} else {
			for (var i = 0; i < arguments.length; i++) {
				if (arguments[i] != undefined) {
					var reg = new RegExp("({)" + i + "(})", "g");
					result = result.replace(reg, arguments[i])
				}
			}
		}
	}
	return result
};