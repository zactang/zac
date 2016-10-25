package com.zac.web.action;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zac.common.DBTest;
import com.zac.common.ben.Tb_Obj;

@Controller
@RequestMapping("/addr")
public class AddressController {

	@RequestMapping("/list")
	public String addlist(Map<String, Object> rep){
	
		
		String fileName = "E:/info/zac/lean/db/db/zac.db";
		 String driver="org.sqlite.JDBC";
		 String url="jdbc:sqlite:"+fileName;
		 Tb_Obj[][] res=DBTest.querySql(driver,url,null,null);
		 System.out.println(res.length);
		 rep.put("list", res);
		return "addlist";
	}
}
