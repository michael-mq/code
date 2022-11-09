package Algorithm.LeetCode.LeetCode_383_Ransom_Note;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];

        for (char m : magazine.toCharArray()) {
            int index = m - 'a';
            letters[index]++;
        }

        for (char r : ransomNote.toCharArray()) {
            int index = r - 'a';
            letters[index]--;

            if (letters[index] < 0) {
                return false;
            }
        }

        return true;
    }
}