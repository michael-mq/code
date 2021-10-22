package Algorithm.LeetCode.LeetCode_38_Count_and_Say;

class Solution {
    public String countAndSay(int n) {
        String result = "1";

        if (n == 1) {
            return result;
        }

        for (int i = 1; i < n; i++) {
            result = helper(result);
        }

        return result;
    }

    private String helper(String number) {
        StringBuilder s = new StringBuilder();
        int len = number.length();

        int count = 1;

        for (int i = 0; i < len; i++) {
            if (i < len - 1 && number.charAt(i) == number.charAt(i + 1)) {
                count++;
            } else {
                s.append(count);
                s.append(number.charAt(i));
                count = 1;
            }
        }

        return s.toString();
    }
}
