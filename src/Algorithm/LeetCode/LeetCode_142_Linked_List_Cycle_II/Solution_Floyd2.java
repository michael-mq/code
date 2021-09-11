package Algorithm.LeetCode.LeetCode_142_Linked_List_Cycle_II;

// https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/

public class Solution_Floyd2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution_Floyd2 foo = new Solution_Floyd2();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(foo.detectCycle(head));

        ListNode head4 = new ListNode(-4);
        ListNode head3 = new ListNode(0);
        ListNode head2 = new ListNode(2);
        ListNode head1 = new ListNode(3, head2);
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;

        System.out.println(foo.detectCycle(head1));
    }
}
