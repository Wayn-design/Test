package com.gjun.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//使用web.xml 進行跟struts 攔截器進行順序設定

public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//攔截有沒有憑證的Cookie物件
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//取出所有的Cookie
		Cookie[] cookies=request.getCookies();
		boolean isValid=false;
		if(cookies!=null) {
			//走訪Cookie 判斷是否有憑證的Cookie
			for(Cookie cookie:cookies) {
				//判斷是否有憑證(登入發出的憑證)..登入發出憑證名稱.cred
				if(cookie.getName().equals(".appcred")) {
					isValid=true;
					break;
				}
			
			}
			//進行判斷是否合法使用者
			if(isValid) {
				//往下走
				chain.doFilter(request, response); 
			}else {
				//踢到大門口
				response.sendRedirect("../login.action");
			}
			
		}else
		{
			response.sendRedirect("../login.action");
		}
		
		
	}

}
