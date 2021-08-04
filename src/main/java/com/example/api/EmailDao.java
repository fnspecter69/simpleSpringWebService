package com.example.api;

import java.util.List;
public interface EmailDao {
    public Email getById(String id);
    public List<Email> getBySender(String sender);
}
