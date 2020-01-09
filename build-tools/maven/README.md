maven
================================================================================

maven.apache.org
Managed by Apache Software Foundation
Open source
Convention over configuration

What is Maven
--------------------------------------------------------------------------------

- Build tool
- It always produces one artifact (Component, jar, war, zip, etc.)
- Manages dependencies
- Handles versioning and releases
- Meta data
    - Describes what you project does
    - Who the developers are
    - Produces Javadocs as well as other source information

Why use it
--------------------------------------------------------------------------------
 
- Recreate builds
- Transitive dependencies
    - Item pulls all dependencies it needs
    - Or is this curse? Modern tools like Bazel prefer to build from source
- Works with local repo
- IDE integration or standalone
- Preferrred choice for use with Jenkins or Cruise Control, Hudson, Bamboo

Install
--------------------------------------------------------------------------------

1. Download Maven
http://maven.apache.org/download.cgi
    - Example apache-maven-3.1.1-bin.tar.gz

2. Extract it to your desired location
    ```
    tar -xvf apache-maven-3.1.1-bin.tar.gz
    pwd
    /Users/myname/apache-maven-3.1.1
    ```

3. Set Maven in environment variable.
Update `~/.bashrc`, `~/.bash_profile` or like (create this file if doesn’t exist)
    ```
    $ vim ~/.bashprofile
    export M2_HOME=/Users/myname/apache-maven-3.1.1
    export PATH=$PATH:$M2_HOME/bin
    source ~/.bash_profile
    ```

4. Test it
    ```
    $mvn -version
    
    Apache Maven 3.1.1 (0728685237757ffbf44136acec0402957f723d9a; 2013-09-17 23:22:22+0800)
    Maven home: /Users/myname/apache-maven-3.1.1
    Java version: 1.7.0_05, vendor: Oracle Corporation
    Java home: /Library/Java/JavaVirtualMachines/1.7.0.jdk/Contents/Home/jre
    Default locale: en_US, platform encoding: UTF-8
    OS name: "mac os x", version: "10.9", arch: "x86_64", family: "mac"
    ```

CLASSPATH
================================================================================

CLASSPATH is an environment variable which is used by Java Virtual Machine to locate user defined classes. 

Use via command line `java -classpath` or `java -cp`
By default, Java CLASSPATH points to current directory denoted by "." and it will look for any class only in the current directory.


It's also worth noting that when you use the  java -jar command line option to run your Java program as an executable JAR, then the CLASSPATH environment variable will be ignored, and also the -cp and -classpath switches will be ignored. In this case, you can set your Java classpath in the META-INF/MANIFEST.MF file by using the Class-Path attribute. In short Class-path attribute in manifest file overrides classpath specified by -cp, -classpath or CLASSPATH environment variable.

Read more: https://javarevisited.blogspot.com/2011/01/how-classpath-work-in-java.html#ixzz6AD9BkiBu

## Maven Structure

### Folder Structure
- MyProject
    - src
        - main
            - java
        - test
            - java
    - target
        - classes
        - maven-archive
        - surefire
        - test-class
        - HelloWorld-1.0-SNAPSHOT.jar
    - pom.xml

Note: 
- test directory 
    - should be for unit tests only, not for integration tests
- target directory 
    - Where everything gets compiled to
    - Also where tests are run from
    - Contents in the directory get packaged into jar, war, ear, etc

### POM file basics
- Diveded into 4 pars
    1. Project information
        - groupId
        - artifactId
        - version
        - packaging
    2. Dependencies
        - Direct dependencies used in app
    3. Build
        - Plugins
        - Directory Structure
    4. Repositories

#### Dependency
- Direct dependencies used in app
    - Imported by their naming convention
    4. Repositories

#### Dependency
- Direct dependencies used in app
    - Imported by their naming convention
    - We need to know groupId, artifactId, version
    - Transitive dependencies are pulled in automatically
    ```xml
    <dependencies>
        <dependency>
            <groupId>commons-lang</groupId>
            <artifactId>commons-lang</artifactId>
            <version>2.1</version>
        </dependency>
    </dependencies>
    ```

#### Goals
- clean
    - Deletes the target directory and any generated resources
- compile
    - Compiles source code, generates any files, copies resources to our classes directory
- package
    - Runs the compile command first, runs any tests, packages the app based off of its package type
- install
    - Runs package command and then installs it in your local repo
- deploy
    - Runs the install command and then deploys it to a corporate repo

#### Local Repo
Where maven stores everything it downloads
- Windows
    C:\Users\<yourname>\.m2\repository
- Mac
    /Users/<yourname>/.m2/repository

#### Build Section
```xml
<build>
    <finalName>MyNewNameforMyWar</finalWar>
</build>
```
Outputs: MyNewNameForMyWar.war

## Dependencies
- List of things you want in your app
- Transitive dependencies are pulled in automatically
- Need a minimum of three things:
    1. groupId
    2. artifactId
    3. version
- versions
    - All development should be done off of a SNAPSHOT
        - myapp-1.0-SNAPSHOT.jar
    - Changes are always downloaded
    - Saves you from releasing versions for development
    - Never deploy to production with SNAPSHOT
    - Industry standards
        - myapp-1.0-M1.jar (milestone)
        - myapp-1.0-RC1.jar (release candidate)
        - myapp-1.0-RELEASE.jar (release)
        - myapp-1.0-Final.jar (release)
