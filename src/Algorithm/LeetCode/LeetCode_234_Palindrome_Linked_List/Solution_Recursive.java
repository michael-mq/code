package Algorithm.LeetCode.LeetCode_234_Palindrome_Linked_List;

public class Solution_Recursive {
    private ListNode frontPointer;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;

        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }

            if (currentNode.val != frontPointer.val) {
                return false;
            }

            frontPointer = frontPointer.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution_Recursive solutionStack = new Solution_Recursive();

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
