package Algorithm.LeetCode.LeetCode_88_Merge_Sorted_Array;

public class Solution_Reverse {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;

        int i = nums1.length - 1;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[i--] = nums1[m--];
            } else {
                nums1[i--] = nums2[n--];
            }
        }

        while (i >= 0) {
            nums1[i--] = m == -1 ? nums2[n--] : nums1[m--];
        }
    }
}
