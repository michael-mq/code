package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap_MyOwn1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.computeIfAbsent(nums1[i], k -> 0) + 1);
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];

            if (map.containsKey(cur) && map.get(cur) > 0) {
                res.add(cur);
                map.put(cur, map.get(cur) - 1);
            }
        }

        return res.stream().mapToInt(n -> n).toArray();
    }
}
