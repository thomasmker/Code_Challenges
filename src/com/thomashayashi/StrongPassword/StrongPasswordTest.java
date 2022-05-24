package com.thomashayashi.StrongPassword;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/strong-password/problem
 */
class StrongPasswordTest {
    @Test
    void checkPasswordStrength(){
        assertEquals(1, minimumNumber("2bb#A"));
        assertEquals(3, minimumNumber("Ab1"));
    }

    private int minimumNumber(String password) {
        List<String> regexes = new ArrayList<>();
        regexes.add("[0-9]");
        regexes.add("[A-Z]");
        regexes.add("[a-z]");
        regexes.add("[!@#$%^&*()+-]");

        int count = 0;
        for(String regex : regexes) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if(!matcher.find())
                count++;
        }
        return Math.max(6 - password.length(), count);
    }
}
