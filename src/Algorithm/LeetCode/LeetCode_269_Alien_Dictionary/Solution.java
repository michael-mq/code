package Algorithm.LeetCode.LeetCode_269_Alien_Dictionary;

import java.util.*;

//https://www.cspiration.com/#/course/video?courseId=26&superType=1&courseName=LeetCode%20题目视频讲解（1-300题分类顺序版）&userCourseId=2534
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.putIfAbsent(c, 0);
            }
        }

        Map<Character, Set<Character>> graph = new HashMap<>();

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            // WHY?
            // The input can contain words followed by their prefix, for example, abcd and then ab.
            // These cases will never result in a valid alphabet
            // (because in a valid alphabet prefixes are always first).
            // You'll need to make sure your solution detects these cases correctly.
            // https://leetcode.com/problems/alien-dictionary/editorial/
            //            "ab" should be in front of "abc" by lexicographically
            //            Input
            //            words =
            //            ["abc","ab", "cd", "de"]
            //            Output
            //            ""
            //            Expected
            //            ""
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int len = Math.min(words[i].length(), words[i + 1].length());

            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    Set<Character> set = graph.computeIfAbsent(c1, k -> new HashSet<>());
                    if (!set.contains(c2)) {
                        set.add(c2);
                        inDegree.merge(c2, 1, Integer::sum);
                    }

                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (char k : inDegree.keySet()) {
            if (inDegree.get(k) == 0) {
                queue.add(k);
                res.append(k);
            }
        }

        while (!queue.isEmpty()) {
            char k = queue.poll();

            if (graph.containsKey(k)) {
                for (char v : graph.get(k)) {
                    inDegree.merge(v, -1, Integer::sum);

                    if (inDegree.get(v) == 0) {
                        queue.add(v);
                        res.append(v);
                    }
                }
            }

        }

        for (char k : inDegree.keySet()) {
            if (inDegree.get(k) != 0) {
                return "";
            }
        }

        // if (inDegree.size() != res.length()) {
        //     return "";
        // }

        return res.toString();
    }
}