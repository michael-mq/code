package Algorithm.LeetCode.LeetCode_347_Top_K_Frequent_Elements;

import java.util.*;

class Solution_MyOwn {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, ++count);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((i, j) -> j.getValue() - i.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}