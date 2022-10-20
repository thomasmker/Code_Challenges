package com.thomashayashi.ReorderList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reorder-list/
 */
public class ReorderListTest {

    private ListNode Head;
    private static final String SEPARATOR = "|";

    @BeforeEach
    void init() {
        Head = new ListNode(1);
    }

    @Test
    void checkSingleNode() {
        assertResult(List.of("1"));
    }

    @Test
    void checkTwoNodes() {
        Head.next = new ListNode(2);
        assertResult(Arrays.asList("1","2"));
    }

    @Test
    void checkThreeNodes() {
        Head.next = new ListNode(2);
        Head.next.next = new ListNode(3);
        assertResult(Arrays.asList("1","3","2"));
    }

    @Test
    void checkFourNodes() {
        Head.next = new ListNode(2);
        Head.next.next = new ListNode(3);
        Head.next.next.next = new ListNode(4);
        assertResult(Arrays.asList("1","4","2","3"));
    }

    void assertResult(List<String> expectedResult) {
        Head.reorderList();
        assertEquals(formatResult(expectedResult), Head.print(SEPARATOR));
    }

    String formatResult(List<String> expectedResult) {
        return String.join(SEPARATOR, expectedResult);
    }
}

