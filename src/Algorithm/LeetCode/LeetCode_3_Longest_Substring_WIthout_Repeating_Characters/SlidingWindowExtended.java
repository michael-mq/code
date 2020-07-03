package Algorithm.LeetCode.LeetCode_3_Longest_Substring_WIthout_Repeating_Characters;

import java.util.*;

public class SlidingWindowExtended {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }

            map.put(s.charAt(j), j);
            ans = Math.max(j - i + 1, ans);
        }

        return ans;
    }
}
