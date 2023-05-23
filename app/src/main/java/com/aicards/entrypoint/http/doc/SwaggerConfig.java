package com.aicards.entrypoint.http.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI()
                .info(
                        new Info().title("AI-Cards")
                                .description("API para criação de cartas aleatórias")
                                .version("v1.0")
                                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                )
                .externalDocs(
                        new ExternalDocumentation()
                                .description("AI-Cards docs")
                                .url("https://github.com/davidrezende/ai-cards")
                );
    }
}
