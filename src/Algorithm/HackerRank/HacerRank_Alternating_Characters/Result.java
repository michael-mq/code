package Algorithm.HackerRank.HacerRank_Alternating_Characters;

class Result {

    /*
     * Complete the 'alternatingCharacters' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int alternatingCharacters(String s) {
    // Write your code here
        char letter = s.charAt(0);
        int result = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                result++;
            } else {
                letter = s.charAt(i);
            }
        }

        return result;
    }

}
