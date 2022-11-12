package Algorithm.LeetCode.LeetCode_202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        }

        int slowRunner = n;
        int fastRunner = getNext(n);

        while (fastRunner != slowRunner) {
            slowRunner = getNext(slowRunner);
            fastRunner = getNext(getNext(fastRunner));

            if (fastRunner == 1) {
                return true;
            }
        }

        return false;
    }

    // public boolean isHappy(int n) {
    //     int slowRunner = n;
    //     int fastRunner = getNext(n);
    //     while (fastRunner != 1 && slowRunner != fastRunner) {
    //         slowRunner = getNext(slowRunner);
    //         fastRunner = getNext(getNext(fastRunner));
    //     }
    //     return fastRunner == 1;
    // }

    private int getNext(int n) {
        int total = 0;

        while (n > 0) {
            int d = n % 10;
            total += d * d;
            n = n / 10;
        }

        return total;
    }
}