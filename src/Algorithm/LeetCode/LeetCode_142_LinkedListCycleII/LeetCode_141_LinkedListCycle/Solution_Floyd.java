package Algorithm.LeetCode.LeetCode_142_LinkedListCycleII.LeetCode_141_LinkedListCycle;

// https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/huan-xing-lian-biao-ii-by-leetcode/

public class Solution_Floyd {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution_Floyd foo = new Solution_Floyd();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(foo.detectCycle(head));

        ListNode head4 = new ListNode(-4);
        ListNode head3 = new ListNode(0);
        ListNode head2 = new ListNode(2);
        ListNode head1 = new ListNode(3, head2);
        head2.next = head3;
        head3.next = head4;
        head4.next = head2;

        System.out.println(foo.detectCycle(head1));
    }
}
