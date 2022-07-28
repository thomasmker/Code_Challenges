package com.thomashayashi.GenerateParentheses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/generate-parentheses/
 */
class GenerateParenthesesTest {
    Stack<String> stack;
    List<String> result;

    @Test
    void checkParenthesisGeneration(){
        assertEquals(List.of("()"), generateParenthesis(1));
        assertEquals(Arrays.asList("(())","()()"), generateParenthesis(2));
        assertEquals(Arrays.asList("((()))","(()())","(())()","()(())","()()()"), generateParenthesis(3));
    }

    private List<String> generateParenthesis(int n) {
        stack = new Stack<>();
        result = new ArrayList<>();

        backTrack(0,0,n);

        return result;
    }

    private void backTrack(int open, int close, int n) {
        if (open == close && close == n) {
            result.add(String.join("", stack.stream().toList()));
            return;
        }

        if (open < n) {
            stack.push("(");
            backTrack(open + 1, close, n);
            stack.pop();
        }

        if (close < open) {
            stack.push(")");
            backTrack(open, close + 1, n);
            stack.pop();
        }
    }
}
