var strategys =
	{ // 定制规则
		isNotEmpty : function(value, msg)
			{
				if (value === '') return msg;
			},
		minLength : function(value, length, msg)
			{
				if (value.length < length) return msg;
			}
	};
var Validator = function()
	{
		this.cache = [] // 保存校验规则
	};
Validator.prototype.add = function(dom, rules)
	{
		var self = this;
		for (var i = 0, rule; rule = rules[i++];)
		{
			(function()
				{
					var strategyAry = rule.strategy.split(':');
					var msg = rule.msg;
					self.cache.push(function()
						{
							var strategy = strategyAry.shift();
							strategyAry.unshift(dom.value);
							strategyAry.push(msg);
							return strategys[strategy].apply(dom, strategyAry)
						});
				})(rule);
		}
	};
Validator.prototype.start = function() // 添加校验开始方法
	{
		for (var i = 0, validatorFunc; validatorFunc = this.cache[i++];)
		{
			var msg = validatorFunc();
			if (msg) {$.tooltip(msg, 2500, true);throw msg;} // 开始校验,取得校验后的返回信息
		}
	};
