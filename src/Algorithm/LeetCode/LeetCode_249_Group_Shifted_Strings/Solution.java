package Algorithm.LeetCode.LeetCode_249_Group_Shifted_Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String s : strings) {
            List<String> list = map.computeIfAbsent(hash(s), k -> new ArrayList<>());
            list.add(s);
        }

        result.addAll(map.values());
        
        return result;
    }

    private String hash(String s) {
        int dist = s.charAt(0) - 'a';
        char[] arr = new char[s.length()];

        arr[0] = 'a';

        for (int i = 1; i < s.length(); i++) {
            char c = (char) (s.charAt(i) - dist);

            if (c < 'a') {
                c += 26;
            }

            arr[i] = c;
        }

        return new String(arr);
    }
}