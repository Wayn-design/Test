package com.gjun.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gjun.domain.IHello;

//�ĥΤFPOJO(Plain Old Java Object)
public class HelloController  {
	//attribute 
	//�غc�u�t���� �P�ɪ`�J�X����
	private ApplicationContext factory=
			new ClassPathXmlApplicationContext("applicationContext.xml");
	//�t�m�@�Ӹ�T���A�i�H�i�JValue stack
	private String helloMessage;
	

	public String getHelloMessage() {
		return helloMessage;
	}

	public void setHelloMessage(String helloMessage) {
		this.helloMessage = helloMessage;
	}

	//��պAaction�t�m�S�����wmethod�W�ٮ� �@�{�ϥγo�@��
	public String execute() {
		// TODO Auto-generated method stub
		return "success";
	}
	
	//�z�LSpring�u�t�ӭn�@�ӥ��۩I����i��ާ@
	public String helloExecute() {
		//1.��Spring�u�t(?)�n�@�ӥ��۩I������
		IHello hello=factory.getBean("hello",IHello.class);
		//��Value Stack�t�e�e���h �i�H���o��T
		this.helloMessage=hello.helloWorld();
		
		return "success";
	}
}