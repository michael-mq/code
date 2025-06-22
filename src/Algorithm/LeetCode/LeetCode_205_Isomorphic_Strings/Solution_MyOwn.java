package Algorithm.LeetCode.LeetCode_205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.Map;

class Solution_MyOwn {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                if (mapS.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                mapS.put(s.charAt(i), t.charAt(i));
            }

            if (mapT.containsKey(t.charAt(i))) {
                if (mapT.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                mapT.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}