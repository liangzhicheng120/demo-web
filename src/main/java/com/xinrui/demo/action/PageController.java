package com.xinrui.demo.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xinrui.demo.python.PyConstants;
import com.xinrui.demo.python.PythonUtil;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.encrypt.EncryptUtil;
import com.xinrui.demo.util.web.CheckUtil;

@Controller
public class PageController {

	@RequestMapping(value = "/index")
	public String index() {
		return "main/index";
	}

	@RequestMapping(value = "/")
	public String defaultWeb() {
		return "main/login";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "main/login";
	}

	@RequestMapping(value = "/exit")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}

	@RequestMapping(value = "/test")
	public String test() {
		return "main/test";
	}

	@RequestMapping(value = "/register")
	public String register() {
		return "main/register";
	}

	@RequestMapping(value = "/note")
	public String note(HttpSession session, String clzss, String label) throws Exception {
		CheckUtil.checkBlank(clzss, "类别不能为空");
		CheckUtil.checkBlank(label, "标签不能为空");
		session.setAttribute(Constants.CLZSS, clzss);
		session.setAttribute(Constants.LABEL, label);
		PythonUtil.run(PyConstants.ml.BAYES_PY, EncryptUtil.HMACMD5(clzss));
		return "main/note";
	}

	@RequestMapping(value = "/learn")
	public String learn() {
		return "main/learn";
	}

	@RequestMapping(value = "/gallery")
	public String gallery() {
		return "main/gallery";
	}

	@RequestMapping(value = "/baike")
	public String baike() {
		return "main/baike";
	}
}
