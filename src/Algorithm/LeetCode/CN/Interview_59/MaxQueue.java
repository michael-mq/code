package Algorithm.LeetCode.CN.Interview_59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public MaxQueue() {
        this.queue = new LinkedList<>();
        this.deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }

        return deque.getFirst();
    }

    public void push_back(int value) {
        queue.add(value);

        while (!deque.isEmpty() && value > deque.getLast()) {
            deque.removeLast();
        }

        deque.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }

        int value = queue.poll();

        if (!deque.isEmpty() && value == deque.getFirst()) {
            deque.removeFirst();
        }

        return value;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */