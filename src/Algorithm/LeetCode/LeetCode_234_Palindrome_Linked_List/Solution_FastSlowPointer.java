package Algorithm.LeetCode.LeetCode_234_Palindrome_Linked_List;

public class Solution_FastSlowPointer {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;

        // p1.length > p2.length

        while (p2 != null) {
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);

        return true;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution_FastSlowPointer solutionStack = new Solution_FastSlowPointer();

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
