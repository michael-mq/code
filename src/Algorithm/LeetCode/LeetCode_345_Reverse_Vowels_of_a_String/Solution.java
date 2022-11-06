package Algorithm.LeetCode.LeetCode_345_Reverse_Vowels_of_a_String;

class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;

        char[] chars = s.toCharArray();

        while (i < j) {
            if (isVowel(chars[i]) && isVowel(chars[j])) {
                swap(chars, i, j);
                i++;
                j--;
            } else if (isVowel(chars[i]) && !isVowel(chars[j])) {
                j--;
            } else {
                i++;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
            c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}