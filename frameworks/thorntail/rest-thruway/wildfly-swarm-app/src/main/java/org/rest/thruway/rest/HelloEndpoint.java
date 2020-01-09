package org.rest.thruway.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.MediaType;
import java.net.URL;
import java.net.MalformedURLException;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.rest.thruway.rest.PostsService;

@Path("/hello")
public class HelloEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() throws MalformedURLException {
		PostsService postsService = RestClientBuilder.newBuilder()
				.baseUrl(new URL("https://jsonplaceholder.typicode.com"))
				.build(PostsService.class);
		Object repsonse = postsService.getPosts();
		return Response.ok()
				.entity("yay")
				.build();
	}
}