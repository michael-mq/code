package Algorithm.LeetCode.LeetCode_138_Copy_List_with_Random_Pointer;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        //第一步，在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        Node p = head;

        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }

        //第二步，设置新节点的随机节点
        p = head;

        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }

            p = p.next.next;
        }

        //第三步，将两个链表分离
        Node cur = new Node(-1);
        Node dummy = cur;
        // Same as
        // Node dummy = new Node(-1);
        // Node cur = dummy;

        p = head;

        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }

        return dummy.next;
    }
}