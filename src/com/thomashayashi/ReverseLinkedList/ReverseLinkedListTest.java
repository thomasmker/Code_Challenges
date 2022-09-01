package com.thomashayashi.ReverseLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reverse-linked-list/
 */
class ReverseLinkedListTest {
    private ListNode head;

    @BeforeEach
    void init() {
        head  = new ListNode("a");
    }

    @Test
    void checkTwoNodeList(){
        head.next = new ListNode("b");
        checkReversedListResult("b|a");
    }

    @Test
    void checkMultiNodeList(){
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        head.next = b;
        b.next = c;
        checkReversedListResult("c|b|a");
    }

    private void checkReversedListResult(String expectedResult) {
        ListNode reversedList = ListNode.reverseList(head);
        assertEquals(expectedResult, reversedList.print("|"));
    }
}
