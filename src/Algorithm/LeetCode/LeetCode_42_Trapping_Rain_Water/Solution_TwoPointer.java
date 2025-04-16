package Algorithm.LeetCode.LeetCode_42_Trapping_Rain_Water;

//https://leetcode.cn/problems/trapping-rain-water/solutions/692342/jie-yu-shui-by-leetcode-solution-tuvc
//https://www.youtube.com/watch?v=bu1quf2rOp8
class Solution_TwoPointer {
    public int trap(int[] height) {
        int left_max = 0, right_max = 0;
        int left = 0, right = height.length - 1;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                left_max = Math.max(left_max, height[left]);
                ans += left_max - height[left];
                left++;
            } else {
                right_max = Math.max(right_max, height[right]);
                ans += right_max - height[right];
                right--;
            }
        }

        return ans;
    }
}