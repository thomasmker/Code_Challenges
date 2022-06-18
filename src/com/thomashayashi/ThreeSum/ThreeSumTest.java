package com.thomashayashi.ThreeSum;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/3sum/
 */
class ThreeSumTest {
    @Test
    void checkSum(){
        assertEquals(Arrays.asList(Arrays.asList(-1,-1,2),Arrays.asList(-1,0,1)), threeSum(new int[] {-1,0,1,2,-1,-4}));
        assertEquals(Collections.emptyList(), threeSum(new int[] {}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        LinkedList<List<Integer>> sol = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int left = i + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> miniSol = new ArrayList<>();
                        miniSol.add(nums[i]);
                        miniSol.add(nums[left]);
                        miniSol.add(nums[right]);
                        sol.add(miniSol);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return sol;
    }
}
