package Algorithm.LeetCode.LeetCode_849_Maximize_Distance_to_Closest_Person;

class Solution_MyOwn2 {
    public int maxDistToClosest(int[] seats) {
        int dist = 0;
        int prev = -1;
        int curr = 0;

        while (curr < seats.length) {
            if (seats[curr] == 1) {
                if (prev != -1) {
                    dist = Math.max(dist, (curr - prev) / 2);
                } else {
                    dist = curr;
                }

                prev = curr;
            }

            curr++;
        }

        dist = Math.max(dist, seats.length - prev - 1);

        return dist;
    }
}