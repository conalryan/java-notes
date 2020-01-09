Hello World in Packages
================================================================================

Multiple packages, need to use `-cp` class path flag to specify required classes/jars/zips.

[Class Path](https://docs.oracle.com/javase/tutorial/essential/environment/paths.html)
--------------------------------------------------------------------------------
The CLASSPATH variable is one way to tell applications, including the JDK tools, where to look for user classes. 
(Classes that are part of the JRE, JDK platform, and extensions should be defined through other means, such as the bootstrap class path or the extensions directory.)

The preferred way to specify the class path is by using the `-cp` command line switch. This allows the CLASSPATH to be set individually for each application without affecting other applications.
Setting the CLASSPATH can be tricky and should be performed with care.

The default value of the class path is ".", meaning that only the current directory is searched.
Specifying either the CLASSPATH variable or the `-cp` command line switch overrides this value.

Check if CLASSPATH is set:
```bash
echo $CLASSPATH
```

### Modify the CLASSPATH

Class path wildcards allow you to include an entire directory of .jar files in the class path without explicitly naming them individually.

The class search path (class path) can be set using either the `-classpath` option when calling a JDK tool (the preferred method) or by setting the CLASSPATH environment variable. The -classpath option is preferred because you can set it individually for each application without affecting other applications and without other applications modifying its value.

`sdkTool -classpath classpath1:classpath2...`

`set CLASSPATH=classpath1;classpath2...`

#### sdkTool
A command-line tool, such as java, javac, javadoc, or apt.

#### classpath1:classpath2
Class paths to the JAR, zip or class files. Each class path should end with a file name or directory depending on what you are setting the class path to, as follows:
- For a JAR or zip file that contains class files, the class path ends with the name of the zip or JAR file.
- For class files in an unnamed package, the class path ends with the directory that contains the class files.
- For class files in a named package, the class path ends with the directory that contains the root package, which is the first package in the full package name.

Multiple path entries are separated by semicolons with no spaces around the equals sign (=) in Windows and colons in Oracle Solaris.

The default class path is the current directory. Setting the `CLASSPATH` variable or using the `-classpath` command-line option overrides that default, so if you want to include the current directory in the search path, then you must include a dot (.) in the new settings.

Class path entries that are neither directories nor archives (.zip or JAR files) nor the asterisk (*) wildcard character are ignored.

Try using `-cp` flag:
```bash
javac -sourcepath ~/dev/code/p/java/helloworldpackages/package2 ~/dev/code/p/java/helloworldpackages/package1/com/mydomain/HelloWorld.java

# now from Main class package
# ./helloworldpackages/package1

java -cp .:~/dev/code/p/java/helloworldpackages/package2`:com/mydomain/HelloWorld
```

It's also worth noting that when you use the  `java -jar` command line option to run your Java program as an executable JAR,
then the `CLASSPATH` environment variable will be ignored, and also the `-cp` and `-classpath` switches will be ignored.
In this case, you can set your Java classpath in the `META-INF/MANIFEST.MF` file by using the `Class-Path` attribute.
In short `Class-path` attribute in manifest file overrides classpath specified by `-cp`, `-classpath` or `CLASSPATH` environment variable.

