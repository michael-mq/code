package Algorithm.LeetCode.LeetCode_234_Palindrome_Linked_List;

import java.util.Stack;

public class Solution_Stack {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            }

            head = head.next;
        }

        return true;
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
