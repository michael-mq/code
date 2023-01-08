package Algorithm.LeetCode.LeetCode_543_Diameter_of_Binary_Tree;

public class Solution_2 {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(myDiameter, maxDiameter);

        return Math.max(leftMax, rightMax) + 1;

    }
}