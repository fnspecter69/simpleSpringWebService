package com.example.controller;

import com.example.api.Email;
import com.example.api.EmailDao;
import com.example.dao.MongoEmailDao;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private MongoTemplate mongoTemplate;
    private EmailDao emailDao;

    public EmailController(MongoTemplate mongoTemplate){
        emailDao = new MongoEmailDao(mongoTemplate);
    }

    @RequestMapping(value = "/email/{id}")
    public Email getEmailById(@RequestParam String id) {
        return this.emailDao.getById(id);
    }
}
