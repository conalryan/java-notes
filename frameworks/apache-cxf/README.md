# _apache_cxf_notes

Apache CXF is an open source services framework. CXF helps you build and develop services using frontend programming APIs, like JAX-WS and JAX-RS. These services can speak a variety of protocols such as SOAP, XML/HTTP, RESTful HTTP, or CORBA and work over a variety of transports such as HTTP, JMS or JBI.

With so many options available to developers today in the web services space, one of the questions worth asking is why should I use CXF? In no particular order, here are some of the reasons you might want to use CXF:

## JAX-WS Support
CXF implements the JAX-WS APIs which make building web services easy. JAX-WS encompasses many different areas:

Generating WSDL from Java classes and generating Java classes from WSDL
Provider API which allows you to create simple messaging receiving server endpoints
Dispatch API which allows you to send raw XML messages to server endpoints
Much more...

## Spring Integration
- Spring is a first class citizen with Apache CXF. 
- CXF supports the Spring 2.0 XML syntax
- Declare endpoints which are backed by Spring and inject clients into your application.

## SOA Service Oriented Architecture
- Group business capabilites
- Provide contract for users to access
- Web services

## History
JAX-RPC
    - Soap xml over http
JAX-WS
    - Update JAX-RPC to support new standards
    - Soap 1.2
    - Wsdl 2.0
    - Jaxb
JAX-RS
    - Ajax calls directly from UI
    - REST
CXF
    - Framework for web services


## Maven Archetypes
https://mvnrepository.com/artifact/org.apache.cxf.archetype
CXF Archetype for each front end
JAX-RS Archetype
JAX-WS Archetype
    - Includes Java-first web service
    - Command: mvn archetype:generate -Dfilter=org.apache.cxf.type: 

Spring configuration for the JAX-WS endpoint. It defines the implementation class we looked at previously and the address for the endpoint. Next, let's look at the web.xml file. In the web deployment descriptor, you will see the Spring context loader as you would with any Spring-based web application. However, instead of the MVC dispatcher servlet, there is a CXF servlet mapped. 

## Web Container    
In this course, we will use Apache Tomcat as the web container for running our CXF web application. Tomcat was chosen as it is one of the most popular web application servers in the open source community

## CXF
- Pluggable service
- Interceptor
    - CXF Implements interceptor design pattern
    - Provides messages and fault handlers
    - Can be chained together
- Messages
    - Container for data to be passed through interceptor chains
- Interceptor Phases
    - Three logical groupings of phases
        - Incoming interceptor chains
            - Receive
                - perform transport level processing
                - Stream
                    - Pre/User/Post
                    - perform stream level processing and transformation
            - Read
                - Interceptors in the read phase will typically read the header of the incoming message construct
                - contains interceptors that implement protocol processing, such as SOAP handlers
                - Pre_Protocol
                - Pre_Protocol_Frontend
                - (User/Post)_Protocol
            - Unmarshal
                - request is unmarshalled from the request format into objects
            - Logical
                - (Pre/User/Post)_Logical
                - implement processing of the unmarshalled request objects
            - Invoke
                - perform actual execution of the service logic
                - Pre_Invoke
                - Invoke
                - Post_Invoke
        - Outgoing interceptor chains
            - have some similarity to the incoming phases , but they are executed in reverse
            - Setup
                - Interceptors in the setup phase will devise the plan for phases that follow in the chain
            - Logical
                - Interceptors in this phase perform processing objects that are about to be marshaled
            - Prepare_Send
                - Interceptors in the prepare_send phase are responsible for opening the outbound connection
            _ Pre_Stream
            - Pre_Protocol
                - Interceptors in the pre_stream and pre_protocol phases perform any behavior that's required for the streaming protocol prior to writing the outbound message        
            - Write
                - The write phase is where an interceptor will write the message based on the protocol, such as a SOAP envelope for JAX-WS web services. 
            - Marshall
                - Interceptors in the marshal phase will marshal the objects from the write phase into the outgoing format. 
            - User_Protocol
                - Interceptors in the user_protocol, post_protocol, user_stream, and post_stream perform any behavior required on the protocol message output from the marshal phase. 
            - Send Phase
                - send phase is where an interceptor will perform the actual action of sending the write level message stream to an endpoint. 
        - Post-processing 
            - associated to each of the phases in the inbound and outbound chains. 
            - Interceptors are given a to clean up and close anything that may have been created or opened during the inbound or outbound chains.

