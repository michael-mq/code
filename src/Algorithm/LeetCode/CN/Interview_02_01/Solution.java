package Algorithm.LeetCode.CN.Interview_02_01;


import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


// https://leetcode.cn/problems/remove-duplicate-node-lcci/description/
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead = head;

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        while (head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                set.add(head.next.val);
                head = head.next;
            }
        }

        return dummyHead;

    }
}