package Algorithm.LeetCode.LeetCode_1825_Finding_MK_Average;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

// https://leetcode.cn/problems/finding-mk-average/solutions/2067300/by-lcbin-bonb
class MKAverage {
    private int m, k;
    private long sum;
    private int sizeLo, sizeHi;
    private Deque<Integer> q = new ArrayDeque<>();
    private TreeMap<Integer, Integer> lo = new TreeMap<>();
    private TreeMap<Integer, Integer> mid = new TreeMap<>();
    private TreeMap<Integer, Integer> hi = new TreeMap<>();

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (lo.isEmpty() || num <= lo.lastKey()) {
            lo.merge(num, 1, Integer::sum);
            sizeLo++;
        } else if (hi.isEmpty() || num >= hi.firstKey()) {
            hi.merge(num, 1, Integer::sum);
            sizeHi++;
        } else {
            mid.merge(num, 1, Integer::sum);
            sum += num;
        }

        q.offer(num);

        if (q.size() > m) {
            int x = q.poll();

            if (lo.containsKey(x)) {
                if (lo.merge(x, -1, Integer::sum) == 0) {
                    lo.remove(x);
                }
                sizeLo--;
            } else if (hi.containsKey(x)) {
                if (hi.merge(x, -1, Integer::sum) == 0) {
                    hi.remove(x);
                }
                sizeHi--;
            } else {
                if (mid.merge(x, -1, Integer::sum) == 0) {
                    mid.remove(x);
                }
                sum -= x;
            }
        }

        for (; sizeLo > k; sizeLo--) {
            int x = lo.lastKey();
            if (lo.merge(x, -1, Integer::sum) == 0) {
                lo.remove(x);
            }

            mid.merge(x, 1, Integer::sum);
            sum += x;
        }

        for (; sizeHi > k; sizeHi--) {
            int x = hi.firstKey();
            if (hi.merge(x, -1, Integer::sum) == 0) {
                hi.remove(x);
            }

            mid.merge(x, 1, Integer::sum);
            sum += x;
        }

        for (; sizeLo < k && !mid.isEmpty(); sizeLo++) {
            int x = mid.firstKey();
            if (mid.merge(x, -1, Integer::sum) == 0) {
                mid.remove(x);
            }
            sum -= x;
            lo.merge(x, 1, Integer::sum);
        }

        for (; sizeHi < k && !mid.isEmpty(); sizeHi++) {
            int x = mid.lastKey();
            if (mid.merge(x, -1, Integer::sum) == 0) {
                mid.remove(x);
            }
            sum -= x;
            hi.merge(x, 1, Integer::sum);
        }
    }

    public int calculateMKAverage() {
        if (q.size() < m) {
            return -1;
        }

        return (int) (sum / (q.size() - k * 2));
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */