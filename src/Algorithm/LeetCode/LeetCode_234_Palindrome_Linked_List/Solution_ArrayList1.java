package Algorithm.LeetCode.LeetCode_234_Palindrome_Linked_List;

import java.util.ArrayList;

public class Solution_ArrayList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ArrayList<Integer> array = new ArrayList<>();

        ListNode next = head;

        while (next != null) {
            array.add(next.val);
            next = next.next;
        }

        int first = 0;
        int last = array.size() - 1;

        while (first < last) {
            if (!array.get(first).equals(array.get(last))) {
                return false;
            }

            first++;
            last--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_ArrayList solutionStack = new Solution_ArrayList();

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
