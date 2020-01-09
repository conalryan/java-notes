# [JBoss EAP 6](https://www.youtube.com/watch?v=KUXdQd_14fU&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc)

## Java EE (Enterprise Edition)
- Java EE application runs within application server, which in turn runs on the JVM.
- Access by many clients.
- Java EE application is not directly executable. It requires the Java EE server to run the application.

## Java EE 6
- Full Profile
- Web Profile
- JBoss supports both profiles as well as custom profiles.

## [Standalone Domain](https://www.youtube.com/watch?v=USlTqi6Ozs4&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=2

### Standalone Mode
- Single server instance
- Managed independently
- Can run a group of standalone instances with JBoss Operations Network

### Domain Mode
- New to JBoss 6
- Manage JBoss instances as a group.
- Domain Controller
	- The master of the domain.
	- Coordinates actions of host controllers which in turn are responsible for coordinate the individual server instances.
	- Process that runs on a server instances of its own, or at lease on its own Java virtual machine.
	
#### Host Controller
- Typically resides on individual piece of hardware.
- Process that runs on its own virtual machine.
- May be responsible for managing lifecycle (starting, stopping, etc) of one or more JBoss instances on the same machine.
- Generally speaking there will be 1 Host Controller per machine.
- Host Controller is administration agent acting on the machine as a proxy for the Domain Controller.
	
#### Domain Controller
- In essence same process as host controller but manages host controllers as opposed to server instances.
- Talks to host controller. Domain controller does not talk directly to server instance.
- JBoss operations network does not support Domain Mode.

## [Management Options](https://www.youtube.com/watch?v=GWCwXhvm_6A&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=4)
- Management Console (Web)
- Command Line Interface (CLI) Tool
- XML File Editing (not recommended)
	- Can only modify the xml when the server is **not** running.
	
## [Extensions, Subsystems, Profiles](https://www.youtube.com/watch?v=8uWc1vCjyec&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=5)

```xml
<?xml version='1.0' encoding='UTF-8'?>

<server xmlns="urn:jboss:domain:5.0">
    <extensions></extensions>
    <management></management>
    <profile></profile>
    <interfaces></interfaces>
    <socket-binding-group name="standard-sockets" default-interface="public" port-offset="${jboss.socket.binding.port-offset:10000}"></socket-binding-group>
</server>
```

### Extensions
- Can be configured in `standalone.xml` or `domain.xml` files.
- Registers a plugin that could be used by applications.
e.g. standalone.xml (similar config in domain.xml)
```xml
<extensions>
        <extension module="org.jboss.as.clustering.infinispan"/>
        <extension module="org.jboss.as.connector"/>
        <extension module="org.jboss.as.deployment-scanner"/>
        <extension module="org.jboss.as.ee"/>
        <extension module="org.jboss.as.ejb3"/>
        <extension module="org.jboss.as.jaxrs"/>
        <extension module="org.jboss.as.jdr"/>
        <extension module="org.jboss.as.jmx"/>
        <extension module="org.jboss.as.jpa"/>
        <extension module="org.jboss.as.jsf"/>
        <extension module="org.jboss.as.logging"/>
        <extension module="org.jboss.as.mail"/>
        <extension module="org.jboss.as.naming"/>
        <extension module="org.jboss.as.pojo"/>
        <extension module="org.jboss.as.remoting"/>
        <extension module="org.jboss.as.sar"/>
        <extension module="org.jboss.as.security"/>
        <extension module="org.jboss.as.transactions"/>
        <extension module="org.jboss.as.webservices"/>
        <extension module="org.jboss.as.weld"/>
        <extension module="org.wildfly.extension.batch.jberet"/>
        <extension module="org.wildfly.extension.bean-validation"/>
        <extension module="org.wildfly.extension.core-management"/>
        <extension module="org.wildfly.extension.elytron"/>
        <extension module="org.wildfly.extension.io"/>
        <extension module="org.wildfly.extension.request-controller"/>
        <extension module="org.wildfly.extension.security.manager"/>
        <extension module="org.wildfly.extension.undertow"/>
    </extensions>
```
- In order for it to be used it must be registered in the subsystem as well.
- Loosely correlates to folder structure in file system `${JBOSS_HOME}/modules/` 
	e.g. `<extension module="org.jboss.as.clustering.infinispan"/>` correlates to `${JBOSS_HOME}/modules/system/layers/base/org/jboss/as/clustering/infispan`
- Library/plugin itself will be distributed as a jar.
- JBoss architecture is lightweight core and a plugin architecture to provide additional functionality.
- Registration of an extension simply enables the possibility for this library to be used on this server when it's started up.
- To use the registered extension or plugin you must register the subsystem within a profile.
	- Note in standalone.xml there will only be one profile however, in domain.xml there will be multiple profiles known as "named" profiles.

