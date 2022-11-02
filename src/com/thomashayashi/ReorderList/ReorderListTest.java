package com.thomashayashi.ReorderList;

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

    @Test
    void checkSingleNode() {
        linkNodesFromHead(List.of(1));
        assertResult(List.of("1"));
    }

    @Test
    void checkTwoNodes() {
        linkNodesFromHead(Arrays.asList(1,2));
        assertResult(Arrays.asList("1","2"));
    }

    @Test
    void checkThreeNodes() {
        linkNodesFromHead(Arrays.asList(1,2,3));
        assertResult(Arrays.asList("1","3","2"));
    }

    @Test
    void checkFourNodes() {
        linkNodesFromHead(Arrays.asList(1,2,3,4));
        assertResult(Arrays.asList("1","4","2","3"));
    }

    @Test
    void checkFiveNodes() {
        linkNodesFromHead(Arrays.asList(1,2,3,4,5));
        assertResult(Arrays.asList("1","5","2","4","3"));
    }

    void linkNodesFromHead(List<Integer> nodes) {
        initHead(nodes.get(0));
        ListNode current = Head;
        for(int i = 1; i < nodes.size(); i++) {
            current.next = new ListNode(nodes.get(i));
            current = current.next;
        }
    }

    void initHead(Integer value) {
        Head = new ListNode(value);
    }

    void assertResult(List<String> expectedResult) {
        Head.reorderList();
        assertEquals(formatResult(expectedResult), Head.print(SEPARATOR));
    }

    String formatResult(List<String> expectedResult) {
        return String.join(SEPARATOR, expectedResult);
    }
}

