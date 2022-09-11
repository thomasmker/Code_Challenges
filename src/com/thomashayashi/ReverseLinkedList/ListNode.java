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
        ListNode previous;
        ListNode temp = null;
        ListNode current = head;
        while (current != null) {
            previous = temp;
            temp = current;
            current = current.next;
            temp.next = previous;
        }
        return temp;
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
