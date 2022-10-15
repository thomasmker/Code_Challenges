package com.thomashayashi.ReorderList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reorder-list/
 */
public class ReorderListTest {

    private ListNode Head;

    @BeforeEach
    void init() {
        this.Head = new ListNode(1);
    }

    @Test
    void checkSingleNode() {
        assertResult("1");
    }

    @Test
    void checkTwoNodes() {
        this.Head.next = new ListNode(2);
        assertResult("1|2");
    }

    @Test
    void checkThreeNodes() {
        this.Head.next = new ListNode(2);
        this.Head.next.next = new ListNode(3);
        assertResult("1|3|2");
    }

    @Test
    void checkFourNodes() {
        this.Head.next = new ListNode(2);
        this.Head.next.next = new ListNode(3);
        this.Head.next.next.next = new ListNode(4);
        assertResult("1|4|2|3");
    }

    void assertResult(String expectedResult) {
        this.Head.reorderList();
        assertEquals(expectedResult, this.Head.print("|"));
    }
}

