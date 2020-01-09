# [Wildfly Swarm in 15 minutes](https://www.youtube.com/watch?v=5BvJVAlZyvo)

## Old Java EE pattern
Create a new Java EE project
```bash
# Start JBoss Forge
forge

# Create new project
project-new --named java-ee-app --stack JAVA_EE_7
```

Create a rest endpoint
````bash
rest-new-endpoint --named HelloEndpoint --path hello --methods GET
````

Create a war file
````bash
cd java-ee-app
mvn clean install
````

Size
- war file: 3.6K (3,667B)

Start server (empty server with no war)
````bash
$JBOSS_HOME/bin/standalone.sh
````
JBoss EAP 7.1.0.GA (WildFly Core 3.0.10.Final-redhat-1) started in **6919ms** - Started **292 of 553** services (347 services are lazy, passive or on-demand)

Start JConsole
````bash
jconsole
````

Select New Connection
- Heap Memory Usage: 150MB - 160MB
- Threads: 50
- Classes: 10913
- CPU Usage: 0.2%

Select Memory tab and Perform GC
- Heap Memory Usage: 39MB

Deploy war to server
````bash
cp ./target/java-ee-app.war $JBOSS_HOME/standalone/deployments
````

Browse
http://localhost:8080/java-ee-app/rest/hello

Check JConsole
- Heap Memory Usage: 190MB

## New WildFly Swarm Fractions Pattern
Add thorntail addon to JBoss Forge
````bash
addon-install-from-git --url https://github.com/forge/thorntail-addon.git
````

Thorntail Project type
If you are creating a new project, you can choose the thorntail project type directly
````bash
project-new --named wildfly-swarm-app --type thorntail --stack JAVA_EE_7
````

Setup command
If you’re working in an existing project (or you forgot to choose thorntail in the command above) just type wildfly-swarm-setup if you’re in shell. It should read Thorntail: Setup if you’re in a GUI environment:
````bash
thorntail-setup
````

And that’s it! The thorntail-maven-plugin will be installed.

Convert java-ee-app to WildFly Swarm
````forge
thorntail-setup --context-path java-ee-app
````

Detect Fractions
````bash
thorntail-detect-fractions
````

Add a Fraction

Note: Press tab after --fractions to get a list fractions you can add.
````bash
thorntail-add-fraction --fractions jaxrs
````


Build
````bash
mvn clean install
````

Thorntail has created an uber-jar

Size
- war file: 4.3K (4,402B)
- jar file: 52MB (54,350,616B)

Run
````bash
java -jar ./target/wildfly-swarm-app-thorntail.jar
````

Browse
http://localhost:8080/rest/hello

Thorntail 2.5.0.Final (WildFly Core 7.0.0.Final) started in **1944ms** - Started **99 of 105** services (18 services are lazy, passive or on-demand)

Select New Connection
- Heap Memory Usage: 146MB
- Threads: 35 Live of 60
- Classes: 11,631
- CPU Usage: 0.1%

Select Memory tab and Perform GC
- Heap Memory Usage: 48MB