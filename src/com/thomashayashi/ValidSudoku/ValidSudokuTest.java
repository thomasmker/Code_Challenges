package com.thomashayashi.ValidSudoku;

import org.junit.jupiter.api.Test;


import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Full description: https://leetcode.com/problems/valid-sudoku/
 */
class ValidSudokuTest {
    @Test
    void checkValidSudoku() {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        assertTrue(isValidSudoku(board));
    }

    @Test
    void checkInvalidSudoku() {
        char[][] board = {
                {'8','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}
        };

        assertFalse(isValidSudoku(board));
    }

    private boolean isValidSudoku(char[][] board) {
        HashSet<String> h1 = new HashSet<>();

        for(int i=0; i < 9; i++){
            for(int j=0; j< 9; j++){
                if(board[i][j] != '.'){

                    //Check whether HashSet contains duplicate elements in row and column
                    if(h1.contains("row" + i + board[i][j]) || h1.contains("col" + j + board[i][j]) )
                        return false;

                    h1.add("row" + i + board[i][j]);
                    h1.add("col" + j + board[i][j]);


                    //Check whether Box contains duplicate elements in it
                    if(h1.contains("box"+ (i/3) + (j/3) + board[i][j]))
                        return false;

                    h1.add("box"+ (i/3) + (j/3) + board[i][j]);
                }
            }
        }


        return true;
    }
}
