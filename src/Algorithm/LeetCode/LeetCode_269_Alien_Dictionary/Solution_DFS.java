package Algorithm.LeetCode.LeetCode_269_Alien_Dictionary;

import java.util.*;

//https://www.cspiration.com/#/course/video?courseId=26&superType=1&courseName=LeetCode%20题目视频讲解（1-300题分类顺序版）&userCourseId=2534
class Solution_DFS {
    public String alienOrder(String[] words) {
        Map<Character, Integer> visited = new HashMap<>();
        Map<Character, Set<Character>> graph = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                visited.putIfAbsent(c, 0);
                // Making sure every character is added
                graph.putIfAbsent(c, new HashSet<>());
            }
        }


        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            int len = Math.min(words[i].length(), words[i + 1].length());

            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);

                if (c1 != c2) {
                    Set<Character> set = graph.get(c1);
                    if (!set.contains(c2)) {
                        set.add(c2);
                    }

                    break;
                }
            }
        }

        StringBuilder res = new StringBuilder();

        for (char k : graph.keySet()) {
            if (!dfs(k, graph, visited, res)) {
                return "";
            }
        }

        return res.toString();
    }

    private boolean dfs(char c, Map<Character, Set<Character>> graph, Map<Character, Integer> visited, StringBuilder res) {
        if (visited.get(c) == 1) {
            return false;
        }

        if (visited.get(c) == -1) {
            return true;
        }

        visited.put(c, 1);

        if (graph.containsKey(c)) {
            for (char k : graph.get(c)) {
                if (!dfs(k, graph, visited, res)) {
                    return false;
                }
            }
        }

        visited.put(c, -1);
        res.insert(0, c);

        return true;
    }
}