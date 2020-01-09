# _servlet_notes

## Generate Webapp
```bash
mvn archetype:generate \
	-DgroupId={project-packaging} \
	-DartifactId={project-name} \
	-DarchetypeArtifactId=maven-archetype-webapp \
	-DinteractiveMode=false
```

## Deployment Descriptor
### Servlet 3.1
Java EE 7 XML Schema namespace:  http://xmlns.jcp.org/xml/ns/javaee/
```xml
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
		 http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">
</web-app>
``` 
### Servlet 3.0
Java EE 6 XML schema, namespace is http://java.sun.com/xml/ns/javaee
```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
	      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	      xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	      http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
	      version="3.0">
</web-app>
``` 

## Build War
```bash
mvn package
```

## Deploy
### JBoss 6.4
```bash
cp target/servlet-notes.war $JBOSS_HOME/standalone/deployments/ROOT.war
touch $JBOSS_HOME/standalone/deployments/ROOT.war.dodeploy
$JBOSS_HOME/bin/standalone.sh
```
Verify it's running

http://localhost:8080/Demo1