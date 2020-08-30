package Algorithm.LeetCode.LeetCode_141_Linked_List_Cycle;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (head != null) {
            if (nodeSet.contains(head)) {
                return true;
            }

            nodeSet.add(head);
            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_HashSet foo = new Solution_HashSet();

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
