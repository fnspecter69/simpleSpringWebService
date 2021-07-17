package com.example.run;

import com.example.controller.StaticNameController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Start {

    @Bean
    public StaticNameController staticNameController() {
        return new StaticNameController();
    }

    public static void main(String[] args) {
        // Launch the application
        SpringApplication.run(Start.class, args);
    }

    /*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/name")
                        .allowedMethods("*")
                        .allowedOrigins("http://localhost:8080");
            }
        };
    }*/
}
