package Algorithm.LeetCode.LeetCode_295_Find_Median_from_Data_Stream;

import java.util.PriorityQueue;

// https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247487197&idx=1&sn=0cb587fda164bda7fbcaa54cb9630fde&scene=21#wechat_redirect

class MedianFinder {
    private PriorityQueue<Integer> large;
    private PriorityQueue<Integer> small;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        small = new PriorityQueue<>((a, b) -> b - a);
        large = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (small.size() >= large.size()) {
            small.offer(num);
            large.offer(small.poll());
        } else {
            large.offer(num);
            small.offer(large.poll());
        }
    }

    public double findMedian() {
        if (small.size() > large.size()) {
            return small.peek();
        } else if (small.size() < large.size()) {
            return large.peek();
        }

        return (small.peek() + large.peek()) / 2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
