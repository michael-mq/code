
package Algorithm.LeetCode.LeetCode_731_My_Calendar_II;

import java.util.Map;
import java.util.TreeMap;

//https://leetcode.cn/problems/my-calendar-ii/solutions/1092727/yi-fa-jie-nti-by-laughhhh-pll7/comments/1451845/
class MyCalendarTwo_LineSweep {
    Map<Integer, Integer> bookingCount;
    int maxOverlappedBooking;

    public MyCalendarTwo_LineSweep() {
        bookingCount = new TreeMap<>();
        maxOverlappedBooking = 2;
    }

    public boolean book(int startTime, int endTime) {
        bookingCount.put(startTime, bookingCount.getOrDefault(startTime, 0) + 1);
        bookingCount.put(endTime, bookingCount.getOrDefault(endTime, 0) - 1);

        int overlappedBooking = 0;

        for (Map.Entry<Integer, Integer> entry : bookingCount.entrySet()) {
            overlappedBooking += entry.getValue();

            if (overlappedBooking > maxOverlappedBooking) {
                bookingCount.put(startTime, bookingCount.get(startTime) - 1);
                bookingCount.put(endTime, bookingCount.get(endTime) + 1);

                if (bookingCount.get(startTime) == 0) {
                    bookingCount.remove(startTime);
                }

                if (bookingCount.get(endTime) == 0) {
                    bookingCount.remove(endTime);
                }

                return false;
            }
        }

        return true;
    }
}