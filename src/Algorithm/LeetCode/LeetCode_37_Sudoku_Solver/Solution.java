package Algorithm.LeetCode.LeetCode_37_Sudoku_Solver;

import java.util.Arrays;

// https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode/

public class Solution {
    public void solveSudoku(char[][] board) {
        // 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
        boolean[][] rowUsed = new boolean[9][10];
        boolean[][] colUsed = new boolean[9][10];
        boolean[][][] boxUsed = new boolean[3][3][10];
        // 初始化
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int num = board[row][col] - '0';

                // This is to make sure we are only record numbers but not '.'s
                if (1 <= num && num <= 9) {
                    rowUsed[row][num] = true;
                    colUsed[col][num] = true;
                    boxUsed[row / 3][col / 3][num] = true;
                }
            }
        }
        // 递归尝试填充数组
        recursiveSolveSudoku(board, rowUsed, colUsed, boxUsed, 0, 0);
    }

    private boolean recursiveSolveSudoku(char[][] board, boolean[][] rowUsed, boolean[][] colUsed, boolean[][][] boxUsed, int row, int col) {
        // 边界校验, 如果已经填充完成, 返回true, 表示一切结束
        if (col == board[0].length) {
            if (row == board.length - 1) return true;

            // move to next row from col 0
            col = 0;
            row++;
        }

        // 是空则尝试填充, 否则跳过继续尝试填充下一个位置
        if (board[row][col] == '.') {
            // 尝试填充1~9
            for (int num = 1; num <= 9; num++) {
                // If not valid use next number
                if (rowUsed[row][num] || colUsed[col][num] || boxUsed[row / 3][col / 3][num]) {
                    continue;
                }
                ;

                rowUsed[row][num] = true;
                colUsed[col][num] = true;
                boxUsed[row / 3][col / 3][num] = true;

                board[row][col] = (char) ('0' + num);

                if (recursiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1)) {
                    return true;
                }

                // if failed, back track and clean up last step
                board[row][col] = '.';

                rowUsed[row][num] = false;
                colUsed[col][num] = false;
                boxUsed[row / 3][col / 3][num] = false;
            }
        } else {
            return recursiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1);
        }

        // if current try failed for all numbers at line 56: if (recursiveSolveSudoku(board, rowUsed, colUsed, boxUsed, row, col + 1))
        return false;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        foo.solveSudoku(board);

        System.out.println(Arrays.deepToString(board));
    }
}
