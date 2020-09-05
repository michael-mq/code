package Algorithm.LeetCode.LeetCode_160_Intersection_of_Two_Linked_Lists;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode lA = headA;
        ListNode lB = headB;

        while (lA != lB) {
            if (lA == null) {
                lA = headB;
            } else {
                lA = lA.next;
            }

            if (lB == null) {
                lB = headA;
            } else {
                lB = lB.next;
            }
        }

        return lA;
    }
}
