package com.gjun.service;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;

import com.gjun.domain.ApplicationConfig;
import com.gjun.domain.Customers;
import com.gjun.domain.Message;

@Path("/customers")
public class CustomersService {
	
	private ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
	private @Context ServletContext application;
	private @Context HttpServletRequest request;
	
	@Path("/query/country/{country}/rawdata")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response customersQryByCountry(@PathParam("country")String country) {
		ApplicationConfig config = (ApplicationConfig)application.getAttribute("config");
		String daoName = config.getSakilaDao();
		
		JdbcOperations dao = factory.getBean(daoName,JdbcOperations.class);
		List<Customers> result = dao.query("select ID,name,address,phone,city,country from customer_list where country=?"
				, new Object[] {country}
				,BeanPropertyRowMapper.newInstance(Customers.class));
		
		if(result.size()!=0) {
			return Response.ok(result,MediaType.APPLICATION_JSON).build();
		}else {
			Message message = new Message();
			message.setCode(400);
			message.setMsg("查無國家別:"+country+"資料!!!");
			
			return Response.status(400).entity(message).build();
		}
	}
}
