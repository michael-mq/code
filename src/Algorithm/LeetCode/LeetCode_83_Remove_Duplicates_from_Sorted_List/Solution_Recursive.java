package Algorithm.LeetCode.LeetCode_83_Remove_Duplicates_from_Sorted_List;

class Solution_Recursive {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            return null;
        }

        head.next = deleteDuplicates(head.next);

        if (head.next.val == head.next.next.val) {
            return head.next.next;
        }

        return head.next;
    }
}