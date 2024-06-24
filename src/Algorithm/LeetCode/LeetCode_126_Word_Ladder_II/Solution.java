package Algorithm.LeetCode.LeetCode_126_Word_Ladder_II;

import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/solutions/2424910/explanation-with-animation-accepted-without-tle
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // boolean value indicate visited
        Map<String, Boolean> wordDict = new HashMap<>();
        for (String word : wordList) {
            wordDict.put(word, false);
        }

        if (!wordDict.containsKey(endWord)) {
            return new ArrayList<>();
        }

        Queue<String> q = new LinkedList<>();
        // level of bfs
        List<List<String>> levels = new ArrayList<>();
        boolean reached = false;
        wordDict.remove(beginWord);
        q.offer(beginWord);

        qLoop:
        while (!q.isEmpty()) {
            int qSize = q.size();
            List<String> currentLevel = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                String curr = q.poll();
                currentLevel.add(curr);
                if (curr.equals(endWord)) {
                    reached = true;
                    break qLoop;
                }

                for (String word : wordDict.keySet()) {
                    boolean visited = wordDict.get(word);
                    if (visited || !isConnected(word, curr)) continue;

                    wordDict.put(word, true);
                    q.offer(word);
                }
            }
            levels.add(currentLevel);
        }
        if (!reached) {
            return new ArrayList<>();
        }

        LinkedList<String> endPath = new LinkedList<>();
        endPath.add(endWord);

        List<List<String>> paths = new ArrayList<>();
        paths.add(endPath);

        for (int i = levels.size() - 1; i >= 0; i--) {
            List<List<String>> tmpPaths = new ArrayList<>();
            List<String> currentLevel = levels.get(i);
            for (List<String> path : paths) {
                String curr = path.get(0);

                for (String word : currentLevel) {
                    if (!isConnected(word, curr)) continue;
                    LinkedList<String> newPath = new LinkedList<>(path);
                    newPath.addFirst(word);
                    tmpPaths.add(newPath);
                }
            }
            paths = tmpPaths;
        }
        return paths;
    }

    private boolean isConnected(String a, String b) {
        if (a.length() != b.length()) return false;
        int diffCount = 0;
        for (int i = 0; i < a.length() && diffCount < 2; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}
