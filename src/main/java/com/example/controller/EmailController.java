package com.example.controller;

import com.example.api.Email;
import com.example.api.EmailDao;
import java.util.List;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    private EmailDao emailDao;

    public EmailController(EmailDao emailDao){
        this.emailDao = emailDao;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/email/{id}")
    @ResponseBody
    public Email getEmailById(@RequestParam String id) {
        return this.emailDao.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/email")
    @ResponseBody
    public Email createEmail(@RequestBody Email email) {
        return this.emailDao.insertEmail(email);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/emails/{sender}")
    @ResponseBody
    public List<Email> getEmailsBySender(@RequestParam String sender) {
        return emailDao.getBySender(sender);
    }

    public Email deleteEmail(@RequestParam String id) { return null; }

    public Email updateEmail(Email email) { return null; }
}
