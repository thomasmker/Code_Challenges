package com.thomashayashi.ArrayDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HourGlass {

    public static int hourglassSum(List<List<Integer>> arr) {
        List<List<Integer>> allHourGlasses = getHourGlassesValues(arr);

        List<Integer> hourGlassesSumValue = sumValueEachHourGlass(allHourGlasses);

        return Collections.max(hourGlassesSumValue);
    }

    private static List<Integer> sumValueEachHourGlass(List<List<Integer>> allHourGlasses) {
        return allHourGlasses.stream().map(HourGlass::sumHourGlassValues).collect(Collectors.toList());
    }

    private static int sumHourGlassValues(List<Integer> hourGlassValues) {
        return hourGlassValues.stream().mapToInt(Integer::intValue).sum();
    }

    public static List<List<Integer>> getHourGlassesValues(List<List<Integer>> arr) {
        List<List<Integer>> allHourGlassesValues = new ArrayList<>();

        for(int row = 0; row < arr.size(); row++) {
            if(row + 2 >= arr.size()) continue;

            List<Integer> topRow = arr.get(row);
            List<Integer> middleRow = arr.get(row+1);
            List<Integer> bottomRow = arr.get(row+2);

            for(int column = 0; column < topRow.size(); column ++) {
                if(column + 2 >= topRow.size()) continue;

                List<Integer> hourGlassValues = new ArrayList<>();
                hourGlassValues.add(topRow.get(column));
                hourGlassValues.add(topRow.get(column+1));
                hourGlassValues.add(topRow.get(column+2));

                hourGlassValues.add(middleRow.get(column+1));

                hourGlassValues.add(bottomRow.get(column));
                hourGlassValues.add(bottomRow.get(column+1));
                hourGlassValues.add(bottomRow.get(column+2));

                allHourGlassesValues.add(hourGlassValues);
            }
        }

        return allHourGlassesValues;
    }
}
