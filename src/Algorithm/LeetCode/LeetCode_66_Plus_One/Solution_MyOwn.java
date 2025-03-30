package Algorithm.LeetCode.LeetCode_66_Plus_One;

class Solution_MyOwn {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        digits[n - 1] += 1;

        for (int i = n - 2; i >= 0; i--) {
            if (digits[i + 1] <= 9) {
                return digits;
            }

            int tmp = digits[i + 1];

            digits[i + 1] = tmp % 10;
            digits[i] += tmp / 10;
        }

        if (digits[0] <= 9) {
            return digits;
        }

        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        newDigits[1] = digits[0] % 10;

        for (int i = 2; i < n + 1; i++) {
            newDigits[i] = digits[i - 1];
        }

        return newDigits;
    }
}
