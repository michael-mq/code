package Algorithm.LeetCode.LeetCode_242_Valid_Anagram;

public class Solution_2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] table = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            table[index]++;
        }

        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            table[index]--;

            // if any character's occurrence is less than 0
            // it means this character is either not existing in `s`
            // or appeared more than the occurrence in `s`
            if (table[index] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_2 foo = new Solution_2();

        System.out.println(foo.isAnagram("anagram", "nagaram"));
        System.out.println(foo.isAnagram("rat", "car"));
    }
}
