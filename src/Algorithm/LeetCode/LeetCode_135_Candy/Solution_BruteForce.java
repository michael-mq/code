package Algorithm.LeetCode.LeetCode_135_Candy;

import java.util.Arrays;

class Solution_BruteForce {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);
        boolean hasChanged = true;

        while (hasChanged) {
            hasChanged = false;

            for (int i = 0; i < n; i++) {
                if (i < n - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    hasChanged = true;
                }

                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    hasChanged = true;
                }
            }
        }

        int ans = 0;

        for (int candy : candies) {
            ans += candy;
        }

        return ans;
    }
}