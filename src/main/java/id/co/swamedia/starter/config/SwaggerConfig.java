package id.co.swamedia.starter.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
public class SwaggerConfig {

    @Value("${application.version}")
    private String version;

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes("Bearer",
                        new SecurityScheme().type(Type.HTTP).scheme("Bearer").bearerFormat("JWT")))
                .info(new Info()
                        .title("Spring Boot API")
                        .description("Spring Boot API")
                        .version(version));
    }

}
