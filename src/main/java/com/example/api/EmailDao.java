package com.example.api;

import java.util.List;
public interface EmailDao {

    public Email insertEmail(Email email);

    public Email getById(String id);

    public List<Email> getBySender(String sender);

    public Email updateEmail(Email email);

    public Email deleteEmail(Email email);
}
