package Algorithm.LeetCode.LeetCode_148_Sort_List;

public class Solution_MergeSort_Recursion {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);

        ListNode dummy = new ListNode();
        ListNode pointer = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                pointer.next = left;
                left = left.next;
            } else {
                pointer.next = right;
                right = right.next;
            }

            pointer = pointer.next;
        }

        pointer.next = left == null ? right : left;

        return dummy.next;
    }
}
