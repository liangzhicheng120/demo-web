package com.xinrui.demo.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.demo.util.StringUtil;

@Controller
@RequestMapping(value = "/command")
public class CommandController {

	@RequestMapping(value = "/cmd")
	@ResponseBody
	public String cmd(String param) throws Exception {
		System.out.println("���յ��������" + param);
		String cmd = "1212312abns����ֵ������";
		System.out.println(StringUtil.getEncoding(cmd));
		return cmd;
	}

}
