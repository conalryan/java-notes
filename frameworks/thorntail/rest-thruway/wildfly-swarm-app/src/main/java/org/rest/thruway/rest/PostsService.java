package org.rest.thruway.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/")
public interface PostsService {
    @Path("/posts")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Object getPosts();
}
