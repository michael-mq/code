package Algorithm.LeetCode.LeetCode_8.String_to_Integer;

public class Solution_1 {
    public int myAtoi(String s) {
        int len = s.length();

        if (len == 0) {
            return 0;
        }

        double val = 0;

        // Step 1
        int pointer = 0;

        while (pointer < len - 1 && s.charAt(pointer) == ' ') {
            pointer++;
        }

        // Step 2
        boolean isPositive = true;

        if (s.charAt(pointer) == '+' || s.charAt(pointer) == '-') {
            isPositive = s.charAt(pointer) == '+';
            pointer++;
        }

        // Step 3
        for (int i = pointer; i < len; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }

            val = val * 10 + (s.charAt(i) - '0');
        }

        // Step 4
        if (!isPositive) {
            val *= -1;
        }

        // Step 5

        if (val > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (val < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) val;
    }
}
