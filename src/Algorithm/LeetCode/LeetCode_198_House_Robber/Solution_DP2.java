package Algorithm.LeetCode.LeetCode_198_House_Robber;

public class Solution_DP2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;

        if (length == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }

        return second;
    }

    public static void main(String[] args) {
        Solution_DP2 foo = new Solution_DP2();

        System.out.println(foo.rob(new int[]{1, 3, 1, 3, 100}));
    }
}
