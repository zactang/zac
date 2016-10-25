package com.zac.web.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{

	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(HttpServletRequest req, Map<String, Object> rep, String username, String password) {
		
		String code=req.getParameter("validateCode");
		if(StringUtils.isEmpty(code)){
			req.setAttribute("errMsg", "验证码为空！");
			return "login";  
		}
		if (!(code.equalsIgnoreCase(req.getSession().getAttribute("code").toString()))) {  //忽略验证码大小写  
            req.setAttribute("errMsg", "验证码不正确！");
			return "login";  
		}
		
		
		req.setAttribute("errMsg", "用户名密码不正确");
		
		return "login";
	}
}
