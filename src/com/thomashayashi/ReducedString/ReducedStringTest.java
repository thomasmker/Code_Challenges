package com.thomashayashi.ReducedString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/reduced-string/problem
 */
class ReducedStringTest {
    @Test
    void checkReducedString(){
        assertEquals("", superReducedString(""));
        assertEquals("", superReducedString("aa"));
        assertEquals("", superReducedString("aabb"));
        assertEquals("ab", superReducedString("ab"));
        assertEquals("b", superReducedString("aab"));
        assertEquals("", superReducedString("baab"));
    }

    private String superReducedString(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for(int i = 0; i < s.length(); i++) {
            if (i == 0 || top == -1)
                stack[++top] = s.charAt(i);
            else {
                if (stack[top] == s.charAt(i))
                    top--;
                else
                    stack[++top] = s.charAt(i);
            }
        }

        StringBuilder remaining = new StringBuilder();
        if(top !=-1) {
            for(int i=0;i<=top;i++)
                remaining.append(stack[i]);
        }

        return remaining.toString();
    }
}
