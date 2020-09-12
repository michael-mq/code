package Algorithm.LeetCode.LeetCode_621_Task_Scheduler;
// https://leetcode-cn.com/problems/task-scheduler/solution/621-ren-wu-diao-du-qi-java-jie-ti-zhu-shi-ying-gai/

import java.util.Arrays;

public class Solution_Greedy {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;

        if (len <= 1 || n == 0) {
            return len;
        }

        int result = 0;

        int[] arr = new int[26];

        for (int i = 0; i < len; i++) {
            arr[tasks[i] - 'A']++;
        }

        Arrays.sort(arr);

        int maxCount = arr[25];

        result = (maxCount - 1) * (n + 1) + 1;

        int i = 24;
        while (i >=0 && arr[i] == maxCount) {
            result++;
            i--;
        }

        return Math.max(result, len);
    }
}
