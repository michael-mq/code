package Algorithm.LeetCode.LeetCode_49_Group_Anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_MyOwn {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);

            String sortedString = new String(charArray);

            List<Integer> list;

            if (map.containsKey(sortedString)) {
                list = map.get(sortedString);
            } else {
                list = new ArrayList<>();
            }

            list.add(i);

            map.put(sortedString, list);
        }

        for (List<Integer> value : map.values()) {
            List<String> s = new ArrayList<>();

            for (int i : value) {
                s.add(strs[i]);
            }

            res.add(s);
        }

        return res;
    }
}


//class Solution {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<>();
//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String str : strs) {
//            char[] charArr = str.toCharArray();
//            Arrays.sort(charArr);
//            String sortedStr = new String(charArr);
//            List<String> list = map.computeIfAbsent(sortedStr, k -> new ArrayList<>());
//            list.add(str);
//        }
//
//        res = new ArrayList<>(map.values());
//
//        return res;
//    }
//}