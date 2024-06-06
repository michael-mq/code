package Algorithm.LeetCode.LeetCode_1825_Finding_MK_Average;

import java.util.LinkedList;
import java.util.PriorityQueue;

class MKAverage_BF_MyOwn {
    private final LinkedList<Integer> stream;
    private final int m;
    private final int k;

    public MKAverage_BF_MyOwn(int m, int k) {
        this.m = m;
        this.k = k;
        stream = new LinkedList<>();
    }

    public void addElement(int num) {
        stream.addLast(num);
    }

    public int calculateMKAverage() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        if (stream.size() < m) {
            return -1;
        }

        for (int i = stream.size() - 1; i >= stream.size() - m; i--) {
            pq.add(stream.get(i));
        }

        for (int i = 0; i < k; i++) {
            pq.poll();
        }

        int n = pq.size() - k;

        int res = 0;

        for (int i = 0; i < n; i++) {
            res += pq.poll();
        }

        return (int) (Math.floor((double) res / n));
    }
}