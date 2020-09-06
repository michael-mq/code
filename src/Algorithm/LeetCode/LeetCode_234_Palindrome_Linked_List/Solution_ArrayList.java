package Algorithm.LeetCode.LeetCode_234_Palindrome_Linked_List;

import java.util.Stack;

public class Solution_Stack {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<ListNode> stack = new Stack<>();

        stack.push(head);

        ListNode next = head.next;

        while (next != null) {
            int val = stack.peek().val;
            if (next.val != val) {
                stack.push(next);
            } else {
                stack.pop();
            }

            next = next.next;
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution_Stack solutionStack = new Solution_Stack();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(solutionStack.isPalindrome(head));

        head = new ListNode(1, new ListNode(2));
        System.out.println(solutionStack.isPalindrome(head));

        head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(solutionStack.isPalindrome(head));

        head = new ListNode(0, new ListNode(0));
        System.out.println(solutionStack.isPalindrome(head));

        head = new ListNode(1, new ListNode(0, new ListNode(1)));
        System.out.println(solutionStack.isPalindrome(head));

    }
}
