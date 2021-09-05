package Algorithm.LeetCode.LeetCode_215_Kth_Largest_Element_in_an_Array;

import java.util.Arrays;

public class Solution_Sort {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        int counter = 1;
        int cur = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0 && counter < k; i--) {
            if (nums[i] <= cur) {
                counter++;

                if (counter == k) {
                    return nums[i];
                }
            }

            cur = nums[i];
        }

        return cur;
    }
}
