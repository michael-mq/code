package Algorithm.LeetCode.LeetCode_67_Add_Binary;

public class Solution_MyOwn {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int len = lenA;

        StringBuilder result = new StringBuilder();

        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                b = "0" + b;
            }
        } else if(lenA < lenB) {
            len = lenB;
            for (int i = 0; i < lenB - lenA; i++) {
                a = "0" + a;
            }
        }

        boolean next = false;
        for (int i = len - 1; i >=0 ; i--) {
            int ai = a.charAt(i) - '0';
            int bi = b.charAt(i) - '0';
            int ri = ai + bi;

            if (next) {
                ri += 1;
            }

            if (ri < 2) {
                result = result.insert(0, ri);
                next = false;
            } else if (ri == 2) {
                result = result.insert(0, 0);
                next = true;
            } else {
                result = result.insert(0, 1);
                next = true;
            }
        }

        if (next) {
            result = result.insert(0, 1);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution_MyOwn solutionMyOwn = new Solution_MyOwn();

        System.out.println(solutionMyOwn.addBinary("11", "1"));

        System.out.println(solutionMyOwn.addBinary("1010", "1011"));

        System.out.println(solutionMyOwn.addBinary("1111", "1111"));
    }
}
