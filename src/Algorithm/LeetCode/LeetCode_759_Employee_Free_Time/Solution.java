package Algorithm.LeetCode.LeetCode_759_Employee_Free_Time;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};

class Solution {
    private static final Comparator<Interval> cmp = new Comparator<Interval>() {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start == b.start ? a.end - b.end : a.start - b.start;
        }
    };

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> q = new PriorityQueue<>(cmp);

        for (List<Interval> intervals : schedule) {
            q.addAll(intervals);
        }

        List<Interval> res = new ArrayList<>();

        Interval pre = q.poll();
        int maxEnd = pre.end;

        while (!q.isEmpty()) {
            Interval cur = q.poll();

            if (maxEnd >= cur.start) {
                maxEnd = Math.max(maxEnd, cur.end);
            } else {
                res.add(new Interval(maxEnd, cur.start));
                maxEnd = cur.end;
            }
        }

        return res;
    }
}
