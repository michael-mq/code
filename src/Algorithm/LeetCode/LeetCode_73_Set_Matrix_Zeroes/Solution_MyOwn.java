package Algorithm.LeetCode.LeetCode_73_Set_Matrix_Zeroes;

class Solution_MyOwn {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] originZeros = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    originZeros[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (originZeros[i][j]) {
                    for (int x = 0; x < m; x++) {
                        matrix[x][j] = 0;
                    }

                    for (int y = 0; y < n; y++) {
                        matrix[i][y] = 0;
                    }
                }
            }
        }
    }
}
