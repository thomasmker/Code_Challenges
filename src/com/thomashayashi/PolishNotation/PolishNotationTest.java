package com.thomashayashi.PolishNotation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 */
class PolishNotationTest {

    @Test
    void checkTokens(){
        assertEquals(3, evalRPN(Arrays.asList("2","1","+")));
        assertEquals(9, evalRPN(Arrays.asList("2","1","+","3","*")));
    }

    int evalRPN(List<String> tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "-" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b - a);
                }
                case "/" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
