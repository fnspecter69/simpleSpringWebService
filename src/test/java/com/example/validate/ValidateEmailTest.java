package com.example.validate;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
public class ValidateEmailTest {

    private String emailValid = "";
    private String emailValid2 = "";
    private String emailValid3 = "";
    private String emailInvalid;
    private String emailInvalid2;
    private String emailInvalid3;
    private ValidateEmail validateEmail;
    private ArrayList<String> validEmails = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        emailValid = "fre45@gamil.com";
        emailValid2 = "user-name@domain.com";
        emailValid3 = "username@domain.co.in";
        emailInvalid = "yahoo.com";
        emailInvalid2 = ".user.name@domain.com";
        emailInvalid3 = "user-name@domain.com.";
        validEmails.add(emailValid);
        validEmails.add(emailValid2);
        validEmails.add(emailValid3);
        validateEmail = new ValidateEmail();
    }

    @Test
    public void validateEmailAddressNormal() {
        Assert.assertTrue(validateEmail.isValidEmailAddress(emailValid));
        Assert.assertTrue(validateEmail.isValidEmailAddress(emailValid2));
        Assert.assertTrue(validateEmail.isValidEmailAddress(emailValid3));
    }

    @Test
    public void validateEmailAddressInvalid() {
        Assert.assertFalse(validateEmail.isValidEmailAddress(emailInvalid));
        Assert.assertFalse(validateEmail.isValidEmailAddress(emailInvalid2));
        Assert.assertFalse(validateEmail.isValidEmailAddress(emailInvalid3));
    }
}
