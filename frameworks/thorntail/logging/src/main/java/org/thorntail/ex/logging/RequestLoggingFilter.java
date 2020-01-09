package org.thorntail.ex.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Logged
@Provider
public class RequestLoggingFilter implements ContainerRequestFilter {

  private Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    // Use the ContainerRequestContext to extract information from the HTTP request
    // Information such as the URI, headers and HTTP entity are available
    LOG.info("--> [RequestLoggingFilter]");
    LOG.debug(requestContext.getUriInfo().toString());
    LOG.debug(requestContext.getRequest().toString());
  }
}