package Algorithm.LeetCode.LeetCode_12_Integer_to_Roman;

class Solution2 {
    public String intToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        int thousand = num / 1000;
        int hundred = num % 1000 / 100;
        int ten = num % 100 / 10;
        int one = num % 10;

        return thousands[thousand] +
                hundreds[hundred] +
                tens[ten] +
                ones[one];
    }
}