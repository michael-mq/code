package Algorithm.LeetCode.LeetCode_731_My_Calendar_II;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo_BruteForce {
    private List<int[]> booked;
    private List<int[]> overlaps;

    public MyCalendarTwo_BruteForce() {
        booked = new ArrayList<>();
        overlaps = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] o : overlaps) {
            if (startTime < o[1] && endTime > o[0]) {
                return false;
            }
        }

        for (int[] b : booked) {
            if (startTime < b[1] && endTime > b[0]) {
                overlaps.add(new int[]{Math.max(startTime, b[0]), Math.min(endTime, b[1])});
            }
        }

        booked.add(new int[]{startTime, endTime});

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */