package com.thomashayashi.ReverseLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reverse-linked-list/
 */
class ReverseLinkedListTest {
    private ListNode head;
    private final String HEAD_NODE = "HEAD";
    private final String SEPARATOR = "|";
    @BeforeEach
    void init() {
        head  = new ListNode(HEAD_NODE);
    }
    
    @Test
    void checkSingleNodeList(){
        checkReversedListResult("");
    }

    @Test
    void checkTwoNodeList(){
        head.next = new ListNode("A");
        checkReversedListResult("A");
    }

    @Test
    void checkMultiNodeList(){
        ListNode a = new ListNode("A");
        ListNode b = new ListNode("B");
        head.next = a;
        a.next = b;
        checkReversedListResult("B" + SEPARATOR + "A");
    }

    private void checkReversedListResult(String expectedResult) {
        ListNode reversedList = head.reverseList();
        assertEquals(formatExpectedResult(expectedResult), reversedList.print(SEPARATOR));
    }
    
    private String formatExpectedResult(String expectedResult) {
        return (expectedResult.equals("")) ? HEAD_NODE : expectedResult + SEPARATOR + HEAD_NODE;
    }
}
