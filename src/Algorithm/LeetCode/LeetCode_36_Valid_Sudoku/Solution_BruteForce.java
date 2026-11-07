package Algorithm.LeetCode.LeetCode_36_Valid_Sudoku;

class Solution_BruteForce {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    for (int k = 0; k < 9; k++) {
                        if (k != i && board[k][j] == board[i][j]) {
                            return false;
                        }
                    }

                    for (int k = 0; k < 9; k++) {
                        if (k != j && board[i][k] == board[i][j]) {
                            return false;
                        }
                    }

                    int _m = i / 3;
                    int _n = j / 3;

                    for (int k = _m * 3; k < _m * 3 + 3; k++) {
                        for (int l = _n * 3; l < _n * 3 + 3; l++) {
                            if (k != i && l != j && board[k][l] == board[i][j]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}