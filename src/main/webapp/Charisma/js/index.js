var index =
	{
		html : function(page)
			{
				$.ajax(
					{
						url : page,
						success : function(data)
							{
								$('.box-inner').html(data)
							},
						error : function(XMLHttpRequest, textStatus, errorThrown)
							{
								common.showerrordialog(XMLHttpRequest.status + ',' + XMLHttpRequest.readyState + ',' + textStatus);
							}
					});
			}
	}