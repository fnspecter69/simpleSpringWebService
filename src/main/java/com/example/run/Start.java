package com.example.run;

import com.example.controller.StaticNameController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;

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
}
