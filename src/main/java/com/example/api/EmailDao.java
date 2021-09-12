package com.example.api;

import java.util.List;
public interface EmailDao {

    public Email insertEmail(Email email);

    public Email getById(String id);

    public List<Email> getAllEmails();

    public Email updateEmail(String id, Email email);

    public Email deleteEmail(String id);
}
