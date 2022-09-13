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
        ListNode temp;
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            temp = previous;
            previous = current;
            current = current.next;
            previous.next = temp;
        }
        return previous;
    }

    public String print(String delimiter) {
        List<String> list = new ArrayList<>();
        ListNode node = this;
        do {
            list.add(node.getValue());
            node = node.next;
        } while(node != null);

        return String.join(delimiter, list);
    }
}
