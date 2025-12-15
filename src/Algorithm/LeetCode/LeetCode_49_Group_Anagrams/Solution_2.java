package Algorithm.LeetCode.LeetCode_49_Group_Anagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://youtu.be/md032bqR22U?t=7388
class Solution_2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = encodeStr(strs[i]);

            List<String> list = map.computeIfAbsent(s, k -> new ArrayList<>());
            list.add(strs[i]);
        }

        List<List<String>> ans = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    private String encodeStr(String str) {
        int[] chars = new int[26];

        for (char c : str.toCharArray()) {
            chars[c - 'a']++;
        }

        String s = "";

        for (int i : chars) {
            s += i + "#";
        }

        return s;
    }
}
