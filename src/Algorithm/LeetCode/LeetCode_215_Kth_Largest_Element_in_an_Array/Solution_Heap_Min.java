package Algorithm.LeetCode.LeetCode_215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution_Heap_Min {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);

        for (int num : nums) {
            minHeap.add(num);
        }

        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
