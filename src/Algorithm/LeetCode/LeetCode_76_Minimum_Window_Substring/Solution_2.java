package Algorithm.LeetCode.LeetCode_76_Minimum_Window_Substring;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/editorial/#approach-2-optimized-sliding-window
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class Solution_2 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            int n = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), n + 1);
        }

        int required = dictT.size();

        List<Pair<Integer, Character>> filteredS = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (dictT.containsKey(s.charAt(i))) {
                filteredS.add(new Pair(i, s.charAt(i)));
            }
        }

        int l = 0, r = 0, formed = 0;
        int[] ans = {Integer.MAX_VALUE, 0, 0};

        Map<Character, Integer> windowCounts = new HashMap<>();

        while (r < filteredS.size()) {
            char c = filteredS.get(r).getValue();
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                int start = filteredS.get(l).getKey();
                int end = filteredS.get(r).getKey();

                if (end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                char d = filteredS.get(l).getValue();

                windowCounts.put(d, windowCounts.get(d) - 1);

                if (windowCounts.get(d).intValue() < dictT.get(d).intValue()) {
                    formed--;
                }


                l++;
            }

            r++;
        }

        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}