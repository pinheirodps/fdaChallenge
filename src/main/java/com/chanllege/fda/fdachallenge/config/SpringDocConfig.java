package com.chanllege.fda.fdachallenge.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Spring doc config.
 */
@Configuration
public class SpringDocConfig {

    /**
     * Open API documentation.
     *
     * @return the {@link OpenAPI} information
     */
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .info(new Info().title("Open FDA Service API").version("1.0"));
    }
}
