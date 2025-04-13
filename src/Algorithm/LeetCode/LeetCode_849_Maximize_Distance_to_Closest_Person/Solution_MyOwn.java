package Algorithm.LeetCode.LeetCode_849_Maximize_Distance_to_Closest_Person;

import java.util.ArrayList;
import java.util.List;

class Solution_MyOwn {
    public int maxDistToClosest(int[] seats) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                list.add(i);
            }
        }

        int dist = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            dist = Math.max(dist, (list.get(i) - list.get(i - 1)) / 2);
        }

        dist = Math.max(dist, seats.length - list.get(list.size() - 1) - 1);

        return dist;
    }
}