package Algorithm.LeetCode.LeetCode_141_Linked_List_Cycle;

public class Solution_TwoPointers {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_TwoPointers foo = new Solution_TwoPointers();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(foo.hasCycle(head));

        ListNode head4 = new ListNode(-4);
        ListNode head3 = new ListNode(0);
        ListNode head2 = new ListNode(2);
        ListNode head1 = new ListNode(3, head2);
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;

        System.out.println(foo.hasCycle(head1));
    }
}
