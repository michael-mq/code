package Algorithm.LeetCode.LeetCode_350_Intersection_of_Two_Arrays_II;

import java.util.Arrays;

public class Solution_Sorting {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int length1 = nums1.length, length2 = nums2.length;

        int[] intersection = new int[Math.min(length1, length2)];

        int index1 = 0, index2 = 0, index = 0;

        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        Solution_Sorting foo = new Solution_Sorting();

        System.out.println(Arrays.toString(foo.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));

        System.out.println(Arrays.toString(foo.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

}
