package Algorithm.LeetCode.LeetCode_48_Rotate_Image;
// https://leetcode.com/problems/rotate-image/editorial/#approach-2-reverse-on-the-diagonal-and-then-reverse-left-to-right

class Solution2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            int j = 0, k = n - 1;

            while (j < k) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = tmp;
                j++;
                k--;
            }
        }
    }
}