### Subsystem
- Enables the functionality of the plugin module and configures the functionality.

## [Standalone Mode](https://www.youtube.com/watch?v=rlus52S03ZM&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=6)
- Single EAP server instance running within the context of its own JVM, typically on its own box, although there may be multiple standalone instances running on the same box.
- Often used by developers or small application deployments, where you want fine grained control over your server instance.
- Single configuration file `standalone.xml`.
- `standalone.xml` contains a single unamed profile. However, JBoss ships with 4 standalone configuration files `standalone-full-ha.xml, standalone-full.xml, standalone-ha.xml, standalone.xml`.
- No functional difference between server running in standalone mode versus running in domain mode. Both offer same services, the difference is in terms of management.

## [Standalone Directories](https://www.youtube.com/watch?v=7sVFqh63iYc&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=7)

### JBoss EAP 6 Directory
- appclient
	- Libraries for fat client apps that need to connect with another Java application on another system.
- bin
	- Contains scripts to start/stop the server
	- Vault script for secure storage of passwords.
	- `standalone.conf` 
		- JVM options 
			- heap settings
			- ms and mx settings for heap and max perm size.
			- Changes are relatively persistent.
		- Can specify a relative directory in the file system to look for standalone directory. Use to perserve configuraiton settings for a given version of an app.
- bundles
- docs
	- schema
		- Useful documentation what settings might be available in the subsytems.
	- examples
		- Various configuration files that can be used.
- domain
- modules
- standalone
	- configuration
		- `standalone.xml`
		- Properties files
		- Logging properties
		- Security properties
	- deployments
		- Can be used to auto deploy if hot deployments is turned on.
	- lib
		- Potentially will contain libraries your application needs.
			- However, generally you should package as a module and use the modules directory instead.
			- Not recommended to be used, it's there for legacy purposes.
	- log
		- boot log and server log
- welcome-content
	- ROOT web application by default unless defined by user.
	- Defaults to port 8080.

### Change conf location
- Modify `standalone.conf` to point to standalone folder.
```bash
JAVA_OPTS="$JAVA_OPTS -Djboss.server.base.dir
```

## [Custom Location](https://www.youtube.com/watch?v=2s-hoXVITCI&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=8)
- Copy $JBOSS_HOME/standalone/configuration $JBOSS_HOME/standalone/deployments $JBOSS_HOME/standalone/lib to another location (e.g. /full/path/dir).
- Modify $JBOSS_HOME/standalone/configuration/`standalone.xml` to port-offset:10000
```xml
<socket-binding-group name="standard-sockets" default-interface="public" port-offset="${jboss.socket.binding.port-offset:10000}">
```
- Start server
```bash
$JBOSS_HOME/bin/standalone.sh -Djboss.server.base.dir=/full/path/dir
```
- Alternatively, you could place `-Djboss.server.base.dir=/full/path/dir` in `standalone.conf`

## [Standalone xml part 1](https://www.youtube.com/watch?v=r_o1R_YdpoU&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=9)
- `<extensions>`
	- Plugins to core functionality of server instance.
