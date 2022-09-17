package com.thomashayashi.MergeTwoLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
 * Full description: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLinkedListTest {

    @Test
    void checkNullMerges(){
        assertNull(mergeTwoLists(null, null));
    }

    @Test
    void checkSingleNodeMerges() {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        assertEquals("1|2", mergeTwoLists(list1, list2).print("|"));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null)
            return null;

        final ListNode root = new ListNode();
        ListNode prev = root;
        while (list1 != null && list2 != null) {
            if (list1.value < list2.value) {
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = list1 != null ? list1 : list2;
        return root.next;
    }
}
