package Algorithm.LeetCode.LeetCode_204_Count_Primes;

import java.util.Arrays;

// https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-bao-li-fa-ji-you-hua-shai-fa-ji-you/
class Solution {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;

                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return count;
    }
}
