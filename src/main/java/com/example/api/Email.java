package com.example.api;

import java.util.Date;
import org.springframework.data.annotation.Id;
/**
 *  Email
 *
 */
public class Email {

    @Id private String id;
    private String to;
    private String body;
    private String from;
    private Date date;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    private String subject;

    public Email() {
        this.id = "";
        this.to = "";
        this.body = "";
        this.from = "";
        this.subject = "";
        this.date = new Date();
    }

    public String getBody() {
        return body;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Email(String to, String body, String from, String subject){
        this.to = to;
        this.body = body;
        this.from = from;
        this.date = new Date();
        this.subject = subject;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Date getDate() {
        return date;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
