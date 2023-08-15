package top.rectorlee.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: Lee
 * @date: 2023-08-15 14:00:22
 * @version: 1.0
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .externalDocs(new ExternalDocumentation().description("接口文档").url(""));
    }

    private Info apiInfo() {
        return new Info()
                .title("接口文档")
                .description("第一次学习MongoDB和SpringDoc接口文档")
                .version("v1.0")
                .contact(new Contact().name("Lee").url("").email(""));
    }
}
