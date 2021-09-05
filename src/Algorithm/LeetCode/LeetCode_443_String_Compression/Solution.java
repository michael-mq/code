package Algorithm.LeetCode.LeetCode_443_String_Compression;

class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i = 0;
        int j = 0;

        while (j < chars.length) {
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }

            chars[index++] = chars[i];

            if (j - i > 1) {
                String temp = j - i + "";
                for (char c : temp.toCharArray()) {
                    chars[index++] = c;
                }
            }

            i = j;
        }

        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }
}
