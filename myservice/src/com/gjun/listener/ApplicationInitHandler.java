package com.gjun.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.gjun.domain.ApplicationConfig;
@WebListener()
public class ApplicationInitHandler implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		String realPath = application.getRealPath("/WEB-INF")+"/appReference.properties";
		
		
		try {
			ApplicationConfig config = new ApplicationConfig();
			InputStream is = new FileInputStream(realPath);
			
			Properties pro = new Properties();
			pro.load(is);
			config.setSakilaDao(pro.getProperty("sakladaoname"));
			config.setGjunDao(pro.getProperty("gjundaoname"));
			config.setCompanyName(pro.getProperty("company.name"));
			config.setAddress(pro.getProperty("company.address"));
			config.setPhone(pro.getProperty("company.phone"));
			
			application.setAttribute("config", config);
			is.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
