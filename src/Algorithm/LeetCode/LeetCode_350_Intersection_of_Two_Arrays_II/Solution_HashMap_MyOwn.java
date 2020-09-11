package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap_MyOwn {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }

        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        for (Map.Entry entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                int n = Math.min(map2.get(entry.getKey()), (Integer) entry.getValue());
                for (int i = 0; i < n; i++) {
                    res.add((Integer) entry.getKey());
                }
            }
        }

        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution_HashMap_MyOwn foo = new Solution_HashMap_MyOwn();

        System.out.println(Arrays.toString(foo.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

        System.out.println(Arrays.toString(foo.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
