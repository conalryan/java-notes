package org.rest.thruway.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class HelloEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		Client client = ClientBuilder.newClient();
		Object response =
				client.target("https://jsonplaceholder.typicode.com/posts").request(MediaType.APPLICATION_JSON).get(Object.class);
		return Response.ok("yay").build();
	}
}