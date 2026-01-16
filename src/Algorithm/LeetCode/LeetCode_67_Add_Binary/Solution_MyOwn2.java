package Algorithm.LeetCode.LeetCode_67_Add_Binary;

public class Solution_MyOwn2 {
    public String addBinary(String a, String b) {
        int carry = 0;

        String ans = "";

        int i = a.length() - 1, j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int v = 0;
            int vA = 0;
            int vB = 0;

            if (i < 0) {
                vA = 0;
            } else {
                vA = a.charAt(i) - '0';
            }

            if (j < 0) {
                vB = 0;
            } else {
                vB = b.charAt(j) - '0';
            }

            v = vA + vB + carry;

            if (v >= 2) {
                carry = 1;
            } else {
                carry = 0;
            }

            ans = v % 2 + ans;

            i--;
            j--;
        }

        if (carry > 0) {
            ans = "1" + ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_MyOwn2 solutionMyOwn = new Solution_MyOwn2();

        System.out.println(solutionMyOwn.addBinary("11", "1"));

        System.out.println(solutionMyOwn.addBinary("1010", "1011"));

        System.out.println(solutionMyOwn.addBinary("1111", "1111"));
    }
}
