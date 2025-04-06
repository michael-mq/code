package Algorithm.LeetCode.LeetCode_159_Longest_Substring_with_At_Most_Two_Distinct_Characters;

import java.util.HashMap;
import java.util.Map;

class Solution_MyOwn {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() == 1) {
            return 1;
        }

        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int l = 0, r = 1;

        map.put(s.charAt(l), 1);

        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() > 2) {
                c = s.charAt(l);
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) {
                    map.remove(c);
                }

                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}