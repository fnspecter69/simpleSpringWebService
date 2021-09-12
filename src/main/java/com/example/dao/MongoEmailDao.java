package com.example.dao;

import com.example.api.Email;
import com.example.api.EmailDao;
import com.mongodb.client.result.UpdateResult;
import java.util.List;
import java.util.UUID;
import javax.validation.constraints.NotNull;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.Assert;

/**
 * MongoEmailDao - implementation of EmailDao interface
 */
public class MongoEmailDao implements EmailDao {

    private MongoTemplate mongoTemplate;

    public MongoEmailDao(MongoTemplate mongoTemplate) {
        Assert.notNull(mongoTemplate, "MongoTemplate cannot be null");
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Email insertEmail(Email email) {
        email.setId(UUID.randomUUID().toString());
        try {
            this.mongoTemplate.insert(email);
        } catch (Throwable t){
            return null;
        }
        return email;
    }

    @Override
    public Email getById(@NotNull String id) {
        return mongoTemplate.findById(id, Email.class);
    }

    @Override
    public List<Email> getAllEmails() {
        return mongoTemplate.findAll(Email.class);
    }

    @Override
    public Email updateEmail(String id, Email email) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        if (!this.mongoTemplate.exists(query, Email.class)) {
            return email;
        }
        Update update = new Update();
        update.set("body", email.getBody());
        update.set("to", email.getTo());
        update.set("from", email.getFrom());
        UpdateResult updateResult = this.mongoTemplate.upsert(query, update, Email.class);
        if (updateResult.getModifiedCount() == 0) {
            return null;
        }
        return email;
    }

    @Override
    public Email deleteEmail(@NotNull String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findAndRemove(query, Email.class);
    }
}
