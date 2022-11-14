package Algorithm.LeetCode.CN.Interview_01_02;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] table = new int[56];

        for (int i = 0; i < s1.length(); i++) {
            int index = s1.charAt(i) - 'a';
            table[index]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i) - 'a';
            table[index]--;

            if (table[index] < 0) {
                return false;
            }
        }

        return true;
    }
}