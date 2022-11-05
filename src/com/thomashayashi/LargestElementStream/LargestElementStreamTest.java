package com.thomashayashi.LargestElementStream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class LargestElementStreamTest {

    @Test
    void checkAddingLargerElement() {
        KthLargest heap = new KthLargest(1, List.of(0));
        assertEquals(1, heap.add(1));
    }

    @Test
    void checkAddingSmallerElement() {
        KthLargest heap = new KthLargest(1, List.of(1));
        assertEquals(1, heap.add(0));
    }
}

class KthLargest {

    final PriorityQueue<Integer> heap = new PriorityQueue<>();
    final int k;

    public KthLargest(int k, List<Integer> numbers) {
        this.k = k;
        for (Integer n : numbers) add(n);
    }

    public Integer add(Integer val) {
        if (heap.size() < k)heap.offer(val); //for adding the values of the array
        else if (heap.peek() != null && val > heap.peek()) {
            heap.poll(); //remove the top element
            heap.add(val); //add the new element
        }
        return heap.peek();
    }
}