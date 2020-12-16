package Algorithm.LeetCode.LeetCode_319_Bulb_Switcher;

class Solution {
    public int bulbSwitch(int n) {
        if (n <= 1) {
            return n;
        }

        int res = 1;

        while (true) {
            if (res * res > n) {
                break;
            }

            res++;
        }

        return res - 1;
    }
}
