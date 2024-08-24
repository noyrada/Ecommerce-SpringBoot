package com.project.samplecrud_sb.config;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    //Bean for back-end swagger api:
    @Bean
    public GroupedOpenApi backendApiGroup(){
        return GroupedOpenApi.builder().group("backend-api").addOpenApiCustomizer(openApi -> openApi
                .info(getBackendApiInfo())).packagesToScan("com.project.samplecrud_sb.controller.backend").build();
    }

    //Bean for font-end swagger api:
    @Bean
    public GroupedOpenApi frontendApiGroup(){
        return GroupedOpenApi.builder().group("frontend-api").addOpenApiCustomizer(openApi -> openApi
                .info(getFrontendApiInfo())).packagesToScan("com.project.samplecrud_sb.controller").build();
    }

    //Information Contact for backend:
    private Info getBackendApiInfo(){
        Contact contact = new Contact();
        contact.setName("noy-rada");
        contact.setEmail("noy-rada@gmail.com");
        contact.setUrl("https://github.com/noyrada");

        return new Info().title("Ecommerce API").description("Backend Ecommerce API").contact(contact).version("1.0.1");
    }

    //Information Contact for backend:
    private Info getFrontendApiInfo(){
        Contact contact = new Contact();
        contact.setName("noy-rada");
        contact.setEmail("noy-rada@gmail.com");
        contact.setUrl("https://github.com/noyrada");

        return new Info().title("Ecommerce API").description("Frontend Ecommerce API").contact(contact).version("1.0.1");
    }






}
