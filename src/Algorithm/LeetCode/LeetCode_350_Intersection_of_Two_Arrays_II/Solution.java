package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int n : nums1) {
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }

        for (int n : nums2) {
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }

        for (int k : map1.keySet()) {
            if (map2.containsKey(k)) {
                int min = Math.min(map1.get(k), map2.get(k));

                for (int i = 0; i < min; i++) {
                    result.add(k);
                }
            }
        }

        return result.stream().mapToInt(n -> n).toArray();

    }
}