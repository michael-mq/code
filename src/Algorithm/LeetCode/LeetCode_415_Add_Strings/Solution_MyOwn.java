package Algorithm.LeetCode.LeetCode_415_Add_Strings;

public class Solution_MyOwn {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if (len1 == 0) {
            return num1;
        }

        if (len2 == 0) {
            return num2;
        }

        int extra = 0;

        StringBuilder res = new StringBuilder();

        while (len1 > 0 || len2 > 0 || extra > 0) {
            int n1 = len1 > 0 ? num1.charAt(len1 - 1) - '0' : 0;
            int n2 = len2 > 0 ? num2.charAt(len2 - 1) - '0' : 0;

            int sum = n1 + n2 + extra;
            String sumStr = String.valueOf(n1 + n2 + extra);

            if (sum < 10) {
                res.insert(0, String.valueOf(sumStr.charAt(0)));
                extra = 0;
            } else {
                res.insert(0, String.valueOf(sumStr.charAt(1)));
                extra = 1;
            }

            len1--;
            len2--;
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Solution_MyOwn foo = new Solution_MyOwn();

        System.out.println(foo.addStrings("0", "0"));
        System.out.println(foo.addStrings("1", "9"));
    }
}
