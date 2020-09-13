package Algorithm.LeetCode.LeetCode_438_Find_All_Anagrams_in_a_String;

import java.util.*;

public class Solution_HashMap_SlidingWindow_MyOwn {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapP = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            mapP.put(p.charAt(i), mapP.getOrDefault(p.charAt(i), 0) + 1);
        }

        for (int i = 0; i < p.length(); i++) {
            mapS.put(s.charAt(i), mapS.getOrDefault(s.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = p.length();

        while (j < s.length()) {
            if (mapP.equals(mapS)) {
                result.add(i);
            }

            if (mapS.containsKey(s.charAt(i))) {
                if (mapS.get(s.charAt(i)) > 1)
                    mapS.put(s.charAt(i), mapS.get(s.charAt(i)) - 1);
                else
                    mapS.remove(s.charAt(i));
            }

            mapS.put(s.charAt(j), mapS.getOrDefault(s.charAt(j), 0) + 1);

            i++;
            j++;
        }

        if (mapP.equals(mapS)) {
            result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution_HashMap_SlidingWindow_MyOwn foo = new Solution_HashMap_SlidingWindow_MyOwn();
        System.out.println(Arrays.toString(foo.findAnagrams("abab", "ab").toArray()));
    }
}
