package com.xinrui.demo.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;
import com.xinrui.demo.bean.BaseResultModel;
import com.xinrui.demo.exception.CodeConstants;
import com.xinrui.demo.service.UserInfoService;
import com.xinrui.demo.util.CheckUtil;
import com.xinrui.demo.util.Constants;

@Controller
public class LoginController {

	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private Producer captchaProducer = null;

	@RequestMapping(value = "/dologin")
	@ResponseBody
	public BaseResultModel dologin(HttpSession session, String username, String password) {
		BaseResultModel baseResultModel = new BaseResultModel();
		if (!"Admin".equalsIgnoreCase(username)) {
			baseResultModel.setCode(CodeConstants.USERNAME_CHECK_ERROR);
			baseResultModel.setMessage("账号错误");
		}
		if (!"123456".equalsIgnoreCase(password)) {
			baseResultModel.setCode(CodeConstants.PASSWORD_CHECK_ERROR);
			baseResultModel.setMessage("密码错误");
		}
		if ("Admin".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(password)) {
			session.setAttribute("username", Constants.ADMIN);
			baseResultModel.setRedirect("index");
		}
		return baseResultModel;
	}

	@RequestMapping(value = "/doregister")
	@ResponseBody
	public BaseResultModel doregister(String name, String password, String rePassword) {
		BaseResultModel baseResultModel = new BaseResultModel();
		CheckUtil.checkBlank(name, "用户名不能为空");
		CheckUtil.checkBlank(password, "密码不能为空");
		CheckUtil.checkObjIsEqual(password, rePassword, "两次密码不一致");
		return baseResultModel;
	}

	@RequestMapping(value = "/captcha-image")
	public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = captchaProducer.createText();
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
		return null;
	}
}
