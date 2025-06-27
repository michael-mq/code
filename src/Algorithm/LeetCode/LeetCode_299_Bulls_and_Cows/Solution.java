package Algorithm.LeetCode.LeetCode_299_Bulls_and_Cows;

class Solution {
    public String getHint(String secret, String guess) {
        int[] countS = new int[10];
        int[] countG = new int[10];

        int x = 0, y = 0;

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                x++;
            } else {
                countS[s - '0']++;
                countG[g - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            y += Math.min(countS[i], countG[i]);
        }

        return x + "A" + y + "B";
    }
}