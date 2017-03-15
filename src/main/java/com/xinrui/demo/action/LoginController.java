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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Producer;
import com.xinrui.demo.bean.Admin;
import com.xinrui.demo.bean.BaseResultModel;
import com.xinrui.demo.service.AdminService;
import com.xinrui.demo.util.CheckUtil;
import com.xinrui.demo.util.CodeConstants;
import com.xinrui.demo.util.Constants;
import com.xinrui.demo.util.EncryptUtil;

@Controller
public class LoginController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private Producer captchaProducer = null;

	@RequestMapping(value = "/loginOn",method = RequestMethod.POST)
	@ResponseBody
	public BaseResultModel loginOn(HttpSession session, String username, String password,String captcha) throws Exception {
		BaseResultModel baseResultModel = new BaseResultModel();
		String sessionCaptcha = ( String ) session.getAttribute ( Constants.KAPTCHA_SESSION_KEY );
		CheckUtil.checkBlank(username, "账号不能为空");
		if (!captcha.equals(sessionCaptcha)) {
			baseResultModel.setCode(CodeConstants.PARAMETERS_CHECK_ERROR);
			baseResultModel.setMessage("验证码不正确");
			return baseResultModel;
		}
		Admin admin = adminService.getPasswordByName(username);
		if (admin == null) {
			baseResultModel.setCode(CodeConstants.PARAMETERS_CHECK_ERROR);
			baseResultModel.setMessage("账号不存在");
			return baseResultModel;
		}
		String encryptPassword = EncryptUtil.encryptMD5( username+password+Constants.SALT ); 
		String passwordDao = admin.getPassword();
		if (!encryptPassword.equals(passwordDao)) {
			baseResultModel.setCode(CodeConstants.PARAMETERS_CHECK_ERROR);
			baseResultModel.setMessage("密码错误");
			return baseResultModel;
		}
		baseResultModel.setRedirect("index");
		return baseResultModel;
	}



	@RequestMapping(value = "/captcha-image")
	public void getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
	}
	
}
