package org.elsys.springcarautopark.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    GroupedOpenApi userApi() {
        final String[] packagesToScan = {"org.elsys.springcarautopark.controller"};
        return GroupedOpenApi
                .builder()
                .group("User API")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/users/**")
                .addOpenApiCustomizer(userApiCustomizer())
                .build();
    }
    OpenApiCustomizer userApiCustomizer() {
        return openAPI -> openAPI
                .info(new Info()
                        .title("Springboot & OpenAPI")
                        .description("This is a sample Spring Boot RESTful service using OpenAPI")
                        .version("3.0.0")
                        .contact(new Contact()
                                .name("Test Software")
                                .url("https://te-software.com/")
                                .email("test@test.com")));
    }
}
