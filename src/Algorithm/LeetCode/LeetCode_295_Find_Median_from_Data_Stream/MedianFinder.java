package Algorithm.LeetCode.LeetCode_295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

class MedianFinder {
    private PriorityQueue<Integer> l;
    private PriorityQueue<Integer> r;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        l = new PriorityQueue<>((a, b) -> b - a);
        r = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        int s1 = l.size();
        int s2 = r.size();

        if (s1 == s2) {
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.poll());
                r.add(num);
            }
        } else {
            if (l.peek() <= num) {
                r.add(num);
            } else {
                r.add(l.poll());
                l.add(num);
            }
        }
    }

    public double findMedian() {
        int s1 = l.size();
        int s2 = r.size();

        if (s1 == s2) {
            return (l.peek() + r.peek()) / 2.0;
        } else {
            return l.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
