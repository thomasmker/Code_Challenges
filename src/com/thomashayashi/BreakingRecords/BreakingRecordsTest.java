package com.thomashayashi.BreakingRecords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
 */
class BreakingRecordsTest {
    @Test
    void checkBestAndWorstRecordsBreak() {
        assertEquals(Arrays.asList(0,0),breakingRecords(Collections.singletonList(0)));
        assertEquals(Arrays.asList(1,0),breakingRecords(Arrays.asList(1,2)));
        assertEquals(Arrays.asList(0,1),breakingRecords(Arrays.asList(2,1)));

        assertEquals(Arrays.asList(2,4),breakingRecords(Arrays.asList(10,5,20,20,4,5,2,25,1)));
        assertEquals(Arrays.asList(4,0),breakingRecords(Arrays.asList(3,4,21,36,10,28,35,5,24,42)));
    }

    public List<Integer> breakingRecords(List<Integer> scores) {
        int numBestRecordBreak = 0;
        int numWorstRecordBreak = 0;

        int bestRecord = scores.get(0);
        int worstRecord = scores.get(0);
        for(int i = 1; i < scores.size(); i++) {
            int currentGameScore = scores.get(i);
            if(currentGameScore > bestRecord){
                bestRecord = currentGameScore;
                numBestRecordBreak++;
            }else if(currentGameScore < worstRecord) {
                worstRecord = currentGameScore;
                numWorstRecordBreak++;
            }
        }

        return Arrays.asList(numBestRecordBreak, numWorstRecordBreak);
    }
}
