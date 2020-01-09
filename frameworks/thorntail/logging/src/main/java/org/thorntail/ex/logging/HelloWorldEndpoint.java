package org.thorntail.ex.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@GET
	@Logged
	@Produces("text/plain")
	public Response doGet() {
		LOG.info("--> LOG.info doGet called");
		// To start logging in debug mode
		// mvn thorntail:run -Dthorntail.logging=DEBUG
		LOG.debug("--> Log.debug Not called be default");
		return Response.ok("Hello from Thorntail!").build();
	}
}