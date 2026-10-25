package Algorithm.LeetCode.LeetCode_7_Reverse_Integer;

import java.util.ArrayList;
import java.util.List;


// We can't use long because the description says:
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
class Solution_Not_Passing {
    public int reverse(int x) {
        if (x >= -9 && x <= 9) {
            return x;
        }

        List<Integer> list = new ArrayList<>();
        int sign = 1;
        long result = 0;

        if (x < 0) {
            sign = -1;
        }

        x = Math.abs(x);

        while (x > 0) {
            list.add(x % 10);
            x /= 10;
        }

        for (int n : list) {
            result = result * 10 + n;
        }

        result = sign == 1 ? result : -result;

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) result;
    }
}
