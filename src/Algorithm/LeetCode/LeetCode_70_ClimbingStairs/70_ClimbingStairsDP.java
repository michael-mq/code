package Algorithm.LeetCode.LeetCode_70_ClimbingStairs;

class ClimbingStairsDP_70 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}

class ClimbingStairsDPMain_70 {
    public static void main(String[] args) {
        ClimbingStairsDP_70 climbingStairsDP_70 = new ClimbingStairsDP_70();

        System.out.println(climbingStairsDP_70.climbStairs(1));
    }
}