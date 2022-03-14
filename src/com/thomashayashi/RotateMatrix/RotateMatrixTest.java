package com.thomashayashi.RotateMatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/*Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?*/
class RotateMatrixTest {
    @Test
    void checkRotatedMatrix() {
    }

    boolean rotateBookSolution(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;
        for(int layer = 0; layer < n/2; layer++) {
            int last = n - 1 - layer;
            for(int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i]; // save top
                matrix[layer][i] = matrix[last - offset][layer]; // left -> top;
                matrix[last - offset][layer] = matrix[last][last - offset]; // bottom -> left
                matrix[last][last - offset] = matrix[i][last]; // right -> bottom
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }
}
