package Algorithm.LeetCode.LeetCode_1235_Maximum_Profit_in_Job_Scheduling;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/maximum-profit-in-job-scheduling/solution/c-dong-tai-gui-hua-xiang-jie-by-csdu-gou/

class Solution_DP1 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return profit[0];
        }

        List<int[]> jobs = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            jobs.add(new int[] {startTime[i], endTime[i], profit[i]});
        }

        jobs.sort((a, b) -> a[1] - b[1]);

        int[] prev = new int[len + 1];
        int[] dp = new int[len + 1];

        for (int i = 2; i < len + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (jobs.get(j - 1)[1] <= jobs.get(i - 1)[0]) {
                    prev[i] = j;
                    break;
                }
            }
        }

        dp[1] = jobs.get(0)[2];

        for (int i = 2; i < len + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[prev[i]] + jobs.get(i - 1)[2]);
        }

        return dp[len];
    }
}
