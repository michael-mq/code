package Algorithm.LeetCode.LeetCode_387_First_Unique_Character_in_a_String;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution_Map {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
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
