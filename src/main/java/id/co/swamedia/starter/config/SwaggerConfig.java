package id.co.swamedia.starter.config;

import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

/**
 * Swagger/OpenAPI configuration for API documentation in Spring Boot applications.
 * <p>
 * This class configures {@openAPI link} with Bearer Token security scheme
 * as well as adding basic information about the API.
 * </p>
 *
 * @author [Your Name]
 * @version 1.0.0
 * @since [yyyy-mm-dd]
 */
@Configuration
public class SwaggerConfig {

    /**
     * The version of the application to be displayed in the API documentation.
     */
    @Value("${application.version}")
    private String version;

    /**
     * Main configuration for OpenAPI.
     * <p>
     * Added Bearer Token security scheme with JWT format
     * as well as providing general information about the API.
     * </p>
     *
     * @return an instance of the configured {@openAPI} link.
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Bearer", new SecurityScheme()
                                .type(Type.HTTP)
                                .scheme("Bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("Spring Boot API")
                        .description("Spring Boot API")
                        .version(version));
    }

    /**
     * Add Accept-Language header to all API operations globally.
     *
     * @return OperationCustomizer that adds the Accept-Language header.
     */
    @Bean
    public OperationCustomizer customizeHeaders() {
        return (operation, handlerMethod) -> {
            operation.addParametersItem(new HeaderParameter()
                    .name("Accept-Language")
                    .description("Header untuk menentukan bahasa yang digunakan")
                    .required(false));
            return operation;
        };
    }

}
