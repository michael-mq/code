package Algorithm.LeetCode.LeetCode_7_Reverse_Integer;

// MAX_VALUE = 2,147,483,647, MIN_VALUE = -2,147,483,648
class Solution {
    public int reverse(int x) {
        if (x == 0) {
            return x;
        }

        int ans = 0;

        while (x != 0) {
            int d = x % 10;

            if (ans > 214748364 || ans == 214748364 && d > 7) {
                return 0;
            }

            if (ans < -214748364 || ans == -214748364 && d < -8) {
                return 0;
            }

            ans = ans * 10 + d;

            x = x / 10;
        }

        return ans;
    }
}