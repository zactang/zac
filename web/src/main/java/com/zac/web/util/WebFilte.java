package com.zac.web.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class WebFilte implements Filter{

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		HttpServletResponse resp=(HttpServletResponse) response;
		String url=req.getRequestURI();
		
		Object obj=session.getAttribute(Constant.Session.LOGININFO);
		
		
		List<String> filteList=new ArrayList<String>();//列外访问
		filteList.add("/common/");//静态文件
		filteList.add("/favicon.ico");//静态文件
		filteList.add("/test/");//静态文件
		
		String fix=req.getContextPath();
		//如果未登录,除了login页面 进行过滤判断
		if(obj==null&&!url.equals(fix+"/login")&&!url.equals(fix+"/login/quit")&&!url.equals(fix+"/login/code")){
			int has=-1;
			for (String string : filteList) {
				has=url.indexOf(string);
				if(has!=-1){break;}
			}
			
			if(has==-1){
				resp.sendRedirect(fix+"/login");
				return ;
			}
			
			
		}
		chain.doFilter(request, response);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
