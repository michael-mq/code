package Algorithm.LeetCode.LeetCode_127_Word_Ladder;

import java.util.*;

// https://leetcode.com/problems/word-ladder/solutions/1764371/a-very-highly-detailed-explanation
// https://www.cspiration.com/#/course/video?courseId=26&superType=1&courseName=LeetCode%20题目视频讲解（1-300题分类顺序版）&userCourseId=2534
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        set.remove(beginWord);
        int level = 0;

        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                for (int j = 0; j < word.length(); j++) {
                    char[] arr = word.toCharArray();

                    for (int k = 'a'; k <= 'z'; k++) {
                        arr[j] = (char) k;
                        String str = new String(arr);

                        if (set.contains(str)) {
                            queue.add(str);
                            set.remove(str);
                        }
                    }
                }
            }
        }

        return 0;
    }
}