package com.thomashayashi.ReverseLinkedList;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

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

class ListNode {
    public ListNode next;
    private final String value;

    public ListNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode p;
        ListNode q = null;
        ListNode r = head;
        while (r != null) {
            p = q;
            q = r;
            r = r.next;
            q.next = p;
        }
        return q;
    }

    public static String printList(ListNode head) {
        List<String> list = new ArrayList<>();
        while(head != null) {
            list.add(head.getValue());
            head = head.next;
        }

        return String.join("|", list);
    }
}
