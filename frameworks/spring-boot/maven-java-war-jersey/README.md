# spring-boot

## Generate App
- Starter: https://start.spring.io/ 
- Project: Maven 
- Language: Java 
- Spring Boot: 2.1.7 
- Packaging: War 
- Java: 8 
- Dependencies: Jersey

## Build
```bash
./mvnw clean install
Total Build Time: 17.589 s
```

## Test
```bash
./mvnw test
# Total Test Time: 2.875 s
```

## Run
```bash
./mvnw spring-boot:run
# Total Start Time: Application in 5.661 seconds (JVM running for 111.561)
```

## Dependency Tree
```
10:28 $ ./mvnw dependency:tree
[INFO] Scanning for projects...
[INFO]
[INFO] ---------------------< com.maven:java-war-jersey >----------------------
[INFO] Building java-war 0.0.1-SNAPSHOT
[INFO] --------------------------------[ war ]---------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:3.1.1:tree (default-cli) @ java-war-jersey ---
[INFO] com.maven:java-war-jersey:war:0.0.1-SNAPSHOT
[INFO] +- org.springframework.boot:spring-boot-starter-jersey:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-json:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-databind:jar:2.9.9:compile
[INFO] |  |  |  \- com.fasterxml.jackson.core:jackson-core:jar:2.9.9:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jdk8:jar:2.9.9:compile
[INFO] |  |  +- com.fasterxml.jackson.datatype:jackson-datatype-jsr310:jar:2.9.9:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-parameter-names:jar:2.9.9:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter-validation:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework:spring-web:jar:5.1.9.RELEASE:compile
[INFO] |  |  \- org.springframework:spring-beans:jar:5.1.9.RELEASE:compile
[INFO] |  +- org.glassfish.jersey.core:jersey-server:jar:2.27:compile
[INFO] |  |  +- org.glassfish.jersey.core:jersey-common:jar:2.27:compile
[INFO] |  |  |  \- org.glassfish.hk2:osgi-resource-locator:jar:1.0.1:compile
[INFO] |  |  +- org.glassfish.jersey.core:jersey-client:jar:2.27:compile
[INFO] |  |  +- javax.ws.rs:javax.ws.rs-api:jar:2.1:compile
[INFO] |  |  +- org.glassfish.jersey.media:jersey-media-jaxb:jar:2.27:compile
[INFO] |  |  \- javax.validation:validation-api:jar:2.0.1.Final:compile
[INFO] |  +- org.glassfish.jersey.containers:jersey-container-servlet-core:jar:2.27:compile
[INFO] |  +- org.glassfish.jersey.containers:jersey-container-servlet:jar:2.27:compile
[INFO] |  +- org.glassfish.jersey.ext:jersey-bean-validation:jar:2.27:compile
[INFO] |  +- org.glassfish.jersey.ext:jersey-spring4:jar:2.27:compile
[INFO] |  |  +- org.glassfish.jersey.inject:jersey-hk2:jar:2.27:compile
[INFO] |  |  |  \- org.glassfish.hk2:hk2-locator:jar:2.5.0-b42:compile
[INFO] |  |  |     +- org.glassfish.hk2.external:aopalliance-repackaged:jar:2.5.0-b42:compile
[INFO] |  |  |     \- org.javassist:javassist:jar:3.22.0-CR2:compile
[INFO] |  |  +- org.glassfish.hk2:hk2:jar:2.5.0-b42:compile
[INFO] |  |  |  +- org.glassfish.hk2:hk2-utils:jar:2.5.0-b42:compile
[INFO] |  |  |  |  \- javax.inject:javax.inject:jar:1:compile
[INFO] |  |  |  +- org.glassfish.hk2:hk2-api:jar:2.5.0-b42:compile
[INFO] |  |  |  +- org.glassfish.hk2:config-types:jar:2.5.0-b42:compile
[INFO] |  |  |  +- org.glassfish.hk2:hk2-core:jar:2.5.0-b42:compile
[INFO] |  |  |  +- org.glassfish.hk2:hk2-config:jar:2.5.0-b42:compile
[INFO] |  |  |  +- org.glassfish.hk2:hk2-runlevel:jar:2.5.0-b42:compile
[INFO] |  |  |  \- org.glassfish.hk2:class-model:jar:2.5.0-b42:compile
[INFO] |  |  |     \- org.glassfish.hk2.external:asm-all-repackaged:jar:2.5.0-b42:compile
[INFO] |  |  +- org.glassfish.hk2:spring-bridge:jar:2.5.0-b42:compile
[INFO] |  |  \- org.springframework:spring-aop:jar:5.1.9.RELEASE:compile
[INFO] |  +- org.glassfish.jersey.media:jersey-media-json-jackson:jar:2.27:compile
[INFO] |  |  +- org.glassfish.jersey.ext:jersey-entity-filtering:jar:2.27:compile
[INFO] |  |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.9.0:compile
[INFO] |  |  \- com.fasterxml.jackson.module:jackson-module-jaxb-annotations:jar:2.9.9:compile
[INFO] |  \- javax.xml.bind:jaxb-api:jar:2.3.1:compile
[INFO] |     \- javax.activation:javax.activation-api:jar:1.2.0:compile
[INFO] +- org.springframework.boot:spring-boot-starter-web:jar:2.1.7.RELEASE:compile
[INFO] |  +- org.springframework.boot:spring-boot-starter:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-autoconfigure:jar:2.1.7.RELEASE:compile
[INFO] |  |  +- org.springframework.boot:spring-boot-starter-logging:jar:2.1.7.RELEASE:compile
[INFO] |  |  |  +- ch.qos.logback:logback-classic:jar:1.2.3:compile
[INFO] |  |  |  |  \- ch.qos.logback:logback-core:jar:1.2.3:compile
[INFO] |  |  |  +- org.apache.logging.log4j:log4j-to-slf4j:jar:2.11.2:compile
[INFO] |  |  |  |  \- org.apache.logging.log4j:log4j-api:jar:2.11.2:compile
[INFO] |  |  |  \- org.slf4j:jul-to-slf4j:jar:1.7.26:compile
[INFO] |  |  \- org.yaml:snakeyaml:jar:1.23:runtime
[INFO] |  +- org.hibernate.validator:hibernate-validator:jar:6.0.17.Final:compile
[INFO] |  |  +- org.jboss.logging:jboss-logging:jar:3.3.2.Final:compile
[INFO] |  |  \- com.fasterxml:classmate:jar:1.4.0:compile
[INFO] |  \- org.springframework:spring-webmvc:jar:5.1.9.RELEASE:compile
[INFO] |     +- org.springframework:spring-context:jar:5.1.9.RELEASE:compile
[INFO] |     \- org.springframework:spring-expression:jar:5.1.9.RELEASE:compile
[INFO] +- org.springframework.boot:spring-boot-starter-tomcat:jar:2.1.7.RELEASE:provided
[INFO] |  +- javax.annotation:javax.annotation-api:jar:1.3.2:compile
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-core:jar:9.0.22:provided
[INFO] |  +- org.apache.tomcat.embed:tomcat-embed-el:jar:9.0.22:compile
[INFO] |  \- org.apache.tomcat.embed:tomcat-embed-websocket:jar:9.0.22:provided
[INFO] \- org.springframework.boot:spring-boot-starter-test:jar:2.1.7.RELEASE:test
[INFO]    +- org.springframework.boot:spring-boot-test:jar:2.1.7.RELEASE:test
[INFO]    +- org.springframework.boot:spring-boot-test-autoconfigure:jar:2.1.7.RELEASE:test
[INFO]    +- com.jayway.jsonpath:json-path:jar:2.4.0:test
[INFO]    |  +- net.minidev:json-smart:jar:2.3:test
[INFO]    |  |  \- net.minidev:accessors-smart:jar:1.2:test
[INFO]    |  |     \- org.ow2.asm:asm:jar:5.0.4:test
[INFO]    |  \- org.slf4j:slf4j-api:jar:1.7.26:compile
[INFO]    +- junit:junit:jar:4.12:test
[INFO]    +- org.assertj:assertj-core:jar:3.11.1:test
[INFO]    +- org.mockito:mockito-core:jar:2.23.4:test
[INFO]    |  +- net.bytebuddy:byte-buddy:jar:1.9.16:test
[INFO]    |  +- net.bytebuddy:byte-buddy-agent:jar:1.9.16:test
[INFO]    |  \- org.objenesis:objenesis:jar:2.6:test
[INFO]    +- org.hamcrest:hamcrest-core:jar:1.3:test
[INFO]    +- org.hamcrest:hamcrest-library:jar:1.3:test
[INFO]    +- org.skyscreamer:jsonassert:jar:1.5.0:test
[INFO]    |  \- com.vaadin.external.google:android-json:jar:0.0.20131108.vaadin1:test
[INFO]    +- org.springframework:spring-core:jar:5.1.9.RELEASE:compile
[INFO]    |  \- org.springframework:spring-jcl:jar:5.1.9.RELEASE:compile
[INFO]    +- org.springframework:spring-test:jar:5.1.9.RELEASE:test
[INFO]    \- org.xmlunit:xmlunit-core:jar:2.6.3:test
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.367 s
[INFO] Finished at: 2019-08-26T10:29:36-04:00
[INFO] ------------------------------------------------------------------------
```

