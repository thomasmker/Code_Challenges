package com.thomashayashi.ReorderList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int value) {
        this.value = value;
    }

    public String print(String delimiter) {
        List<String> list = new ArrayList<>();
        ListNode node = this;
        do {
            list.add(String.valueOf(node.value));
            node = node.next;
        } while(node != null);

        return String.join(delimiter, list);
    }
}
