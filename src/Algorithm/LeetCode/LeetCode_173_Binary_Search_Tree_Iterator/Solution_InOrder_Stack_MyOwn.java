package Algorithm.LeetCode.LeetCode_173_Binary_Search_Tree_Iterator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_InOrder_Stack_MyOwn {
    Queue<TreeNode> queue;

    public Solution_InOrder_Stack_MyOwn(TreeNode root) {
        queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            queue.add(root);

            root = root.right;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return queue.poll().val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
