package Algorithm.LeetCode.LeetCode_29_Divide_Two_Integers;

class Solution {
    public int divide(int dividend, int divisor) {
        // 1. 特殊溢出判断
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 2. 转换为 long 处理绝对值
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);

        // 3. 记录符号
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long res = 0;
        // 4. 核心逻辑：倍增法
        while (lDividend >= lDivisor) {
            long temp = lDivisor;
            long multiple = 1;

            // 只要翻倍后还不超过被除数，就继续翻倍
            // temp << 1 相当于 temp * 2
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // 减去这部分，并累加对应的商
            lDividend -= temp;
            res += multiple;
        }

        // 5. 根据符号返回结果，并强转回 int
        return isNegative ? (int) -res : (int) res;
    }
}
