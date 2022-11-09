package Algorithm.LeetCode.LeetCode_242_Valid_Anagram;

import java.util.HashMap;
import java.util.Map;

class Solution_4 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (map.get(c) == null) {
                return false;
            }

            map.put(c, map.get(c) - 1);
        }

        for (Character k : map.keySet()) {
            if (map.get(k) != 0) {
                return false;
            }
        }

        return true;
    }
}