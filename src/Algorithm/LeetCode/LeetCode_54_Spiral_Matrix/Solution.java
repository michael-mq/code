package Algorithm.LeetCode.LeetCode_54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int column = left; column <= right; column++) {
                res.add(matrix[top][column]);
            }

            if (++top > bottom) {
                break;
            }

            for (int row = top; row <= bottom; row++) {
                res.add(matrix[row][right]);
            }

            if (--right < left) {
                break;
            }

            for (int column = right; column >= left; column--) {
                res.add(matrix[bottom][column]);
            }

            if (--bottom < top) {
                break;
            }

            for (int row = bottom; row >= top; row--) {
                res.add(matrix[row][left]);
            }

            if (++left > right) {
                break;
            }
        }

        return res;
    }
}
