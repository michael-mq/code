package Algorithm.LeetCode.LeetCode_203_Remove_Linked_List_Elements;


class Solution_Recursive {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }
}