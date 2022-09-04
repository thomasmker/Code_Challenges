package com.thomashayashi.ReverseLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reverse-linked-list/
 */
class ReverseLinkedListTest {
    private ListNode head;
    private final String headDescription = "head";
    
    @BeforeEach
    void init() {
        head  = new ListNode(headDescription);
    }
    
    @Test
    void checkSingleNodeList(){
        checkReversedListResult();
    }

    @Test
    void checkTwoNodeList(){
        head.next = new ListNode("a");
        checkReversedListResult("a");
    }

    @Test
    void checkMultiNodeList(){
        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        head.next = a;
        a.next = b;
        checkReversedListResult("b|a");
    }

    private void checkReversedListResult(String expectedResult = "") {
        ListNode reversedList = ListNode.reverseList(head);
        assertEquals(formatExpectedResult(expectedResult), reversedList.print("|"));
    }
    
    private String formatExpectedResult(String expectedResult) {
        return (expectedResult == "") ? headDescription : expectedResult + "|" + headDescription;
    }
}
