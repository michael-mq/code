package Algorithm.LeetCode.LeetCode_128_Longest_Consecutive_Sequence;

import java.util.PriorityQueue;

class Solution_PriorityQueue_MyOwn {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int num : nums) {
            queue.offer(num);
        }

        int res = 0;
        int pre = queue.poll();
        int count = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == pre + 1) {
                count++;
            } else if (cur == pre) {
                continue;
            }else {
                res = Math.max(res, count);
                count = 1;
            }

            pre = cur;
        }

        return Math.max(res, count);
    }
}
