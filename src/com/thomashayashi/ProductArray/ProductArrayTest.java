package com.thomashayashi.ProductArray;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/product-of-array-except-self/
 */
class ProductArrayTest {
    @Test
    void checkProduct() {
        assertEquals(Arrays.asList(24,12,8,6), productExceptSelf(Arrays.asList(1,2,3,4)));
        assertEquals(Arrays.asList(0,0,9,0,0), productExceptSelf(Arrays.asList(-1,1,0,-3,3)));
    }

    private List<Integer> productExceptSelf(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();

        int prefix = 1;
        for (Integer num : nums) {
            result.add(prefix);
            prefix *= num;
        }
        int postfix = 1;
        for (int i = nums.size() - 1; i >= 0; i--) {
            result.set(i, result.get(i) * postfix);
            postfix *= nums.get(i);
        }
        return result;
    }
}
