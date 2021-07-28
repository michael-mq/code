package Algorithm.LeetCode.LeetCode_234_Palindrome_Linked_List;

public class Solution_Recursion2 {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;

        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }

        boolean res = traverse(right.next);

        // 后序遍历代码
        res = res & (left.val == right.val);
        left = left.next;

        return res;

    }


    public static void main(String[] args) {
        Solution_Recursion2 solutionStack = new Solution_Recursion2();

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
