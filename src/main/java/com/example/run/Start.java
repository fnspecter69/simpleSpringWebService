package com.example.run;

import com.example.api.EmailDao;
import com.example.dao.MongoEmailDao;
import com.example.controller.EmailController;
import com.example.controller.StaticNameController;
import com.mongodb.MongoClientSettings;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Start {

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "test");
    }

    @Bean
    public EmailDao emailDao(MongoTemplate mongoTemplate) {
        return new MongoEmailDao(mongoTemplate);
    }

    @Bean
    public EmailController emailController(EmailDao emailDao) {
        return new EmailController(emailDao);
    }

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
