package com.example.controller;

import com.example.api.Email;
import com.example.api.EmailDao;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Email> getEmailById(@RequestParam String id) {
        Optional<Email> email = Optional.of(this.emailDao.getById(id));

        if (!email.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Email>(email.get(), HttpStatus.FOUND);

    }

    @RequestMapping(method = RequestMethod.POST, value = "/email")
    @ResponseBody
    public ResponseEntity<Email> createEmail(@RequestBody Email email) {
        return new ResponseEntity<Email>(this.emailDao.insertEmail(email), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/emails/{sender}")
    @ResponseBody
    public ResponseEntity<List<Email>> getEmailsBySender(@RequestParam String sender) {
        Optional<List<Email>> emails = Optional.of(emailDao.getBySender(sender));
        if (!emails.isPresent()) {
            return new ResponseEntity<List<Email>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Email>>(emails.get(), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/email/delete/{id}")
    @ResponseBody
    public ResponseEntity<Email> deleteEmail(@RequestParam String id) {
        Optional<Email> deletedEmail = Optional.of(emailDao.deleteEmail(id));

        if (!deletedEmail.isPresent()) {
            return new ResponseEntity<Email>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Email>(deletedEmail.get(), HttpStatus.FOUND);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/email/update")
    @ResponseBody
    public ResponseEntity<Email> updateEmail(@RequestBody Email email) {
        Optional updateEmail = Optional.of(emailDao.updateEmail(email));

        if (!updateEmail.isPresent()) {
            return new ResponseEntity<Email>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Email>((Email) updateEmail.get(), HttpStatus.FOUND);
    }
}
