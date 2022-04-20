package com.thomashayashi.PlusMinus;

import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/one-week-preparation-kit-plus-minus/problem
 */
class PlusMinusTest {
    @Test
    void checkRatios(){
        assertEquals(Arrays.asList("0.400000","0.400000","0.200000"), plusMinus(Arrays.asList(-2,-1,0,1,2)));
        assertEquals(Arrays.asList("0.333333","0.333333","0.333333"), plusMinus(Arrays.asList(-1,0,1)));
    }

    private List<String> plusMinus(List<Integer> arr) {
        int positive = 0, negative = 0, zeros = 0;
        int total = arr.size();

        for(Integer n : arr) {
            if(n > 0)
                positive++;
            else if(n < 0)
                negative++;
            else
                zeros++;
        }

        DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
        otherSymbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("", otherSymbols);
        df.setMinimumFractionDigits(6);
        df.setMaximumFractionDigits(6);
        df.setMinimumIntegerDigits(1);

        List<String> ratios = new ArrayList<>();
        ratios.add(df.format((double)positive / total));
        ratios.add(df.format((double)negative / total));
        ratios.add(df.format((double)zeros / total));
        return ratios;
    }
}
