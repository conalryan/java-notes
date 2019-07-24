
# [Java EE](https://www.oracle.com/technetwork/java/javaee/overview/index.html)

## Java EE 8
- Java Servlet 4.0 API with HTTP/2 support
- Enhanced JSON support including a new JSON binding API
- A new REST Reactive Client API
- Asynchronous CDI Events
- A new portable Security API
- Server-Sent Events support (Client & Server-side)
- Support for Java SE 8 new capabilities (e.g. Date & Time API, Streams API, annotations enhancements)
- Oracle has transferred Java EE to the Eclipse Foundation, and it is now called **Jakarta EE** after Java EE 8. 
- There is a **Web Profile** subset of the **full EE platform** now available, as well as a **servlet-only web container**.

### Java EE8 JSRs (Java Specification Requests)
- JSR 366 – Java EE 8 Platform
- JSR 365 – Contexts and Dependency Injection (CDI) 2.0
- JSR 367 – The Java API for JSON Binding (JSON-B) 1.0
- JSR 369 – Java Servlet 4.0
- JSR 370 – Java API for RESTful Web Services (JAX-RS) 2.1
- JSR 372 – JavaServer Faces (JSF) 2.3
- JSR 374 – Java API for JSON Processing (JSON-P)1.1
- JSR 375 – Java EE Security API 1.0
- JSR 380 – Bean Validation 2.0
- JSR 250 – Common Annotations 1.3
- JSR 338 – Java Persistence 2.2
- JSR 356 – Java API for WebSocket 1.1
- JSR 919 – JavaMail 1.6

## Servers
- GlassFish Server 5
  - GlassFish is the Java EE reference implementation developed by Oracle.
  - If you use GlassFish and need commercial support in the future, you’ll need to migrate to a completely different application server.
	- It might not sound like a big deal to you right now, but it’s a deal-breaker for many businesses. Consider what your future needs might look like, at the very least.
