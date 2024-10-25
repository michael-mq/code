package Algorithm.LeetCode.LeetCode_410_Split_Array_Largest_Sum;
//https://youtu.be/IkQE4aN4zi0?t=4635
class Solution {
    public int splitArray(int[] nums, int k) {
        long left = 0;
        long right = 0;

        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }

        while (left + 1 < right) {
            long mid = (left + right) >> 1;

            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (check(nums, k, left)) {
            return (int) left;
        }

        return (int) right;
    }

    private boolean check(int[] nums, int m, long mid) {
        int index = 0;
        int parts = 0;

        while (index < nums.length) {
            long sum = 0;

            while (index < nums.length) {
                if (nums[index] > mid) {
                    return false;
                }

                sum += nums[index];

                if (sum > mid) {
                    break;
                }

                index++;
            }

            parts++;
        }

        if (parts > m) {
            return false;
        }

        return true;
    }
}