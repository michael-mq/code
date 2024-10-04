package Algorithm.LeetCode.LeetCode_162_Find_Peak_Element;

// https://youtu.be/IkQE4aN4zi0?t=2957
// https://leetcode.cn/problems/find-peak-element/solutions/998441/gong-shui-san-xie-noxiang-xin-ke-xue-xi-qva7v
public class Solution2 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] > nums[mid - 1]) {
                l = mid;
            } else {
                r = mid;
            }
        }

        return nums[l] > nums[r] ? l : r;
    }
}
