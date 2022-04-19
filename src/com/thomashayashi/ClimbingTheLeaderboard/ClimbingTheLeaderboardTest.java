package com.thomashayashi.ClimbingTheLeaderboard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
class ClimbingTheLeaderboardTest {
    @Test
    void checkLeaderboard(){
        assertEquals(Arrays.asList(3,3), climbingLeaderboard(Arrays.asList(100,90,90,80), Arrays.asList(80,80)));
        assertEquals(Arrays.asList(4,3), climbingLeaderboard(Arrays.asList(100,90,90,80), Arrays.asList(70,80)));
        assertEquals(Arrays.asList(4,2), climbingLeaderboard(Arrays.asList(100,90,90,80), Arrays.asList(70,90)));
        assertEquals(Arrays.asList(4,1), climbingLeaderboard(Arrays.asList(100,90,90,80), Arrays.asList(70,100)));
        assertEquals(Arrays.asList(4,1), climbingLeaderboard(Arrays.asList(100,90,90,80), Arrays.asList(70,101)));

        assertEquals(Arrays.asList(4,3,1), climbingLeaderboard(Arrays.asList(100,90,90,80), Arrays.asList(70,80,105)));
    }

    private List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        HashMap<Integer, Integer> rankNumber = createScoreRank(ranked);

        return calculatePlayerRank(ranked, player, rankNumber);
    }

    private List<Integer> calculatePlayerRank(List<Integer> ranked, List<Integer> player, HashMap<Integer, Integer> rankNumber) {
        int indexRank = ranked.size() - 1;
        int indexPlayer = 0;

        List<Integer> rankPosition = new ArrayList<>();
        while(indexPlayer < player.size()) {
            int rankedScore = ranked.get(indexRank);
            int playerScore = player.get(indexPlayer);
            Integer rank = null;

            if((rankedScore == playerScore) || (indexRank == 0 && rankedScore < playerScore))
                rank = rankNumber.get(rankedScore);
            else if(rankedScore > playerScore)
                rank = rankNumber.get(rankedScore) + 1;

            if(rank != null) {
                rankPosition.add(rank);
                indexPlayer++;
            } else {
                indexRank -= indexRank == 0 ? 0 : 1;
            }
        }
        return rankPosition;
    }

    private HashMap<Integer, Integer> createScoreRank(List<Integer> ranked) {
        int rank = 1;
        HashMap<Integer, Integer> rankNumber = new HashMap<>();
        for(Integer rankScore : ranked) {
            if(!rankNumber.containsKey(rankScore))
                rankNumber.put(rankScore, rank++);
        }
        return rankNumber;
    }
}
