package com.example.validate;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
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
    private ArrayList<String> validEmails = new ArrayList<>();

    @Before
    public void setUp() {
        System.out.println("Beggining the tests\n\n\n\n");
        emailValid = "fre45@gamil.com";
        emailValid2 = "user-name@domain.com";
        emailValid3 = "username@domain.co.in";
        validEmails.add(emailValid);
        validEmails.add(emailValid2);
        validEmails.add(emailValid3);
    }

    @Test
    public void validateEmailAddressNormal() {
        emailValid = "fre45@gamil.com";
        emailValid2 = "user-name@domain.com";
        emailValid3 = "username@domain.co.in";
        System.out.println("\n\n\n\n\nvalidEmails size is " + validEmails.size());
        ValidateEmail validateEmail = new ValidateEmail();
        Assert.assertTrue(validateEmail.isValidEmailAddress(emailValid));
        Assert.assertTrue(validateEmail.isValidEmailAddress(emailValid2));
        Assert.assertTrue(validateEmail.isValidEmailAddress(emailValid3));
    }

    @Test
    public void validateEmailAddressInvalid() {
        emailInvalid = "yahoo.com";
        emailInvalid2 = ".user.name@domain.com";
        emailInvalid3 = "user-name@domain.com.";
        ValidateEmail inValidateEmail = new ValidateEmail();
        Assert.assertFalse(inValidateEmail.isValidEmailAddress(emailInvalid));
        Assert.assertFalse(inValidateEmail.isValidEmailAddress(emailInvalid2));
        Assert.assertFalse(inValidateEmail.isValidEmailAddress(emailInvalid3));
    }
}
