package Algorithm.LeetCode.LeetCode_222_Count_Complete_Tree_Nodes;

// https://www.youtube.com/watch?v=dtLIe1rHYPg
class Solution_2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == right) {
            return countNodes(root.right) + (1 << left);
        }

        return countNodes(root.left) + (1 << right);
    }

    private int getHeight(TreeNode root) {
        int height = 0;

        while (root != null) {
            root = root.left;
            height++;
        }

        return height;
    }
}