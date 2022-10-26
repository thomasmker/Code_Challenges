package com.thomashayashi.ReorderList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/reorder-list/
 */
public class ReorderListTest {

    private ListNode Head;
    private static final String SEPARATOR = "|";

    @Test
    void checkSingleNode() {
        linkNodes(Collections.emptyList());
        assertResult(List.of("1"));
    }

    @Test
    void checkTwoNodes() {
        linkNodes(List.of(2));
        assertResult(Arrays.asList("1","2"));
    }

    @Test
    void checkThreeNodes() {
        linkNodes(Arrays.asList(2,3));
        assertResult(Arrays.asList("1","3","2"));
    }

    @Test
    void checkFourNodes() {
        linkNodes(Arrays.asList(2,3,4));
        assertResult(Arrays.asList("1","4","2","3"));
    }

    @Test
    void checkFiveNodes() {
        linkNodes(Arrays.asList(2,3,4,5));
        assertResult(Arrays.asList("1","5","2","4","3"));
    }


    void linkNodes(List<Integer> nodes) {
        Head = new ListNode(1);
        ListNode current = Head;
        for(Integer node : nodes) {
            current.next = new ListNode(node);
            current = current.next;
        }
    }

    void assertResult(List<String> expectedResult) {
        Head.reorderList();
        assertEquals(formatResult(expectedResult), Head.print(SEPARATOR));
    }

    String formatResult(List<String> expectedResult) {
        return String.join(SEPARATOR, expectedResult);
    }
}

