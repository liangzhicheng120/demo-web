var register = {
	url : {

	},
	param : {

	},
	init : function() {
		register.initView(); // 初始化界面
	},
	initView : function() {
		$("#username").focus();
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
	},
}