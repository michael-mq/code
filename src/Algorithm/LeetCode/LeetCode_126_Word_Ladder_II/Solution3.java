package Algorithm.LeetCode.LeetCode_126_Word_Ladder_II;

import java.util.*;

// Not the best Solution, see the comments in the code
//https://www.cspiration.com/#/course/video?courseId=26&superType=1&courseName=LeetCode%20题目视频讲解（1-300题分类顺序版）&userCourseId=2534
class Solution3 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.isEmpty()) return res;

        int curNum = 1;
        int nextNum = 0;
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> unvisited = new HashSet<>(wordList);
        // Should remove the beginWord, to save the self to self map
        // unvisited.remove(beginWord);

        //        beginWord:"a"
        //        endWord:"c"
        //        wordList:["a","b","c"]
        //        res:[]
        //        curNum:0
        //        nextNum:3
        //        found:true
        //        queue:["a","b","c"]
        //        unvisited:[a, b, c]
        //        visited:[a, b, c]
        //        map:{"a":["a"],"b":["a"],"c":["a"]}

        HashSet<String> visited = new HashSet<>();

        HashMap<String, List<String>> map = new HashMap<>();

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (unvisited.contains(newWord)) {
                        if (visited.add(newWord)) {
                            nextNum++;
                            queue.offer(newWord);
                        }
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new ArrayList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        if (newWord.equals(endWord)) {
                            found = true;
                            // It can be broken now to save more loops
                            // break;
                        }
                    }
                }
            }

            if (curNum == 0) {
                if (found) break;
                curNum = nextNum;
                nextNum = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }

        dfs(res, new ArrayList<>(), map, endWord, beginWord);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, Map<String, List<String>> map,
                     String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<>(list));
            list.remove(0);

            return;
        }

        list.add(0, word);

        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, list, map, s, start);
            }
        }

        list.remove(0);
    }
}
