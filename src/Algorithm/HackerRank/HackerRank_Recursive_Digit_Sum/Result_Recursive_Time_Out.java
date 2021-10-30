package Algorithm.HackerRank.HackerRank_Recursive_Digit_Sum;

class Result_Recursive_Time_Out {

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
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < k; i++) {
            sb.append(n);
        }

        return helper(sb.toString());
    }

    private static int helper(String n) {
        if (n.length() == 1) {
            return (int) Long.parseLong(n);
        }

        long sum = 0;

        for (char c : n.toCharArray()) {
            sum += c - '0';
        }

        return helper(Long.toString(sum));
    }

}
