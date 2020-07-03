package Algorithm.LeetCode.LeetCode_3_Longest_Substring_WIthout_Repeating_Characters;

import java.util.*;

public class SlidingWindow {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;

        for (int i = 0, j = 0; j < n; j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            ans = Math.max(ans, set.size());
        }

        return ans;
    }
}
