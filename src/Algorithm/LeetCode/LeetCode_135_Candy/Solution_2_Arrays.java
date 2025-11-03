package Algorithm.LeetCode.LeetCode_135_Candy;

import java.util.Arrays;

class Solution_2_Arrays {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];

        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1] && left2right[i] <= left2right[i - 1]) {
                left2right[i] = left2right[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && right2left[i] <= right2left[i + 1]) {
                right2left[i] = right2left[i + 1] + 1;
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans += Math.max(left2right[i], right2left[i]);
        }

        return ans;
    }
}