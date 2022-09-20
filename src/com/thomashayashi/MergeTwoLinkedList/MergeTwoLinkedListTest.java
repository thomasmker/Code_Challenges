package com.thomashayashi.MergeTwoLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/*
 * Full description: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLinkedListTest {

    private ListNode List1;
    private ListNode List2;

    @BeforeEach
    void init() {
        this.List1 = new ListNode();
        this.List2 = new ListNode();
    }
    @Test
    void checkNullMerges(){
        assertNull(mergeTwoLists(null, null));
    }

    @Test
    void checkSingleNodeMergesAsc() {
        this.List1.value = 1;
        this.List2.value = 2;
        assertExpectedResult("1|2");
    }

    @Test
    void checkSingleNodeMergesDesc() {
        this.List1.value = 4;
        this.List2.value = 3;
        assertExpectedResult("3|4");
    }

    void assertExpectedResult(String expectedResult) {
        assertEquals(expectedResult, mergeTwoLists(this.List1, this.List2).print("|"));
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
