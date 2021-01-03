package Algorithm.LeetCode.LeetCode_1094_Car_Pooling;

public class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] allTrip = new int[1001];

        for (int[] trip : trips) {
            int num = trip[0];
            int start = trip[1];
            int end = trip[2];

            for (int i = start; i < end; i++) {
                allTrip[i] += num;

                if (allTrip[i] > capacity) return false;
            }
        }

        return true;
    }
}
