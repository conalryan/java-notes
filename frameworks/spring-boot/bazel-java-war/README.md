# Bazel Spring Boot

## Build app
```bash
bazel build //src/main:tomcat-app
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
# local dev
bazel run //src/main:tomcat-webapp

# Build war for JBoss
bazel build //src/main:java-war
cp bazel-bin/src/main/java-war.war $JBOSS_HOME/standalone/deployments/ROOT.war
bash $JBOSS_HOME/bin/standalone.sh
```
Tomcat: 
  localhost:8080 returns Whitelabel error
  localhost:8080/index.html returns Whitelabel error
  localhost:8080/static.html works
  localhost:8080/helloworld works
JBoss: 
  localhost:8080 works
  localhost:8080/index.html works
  localhost:8080/static.html returns Whitelabel error
  localhost:8080/helloworld works

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
