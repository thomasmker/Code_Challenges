package com.thomashayashi.EncodeDecodeString;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.lintcode.com/problem/659/
 */
class EncodeDecodeStringTest {
    @Test
    void checkEncode() {
        assertEquals("1#a2#bc", encode(Arrays.asList("a","bc")));
        assertEquals("4#lint4#code4#love3#you", encode(Arrays.asList("lint","code","love","you")));
    }

    private String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String str: strs)
            encodedString.append(str.length()).append("#").append(str);

        return encodedString.toString();
    }
}
