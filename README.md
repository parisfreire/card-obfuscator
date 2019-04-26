## Card Obfuscator App using [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html) and [Spring Boot](https://spring.io/projects/spring-boot).

### Running with [Maven](https://github.com/dart-lang/site-webdev/blob/master/src/tools/webdev.md)

If you don't have Maven installed, you can use maven wrapper in this project.
To be able to run your Spring Boot app you will need to first build it. You will need to run it from the project folder which contains the pom.xml file.

Unix system:

```
./mvnw clean install
```

Windows:

```
./mvnw.cmd clean install
```

Once the previous command is finished, let’s run the Spring-Boot project:

```
./mvnw spring-boot:run
```

### Running with java -jar command

To run your Spring Boot app from a command line in a Terminal window you can you the java -jar command. This is provided your Spring Boot app was packaged as an executable jar file.

```
java -jar target/card-obfuscator-0.1.0.jar
```

### Manual deployment

You can run by hand the app deploying it on a Tomcat copying the files under the following directory:

**target/card-obfuscator-0.1.0.jar**


