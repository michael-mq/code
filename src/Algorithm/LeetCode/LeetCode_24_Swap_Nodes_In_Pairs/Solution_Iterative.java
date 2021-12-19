package Algorithm.LeetCode.LeetCode_24_Swap_Nodes_In_Pairs;

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/liang-liang-jiao-huan-lian-biao-zhong-de-jie-di-19/
// https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/bi-jiao-zhi-jie-gao-xiao-de-zuo-fa-han-tu-jie-by-w/
// diagram in folder

public class Solution_Iterative {
    public ListNode swapPairs(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        // head != null is for even nodes
        // head.next != null is for odd nodes
        while (head != null && head.next != null) {
            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode; // At first loop, this is for dummy to point to secondNode and stay as it is
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution_Iterative Solution_Recursive = new Solution_Iterative();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode result = Solution_Recursive.swapPairs(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

        head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        result = Solution_Recursive.swapPairs(head);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
