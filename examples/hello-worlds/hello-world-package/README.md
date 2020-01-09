Hello World in Package
================================================================================

You can compile from any dir
```bash
$ javac helloworldpackage/com/mydomain/HelloWorld.java
```

However, you cannot run from any dir
```bash
$ java helloworldpackage/com/mydomain/Helloworld
Error: Could not find or load main class helloworldpackage.com.mydomain.HelloWorld
```

Try from same dir as `*.class`
```bash
$ cd helloworldpackage/com/mydomain/HelloWorld

$ java HelloWorld
Error: Could not find or load main class HelloWorld
```

Try matching package name to dir (e.g. `package`)
```bash
$ cd helloworldpackage

$ java com/mydomain/HelloWorld
Hello, World
```

