package com.example.api;

import java.util.Date;
/**
 *  Email
 *
 */
public class Email {

    private String id;
    private String to;
    private String body;
    private String from;
    private Date date;

    public Email() {
        this.id = "";
        this.to = "";
        this.body = "";
        this.from = "";
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

    public Email(String to, String body, String from){
        this.to = to;
        this.body = body;
        this.from = from;
    }

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
