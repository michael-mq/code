package Algorithm.LeetCode.LeetCode_1004_Max_Consecutive_Ones_III;

class Solution {
    public int longestOnes(int[] A, int K) {
        int lo = 0, hi = 0;
        int preSum = 0;
        int n = A.length;
        int res = 0;

        for (hi = 0; hi < n; hi++) {
            preSum += A[hi] == 0 ? 1 : 0;

            if (preSum > K) {
                while (A[lo] == 1) {
                    lo++;
                }
                preSum--;
                lo++;
            }

            if (hi - lo + 1 > res) {
                res = hi - lo + 1;
            }
        }

        return res;
    }
}