package com.thomashayashi.MergeTwoLinkedList;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int value;
    public ListNode next;

    public ListNode() {

    }

    public ListNode mergeTwoLists(ListNode list2) {
        final ListNode root = new ListNode();
        ListNode prev = root;

        ListNode currentList = this;
        while (currentList != null && list2 != null) {
            if (currentList.value < list2.value) {
                prev.next = currentList;
                currentList = currentList.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = currentList != null ? currentList : list2;
        return root.next;
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
