package com.thomashayashi.SearchInRotatedSortedArray;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class SearchInRotatedSortedArrayTest {
    @Test
    void checkIndex(){
        assertEquals(4, search(Arrays.asList(4,5,6,7,0,1,2), 0));
        assertEquals(-1, search(Arrays.asList(4,5,6,7,0,1,2), 3));
    }

    private int search(List<Integer> numbers, int target) {
        int minIndex = minIndex(numbers);
        int leftSearch = binarySearch(numbers, 0, minIndex - 1, target);
        int rightSearch = binarySearch(numbers, minIndex, numbers.size() - 1, target);

        return (leftSearch != -1) ? leftSearch : rightSearch;
    }

    private int minIndex(List<Integer> numbers) {
        int start = 0;
        int end = numbers.size() - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + numbers.size()) % numbers.size();
            int next = (mid + 1) % numbers.size();
            if (numbers.get(mid) <= numbers.get(prev) && numbers.get(mid)  <= numbers.get(next)) {
                return mid;
            } else if (numbers.get(mid)  <= numbers.get(end)) {
                end = mid - 1;
            } else if (numbers.get(mid)  >= numbers.get(start)) {
                start = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearch(List<Integer> numbers, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (numbers.get(mid)  == target) {
                return mid;
            } else if (numbers.get(mid)  < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
