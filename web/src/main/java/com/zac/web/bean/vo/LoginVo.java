package com.zac.web.bean.vo;

import java.util.ArrayList;
import java.util.List;

public class LoginVo {

	/**权限菜单*/
	private List<String> menus=new ArrayList<String>();
	
	/**昵称*/
	private String usrName;
	/**账号*/
	private String usrAcct;
	
	
	
	public List<String> getMenus() {
		return menus;
	}
	public void setMenus(List<String> menus) {
		this.menus = menus;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrAcct() {
		return usrAcct;
	}
	public void setUsrAcct(String usrAcct) {
		this.usrAcct = usrAcct;
	}
	
	
}
