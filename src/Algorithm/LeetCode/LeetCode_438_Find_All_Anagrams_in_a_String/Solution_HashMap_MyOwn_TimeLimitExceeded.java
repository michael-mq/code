package Algorithm.LeetCode.LeetCode_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap_MyOwn_TimeLimitExceeded {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i), map.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> mapTemp = new HashMap<>();

            for (int j = i; j < p.length() + i && j < s.length(); j++) {
                mapTemp.put(s.charAt(j), mapTemp.getOrDefault(s.charAt(j), 0) + 1);
            }

            if (mapTemp.equals(map)) {
                result.add(i);
            }
        }

        return result;
    }
}
