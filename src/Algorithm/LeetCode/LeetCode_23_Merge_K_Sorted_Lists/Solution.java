package Algorithm.LeetCode.LeetCode_23_Merge_K_Sorted_Lists;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/editorial/#approach-2-compare-one-by-one
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode point = head;
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(
//                new Comparator<ListNode>() {
//                    @Override
//                    public int compare(ListNode o1, ListNode o2) {
//                        if (o1.val > o2.val) {
//                            return 1;
//                        } else if (o1.val == o2.val) {
//                            return 0;
//                        } else {
//                            return -1;
//                        }
//                    }
//                }
//        );

        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                Comparator.comparingInt(o -> o.val)
        );


        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            point.next = queue.poll();
            point = point.next;
            if (point.next != null) {
                queue.add(point.next);
            }
        }
        return head.next;
    }
}