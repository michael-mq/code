package Algorithm.LeetCode.LeetCode_819_Most_Common_Word;

import java.util.*;

class Solution_MyOwn {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < paragraph.length()) {
            if (!Character.isLetter(paragraph.charAt(i))) {
                if (sb.length() != 0) {
                    map.put(sb.toString().toLowerCase(), map.getOrDefault(sb.toString().toLowerCase(), 0) + 1);
                    sb = new StringBuilder();
                }
            } else {
                sb.append(paragraph.charAt(i));
            }

            i++;
        }

        if (sb.length() != 0) {
            map.put(sb.toString().toLowerCase(), map.getOrDefault(sb.toString().toLowerCase(), 0) + 1);
        }

        for (String s : banned) {
            map.remove(s);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((a, b) -> {
            return a.getValue() - b.getValue();
        });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);

            while (minHeap.size() > 1) {
                minHeap.poll();
            }
        }

        return minHeap.peek().getKey().toLowerCase();
    }
}
