package Algorithm.LeetCode.LeetCode_88_Merge_Sorted_Array;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 设置三个指针
        int i = m - 1;      // nums1 的有效末尾
        int j = n - 1;      // nums2 的末尾
        int p = m + n - 1;  // nums1 的实际末尾

        // 从后向前遍历，直到其中一个数组遍历完
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }

        // 如果 nums2 还有剩余（nums1 剩余则无需处理）
        // 例如 nums1 = [4,5,6,0,0,0], nums2 = [1,2,3]
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
}