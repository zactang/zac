package com.zac.web.action;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zac.web.util.DateUtil;

@Controller
@RequestMapping("/test")
public class TestController {

	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	@RequestMapping("/login2")
	public String login2(Map<String, Object> reponse){
		//reponse.put("dts", DateUtil.getMonthDetail());
		return "login2";
	}
}
