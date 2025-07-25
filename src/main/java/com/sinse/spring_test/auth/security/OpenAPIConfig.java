package com.sinse.spring_test.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI();
  }
}
