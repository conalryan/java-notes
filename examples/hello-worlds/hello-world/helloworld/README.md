Hello World
================================================================================

### Compile
`javac <path-to-java-file>`

e.g. using relative path 
```bash
$ javac ~/my-repo/helloworld/HelloWorld.java 
```

### Run
`java [-options] class [args...]`

Note need to run the class with the main method
`java <main-class>`


### Default CLASSPATH "."

e.g. HelloWorld with main method and no package name
Run from the same dir as the `HelloWorld.class`
```bash
$ java HelloWorld

Hello, World
```

Fails when running from another dir
```bash
$ java helloworld/HelloWorld

Error: Could not find or load main class helloworld.HelloWorld
```

### Classpath Flag
Class path `-cp` is used to tell JVM where to find JARS, Zips and .class files
```bash
# Now you can run the .class file from any dir, using relative path or absolute path
java -cp ~/my-repo/helloworld HelloWorld
```

### Sourcepath Flag
Source path `-sourcepath` is used to tell `javac` where to find .java files.
Appears a bit dubious as it doesn't specify the "main" class, only classes that the "main" class is dependent on
```bash
javac -sourcepath . HelloWorld.java
```

[Jar](https://docs.oracle.com/javase/tutorial/deployment/jar/build.html)
--------------------------------------------------------------------------------

### Package
`jar cf jar-file input-file(s)`

This command will generate a compressed JAR file and place it in the current directory.
The command will also generate a **default manifest** file for the JAR archive.
The options and arguments used in this command are:
- The `c` option indicates that you want to create a JAR file.
- The `f` option indicates that you want the output to go to a file rather than to stdout.
- `jar-file` is the name that you want the resulting JAR file to have. You can use any filename for a JAR file. By convention, JAR filenames are given a .jar extension, though this is not required.
- The `input-file(s)` argument is a space-separated list of one or more files that you want to include in your JAR file. The input-file(s) argument can contain the wildcard * symbol. If any of the "input-files" are directories, the contents of those directories are added to the JAR archive recursively.

```bash
$ jar cf my-helloworld.jar HelloWorld.class
```

### Run
`java [-options] class [args...]`

```bash
$ java -jar my-helloworld.jar
no main manifest attribute, in my-helloworld.jar
```

Options:
`v` Produces verbose output on stdout while the JAR file is being built. The verbose output tells you the name of each file as it's added to the JAR file.
`0` (zero) Indicates that you don't want the JAR file to be compressed.
`M` Indicates that the default manifest file should not be produced.
`m` Used to include manifest information from an existing manifest file. The format for using this option is:
Warning: The manifest must end with a new line or carriage return. The last line will not be parsed properly if it does not end with a new line or carriage return.
`-C` To change directories during execution of the command. See below for an example.

### Modify Default Manifest
`jar cfm jar-file manifest-addition input-file(s)`

Let's look at the options and arguments used in this command:
- The `c` option indicates that you want to create a JAR file.
- The `m` option indicates that you want to merge information from an existing file into the manifest file of the JAR file you're creating.
- The `f` option indicates that you want the output to go to a file (the JAR file you're creating) rather than to standard output.
- `manifest-addition` is the name (or path and name) of the existing text file whose contents you want to add to the contents of JAR file's manifest.
- `jar-file` is the name that you want the resulting JAR file to have.
- The `input-file(s)` argument is a space-separated list of one or more files that you want to be placed in your JAR file.

1. Create Manifest.txt
```txt
Main-Class: HelloWorld
```

2. Create jar with manifest
```bash
$ jar cfm my-helloworld.jar Manifest.txt ./*.class
```

3. Run jar
```bash
$ java -jar my-helloworld.jar

Hello, World
```

### Extract
```bash
$ jar xf my-helloworld.jar
```

[Default Manifest](https://docs.oracle.com/javase/tutorial/deployment/jar/defman.html)
--------------------------------------------------------------------------------
When you create a JAR file, it automatically receives a default manifest file. There can be only one manifest file in an archive, and it always has the pathname

`META-INF/MANIFEST.MF`

When you create a JAR file, the default manifest file simply contains the following:
`
Manifest-Version: 1.0
Created-By: 1.8.0_232 (AdoptOpenJDK)
`

