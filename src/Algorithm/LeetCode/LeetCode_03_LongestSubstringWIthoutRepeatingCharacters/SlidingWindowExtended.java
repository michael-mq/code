package Algorithm.LeetCode.LeetCode_03_LongestSubstringWIthoutRepeatingCharacters;

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