Started JavaWarApplication in 4.048 seconds (JVM running for 9.653)

## Memory
```bash
jconsole
```

- Heap Memory Usage: 226.5MB
- Threads: 30
- Classes: 9,437
- CPU Usage: 0.2%

Select Memory tab and Perform GC
- Heap Memory Usage: 54.2MB


## Remove parent form pom.xml

## Build
```bash
./mvnw clean install
Total Build Time: 17.589 s
```

Error assembling WAR: webxml attribute is required (or pre-existing WEB-INF/web.xml if executing in update mode) -> [Help 1]:

Add maven-war-plugine to pom.xml
web.xml is not required with servlet 3+
```xml
<plugin>
  <artifactId>maven-war-plugin</artifactId>
  <version>3.2.3</version>
  <configuration>
    <failOnMissingWebXml>false</failOnMissingWebXml>
  </configuration>
</plugin>
```

## Build
```bash
./mvnw clean install
# Total Build Time: 17.589 s
```

## Test
```bash
./mvnw test
# Total Test Time: 2.875 s
```

## Run
```bash
./mvnw spring-boot:run
```
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:2.1.7.RELEASE:run (default-cli) on project java-war: An exception occurred while running. null: InvocationTargetException: Cannot instantiate interface org.springframework.boot.SpringApplicationRunListener : org.springframework.boot.context.event.EventPublishingRunListener: Failed to instantiate [org.springframework.boot.context.event.EventPublishingRunListener]: Constructor threw exception; nested exception is java.lang.NoSuchMethodError: org.springframework.aop.framework.AopProxyUtils.getSingletonTarget(Ljava/lang/Object;)Ljava/lang/Object; -> [Help 1]

