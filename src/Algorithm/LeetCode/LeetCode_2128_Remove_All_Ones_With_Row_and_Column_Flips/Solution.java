package Algorithm.LeetCode.LeetCode_2128_Remove_All_Ones_With_Row_and_Column_Flips;

// https://leetcode.com/problems/remove-all-ones-with-row-and-column-flips/discuss/1907860/Demonstration-with-full-explanation-Good-for-interview
class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++) {
            boolean same = true;
            boolean opposite = true;

            for (int j = 0; j < n; j++) {
                same &= grid[0][j] == grid[i][j];
                opposite &= grid[0][j] != grid[i][j];
            }

            if (!same && !opposite) {
                return false;
            }
        }

        return true;
    }
}