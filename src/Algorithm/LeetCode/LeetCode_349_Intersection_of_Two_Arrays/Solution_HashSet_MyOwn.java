package Algorithm.LeetCode.LeetCode_349_Intersection_of_Two_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet_MyOwn {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                resSet.add(nums2[i]);
            }
        }

        return resSet.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution_HashSet_MyOwn foo = new Solution_HashSet_MyOwn();

        System.out.println(Arrays.toString(foo.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }
}
