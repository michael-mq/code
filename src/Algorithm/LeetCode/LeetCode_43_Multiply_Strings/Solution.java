package Algorithm.LeetCode.LeetCode_43_Multiply_Strings;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];

        for (int i = len1 - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';

            for (int j = len2 - 1; j >= 0 ; j--) {
                int n2 = num2.charAt(j) - '0';

                int pos1 = i + j;
                int pos2 = i + j + 1;

                int sum = n1 * n2 + res[pos1] * 10 + res[pos2];
                res[pos1] = sum / 10;
                res[pos2] = sum % 10;

//                int sum = n1 * n2 + res[pos2];
//                res[pos2] = sum % 10;
//                res[pos1] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }

            result.append(res[i]);
        }

        return result.toString();
    }
}
