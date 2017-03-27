package com.xinrui.demo.action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String note() {
		return "main/note";
	}
}
