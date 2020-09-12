package Algorithm.LeetCode.LeetCode_703_Kth_Largest_Element_in_a_Stream;

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

import java.util.PriorityQueue;

public class KthLargest {
    final PriorityQueue<Integer> queue;
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k);
        for (int n : nums)
            add(n);
    }

    public int add(int n) {
        if (queue.size() < k)
            queue.add(n);
        else if (queue.peek() < n) {
            queue.poll();
            queue.add(n);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[]{4, 5, 8, 2};

        KthLargest kthLargest = new KthLargest(3, arr);

        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8

//        PriorityQueue<Integer> Miscs = new PriorityQueue<>(3);
//        System.out.println(Miscs.size());
    }
}




