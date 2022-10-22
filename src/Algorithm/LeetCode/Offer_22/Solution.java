package Algorithm.LeetCode.Offer_22;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (k == 1) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        for (int i = 0; i < k; i++) {
            first = first.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}