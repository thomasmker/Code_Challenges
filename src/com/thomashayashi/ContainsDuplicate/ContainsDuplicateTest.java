package com.thomashayashi.ContainsDuplicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/*
 * Full description: https://leetcode.com/problems/contains-duplicate/
 */
class ContainsDuplicateTest {
    @Test
    void checkDuplicates(){
        assertTrue(containsDuplicate(Arrays.asList(1, 2, 1)));
        assertFalse(containsDuplicate(Arrays.asList(1, 2, 3)));
    }

    private boolean containsDuplicate(List<Integer> arr) {
        Set<Integer> uniqueArr = new HashSet<>(arr);
        return uniqueArr.size() != arr.size();
    }
}
