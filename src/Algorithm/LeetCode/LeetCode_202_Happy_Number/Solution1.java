package Algorithm.LeetCode.LeetCode_202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (!seen.contains(n)) {
            seen.add(n);
            n = getNext(n);

            if (n == 1) {
                return true;
            }
        }

        return false;

        // while (n != 1 && !seen.contains(n)) {
        //     seen.add(n);
        //     n = getNext(n);
        // }
        // return n == 1;
    }

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