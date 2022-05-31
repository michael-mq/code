package Algorithm.LeetCode.LeetCode_347_Top_K_Frequent_Elements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int count = map.getOrDefault(n, 0);
            map.put(n, ++count);
        }

        Queue<Integer> queue = new PriorityQueue<>((i, j) -> map.get(i) - map.get(j));

        for (int key : map.keySet()) {
            queue.add(key);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;
    }
}