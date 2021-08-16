package com.example.dao;

import com.example.api.Email;
import com.example.api.EmailDao;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * MongoEmailDao -
 */
public class MongoEmailDao implements EmailDao {

    private MongoTemplate mongoTemplate;

    public MongoEmailDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Email insertEmail(Email email) {
        try {
            this.mongoTemplate.insert(email);
        } catch (Throwable t){
            return null;
        }
        return email;
    }

    @Override
    public Email getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findById(query, Email.class);
    }

    @Override
    public List<Email> getBySender(String sender) {
        Query query = new Query();
        query.addCriteria(Criteria.where("sender").is(sender));
        return mongoTemplate.find(query, Email.class);
    }

    @Override
    public Email updateEmail(Email email) {
        return null;
    }

    @Override
    public Email deleteEmail(Email email) { return null;}
}
