package Algorithm.LeetCode.LeetCode_169_Majority_Element;

import java.util.Arrays;

public class Solution_Sorting {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        Solution_Sorting solution_hashMap = new Solution_Sorting();

        System.out.println(solution_hashMap.majorityElement(new int[]{3, 2, 3}));
        System.out.println(solution_hashMap.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
