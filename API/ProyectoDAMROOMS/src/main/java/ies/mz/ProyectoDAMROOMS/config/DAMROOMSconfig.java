package ies.mz.ProyectoDAMROOMS.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAMROOMSconfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("DAMROOMS API")
                        .description("API REST del equipo de DAMROOMS")
                        .contact(new Contact()
                                .name("IMZ")
                                .email("imz@iesmarcoszaragoza.es")
                                .url("www.imz.es"))
                        .version("1.0"));
    }
}
