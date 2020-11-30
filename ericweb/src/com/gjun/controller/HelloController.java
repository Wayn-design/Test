package com.gjun.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gjun.domain.IHello;

//採用了POJO(Plain Old Java Object)
public class HelloController  {
	//attribute 
	//建構工廠物件 同時注入合約書
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	//配置一個資訊狀態可以進入Value stack
	private String helloMessage;
	

	public String getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}

	//當組態action配置沒有指定method名稱時 一慮使用這一個
	public String execute() {
		// TODO Auto-generated method stub
		return "success";
	}
	
	//透過Spring工廠來要一個打招呼物件進行操作
	public String helloExecute() {
		//1.跟Spring工廠(?)要一個打招呼的物件
		IHello hello=factory.getBean("hello",IHello.class);
		//走Value Stack配送畫面去 可以取得資訊
		this.helloMessage=hello.helloWorld();
		
		return "success";
	}
}