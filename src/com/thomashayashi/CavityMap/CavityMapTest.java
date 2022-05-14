package com.thomashayashi.CavityMap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * Full description: https://www.hackerrank.com/challenges/cavity-map/problem
 */
class CavityMapTest {
    @Test
    void checkCavities(){
        assertEquals(Arrays.asList("989","1X1","111"), cavityMap(Arrays.asList("989","191","111")));
        assertEquals(Arrays.asList("1112","1X12","18X2","1234"), cavityMap(Arrays.asList("1112", "1912", "1892", "1234")));
    }

    private List<String> cavityMap(List<String> grid) {
        int n = grid.get(0).length();
        int[][] map = new int[n][n];
        for(int row = 0; row < n; row++){
            char[] depths = grid.get(row).toCharArray();
            for(int column = 0; column < n; column++)
                map[row][column] = Character.getNumericValue(depths[column]);
        }

        for(int i=1; i<n-1; i++){
            for(int j=1; j<n-1; j++){
                if(isMaximum(map, i, j))
                    map[i][j] = -1;
            }
        }

        List<String> maps = new ArrayList<>();
        for(int i=0; i < n; i++){
            StringBuilder row = new StringBuilder();
            for(int j=0; j < n; j++)
                row.append(map[i][j] == -1 ? "X" : String.valueOf(map[i][j]));
            maps.add(row.toString());
        }
        return maps;
    }

    private boolean isMaximum(int[][] array, int i, int j) {
        int max = Math.max(Math.max(array[i-1][j], array[i+1][j]), Math.max(array[i][j-1], array[i][j+1]));
        return (max < array[i][j]);
    }
}
