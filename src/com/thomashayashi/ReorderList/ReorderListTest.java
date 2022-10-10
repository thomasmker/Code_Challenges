package com.thomashayashi.ReorderList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reorder-list/
 */
public class ReorderListTest {

    private ListNode List;

    @Test
    void checkSingleNode() {
        this.List = new ListNode(1);
        reorderList(this.List);
        assertResult("1");
    }

    @Test
    void checkTwoNodes() {
        this.List = new ListNode(1);
        this.List.next = new ListNode(2);
        reorderList(this.List);
        assertResult("1|2");
    }

    @Test
    void checkThreeNodes() {
        this.List = new ListNode(1);
        this.List.next = new ListNode(2);
        this.List.next.next = new ListNode(3);
        reorderList(this.List);
        assertResult("1|3|2");
    }

    void assertResult(String expectedResult) {
        assertEquals(expectedResult, this.List.print("|"));
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}

