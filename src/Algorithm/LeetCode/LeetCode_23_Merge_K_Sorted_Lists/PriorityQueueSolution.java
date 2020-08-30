package Algorithm.LeetCode.LeetCode_23_Merge_K_Sorted_Lists;

/*
Input:
    [
        1->4->5,
        1->3->4,
        2->6
    ]
Output: 1->1->2->3->4->4->5->6
*/


import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        Queue<ListNode> pq = new PriorityQueue<>(lists.length, (ListNode a, ListNode b) -> (a.val - b.val));

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) pq.offer(lists[i]);
        }

        ListNode curr = new ListNode(0);
        ListNode foo = curr;

        while (!pq.isEmpty()) {
            ListNode tmp = pq.poll();
            curr.next = tmp;
            curr = tmp;

            if (tmp.next != null)
                pq.offer(tmp.next);
        }

        return foo.next;
    }

/*
    public static void main(String[] args) {
        PriorityQueueSolution foo = new PriorityQueueSolution();

    }
*/

}
