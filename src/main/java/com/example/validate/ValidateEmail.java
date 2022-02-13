package com.example.validate;

import java.util.regex.Pattern;


/**
 * A class that will validate the email for validity
 */
public class ValidateEmail {

    private String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    /**
     * validate that the email is valid or not
     * @param emailAddress - the email address to be validate
     * @return true if pass otherwise false
     */
    public boolean isValidEmailAddress(String emailAddress) {
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
}
