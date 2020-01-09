package org.thorntail.ex.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Logged
@Provider
public class ResponseLoggingFilter implements ContainerResponseFilter {

  private Logger LOG = LoggerFactory.getLogger(this.getClass());

  @Override
  public void filter(ContainerRequestContext requestContext,
                     ContainerResponseContext responseContext) throws IOException {
    // Use the ContainerRequestContext to extract information from the HTTP request
    // Use the ContainerResponseContext to extract information from the HTTP response
    LOG.info("--> [ResponseLoggingFilter]");
    LOG.debug(String.valueOf(responseContext.getStatus()));
    LOG.debug(responseContext.getEntity().toString());
  }
}
