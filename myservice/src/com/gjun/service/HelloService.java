package com.gjun.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.gjun.domain.Message;

@Path("/hello")
public class HelloService {
	@Path("/helloWorld")
	@GET
	@Produces("text/plain")
	public String helloWorld() {
		return "Hello World";
	}
	
	@Path("/twhello")
	@GET
	@Produces("application/json")
	public Message twHello() {
		Message message = new Message();
		message.setCode(200);
		message.setMsg("您好");			
		return message;
	}
	
	@Path("/passing/twhello")
	@GET
	@Produces("application/json")
	public Message helloPassing(@QueryParam("w")String who) {
		Message message = new Message();
		message.setCode(200);
		message.setMsg("您好 "+who);			
		return message;
	}
	
}
