package Algorithm.LeetCode.LeetCode_142_Linked_List_Cycle_II;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head)) {
                return head;
            }

            nodeSet.add(head);
            head = head.next;
        }

        return null;
    }

    public static void main(String[] args) {
        Solution_HashSet foo = new Solution_HashSet();

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
