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
}