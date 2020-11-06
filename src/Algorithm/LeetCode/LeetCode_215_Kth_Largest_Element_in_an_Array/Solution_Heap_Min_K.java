package Algorithm.LeetCode.LeetCode_215_Kth_Largest_Element_in_an_Array;

import java.util.PriorityQueue;

public class Solution_Heap_Min_K {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < len; i++) {
            if (nums[i] > minHeap.peek())
            {
                minHeap.poll();
                minHeap.add(nums[i]);
            }

        }
        return minHeap.peek();
    }
}
