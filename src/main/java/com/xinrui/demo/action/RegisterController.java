package com.xinrui.demo.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xinrui.demo.bean.Admin;
import com.xinrui.demo.bean.BaseResultModel;
import com.xinrui.demo.service.AdminService;
import com.xinrui.demo.util.CheckUtil;
import com.xinrui.demo.util.CodeConstants;

@Controller
public class RegisterController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/doregister")
	@ResponseBody
	public BaseResultModel doRegister(String username, String password, String repassword) throws Exception {
		CheckUtil.checkBlank(username, "账号不能为空");
		CheckUtil.checkBlank(password, "密码不能为空");
		CheckUtil.checkObjIsEqual(password, repassword, "两次密码不一致");
		BaseResultModel baseResultModel = new BaseResultModel();
		Admin admin = adminService.getPasswordByName(username);
		if (admin != null) {
			baseResultModel.setCode(CodeConstants.PARAMETERS_CHECK_ERROR);
			baseResultModel.setMessage("账号已存在");
			return baseResultModel;	
		}
		adminService.save(username, repassword);
		baseResultModel.setRedirect("login");
		return baseResultModel;
	}
}
