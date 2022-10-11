package Algorithm.LeetCode.LeetCode_69_Sqrt_x;

public class Solution_BS_Jiuzhang_Template {
    public int mySqrt(int x) {
        long start = 1, end = x;

        while (start + 1 < end) {
            long mid = start + (end - start) / 2;

            if (mid * mid == (long) x) {
                return (int) mid;
            } else if (mid * mid > (long) x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (start * start <= (long) x && end * end > (long) x) {
            return (int) start;
        }

        if (end * end <= (long) x) {
            return (int) end;
        }

        return x;
    }
}
