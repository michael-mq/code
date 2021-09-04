package Algorithm.LeetCode.LeetCode_541_Reverse_String_II;

class Solution_MyOwn {
    public String reverseStr(String s, int k) {
        int i = 0;

        char[] chars = s.toCharArray();

        while (i < chars.length) {
            reverse(chars, i, Math.min(i + k, chars.length) - 1);
            i += 2 * k;
        }

        return new String(chars);

    }

    private void reverse(char[] chars, int start, int end) {
        int i = start, j = end;

        while (i <= j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
    }
}
