package Algorithm.LeetCode.LeetCode_13_Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

class Solution_MyOwn {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int i = 0;
        int ans = 0;

        while (i < s.length()) {
            if (i < s.length() - 1) {
                String s1 = s.substring(i, i + 2);

                if (map.containsKey(s1)) {
                    ans += map.get(s1);
                    i++;
                    i++;
                    continue;
                }
            }

            String s2 = s.substring(i, i + 1);
            ans += map.get(s2);
            i++;
        }

        return ans;
    }
}
