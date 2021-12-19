package Algorithm.DailyAlgo.DailyAlgo_Pick_a_Sign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int numSignWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return helper(0, 0, nums, target, new ArrayList<>(), new int[nums.length]);
    }

    private int helper(int step, int sum, int[] nums, int target, List<int[]> result, int[] arr) {
        if (step == nums.length) {
            if (sum == target) {
                result.add(Arrays.copyOf(arr, arr.length));
                System.out.println(Arrays.toString(arr));
                return 1;
            }

            return 0;
        }

        arr[step] = nums[step];

        int positiveMatches = helper(step + 1, sum + nums[step], nums, target, result, arr);

        arr[step] = -nums[step];
        int negativeMatches = helper(step + 1, sum - nums[step], nums, target, result, arr);

        return positiveMatches + negativeMatches;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSignWays(new int[]{2, 1, 3, 2}, 4));
        System.out.println(solution.numSignWays(new int[]{2, 1, 3, 2}, 2));

    }

}
