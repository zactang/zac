package com.zac.web.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.springframework.beans.BeanUtils;

import com.zac.util.StringUtil;
import com.zac.web.bean.vo.LoginVo;
import com.zac.web.util.Constant;


/**
 * 基础Controller
 * 
 * @author ZacTang
 *
 */
public abstract class BaseController {
	/**
	 * 获取当前登录用的所有信息
	 * @param req
	 * @return
	 */
	protected LoginVo getCurrentSysUser(HttpServletRequest req){
		LoginVo usrVo=(LoginVo)req.getSession().getAttribute(Constant.Session.LOGININFO);
		if (usrVo == null) {
			usrVo = new LoginVo();
		}
		return usrVo;
	}
	
	protected static String getHttpResponseContent(HttpServletRequest req) {
		//String msg = "";
		try{
			String remoteAddr = req.getHeader("X-Forwarded-For");
			// 如果通过多级反向代理，X-Forwarded-For的值不止一个，而是一串用逗号分隔的IP值，此时取X-Forwarded-For中第一个非unknown的有效IP字符串
			if (isEffective(remoteAddr) && (remoteAddr.indexOf(",") > -1)) {
				String[] array = remoteAddr.split(",");
				for (String element : array) {
					if (isEffective(element)) {
						remoteAddr = element;
						break;
					}
				}
			}
			if (!isEffective(remoteAddr)) {
				remoteAddr = req.getHeader("X-Real-IP");
			}
			if (!isEffective(remoteAddr)) {
				remoteAddr = req.getRemoteAddr();
			}
			return remoteAddr;
		}catch(Exception e){
			//log.error("get romote ip error,error message:"+e.getMessage());
			return "";
		}
		//return msg;
		// return bRet;
	}
	
	/**
	 * 获取客户端源端口
	 * @param request
	 * @return
	 */
	public static Long getRemotePort(final HttpServletRequest request){
		try{
			String port = request.getHeader("remote-port");
			if( !StringUtil.isEmpty(port )) {
				try{
					return Long.parseLong(port);
				}catch(NumberFormatException ex){
					//log.error("convert port to long error , port:	"+port);
					return 0l;
				}
			}else{
				return 0l;
			}		
		}catch(Exception e){
			//log.error("get romote port error,error message:"+e.getMessage());
			return 0l;
		}
	}

	/**
	 * 远程地址是否有效.
	 * @param remoteAddr 远程地址
	 * @return true代表远程地址有效，false代表远程地址无效
	 */
	private static boolean isEffective(final String remoteAddr) {
		boolean isEffective = false;
		if ((null != remoteAddr) && (!"".equals(remoteAddr.trim())) && (!"unknown".equalsIgnoreCase(remoteAddr.trim()))) {
			isEffective = true;
		}
		return isEffective;
	}
}

