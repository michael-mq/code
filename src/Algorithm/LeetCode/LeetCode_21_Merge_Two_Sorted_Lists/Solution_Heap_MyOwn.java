package Algorithm.LeetCode.LeetCode_21_Merge_Two_Sorted_Lists;

import java.util.PriorityQueue;
import java.util.Queue;

class Solution_Heap_MyOwn {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));

        while (list1 != null) {
            minHeap.offer(list1);
            list1 = list1.next;
        }

        while (list2 != null) {
            minHeap.offer(list2);
            list2 = list2.next;
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (!minHeap.isEmpty()) {
            ListNode n = minHeap.poll();
            // important, clear the cycle
            n.next = null;

            head.next = n;
            head = n;
        }

        return dummy.next;
    }
}