Try adding to pom.xml
```xml
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-aop</artifactId>
      <version>${org.springframework.boot.version}</version>
    </dependency>
```

## Run
```bash
./mvnw spring-boot:run
```
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:2.1.7.RELEASE:run (default-cli) on project java-war-jersey: An exception occurred while running. null: InvocationTargetException: Unable to start web server; nested exception is org.springframework.boot.web.server.WebServerException: Unable to start embedded Tomcat: Error creating bean with name 'formContentFilter' defined in class path resource [org/springframework/boot/autoconfigure/web/servlet/WebMvcAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.springframework.boot.web.servlet.filter.OrderedFormContentFilter]: Factory method 'formContentFilter' threw exception; nested exception is java.lang.NoClassDefFoundError: Could not initialize class com.fasterxml.jackson.databind.ObjectMapper -> [Help 1]

Match dependencies with parent
Add to pom.xml
```xml
<dependency>
			<groupId>com.fasterxml</groupId>
			<artifactId>classmate</artifactId>
      <version>1.4.0</version>
		</dependency>
    
    <dependency>
			<groupId>javax.validation</groupId>
			<artifactId>validation-api</artifactId>
      <version>2.0.1.Final</version>
		</dependency>

    <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
      <version>5.1.9.RELEASE</version>
		</dependency>

    <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-expression</artifactId>
      <version>5.1.9.RELEASE</version>
		</dependency>

    <dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aop</artifactId>
      <version>5.1.9.RELEASE</version>
		</dependency>

    <dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-annotations</artifactId>
      <version>2.9.0</version>
		</dependency>

    <dependency>
			<groupId>com.fasterxml.jackson.module</groupId>
			<artifactId>jackson-module-jaxb-annotations</artifactId>
      <version>2.9.9</version>
		</dependency>

    <dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
      <version>1.7.26</version>
		</dependency>

    <dependency>
			<groupId>net.bytebuddy</groupId>
			<artifactId>byte-buddy</artifactId>
      <version>1.9.16</version>
      <scope>test</scope>
		</dependency>

    <dependency>
			<groupId>net.bytebuddy</groupId>
			<artifactId>byte-buddy-agent</artifactId>
      <version>1.9.16</version>
      <scope>test</scope>
		</dependency>
```

## Run
```bash
./mvnw spring-boot:run
# Total Start Time: Application in 5.658 seconds (JVM running for 111.587)
```

## Memory
```bash
jconsole
```

- Heap Memory Usage: 64.6MB
- Threads: 30
- Classes: 9,125
- CPU Usage: 0.2%

Select Memory tab and Perform GC
- Heap Memory Usage: 40.3MB

## JBoss
Deploy WAR to JBoss 7.1
- JBoss EAP 7.1.0.GA (WildFly Core 3.0.10.Final-redhat-1) started in 16558ms - Started 504 of 732 services (353 services are lazy, passive or on-demand)

- Heap Memory Usage: 189.4MB
- Threads: 53
- Classes: 17,796
- CPU Usage: 0.3%

Select Memory tab and Perform GC
- Heap Memory Usage: 48.5MB
