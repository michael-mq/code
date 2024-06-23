package Algorithm.LeetCode.LeetCode_126_Word_Ladder_II;

import java.util.*;

//https://www.cspiration.com/#/course/video?courseId=26&superType=1&courseName=LeetCode%20题目视频讲解（1-300题分类顺序版）&userCourseId=2534
class Solution2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return res;
        }

        set.remove(beginWord);

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);

        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();

        qLoop:
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    break qLoop;
                }

                for (int j = 0; j < word.length(); j++) {
                    char arr[] = word.toCharArray();

                    for (int k = 'a'; k <= 'z'; k++) {
                        arr[j] = (char) k;
                        String str = new String(arr);

                        if (set.contains(str)) {
                            if (visited.add(str)) {
                                queue.add(str);
                            }

                            // Why? See dfs comment
                            List<String> list = map.computeIfAbsent(str, key -> new ArrayList<>());
                            list.add(word);
                        }
                    }
                }
            }

            set.removeAll(visited);
            visited.clear();
        }

        dfs(res, new ArrayList<>(), map, endWord, beginWord);

        return res;
    }

    // Why it should be from end to begin?
    // It will save unnecessary dfs, E.g: `dig` won't be queried. So only the paths to endWord will be queried from bottom to top
    //          hit
    //           |
    //          hot
    //         /   \
    //        dot  lot
    //         |    |
    //        dog  log
    //        / \  /
    //      dig  cog



    private void dfs(List<List<String>> res, List<String> path, Map<String, List<String>> map,
                     String word, String startWord) {
        if (word.equals(startWord)) {
            path.add(0, startWord);
            res.add(new ArrayList<>(path));
            path.remove(0);

            return;
        }

        path.add(0, word);

        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, path, map, s, startWord);
            }
        }

        path.remove(0);
    }
}
