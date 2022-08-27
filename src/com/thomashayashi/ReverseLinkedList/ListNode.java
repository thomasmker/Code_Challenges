package com.thomashayashi.ReverseLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
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
