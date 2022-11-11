package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_TwoPointer {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;

        List<Integer> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return res.stream().mapToInt(n -> n).toArray();
    }

    public static void main(String[] args) {
        Solution_TwoPointer foo = new Solution_TwoPointer();

        System.out.println(Arrays.toString(foo.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

        System.out.println(Arrays.toString(foo.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
