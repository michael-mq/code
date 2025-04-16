package Algorithm.LeetCode.LeetCode_42_Trapping_Rain_Water;

//https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc
class Solution_DP {
    public int trap(int[] height) {
        int n = height.length;

        int[] left_max_arr = new int[n];
        int[] right_max_arr = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            left_max_arr[i] = max;
        }

        max = 0;

        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right_max_arr[i] = max;
        }

        int res = 0;

        for (int i = 0; i < n - 1; i++) {
            res += Math.min(left_max_arr[i], right_max_arr[i]) - height[i];
        }

        return res;
    }
}