package com.gjun.controller;

import java.sql.SQLException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcOperations;

import com.gjun.domain.Users;
//POJO Plain Old Java Object
public class RegisterController implements ServletResponseAware {
	//Attribute 配合註冊表單欄位name="xxxx"
	private String username;
	private String password;
	private String email;
	//BeanFactory 介面工廠
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	private String message; //處理之後的訊息狀態
	//登入會員資訊物件
	private Users users;
	private HttpServletResponse response;
	
	
	

	

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return action沒有指定方法名稱 就會這一個預設的
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return "success";
	}
	
	
	//派送登入頁面
	public String loginForm() {
		// TODO Auto-generated method stub
		//提供表單 也進行驗證作業
		if(this.users==null) {
			//第一次登入作業
			return "success";
		}else
		{
			//驗證是否合法帳號
			//工廠要DAO物件
			JdbcOperations dao=factory.getBean("dao",JdbcOperations.class);
			//進行查詢
			String sql="select count(*) as counter from users where username=? and password=?";
			//單筆查詢 透過第三個參數查詢結果指定轉型
			Integer i=dao.queryForObject(sql,
					new Object[] {users.getUsername(),users.getPassword()}
			,Integer.class);
			//Unboxing 打開物件取出那一個整數值
			if(i>0) {
				//發出前端的Cookie(憑證)
				Cookie cred=new Cookie(".appcred",users.getUsername());
				//讓HttpServletResponse對應Cookies 進行參考????
				response.addCookie(cred);
				
				message="驗證通過";
			}else
			{
				message="驗證失敗";
			}
				
			
			
			return "ok";
		}
	}

	
	//進行會員註冊
	public String registerSave(){
		//介面操作
		//1.擷取表單欄位內容 借助valuestack 表單欄位注入到attribute
		try {
		JdbcOperations dao=factory.getBean("dao",JdbcOperations.class);
		//進行新增作業
		String sql="insert Into users(username,password,email) values(?,?,?)";
		int affect=dao.update(sql,this.username,this.password,this.email);
		message=String.format("新增記錄數:%d",affect);
		
		return "success";
		}catch(Exception ex) {
			//維護上出現問題
			message=String.format("新增紀錄失敗，訊息:%s",ex.getMessage());
			return "failure";
			
		}
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		
	}
}