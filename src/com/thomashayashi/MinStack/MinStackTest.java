package com.thomashayashi.MinStack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Full description: https://leetcode.com/problems/min-stack/
 */
class MinStackTest {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    @BeforeEach
    void setup() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    @Test
    void checkEmptyStack(){
        assertTrue(stack.empty());
        assertTrue(minStack.empty());
    }

    @Test
    void checkStackNotEmptyAfterPush(){
        push(0);
        assertFalse(stack.empty());
        assertFalse(minStack.empty());
    }

    @Test
    void checkStackSizeAfterOnePush(){
        push(1);
        assertEquals(1,stack.size());
        assertEquals(1,minStack.size());
    }

    public void push(int val) {
        stack.push(val);
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }
}
