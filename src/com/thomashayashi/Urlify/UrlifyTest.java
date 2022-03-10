package com.thomashayashi.Urlify;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*Write a method to replace all spaces in a string with '___: You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: if implementing in Java, please use a character array so that you can
perform this operation in place.)*/
class UrlifyTest {
    @Test
    void convertString() {
        //assertEquals("Mr___John___Smith","Mr John Smith".replace(" ", "___"));
        assertEquals("Mr___John___Smith",replaceSpaces("Mr John Smith    ".toCharArray(),13));
        assertEquals("Mr___Ann___Smith",replaceSpaces("Mr Ann Smith    ".toCharArray(),12));
    }

    private String replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for(int i = 0; i < trueLength; i++) {
            if(str[i] == ' ')
                spaceCount++;
        }

        int index = trueLength + spaceCount * 2;
        if(trueLength < str.length) str[trueLength] = '\0';
        for(int i = trueLength - 1; i >=0; i--) {
            if(str[i] == ' ') {
                str[index - 1] = '_';
                str[index - 2] = '_';
                str[index - 3] = '_';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }

        return new String(str);
    }
}
