package Algorithm.LeetCode.LeetCode_581_Shortest_Unsorted_Continuous_Subarray;

public class Solution_O1 {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        boolean flag = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1])
                flag = true;
            if (flag)
                min = Math.min(min, nums[i]);
        }

        flag = false;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1])
                flag = true;
            if (flag)
                max = Math.max(max, nums[i]);
        }

        int l, r;

        for (l = 0; l < nums.length; l++) {
            if (min < nums[l])
                break;
        }

        for (r = nums.length - 1; r >= 0; r--) {
            if (max > nums[r])
                break;
        }

        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Solution_O1 solutionSorting = new Solution_O1();

        System.out.println(solutionSorting.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
