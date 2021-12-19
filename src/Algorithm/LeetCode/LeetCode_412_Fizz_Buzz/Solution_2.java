package Algorithm.LeetCode.LeetCode_412_Fizz_Buzz;

import java.util.ArrayList;
import java.util.List;

class Solution_2 {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        int fCount = 0;
        int bCount = 0;
        int fbCount = 0;

        for (int i = 1; i <= n; i++) {
            fCount++;
            bCount++;
            fbCount++;

            if (fbCount == 15) {
                result.add("FizzBuzz");
                fbCount = 0;
                fCount = 0;
                bCount = 0;

                continue;
            }

            if (fCount == 3) {
                result.add("Fizz");
                fCount = 0;

                continue;
            }

            if (bCount == 5) {
                result.add("Buzz");
                bCount = 0;

                continue;
            }

            result.add(Integer.toString(i));
        }

        return result;
    }
}