- Types
    - pom
        - referred to as a dependency pom
        - downloads dependency from that pom
        - packaging you declare, and type someone imports are the same
    - jar
    - war
    - maven-plugin
    - ejb
    - ear
    - rar
    - par
- Transitive Dependencies
    - Will grap all dependencies that are needed from the dependency you are importing
- Scopes
    - compile
        - default scope if nothing is specified
        - artifacts available everywhere
    - provided
        - like compile, means that the artifact is going to be provided where its deployed
            - servlet-api.jar
            - xml-apis
        - Available in all phases, but not included in final artifact
    - runtime
        - Not needed for compilation, but needed for execution
        - jdbc driver
    - test
        - Only available for the test compilation and execution phase
        - Not included in final artifact
    - system
        - Similar to provided, you specify a path to the jar on your file system
        - Very brittle and defeats the purpose of maven
        - DO NOT USE!
    - import
        - Advanced topic
        - Deals with dependencyManagement sections

## Command Line
````
mvn compile

mvn test

mvn clean

mvn package
````

## Archetypes
### quickstart
````
mvn archetype:generate
	-DgroupId=com.mycompany.app
	-DartifactId=my-app
	-DarchetypeArtifactId=maven-archetype-quickstart
	-DinteractiveMode=false
````

### Maven WebApp
````
mvn archetype:generate \
	-DgroupId={project-packaging} \
	-DartifactId={project-name} \
	-DarchetypeArtifactId=maven-archetype-webapp \
	-DinteractiveMode=false \
````

### Install 3rd party libraries
mvn install:install-file \
	-Dfile=<path-to-file> \
	-DgroupId=<group-id> \
    -DartifactId=<artifact-id> \
	-Dversion=<version> \
	-Dpackaging=<packaging>

### Install 3rd party library poms
mvn install:install-file \
	-Dfile=<path-to-file> \
	-DpomFile=<path-to-pomfile>

### Install 3rd party library in  META_INF directoy
mvn install:install-file \
	-Dfile=<path-to-file>

### Server and Servlet Container to Deploy
```xml
<plugin>
	<groupId>org.mortbay.jetty</groupId>
	<artifactId>maven-jetty-plugin</artifactId>
	<version>6.1.10</version>
	<configuration>
		<scanIntervalSeconds>10</scanIntervalSeconds>
		<stopKey>foo</stopKey>
		<stopPort>9999</stopPort>
	</configuration>
</plugin>
````

### Server commands
````
mvn jetty:run

mvn jetty:start

mvn jetty:stop
````

### clean
mvn clean install
mvn clean install -DskipTests
mvn clean install -DskipTests -s <absolute-path-to-settings.xml>
mvn clean install -DskipTests -s D:/software/apache-maven-3.2.5/conf/settings.xml

### Check Dependencies
mvn dependency:tree -Dincludes=org.codehaus.jackson

### spring
mvn spring-boot:run

### spring profile
mvn test -Dspring.profiles.active=dev -DargLine="-Xms1024m -Xmx2048m -XX:MaxPermSize=2048M"

## Repositories
- Dependency Repo
- Plugin Repo
- Releases/Snapshots
- Simply a http accessible location that you download files from
- Super pom.xml
    - Default with maven installation
    - http://repo.maven.apache.org/maven2
    - This is the open source repo
- Multiple repositories are allowed
- Corporate Repository
    - Nexus (this is what the default repo is built on)
    - Artifactory
- Dependency Repositories and Plugin Repositories can be separate or same repository
- Projects often do NOT upload SNAPSHOT code to the central repo even though their release project is hosted there
- Plugins are usually in the same repo as dependencies
- Companies should use a corporate repository internally to help lighten the load on the central repo.

```xml
<repositories>
    <repository>
        <id>spring-snapshot</id>
        <name>Spring Maven SNAPSHOT Repository</name>
        <url>http://repo.springsource.org/libs-snapshot</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
        <releases>
            <enabled>false</enabled>
        </releases>
    </repository>
</repositories>
```

### Plugin Repositories
- Identical to dependency repositories, just deals with plugins
- Will only look for Plugins, by desing usually in separate repository
    ```xml
    <plugin
    ```

### Local Repo
<home_direcoty>/.m2
<home_direcotry>/.m2/repository

## Plugins
- Goals
    - Default goals are plugins configured in the maven install (clean, compile, test, package, install, deploy)
    - Super pom.xml has these goals defined in it, which are added to your effective pom.xml
    - Goals are also tied to a phase
- Phases
    - validate
        - Validate project is correct and all necessary information is available
    - compile
        - Compile the source code of the project
    - test
        - Test the compiled source code
    - package
        - Packages the code in its defined package, such as JAR
    - integration-test
        - Deploy and run integration tests
    - verify
        - Run checks against package to verify integrity
     - install
        - Install the package in our local repo
    - deploy
        - Copy final package to remote repository

- Compiler Plugin
    - Package code into jar file
    - Tied to package phase
    - Configuration
        - Includes/Excludes
        - Manifest
- Sources Plugin
    - Used to attach source code to jar
    - Tied to package phase
    - Typically overwritten to later phase
- Javadoc Plugin
    - Used to attach Javadocs to a jar
    - Tied to the package phase
        - Often overwritten to later phase
    - Usually just the defaults, but many customization options for Javadoc format
