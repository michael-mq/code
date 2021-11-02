package Algorithm.Others.Substring;

import java.util.*;

public class Solution {
    public List<List<String>> printAllSubstrings_Partitioning_BackTracking(String s) {
        List<List<String>> result = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();

        dfs(s, 0, result, path);

        return result;
    }

    private void dfs(String s, int index, List<List<String>> result, Deque<String> path) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            System.out.print(Arrays.toString(path.toArray()) + " ");
        }

        for (int i = index; i < s.length(); i++) {
            path.addLast(s.substring(index, i + 1));

            dfs(s, i + 1, result, path);

            path.removeLast();
        }
    }

    public void printAllSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                System.out.print(s.substring(i, j + 1) + " ");
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.printAllSubstrings_Partitioning_BackTracking("aabaa");
        System.out.println();
        solution.printAllSubstrings("abba");
    }
}
