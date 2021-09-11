package Algorithm.LeetCode.LeetCode_160_Intersection_of_Two_Linked_Lists;

import java.util.HashSet;
import java.util.Set;

public class Solution_HashSet {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        ListNode pA = headA;

        while (pA != null) {
            set.add(pA);
            pA = pA.next;
        }

        ListNode pB = headB;

        while (!set.contains(pB) && pB != null) {
            pB = pB.next;
        }

        return pB;
    }
}
