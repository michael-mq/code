package Algorithm.LeetCode.LeetCode_88_Merge_Sorted_Array;

public class Solution_MyOwn {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, index = 0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                res[index] = nums2[j];
                j++;
            } else if (nums1[i] <= nums2[j]) {
                res[index] = nums1[i];
                i++;
            }
            index++;
        }

        while (i < m) {
            res[index++] = nums1[i];
            i++;
        }

        while (j < n) {
            res[index++] = nums2[j];
            j++;
        }

        System.arraycopy(res, 0, nums1, 0, m + n);
    }

    public static void main(String[] args) {
        Solution_MyOwn foo = new Solution_MyOwn();

        foo.merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
