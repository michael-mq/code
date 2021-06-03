package Algorithm.LeetCode.LeetCode_19_Remove_Nth_Node_From_End_of_List;

class Solution_My_Own {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode pointer = head;

        while(pointer != null) {
            len++;
            pointer = pointer.next;
        }

        int breakingPoint = len - n;

        if(breakingPoint == 0) {
            return head.next;
        }

        pointer = head;

        for (int i = 1; i < breakingPoint; i++) {
            pointer = pointer.next;
        }

        pointer.next = pointer.next.next;

        return head;
    }
}
