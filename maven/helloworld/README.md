Maven Hello World
================================================================================

1. Create pom.xml
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <project xmlns="http://maven.apache.org/POM/4.0.0"
	     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
				 http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>

        <groupId>com.mydomain</groupId>
        <artifactId>HelloWorld</artifactId>
        <version>1.0-SNAPSHOT</version>
        <packaging>jar</packaging>

	<properties>
	    <!-- Set compiler to correct source and target
	         Defatults to Java 1.5, which is no longer supported
		 https://github.com/jflex-de/jflex/issues/400 -->
            <maven.compiler.source>1.8</maven.compiler.source>
            <maven.compiler.target>1.8</maven.compiler.target>
        </properties>

    </project>
    ```

2. Create [Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html) 
    ```bash
    mkdir -p src/main/java/com/mydomain && \
    mkdir -p src/main/resources && \
    mkdir -p src/main/webapp && \
    mkdir -p src/test/java/com/mydomain && \
    mkdir -p src/test/resources
    ```
- src
    - main
        - java
	    - com
	        - mydomain
	- resources
	- webapp
    - test
        - java
	    - com
	        - mydomain
	- resources

3. Create HelloWorld.java in the java package (com.mydomain)
    ```java
    package com.mydomain;

    public class HelloWorld {
    
        public static void main(String args[]) {
            System.out.println("Hello World");
        }
    }
    ```


### Try to build and run JAR
Build Jar
```bash
mvn clean install
```
- Since maven is built with maven, it will download all the necessary plugins to run the command
- mvn compile will make a target directory
    ```bash
    helloworld/
        pom.xml
	src/
	target/
	    classes/
	       com/
	           mydomain/
		       HelloWorld.class
	    generated-sources/
	    maven-status/
    ```

7. Run command
    ```bash
    java target/classese/com/mydomain/HelloWorld
    Error: Could not find or load main class target.classes.com.mydomain.HelloWorld
Caused by: java.lang.NoClassDefFoundError: com/mydomain/HelloWorld (wrong name: target/classes/com/mydomain/HelloWorld)
    ```


Try to run Jar
```bash
java -jar target/HelloWorld-1.0-SNAPSHOT.jar

no main manifest attribute, in target/HelloWorld-1.0-SNAPSHOT.jar
```
You now have a jar however it is not executable since you need to jar a file called META-INF/MANIFEST.MF
    - The file itself should have (at least) this one liner: Main-Class: com.mydomain.MyClass
    - Where com.mypackage.MyClass is the class holding the public static void main(String[] args) entry point.
    - Note that there are several ways to get this done either with the CLI, Maven or Ant:
    - For CLI, the following command will do
    ```bash
    jar cmvf META-INF/MANIFEST.MF <new-jar-filename>.jar  <files to include>
    ```
  
maven-jar-plugin
--------------------------------------------------------------------------------
Add maven-jar-plugin to pom.xml
```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-jar-plugin</artifactId>
      <version>3.2.0</version>
      <configuration>
	<archive>
	  <manifest>
	    <addClasspath>true</addClasspath>
	    <classpathPrefix>lib/</classpathPrefix>
            <mainClass>com.mydomain.HelloWorld</mainClass>
	  </manifest>
        </archive>
      </configuration>
    </plugin>
  </plugins>
</build>
```

Build and run
```bash
mvn clean install

java -jar target/Hello-World-1.0-SNAPSHOT.jar
```


Extract Contents of Jar
--------------------------------------------------------------------------------
`jar xf jar-file [archived-file(s)]`

```bash
jar xf ./target/Hello-World-1.0-SNAPSHOT.ar
```

META-INF/MANIFEST.MF
`
Manifest-Version: 1.0
Build-Jdk-Spec: 1.8
Created-By: Maven Jar Plugin 3.2.0
Main-Class: com.mydomain.HelloWorld
`

com/mydomain/HelloWorld.class

