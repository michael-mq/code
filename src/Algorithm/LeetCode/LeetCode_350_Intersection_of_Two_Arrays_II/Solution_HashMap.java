package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution_HashMap {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        // nums1.length < nums2.length
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] intersection = new int[nums1.length];

        int index = 0;

        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);

            if (count > 0) {
                intersection[index++] = num;
                count--;

                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        Solution_HashMap foo = new Solution_HashMap();

        System.out.println(Arrays.toString(foo.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

        System.out.println(Arrays.toString(foo.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
