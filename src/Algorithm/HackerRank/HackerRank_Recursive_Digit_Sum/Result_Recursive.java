package Algorithm.HackerRank.HackerRank_Recursive_Digit_Sum;

class Result_Recursive {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Write your code here
        if (n.length() == 1 && k == 1) {
            return (int) Long.parseLong(n);
        }

        long sum = 0;

        for (char c : n.toCharArray()) {
            sum += c - '0';
        }

        sum *= k;

        return superDigit(Long.toString(sum), 1);

    }

}
