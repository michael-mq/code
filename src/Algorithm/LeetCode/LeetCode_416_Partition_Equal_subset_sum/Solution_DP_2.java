package Algorithm.LeetCode.LeetCode_416_Partition_Equal_subset_sum;

//https://www.programmercarl.com/0416.分割等和子集.html
public class Solution_DP_2 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        int[] dp = new int[target + 1];

        for (int i = 0; i < len; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);

                // My own idea: regardless the size of the bag, as long as it contains the half of the total, it's true
                if (dp[j] == target) {
                    return true;
                }

//                //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
//                if(dp[target] == target)
//                    return true;
            }
        }

        return false;
    }
}
