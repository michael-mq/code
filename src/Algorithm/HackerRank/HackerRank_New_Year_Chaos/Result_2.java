package Algorithm.HackerRank.HackerRank_New_Year_Chaos;

import java.util.List;

class Result_2 {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // https://josephjsf2.github.io/hackerrank/2020/01/04/new-year-chaos.html

        int len = q.size();
        int result = 0;

        for (int i = len - 1; i >= 0; i--) {
            if (q.get(i) < i + 1) {
                if (q.get(i - 1) == i + 1) {
                    swap(q, i - 1, i);
                    result++;
                } else if (q.get(i - 2) == i + 1) {
                    swap(q, i - 2, i - 1);
                    swap(q, i - 1, i);
                    result += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }

        System.out.println(result);

    }

    private static void swap(List<Integer> q, int i, int j) {
        int tmp = q.get(i);
        q.set(i, q.get(j));
        q.set(j, tmp);
    }

}
