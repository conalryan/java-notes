# [Quarkus Getting Started](https://quarkus.io/guides/getting-started-guide)

1. Scaffold with Maven Archetype
```bash
mvn io.quarkus:quarkus-maven-plugin:0.20.0:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=getting-started \
    -DclassName="org.acme.quickstart.GreetingResource" \
    -Dpath="/hello"
```

## Differences with vanilla JAX-RS
With Quarkus, there is no need to create an `Application class`. It’s supported, but not required. 
In addition, only **one instance** of the resource is created and not one per request. 
You can configure this using the different *Scoped annotations (**ApplicationScoped**, **RequestScoped**, etc).

2. Run Application
```bash
./mvnw compile quarkus:dev
```

3. Check it's Running
```bash
curl http://localhost:8080/hello
hello
```

4. Add GreetingService using Inject
```bash
./mvnw compile quarkus:dev
```
Then check that http://localhost:8080/hello/greeting/quarkus returns hello quarkus.

5. [Dev mode](https://quarkus.io/guides/getting-started-guide#development-mode)
quarkus:dev runs Quarkus in development mode. This enables hot deployment with background compilation, which means that when you modify your Java files and/or your resource files and refresh your browser, these changes will automatically take effect. This works too for resource files like the configuration property file. Refreshing the browser triggers a scan of the workspace, and if any changes are detected, the Java files are recompiled and the application is redeployed; your request is then serviced by the redeployed application. If there are any issues with compilation or deployment an error page will let you know.

This will also listen for a debugger on port 5005. If you want to wait for the debugger to attach before running you can pass -Ddebug on the command line. If you don’t want the debugger at all you can use -Ddebug=false.

6. Test
By using the QuarkusTest runner, you instruct JUnit to start the application before the tests.
Check the HTTP response status code and content
These tests use RestAssured, but feel free to use your favorite library.

You can run the test from your IDE directly (be sure you stopped the application first), or from Maven using: 
```bash
./mvnw test
```

By default, tests will run on port `8081` so as not to conflict with the running application. We automatically configure RestAssured to use this port. If you want to use a different client you should use the `@TestHTTPResource` annotation to directly inject the URL of the test into a field on the test class. This field can be of the type String, URL or URI. This annotation can also be given a value for the test path. For example, if I want to test a Servlet mapped to `/myservlet` I would just add the following to my test:
```java
@TestHTTPResource("/myservlet")
URL testUrl;
```
The test port can be controlled via the `quarkus.http.test-port` config property. Quarkus also creates a system property called `test.url` that is set to the base test URL for situations where you cannot use injection.

9. Packaging and run the application
The application is packaged using `./mvnw package`. It produces 2 jar files:

`getting-started-1.0-SNAPSHOT.jar` - containing just the classes and resources of the projects, it’s the regular artifact produced by the Maven build;

`getting-started-1.0-SNAPSHOT-runner.jar` - being an executable jar. Be aware that it’s not an über-jar as the dependencies are copied into the target/lib directory.

You can run the application using: java -jar target/getting-started-1.0-SNAPSHOT-runner.jar

The Class-Path entry of the MANIFEST.MF from the runner jar explicitly lists the jars from the lib directory. So if you want to deploy your application somewhere, you need to copy the runner jar as well as the lib directory.
Before running the application, don’t forget to stop the hot reload mode (hit CTRL+C), or you will have a port conflict.

10. Async
The resource can also use CompletionStage as return type to handle asynchronous actions:
```java
@GET
@Produces(MediaType.TEXT_PLAIN)
public CompletionStage<String> hello() {
    return CompletableFuture.supplyAsync(() -> {
        return "hello\n";
    });
}
```
