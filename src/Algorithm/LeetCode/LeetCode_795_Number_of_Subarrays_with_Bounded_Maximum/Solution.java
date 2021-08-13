package Algorithm.LeetCode.LeetCode_795_Number_of_Subarrays_with_Bounded_Maximum;

// https://www.youtube.com/watch?v=V8jAp1Zi1Os
public class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int pre = 0;
        int cnt = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                cnt = (i - pre + 1);
            } else {
                pre = i;
                cnt = 0;
            }
            // if (nums[i] < left), cnt = previous cnt
            res += cnt;
        }

        return res;
    }
}
