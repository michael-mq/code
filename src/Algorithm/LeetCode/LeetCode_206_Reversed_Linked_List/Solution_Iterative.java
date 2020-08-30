package Algorithm.LeetCode.LeetCode_206_Reversed_Linked_List;
// 输入: 1->2->3->4->5->NULL
// 输出: 5->4->3->2->1->NULL
// https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/

public class Solution_Iterative {
    public ListNode reverseList(ListNode head) {
        ListNode curr = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = curr;
            curr = head;
            head = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        Solution_Iterative solution_iterative = new Solution_Iterative();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result =solution_iterative.reverseList(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
