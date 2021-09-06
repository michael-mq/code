package Algorithm.LeetCode.LeetCode_225_Implement_Stack_Using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack3 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack3() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q1.isEmpty()) {
            q2.add(x);
        } else {
            q1.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (q1.isEmpty()) {
            int size = q2.size();

            for (int i = 0; i < size - 1; i++) {
                q1.add(q2.poll());
            }

            return q2.poll();
        } else {
            int size = q1.size();

            for (int i = 0; i < size - 1; i++) {
                q2.add(q1.poll());
            }

            return q1.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        int res;

        if (q1.isEmpty()) {
            int size = q2.size();

            for (int i = 0; i < size - 1; i++) {
                System.out.print(q2.peek());
                q1.add(q2.poll());
            }

            res = q2.poll();
            q1.add(res);
        } else {
            int size = q1.size();

            for (int i = 0; i < size - 1; i++) {
                q2.add(q1.poll());
            }

            res = q1.poll();
            q2.add(res);
        }

        return res;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
