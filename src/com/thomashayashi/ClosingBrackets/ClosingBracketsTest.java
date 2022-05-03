package com.thomashayashi.ClosingBrackets;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class ClosingBracketsTest {
    @Test
    void checkValidity(){
        assertTrue(isValid("[]"));
        assertTrue(isValid("[[][]]"));
        assertFalse(isValid("]["));
        assertFalse(isValid("[[]"));
    }

    private boolean isValid(String word) {
        Stack<Character> stack = new Stack<>();

        for(char c : word.toCharArray()) {
            if(c == '[')
                stack.push(c);
            else if(stack.size() != 0)
                stack.pop();
        }

        return stack.size() == 0;
    }
}
