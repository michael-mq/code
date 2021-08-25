package Algorithm.LeetCode.LeetCode_692_Top_K_Frequent_Words;

import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();

        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getValue() == b.getValue()) {
                        return a.getKey().compareTo(b.getKey());
                    }

                    return b.getValue() - a.getValue();
                });

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }

        for (int i = 0; i < k; i++) {
            res.add(maxHeap.poll().getKey());
        }

        return res;
    }
}
