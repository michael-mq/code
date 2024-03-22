package Algorithm.LeetCode.LeetCode_222_Count_Complete_Tree_Nodes;

// https://www.programmercarl.com/0222.完全二叉树的节点个数.html
class Solution {
    /**
     * 针对完全二叉树的解法
     * <p>
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        TreeNode left = root.left;
        TreeNode right = root.right;

        int leftDepth = 1, rightDepth = 1; // 这里初始为0是有目的的，为了下面求指数方便

        while (left != null) {  // 求左子树深度
            left = left.left;
            leftDepth++;
        }

        while (right != null) { // 求右子树深度
            right = right.right;
            rightDepth++;
        }

        if (leftDepth == rightDepth) {
            return (int) Math.pow(2, leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}