## CXF Architecture
- Bus
    - Central provider of resources
    - Spring-based registry of components - IoC
    - Highly customizable
    - Minimal configuration
    - cxf-rt-core
    - cxf-api
- Transports
    - http
        - Transport options
            - Deploy web services to a container?
            - Deploy web services with an embedded web container?
        - WAR
        - http server based on Jetty 
    - https
    - JMS
    - UDP
    - in-VM
    - Apache Camel offers additional
        - SMTP
        - Pop3
        - TCP
        - Jabber
- Front-ends
    - JAX-WS
        - XML
        - Spec for Java XML-based web services
        - Typically implmeented using WSDL with SOAP over HTTP
        - Availabe in the cxf-rt-frontend-jaxws library
        - Configured through Spring application context (i.e. in beans.xml)
            ```xml
            <jaxws:endpoint 
                  id="helloWorld" 
                  implementor="com.conal.ryan.cxfdemo.HelloWorldImpl" 
                  address="/HelloWorld">
            </jaxws:endpoint>
            ```
    - JAX-RS
        - REST
        - Spec for Java RESTful web services
        - Supports POJO through URLs
        - JAX-RS 2.0 - CXF 2.x mostly supports, CXF 3.x fully supports
        - JAX-RS 1.1 - CSF 2.x+ fully supports
        - XML, JSON, HTML, plaintext, binary octete
        - HTTP transport only
        - Available in cxf-rt-frontend-jaxrs libaray
        - Supported by the HTTP transport and CXF Servlet
        - Configured through Spring application context (i.e. in beans.xml)
            ```xml
            <jaxrs:server id="services" address="/">
              <jaxrs:serviceBeans>
                  <bean class="com.conal.ryan.cxfdemo.HelloWorld" />
              </jaxrs:serviceBeans>
              <jaxrs:providers>
                  <bean class="org.codehaus.jackson.jaxrs.JacksonJsonProvider" />
              </jaxrs:providers>
            </jaxrs:server>
            ```
    - JavaScript
- Data binding
    - Plugin approach
    - JAXB
        - Default data binding in CXF
        - Java Architecture for XML binding
        - Binding based on XML schema defintion
        - Unmarshal and marshal
        - Optionally defined JAXB as databinding in Spring application context (i.e. in beans.xml)
            ```xml
            <jaxws:endpoint 
                  id="helloWorld" 
                  implementor="com.conal.ryan.cxfdemo.HelloWorldImpl" 
                  address="/HelloWorld">
               <jaxws:dataBinding>    
                  <bean class="com.apache.cxf.jaxb.JAXBDataBinding" />
               </jaxws:dataBinding>
            </jaxws:endpoint>
            ```
        - CXF XJC Maven Plugin
            - XCJ is a binding compiler executed through a command prompt
            - Generates Java code based on an XSD
            - Compiled code is then made available via a dependency 
            - CXF supports XJC through a Maven plug-in
    - Aegis
    - SDO
    - XMLBeans
- Protocol Bindings for WSDL
    - SOAP
        - version 1.1
        - version 1.2
        - Language that defines service message format
        - Data is passed in an envelope that contains a header and body
        - Header is commonly extended to add support for security
        - Configured as port of the WSDL binding section
    - SOAP MTOM (Message Transmission Optimization Mechanism)
    - XML (Pure xml)
