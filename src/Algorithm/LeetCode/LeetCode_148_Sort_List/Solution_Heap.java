package Algorithm.LeetCode.LeetCode_148_Sort_List;

import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution_Heap {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        while (head != null) {
            queue.add(head);
            head = head.next;
        }

        ListNode dummy = new ListNode();
        ListNode node = queue.poll();
        dummy.next = node;

        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
        }

        node.next = null;

        return dummy.next;
    }
}
