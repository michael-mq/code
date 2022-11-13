package Algorithm.LeetCode.CN.Offer_22;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
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