# spring-boot

## Generate App
- Starter: https://start.spring.io/ 
- Project: Maven 
- Language: Java 
- Spring Boot: 1.5.22.RELEASE 
- Packaging: Jar 
- Java: 8 
- Dependencies: Web (Spring Web Starter)

## Build
```bash
./mvnw clean install
# Total Build Time: 8.677 s
```

## Test
```bash
./mvnw test
# Total Test Time: 2.001 s
```

## Run
```bash
./mvnw spring-boot:run
# Total Start Time: Application in 3.985 seconds (JVM running for 10.234)
```
- Application now runs and available at localhost:8080
- Expected results received:
```html
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Fri Aug 23 22:10:27 EDT 2019
There was an unexpected error (type=Not Found, status=404).
No message available
```

## Dependency Tree
```bash
./mvnw dependency:tree -Doutput=dependency-tree.txt
```

```
com.example:maven-java-jar-web:jar:0.0.1-SNAPSHOT
+- org.springframework.boot:spring-boot-starter-web:jar:1.5.22.RELEASE:compile
|  +- org.springframework.boot:spring-boot-starter:jar:1.5.22.RELEASE:compile
|  |  +- org.springframework.boot:spring-boot:jar:1.5.22.RELEASE:compile
|  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:1.5.22.RELEASE:compile
|  |  +- org.springframework.boot:spring-boot-starter-logging:jar:1.5.22.RELEASE:compile
|  |  |  +- ch.qos.logback:logback-classic:jar:1.1.11:compile
|  |  |  |  \- ch.qos.logback:logback-core:jar:1.1.11:compile
|  |  |  +- org.slf4j:jcl-over-slf4j:jar:1.7.26:compile
|  |  |  +- org.slf4j:jul-to-slf4j:jar:1.7.26:compile
|  |  |  \- org.slf4j:log4j-over-slf4j:jar:1.7.26:compile
|  |  \- org.yaml:snakeyaml:jar:1.17:runtime
|  +- org.springframework.boot:spring-boot-starter-tomcat:jar:1.5.22.RELEASE:compile
|  |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:8.5.43:compile
|  |  |  \- org.apache.tomcat:tomcat-annotations-api:jar:8.5.43:compile
|  |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:8.5.43:compile
|  |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:8.5.43:compile
|  +- org.hibernate:hibernate-validator:jar:5.3.6.Final:compile
|  |  +- javax.validation:validation-api:jar:1.1.0.Final:compile
|  |  +- org.jboss.logging:jboss-logging:jar:3.3.0.Final:compile
|  |  \- com.fasterxml:classmate:jar:1.3.1:compile
|  +- com.fasterxml.jackson.core:jackson-databind:jar:2.8.11.3:compile
|  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.8.0:compile
|  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.8.10:compile
|  +- org.springframework:spring-web:jar:4.3.25.RELEASE:compile
|  |  +- org.springframework:spring-aop:jar:4.3.25.RELEASE:compile
|  |  +- org.springframework:spring-beans:jar:4.3.25.RELEASE:compile
|  |  \- org.springframework:spring-context:jar:4.3.25.RELEASE:compile
|  \- org.springframework:spring-webmvc:jar:4.3.25.RELEASE:compile
|     \- org.springframework:spring-expression:jar:4.3.25.RELEASE:compile
\- org.springframework.boot:spring-boot-starter-test:jar:1.5.22.RELEASE:test
   +- org.springframework.boot:spring-boot-test:jar:1.5.22.RELEASE:test
   +- org.springframework.boot:spring-boot-test-autoconfigure:jar:1.5.22.RELEASE:test
   +- com.jayway.jsonpath:json-path:jar:2.2.0:test
   |  +- net.minidev:json-smart:jar:2.2.1:test
   |  |  \- net.minidev:accessors-smart:jar:1.1:test
   |  |     \- org.ow2.asm:asm:jar:5.0.3:test
   |  \- org.slf4j:slf4j-api:jar:1.7.16:compile
   +- junit:junit:jar:4.12:test
   +- org.assertj:assertj-core:jar:2.6.0:test
   +- org.mockito:mockito-core:jar:1.10.19:test
   |  \- org.objenesis:objenesis:jar:2.1:test
   +- org.hamcrest:hamcrest-core:jar:1.3:test
   +- org.hamcrest:hamcrest-library:jar:1.3:test
   +- org.skyscreamer:jsonassert:jar:1.4.0:test
   |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
   +- org.springframework:spring-core:jar:4.3.25.RELEASE:compile
   \- org.springframework:spring-test:jar:4.3.25.RELEASE:test

```

## Memory
```bash
jconsole
```

Heap Memory Usage: 180.7MB
Threads: 31
Classes: 7,947
CPU Usage: 0.2%

Select Memory tab and Perform GC
Heap Memory Usage: 41MB
