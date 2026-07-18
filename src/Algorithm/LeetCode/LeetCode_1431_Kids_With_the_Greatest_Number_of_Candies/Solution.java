package Algorithm.LeetCode.LeetCode_1431_Kids_With_the_Greatest_Number_of_Candies;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>();

        int max = 0;

        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }

        for (int i = 0; i < candies.length; i++) {
            ans.add(candies[i] + extraCandies >= max);
        }

        return ans;
    }
}