package Algorithm.LeetCode.LeetCode_670_Maximum_Swap;

public class Solution {
    public int maximumSwap(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        int[] lastIndex = new int[10];

        for (int i = 0; i < numChars.length; i++) {
            lastIndex[numChars[i] - '0'] = i;
        }

        for (int i = 0; i < numChars.length; i++) {
            for (int j = 9; j > numChars[i] - '0'; j--) {
                if (lastIndex[j] > i) {
                    swap(numChars, lastIndex[j], i);
                    return Integer.valueOf(String.valueOf(numChars));
                }
            }
        }

        return num;
    }

    private void swap(char[] numChars, int i, int j) {
        char temp = numChars[i];
        numChars[i] = numChars[j];
        numChars[j] = temp;
    }
}
