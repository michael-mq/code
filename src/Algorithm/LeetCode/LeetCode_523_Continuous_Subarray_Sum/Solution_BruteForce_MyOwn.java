package Algorithm.LeetCode.LeetCode_523_Continuous_Subarray_Sum;

public class Solution_BruteForce_MyOwn {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int sum = nums[i];

            for (int j = i + 1; j < len; j++) {
                sum += nums[j];
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_BruteForce_MyOwn foo = new Solution_BruteForce_MyOwn();

        System.out.println(foo.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
        System.out.println(foo.checkSubarraySum(new int[]{0, 1, 0}, 0));
        System.out.println(foo.checkSubarraySum(new int[]{0}, 0));
    }
}
