package Algorithm.LeetCode.CN.Offer_03;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            if (map.containsKey(n)) {
                return n;
            }

            map.put(n, 1);
        }

        return -1;
    }
}