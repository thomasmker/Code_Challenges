package com.thomashayashi.TopFrequentElements;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/top-k-frequent-elements/
 */
class TopFrequentElementsTest {

    @Test
    void checkMostFrequentElements(){
        assertEquals(List.of(1), topKFrequent(new int[] {1}, 1));
        assertEquals(Arrays.asList(2,1), topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n: nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k)
                minHeap.poll();
        }

        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty())
            topNumbers.add(minHeap.poll().getKey());

        return topNumbers;
    }
}
