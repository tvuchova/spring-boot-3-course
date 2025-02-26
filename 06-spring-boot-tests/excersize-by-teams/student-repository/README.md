# Student Repository

## Getting Started



### H2 In-memory Database

This project uses H2 in-memory database as we do not need to persist the data. By default, it is volatile and all stored data loss when we restart the application.

### Build the Spring Boot application

Verify the installation of Maven

```
mvn -v
```

Build your Spring Boot application

```
mvn clean install
```

### Run the Spring Boot Application

Now that your application is compiled, let’s run it with the following command

```
mvn spring-boot:run
```

Access the application at http://localhost:8080/students or  http://localhost:8080/

Access the H2 database after you've run the application at http://localhost:8080/h2-console. Make sure to check the `application.properties` file for correct information asked when accessing the in-memory database.

### Stop the application

Terminate your current terminal to stop the application as well as free up the current port.

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#web.servlet.spring-mvc.template-engines)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.7.5/reference/htmlsingle/#using.devtools)

## Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
