package com.thomashayashi.GroupAnagrams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://leetcode.com/problems/group-anagrams/
 */
class GroupAnagramsTest {
    @Test
    void checkAnagramGroups(){
        assertEquals(List.of(List.of("")), groupAnagrams(new String[] {""}));
        assertEquals(Arrays.asList(Arrays.asList("tan","nat"), Arrays.asList("eat","tea","ate"), List.of("bat")), groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"}));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray())
                hash[c-'a']++;

            String str = new String(hash);
            map.computeIfAbsent(str, k -> new ArrayList<>());

            map.get(str).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
