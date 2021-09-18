package Algorithm.LeetCode.LeetCode_128_Longest_Consecutive_Sequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int res = 0;

        for (int x : set) {
            if (!set.contains(x - 1)) {
                int y = x + 1;

                while (set.contains(y)) {
                    y++;
                }

                res = Math.max(res, y - x);
            }
        }

        return res;
    }
}
