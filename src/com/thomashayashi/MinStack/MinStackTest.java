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

    @Test
    void checkEmptyStackAfterOnePushAndOnePop(){
        push(1);
        pop();
        checkEmptyStack();
    }

    @Test
    void checkLastEntryAfterOnePush(){
        push(2);
        assertEquals(2,top());
    }

    @Test
    void checkLastEntryAfterTwoAscendingPush(){
        push(2);
        push(5);
        assertEquals(5,top());
    }

    @Test
    void checkMinValueWithAscendingPush(){
        push(2);
        push(5);
        assertEquals(2,getMin());
    }

    @Test
    void checkMinValueWithDescendingPush(){
        push(4);
        push(1);
        assertEquals(1,getMin());
    }

    private void push(int val) {
        stack.push(val);
        val = Math.min(val, minStack.isEmpty() ? val : minStack.peek());
        minStack.push(val);
    }

    private void pop() {
        stack.pop();
        minStack.pop();
    }

    private int top() {
        return stack.peek();
    }

    private int getMin() { return minStack.peek(); }
}
