package com.thomashayashi.MergeTwoLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoLinkedListTest {

    private ListNode List1;
    private ListNode List2;

    private final String SEPARATOR = "|";

    @BeforeEach
    void init() {
        this.List1 = new ListNode();
        this.List2 = new ListNode();
    }

    @Test
    void checkSingleNodeMergesAsc() {
        this.List1 = new ListNode(1);
        this.List2 = new ListNode(2);
        assertExpectedResult(Arrays.asList("1","2"));
    }

    @Test
    void checkSingleNodeMergesDesc() {
        this.List1 = new ListNode(4);
        this.List2 = new ListNode(3);
        assertExpectedResult(Arrays.asList("3","4"));
    }

    @Test
    void checkSingleNodeMergesSameValue() {
        this.List1 = new ListNode(5);
        this.List2 = new ListNode(5);
        assertExpectedResult(Arrays.asList("5","5"));
    }

    @Test
    void checkMultipleNodeMergeInterval() {
        this.List1 = new ListNode(1);
        this.List1.next = new ListNode(3);

        this.List2 = new ListNode(2);
        this.List2.next = new ListNode(4);

        assertExpectedResult(Arrays.asList("1","2","3","4"));
    }

    @Test
    void checkMultipleNodeMergeSequentialHead() {
        this.List1 = new ListNode(1);
        this.List1.next = new ListNode(2);

        this.List2 = new ListNode(3);
        this.List2.next = new ListNode(4);

        assertExpectedResult(Arrays.asList("1","2","3","4"));
    }

    @Test
    void checkMultipleNodeMergeSequentialTail() {
        this.List1.value = 3;
        this.List1.next = new ListNode(4);

        this.List2.value = 1;
        this.List2.next = new ListNode(2);

        assertExpectedResult(Arrays.asList("1","2","3","4"));
    }

    void assertExpectedResult(List<String> expectedList) {
        assertEquals(formatExpectedResult(expectedList), this.List1.mergeTwoLists(this.List2).print(SEPARATOR));
    }

    String formatExpectedResult(List<String> expectedList) {
        return String.join(SEPARATOR, expectedList);
    }
}
