package Algorithm.LeetCode.LeetCode_729_My_Calendar_I;

import java.util.ArrayList;
import java.util.List;

class MyCalendar_BruteForce {
    private List<int[]> booked;

    public MyCalendar_BruteForce() {
        booked = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] b : booked) {
            if (startTime < b[1] && endTime > b[0]) {
                return false;
            }
        }

        booked.add(new int[]{startTime, endTime});

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */