var util = {
	/**
	 * Post 提交ajax
	 * @param url
	 * @param param
	 * @param fn
	 */
	doAjaxWithPost : function(url, param, fn) {
		$.ajax({
			url : url,
			type : 'POST',
			data : param,
			success : function(data) {
				if (data.code == 200) {
					fn(data);
				} else {
					$.tooltip('错误：' + data.message, 2500, false);
					console.log(data.message);
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				$.tooltip("错误：" + XMLHttpRequest.status + ',' + XMLHttpRequest.readyState + ',' + textStatus, 2500, false);
			}
		});
	},
}