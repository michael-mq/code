package Algorithm.LeetCode.LeetCode_24_Swap_Nodes_In_Pairs;

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/dong-hua-yan-shi-24-liang-liang-jiao-huan-lian-bia/

public class Solution_Recursive_MyOwn {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);

        dummy.next = helper(head);

        return dummy.next;
    }

    private ListNode helper(ListNode prev) {
        if (prev == null || prev.next == null) {
            return prev;
        }

        ListNode curr = prev.next;
        ListNode next = prev.next.next;

        curr.next = prev;
        prev.next = helper(next);

        return curr;
    }

    public static void main(String[] args) {
        Solution_Recursive_MyOwn solution_Recursive = new Solution_Recursive_MyOwn();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = solution_Recursive.swapPairs(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        result = solution_Recursive.swapPairs(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
