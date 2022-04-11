package com.thomashayashi.ACMICPCTeam;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/acm-icpc-team/problem
 */
class ACMICPCTeamTest {
    @Test
    void checkTeams(){
        assertEquals(Arrays.asList(5,1), acmTeam(Arrays.asList("10101","11110", "00010")));
        assertEquals(Arrays.asList(5,2), acmTeam(Arrays.asList("10101","11100", "11010","00101")));
    }

    private List<Integer> acmTeam(List<String> topic) {
        HashMap<Integer, Integer> team = new HashMap<>();
        int numberTopics = topic.get(0).length();

        int maxKnownTopics = 0;
        for(int i = 0; i < topic.size(); i++) {
            for(int j = i + 1; j < topic.size(); j++) {
                char[] p1 = topic.get(i).toCharArray();
                char[] p2 = topic.get(j).toCharArray();

                int knownTopics = 0;
                for(int c = 0; c < numberTopics; c++) {
                    if(p1[c] == '1' || p2[c] == '1')
                        knownTopics++;
                }
                team.put(knownTopics, team.containsKey(knownTopics) ? team.get(knownTopics) + 1 : 1);

                if(maxKnownTopics < knownTopics)
                    maxKnownTopics = knownTopics;
            }
        }

        return Arrays.asList(maxKnownTopics, team.get(maxKnownTopics));
    }
}
