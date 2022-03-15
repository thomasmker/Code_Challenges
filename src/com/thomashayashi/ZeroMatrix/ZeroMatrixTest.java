package com.thomashayashi.ZeroMatrix;

import org.junit.jupiter.api.Test;

/* Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.*/
class ZeroMatrixTest {
    @Test
    void checkZerosInMatrix() {
    }

    void setZerosBookSolution(int[][] matrix){
        if(matrix == null) return;

        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for(int i = 0; i < row.length; i++) {
            if(row[i]) nullifyRow(matrix, i);
        }

        for(int j = 0; j < column.length; j++) {
            if(column[j]) nullifyColumn(matrix, j);
        }
    }

    private void nullifyRow(int[][] matrix, int row) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private void nullifyColumn(int[][] matrix, int column) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}
