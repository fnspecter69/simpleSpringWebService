package com.example.dao;

import com.example.api.Email;
import com.example.api.EmailDao;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *
 */
public class MongoEmailDao implements EmailDao {

    private MongoTemplate mongoTemplate;

    public MongoEmailDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Email insertEmail(Email email) {
        return null;
    }

    @Override
    public Email getById(String id) {
        return null;
    }

    @Override
    public List<Email> getBySender(String sender) {
        return null;
    }

    @Override
    public Email updateEmail(Email email) {
        return null;
    }
}
