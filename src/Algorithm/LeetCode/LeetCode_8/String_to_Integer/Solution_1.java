package Algorithm.LeetCode.LeetCode_8.String_to_Integer;

public class Solution_1 {
    public int myAtoi(String s) {
        // 1. 去除首尾空格
        s = s.trim();
        if (s.isEmpty()) return 0;

        int index = 0;
        int sign = 1;
        long res = 0; // 使用 long 方便处理中间溢出判断

        // 2. 处理符号
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        // 3. 转换数字
        while (index < s.length()) {
            char curr = s.charAt(index);

            // 遇到非数字字符立即停止
            if (curr < '0' || curr > '9') break;

            int digit = curr - '0';
            res = res * 10 + digit;

            // 4. 实时检查溢出
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            index++;
        }

        return (int) (res * sign);
    }
}