- `<management>`
	- 2 interfaces: http interface and native interface
	- native: Command line interface, binary format.
	- http: Used by web console.
	- Protected by security-realm
	```xml
	<security-realm name="ManagementRealm">
                <authentication>
                    <local default-user="$local" skip-group-loading="true"/>
                    <properties path="mgmt-users.properties" relative-to="jboss.server.config.dir"/>
                </authentication>
                <authorization map-groups-to-roles="false">
                    <properties path="mgmt-groups.properties" relative-to="jboss.server.config.dir"/>
                </authorization>
            </security-realm>
            ```
		- local properties path `<properties path="mgmt-users.properties"` refers to $JBOSS_HOME/standalone/configuration/mgm-users.properties
		- User password will be hashed value (e.g. admin=adbeijk343554
		- Add users via `$JBOSS_HOME/bin/add-user.sh`
		- In production you should be using somehting more secure like LDAP.
- `<profile>`
	- logging subsystem
		- Add log categories for Java classes you want to enable logging for (e.g. org.jboss.as.clustering)
		```xml
		<logger category="org.jboss.as.clustering">
                <level name="ERROR"/>
            </logger>
        ``
	- `<subsystem xmlns="urn:jboss:domain:datasources:5.0">` can be removed in production it's intended for development/testing and not for production.
	
## [Standalone xml part 2]()	
- `<interfaces>`
	- Define one or more network interfaces.
	- Give it a name and initial value for boot.
	- You can create additional interfaces to segment your traffic across different channels.
	- You can also pass in value with -D flag as a JVM argument. Colon value is the default value.
	```xml
	<interface name="management">
            <inet-address value="${jboss.bind.address.management:127.0.0.1}"/>
        </interface>
        ```
	- `<socket-binding-group>`

## Management Console Demo()
- JBoss EAP management console Not included in OpenShift
- The JBoss EAP management console is not included in this release of JBoss EAP for OpenShift.
- https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.2/html-single/getting_started_with_jboss_eap_for_openshift_container_platform/index

## Domain Overview
- Managed domain Not supported in OpenShift
- Although a JBoss EAP managed domain is not supported, creation and distribution of applications are managed in the containers on OpenShift
- https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.2/html-single/getting_started_with_jboss_eap_for_openshift_container_platform/index

## [Workshop CLI](https://www.youtube.com/watch?v=Wp5lJ79ghkQ&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=18)
- JBoss EAP management CLI Not recommended in OpenShift
- The JBoss EAP management CLI is not recommended for use with JBoss EAP running in a containerized environment. Any configuration changes made using the management CLI in a running container will be lost when the container restarts. The management CLI is accessible from within a pod for troubleshooting purposes.
- https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.2/html-single/getting_started_with_jboss_eap_for_openshift_container_platform/index
- $JBOSS_HOME/bin/jboss-cli.sh


## [Datasource Overview](https://www.youtube.com/watch?v=_c4ISLZtSok&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=19)
- Connection between application server and database.
- Connects your JPA enabled application to the datasource.
- Need 2 components:
	1. Database driver.
	2. Datasource definition. In past ds.xml file be used but not recommended in production.
- To make JDBC type 4 driver available to your server you may deploy a jar to the group or you may load jar as a module.

## [Defining Datasources](https://www.youtube.com/watch?v=BSa6yO34iTg&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=20)
- After driver has been set up you now need to define a datasource to connect to the driver.
- Define datasource in profile in standalone.xml
- You can define multiple datasources in the datasource subsystem.
- Standard and XA datasources are configuratble. An XA datasource will use distributed transactions.
- Each datasource should have a unique JNDI name. Each name should start with java: or java:jboss
- You can create a sql statement to be executed whenever a new connection is made via:
```xml
<new-connection-sql>SQL statemetn </new-connection-sql>
```
- `<statement>` can be used to build prepared statement caches to be used to improve the performance.
- `trackstatements` tag can be used to close database connections and result sets that have not been closed by the application. 

## [Datasource Example](https://www.youtube.com/watch?v=1cDQyOV2Qr8&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=21)
standalone.xml
```xml
<datasources>
  <datasource jndi-name="java:jboss/MySqlDS" pool-name="MySqlDS">
    <connection-url>jdbc:mysql://localhost:3306/jbossdb</connection-url>
    <driver>com.mysql</driver>
    <!-- Refer to vault section to secure user-name and password -->
    <security>
      <user-name>admin</user-name>
      <password>admin</password>
    </security> 
    <validation>
      <valid-connection-checker class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLValidConnectionChecker"></valid-connection-checker>
      <exception-sorter class-name="org.jboss.jca.adapters.jdbc.extensions.mysql.MySQLExceptionSorter"></exception-sorter>
    </validation>
  </datasource>
  <drivers>
    <driver name="mysql" module="com.mysql">
      <xa-datasource-class>com.mysql.jdbc.jdbc2.optional.MysqlXADataSource</xa-datasource-class>
    </driver>
  </drivers>
</datasources>
```
- To setup connection:
  - Setup JNDI name
  - Define connection URL
  - Define your drivers
  - Set pool size and security

## [XA Datasource Example](https://www.youtube.com/watch?v=qY_dT1skjeo&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=22)
- Still need JDNI name and driver

## [Logging Overview](https://www.youtube.com/watch?v=SBnJoQ2CY6w&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=23)
- $JBOSS_HOME/standalone/log
- $JBOSS_HOME/domain/log

## [Built-in Handlers](https://www.youtube.com/watch?v=KTsj8lIDCBk&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=24)
- Console Handlers
standalone.xml
```xml
<profile>
  </subsystem xmlns="urn:jboss:domain:logginf:1.1">
    <console-handler name="CONSOLE">
      <level name="INFO"/>
      <formatter>
        <named-formatter name="COLOR-PATTERN"/>
      </formatter>
    </console-handler>
    <!-- ... -->
</profile>
```

## [Periodic File Handler](https://www.youtube.com/watch?v=Bp74-ECLbes&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=25)
standalone.xml
```xml
<periodic-rotating-file-handler name="FILE" autoflush="true">
  <formatter>
    <named-formatter name="PATTERN"/>
  </formatter>
  <file relative-to="jboss.server.log.dir" path="server.log"/>
  <!-- 
  Suffix to rotate file
  .yyyy-MM rotate every month
  .yyyy-MM-dd rotate every day
  .yyyy-MM-dd.hh rotate every hour
  -->
  <suffix value=".yyyy-MM-dd"/>
  <append value="true"/>
</periodic-rotating-file-handler>
```

## [Size File Handler](https://www.youtube.com/watch?v=ES0KqhOJOmo&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=26)
- Rotate a log file based on the size of the file as opposed to be date with `<periodic-rotating-file-handler>`
  
## [Async Logging](https://www.youtube.com/watch?v=uGrmJgBxJ1k&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=27)
- Performance advantage. Normal file handlers will be blocking while they write to the log file.
- Gives you a buffer so you don't have to wait for the system to write to the file, you simply write to the buffer.

## [Defining Loggers](https://www.youtube.com/watch?v=rByiHQ13_aQ&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=28)
- Custom logger for a given package.
standalone.xml
```xml
<logger category="com.arjuna">
  <level name="WARN"/>
</logger>
```

## [Root Logger](https://www.youtube.com/watch?v=rex4nxVx9-g&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=29)
- Default INFO and higher level log to CONSOLE and FILE handler.
standalone.xml
```xml
<root-logger>
  <level name="INFO"/>
  <handlers>
    <handler name="CONSOLE"/>
    <handler name="FILE"/>
  </handlers>
</root-logger>
```

## [JMS Overview](https://www.youtube.com/watch?v=aFnOnjeyGhY&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=30)
- Java Messaging System
- HornetQ is JBoss eap-6 implementation of JMS.
- JMS is an API to talk to messaging system.
- Application sends message to another system.
- 2 types of messaging models:
  1. Queues
    - Point to Point
    - Messages consumed by recipent application
  2. Topics
    - Publish and subscribe model.
    - Application publishes messages and various applications listen to message.

## [HornetQ Intro](https://www.youtube.com/watch?v=JWySOwCJ37E&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=31)
- New implementation of JMS in EAP 6.
- 2 types of connectors and acceptors
  - in-vm connectors
    - Intra virtual machine.
  - netty connectors
    - Remote connector for an external client. Not running internally to JBoss application server.

## [Conection Factories](https://www.youtube.com/watch?v=BdLR0q-_h0I&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=32)
- 2 requirements:
  - Connection factory
    - Wraps connectors wihin eap-6 (in-vm and netty connectors) and expose them to JNDI and Java EE applications.
  - Message destination

## [Define Destinations](https://www.youtube.com/watch?v=mREFUIuPAws&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=33)
- 2 types (queues and topics).

## [Pooled Connection Factories](https://www.youtube.com/watch?v=1PS2qhOTHJI&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=34)
- Typical of application using transactional pool.
- Wait for transaction to get commited.

## [HornetQ Journals](https://www.youtube.com/watch?v=zKVZlfsb310&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=35)
- New option in EAP-6 to persist messages.
- File based model.
- Java NIO:
    - Java new I/O input/output stream Java-EE 7.
- Linux AIO:
  - Far better performance.
  - Async I/O.

## [Other Settings](https://www.youtube.com/watch?v=iHgwhNH9mlQ&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=36)
- Apply to any queue matching pattern criteria.

## [Security](https://www.youtube.com/watch?v=xlE4ZFMV7bw&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=37)
- Configuring Security Subsystem:
  - Uses open source Picket Box implementation.
- Security Domains:
  - LDAP
  - Database uses flat files.
- JAS Java Authentication System part of Java EE spec.

## [Secuirty Domains](https://www.youtube.com/watch?v=g35FYzc1PXQ&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=38)
- JAS based authentication module.

## [LDAP Realm](https://www.youtube.com/watch?v=V4VwEmuYIzg&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=39)

## [JVM Config](https://www.youtube.com/watch?v=AbcJ4TaX824&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=40)
- Overview of the JVM Memory Settings
  -Xmx (maximum heap setting. -Xms is minimum heap setting)
    - NewSize, MaxNewSize
    - Eden
      - New Java objects are place in Eden space.
    - SurviorRatio
      - Java objects that survive minor garbage collection
      - Survior1
      - Survior2
    - Tenured (NewRatio)
      - When tenured space is completely filled up that will cause a full garbage collection which will pause your JVM execution.
    - PermGen (MaxPermSize)
- Performance tunning involves changing NewSize and NewRatio and PermGen. You can also specify a ratio 2 to 1 NewRatio to NewSize etc.
- You can tune settings in `$JBOSS_HOME/bin/standalone.conf`

## [JVM Domain](https://www.youtube.com/watch?v=LWkgV7CoJRA&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=41)
- Skipped

## [Migrating Apps](https://www.youtube.com/watch?v=9E1xRKVIZDg&list=PL09NkvEHuNCdEEkCwUSlTA9UKlR4jo8rc&index=42)

## [Classpath Modules]()

## [JPA Issues]()

## [Update Security]()

## [Update JNDI]()

## [Sample Migration]()