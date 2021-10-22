package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_HashMap_MyOwn1 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for (int m : nums1) {
            map.put(m, map.getOrDefault(m, 0) + 1);
        }

        for (int n : nums2) {
            if (map.containsKey(n) && map.get(n) > 0) {
                res.add(n);
                map.put(n, map.get(n) - 1);
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