- [Java EE Compatible Servers](https://www.oracle.com/technetwork/java/javaee/overview/compatibility-jsp-136984.html)
	- Java EE 8 Full Platform Compatible Implementations
		- GlassFish Server Open Source Edition 5.0
		- IBM WebSphere Application Server Liberty Version 18.0.0.2
		- WildFly 14.x
		- Red Hat JBoss EAP 7
		- Red Hat JBoss EAP 7.2
		- Eclipse GlassFish 5.1
	- Java EE 8 Web Profile Compatible Implementations
		- GlassFish Server Open Source Edition 5.0
		- WildFly 14.x Web Profile
		- IBM WebSphere Application Server Liberty Version 18.0.0.2
		- Red Hat JBoss EAP 7
		- Red Hat JBoss EAP 7.2
		- Eclipse GlassFish 5.1
- Tomcat
	- Tomcat is not a JavaEE application server because it does not adhire to the Java EE spec, however, it is claimed that Tomcat hosts 60% of all Java applications.
	- Indeed, Tomcat doesn’t implement all the features required of a Java EE application server. The accurate title for Tomcat would be either “web server” or “servlet container”.
- Jetty
	- Jetty is another application server (this one developed by Eclipse Foundation) that isn’t technically a fully featured Java EE container. 
	- Just like Tomcat, it lacks support for many Java EE features.
	- Two of its main selling points are its compactness and small footprint. 
	- Both make Jetty a great fit for constrained environments and for embedding in other products.
- WildFly
	- Formerly known as JBoss Application Server and developed by Red Hat, is another fully featured and certified application server.
	- The big advantage of WildFly over GlassFish is that Red Hat provides an easy migration path from WildFly to its commercially supported application server called JBoss Enterprise Application Platform. This means that you can use WildFly today and quickly migrate to JBoss EAP in the future to get commercial support if you decide that’s something you need.

Overall, I’d suggest favoring Tomcat, but consider Jetty if you need its smaller footprint. Otherwise, if you need extensive Java EE support in your project, take WildFly.
- [netty](https://netty.io/)
	- Netty is a non-blocking I/O client-server framework for the development of Java network applications such as protocol servers and clients. 
	- The asynchronous event-driven network application framework and tools are used to simplify network programming such as TCP and UDP socket servers. 
	- Netty includes an implementation of the reactor pattern of programming. 
	- Originally developed by JBoss, Netty is now developed and maintained by the Netty Project Community.
	- Netty includes built-in HTTP, HTTP2, DNS and more protocols support, including the ability to run inside a servlet container, support for WebSockets, integration with Google Protocol Buffers, SSL/TLS support, support for SPDY protocol and support for message compression. 
	- Netty has been actively developed since 2004
- [Undertow](http://undertow.io/)
	- Undertow is a flexible performant web server written in java, providing both blocking and non-blocking API’s based on NIO.
	- Undertow has a composition based architecture that allows you to build a web server by combining small single purpose handlers. The gives you the flexibility to choose between a full Java EE servlet 4.0 container, or a low level non-blocking handler, to anything in between.
	- Undertow is designed to be fully embeddable, with easy to use fluent builder APIs. Undertow’s lifecycle is completely controlled by the embedding application.
	- Undertow is sponsored by JBoss and is the default web server in the Wildfly Application Server.

## JDKs
- Java EE Platform SDK 8u1
- Java EE Web Profile SDK 8u1

## Cloud and Commercial Support for Java EE 7
- WebLogic Server 12.2.1
- Oracle WebLogic Server 12cR2 is fully Java Enterprise Edition 7 compatible and Java SE 8 certified, supporting the latest developer innovations.

## Oracle Java Cloud Service
- Oracle Java Cloud Service is a complete platform and infrastructure cloud solution for building, deploying, and managing Java EE applications. 
- Oracle Java Cloud Service fully supports Java EE 7 through its offering of

## Reference Implementations
- GlassFIsh Server Open Source Edition [javaee.github.io/glassfish]() Java EE Reference Implementation built in open source
- Project Open MQ	[javaee.github.io/openmq]() High quality, enterprise ready messaging; open source and a community of developers and users.
- Project Jersey	[jersey.github.io]() Jersey is the open source, production quality, JAX-RS (JSR 370) Reference Implementation for building RESTful Web services.
- Project Grizzly	[javaee.github.io/grizzly]() Project Grizzly help developers to build scalable and robust servers using NIO as well as offering extended framework components
- JavaServer Faces (Project Mojarra) [javaserverfaces.github.io]() Java Server Faces (JSF) Reference Implementation
- Project Metro	[javaee.github.io/metro]() Metro is a high-performance, extensible, easy-to-use web service stack.


# Java EE ?

## [What is Java EE](https://stackoverflow.com/questions/7295096/what-exactly-is-java-ee)
- Java EE is indeed an abstract specification. Anybody is open to develop and provide a working implementation of the specification. The concrete implementations are the so-called application servers, like WildFly, TomEE, GlassFish, Liberty, WebLogic, etc. There are also servlet containers which implement only the JSP/Servlet part of the huge Java EE API, such as Tomcat, Jetty, etc.
- We, Java EE developers, should write code utilizing the specification (i.e. import only javax.* classes in our code instead of implementation specific classes such as org.jboss.wildfly.*, com.sun.glassfish.*, etc) and then we'll be able to run our code on any implementation (thus, on any application server). If you're familiar with JDBC, it's basically the same concept as how JDBC drivers work. See also a.o. In simplest terms, what is a factory?
- The Java EE SDK download from Oracle.com contains basically the GlassFish server along a bunch of documentation and examples and optionally also the NetBeans IDE. You don't need it if you want a different server and/or IDE.
- EJB is part of the Java EE specification. Look, it's in the Java EE API. Full-fledged Java EE application servers support it out the box, but simple JSP/Servlet containers don't.
- EJB is part of Java EE. Spring is a standalone framework which substitutes and improves many parts of Java EE. Spring doesn't necessarily require Java EE to run. A barebones servletcontainer like Tomcat is already sufficient. Simply put, Spring is a competitor of Java EE. E.g. "Spring" (standalone) competes EJB/JTA, Spring MVC competes JSF/JAX-RS, Spring DI/IoC/AOP competes CDI, Spring Security competes JAAS/JASPIC, etc.
- Back during the old J2EE/EJB2 times, the EJB2 API was terrible to implement and maintain. Spring was then a much better alternative to EJB2
- Since CDI (Java EE 6), there's not really a reason to look at again another framework like Spring to make the developers more easy as to developing among others the service layer.
- Only when you're using a barebones servletcontainer such as Tomcat and can't move on to a Java EE server, then Spring is more attractive as it's easier to install Spring on Tomcat. It isn't possible to install e.g. an EJB container om Tomcat without modifying the server itself, you would basically be reinventing TomEE.

# [Java vs Java EE](https://www.educba.com/java-vs-java-ee/)
- Java is a programming language and also a computing platform. A platform is the hardware or software environment in which programs run. Java was developed by Sun Microsystems which was led by James Gosling.
- Java has two components Java Virtual Machine and Application Programming Interface. Java is now available as free software under terms of GNU General Public License.


# [Java Platform, Enterprise Edition (Java EE)](https://www.theserverside.com/definition/J2EE-Java-2-Platform-Enterprise-Edition)
- The Java Platform, Enterprise Edition (Java EE) is a collection of Java APIs owned by Oracle that software developers can use to write server-side applications. 
- It was formerly known as Java 2 Platform, Enterprise Edition, or J2EE.
- Sun Microsystems (together with industry partners such as IBM) originally designed Java EE to simplify application development in a thin-client-tiered environment. 
- Java EE simplifies app development and decreases the need for programming by creating standardized, reusable modular components and by enabling the tier to handle many aspects of programming automatically.
- Java EE applications are hosted on application servers, such as  IBM's WebSphere, Oracle's GlassFish or Red Hat's WildFly server, all of which run either in the cloud or within a corporate data center. While Java EE apps are hosted on the server side, examples of Java EE clients include an internet of things (IoT) device, smartphone, RESTful web service, standard web-based application, WebSocket or even microservices running in a Docker container.

## Java EE architecture goals
- The Java EE architecture provides services that simplify the most common challenges facing developers when building modern applications, in many cases through APIs, thus making it easier to use popular design patterns and industry-accepted best practices.
- For example, one common challenge enterprise developers face is how to handle requests coming in from web-based clients. To simplify this challenge, Java EE provides the **Servlet** and JavaServer Pages (JSP) APIs, which provide methods for activities like finding out what a user typed into a text field in an online form or storing a cookie on a user's browser.
- Another common task is how to store and retrieve information in a database. To address this goal, Java EE provides the Java Persistence API (JPA,) which makes it easy to map data used within a program to information stored in the tables and rows of a database. Also, creating web services or highly scalable logic components is simplified through the use of the Enterprise JavaBeans (EJB) specification. All of these APIs are well tested, relatively easy for Java developers to learn and can greatly simplify some of the hardest parts of enterprise development.