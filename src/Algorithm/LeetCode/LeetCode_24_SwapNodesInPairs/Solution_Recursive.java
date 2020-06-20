package Algorithm.LeetCode.LeetCode_24_SwapNodesInPairs;

// https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/dong-hua-yan-shi-24-liang-liang-jiao-huan-lian-bia/

public class Solution_Recursive {
    public ListNode swapPairs(ListNode head) {
        //递归的终止条件
        if(head==null || head.next==null) {
            return head;
        }
        //假设链表是 1->2->3->4
        //这句就先保存节点2
        ListNode tmp = head.next;
        //继续递归，处理节点3->4
        //当递归结束返回后，就变成了4->3
        //于是head节点就指向了4，变成1->4->3
        head.next = swapPairs(tmp.next);
        //将2节点指向1
        tmp.next = head;
        return tmp;
    }

    public static void main(String[] args) {
        Solution_Recursive solution_Recursive = new Solution_Recursive();

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
