package Algorithm.LeetCode.LeetCode_35_Search_Insert_Position;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target || nums[start] > target) {
            return start;
        }

        if (nums[end] == target || nums[end] > target) {
            return end;
        } else if (nums[end] < target) {
            return end + 1;
        }

        return -1;
    }
}
