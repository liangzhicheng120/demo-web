var login = {
	url : {
		loginOn : 'loginOn'
	},
	param : function() {
		return {
			username : $('#username').val().trim(),
			password : $('#password').val().trim(),
			captcha : $('#captcha').val().trim()
		};
	},
	init : function() {
		login.initView(); // 初始化界面
		login.vcodeBtn(); // 注册换验证码按钮
		login.loginBtn(); // 注册登陆按钮
	},
	initView : function() {
		$("#username").focus();
		$('body').particleground({
			dotColor : '#5cbdaa',
			lineColor : '#5cbdaa'
		});
	},
	vcodeBtn : function() {
		$('#vcode').click(function() {
			$("#vcode").attr("src", "captcha-image.do?" + Math.floor(100 * Math.random()));
		});
	},
	loginBtn : function() {
		$('#loginBtn').click(function() {
			login.validateParam();
			util.doAjaxWithPost(login.url.loginOn, login.param(), function(data) {
				window.location.href = data.redirect;
			});
		});
	},
	validateParam : function() {
		var validator = new Validator();
		validator.add($('#username'), [ {
			strategy : 'isNotEmpty',
			msg : '账号不能为空'
		} ]);
		validator.add($('#password'), [ {
			strategy : 'isNotEmpty',
			msg : '密码不能为空'
		} ]);
		validator.add($('#captcha'), [ {
			strategy : 'isNotEmpty',
			msg : '验证码不为空'
		} ]);
		validator.start();
	}
};
