package Algorithm.LeetCode.LeetCode_6_Zigzag_Conversion;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows == s.length()) {
            return s;
        }

        StringBuilder[] arr = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        int row = 0, step = 1;

        for (char c : s.toCharArray()) {
            arr[row].append(c);
            row += step;

            if (row == 0) {
                step = 1;
            } else if (row == numRows - 1) {
                step = -1;
            }
        }

        StringBuilder result = new StringBuilder();

        for (StringBuilder sb : arr) {
            result.append(sb);
        }

        return result.toString();
    }
}