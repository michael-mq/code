package Algorithm.LeetCode.LeetCode_387_First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.Map;

class Solution_HashMap {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }

        return -1;
    }
}