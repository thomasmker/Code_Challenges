package com.thomashayashi.AppleOrangeFall;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class AppleOrangeFall {
    /*
     * The function accepts following parameters:
     *  1. INTEGER s - starting point of Sam's house location.
     *  2. INTEGER t - ending location of Sam's house location.
     *  3. INTEGER a - location of the Apple tree
     *  4. INTEGER b - location of the Orange tree.
     *  5. INTEGER_ARRAY apples - distances at which each apple falls from the tree
     *  6. INTEGER_ARRAY oranges - distances at which each orange falls from the tree
     */
    public NumberFruit countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        List<Integer> applesLocation = getFruitLocation(apples, a);
        List<Integer> orangesLocation = getFruitLocation(oranges, b);

        NumberFruit fruits = new NumberFruit();
        fruits.apples = getNumberOfFruitInsideHouse(applesLocation, s, t);
        fruits.oranges = getNumberOfFruitInsideHouse(orangesLocation, s, t);

        return fruits;
    }

    private static List<Integer> getFruitLocation(List<Integer> fallenFruit, int treePosition) {
        return fallenFruit.stream().map(fruit -> treePosition + fruit).collect(Collectors.toList());
    }

    private static int getNumberOfFruitInsideHouse(List<Integer> fruitLocation, int startHouse, int endHouse) {
        int fruits = 0;
        for(Integer appleLocation : fruitLocation)
            if(isWithinTheHouse(appleLocation, startHouse, endHouse)) fruits++;
        return fruits;
    }

    private static boolean isWithinTheHouse(Integer fruitLocation, int startHouse, int endHouse) {
        return fruitLocation >= startHouse && fruitLocation <= endHouse;
    }

    public static class NumberFruit {
        int apples = 0;
        int oranges = 0;
    }
}
