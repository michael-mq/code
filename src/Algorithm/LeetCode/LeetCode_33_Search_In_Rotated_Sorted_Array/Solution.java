package Algorithm.LeetCode.LeetCode_33_Search_In_Rotated_Sorted_Array;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int peak_idx = findPeakIndex(nums);

        if (peak_idx >= 0 && target >= nums[0] && target <= nums[peak_idx]) {
            return binarySearch(nums, 0, peak_idx, target);
        } else {
            return binarySearch(nums, peak_idx + 1, nums.length - 1, target);
        }
    }

    private int findPeakIndex(int[] nums) {
        if (nums.length == 1) return 0;

        if (nums[0] < nums[nums.length - 1]) return nums.length - 1;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) return mid;

            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while(left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
