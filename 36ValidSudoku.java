/*
 * Determine if a Sudoku is valid, 
 * according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, 
 * where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily 
 * solvable. Only the filled cells need to be validated.
 */

import java.util.*;
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // column
        for(int i = 0; i < board[0].length; i++){
            HashSet<Character> col = new HashSet<Character>();
            for(int j = 0; j < board.length; j++){
                if(board[j][i]!='.' && !col.add(board[j][i])){
                    return false;
                }
            }
        }
        
        // row
        for(int i = 0; i<board.length; i++){
            HashSet<Character> row = new HashSet<Character>();
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])){
                    return false;
                }
            }
        }
        
        // sub-box
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                HashSet<Character> cube = new HashSet<Character>();
                for(int m = i*3; m < i*3+3; m++){
                    for(int n = j*3; n < j*3+3; n++){
                        if(board[m][n] != '.' && !cube.add(board[m][n])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}