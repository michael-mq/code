package Algorithm.LeetCode.LeetCode_19_Remove_Nth_Node_From_End_of_List;

import java.util.Stack;

class Solution_Stack {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();

        ListNode dummy = new ListNode(0, head);
        ListNode newHead = dummy;

        while (newHead != null) {
            stack.push(newHead);
            newHead = newHead.next;
        }

        ListNode temp = stack.peek();

        for (int i = 0; i <= n; i++) {
            temp = stack.pop();
        }

        temp.next = temp.next.next;

        return dummy.next;
    }
}
