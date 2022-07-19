package com.thomashayashi.ValidParentheses;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Full description: https://leetcode.com/problems/valid-parentheses/
 */
class ValidParenthesesTest {

    @Test
    void checkValidity(){
        assertTrue(isValid("()"));
        assertTrue(isValid("()[]{}"));
        assertFalse(isValid("(]"));
    }

    private boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
                continue;
            }

            if(stack.empty() || !stack.peek().equals(map.get(c))) {
                return false;
            }
            stack.pop();
        }

        return stack.empty();
    }
}
