package Algorithm.LeetCode.LeetCode_48_Rotate_Image;
//https://www.youtube.com/watch?v=9ryIfj5DohI

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null && matrix.length == 0) {
            return;
        }

        int n = matrix.length;

        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int left = 0;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                int temp = matrix[top][left + i];

                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }

            n -= 2;
            top++;
            right--;
            bottom--;
            left++;
        }
    }
}
