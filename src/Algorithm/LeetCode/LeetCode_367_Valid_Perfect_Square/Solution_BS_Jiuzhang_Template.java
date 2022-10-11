package Algorithm.LeetCode.LeetCode_367_Valid_Perfect_Square;

class Solution_BS_Jiuzhang_Template {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }

        int start = 1, end = num;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            long square = (long) mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (start * start == num || end * end == num) {
            return true;
        }

        return false;
    }
}