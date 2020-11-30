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

//�ϥ�web.xml �i���struts �d�I���i�涶�ǳ]�w

public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		//�d�I���S�����Ҫ�Cookie����
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		//���X�Ҧ���Cookie
		Cookie[] cookies=request.getCookies();
		boolean isValid=false;
		if(cookies!=null) {
			//���XCookie �P�_�O�_�����Ҫ�Cookie
			for(Cookie cookie:cookies) {
				//�P�_�O�_������(�n�J�o�X������)..�n�J�o�X���ҦW��.cred
				if(cookie.getName().equals(".appcred")) {
					isValid=true;
					break;
				}
			
			}
			//�i��P�_�O�_�X�k�ϥΪ�
			if(isValid) {
				//���U��
				chain.doFilter(request, response); 
			}else {
				//���j���f
				response.sendRedirect("../login.action");
			}
			
		}else
		{
			response.sendRedirect("../login.action");
		}
		
		
	}

}
