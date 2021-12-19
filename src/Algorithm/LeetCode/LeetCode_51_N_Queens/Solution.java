package Algorithm.LeetCode.LeetCode_51_N_Queens;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/n-queens/discuss/19805/My-easy-understanding-Java-Solution/150112

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();

        if (n <= 0) {
            return result;
        }

        // build chessboard
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        helper(board, 0, result);

        return result;
    }

    private void helper(char[][] board, int row, List<List<String>> result) {
        // If it has reached the last row
        if (row == board.length) {
            result.add(build(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                helper(board, row + 1, result);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int x, int y) {
        // only check rows above current one
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 'Q' && (j == y || Math.abs(x - i) == Math.abs(y - j))) {
                    return false;
                }
            }
        }

        return true;
    }

    // build solution from temporary chessboard
    private List<String> build(char[][] board) {
        List<String> tmp = new LinkedList<>();

        for (int i = 0; i < board.length; i++) {
            String t = new String(board[i]);
            tmp.add(t);
        }

        return tmp;
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        List<List<String>> result = foo.solveNQueens(4);

        System.out.println(Arrays.toString(result.toArray()));
    }
}
