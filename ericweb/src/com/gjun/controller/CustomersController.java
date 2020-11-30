package com.gjun.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;

import com.gjun.domain.Customer;
import com.gjun.domain.GjunCustomers;

//針對客戶資料維護控制器Controller
public class CustomersController {
	//attribute
	private String country;
	private String message;
	private ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	private List<Customer> result;
	private GjunCustomers customer;
	
	
	public GjunCustomers getCustomer() {
		return customer;
	}


	public void setCustomer(GjunCustomers customer) {
		this.customer = customer;
	}


	public List<Customer> getResult() {
		return result;
	}


	public void setResult(List<Customer> result) {
		this.result = result;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	//預設方法
	public String execute() {
		return "success";
	}
	
	public String countryQry() {
		if(this.country==null) {
			return "success";
		}else {
			JdbcOperations dao = factory.getBean("sakiladao", JdbcOperations.class);
			String sql = "select customer_id,first_name,last_name,address,city,country from vwcustomersdetails where country=?";
			result = dao.query(sql, new Object[] {country},
					new BeanPropertyRowMapper<Customer>(Customer.class));
			
			if(result.size()==0) {
				message=String.format("查詢國家別:%s 查無紀錄!!!", country);
			}
			return "ok";
		}
	}

}
