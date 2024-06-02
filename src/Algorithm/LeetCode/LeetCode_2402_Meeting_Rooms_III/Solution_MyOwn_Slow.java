package Algorithm.LeetCode.LeetCode_2402_Meeting_Rooms_III;

import java.util.*;

class Solution_MyOwn_Slow {
    public int mostBooked(int n, int[][] meetings) {
        int res = -1;
        int max = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(meetings.length, (a, b) -> a[0] - b[0]);

        List<TreeMap<Long, Long>> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            rooms.add(new TreeMap<>());
        }

        pq.addAll(Arrays.asList(meetings));

        while (!pq.isEmpty()) {
            int[] meeting = pq.poll();
            boolean arranged = false;

            for (TreeMap<Long, Long> room : rooms) {
                if (room.isEmpty()) { // If there is no meeting in the room
                    room.put((long) meeting[1], (long) meeting[0]);
                    arranged = true;
                    break;
                } else if (meeting[0] >= room.lastKey()) {
                    room.put((long) meeting[1], (long) meeting[0]);
                    arranged = true;
                    break;
                }
            }

            if (!arranged) { // If it can't find any empty room, or all the rooms already have meeting conflicting with the current meeting
                // check which room has earliest ending time
                long earlistEndingTime = Long.MAX_VALUE;
                int roomNo = 0;
                for (int i = 0; i < rooms.size(); i++) {
                    TreeMap<Long, Long> room = rooms.get(i);

                    if (earlistEndingTime > room.lastKey()) {
                        earlistEndingTime = room.lastKey();
                        roomNo = i;
                    }
                }

                long delay = earlistEndingTime - (long) meeting[0];

                long start = (long) meeting[0] + delay;
                long end = (long) meeting[1] + delay;

                rooms.get(roomNo).put(end, start);
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).size() > max) {
                max = rooms.get(i).size();
                res = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution_MyOwn_Slow solution = new Solution_MyOwn_Slow();

        int[][] meetings = new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}};

        System.out.println(solution.mostBooked(2, meetings));
    }
}