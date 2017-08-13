package com.yelun.weixin.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/test")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_ATOM_XML })
public class Test {

	@GET
	@Path("/test")
	public String getStudent() {
		return "hello Student!";
	}
}
