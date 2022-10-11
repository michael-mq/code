package Algorithm.LeetCode.LeetCode_74_Search_a_2D_Matrix;

class Solution_BS_Jiuzhang_Template {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int start = 0, end = m * n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int x = mid / n, y = mid % n;

            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[start / n][start % n] == target) {
            return true;
        }

        if (matrix[end / n][end % n] == target) {
            return true;
        }

        return false;
    }
}