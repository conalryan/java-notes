# [Jax-RS](https://github.com/jax-rs)


# [JAX-RS is just an API](https://www.baeldung.com/jax-rs-spec-and-implementations)
A RESTful API can be implemented in Java in a number of ways: you can use Spring, JAX-RS, or you might just write your own bare servlets if you’re good and brave enough. All you need is the ability to expose HTTP methods – the rest is all about how you organize them and how you guide the client when making calls to your API.

## Inclusion in Java EE
JAX-RS is nothing more than a specification, a set of interfaces and annotations offered by Java EE. And then, of course, we have the implementations; some of the more well known are RESTEasy and Jersey.

Also, if you ever decide to build a JEE-compliant application server, the guys from Oracle will tell you that, among many other things, your server should provide a JAX-RS implementation for the deployed apps to use. That’s why it’s called Java Enterprise Edition Platform.

Another good example of specification and implementation is JPA and Hibernate.

## Lightweight Wars
So how does all this help us, the developers? The help is in that our deployables can and should be very thin, letting the application server provide the needed libraries. This applies when developing a RESTful API as well: the final artifact should not contain any information about the used JAX-RS implementation.

## Always Know Your Server
We said so far that we should take advantage of the platform that we’re offered.

Before deciding on a server to use, we should see what JAX-RS implementation (name, vendor, version and known bugs) it provides, at least for Production environments. For instance, Glassfish comes with Jersey, while Wildfly or Jboss come with RESTEasy.

## Maven Example
pom.xml
````xml
<dependency>
    <groupId>javax</groupId>
    <artifactId>javaee-api</artifactId>
    <version>7.0</version>
    <scope>provided</scope>
</dependency>
````   
We’re using JavaEE 7 since there are already plenty of application servers implementing it. That API jar contains the annotations that you need to use, located in package javax.ws.rs. Why is the scope “provided”? Because this jar doesn’t need to be in the final build either – we need it at compile time and it is provided by the server for the run time.

After the dependency is added, we first have to write the entry class: an empty class which extends javax.ws.rs.core.Application and is annotated with javax.ws.rs.ApplicationPath:

````java
@ApplicationPath("/api")
  public class RestApplication extends Application {
}
````
We defined the entry path as being /api. Whatever other paths we declare for our resources, they will be prefixed with /api.

resource example
````java
@Path("/notifications")
public class NotificationsResource {
    @GET
    @Path("/ping")
    public Response ping() {
        return Response.ok().entity("Service online").build();
    }
 
    @GET
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNotification(@PathParam("id") int id) {
        return Response.ok()
          .entity(new Notification(id, "john", "test notification"))
          .build();
    }
 
    @POST
    @Path("/post/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postNotification(Notification notification) {
        return Response.status(201).entity(notification).build();
    }
}
````

Deploy this war on any application server implementing JEE7 and the following commands will work:

````bash
curl http://localhost:8080/simple-jaxrs-ex/api/notifications/ping/
 
curl http://localhost:8080/simple-jaxrs-ex/api/notifications/get/1
 
curl -X POST -d '{"id":23,"text":"lorem ipsum","username":"johana"}'
  http://localhost:8080/simple-jaxrs-ex/api/notifications/post/
  --header "Content-Type:application/json"
````

## Conclusion
At the end of this article, just keep in mind that JAX-RS is a powerful API and most (if not all) of the stuff that you need is already implemented by your web server. No need to turn your deployable into an unmanageable pile of libraries.

