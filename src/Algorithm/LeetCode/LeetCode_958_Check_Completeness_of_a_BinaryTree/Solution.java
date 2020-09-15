package Algorithm.LeetCode.LeetCode_958_Check_Completeness_of_a_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        // 层序遍历
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();  // LinkedList做队列的话支持添加null元素，而ArrayDeque不支持添加null
        queue.add(root);

        boolean flag = false;

        while (!queue.isEmpty()) {
            int curCount = queue.size();

            for (int i = 0; i < curCount; i++) {
                TreeNode curNode = queue.poll();

                if (curNode != null) {
                    if (flag) {
                        return false;
                    } // 如果在这之前出现过null节点，根据完全二叉树的性质，可以判断结果了

                    queue.add(curNode.left);
                    queue.add(curNode.right);
                } else { // 记录出现过null节点
                    flag = true;
                }
            }
        }

        return true;
    }
}
