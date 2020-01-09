# [Gradle Basic](https://guides.gradle.org/creating-new-gradle-builds/)

# Setup
````bash
gradle init
# Select Basic in prompt
# Select Groovy in prompt
````

# build.gradle
````groovy
/*
 * plugins
 * Be sure to add the plugins {} block at the top of the file.
 * only buildscript {} and other plugins {} script blocks are allowed before plugins {} blocks, no other statements are allowed
 */
plugins {
    // base allows zip
    id "base"
}

// description and version CANNOT be above plugins, else build error:
// only buildscript {} and other plugins {} script blocks are allowed before plugins {} blocks, no other statements are allowed
description = "A trivial Gradle build"
version = "1.0"

/*
 * TASKS
 * run ./gradlew tasks
 */

/*
 * Define a task called copy of type Copy (note the capital letter) in your build file that copies
 * the src directory to a new directory called dest.
 * (You don’t have to create the dest directory — the task will do it for you.)
 *
 * Run with ./gradlew copy
 */
task copy(type: Copy, group: "Custom", description: "Copies sources to the dest directory") {
    from "src"
    into "dest"
}

/*
 * The base plugin works with the settings to create an archive file called basic-demo-1.0.zip in the
 * build/distributions folder.
 *
 * Run with ./gradlew zip
 */
task zip(type: Zip, group: "Archive", description: "Archives sources in a zip file") {
    from "src"
    setArchiveName "basic-demo-1.0.zip"
}
````

# Helpful
````bash
./gradlew tasks
````

````bash
./gradlew properties
````