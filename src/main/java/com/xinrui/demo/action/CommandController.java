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
		System.out.println("接收到输入参数" + param);
		String cmd = "1212312abns返回值带中文";
		System.out.println(StringUtil.getEncoding(cmd));
		return cmd;
	}

}
