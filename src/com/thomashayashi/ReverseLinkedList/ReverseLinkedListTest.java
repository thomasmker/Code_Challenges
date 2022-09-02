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
        head  = new ListNode("head");
    }
    
    @Test
    void checkSingleNodeList(){
        checkReversedListResult("head");
    }

    @Test
    void checkTwoNodeList(){
        head.next = new ListNode("a");
        checkReversedListResult("a|head");
    }

    @Test
    void checkMultiNodeList(){
        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        head.next = a;
        a.next = b;
        checkReversedListResult("b|a|head");
    }

    private void checkReversedListResult(String expectedResult) {
        ListNode reversedList = ListNode.reverseList(head);
        assertEquals(expectedResult, reversedList.print("|"));
    }
}
