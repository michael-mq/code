package Algorithm.HackerRank.HackerRank_Left_Rotation;

import java.util.List;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        int len = a.size();

        swap(a, 0, len - 1);
        swap(a, 0, len - d - 1);
        swap(a, len - d, len - 1);

        return a;
    }

    private static void swap(List<Integer> a, int left, int right) {
        while (left < right) {
            int tmp = a.get(left);
            a.set(left, a.get(right));
            a.set(right, tmp);

            left++;
            right--;
        }
    }

}
