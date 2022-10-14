package com.thomashayashi.ReorderList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reorder-list/
 */
public class ReorderListTest {

    private ListNode List;

    @BeforeEach
    void init() {
        this.List = new ListNode(1);
    }

    @Test
    void checkSingleNode() {
        assertResult("1");
    }

    @Test
    void checkTwoNodes() {
        this.List.next = new ListNode(2);
        assertResult("1|2");
    }

    @Test
    void checkThreeNodes() {
        this.List.next = new ListNode(2);
        this.List.next.next = new ListNode(3);
        assertResult("1|3|2");
    }

    @Test
    void checkFourNodes() {
        this.List.next = new ListNode(2);
        this.List.next.next = new ListNode(3);
        this.List.next.next.next = new ListNode(4);
        assertResult("1|4|2|3");
    }

    void assertResult(String expectedResult) {
        this.List.reorderList();
        assertEquals(expectedResult, this.List.print("|"));
    }
}

