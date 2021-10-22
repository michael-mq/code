package Algorithm.LeetCode.LeetCode_66_Plus_One;

class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + add;
            digits[i] = tmp % 10;
            add = tmp / 10;

            if (add == 0) {
                break;
            }
        }

        if (add == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(newDigits, 1, digits, 0, digits.length);

            return newDigits;
        }

        return digits;
    }
}
