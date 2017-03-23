var rule =
	{
		isNotEmpty : function(value, msg)
			{
				if (value === '') return msg;
			},
		minLength : function(value, length, msg)
			{
				if (value.length < length) return msg;
			}
	}