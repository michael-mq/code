package Algorithm.LeetCode.LeetCode_498_Diagonal_Traverse;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0)
            return new int[0];

        int row = 0;
        int col = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];

        for (int i = 0; i < m * n; i++) {
//            System.out.print(i + "," + row + "," + col + "   ");
            res[i] = mat[row][col];

            if ((row + col) % 2 == 0) {
                // when both (row == 0 && col == n - 1), it's on the top right conner
                // (col == n - 1) takes precedence
                if (col == n - 1) {
                    row++;
                } else if (row == 0) {
                    col++;
                } else {
                    row--;
                    col++;
                }
            } else { // same here
                if (row == m - 1) {
                    col++;
                } else if (col == 0) {
                    row++;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return res;
    }
}
