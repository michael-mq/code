package Algorithm.LeetCode.LeetCode_153_Find_Minimum_in_Rotated_Sorted_Array;

public class Solution_MyOwn {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[left] < nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
                return left;
            } else if (nums[left] == nums[mid]) {
                return nums[left] > nums[right] ? right : left;
            }
        }

        return left;
    }
}
