# [Thorntail Logging](https://docs.thorntail.io/2.5.0.Final/#_logging)

Generate
````bash
project-new --named logging --type thorntail
````

SLF4J can be used without adding a dependency to pom.xml
````java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// ...
Logger LOG = LoggerFactory.getLogger(this.getClass());
````

LOG.info will be enabled by default

To add another level use
````bash
mvn thorntail:run -Dthorntail.logging=DEBUG
````

Configure custom loggers
project-defaults.yml
````yaml
thorntail:
  logging:
    pattern-formatters:
      LOG_FORMATTER:
        pattern: "CUSTOM LOG FORMAT %p [%c] %s%e%n"
    periodic-rotating-file-handlers:
      FILE:
        file:
          path: path/to/your/file.log
        suffix: .yyyy-MM-dd
        named-formatter: LOG_FORMATTER
    root-logger:
      handlers:
      - CONSOLE
      - FILE
````

## [Logging Request and Responses](https://stackoverflow.com/questions/33666406/logging-request-and-response-in-one-place-with-jax-rs)

Including 
````xml
<dependency>
    <groupId>io.thorntail</groupId>
    <artifactId>thorntail-runner</artifactId>
    <version>${version.thorntail}</version>
</dependency>
````
causes

Caused by: java.lang.IllegalStateException: 
WFLYLOG0078: The logging subsystem requires the log manager to be org.jboss.logmanager.LogManager. 
The subsystem has not be initialized and cannot be used. 
To use JBoss Log Manager you must add the system property "java.util.logging.manager" and set it to "org.jboss.logmanager.LogManager"
``
 
 when running `mvn thorntail:run`
 
 The error does not occur with `mvn clean install && java -jar target/logging-thorntail.jar`
 