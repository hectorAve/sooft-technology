package com.soft.technology.transactions_management.infrastructure.conf;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info=@Info(
                title = "Transactions Management",
                version = "0.0.1",
                description = "Sooft technologies Management"
        )
)
public class SwaggerConfig {}
