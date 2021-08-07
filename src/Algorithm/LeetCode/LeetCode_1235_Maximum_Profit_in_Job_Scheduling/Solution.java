package Algorithm.LeetCode.LeetCode_1235_Maximum_Profit_in_Job_Scheduling;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
    private final Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            // MUST sort by the ending time!!
            return a[1] == b[1] ? a[0] - b[0] : a[1] - b[1];
        }
    };

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        if (len == 0)
            return 0;

        List<int[]> jobs = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            jobs.add(new int[]{startTime[i], endTime[i], profit[i]});
        }

        jobs.sort(comparator);

        int[] prev = new int[len + 1];
        int[] dp = new int[len + 1];

        prev[0] = 0;
        prev[1] = 0;

        for (int i = 2; i <= len; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (jobs.get(i - 1)[0] >= jobs.get(j - 1)[1]) {
                    prev[i] = j;
                    break;
                }
            }
        }

        dp[1] = jobs.get(0)[2];

        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[prev[i]] + jobs.get(i - 1)[2]);
        }

        return dp[len];
    }

    public static void main(String[] args) {
        Solution foo = new Solution();

        int[] startTime = new int[]{1, 2, 3, 4, 6};
        int[] endTime = new int[]{3, 5, 10, 6, 9};
        int[] profit = new int[]{20, 20, 100, 70, 60};

        System.out.println(foo.jobScheduling(startTime, endTime, profit));
    }
}
