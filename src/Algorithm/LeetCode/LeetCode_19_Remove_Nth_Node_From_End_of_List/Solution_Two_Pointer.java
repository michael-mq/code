package Algorithm.LeetCode.LeetCode_19_Remove_Nth_Node_From_End_of_List;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/editorial
class Solution_Two_Pointer {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) { // remove the first element
            return head.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
