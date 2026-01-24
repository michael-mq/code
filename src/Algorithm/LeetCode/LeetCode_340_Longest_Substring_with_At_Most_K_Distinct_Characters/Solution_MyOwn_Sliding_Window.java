package Algorithm.LeetCode.LeetCode_340_Longest_Substring_with_At_Most_K_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution_MyOwn_Sliding_Window {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int ans = 0;

        while (j < length) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > k) {
                char d = s.charAt(i);
                map.put(d, map.get(d) - 1);

                if (map.get(d) == 0) {
                    map.remove(d);
                }

                i++;
            }

            ans = Math.max(ans, j - i + 1);
            j++;
        }

        return ans;
    }
}