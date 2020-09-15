package Algorithm.LeetCode.LeetCode_825_Friends_Of_Appropriate_Ages;

public class Solution {
    public int numFriendRequests(int[] ages) {
        if (ages == null || ages.length == 0) {
            return 0;
        }

        int[] count = new int[121];

        for(int i: ages) {
            count[i]++;
        }

        int res = 0;
        for (int a = 0; a < 121; a++) {
            for (int b = 0; b < 121; b++) {
                if (b <= 0.5 * a + 7) continue;
                if (b > a) continue;
                if(b > 100 && a < 100) continue;

                // a cannot request friend to itself
                res += count[a] * (count[b] - (a == b ? 1 : 0));
            }
        }

        return res;
    }
}
