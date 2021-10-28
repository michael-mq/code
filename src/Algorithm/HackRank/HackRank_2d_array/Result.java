package Algorithm.HackRank.HackRank_2d_array;

import java.util.List;

class Result {

    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        // Write your code here
        int len = arr.size();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < len - 2; i++) {
            for (int j = 0; j < len - 2; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
                        + arr.get(i + 1).get(j + 1)
                        + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);

                max = Math.max(max, sum);
            }
        }

        return max;
    }

}
