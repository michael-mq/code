package Algorithm.LeetCode.LeetCode_173_Binary_Search_Tree_Iterator;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_InOrder_MyOwn {
    Queue<TreeNode> queue;

    public Solution_InOrder_MyOwn(TreeNode root) {
         queue = new LinkedList<>();

         helper(root);
    }

    void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        queue.add(root);
        helper(root.right);
    }

    /** @return the next smallest number */
    public int next() {
            return queue.poll().val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
