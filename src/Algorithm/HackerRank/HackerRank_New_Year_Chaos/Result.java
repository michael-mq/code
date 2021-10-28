package Algorithm.HackerRank.HackerRank_New_Year_Chaos;

import java.util.List;

class Result {

    /*
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        // https://medium.com/@dwang0816/new-year-chaos-41e8e56cb342
        // https://josephjsf2.github.io/hackerrank/2020/01/04/new-year-chaos.html

        int len = q.size();
        int result = 0;

        for (int i = 0; i < len; i++) {
            if (q.get(i) - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q.get(i) - 2); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

}
