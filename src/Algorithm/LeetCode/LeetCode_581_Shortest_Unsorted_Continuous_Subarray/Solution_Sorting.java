package Algorithm.LeetCode.LeetCode_581_Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

public class Solution_Sorting {
    public int findUnsortedSubarray(int[] nums) {
        int[] newNums = nums.clone();

        Arrays.sort(newNums);

        int start = nums.length;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != newNums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }

        return end >= start ? end - start + 1 : 0;
    }

    public static void main(String[] args) {
        Solution_Sorting solutionSorting = new Solution_Sorting();

        System.out.println(solutionSorting.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
