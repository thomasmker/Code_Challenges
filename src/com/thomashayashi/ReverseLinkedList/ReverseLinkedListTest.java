package com.thomashayashi.ReverseLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reverse-linked-list/
 */
class ReverseLinkedListTest {

    @Test
    void checkSingleNodeList(){
        ListNode a = new ListNode("a");
        checkReversedListResult(a, "a");
    }

    @Test
    void checkTwoNodeList(){
        ListNode a = new ListNode("a");
        a.next = new ListNode("b");
        checkReversedListResult(a, "b|a");
    }

    @Test
    void checkMultiNodeList(){
        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        a.next = b;
        b.next = c;
        checkReversedListResult(a, "c|b|a");
    }

    private void checkReversedListResult(ListNode originalList, String expectedResult) {
        ListNode reversedList = ListNode.reverseList(originalList);
        assertEquals(expectedResult, ListNode.printList(reversedList));
    }
}
