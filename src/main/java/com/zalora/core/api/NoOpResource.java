package com.zalora.core.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class NoOpResource {
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String empty()
	{
		return "Hello World !!";
	}
}