- WS-* Specifications
    - CSF supports most of the ws-* spec
    - Addressing
        - Added to SOAP header
        - Include an endpoint reference
    - Discovery
        - Multicast protocol
        - Leverages UDP protocol for communication
    - MetadataExchange
        - Configured thorugh SOAP header
        - cxf-rt-ws-mex
    - Policy
        - Domain-specific capabilities
        - Requirements
        - Configured through WSDL, Spring or API
        - cxf-rt-ws-policy       
    - ReliableMessaging
        - cxf-rt-ws-mex
    - Security
        - Provides security features beyond the transport level protocol
        - Exchange of authentication tokens between services
        - Encryption of parts or whole of a message
        - Message signature
        - Message time stamping
        - Public key management
        - cxf-rt-ws-security
        - CXF relies on WSS4J as the web service security provider and leverages interceptors for implementation
    - SecurityPolicy
        - Provides an easier, standars-based way to configure security
        - Defined through either the JAX-WS endpoint in the Spring configuration or the WSDL
        - cxf-rt-ws-security
    - SecureConversation
        - Provides better performing approach for encrypted communication
        - need to configure the web service security policy to define properties for the SecureConversation token
        - cxf-rt-ws-security
    - Trust
        - Supports the issuing, renewing, and validation of security tokens. 
        - It does this through a security token service. 
        - Need to configure trust as part of the security policies.
        - cxf-rt-ws-security
    
## CXF Servlet
- Supports request processing for web service endpoints. 
- Configured in the application's web descriptor file, similar to any servlet. 
- Servlet is available by including the cxf-rt-transports-http library as part of your project dependencies. 
- Servlet implementation contains full support for creating Spring's application context for your web application.

## CXF Web Container Support
- Apache Tomcat
- Jetty
- JBoss Application Server
    - Full JavaEE container, so may need extra steps in the setup
- WebLogic
- WebSphere Application Server
- Glassfish Application Server

## Contract First
1. Create WSDL (contract)
2. Create XSD (contract)
3. CXF CodeGen Plug-in (pom.xml)
4. Schema Domain Objects (src)
5. Service Endpoint Interface (src)
6. Endpoint Implementation (src)
7. Processing Logic (src)
8. Endpoint Implementation added to Spring Context (configuration)

## SEI
- Service Endpoint Interface
- @WebService(targetNamespace = "http://www.conal.ryan.com/service/Orders/", name = "Orders")
    - Obtained from portType in wsdl

## CXF Configuration
A CXF configuration file is really a Spring configuration file

beans.xml:
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd">
 
<!-- Configuration goes here! -->
 
</beans>

```
Required dependency in pom.xml:
```xml
<dependency>
   <groupId>org.springframework</groupId>
   <artifactId>spring-context</artifactId>
   <version>3.0.6.RELEASE</version>  (or most recent supported)
</dependency>
```

## JAX-WS Endpoint Bean Configuration
```xml
<jaxws:endpoint
    address=""
    id=""
    implementor="some.fully.qualified.class.name"
    bindingUri=""
    bus=""
    endpointName=""
    implementorClass=""
    publish=""
    publishedEndpointUrl=""
    serviceName=""
    transportId=""
    wsdlLocation="" />
```

## Spring Test
- Supports loading Spring's application context
- Framework agnostic
    - jUnit
        - Supports testing at the unit and integration test level
- Annotions for test case support

## Implementing a CXF Interceptor
Interceptors are used with both CXF clients and CXF servers. 
When a CXF client invokes a CXF server, 
there is an outgoing interceptor chain for the client and an incoming chain for the server. 
When the server sends the response back to the client, 
there is an outgoing chain for the server and an incoming one for the client. 
- Add additional processing to a chain
    - Auditing
    - SOAP message enhancement
- Skip a processing step
    - Non-standard web services
    
### Designing a Custom Interceptor
- Determine inbound or outbound
- Select a phase
- Determine where it fits in the order of phase processing
- Implement message and fault handling

Client Outbound -> Server Inbound
Client Inbound -> Server Outbound