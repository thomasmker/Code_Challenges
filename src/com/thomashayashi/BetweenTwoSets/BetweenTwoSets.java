package com.thomashayashi.BetweenTwoSets;

import java.util.Collections;
import java.util.List;

public class BetweenTwoSets {
    public static int getTotalX(List<Integer> numberFactors, List<Integer> factoredByNumber){
        Integer minFactor = getMinValue(numberFactors);
        Integer minFactored = getMinValue(factoredByNumber);

        int possibleNumbers = 0;
        for(int num = minFactor; num <= minFactored; num++)
            possibleNumbers+= isFactoredAndAFactor(numberFactors, factoredByNumber, num) ? 1 : 0;

        return possibleNumbers;
    }

    private static boolean isFactoredAndAFactor(List<Integer> numberFactors, List<Integer> factoredByNumber, int number) {
        return (isFactoredByAll(numberFactors, number) && isFactorOfAll(factoredByNumber,number));
    }

    private static boolean isFactoredByAll(List<Integer> numberFactors, int number) {
        return numberFactors.stream().allMatch(factor -> number % factor == 0);
    }

    private static boolean isFactorOfAll(List<Integer> factoredByNumber, int factor) {
        return factoredByNumber.stream().allMatch(number -> number % factor == 0);
    }

    private static Integer getMinValue(List<Integer> list) {
        return Collections.min(list);
    }
}
