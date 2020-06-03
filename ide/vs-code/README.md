https://code.visualstudio.com/docs/java/java-tutorial

[Multiple source folders](https://code.visualstudio.com/docs/java/java-project#_multiple-source-folders)
If you have multiple subfolders that have source code for your project, you can easily add these folders to source path, then all the code inside will be correctly compiled.

`Right click on folder > Add Folder to Java Source Path`

[Working with JAR Files](https://code.visualstudio.com/docs/java/java-project#_working-with-jar-files)
You can use the Java Dependency Viewer to add any JAR file to your project. Go to the JAVA DEPENDENCIE view, find the Referenced Libraries node, and click the + button to add a JAR file:


"/private/var/tmp/_bazel_cryan/07124f5a9a7f4be0b57dec99001d067e/execroot/rates_inventory_management/bazel-out/darwin-fastbuild/bin/external/**/*.jar",

"/private/var/tmp/_bazel_cryan/07124f5a9a7f4be0b57dec99001d067e/execroot/rates_inventory_management/bazel-out/darwin-fastbuild/bin/**/*.jar"

doesn't work: "/private/var/tmp/_bazel_cryan/07124f5a9a7f4be0b57dec99001d067e/execroot/rates_inventory_management/bazel-out/darwin-fastbuild/bin/3rdparty/jvm/org/apache/commons/**/*.jar",

Works: "/private/var/tmp/_bazel_cryan/07124f5a9a7f4be0b57dec99001d067e/execroot/rates_inventory_management/bazel-out/darwin-fastbuild/bin/external/**/*.jar"