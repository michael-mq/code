package Algorithm.LeetCode.LeetCode_767_Reorganize_String;

import java.util.PriorityQueue;

class Solution {
    public String reorganizeString(String S) {
        int length = S.length();

        if (length < 2) {
            return S;
        }

        int[] counts = new int[26];
        int maxCount = 0;

        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }

        if (maxCount > (length + 1) / 2)
            return "";

        PriorityQueue<Character> queue = new PriorityQueue<Character>((a, b) -> counts[b - 'a'] - counts[a - 'a']);

        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();

            sb.append(letter1);
            sb.append(letter2);

            int index1 = letter1 - 'a';
            int index2 = letter2 - 'a';

            counts[index1]--;
            counts[index2]--;

            if (counts[index1] > 0) {
                queue.offer(letter1);
            }

            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }

        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}