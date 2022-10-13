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

    void assertResult(String expectedResult) {
        this.List.reorderList();
        assertEquals(expectedResult, this.List.print("|"));
    }
}

