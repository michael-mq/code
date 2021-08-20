package Algorithm.LeetCode.LeetCode_362_Design_Hit_Counter;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

class HitCounter {
    Deque<int[]> dq;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        dq = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        if (dq.peekLast() != null && dq.peekLast()[0] == timestamp) {
            dq.peekLast()[1]++;
        } else {
            dq.offerLast(new int[]{timestamp, 1});
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int res = 0;

        Iterator<int[]> it = dq.iterator();

        while (it.hasNext()) {
            int[] i = it.next();

            if (timestamp - i[0] < 300) {
                res += i[1];
            }
        }

        return res;
    }
}
