package Algorithm.LeetCode.LeetCode_242_Valid_Anagram;

public class Solution_3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_3 foo = new Solution_3();

        System.out.println(foo.isAnagram("anagram", "nagaram"));
        System.out.println(foo.isAnagram("rat", "car"));
    }
}
