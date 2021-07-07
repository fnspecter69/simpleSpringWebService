package com.run;

import com.controller.StaticNameController;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;

@SpringApplication
public class Start {

    @Bean
    public StaticNameController staticNameController() {
        return new StaticNameController();
    }

    public void main(String[] args) {

    }
}
