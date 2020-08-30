package Algorithm.LeetCode.LeetCode_198_House_Robber;

class HouseRoberDP_198 {
    public int rob(int[] nums) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = nums[i] + dp[i - 2];
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len-1];
    }
}

class HouseRoberDPMain_198 {
    public static void main(String[] args) {
        HouseRoberDP_198 foo = new HouseRoberDP_198();

        System.out.println(foo.rob(new int[]{1, 3, 1, 3, 100}));
    }
}
