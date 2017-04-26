var register = {
	url : {
		doregister : 'registerOn'
	},
	param : function() {
		return {
			username : $('#username').val().trim(),
			password : $('#password').val().trim(),
			repassword : $('#repassword').val().trim()
		};
	},
	init : function() {
		register.initView(); // 初始化界面
		register.registerBtn(); // 注册注册按钮
	},
	initView : function() {
		$("#username").focus();
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
	},
	registerBtn : function() {
		$('#registerBtn').click(function() {
			register.validateParam(); // 校验参数
			util.doAjaxWithPost(register.url.doregister, register.param(), function(data) {
				$.tooltip('OK,注册成功,3秒后跳转......', 3000, true);
				setTimeout(function() {
					window.location.href = data.redirect
				}, 3000);
			});
		});
	},
	validateParam : function() {
		var validator = new Validator();
		validator.add($('#username'), [ {
			strategy : 'isNotEmpty',
			msg : '注册账号不能为空'
		} ]);
		validator.add($('#password'), [ {
			strategy : 'isNotEmpty',
			msg : '注册密码不能为空'
		} ]);
		validator.add($('#repassword'), [ {
			strategy : 'isNotEmpty',
			msg : '请再输入一次密码'
		} ]);
		validator.start();
	},
}