package Algorithm.LeetCode.LeetCode_681_Next_Closest_Time;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/next-closest-time/editorial
class Solution {
    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        Set<Integer> allowed = new HashSet<>();
        for (char c : time.toCharArray())
            if (c != ':') {
                allowed.add(c - '0');
            }

        while (true) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            search:
            {
                for (int d : digits) {
                    if (!allowed.contains(d)) {
                        break search;
                    }
                }
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
    }
}