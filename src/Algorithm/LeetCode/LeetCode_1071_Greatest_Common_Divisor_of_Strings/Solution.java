package Algorithm.LeetCode.LeetCode_1071_Greatest_Common_Divisor_of_Strings;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        for (int i = Math.min(len1, len2); i > 0; i--) {
            if (len1 % i == 0 && len2 % i == 0) {
                String subStr = str1.substring(0, i);

                if (checkStr(str1, subStr) && checkStr(str2, subStr)) {
                    return subStr;
                }
            }
        }

        return "";

    }

    private boolean checkStr(String str, String subStr) {
        StringBuilder sb = new StringBuilder();

        int lenX = str.length() / subStr.length();

        for (int i = 0; i < lenX; i++) {
            sb.append(subStr);
        }

        return sb.toString().equals(str);
    }
}
