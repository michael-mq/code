package Algorithm.LeetCode.LeetCode_81_Search_in_Rotated_Sorted_Array_II;

// https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/solution/sou-suo-xuan-zhuan-pai-xu-shu-zu-ii-by-l-0nmp/
class Solution_BS_Jiuzhang_Template {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // because we have to rely on start to check if the left or right side is ascending
            // so we have to keep moving the start until it's not the same as mid anymore
            if (nums[start] == nums[mid]) {
                start++;
            } else if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return true;
        }

        if (nums[end] == target) {
            return true;
        }

        return false;
    }
}