package com.thomashayashi.MergeTwoLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void checkSingleNodeMergesSameValue() {
        this.List1.value = 5;
        this.List2.value = 5;
        assertExpectedResult("5|5");
    }

    void assertExpectedResult(String expectedResult) {
        assertEquals(expectedResult, this.List1.mergeTwoLists(this.List2).print("|"));
    }
}
