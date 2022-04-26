package com.thomashayashi.LisaWorkbook;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/lisa-workbook/problem
 */
class LisaWorkbookTest {
    @Test
    void checkSpecialProblem(){
        assertEquals(1, workbook(2, List.of(3)));
        assertEquals(1, workbook(1, List.of(1)));
        assertEquals(1, workbook(2, List.of(1)));
        assertEquals(1, workbook(2, List.of(2)));
        assertEquals(2, workbook(1, List.of(2)));

        assertEquals(1, workbook(3, Arrays.asList(4,2)));
        assertEquals(4, workbook(3, Arrays.asList(4,2,6,1,10)));
    }

    private int workbook(int k, List<Integer> arr) {
        HashMap<Integer, HashSet<Integer>> pageProblems = getPageProblem(k, arr);
        return getSpecialProblemQuantity(pageProblems);
    }

    private HashMap<Integer, HashSet<Integer>> getPageProblem(int k, List<Integer> arr) {
        HashMap<Integer,HashSet<Integer>> pageProblems = new HashMap<>();
        int page = 1;
        for(Integer chapter : arr) {
            int problemNumber = 1;
            int chapterProblem = chapter;
            do {
                HashSet<Integer> problems = new HashSet<>();

                for (int i = 0; i < k; i++) {
                    if (problemNumber > chapterProblem) break;
                    problems.add(problemNumber++);
                }
                pageProblems.put(page, problems);
                page++;

            } while (problemNumber <= chapterProblem);
        }
        return pageProblems;
    }

    private int getSpecialProblemQuantity(HashMap<Integer, HashSet<Integer>> pageProblems) {
        int specialProblems = 0;
        for(Integer pageNumber : pageProblems.keySet()) {
            HashSet<Integer> problems = pageProblems.get(pageNumber);
            if(problems.contains(pageNumber))
                specialProblems++;
        }
        return specialProblems;
    }
}
