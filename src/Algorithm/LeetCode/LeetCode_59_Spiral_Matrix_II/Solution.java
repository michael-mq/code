package Algorithm.LeetCode.LeetCode_59_Spiral_Matrix_II;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        if (n == 0) {
            return matrix;
        }

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int i = 1;

        while (true) {
            for (int column = left; column <= right; column++) {
                matrix[top][column] = i++;
            }

            if (++top > bottom) {
                break;
            }

            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = i++;
            }

            if (--right < left) {
                break;
            }

            for (int column = right; column >= left; column--) {
                matrix[bottom][column] = i++;
            }

            if (--bottom < top) {
                break;
            }

            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = i++;
            }

            if (++left > right) {
                break;
            }
        }

        return matrix;
    }
}
