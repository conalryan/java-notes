# [Quarkus with Spring DI](https://quarkus.io/guides/spring-di-guide)

1. Generate project from maven archetype
```bash
mvn io.quarkus:quarkus-maven-plugin:0.20.0:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=using-spring-di \
    -DclassName="org.acme.spring.di.GreeterResource" \
    -Dpath="/greeting" \
    -Dextensions="spring-di"
```

2. Add Spring context to pom.xml
```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <!-- Any version higher than 3.2.0-RELEASE -->
    <version>${spring.version}</version>
</dependency>
```