package Algorithm.LeetCode.LeetCode_29_Divide_Two_Integers;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;

        if (divisor == 1) return dividend;

        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) return -dividend;
            return Integer.MAX_VALUE;
        }

        boolean sign = (dividend < 0) ^ (divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long res = 0;

        while (a >= b) {
            long tempDivisor = b;
            long tempResult = 1;

            while (a >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                tempResult <<= 1;
            }

            res += tempResult;
            a -= tempDivisor;
        }

        if (sign) res = -res;

        if (res >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) res;
    }
}
