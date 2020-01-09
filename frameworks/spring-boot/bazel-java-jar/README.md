# Bazel Spring Boot

## Build app
```bash
bazel build //src/main:app
# or 
bazel build //src/...
```

## Test
```bash
bazel test //src/...
```

## Run
```bash
bazel run //src/main:webapp
# or build deployable jar
bazel build //src/main:webapp_deploy.jar
# ERROR org.springframework.boot.SpringApplication - Application startup failed
# org.springframework.beans.factory.BeanDefinitionStoreException: Failed to process import candidates for configuration class [com.ex.bazel.springboot.Application]; nested exception is java.lang.IllegalArgumentException: No # auto configuration classes found in META-INF/spring.factories. If you are using a custom packaging, make sure that file is correct. 
```

## Graph
```bash
bazel query --noimplicit_deps 'deps(//src/...)' --output graph > graph.in
dot -Tsvg < graph.in > graph.svg
```

## Build dependencies
**IMPORTANT**: Run this any time you make a change to dependencies.yaml
TODO: Make this generic, Docker? remote execution?
```bash
# @see https://github.com/johnynek/bazel-deps
cd $BAZEL_DEPS
bazel run //:parse generate -- --repo-root "$MY_PROJ_DIR" --sha-file 3rdparty/workspace.bzl --deps dependencies.yaml
```

## Stats
TODO retest this on fresh startup
- Build Time: 0.209s (no change)
- Test Time: 4.6s (cached)
- Startup: Started Application in 4.23 seconds (JVM running for 4.752)
- Heap Memory Usage: 36MB
- Live Threads: 30
- Classes Loaded: 5,566
- CPU Usage: 0.1%

Perform GC
- Heap Memory Usage: 23.2MB
