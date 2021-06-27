package Algorithm.LeetCode.LeetCode_36_Valid_Sudoku;

// https://leetcode-cn.com/problems/valid-sudoku/solution/36-jiu-an-zhao-cong-zuo-wang-you-cong-shang-wang-x/

public class Solution_better {
    public boolean isValidSudoku(char[][] board) {
        // the 2nd level of array has 10 element because the max number is 9 as index meaning 10th element
        // row[x][0] is always empty because there is no number 0
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '0';
                int boxIndex = (i / 3) * 3 + j / 3;

                // if (row[i][num] + col[j][num] + box[boxIndex][num] >= 1) {
                if (row[i][num] == 1 || col[j][num] == 1 || box[boxIndex][num] == 1) {
                    return false;
                }

                row[i][num] = 1;
                col[j][num] = 1;
                box[boxIndex][num] = 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_better foo = new Solution_better();

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

        System.out.println(foo.isValidSudoku(board));

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(foo.isValidSudoku(board));
    }
}
